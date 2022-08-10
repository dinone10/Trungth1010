/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space_detail;

/**
 *
 * @author Admin
 */
public class SpaceDetailDTO {

    private String parkingDetailID;
    private String slotID;
    private String timeStart;
    private String timeEnd;
    private String vehicleID;
    private float price;
    private String floorID;

    public SpaceDetailDTO() {
    }

    public SpaceDetailDTO(float price) {
        this.price = price;
    }

    public SpaceDetailDTO(String parkingDetailID, String slotID, String timeStart, String timeEnd, float price, String floorID) {
        this.parkingDetailID = parkingDetailID;
        this.slotID = slotID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.price = price;
        this.floorID = floorID;
    }

    public SpaceDetailDTO(String parkingDetailID, String slotID, String timeStart, String timeEnd, String vehicleID) {
        this.parkingDetailID = parkingDetailID;
        this.slotID = slotID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.vehicleID = vehicleID;
    }

    public SpaceDetailDTO(String parkingDetailID, String slotID, String timeStart, String timeEnd, String vehicleID, float price) {
        this.parkingDetailID = parkingDetailID;
        this.slotID = slotID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.vehicleID = vehicleID;
        this.price = price;
    }

    public SpaceDetailDTO(String parkingDetailID, String slotID, String timeStart, String timeEnd, String vehicleID, float price, String floorID) {
        this.parkingDetailID = parkingDetailID;
        this.slotID = slotID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.vehicleID = vehicleID;
        this.price = price;
        this.floorID = floorID;
    }

    public SpaceDetailDTO(String slotID, float price, String floorID) {
        this.slotID = slotID;
        this.price = price;
        this.floorID = floorID;
    }

    public SpaceDetailDTO(String slotID, String timeStart, String timeEnd, float price, String floorID) {
        this.slotID = slotID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.price = price;
        this.floorID = floorID;
    }

    public String getFloorID() {
        return floorID;
    }

    public void setFloorID(String floorID) {
        this.floorID = floorID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getParkingDetailID() {
        return parkingDetailID;
    }

    public void setParkingDetailID(String parkingDetailID) {
        this.parkingDetailID = parkingDetailID;
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

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

}
