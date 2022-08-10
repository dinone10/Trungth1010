/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

/**
 *
 * @author Admin
 */
public class AccountError {

    private String idAccountError;
    private String userNameError;
    private String passwordError;
    private String roleIDError;
    private String confirmError;
    private String emailError;

    public AccountError(String idAccountError, String userNameError, String passwordError, String roleIDError, String confirmError, String emailError) {
        this.idAccountError = idAccountError;
        this.userNameError = userNameError;
        this.passwordError = passwordError;
        this.roleIDError = roleIDError;
        this.confirmError = confirmError;
        this.emailError = emailError;
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

    public String getUserNameError() {
        return userNameError;
    }

    public void setUserNameError(String userNameError) {
        this.userNameError = userNameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public AccountError() {
        this.idAccountError ="";
        this.userNameError = "";
        this.passwordError = "";
        this.roleIDError = "";
        this.confirmError = "";
        this.emailError = "";
    }

    public AccountError(String idAccountError, String userNameError, String passwordError, String roleIDError, String confirmError) {
        this.idAccountError = idAccountError;
        this.userNameError = userNameError;
        this.passwordError = passwordError;
        this.roleIDError = roleIDError;
        this.confirmError = confirmError;
    }

}
