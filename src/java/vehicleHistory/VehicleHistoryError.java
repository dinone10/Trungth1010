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
public class VehicleHistoryError {

    private String vehicleIDError;
    private String empIDError;
    private String timeCheckInError;
    private String timeCheckOutError;
    private String messageError;

    public String getMessageError() {
        return messageError;
    }

    public VehicleHistoryError(String vehicleIDError, String empIDError, String timeCheckInError) {
        this.vehicleIDError = vehicleIDError;
        this.empIDError = empIDError;
        this.timeCheckInError = timeCheckInError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public VehicleHistoryError(String vehicleIDError, String empIDError, String timeCheckInError, String timeCheckOutError, String messageError) {
        this.vehicleIDError = vehicleIDError;
        this.empIDError = empIDError;
        this.timeCheckInError = timeCheckInError;
        this.timeCheckOutError = timeCheckOutError;
        this.messageError = messageError;
    }

    public VehicleHistoryError() {
        this.vehicleIDError = "";
        this.empIDError = "";
        this.timeCheckInError = "";
        this.timeCheckOutError = "";
        this.messageError = "";
    }

    public VehicleHistoryError(String vehicleIDError, String empIDError, String timeCheckInError, String timeCheckOutError) {
        this.vehicleIDError = vehicleIDError;
        this.empIDError = empIDError;
        this.timeCheckInError = timeCheckInError;
        this.timeCheckOutError = timeCheckOutError;
    }

    public String getVehicleIDError() {
        return vehicleIDError;
    }

    public void setVehicleIDError(String vehicleIDError) {
        this.vehicleIDError = vehicleIDError;
    }

    public String getEmpIDError() {
        return empIDError;
    }

    public void setEmpIDError(String empIDError) {
        this.empIDError = empIDError;
    }

    public String getTimeCheckInError() {
        return timeCheckInError;
    }

    public void setTimeCheckInError(String timeCheckInError) {
        this.timeCheckInError = timeCheckInError;
    }

    public String getTimeCheckOutError() {
        return timeCheckOutError;
    }

    public void setTimeCheckOutError(String timeCheckOutError) {
        this.timeCheckOutError = timeCheckOutError;
    }

}
