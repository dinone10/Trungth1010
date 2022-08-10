/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card;

/**
 *
 * @author Admin
 */
public class CardDTO {

    private int longCardID;
    private String vehicleID;
    private String cusID;
    private String importDate;
    private String expirationDate;
    private String licensePlates;
    private String status;

    public CardDTO() {
    }

    public CardDTO(String vehicleID, String importDate, String expirationDate, String licensePlates, String status, String cusID) {
        this.vehicleID = vehicleID;
        this.importDate = importDate;
        this.expirationDate = expirationDate;
        this.licensePlates = licensePlates;
        this.status = status;
        this.cusID = cusID;
    }

    public CardDTO(int longCardID, String vehicleID, String importID, String expirationDate, String licensePlates) {
        this.longCardID = longCardID;
        this.vehicleID = vehicleID;
        this.importDate = importID;
        this.expirationDate = expirationDate;
        this.licensePlates = licensePlates;
    }

    public CardDTO(String vehicleID, String cusID, String importDate, String expirationDate, String licensePlates) {
        this.vehicleID = vehicleID;
        this.cusID = cusID;
        this.importDate = importDate;
        this.expirationDate = expirationDate;
        this.licensePlates = licensePlates;
    }

    public CardDTO(int longCardID, String vehicleID, String cusID, String importDate, String expirationDate, String licensePlates, String status) {
        this.longCardID = longCardID;
        this.vehicleID = vehicleID;
        this.cusID = cusID;
        this.importDate = importDate;
        this.expirationDate = expirationDate;
        this.licensePlates = licensePlates;
        this.status = status;
    }

    public CardDTO(String vehicleID, String importDate, String expirationDate, String licensePlates) {
        this.vehicleID = vehicleID;
        this.importDate = importDate;
        this.expirationDate = expirationDate;
        this.licensePlates = licensePlates;
    }

    public CardDTO(int longCardID, String expirationDate) {
        this.longCardID = longCardID;
        this.expirationDate = expirationDate;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLongCardID() {
        return longCardID;
    }

    public void setLongCardID(int longCardID) {
        this.longCardID = longCardID;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importID) {
        this.importDate = importID;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

}
