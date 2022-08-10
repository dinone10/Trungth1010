
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link rel="stylesheet" type="text/css" href="ggstyle.css" />
        <script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Car Rental System</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="/bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="plugins/iCheck/square/blue.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Google Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

    </head>
    <body class="hold-transition login-page">
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
        <div class="login-box">
            <div class="login-logo">
                <a href="index.php"><b>PA</b>System</a>
            </div>
            <!-- /.login-logo -->
            <div class="login-box-body">
                <p class="login-box-msg">Log in to start your session</p>

                <form action="MainController" method="POST">
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="userName" placeholder="Username" value="<%=userName%>" >
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" name="password" placeholder="Password" value="<%=password%>">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-8">
                            <div class="checkbox icheck">
                                <label>
                                    Remember Me <input type="checkbox" name="remember"  value="1" 
                                                       <%= "1".equals(remember) ? " checked= '/checked'" : ""%> 
                                                       /></br> 
                                </label>
                            </div>
                        </div>
                        <!-- /.col -->
                        <div class="col-xs-4">
                            <button type="submit" class="btn btn-primary btn-block btn-flat" name="action" value="Login">Sign In</button>
                        </div>
                        <!-- /.col -->
                    </div>  
                </form>

                <!-- /.social-auth-links -->

                <a href="forgotPassword.jsp">I forgot my password</a><br>

            </div>
            <!-- /.login-box-body -->
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-5 mx-auto">
                    <div id="first">
                        <div class="myform form ">
                            <div class="col-md-12 ">
                                <div class="login-or">
                                    <hr class="hr-or">
                                    <span class="span-or">or</span>
                                </div>
                            </div>
                            <div class="col-md-12 mb-3">
                                <p class="text-center">
                                    <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/ParkingApartment/login-google&response_type=code
                                       &client_id=372100716601-6unugeitulsumgfei2cvq8h51puu2scr.apps.googleusercontent.com&approval_prompt=force" class="google btn mybtn"><i class="fa fa-google-plus">
                                        </i> Signup using Google
                                    </a>
                                </p>
                            </div>
                            <div class="form-group">
                                <p class="text-center">Don't have account? <a href="register.jsp" id="signup">Sign up here</a></p>
                            </div>


                        </div>
                    </div>

                </div>
            </div>
        </div> 
        <!-- /.login-box -->

        <!-- jQuery 3 -->
        <script src="bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- iCheck -->
        <script src="plugins/iCheck/icheck.min.js"></script>
        <script>
            $(function () {
                $('input').iCheck({
                    checkboxClass: 'icheckbox_square-blue',
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%' /* optional */
                });
            });
        </script>
    </body>
</html>
