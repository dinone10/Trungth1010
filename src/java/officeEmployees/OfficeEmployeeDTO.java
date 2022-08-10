
package officeEmployees;

import java.sql.Date;


public class OfficeEmployeeDTO {
    private String officeEmpID;
    private String officeEmpName;
    private String phone;
    private String email;
    private String idAccount;

    public OfficeEmployeeDTO() {
        this.officeEmpID = "";
        this.officeEmpName = "";
        this.phone = "";
        this.email = "";
        this.idAccount = "";
    }

    public OfficeEmployeeDTO(String officeEmpID, String officeEmpName, String phone, String email, String idAccount) {
        this.officeEmpID = officeEmpID;
        this.officeEmpName = officeEmpName;
        this.phone = phone;
        this.email = email;
        this.idAccount = idAccount;
    }

    public String getOfficeEmpID() {
        return officeEmpID;
    }

    public void setOfficeEmpID(String officeEmpID) {
        this.officeEmpID = officeEmpID;
    }

    public String getOfficeEmpName() {
        return officeEmpName;
    }

    public void setOfficeEmpName(String officeEmpName) {
        this.officeEmpName = officeEmpName;
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

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }


       
}
