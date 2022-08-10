/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicleHistory;

/**
 *
 * @author Admin
 */
public class VehicleHistoryDTO {

    private String vehicleID;
    private String empID;
    private String timeCheckIn;
    private String timeCheckOut;
    private String historyID;

    public VehicleHistoryDTO(String vehicleID, String empID) {
        this.vehicleID = vehicleID;
        this.empID = empID;
    }

    public VehicleHistoryDTO(String vehicleID, String empID, String timeCheckIn, String timeCheckOut, String historyID) {
        this.vehicleID = vehicleID;
        this.empID = empID;
        this.timeCheckIn = timeCheckIn;
        this.timeCheckOut = timeCheckOut;
        this.historyID = historyID;
    }

    public VehicleHistoryDTO(String vehicleID, String empID, String timeCheckIn) {
        this.vehicleID = vehicleID;
        this.empID = empID;
        this.timeCheckIn = timeCheckIn;
    }

    public VehicleHistoryDTO() {
    }

    public VehicleHistoryDTO(String historyID) {
        this.historyID = historyID;
    }

    public VehicleHistoryDTO(String vehicleID, String empID, String timeCheckIn, String timeCheckOut) {
        this.vehicleID = vehicleID;
        this.empID = empID;
        this.timeCheckIn = timeCheckIn;
        this.timeCheckOut = timeCheckOut;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getTimeCheckIn() {
        return timeCheckIn;
    }

    public void setTimeCheckIn(String timeCheckIn) {
        this.timeCheckIn = timeCheckIn;
    }

    public String getTimeCheckOut() {
        return timeCheckOut;
    }

    public void setTimeCheckOut(String timeCheckOut) {
        this.timeCheckOut = timeCheckOut;
    }

}
