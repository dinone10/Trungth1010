<%-- 
    Document   : pat
    Created on : Jun 7, 2022, 7:59:19 AM
    Author     : Admin
--%>

<%@page import="customers.CustomerError"%>
<%@page import="customers.CustomerDTO"%>
<%@page import="attendant.ParkingAttendantError"%>
<%@page import="attendant.ParkingAttendantDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                            <a class="btn btn-danger" style="width: 100%" href="MainController?action=Login"><i class="fa fa-spinner fa-spin"></i> Log out</a>                
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
                            <a href="#"><i class="fa fa-circle text-success"></i> Office Employees</a>
                        </div>
                    </div> 
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu" data-widget="tree">
                        <li class="header">Office Customer Functions</li>
                        <li>
                            <a href="MainController?action=displayUserProfile">
                                <i class="fa fa-cab"></i> <span>User Profile</span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-cab"></i>
                                <span>Space Parking</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li ><a href="MainController?action=displaySpace"><i class="fa fa-circle-o"></i> All Space</a></li>
                                <li ><a href="MainController?action=displaySpaceA1"><i class="fa fa-circle-o"></i> Block A1</a></li>
                                <li ><a href="MainController?action=displaySpaceA2"><i class="fa fa-circle-o"></i> Block A2</a></li>
                                <li ><a href="MainController?action=displaySpaceB1"><i class="fa fa-circle-o"></i> Block B1</a></li>
                                <li ><a href="MainController?action=displaySpaceB2"><i class="fa fa-circle-o"></i> Block B2</a></li>
                            </ul>
                        </li> 
                        <li >
                            <a href="MainController?action=displayOrder">
                                <i class="fa fa-google"></i> <span>List Order</span>
                            </a>
                        </li>
                        <li>
                            <a href="MainController?action=displayCard">
                                <i class="fa fa-cab"></i> <span>Long Term Card</span>
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
                                <li ><a href="MainController?action=displayOE"><i class="fa fa-circle-o"></i> Office Employees</a></li>                              
                                <li class="active"><a href="MainController?action=displayCUS"><i class="fa fa-circle-o"></i> Customer</a></li>
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
                        <i class="fa fa-keyboard-o"></i> Customer Encoding
                        <small></small>
                    </h1>
                </section>
                <%
                    CustomerError cusError = (CustomerError) request.getAttribute("CUSTOMER_ERROR");
                    if (cusError == null) {
                        cusError = new CustomerError();
                    }
                %>
                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title"><i class="fa fa-user"></i> Customer Data Table</h3><a href="MainController?action=getInfoAddCus"><button type="button" class="btn btn-success btn-sm" style="margin-left: 2%">
                                            <i class="fa fa-plus"></i> Add
                                        </button>
                                    </a>
                                    <div class="modal fade" id="add">
                                        <div class="modal-dialog">
                                            <form role="form">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span></button>
                                                        <h4 class="modal-title">Add Customer</h4>
                                                    </div>
                                                    <form action="MainController" >
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-danger pull-left" data-dismiss="modal">Close</button>
                                                            <button type="submit" name="action" value="createCUS" class="btn btn-primary">Submit</button>
                                                        </div>  
                                                    </form>
                                                </div>
                                            </form>
                                        </div>
                                        <!-- /.modal-dialog -->
                                    </div>
                                    <!-- /.modal -->
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <%  List<CustomerDTO> listAll = (List<CustomerDTO>) session.getAttribute("LIST_ALL_CUS");
                                        if (listAll != null) {
                                            if (!listAll.isEmpty()) {
                                    %>
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr style="background-color: #c5c5c5;">
                                                <th ><i class="fa fa-keyboard-o"></i>Customer ID</th>
                                                <th style="width: 11%"><i class="fa fa-user-secret"></i>Customer</th>
                                                <th style="width: 11%"><i class="fa fa-phone"></i>Phone</th>
                                                <th style="width: 11%"><i class="fa fa-map-marker"></i>Email</th>
                                                <th style="width: 11%"><i class="fa fa-map-marker"></i>Vehicle ID</th>
                                                <th ><i class="fa fa-user"></i>Account ID</th>
                                                <th style="width: 7.8%"> </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                for (CustomerDTO cus : listAll) {
                                            %>
                                            <tr>
                                                <td><%=cus.getCusID()%></td>
                                                <td><%=cus.getCusName()%></td>
                                                <td><%=cus.getPhone()%></td>
                                                <td><%=cus.getEmail()%></td>
                                                <td><%=cus.getVehicleID()%></td>
                                                <td><%=cus.getIdAccount()%></td>
                                                <td align="center">
                                                    <form action="MainController">
                                                        <input type="hidden" name="cusID" value="<%=cus.getCusID()%>"/>
                                                        <input type="hidden" name="cusName" value="<%=cus.getCusName()%>"/>
                                                        <input type="hidden" name="phone" value="<%=cus.getPhone()%>"/>
                                                        <input type="hidden" name="email" value="<%=cus.getEmail()%>"/>
                                                        <input type="hidden" name="vehicleID" value="<%=cus.getVehicleID()%>"/>
                                                        <input type="hidden" name="idAccount" value="<%=cus.getIdAccount()%>"/>
                                                        <button type="submit" class="btn btn-primary btn-sm"  data-target="#edit" name="action" value="getCUS"><i class="fa fa-pencil"></i></button>
                                                    </form>                      
                                                    <form action="MainController">                                                      
                                                        <input type="hidden" name="cusID" value="<%=cus.getCusID()%>"/>
                                                        <button type="submit" name="action" value="deleteCUS" class="btn btn-danger btn-sm"><i class="fa fa-trash"></i></button>
                                                    </form> 
                                                </td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                        <%
                                                }
                                            }
                                        %> 
                                        <tfoot>
                                            <tr style="background-color: #c5c5c5;">
                                                <th>Customer ID</th>
                                                <th>Customer</th>
                                                <th>Phone</th>
                                                <th>Email</th>
                                                <th>Vehicle ID</th>
                                                <th>Account ID</th>
                                                <th> </th>
                                            </tr>
                                        </tfoot>

                                    </table>
                                </div>
                                <!-- /.box-body -->
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

