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
public class AccountDTO {

    private String idAccount;
    private String userName;
    private String password;
    private String roleID;
    private String email;

    public AccountDTO(String idAccount, String userName, String password, String roleID, String email) {
        this.idAccount = idAccount;
        this.userName = userName;
        this.password = password;
        this.roleID = roleID;
        this.email = email;
    }

    public AccountDTO(String idAccount, String userName, String roleID) {
        this.idAccount = idAccount;
        this.userName = userName;
        this.roleID = roleID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public AccountDTO() {
        this.idAccount = "";
        this.userName = "";
        this.password = "";
        this.roleID = "";
    }

    public AccountDTO(String idAccount, String userName, String password, String roleID) {
        this.idAccount = idAccount;
        this.userName = userName;
        this.password = password;
        this.roleID = roleID;
    }

}
