<%-- 
    Document   : officeemp_listOrder
    Created on : Jun 30, 2022, 6:12:23 PM
    Author     : Admin
--%>

<%@page import="cart.OrderDTO"%>
<%@page import="java.util.List"%>
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
                    <span class="logo-lg"><b><i class="fa fa-cab"></i> PA</b>System</span>
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
                                            <a class="btn btn-danger" style="width: 100%" href="home.jsp"><i class="fa fa-spinner fa-spin"></i> Log out</a>                
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
                        <li class="header">My Order</li>

                        <li class="active">
                            <a href="MainController?action=displayMyOrder">
                                <i class="fa fa-google"></i> <span>List My Order</span>
                            </a>
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
                        <i class="fa fa-cab"></i> Parking Apartment
                        <small></small>
                    </h1>
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title"><i class="fa fa-car"></i> My Order Data Table</h3>


                                    <a href="MainController?action=getHome&userName=<%= request.getParameter("userName")%>">  <button type="button"  class="btn btn-success btn-sm" style="margin-left: 2%">
                                            <i class="fa fa-backward"></i> Shopping more
                                        </button></a>
                                </div>

                                <!-- /.box-header -->


                                <div class="box-body">
                                    <%  List<OrderDTO> listAll = (List<OrderDTO>) session.getAttribute("LIST_MY_ORDER");
                                        if (listAll != null) {
                                            if (!listAll.isEmpty()) {
                                    %>
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr style="background-color: #c5c5c5;">
                                                <th style="width: 10%"><i class="fa fa-car"></i> Order ID</th>
                                                <th style="width: 20%"><i class="fa fa-car"></i> Order Date</th>
                                                <th style="width: 20%"><i class="fa fa-car"></i> Total</th>
                                                <th style="width: 20%"><i class="fa fa-car"></i> Customer ID</th>
                                                <th style="width: 15%"><i class="fa fa-car"></i> Status</th>
                                                <th style="width: 15%"> </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                for (OrderDTO order : listAll) {
                                            %>
                                            <tr>
                                                <td><%=order.getOrderID()%></td>
                                                <td><%=order.getOrderDate()%></td>
                                                <td><%=order.getTotal()%></td>
                                                <td><%=order.getCusID()%></td>
                                                <% if (order.getStatus().equals("1")) { %>
                                                <td align="center"><span class="btn btn-success btn-xs">Processed</span></td>
                                                <%}%>
                                                <% if (order.getStatus().equals("0")) { %>
                                                <td align="center"><span class="btn btn-danger btn-xs">Processing</span></td>
                                                <%}
                                                %>

                                                <td align="center">
                                                    <form action="MainController">
                                                        <input type="hidden" name="orderID" value="<%=order.getOrderID()%>"/>     
                                                        <input type="hidden" name="userName" value="<%= request.getParameter("userName")%>" />
                                                        <input type="hidden" name="cusID" value="<%= request.getParameter("cusID")%>" />
                                                        <button type="submit" style="background-color: #c3039e;" class="btn btn-sm" name="action" value="displayMyOrderDetail"><i class="fa fa-eye" style="color: white"></i></button>                                                     
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
                                                <th>Order ID</th>
                                                <th>Order Date</th>
                                                <th>Total</th>
                                                <th>Customer ID</th>
                                                <th>Status</th>
                                                <th> </th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                    <!-- /.modal -->            
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
