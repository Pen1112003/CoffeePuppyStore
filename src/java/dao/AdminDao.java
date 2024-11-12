/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Admin;
import dto.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;
import lib.DBUtils;

/**
 *
 * @author penpen1112003
 */
public class AdminDao {

    public Admin loginAdmin(String email, String pass) throws SQLException {
        Admin admin = null;  // Initialize as null to indicate login failure by default
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = DBUtils.makeConnection();

        try {
            if (connection != null) {
                String sql = "SELECT admin_id, email, password, fullName, status "
                        + "FROM dbo.Admin "
                        + "WHERE email = ? AND password = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, pass);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {  // Use if since only one result is expected
                    admin = new Admin();  // Instantiate only if login is successful
                    admin.setAdmin_id(resultSet.getInt("admin_id"));
                    admin.setEmail(resultSet.getString("email"));
                    admin.setPass(resultSet.getString("password"));
                    admin.setFullName(resultSet.getString("fullName"));
                    admin.setStatus(resultSet.getBoolean("status"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return admin;
    }

    public ArrayList<Order> getOrder() throws SQLException {
        ArrayList<Order> orderList = new ArrayList<>();

        String sql = "SELECT order_id, order_date, total_amount, order_status, table_number, guest_phone, product_id, quantity "
                + "FROM dbo.Orders WHERE order_status = 'Pending'";

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
