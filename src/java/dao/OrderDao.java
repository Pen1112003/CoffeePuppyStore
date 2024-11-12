/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import lib.DBUtils;

/**
 *
 * @author penpen1112003
 */
public class OrderDao {

    public boolean submitOrders(ArrayList<Order> orders, int memberId, int tableNumber) {
        String insertSql = "INSERT INTO dbo.Orders (total_amount, table_number, member_id, guest_phone, product_id, quantity) VALUES (?, ?, ?, ?, ?, ?)";
        String checkProductSql = "SELECT COUNT(*) FROM dbo.Products WHERE product_id = ?";
        int[] result;

        try (Connection cn = DBUtils.makeConnection();
                PreparedStatement insertSt = cn.prepareStatement(insertSql);
                PreparedStatement checkSt = cn.prepareStatement(checkProductSql)) {

            cn.setAutoCommit(false); // Start transaction

            for (Order order : orders) {
                // Check if the product_id exists in Products table
                checkSt.setInt(1, order.getProduct_id());
                ResultSet rs = checkSt.executeQuery();
                rs.next();
                int productExists = rs.getInt(1);

                if (productExists == 0) {
                    System.err.println("Product ID " + order.getProduct_id() + " does not exist in Products table.");
                    continue; // Skip this order if the product_id is invalid
                }

                // If valid, add to batch
                insertSt.setInt(1, order.getTotal_amount());
                insertSt.setInt(2, tableNumber);
                insertSt.setInt(3, memberId);
                insertSt.setString(4, order.getMember_phone() != null ? order.getMember_phone() : order.getPhone());
                insertSt.setInt(5, order.getProduct_id());
                insertSt.setInt(6, order.getQuanlity());
                insertSt.addBatch(); // Add to batch
            }

            result = insertSt.executeBatch(); // Execute batch
            cn.commit(); // Commit transaction

        } catch (SQLException e) {
            System.err.println("SQL error during batch insert: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            return false;
        }

        return result.length == orders.size(); // Return true if all valid orders were inserted
    }

    public boolean updateOrderStatus(String orderId, String newStatus) {
        String updateQuery = "UPDATE [dbo].[Orders] SET [order_status] = ? WHERE [order_id] = ?";
        Connection connection = null; // Declare connection outside the try block
        PreparedStatement preparedStatement = null; // Declare prepared statement outside the try block

        try {
            connection = DBUtils.makeConnection(); // Open connection
            preparedStatement = connection.prepareStatement(updateQuery); // Prepare the statement

            // Set the new status and order ID
            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, Integer.parseInt(orderId));

            // Execute the update and check how many rows were affected
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Return true if the update was successful

        } catch (SQLException e) {
            System.err.println("SQL error while updating order status: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            // Close the prepared statement and connection in the finally block
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }

        return false; // Return false if there was an error or no rows were affected
    }

    public ArrayList<Order> getOrder() throws SQLException {
        ArrayList<Order> orderList = new ArrayList<>();

        String sql = "SELECT order_id, order_date, total_amount, order_status, table_number, guest_phone, product_id, quantity "
                + "FROM dbo.Orders WHERE order_status = 'Completed'";

        // Using try-with-resources to ensure that resources are closed properly
        try (Connection connection = DBUtils.makeConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderID(resultSet.getInt("order_id"));
                order.setOrderDate(resultSet.getTimestamp("order_date"));
                order.setTotal_amount(resultSet.getInt("total_amount"));
                order.setOrder_status(resultSet.getString("order_status"));
                order.setTable_number(resultSet.getInt("table_number"));
                order.setPhone(resultSet.getString("guest_phone"));
                order.setProduct_id(resultSet.getInt("product_id"));
                order.setQuanlity(resultSet.getInt("quantity"));
                orderList.add(order);
            }

        } catch (SQLException e) {
            // Log the exception instead of printing the stack trace
            System.err.println("SQL error while fetching orders: " + e.getMessage());
            throw e; // Rethrow the exception to handle it in the calling method if needed
        }

        return orderList;
    }

}
