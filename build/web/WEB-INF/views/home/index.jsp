<%-- 
    Document   : index
    Created on : Jun 1, 2022, 4:40:00 PM
    Author     : team2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <div class="row">
        <c:forEach var="product" items="${list}">
            <div class="col-sm-4">
                <div class=" border rounded p-1 m-1">
                    <form action="<c:url value="/cart/add.do"/>"> 
                        <img src="<c:url value="/products/${product.id}.jpg"/>" width="100%"/>
                        <input type="hidden" value="${product.id}" name="id">   
                        <h4 class="text-center">${product.name}<br/></h4>
                        <strike><fmt:formatNumber value="${product.price}" type="currency"/></strike>
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
                        Quantity: <input type="number" value="1" min="1" name="quantity" style="width: 80px;margin-top: 5px;"/><br/>
                        <button type="submit" class="btn btn-outline-danger btn-lg" style="margin-left: 170px; margin-top: 5px;"><i class="bi bi-cart-plus-fill"></i></button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
    <c:choose>
        <c:when test="${find==null}">
            <div class="col" style="text-align: right;">
                <br/>
                <form action="<c:url value="/home/index.do" />">
                    <button type="submit" class="btn btn-link" name="op" value="FirstPage" title="First Page" <c:if test="${page==1}">disabled</c:if>><i class="bi bi-chevron-bar-left"></i></button>
                    <button type="submit" class="btn btn-link" name="op" value="PreviousPage" title="Previous Page" <c:if test="${page==1}">disabled</c:if>><i class="bi bi-chevron-left"></i></button>
                    <button type="submit" class="btn btn-link" name="op" value="NextPage" title="Next Page" <c:if test="${page==totalPage}">disabled</c:if>><i class="bi bi-chevron-right"></i></button>
                    <button type="submit" class="btn btn-link" name="op" value="LastPage" title="Last Page" <c:if test="${page==totalPage}">disabled</c:if>><i class="bi bi-chevron-bar-right"></i></button>
                    <input type="text" name="gotoPage" value="${page}" class="btn btn-sm btn-outline-default" style="text-align: right;width: 32px;" title="Enter page number"/>
                    <button type="submit" class="btn btn-link" name="op" value="GotoPage" title="Goto Page"><i class="bi bi-arrow-up-right-circle"></i></button>
                </form>
                Page ${page}/${totalPage}
            </div>
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
</div>
