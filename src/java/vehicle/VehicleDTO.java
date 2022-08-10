/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;

/**
 *
 * @author Admin
 */
public class VehicleDTO {

    private String vehicleID;
    private String cusID;
    private String vehicleType;
    private String licensePlates;

    public VehicleDTO() {
    }

    public VehicleDTO(String vehicleID, String cusID, String vehicleType, String licensePlates) {
        this.vehicleID = vehicleID;
        this.cusID = cusID;
        this.vehicleType = vehicleType;
        this.licensePlates = licensePlates;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

}
