S<%-- 
    Document   : shirt
    Created on : Jun 18, 2022, 9:57:13 PM
    Author     : team2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
    <c:forEach var="product" items="${listAll}">
        <c:if test="${product.categoryId==1}">
            <div class="col-sm-4">
                <div class=" border rounded p-1 m-1">
                    <form action="<c:url value="/cart/add.do"/>"/> 
                    <img src="<c:url value="/products/${product.id}.jpg"/>" width="100%"/>
                    <input type="hidden" value="${product.id}" name="id">   
                    Name: ${product.name}<br/>
                    Price: <strike><fmt:formatNumber value="${product.price}" type="currency"/></strike>
                    <span style="color: red; font-size:20px"><fmt:formatNumber value="${product.price*(1-product.discount)}" type="currency"/></span><br/>   
                    Discount:
                    <span class="badge bg-danger text-light"><fmt:formatNumber value="${product.discount}" type="percent"/></span> <br/>
                    Size:  <select id="size" name="size">
                        <option value="S">S</option>
                        <option value="M">M</option>
                        <option value="L">L</option>
                        <option value="XL">XL</option>
                        <option value="XXL">XXL</option>
                    </select><br/>
                    Quantity: <input type="number" class="form-control" value="1" min="1" name="quantity" style="width: 80px;"/><br/>
                    <button type="submit" class="btn btn-sm btn-info"><i class="bi bi-cart">Add to Cart</i></button>
                    </form>
                </div>
            </div>


        </c:if>
    </c:forEach>
</div> 
