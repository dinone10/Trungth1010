
package attendant;


public class ParkingAttendantError {
    private String empIDError;
    private String empNameError;
    private String phoneError;
    private String emailError;
    private String idAccountError;
    private String messageError;

    public ParkingAttendantError() {
        this.empIDError = "";
        this.empNameError = "";
        this.phoneError = "";
        this.emailError = "";
        this.idAccountError = "";
        this.messageError = "";
    }

    public ParkingAttendantError(String empIDError, String empNameError, String phoneError, String emailError, String idAccountError) {
        this.empIDError = empIDError;
        this.empNameError = empNameError;
        this.phoneError = phoneError;
        this.emailError = emailError;
        this.idAccountError = idAccountError;
        this.messageError = messageError;
    }

    public String getEmpIDError() {
        return empIDError;
    }

    public void setEmpIDError(String empIDError) {
        this.empIDError = empIDError;
    }

    public String getEmpNameError() {
        return empNameError;
    }

    public void setEmpNameError(String empNameError) {
        this.empNameError = empNameError;
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

    public String getIdAccountError() {
        return idAccountError;
    }

    public void setIdAccountError(String idAccountError) {
        this.idAccountError = idAccountError;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }
    
    
}
