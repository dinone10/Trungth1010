
<%@page import="news.NewsError"%>
<%@page import="news.NewsError"%>
<%@page import="officeEmployees.OfficeEmployeeError"%>
<!DOCTYPE html>
<html>
    <head>
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
        <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
        <!-- DataTables -->
        <link rel="stylesheet" href="bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Google Font -->
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <%
            NewsError newsError = (NewsError) request.getAttribute("NEWS_ERROR");
            if (newsError == null) {
                newsError = new NewsError();
            }
            String idNews = request.getParameter("idNews");
            if (idNews == null) {
                idNews = "";
            }
            String infoNews = request.getParameter("infoNews");
            if (infoNews == null) {
                infoNews = "";
            }
            String image = request.getParameter("image");
            if (image == null) {
                image = "";
            }
            String dateSubmited = request.getParameter("dateSubmited");
            if (dateSubmited == null) {
                dateSubmited = "";
            }
            String officeEmpID = request.getParameter("officeEmpID");
            if (officeEmpID == null) {
                officeEmpID = "";
            }
            String title = request.getParameter("title");
            if (title == null) {
                title = "";
            }
        %>
        
        <div class="wrapper">

            <header class="main-header">
                <!-- Logo -->
                <a href="carreview.php" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b><i class="fa fa-cab"></i></b></span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b><i class="fa fa-cab"></i> Car</b>Rental</span>
                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>

                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <li class="dropdown user user-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="dist/img/avatar5.png" class="user-image" alt="User Image">
                                    <span class="hidden-xs">Sample Name</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- User image -->
                                    <li class="user-header">
                                        <img src="dist/img/avatar5.png" class="img-circle" alt="User Image">

                                        <p>
                                            Sample Name
                                            <small>Member since Nov. 2012</small>
                                        </p>
                                    </li>
                                    <li class="user-footer">
                                        <div class="pull-center">
                                            <a class="btn btn-danger" style="width: 100%" href="index.jsp"><i class="fa fa-spinner fa-spin"></i> Log out</a>                
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <!-- Control Sidebar Toggle Button -->
                        </ul>
                    </div>
                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="dist/img/avatar5.png" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p>Sample Name</p>
                            <a href="#"><i class="fa fa-circle text-success"></i> User</a>
                        </div>
                    </div> 
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu" data-widget="tree">
                        <li class="header">Office Employees Functions</li>
                        <li>
                            <a href="MainController?action=displaySpace">
                                <i class="fa fa-cab"></i> <span>Space Parking</span>
                            </a>
                        </li>
                        <li>
                            <a href="sendEmail.jsp">
                                <i class="fa fa-google"></i> <span>Send Email</span>
                            </a>
                        </li>
                        <li >
                            <a href="MainController?action=displayAccount">
                                <i class="fa fa-user-secret"></i> <span>User Account</span>
                            </a>
                        </li>
                        <li class="active">
                            <a href="#">
                                <i class="fa fa-laptop"></i>
                                <span>Encoding</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li class="active"><a href="MainController?action=displayOE"><i class="fa fa-circle-o"></i> Office Employees</a></li>
                                <li ><a href="MainController?action=displayCUS"><i class="fa fa-circle-o"></i> Customer</a></li>
                                <li ><a href="MainController?action=displayPAT"><i class="fa fa-circle-o"></i> Parking Attendant</a></li>
                            </ul>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1 align="center">
                        <i class="fa fa-keyboard-o"></i> Add News
                        <small></small>
                    </h1>
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <form role="form" action="MainController">
                                    <div class="modal-content">
                                        <div class="modal-header"><a href="MainController?action=displayOE"><button type="button" class="btn btn-danger btn-sm" >
                                                    <i class="fa fa-backward"></i> Back
                                                </button></a>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="box box-primary">
                                                <div class="box-header with-border">
                                                    <h3 class="box-title">Fill In : </h3>
                                                </div>
                                                <div class="box-body">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">ID NEWS</label>
                                                        <input type="text" class="form-control"  placeholder="Enter ID News" name="idNews" value="<%= idNews%>" ><%= newsError.getIdNewsError()%>
                                                    </div>                                                    
                                                    <div class="form-group">
                                                        <label>NEWS INFORMATION</label>
                                                        <input type="text" class="form-control"  placeholder="News Information" name="infoNews" value="<%= infoNews%>" ><%= newsError.getInfoNewsError()%>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Image</label>
                                                        <input type="text" class="form-control"  placeholder="Image" name="image" value="<%= image%>" ><%= newsError.getImageError()%>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">DATE Submitted</label>
                                                        <input type="text" class="form-control"  placeholder="DATE Submitted" name="dateSubmited" value="<%= dateSubmited%>" ><%= newsError.getDateSubmitedError()%>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Office Employee ID</label>
                                                        <input type="text" class="form-control"  placeholder="Office Employee ID" name="officeEmpID" value="<%= officeEmpID%>" ><%= newsError.getOfficeEmpIDError()%>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Title</label>
                                                        <input type="text" class="form-control"  placeholder="Title" name="title" value="<%= title%>" ><%= newsError.getTitleError()%>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <a href="MainController?action=ViewNews"><button type="button"  class="btn btn-danger pull-left" >Close</button></a>
                                            <button type="submit" name="action" value="AddNews" class="btn btn-primary">Submit</button>

                                        </div>
                                    </div>
                                </form>
                                <!-- /.modal -->
                            </div>
                            <!-- /.box -->
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                </div>
                <strong>Copyright &copy; 2014-2019 <a href="https://adminlte.io">Car Rental System</a>.</strong> All rights
                reserved.
            </footer>

            <!-- /.control-sidebar -->
            <!-- Add the sidebar's background. This div must be placed
                 immediately after the control sidebar -->
            <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->

        <!-- jQuery 3 -->
        <script src="bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- DataTables -->
        <script src="bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
        <!-- SlimScroll -->
        <script src="bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <!-- FastClick -->
        <script src="bower_components/fastclick/lib/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="dist/js/demo.js"></script>
        <!-- page script -->
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
    </body>
</html>
