<%-- 
    Document   : newsAdmin
    Created on : Jun 7, 2022, 8:30:29 PM
    Author     : Admin
--%>

<%@page import="news.NewsDTO"%>
<%@page import="java.util.List"%>
<%@page import="accounts.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free Website Template" name="keywords">
        <meta content="Free Website Template" name="description">

        <!-- Favicon -->
        <link href="main/img/favicon.ico" rel="icon">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Barlow:wght@400;500;600;700;800;900&display=swap" rel="stylesheet"> 

        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="main/lib/flaticon/font/flaticon.css" rel="stylesheet">
        <link href="main/lib/animate/animate.min.css" rel="stylesheet">
        <link href="main/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="main/css/style.css" rel="stylesheet">
        <title>Parking News</title>
    </head>

    <body id="blog">
        <div id="wrapper">

            <div class="section-header text-center">
                <p>News page</p>
                <h2>Latest news & articles</h2>
            </div>
            <a href="newsADD.jsp">ADD NEWS</a></br>
            <%

                String searchNews = request.getParameter("Search News");
                if (searchNews == null) {
                    searchNews = "";
                }
            %>

            <form action="MainController" >
                Search <input type="text" name="Search News"  value="<%= searchNews%>" placeholder="Search By Title"/>
                <input type="submit" name="action"  value="Search News"/>
            </form>

            <%  List<NewsDTO> list = (List<NewsDTO>) session.getAttribute("LIST_NEWS");
                if (list != null) {
                    if (!list.isEmpty()) {
            %>

            <section>
                <div id="articles">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>ID NEWS</th>
                                <th>TITLE NEWS</th>
                                <th>INFO NEWS</th>
                                <th>IMAGE</th>
                                <th>DATE SUBMITTED</th>
                                <th>ID EMPLOYEE</th>            
                            </tr>
                        </thead>
                        <article>
                            <tbody>

                                <%
                                    int count = 1;
                                    for (NewsDTO news : list) {
                                %>               
                            <form action="MainController">                    
                                <tr>
                                <div class="blog">
                                    <div class="container">
                                        <div class="row">
                                            <div class="col-lg-4">
                                            <article class="card">
                                                <td><%=count++%></td>
                                                <td><%=news.getIdNews()%></td>
                                                <td><h1><%=news.getTitle()%></h1></td>
                                                <div class="blog-text">
                                                    <td><%=news.getInfoNews()%></td>
                                                </div>
                                                <div class="blog-img">
                                                    <td><img src="<%=news.getImage()%>" alt="Image" width="100" height="100"></td>
                                                    <div class="meta-date">
                                                        <td><%=news.getDateSubmited()%></td>
                                                    </div>
                                                </div>
                                                <div class="blog-meta">
                                                    <td><%=news.getOfficeEmpID()%></td>  
                                                </div>

                                                <td>
                                                    <input type="hidden" name="idNews" value="<%=news.getIdNews()%>" />
                                                    <input type="hidden" name="title" value="<%=news.getTitle()%>" />
                                                    <div class="blog-text">
                                                        <input type="hidden" name="infoNews" value="<%=news.getInfoNews()%>" />
                                                    </div>
                                                    <input type="hidden" name="image" value="<%=news.getImage()%>" />
                                                    <input type="hidden" name="dateSubmited" value="<%=news.getDateSubmited()%>" />
                                                    <input type="hidden" name="officeEmpID" value="<%=news.getOfficeEmpID()%>" />
                                                    <input type="submit" name="action" value="getNews"/></td>
                                                <td>
                                                    <form action="MainController">
                                                        <input type="hidden" name="idNews" value="<%=news.getIdNews()%>"/>
                                                        <input type="submit"  name="action" value="Remove News"/>
                                                    </form>

                                                </td>
                                            </article>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                </tr>
                            </form>
                            <div class="blog">
                                <div class="container">

                                    <div class="row">
                                        <div class="col-lg-4">
                                            <div class="blog-item">
                                                <div class="blog-img">
                                                    <img src="main/img/blog-1.jpg" alt="Image">
                                                    <div class="meta-date">
                                                        <span>01</span>
                                                        <strong>Jan</strong>
                                                        <span>2045</span>
                                                    </div>
                                                </div>
                                                <div class="blog-text">
                                                    <h3><a href="#">Reason</a></h3>
                                                    <p>
                                                        Since we will take care of your car like ours, always be safe, let us take care of your car. Your safety is our responsibility.                               </p>
                                                </div>
                                                <div class="blog-meta">
                                                    <p><i class="fa fa-user"></i><a href="">Admin</a></p>
                                                    <p><i class="fa fa-folder"></i><a href="">Web Design</a></p>
                                                    <p><i class="fa fa-comments"></i><a href="">15 Comments</a></p>
                                                </div>
                                            </div>
                                        </div>



                                    </div>
                                </div>
                                <%
                                    }
                                %>           
                                </tbody>
                                </table>   
                                <%
                                        }
                                    }
                                %> 

                                <%
                                    String error = (String) request.getAttribute("ERROR");
                                    if (error == null) {
                                        error = "";
                                    }
                                %>
                                <%=error%>

                                <script>
                                    $(function () {
                                        $('#example1').DataTable()
                                        $('#example2').DataTable({
                                            'paging': true,
                                            'lengthChange': false,
                                            'searching': false,
                                            'ordering': true,
                                            'info': true,
                                            'autoWidth': false
                                        })
                                    })
                                </script>
                                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
                                <script src="main/lib/easing/easing.min.js"></script>
                                <script src="main/lib/owlcarousel/owl.carousel.min.js"></script>
                                <script src="main/lib/waypoints/waypoints.min.js"></script>
                                <script src="main/lib/counterup/counterup.min.js"></script>

                                <!-- Contact Javascript File -->
                                <script src="main/mail/jqBootstrapValidation.min.js"></script>
                                <script src="main/mail/contact.js"></script>

                                <!-- Template Javascript -->
                                <script src="main/js/main.js"></script>
                                </body>
                                </html>
