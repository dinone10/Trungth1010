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
public class SpaceDetailError {

    private String parkingDetailIDError;
    private String slotIDError;
    private String timeStartError;
    private String timeEndError;
    private String vehicleIDError;

    public SpaceDetailError() {
        this.parkingDetailIDError = "";
        this.slotIDError = "";
        this.timeStartError = "";
        this.timeEndError = "";
        this.vehicleIDError = "";
    }

    public SpaceDetailError(String parkingDetailIDError, String slotIDError, String timeStartError, String timeEndError, String vehicleIDError) {
        this.parkingDetailIDError = parkingDetailIDError;
        this.slotIDError = slotIDError;
        this.timeStartError = timeStartError;
        this.timeEndError = timeEndError;
        this.vehicleIDError = vehicleIDError;
    }

    public String getParkingDetailIDError() {
        return parkingDetailIDError;
    }

    public void setParkingDetailIDError(String parkingDetailIDError) {
        this.parkingDetailIDError = parkingDetailIDError;
    }

    public String getSlotIDError() {
        return slotIDError;
    }

    public void setSlotIDError(String slotIDError) {
        this.slotIDError = slotIDError;
    }

    public String getTimeStartError() {
        return timeStartError;
    }

    public void setTimeStartError(String timeStartError) {
        this.timeStartError = timeStartError;
    }

    public String getTimeEndError() {
        return timeEndError;
    }

    public void setTimeEndError(String timeEndError) {
        this.timeEndError = timeEndError;
    }

    public String getVehicleIDError() {
        return vehicleIDError;
    }

    public void setVehicleIDError(String vehicleIDError) {
        this.vehicleIDError = vehicleIDError;
    }

}
