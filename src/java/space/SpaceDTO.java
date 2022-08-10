/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

/**
 *
 * @author Admin
 */
public class SpaceDTO {

    private String slotID;
    private String floorID;
    private String status;
    private String parkingDetailID;

    public SpaceDTO() {
    }

    public SpaceDTO(String slotID, String floorID, String status, String parkingDetailID) {
        this.slotID = slotID;
        this.floorID = floorID;
        this.status = status;
        this.parkingDetailID = parkingDetailID;
    }

    public SpaceDTO(String slotID, String floorID, String status) {
        this.slotID = slotID;
        this.floorID = floorID;
        this.status = status;
    }

    public SpaceDTO(String slotID, String floorID) {
        this.slotID = slotID;
        this.floorID = floorID;
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

    public String getFloorID() {
        return floorID;
    }

    public void setFloorID(String floorID) {
        this.floorID = floorID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
