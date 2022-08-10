<%-- 
    Document   : test
    Created on : Jun 7, 2022, 10:38:09 PM
    Author     : Admin
--%>

<%@page import="news.NewsError"%>
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
        <title>UPDATE NEWS</title>

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
            NewsError newsError = (NewsError) request.getAttribute("NEWS_ERROR");
            if (newsError == null) {
                newsError = new NewsError();
            }
        %>
        <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
            <div class="wrapper wrapper--w790">
                <div class="card card-5">
                    <div class="card-heading">
                        <h2 class="title">PASystem - Update News</h2>
                    </div>
                    <div class="card-body">
                        <form action="MainController" method="POST">

                            <div class="form-row">
                                <div class="name">ID NEWS</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="idNews" readonly="" value="<%= request.getParameter("idNews")%>"><%= newsError.getIdNewsError()%>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">NEWS INFORMATION</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="infoNews" value="<%= request.getParameter("infoNews")%>"><%= newsError.getInfoNewsError()%>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">IMAGE</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="image" value="<%= request.getParameter("image")%>"><%= newsError.getImageError()%>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">DATE SUBMITTED</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="dateSubmited" value="<%= request.getParameter("dateSubmited")%>"><%= newsError.getDateSubmitedError()%>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">ID OF EMP</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="officeEmpID" value="<%= request.getParameter("officeEmpID")%>"><%= newsError.getOfficeEmpIDError()%>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="name">TITLE</div>
                                <div class="value">
                                    <div class="input-group">
                                        <input class="input--style-5" type="text" name="title" value="<%= request.getParameter("title")%>"><%= newsError.getTitleError()%>
                                    </div>
                                </div>
                            </div>

                            <div>
                                <button class="btn btn--radius-2 btn--red" type="submit" value="ViewNews" name="action">Close</button>_____________________________________________<button class="btn btn--radius-2 btn--blue" type="submit" name="action" value="Update News">Submit</button>
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