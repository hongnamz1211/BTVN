<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/27/2022
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>All Product</h1>
<button class="btn btn-warning"><a href="/home?action=sortUp">Sắp xếp giá tăng</a></button>
<button class="btn btn-warning"><a href="/home?action=sortDown">Sắp xếp giá giảm</a></button>
<table class="table table-striped">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Description</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${products}" var="pro">
        <tr>
            <td>${pro.getId()}</td>
            <td><a id="name" style="text-decoration: none"
                   href="/home?action=detail&id=${pro.getId()}">${pro.getName()}</a></td>
            <td>${pro.getPrice()}</td>
            <td>${pro.getQuantity()}</td>
            <td>${pro.getDescription()}</td>
            <td>
                <button class="btn btn-warning"><a href="/home?action=createPost&id=${pro.getId()}">Thêm hàng vào giỏ</a>
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
<button class="btn btn-warning"><a href="/home?action=cart">Giỏ hàng của bạn</a></button>
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
