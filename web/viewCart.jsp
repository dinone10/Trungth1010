<%-- 
    Document   : viewCart
    Created on : Jun 27, 2022, 3:27:12 PM
    Author     : Admin
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="space_detail.SpaceDetailDTO"%>
<%@page import="java.util.List"%>
<%@page import="customers.CustomerDTO"%>
<%@page import="accounts.AccountDTO"%>
<%@page import="space.SpaceDTO"%>
<%@page import="cart.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    </head>
    <body>
        <div class="page-header">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h2>CART</h2>
                    </div>
                    <div class="col-12">
                        <a href="">Home</a>
                        <a href="">CART</a>
                    </div>
                </div>
            </div>
        </div>
        <%List<CustomerDTO> listAll = (List<CustomerDTO>) session.getAttribute("LIST_CUS_BY_ID");%>
        <%
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart == null) {
        %>
        <h3 class="message" style="margin-left: 500px">You have not booked. Please, go back to the booking page to make a reservation!!</h3>
        <a  href="MainController?action=listSpace&userName=<%= request.getParameter("userName")%>" style="margin-left: 900px; ">Back to Booking</a>
        <%
        } else {
        %>
        <%    
            String message = (String) request.getAttribute("SHOPPING_MESSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <h1 class="message"><%=message%></h1></br>
        <div class="content">           
            <div class="container h-100 py-5">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col">

                        <div class="table-responsive" >
                            <table class="table" border="1" >
                                <thead>
                                    <tr>
                                        <th scope="col" class="h5">No</th>
                                        <th scope="col">Slot ID</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">Time Start</th>
                                        <th scope="col">Time End</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%  int count = 1;
                                        float total = 0;
                                        float priceAll = 0;
                                        String timeStart = "";
                                        String timeEnd = "";
                                        for (SpaceDetailDTO space : cart.getCart().values()) {
                                            Date nowDate = new Date();
                                            Date checkTimeStart = new Date();
                                            Date checkTimeEnd = new Date();
                                            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                                            timeStart = space.getTimeStart();
                                            timeEnd = space.getTimeEnd();
                                            checkTimeStart = formater.parse(timeStart);
                                            checkTimeEnd = formater.parse(timeEnd);
                                            long diff = checkTimeEnd.getTime() - checkTimeStart.getTime();
                                            long diffDays = (diff / (60 * 60 * 1000)) / 24;
                                            priceAll = space.getPrice() * diffDays;
                                            
                                            total += priceAll;

                                    %>   

                                <form action="MainController">
                                    <tr>
                                        <td><%=count++%></td>
                                        <td class="align-middle"><%=space.getSlotID()%></td>
                                        <td class="align-middle"><fmt:formatNumber value="<%=priceAll%>" type="currency" currencySymbol="" minFractionDigits="0"/> VND</td>  
                                        <td class="align-middle"><%=space.getTimeStart()%></td>
                                        <td class="align-middle"><%=space.getTimeEnd()%></td>
                                        <td>
                                            <input type="hidden" name="slotID" value="<%=space.getSlotID()%>"/>
                                            <input type="hidden" name="userName" value="<%=request.getParameter("userName")%>"/>
                                            <button type="submit" name="action" value="RemoveCart"><i class="fa-solid fa-trash"></i></button>
                                        </td>
                                    </tr>
                                </form>                                          
                                <%
                                    }
                                %>
                                </tbody>
                            </table>
                        </div>

                        <div class="card shadow-2-strong mb-5 mb-lg-0" style="border-radius: 16px;">
                            <div class="card-body p-4">

                                <div class="row">
                                    <div class="col-md-6 col-lg-4 col-xl-3 mb-4 mb-md-0">
                                        <form>
                                            <%                
                                                for (CustomerDTO cus : listAll) {

                                            %>
                                            <div class="">
                                                <h4>Receiver's information:</h4>
                                                <ul>

                                                    <li>Full Name: <%= cus.getCusName()%></li> 
                                                    <li>Phone: <%= cus.getPhone()%></li> 
                                                    <li>Email: <%= cus.getEmail()%></li> 
                                                    <li>Vehicle ID: <%= cus.getVehicleID()%></li> 


                                                </ul>
                                                <form action="MainController">
                                                    <input type="hidden" name="cusID" value="<%= cus.getCusID()%>"/>
                                                    <input type="hidden" name="total" value="<%=total%>" min="1"/>  
                                                    <input type="hidden" name="timeStart" value="<%= timeStart%>"/>
                                                    <input type="hidden" name="timeEnd" value="<%= timeEnd%>"/>

                                                    <div class="col-md-6 col-lg-4 col-xl-6">
                                                        <div class="row">
                                                            <div>
                                                                <div class="d-flex justify-content-between mb-4" style="font-weight: 500;">
                                                                    <p class="mb-2">Total (tax included)</p>
                                                                    <p><fmt:formatNumber value="<%=total%>" type="currency" currencySymbol="" minFractionDigits="0"/> VND</p>  
                                                                </div>
                                                                <input type="hidden" name="userName" value="<%= request.getParameter("userName")%>" />
                                                                <input class="button" type="submit" name="action" value="CheckOut"/>

                                                                <div class="shopping">
                                                                    <a  href="MainController?action=listSpace&userName=<%= request.getParameter("userName")%>">Booking more</a>
                                                                </div>
                                                            </div> 
                                                        </div>
                                                    </div>
                                                </form>      
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
            }
        %>
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
