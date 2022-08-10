<%@page import="accounts.AccountError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sign Up</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="login and register/fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="login and register/css/style.css">
    </head>
    <body>
        <%
            AccountError accountError = (AccountError) request.getAttribute("ACCOUNT_ERROR");
            if (accountError == null) {
                accountError = new AccountError();
            }
        %>
        <div class="main">

            <!-- Sign up form -->
            <section class="signup">
                <div class="container">
                    <div class="signup-content">
                        <div class="signup-form">
                            <h2 class="form-title">Sign up</h2>
                            <form action="MainController" method="POST" class="register-form" id="register-form">
                                <div class="form-group">
                                    <label for="idAccount"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                    <input type="text" name="idAccount" id="idAccount" placeholder="ID Account" required="" /><a style="color: red"><%= accountError.getIdAccountError()%></a>
                                </div>
                                <div class="form-group">
                                    <label for="userName"><i class="zmdi zmdi-email"></i></label>
                                    <input type="text" name="userName" id="userName" placeholder="User Name" required="" /><a style="color: red"><%= accountError.getUserNameError()%></a>
                                </div>
                                <div class="form-group">
                                    <label for="password"><i class="zmdi zmdi-lock"></i></label>
                                    <input type="password" name="password" id="password" placeholder="Password" required="" /><a style="color: red"><%= accountError.getPasswordError()%></a>
                                </div>
                                <div class="form-group">
                                    <label for="password"><i class="zmdi zmdi-lock-outline"></i></label>
                                    <input type="password" name="confirm" id="password" placeholder="Repeat your password" required="" /><a style="color: red"><%= accountError.getConfirmError()%></a>
                                </div>
                                Role ID <input type="text" name="roleID" value="CUS"  readonly=""></br>
                                <div class="form-group">
                                    <label for="email"><i class="zmdi zmdi-lock-outline"></i></label>
                                    <input type="text" name="email" id="re_pass" placeholder="Your Email" required="" /><a style="color: red"><%= accountError.getEmailError()%></a>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                    <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                                </div>
                                <div class="form-group form-button">
                                    <input type="submit" name="action" id="action" class="form-submit" value="Register"/>
                                </div>
                            </form>
                        </div>
                        <div class="signup-image">
                            <figure><img src="login and register/images/signup.jpg" alt="sing up image"></figure>
                            <a href="index.jsp" class="signup-image-link">I am already member</a>
                        </div>
                    </div>
                </div>
            </section>
            <!-- JS -->
            <script src="login and register/vendor/jquery/jquery.min.js"></script>
            <script src="login and register/js/main.js"></script>
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>