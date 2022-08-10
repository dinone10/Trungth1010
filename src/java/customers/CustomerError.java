
package customers;


public class CustomerError {
    private String cusIDError;
    private String cusNameError;
    private String phoneError;
    private String emailError;
    private String vehicleIDError;
    private String idAccountError;

    public CustomerError() {
        this.cusIDError = "";
        this.cusNameError = "";
        this.phoneError = "";
        this.emailError = "";
        this.vehicleIDError = "";
        this.idAccountError = "";
    }

    public CustomerError(String cusIDError, String cusNameError, String phoneError, String emailError, String vehicleIDError, String idAccountError) {
        this.cusIDError = cusIDError;
        this.cusNameError = cusNameError;
        this.phoneError = phoneError;
        this.emailError = emailError;
        this.vehicleIDError = vehicleIDError;
        this.idAccountError = idAccountError;
    }

    public String getCusIDError() {
        return cusIDError;
    }

    public void setCusIDError(String cusIDError) {
        this.cusIDError = cusIDError;
    }

    public String getCusNameError() {
        return cusNameError;
    }

    public void setCusNameError(String cusNameError) {
        this.cusNameError = cusNameError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getVehicleIDError() {
        return vehicleIDError;
    }

    public void setVehicleIDError(String vehicleIDError) {
        this.vehicleIDError = vehicleIDError;
    }

    public String getIdAccountError() {
        return idAccountError;
    }

    public void setIdAccountError(String idAccountError) {
        this.idAccountError = idAccountError;
    }
    
    
}
