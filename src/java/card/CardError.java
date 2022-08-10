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
public class CardError {

    private String longCardIDErorr;
    private String vehicleIDErorr;
    private String importIDErorr;
    private String expirationDateErorr;
    private String licensePlatesErorr;

    public CardError() {
        this.longCardIDErorr = "";
        this.vehicleIDErorr = "";
        this.importIDErorr = "";
        this.expirationDateErorr = "";
        this.licensePlatesErorr = "";
    }

    public CardError(String longCardIDErorr, String vehicleIDErorr, String importIDErorr, String expirationDateErorr, String licensePlatesErorr) {
        this.longCardIDErorr = longCardIDErorr;
        this.vehicleIDErorr = vehicleIDErorr;
        this.importIDErorr = importIDErorr;
        this.expirationDateErorr = expirationDateErorr;
        this.licensePlatesErorr = licensePlatesErorr;
    }

    public String getLongCardIDErorr() {
        return longCardIDErorr;
    }

    public void setLongCardIDErorr(String longCardIDErorr) {
        this.longCardIDErorr = longCardIDErorr;
    }

    public String getVehicleIDErorr() {
        return vehicleIDErorr;
    }

    public void setVehicleIDErorr(String vehicleIDErorr) {
        this.vehicleIDErorr = vehicleIDErorr;
    }

    public String getImportIDErorr() {
        return importIDErorr;
    }

    public void setImportIDErorr(String importIDErorr) {
        this.importIDErorr = importIDErorr;
    }

    public String getExpirationDateErorr() {
        return expirationDateErorr;
    }

    public void setExpirationDateErorr(String expirationDateErorr) {
        this.expirationDateErorr = expirationDateErorr;
    }

    public String getLicensePlatesErorr() {
        return licensePlatesErorr;
    }

    public void setLicensePlatesErorr(String licensePlatesErorr) {
        this.licensePlatesErorr = licensePlatesErorr;
    }

}
