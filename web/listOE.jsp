<%@page import="officeEmployees.OfficeEmployeeDTO"%>
<%@page import="java.util.List"%>
<%@page import="accounts.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Office Employees Page</title>
    </head>
    <body>
        <%
            AccountDTO loginAccount = (AccountDTO) session.getAttribute("LOGIN_ACCOUNT");
                if (loginAccount == null || !loginAccount.getRoleID().equals("OE")) {
                    response.sendRedirect("login.jsp");
                    return;
                }
                String search = request.getParameter("search");
                if (search == null) {
                    search = "";
                }
        %>
        Welcome Office Employees: <h1><%= loginAccount.getUserName()%></h1>
        
        <p> <%= request.getAttribute("SUCCESS_INFO") %> </p>
        <form action="MainController">
            Search<input type="text" name="search" value="<%= search%>"/>
            <input type="submit" name="action" value="SearchOfficeEmployee" />
        </form> </br>
        <form action="MainController" method="POST">           
            <input type="submit" name="action" value="Logout"/>
        </form> </br>
        <form action="MainController">           
            <input type="submit" name="action" value="Create"/>
        </form> 
        <%
            List<OfficeEmployeeDTO> listOfficeEmployee = (List<OfficeEmployeeDTO>) request.getAttribute("LIST_OFFICE_EMPLOYEE");
            if (listOfficeEmployee != null) {
                if (listOfficeEmployee.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>OE ID</th>
                    <th>OE Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Id Account</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (OfficeEmployeeDTO oe : listOfficeEmployee) {
                %>
            <form action="MainController">


                <tr>


                    <td><%= count++%></td>
                    <td>
                        <input type="text" name="empID" value="<%= oe.getOfficeEmpID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="empName" value="<%= oe.getOfficeEmpName()%>" />
                    </td>
                    <td>
                        <input type="number" name="phone" value="<%= oe.getPhone()%>" />

                    </td>
                    <td>
                        <input type="text" name="email" value="<%= oe.getEmail()%>" />

                    </td>
                    <td>
                        <input type="text" name="idAccount" value="<%= oe.getIdAccount()%>" readonly=""/>

                    </td> 
                    
                    <td>
                        <input type="submit" name="action" value="Delete"/>
                        <input type="hidden" name="search" value="<%= search%>"/>
                        <input type="hidden" name="userID" value="<%= oe.getOfficeEmpID()%>"/>

                    </td> 

                    <td>
                        <input type="submit" name="action" value="Update"/>
                        <input type="hidden" name="search" value="<%= search%>"
                        <input type="hidden" name="userID" value="<%= oe.getOfficeEmpID()%>"/>
                    </td>

                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>

    <%
        String error = (String) request.getAttribute("ERROR");
        if (error == null) {
            error = "";
        }
    %>
    <%= error%>
    <%
            }
        }
    %>
    </br>
</body>

</html>
        </form>
    </body>
</html>
