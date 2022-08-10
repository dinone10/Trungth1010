
package officeEmployees;


public class OfficeEmployeeError {
    private String officeEmpIDError;
    private String officeEmpNameError;
    private String phoneError;
    private String emailError;
    private String idAccountError;

    public OfficeEmployeeError() {
        this.officeEmpIDError = "";
        this.officeEmpNameError = "";
        this.phoneError = "";
        this.emailError = "";
        this.idAccountError = "";
    }

    public OfficeEmployeeError(String officeEmpIDError, String officeEmpNameError, String phoneError, String emailError, String idAccountError) {
        this.officeEmpIDError = officeEmpIDError;
        this.officeEmpNameError = officeEmpNameError;
        this.phoneError = phoneError;
        this.emailError = emailError;
        this.idAccountError = idAccountError;
    }

    public String getOfficeEmpIDError() {
        return officeEmpIDError;
    }

    public void setOfficeEmpIDError(String officeEmpIDError) {
        this.officeEmpIDError = officeEmpIDError;
    }

    public String getOfficeEmpNameError() {
        return officeEmpNameError;
    }

    public void setOfficeEmpNameError(String officeEmpNameError) {
        this.officeEmpNameError = officeEmpNameError;
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
    
    
}
