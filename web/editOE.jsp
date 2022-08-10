<%-- 
    Document   : test
    Created on : Jun 7, 2022, 10:38:09 PM
    Author     : Admin
--%>

<%@page import="officeEmployees.OfficeEmployeeError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Colorlib Templates">
        <meta name="author" content="Colorlib">
        <meta name="keywords" content="Colorlib Templates">

        <!-- Title Page-->
        <title>Au Register Forms by Colorlib</title>

        <!-- Icons font CSS-->
        <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
        <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <!-- Font special for pages-->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

        <!-- Vendor CSS-->
        <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

        <!-- Main CSS-->
        <link href="css/main.css" rel="stylesheet" media="all">
    </head>

    <body>
        <%
            OfficeEmployeeError oeError = (OfficeEmployeeError) request.getAttribute("OFFICE_EMPLOYEES_ERROR");
            if (oeError == null) {
                oeError = new OfficeEmployeeError();
            }
        %>
        <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
            <div class="wrapper wrapper--w790">
                <div class="card card-5">
                    <div class="card-heading">
                        <h2 class="title">PASystem - Update Office Employees</h2>
                    </div>
                    <div class="card-body">
                        <form action="MainController" method="POST">

                            <div class="form-row">
                                <div class="name">Office Employees ID</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="officeEmpID" readonly="" value="<%= request.getParameter("officeEmpID")%>"><%= oeError.getOfficeEmpIDError()%>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Office Employees Name</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="officeEmpName" value="<%= request.getParameter("officeEmpName")%>"><%= oeError.getOfficeEmpNameError()%>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Phone</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="phone" value="<%= request.getParameter("phone")%>"><%= oeError.getPhoneError()%>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Email</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="email" value="<%= request.getParameter("email")%>"><%= oeError.getEmailError()%>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">Account ID</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="idAccount" value="<%= request.getParameter("idAccount")%>"><%= oeError.getIdAccountError()%>
                                    </div>
                                </div>
                            </div>

                            <div class="btn-toolbar">
                                <div class="col-sm-8">
                                <button class="btn btn--radius-2 btn--red" type="submit" value="displayOE" name="action">Close</button>
                                </div>
                                <div class="col-sm-4">
                                <button class="btn btn--radius-2 btn--blue" type="submit" name="action" value="UpdateOE">Submit</button>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Jquery JS-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <!-- Vendor JS-->
        <script src="vendor/select2/select2.min.js"></script>
        <script src="vendor/datepicker/moment.min.js"></script>
        <script src="vendor/datepicker/daterangepicker.js"></script>

        <!-- Main JS-->
        <script src="js/global.js"></script>

    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->
