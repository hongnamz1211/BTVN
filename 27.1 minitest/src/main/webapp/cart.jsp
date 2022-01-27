<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/27/2022
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>My Cart</h1>
<button class="btn btn-warning"><a href="/home?action=deleteAll">Thanh toán</a></button>
<button class="btn btn-warning"><a href="/home">Quay lại</a></button>
<table class="table table-striped">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${products}" var="pro">
        <tr>
            <td>${pro.getId()}</td>
            <td>${pro.getName()}</td>
            <td>${pro.getPrice()}</td>
            <td>${pro.getQuantity()}</td>
            <td>
                <button class="btn btn-warning"><a href="/home?action=deleteProduct&id=${pro.getId()}">Delete</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
<style>
    table, th, td {
        border: 1px solid black;
        margin-top: 20px;
    }

    th td {
        padding: 10px;
    }
</style>
</html>
