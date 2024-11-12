package dao;

import dto.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lib.DBUtils;

public class ItemDao {

    public ArrayList<Item> getAllItems() {
        ArrayList<Item> listItems = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtils.makeConnection();
            if (connection != null) {
                String sql = "SELECT [product_id], [product_name], [price], [stock], [image_url], [category_id], [is_active] FROM [dbo].[Products] WHERE is_active = 1";
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Item item = new Item();
                    item.setIdItem(resultSet.getInt("product_id"));
                    item.setItemName(resultSet.getString("product_name"));
                    item.setPrice(resultSet.getInt("price"));
                    item.setStock(resultSet.getInt("stock"));
                    item.setImage(resultSet.getString("image_url"));
                    item.setCategory_id(resultSet.getInt("category_id"));
                    item.setStatus(resultSet.getBoolean("is_active"));
                    listItems.add(item);
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
                e.printStackTrace(); // Keep basic closing handling
            }
        }

        return listItems;
    }

    public ArrayList<Item> getIDItems(int id) {
        ArrayList<Item> listItems = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtils.makeConnection();
            if (connection != null) {
                String sql = "SELECT [product_id], [product_name], [price], [stock], [category_id] FROM [dbo].[Products] WHERE product_id = ? and is_active = 1";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Item item = new Item();
                    item.setIdItem(resultSet.getInt("product_id"));
                    item.setItemName(resultSet.getString("product_name"));
                    item.setPrice(resultSet.getInt("price"));
                    item.setStock(resultSet.getInt("stock"));
                    item.setImage(resultSet.getString("image_url"));
                    item.setCategory_id(resultSet.getInt("category_id"));
                    item.setStatus(resultSet.getBoolean("is_active"));
                    listItems.add(item);
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

        return listItems;
    }

    public ArrayList<Item> getNameItem(String name) throws Exception {
        ArrayList<Item> listItems = new ArrayList<>();
        String sql = "SELECT [product_id], [product_name], [price], [stock], [image_url], [category_id], [is_active] "
                + "FROM [dbo].[Products] WHERE [product_name] LIKE ? AND [is_active] = 1";

        try (Connection connection = DBUtils.makeConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            if (connection != null) {
                preparedStatement.setString(1, "%" + name + "%");
                try (ResultSet resultSet = preparedStatement.executeQuery()) { 
                    while (resultSet.next()) {
                        Item item = new Item();
                        item.setIdItem(resultSet.getInt("product_id"));
                        item.setItemName(resultSet.getString("product_name"));
                        item.setPrice(resultSet.getInt("price"));
                        item.setStock(resultSet.getInt("stock"));
                        item.setImage(resultSet.getString("image_url"));
                        item.setCategory_id(resultSet.getInt("category_id"));
                        item.setStatus(resultSet.getBoolean("is_active"));
                        listItems.add(item);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the SQLException for debugging
        }

        return listItems;
    }

}
