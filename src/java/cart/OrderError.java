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
public class OrderError {

    private String timeStart;
    private String timeEnd;
    private String slotID;

    public OrderError(String timeStart, String timeEnd) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public OrderError(String timeStart, String timeEnd, String slotID) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.slotID = slotID;
    }

    public OrderError() {
        this.timeStart = "";
        this.timeEnd = "";
        this.slotID = "";
    }

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
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

}
