<%-- 
    Document   : index
    Created on : Jun 3, 2022, 3:33:54 PM
    Author     : team2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table class="table table-striped">
    <thead>
        <tr>
            <th class="text-right">No.</th>
            <th class="text-right">ID.</th>
            <th>Image</th>
            <th>Name</th>
            <th class="text-right">Old Price</th>
            <th class="text-right">Discount</th>
            <th class="text-right">New Price</th>
            <th class="text-right">Size</th>
            <th class="text-right">Quantity</th>
            <th class="text-right">Cost</th>
            <th>Operations</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="item" items="${cart.items}" varStatus="loop">
        <form>
            <tr>
                <td class="text-right">${loop.count}</td>
                <td class="text-right">Item ${item.id}</td>
                <td><img src="<c:url value="/products/${item.id}.jpg"/>" height="60"/></td>
                <td>${item.description}</td>
                <%--<td><fmt:formatNumber value="${item.price}" pattern="$#,##0.00"/></td>--%>
                <td class="text-right"><fmt:formatNumber value="${item.price}" type="currency"/></td>
                <%--<td><fmt:formatNumber value="${item.discount}" pattern="$#%"/></td>--%>
                <td class="text-right"><fmt:formatNumber value="${item.discount}" type="percent"/></td>
                <td class="text-right"><fmt:formatNumber value="${item.newPrice}" type="currency"/></td>
            <input type="hidden" value="${item.size}" name="size" />
            <td class="text-right">${item.size} </td>
            <td class="text-right"><input type="number" min="1" value="${item.quantity}" name="quantity" style="width: 60px"/></td>
            <td class="text-right"><fmt:formatNumber value="${item.cost}" pattern="$#,##0.00"/></td>
            <td>
                <input type="hidden" value="${item.id}" name="id" />
                <!--có 2 cách xử lý 1 form có nhiều nút submit-->
                <button class="btn btn-sm btn-outline-success" type="submit" class="btn btn-link" formaction="<c:url value="/cart/update.do"/>"><i class="bi bi-pencil-square"></i>Update</button> |
                <button class="btn btn-sm btn-outline-danger" type="submit" class="btn btn-link" formaction="<c:url value="/cart/delete.do"/>"><i class="bi bi-x-circle-fill"></i>Delete</button>
            </td>
            </tr>
        </form>
    </c:forEach>
</tbody>
<tfoot>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th>Total</th>
        <th class="text-right"><fmt:formatNumber value="${cart.total}" type="currency"/></th>
            <c:choose>
                <c:when test="${c==0 || cart==null}">
                <th></th>
                </c:when>
                <c:otherwise>
                <th><a class="btn btn-danger shadow" href="<c:url value="/cart/empty.do" />">Empty your cart</a></th>   
                </c:otherwise>
            </c:choose> 
    </tr>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th>VIP</th>
            <c:choose>
                <c:when test="${accept==null}">
                <th class="text-right">0%</th>
                </c:when>
                <c:otherwise>
                <th class="text-right"><fmt:formatNumber value="${accept.discount}" pattern="#,##%"/></th>
                </c:otherwise>
            </c:choose>
        <th></th>   
    </tr>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th>After Discount</th>
            <c:choose>
                <c:when test="${accept==null}">
                <th class="text-right"><fmt:formatNumber value="${cart.total}" type="currency"/></th>
                </c:when>
                <c:otherwise>
                <th class="text-right"><fmt:formatNumber value="${cart.total*(100-accept.discount)/100}" type="currency"/></th>
                </c:otherwise>
            </c:choose>
        <th></th>
    </tr>
    <tr>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
            <c:choose>
                <c:when test="${c==0 || cart==null}">
                <th></th>
                </c:when>
                <c:otherwise>
                <th><a class="btn btn-success" href="<c:url value="/cart/order.do" />">Order</a></th>
                </c:otherwise>
            </c:choose>
    </tr>
</tfoot>
</table>

