/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author penpen1112003
 */
public class OrderItem {
    private int orderItem_ID;
    private int orderID;
    private int productID;
    private int quanlity;
    private int price;

    public OrderItem() {
    }

    public OrderItem(int productID, int quanlity, int price) {
        this.productID = productID;
        this.quanlity = quanlity;
        this.price = price;
    }
    
    public OrderItem(int orderItem_ID, int orderID, int productID, int quanlity, int price) {
        this.orderItem_ID = orderItem_ID;
        this.orderID = orderID;
        this.productID = productID;
        this.quanlity = quanlity;
        this.price = price;
    }
    
    public OrderItem(int orderID, int productID, int quanlity, int price) {
        this.orderID = orderID;
        this.productID = productID;
        this.quanlity = quanlity;
        this.price = price;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrderItem_ID() {
        return orderItem_ID;
    }

    public void setOrderItem_ID(int orderItem_ID) {
        this.orderItem_ID = orderItem_ID;
    }
    
    
}
