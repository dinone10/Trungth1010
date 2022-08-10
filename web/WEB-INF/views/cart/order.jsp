<%-- 
    Document   : order
    Created on : Jun 21, 2022, 3:38:10 PM
    Author     : team2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container text-center">
    <h2 class="text-primary">Enter your information</h2>
    <form action="<c:url value="/cart/confirm.do"/>"> 
        <div class="mb-3 mt-3">
            <label for="addressName" class="form-label">Name:</label>
            <input type="text" class="form-control" id="addressName" required placeholder="Enter name" name="addressName" >
        </div>
        <div class="mb-3">
            <label for="addressPhone" class="form-label">Phone:</label>
            <input type="number" class="form-control" id="addressPhone" required placeholder="Enter phone number" name="phone">
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" required placeholder="abc@gmail.com" name="email">
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Address:</label>
            <input type="text" class="form-control" id="address" required placeholder="Enter address" name="address">
        </div>
        <button type="submit" class="btn btn-primary">Buy</button>
    </form>
    ${message}
</div>
