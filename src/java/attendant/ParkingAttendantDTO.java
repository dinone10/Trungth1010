
package attendant;


public class ParkingAttendantDTO {
    private String empID;
    private String empName;
    private String phone;
    private String email;
    private String idAccount;

    public ParkingAttendantDTO() {
        this.empID = "";
        this.empName = "";
        this.phone = "";
        this.email = "";
        this.idAccount = "";
    }

    public ParkingAttendantDTO(String empID, String empName, String phone, String email, String idAccount) {
        this.empID = empID;
        this.empName = empName;
        this.phone = phone;
        this.email = email;
        this.idAccount = idAccount;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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
