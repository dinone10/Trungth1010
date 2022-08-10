<%-- 
    Document   : layouts
    Created on : Jun 23, 2022, 10:47:32 AM
    Author     : team2
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Clothes Shop</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>        
        <link href="${root}/css/site.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="${root}"><img src="${root}/image/logo.png" height="70"/></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item" value="Shirt">
                            <a class="nav-link" href="${root}?find=Shirt">Shirt</a>
                        </li>
                        <li class="nav-item" value="Pant">
                            <a class="nav-link" href="${root}?find=Pant">Pant</a>
                        </li>
                        <li class="nav-item" value="Jacket">
                            <a class="nav-link" href="${root}?find=Jacket">Jacket</a>
                        </li>
                        <li class="nav-item" value="Hoodie">
                            <a class="nav-link" href="${root}?find=Hoodie">Hoodie</a>
                        </li>
                    </ul>
                    <form>
                        <input type="text" id="find" name="find" placeholder="Type here to search">
                        <button  type="submit" style="background-color: white"><i class="bi bi-search"></i></button>
                    </form> 
                </div>
            </div>
        </nav>
        <div style="margin-top: 10px; margin-left: 10px">
            <c:choose>
                <c:when test="${accept==null}">
                    <a style="font-size: 20px" href="<c:url value="/login/index.do"/>" class="btn btn-outline-dark"><i class="bi bi-person-rolodex"></i> Login</a>
                    <a style="font-size: 20px" href="<c:url value="/login/create.do"/>" class="btn btn-outline-dark"><i class="bi bi-person-plus-fill"></i> Register</a>
                </c:when>
                <c:otherwise>
                    <b style="color: black" style="font-size: 20px">    Welcome ${accept.username}</b>
                    <a style="font-size: 20px" href="<c:url value="/login/logout.do"/>" class="btn btn-outline-dark"><i class="bi bi-person-dash-fill"></i> Logout</a>
                </c:otherwise>
            </c:choose>

        </div>
        <a style="font-size: 20px;
           margin-top: 5px;
           margin-right: 40px;
           float: right;
           text-decoration: underline;
           text-decoration: none" href="<c:url value="/cart/index.do"/>" class="btn btn-dark"><i class="bi bi-cart"></i> ${cart==null?0:cart.numOfProducts}</a><br><br>
        <hr>
        <div class="row content py-3">
            <div class="col">
                <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" />
            </div>
        </div>
        <!--footer-->
        <div class="row footer" style="background-color: black; color: white">
            <div class="col" style="text-align: center">
                <br/>
                &copy; Copyright by team 2 class SE1608. Do not reup.
                <br/>
                <br/>
            </div>
        </div>
    </div>        
</body>
</html>