/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author penpen1112003
 */
public class Item {
    private int idItem;
    private String itemName;
    private int price;
    private int stock;
    private String image;
    private int category_id;
    private boolean Status;

    public Item() {
    }

    public Item(int idItem, String itemName, int price, int stock, String image, int category_id, boolean Status) {
        this.idItem = idItem;
        this.itemName = itemName;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.category_id = category_id;
        this.Status = Status;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    
   
    
}
