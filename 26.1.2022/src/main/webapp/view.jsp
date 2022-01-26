<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/26/2022
  Time: 11:34 AM
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
<h1>City</h1>
<c:if test="cities.isEmpty()">
    <p>Không có thành phố nào</p>
</c:if>
<br>
<button class="btn btn-warning"><a href="/home?action=createGet">Thêm thành phố</a></button>
<button class="btn btn-warning"><a href="/home?action=sort">Sắp xếp theo diện tích</a></button>
<br>
<table class="table table-striped">
    <tr>
        <th>Id</th>
        <th>City
            <form action="/home?action=search" method="post">
                <select name="city" id="city">
                    <c:forEach items="${cities}" var="city">
                        <option name="city-select">${city.getName()}</option>
                    </c:forEach>
                </select>
            </form>
        </th>
        <th>Acreage</th>
        <th>Population</th>
        <th>GDP</th>
        <th>Country</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach items="${cities}" var="city">
        <tr>
            <td>${city.getId()}</td>
            <td>
                <a href="${city.getName()}">${city.getName()}</a>
<%--                    ${city.getName()}--%>
            </td>
            <td>${city.getAcreage()}</td>
            <c:if test="${city.getPopulation() <= '1000000' }">
                <td style="color: red">${city.getPopulation()}</td>
            </c:if>
            <c:if test="${city.getPopulation() > '1000000' }">
                <td style="color: black">${city.getPopulation()}</td>
            </c:if>

            <c:choose>
                <c:when test="${city.getGDP() <= '10000000'}">
                    <td style="color: red">${city.getGDP()}</td>
                </c:when>
                <c:when test="${city.getGDP() > '10000000'}">
                    <td style="color: black">${city.getGDP()}</td>
                </c:when>
            </c:choose>

            <td>${city.getCountry()}</td>
            <td>
                <a href="/home?action=delete&id=${city.getId()}">Xóa</a>
            </td>
            <td>
                <a href="/home?action=editGet&id=${city.getId()}">Sửa</a>
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
