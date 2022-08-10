<%@page import="customers.CustomerDTO"%>
<%@page import="card.CardDTO"%>
<%@page import="vehicle.VehicleDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="card.CardError"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Parking Apartment System - PA</title>
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
        <!-- booking --> 
        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,600" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="infoBooking/bootstrap.min.css" />

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="infoBooking/style.css" />

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>

    <body>
        <%
            if (request.getParameter("userName").equals("null")) {
                response.sendRedirect("index.jsp");
            }
        %>
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
                            <a href="MainController?action=listSpace&userName=<%=request.getParameter("userName")%>" class="nav-item nav-link">Booking</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" style="color: white">Long Term Card</a>
                                <div class="dropdown-menu">
                                    <a href="MainController?action=getCreateCard&userName=<%=request.getParameter("userName")%>" class="dropdown-item">Register Card</a>
                                    <a href="MainController?action=getExtend&userName=<%=request.getParameter("userName")%>" class="dropdown-item">Extend card</a>
                                </div>
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
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" style="color: white"><%= request.getParameter("userName")%></a>
                                <div class="dropdown-menu">
                                    <a href="MainController?action=ViewInfoCus" class="dropdown-item">View Information</a>
                                    <a href="MainController?action=displayMyOrder&cusID=<%=request.getParameter("cusID")%>" class="dropdown-item">View My Order</a>
                                    <a href="MainController?action=DisplayMyCard&userName=<%=request.getParameter("userName")%>" class="dropdown-item">View My Card</a>
                                </div>
                            </div>
                            <%}%>
                        </div>
                </nav>
            </div>
        </div>
        <!-- Nav Bar End -->


        <!-- Page Header Start -->
        <div class="page-header">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h2>Extend Card</h2>
                    </div>
                    <div class="col-12">
                        <a href="">Home</a>
                        <a href="">Price</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Page Header End -->
        <!-- Create Start -->
        <%
            CardError cardError = (CardError) request.getAttribute("CARD_ERROR");
            if (cardError == null) {
                cardError = new CardError();
            }
        %>
        <form action="MainController" method="post">

            <%
                List<CustomerDTO> listCus = (List<CustomerDTO>) session.getAttribute("LIST_CUS_BY_ID");
                String cusID = "";
                for (CustomerDTO cus : listCus) {
                    cusID = cus.getCusID();
                }
                List<CardDTO> listAll = (List<CardDTO>) session.getAttribute("LIST_CARD");
                int longCardID = 0;
                String expirationDate = "";
                if (listAll != null) {
                    if (!listAll.isEmpty()) {
            %>
            <div id="booking" class="section">
                <div class="section-center">
                    <div class="container">
                        <div class="row">
                            <div class="booking-form" style="padding: 30px 15px 100px;">
                                <form>
                                    <b style="padding-left: 400px; font-size: x-large">Extend Long Term Card </b></br>
                                    <%
                                        for (CardDTO card : listAll) {
                                            longCardID = card.getLongCardID();
                                            expirationDate = card.getExpirationDate();
                                    %>
                                    <%
                                                }
                                            }
                                        }
                                    %>
                                    </select>
                                    <div class="col-md-12">
                                        <div class="form-group" style="padding-left: 250px; font-size: large">
                                            <h4><b><%= cusID%></b> 's card will expire on <b><%= expirationDate%></b></h4>                                          
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group" style="padding-bottom: 50px; align-content: center; padding-left: 250px; width: 800px">
                                            <p style="font-size: large">Number of days you want to extend:</p>
                                            <input class="form-control" type="text" name="numberDate" required="" >
                                            <span class="select-arrow"></span>
                                            <h4 style="color: red; "><%= cardError.getImportIDErorr()%></h4>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <input type="hidden" name="longCardID" value="<%= longCardID%>" />
                                            <input type="hidden" name="expirationDate" value="<%= expirationDate%>" />
                                            <input type="hidden" name="cusID" value="<%= cusID%>" />

                                            <div class="col-sm-12" style="padding-left: 250px; align-content: center; width: 800px">
                                                <input type="hidden" name="userName" value="<%= request.getParameter("userName")%>" />
                                                <button type="submit" name="action" value="extendCard" class="submit-btn">EXTEND CARD</button>

                                            </div>

                                        </div>

                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
        </form>

    </div>
</form>
<!-- Create End -->


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
        <p>&copy; <a href="#">Your Site Name</a>, All Right Reserved. Designed By <a href="https://htmlcodex.com">HTML Codex</a></p>
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
