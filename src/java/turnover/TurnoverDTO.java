/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnover;

/**
 *
 * @author Admin
 */
public class TurnoverDTO {

    private String detailID;
    private double price;
    private String timeStart;
    private String timeEnd;
    private String orderID;
    private String slotID;

    public String getDetailID() {
        return detailID;
    }

    public void setDetailID(String detailID) {
        this.detailID = detailID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public TurnoverDTO(String detailID, double price, String timeStart, String timeEnd, String orderID, String slotID) {
        this.detailID = detailID;
        this.price = price;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.orderID = orderID;
        this.slotID = slotID;
    }

    public TurnoverDTO() {
        this.detailID = "";
        this.price = 0;
        this.timeStart = "";
        this.timeEnd = "";
        this.orderID = "";
        this.slotID = "";
    }
}
