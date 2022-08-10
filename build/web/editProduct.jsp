<%-- 
    Document   : editProduct
    Created on : Mar 12, 2022, 12:39:57 PM
    Author     : Admin
--%>

<%@page import="sample.user.UserError"%>
<%@page import="sample.products.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.products.ProductError"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
        <title>Register Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
        <style>
            body {
                color: #fff;
                background: #63738a;
                font-family: 'Roboto', sans-serif;
            }
            .form-control{
                height: 40px;
                box-shadow: none;
                color: #969fa4;
            }
            .form-control:focus{
                border-color: #5cb85c;
            }
            .form-control, .btn{        
                border-radius: 3px;
            }
            .signup-form{
                width: 400px;
                margin: 0 auto;
                padding: 30px 0;
            }
            .signup-form h2{
                color: #636363;
                margin: 0 0 15px;
                position: relative;
                text-align: center;
            }
            .signup-form h2:before, .signup-form h2:after{
                content: "";
                height: 2px;
                width: 30%;
                background: #d4d4d4;
                position: absolute;
                top: 50%;
                z-index: 2;
            }	
            .signup-form h2:before{
                left: 0;
            }
            .signup-form h2:after{
                right: 0;
            }
            .signup-form .hint-text{
                color: #999;
                margin-bottom: 30px;
                text-align: center;
            }
            .signup-form form{
                color: #999;
                border-radius: 3px;
                margin-bottom: 15px;
                background: #f2f3f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .signup-form .form-group{
                margin-bottom: 20px;
            }
            .signup-form input[type="checkbox"]{
                margin-top: 3px;
            }
            .signup-form .btn{        
                font-size: 16px;
                font-weight: bold;		
                min-width: 140px;
                outline: none !important;
            }
            .signup-form .row div:first-child{
                padding-right: 10px;
            }
            .signup-form .row div:last-child{
                padding-left: 10px;
            }    	
            .signup-form a{
                color: #fff;
                text-decoration: underline;
            }
            .signup-form a:hover{
                text-decoration: none;
            }
            .signup-form form a{
                color: #5cb85c;
                text-decoration: none;
            }	
            .signup-form form a:hover{
                text-decoration: underline;
            }  
        </style>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !loginUser.getRoleID().equals("AD")) {
                response.sendRedirect("login.jsp");
            }
            ProductError productError = (ProductError) request.getAttribute("PRODUCT_ERROR");
            if (productError == null) {
                productError = new ProductError();
            }
            List<CategoryDTO> list = (List<CategoryDTO>) session.getAttribute("LIST_CATE");
        %>
        <div class="signup-form">
            <form action="MainController" method="post">
                <h2>Edit Product</h2>              
                <div class="form-group">
                    <input type="text" class="form-control" name="productID" placeholder="Product ID" required="" value="<%=request.getParameter("productID")%>">

                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="productName" placeholder="Product Name" required="" value="<%=request.getParameter("productName")%>">

                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="image" placeholder="Product Photo" required="" value="<%=request.getParameter("image")%>">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="price" placeholder="Price of Product" required="" value="<%=request.getParameter("price")%>">

                </div>
                
                <div class="form-group">
                    <input type="text" class="form-control" name="quantity" placeholder="Quantity" required="" value="<%=request.getParameter("quantity")%>">

                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="categoryID" placeholder="T001 - T002 - T003 - T004" required="" value="<%=request.getParameter("categogyID")%>">

                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="importDate" placeholder="Import Date" required="" value="<%=request.getParameter("importDate")%>">

                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="usingDate" placeholder="Using Date" required="" value="<%=request.getParameter("usingDate")%>">

                </div>               
                <div class="form-group">
                    <button type="submit" name="action" value="CheckEdit" class="btn btn-success btn-lg btn-block">Submit</button>
                </div>
            </form>
            <div class="text-center">Do you want back ? <a href="productManagement.jsp">Back</a></div>
        </div>
    </body>
</html>
