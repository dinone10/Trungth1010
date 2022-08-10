/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

/**
 *
 * @author Admin
 */
public class OrderDTO {

    private int orderID;
    private String orderDate;
    private float total;
    private String cusID;
    private String status;

    public OrderDTO() {
    }

    public OrderDTO(int orderID, String orderDate, float total, String cusID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.total = total;
        this.cusID = cusID;
    }

    public OrderDTO(int orderID, String orderDate, float total, String cusID, String status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.total = total;
        this.cusID = cusID;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

}
