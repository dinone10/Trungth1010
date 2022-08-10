/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.products;

/**
 *
 * @author Admin
 */
public class ProductDTO {
   private String productID;
   private String productName;
   private String image;
   private float price;
   private int quantity;
   private String catagoryID;
   private String importDate;
   private String usingDate;
   private String status;
   private int quantityAvaiable;

    public ProductDTO() {
    }

    public ProductDTO(String productID, String productName, String image, float price, int quantity, String catagoryID, String importDate, String usingDate) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.catagoryID = catagoryID;
        this.importDate = importDate;
        this.usingDate = usingDate;
    }
    

    public ProductDTO(String productID, String productName, String image, float price, int quantity, String catagoryID, String importDate, String usingDate, String status) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.catagoryID = catagoryID;
        this.importDate = importDate;
        this.usingDate = usingDate;
        this.status = status;
    }
    public int getQuantityAvaiable() {
        return quantityAvaiable;
    }

    public void setQuantityAvaiable(int quantityAvaiable) {
        this.quantityAvaiable = quantityAvaiable;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCatagoryID() {
        return catagoryID;
    }

    public void setCatagoryID(String catagoryID) {
        this.catagoryID = catagoryID;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public String getUsingDate() {
        return usingDate;
    }

    public void setUsingDate(String usingDate) {
        this.usingDate = usingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "productID=" + productID + ", productName=" + productName + ", image=" + image + ", price=" + price + ", quantity=" + quantity + ", catagoryID=" + catagoryID + ", importDate=" + importDate + ", usingDate=" + usingDate + ", status=" + status + '}';
    }
   
   
    
}
