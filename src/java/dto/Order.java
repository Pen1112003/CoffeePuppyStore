/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.Timestamp;


/**
 *
 * @author penpen1112003
 */
public class Order {
    private int orderID;
    private String productName;
    private int price;
    private int product_id;
    private int quanlity;
    private Timestamp orderDate;
    private int total_amount;
    private String order_status;
    private int table_number;
    private String phone;
    private String member_phone;
   
    public Order() {
    }

    public Order(int total_amount, String phone, String member_phone, int product_id,int quanlity, String productName, int price) {
        this.total_amount = total_amount;
        this.phone = phone;
        this.member_phone = member_phone;
        this.product_id = product_id;
        this.quanlity = quanlity;
        this.productName = productName;
        this.price = price;
    }
    
    public Order(int orderID, Timestamp orderDate, int total_amount, String order_status, int table_number, String phone, String member_phone) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.total_amount = total_amount;
        this.order_status = order_status;
        this.table_number = table_number;
        this.phone = phone;
        this.member_phone = member_phone;
    }
    
    public Order(Timestamp orderDate, int total_amount, String order_status, int table_number, String phone, String member_phone) {
        this.orderDate = orderDate;
        this.total_amount = total_amount;
        this.order_status = order_status;
        this.table_number = table_number;
        this.phone = phone;
        this.member_phone = member_phone;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public int getTable_number() {
        return table_number;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMember_phone() {
        return member_phone;
    }

    public void setMember_phone(String member_phone) {
        this.member_phone = member_phone;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
}
