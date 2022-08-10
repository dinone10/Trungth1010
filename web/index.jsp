<%@page import="accounts.AccountDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="login and register/fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="login and register/css/style.css">
    </head>
    <body>
        <%
            String userName = "", password = "", remember = "";
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cook : cookies) {
                    if (cook.getName().equals("cookUname")) {
                        userName = cook.getValue();
                    }
                    if (cook.getName().equals("cookPass")) {
                        password = cook.getValue();
                    }
                    if (cook.getName().equals("cookRem")) {
                        remember = cook.getValue();
                    }

                    cook.getName().equals("cookPass");
                    cook.getName().equals("cookRem");

                }
            }

        %>
        <div class="main">
            <!-- Sing in  Form -->
            <section class="sign-in">
                <div class="container">
                    <div class="signin-content">
                        <div class="signin-image">
                            <figure><img src="login and register/images/sigin.jpg" alt="sing up image"></figure>
                            <a href="register.jsp" class="signup-image-link">Create an account</a>
                        </div>

                        <div class="signin-form">
                            <h2 class="form-title">Login</h2>
                            <form action="MainController" method="POST" class="register-form" id="login-form">
                                <div class="form-group">
                                    <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                    <input type="text" name="userName" id="your_name" placeholder="Username" value="<%=userName%>"/>
                                </div>
                                <div class="form-group">
                                    <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                    <input type="password" name="password" id="your_pass" placeholder="Password" value="<%=password%>"/>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                    <label for="remember-me" class="label-agree-term" value="1" <%= "1".equals(remember) ? " checked= '/checked'" : ""%>><span><span></span></span>Remember me</label>
                                </div>
                                <div class="form-group form-button">
                                    <input type="submit" name="action" id="signin" class="form-submit" value="Login"/>
                                    <input type="submit" name="action" id="signin" class="form-submit" value="Back"/>
                                </div>
                                <a href="forgotPassword.jsp">I forgot my password</a><br>
                            </form>
                            <div class="social-login">
                                <span class="social-label">Or login with</span>
                                <ul class="socials">
                                    <li><a href="#"><i class="display-flex-center zmdi zmdi-facebook"></i></a></li>
                                    <li><a href="#"><i class="display-flex-center zmdi zmdi-twitter"></i></a></li>
                                    <li><a href="https://accounts.google.com/o/oauth2/auth?scope=profile&redirect_uri=http://localhost:8084/ParkingApartmentV1/login-google&response_type=code
                                           &client_id=372100716601-9i4lt719d8n1vrni8b4q3j955jhu26bs.apps.googleusercontent.com&approval_prompt=force"><i class="display-flex-center zmdi zmdi-google"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </div>

        <!-- JS -->
        <script src="login and register/vendor/jquery/jquery.min.js"></script>
        <script src="login and register/js/main.js"></script>
        <script>
            $(function () {
                $('input').iCheck({
                    checkboxClass: 'icheckbox_square-blue',
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%' /* optional */
                });
            });
        </script>
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>