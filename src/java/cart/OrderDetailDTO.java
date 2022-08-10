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
public class OrderDetailDTO {

    private int detailID;
    private float price;
    private String timeStart;
    private String timeEnd;
    private int orderID;
    private String slotID;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int detailID, float price, String timeStart, String timeEnd, int orderID, String slotID) {
        this.detailID = detailID;
        this.price = price;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.orderID = orderID;
        this.slotID = slotID;
    }

    public OrderDetailDTO(float price, String timeStart, String timeEnd, int orderID) {
        this.price = price;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.orderID = orderID;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

}
