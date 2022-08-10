<%-- 
    Document   : listSpaceBooking1
    Created on : Jul 1, 2022, 12:03:18 AM
    Author     : Admin
--%>

<%@page import="cart.OrderDTO"%>
<%@page import="space_detail.SpaceDetailDTO"%>
<%@page import="space.SpaceDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- 
    Document   : homev2
    Created on : Jun 5, 2022, 6:26:09 PM
    Author     : User
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parking Apartment System - PA</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free Website Template" name="keywords">
        <meta content="Free Website Template" name="description">

        <!-- Favicon -->
        <link href="main/img/favicon.ico" rel="icon">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Barlow:wght@400;500;600;700;800;900&display=swap
              " rel="stylesheet"> 

        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css
              " rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css
              " rel="stylesheet">
        <link href="main/lib/flaticon/font/flaticon.css" rel="stylesheet">
        <link href="main/lib/animate/animate.min.css" rel="stylesheet">
        <link href="main/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- CSS Booking -->  
        <link href="https://fonts.googleapis.com/css?family=Righteous&display=swap
              " rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="Booking/css/bootstrap.min.css" />
        <script type="text/javascript"  src="Booking/js/jquery-2.1.1.min.js"></script>
        <script  type="text/javascript" src="Booking/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="Booking/css/style.css" media="all">
        <link rel="stylesheet" type="text/css" href="Booking/css/font-awesome.min.css" />
        <!-- Template Stylesheet -->
        <link href="main/css/style.css" rel="stylesheet">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>

    <body>
        <!-- Top Bar Start -->
        <div class="top-bar">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 col-md-12">
                        <div class="logo">
                            <a href="home.jsp">
                                <h1>Parking<span>Apartment</span></h1>
                                <!-- <img src="img/logo.jpg" alt="Logo"> -->
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-7 d-none d-lg-block">
                        <div class="row">
                            <div class="col-4">
                                <div class="top-bar-item">
                                    <div class="top-bar-icon">
                                        <i class="far fa-clock"></i>
                                    </div>
                                    <div class="top-bar-text">
                                        <h3>Opening Hour</h3>
                                        <p>Mon - Fri, 8:00 - 9:00</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="top-bar-item">
                                    <div class="top-bar-icon">
                                        <i class="fa fa-phone-alt"></i>
                                    </div>
                                    <div class="top-bar-text">
                                        <h3>Call Us</h3>
                                        <p>+012 345 6789</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="top-bar-item">
                                    <div class="top-bar-icon">
                                        <i class="far fa-envelope"></i>
                                    </div>
                                    <div class="top-bar-text">
                                        <h3>Email Us</h3>
                                        <p>info@example.com</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Top Bar End -->
        <!-- Nav Bar Start -->
        <div class="nav-bar">
            <div class="container">
                <nav class="navbar navbar-expand-lg bg-dark navbar-dark">
                    <a href="#" class="navbar-brand">MENU</a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto">
                            <a href="MainController?action=getHome&userName=<%=request.getParameter("userName")%>" class="nav-item nav-link">Home</a>
                            <a href="about.jsp" class="nav-item nav-link">About</a>
                            <a href="service.jsp" class="nav-item nav-link">Service</a>
                            <a href="price.jsp" class="nav-item nav-link">Price</a>
                            <a href="MainController?action=displayBooking&userName=<%=request.getParameter("userName")%>" class="nav-item nav-link active">Booking</a>
                            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" style="color: white">Long Term Card</a>
                            <div class="dropdown-menu">
                                <a href="MainController?action=getCreateCard&userName=<%=request.getParameter("userName")%>" class="dropdown-item">Register Card</a>
                                <a href="MainController?action=getExtendCard&userName=<%=request.getParameter("userName")%>%>" class="dropdown-item">Extend card</a>
                            </div>
                            <a href="location.jsp" class="nav-item nav-link">Parking Points</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                                <div class="dropdown-menu">
                                    <a href="blog.jsp" class="dropdown-item">Blog Grid</a>

                                </div>
                            </div>
                            <a href="contact.jsp" class="nav-item nav-link">Contact</a>
                            <a href="MainController?action=ViewCart&idAccount=${CURRENT_LOGIN.idAccount}&userName=<%= request.getParameter("userName")%>" class="nav-item nav-link" style="margin-left: 200px;"><i class="fa-solid fa-cart-shopping"></i></a>
                                <%if (request.getParameter("userName") == null) {%>
                            <div class="ml-auto">
                                <a class="btn btn-custom" href="MainController?action=Login">Login</a>
                            </div>

                            <%} else {%>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"><%= request.getParameter("userName")%></a>
                                <div class="dropdown-menu">
                                    <a href="MainController?action=ViewInfoCus" class="dropdown-item">View Information</a>
                                    <a href="MainController?action=displayMyOrder&userName=<%=request.getParameter("userName")%>" class="dropdown-item">View My Order</a>
                                    <a href="MainController?action=DisplayMyCard&userName=<%=request.getParameter("userName")%>" class="dropdown-item">View My Card</a>
                                </div>
                            </div>
                            <%}%>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- Nav Bar End -->
        <%  List<SpaceDTO> listAll = (List<SpaceDTO>) session.getAttribute("LIST_ALL_SPACE");
            List<SpaceDetailDTO> listDetailAll = (List<SpaceDetailDTO>) session.getAttribute("LIST_ALL_SPACE_DETAIL");
            float price = 0;
            int parkingDetailID = 0;
            String date = "";
            String userName = request.getParameter("userName");
            for (SpaceDetailDTO spaceDetail : listDetailAll) {
                price = spaceDetail.getPrice();
                parkingDetailID = Integer.parseInt(spaceDetail.getParkingDetailID());
            }

            if (listAll != null) {
                if (!listAll.isEmpty()) {
        %>
        <form action="MainController">
            <div class="container" >
                <div class="row">
                    <div class="col-sm-12 middle">
                        <p>Book parking at the apartment to ensure safety and excellent quality</p>
                        <div class="middle_1 clearfix" >

                            <ul class="nav nav-tabs">
                                <li class="active"><a  href="MainController?action=listSpace&userName=<%= request.getParameter("userName")%>">All Space</a></li>
                                <li><a  href="MainController?action=listSpaceA1&userName=<%= request.getParameter("userName")%>">Block A1</a></li>
                                <li><a  href="MainController?action=listSpaceA2&userName=<%= request.getParameter("userName")%>">Block A2</a></li>
                                <li><a  href="MainController?action=listSpaceB1&userName=<%= request.getParameter("userName")%>">Block B1</a></li>
                                <li><a  href="MainController?action=listSpaceB2&userName=<%= request.getParameter("userName")%>">Block B2</a></li>                             
                            </ul>
                            <%
                                for (SpaceDTO space : listAll) {
                            %>
                            <div class="col-sm-4 tab-content clearfix" >
                                <div id="home_1" class="tab-pane fade in active clearfix">
                                    <div class="click clearfix">
                                        <div class="col-sm-12 world">
                                            <div class="col-sm-12">
                                                <div class="thumbnail">
                                                    <div class="london_top">
                                                        <div class="londan">
                                                            <img src="https://blog.getmyparking.com/wp-content/uploads/2021/07/sen-e1627888187393-930x419.jpeg" width="550" height="411"  class="img-responsive">
                                                        </div>
                                                        <div class="londan__1">
                                                            <p><a href="#"><%= space.getSlotID()%></a></p>
                                                        </div>

                                                    </div>
                                                    <div class="caption">
                                                        <div class="row">
                                                            <div class="col-sm-12 low">
                                                                <div class="col-sm-6 low_left">
                                                                    <h6>Low prices from</h6>
                                                                    <h4><span><i class="fa fa-rupee"></i></span><fmt:formatNumber value="<%= price%>" type="currency" currencySymbol="" minFractionDigits="0"/> VND</h4>
                                                                </div>
                                                                <%if (userName.equals("null")) {%>
                                                                <div class="col-sm-6 low_right">
                                                                    <div class="view">
                                                                        <a href="MainController?action=Login">Book Now</a>
                                                                    </div>
                                                                </div>
                                                                <%} else {%>
                                                                <div class="col-sm-6 low_right">
                                                                    <div class="view">
                                                                        <a href="MainController?action=bookNow&slotID=<%= space.getSlotID()%>&parkingDetailID=<%=space.getParkingDetailID()%>&userName=<%=request.getParameter("userName")%>">Book Now</a>
                                                                    </div>
                                                                </div>
                                                                <%}%>
                                                            </div>
                                                            <div class="col-sm-12 low_bottom">
                                                                <h5><i class="fa fa-dot-circle-o"></i><i class="fa fa-dot-circle-o"></i><i class="fa fa-dot-circle-o"></i><i class="fa fa-dot-circle-o"></i><i class="fa fa-dot-circle-o"></i> <a href="#">PA System <span class="reward"> 1,793 reviews</span></a></h5>
                                                                <ul class="low_bottom_bred text-center">
                                                                    <li><i class="fa fa-eye"></i> 25</li>
                                                                    <li><i class="fa fa-comment"></i> 15</li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            %>
                        </div>
                        <%
                                }
                            }
                        %> 
                    </div>
                </div>
            </div>
        </form>

    </div>
</div>





<!-- Footer Start -->
<div class="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6">
                <div class="footer-contact">
                    <h2>Get In Touch</h2>
                    <p><i class="fa fa-map-marker-alt"></i>123 Street, New York, USA</p>
                    <p><i class="fa fa-phone-alt"></i>+012 345 67890</p>
                    <p><i class="fa fa-envelope"></i>info@example.com</p>
                    <div class="footer-social">
                        <a class="btn" href=""><i class="fab fa-twitter"></i></a>
                        <a class="btn" href=""><i class="fab fa-facebook-f"></i></a>
                        <a class="btn" href=""><i class="fab fa-youtube"></i></a>
                        <a class="btn" href=""><i class="fab fa-instagram"></i></a>
                        <a class="btn" href=""><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="footer-link">
                    <h2>Popular Links</h2>
                    <a href="">About Us</a>
                    <a href="">Contact Us</a>
                    <a href="">Our Service</a>
                    <a href="">Service Points</a>
                    <a href="">Pricing Plan</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="footer-link">
                    <h2>Useful Links</h2>
                    <a href="">Terms of use</a>
                    <a href="">Privacy policy</a>
                    <a href="">Cookies</a>
                    <a href="">Help</a>
                    <a href="">FQAs</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="footer-newsletter">
                    <h2>Newsletter</h2>
                    <form>
                        <input class="form-control" placeholder="Full Name">
                        <input class="form-control" placeholder="Email">
                        <button class="btn btn-custom">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="container copyright">
        <p>&copy; <a href="#">Your Site Name</a>, All Right Reserved. Designed By <a href="https://htmlcodex.com
                                                                                     ">HTML Codex</a></p>
    </div>
</div>
<!-- Footer End -->

<!-- Back to top button -->
<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

<!-- Pre Loader -->
<div id="loader" class="show">
    <div class="loader"></div>
</div>

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js
"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js
"></script>
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
