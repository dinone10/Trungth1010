/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers;

/**
 *
 * @author Admin
 */
public class CustomerDTO {
    private String cusID;
    private String cusName;
    private String phone;
    private String email;
    private String vehicleID;
    private String idAccount;

    public CustomerDTO() {
        this.cusID = "";
        this.cusName = "";
        this.phone = "";
        this.email = "";
        this.vehicleID = "";
        this.idAccount = "";
    }

    public CustomerDTO(String cusID, String cusName, String phone, String email, String vehicleID, String idAccount) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.phone = phone;
        this.email = email;
        this.vehicleID = vehicleID;
        this.idAccount = idAccount;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }
    
}
