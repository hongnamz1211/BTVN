<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/26/2022
  Time: 2:09 PM
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
<form class="form-control" action="/home?action=editPost" method="post">
    <label for="id" hidden>ID:
        <input type="text" id="id" name="id" value="${city.getId()}" hidden>
    </label>
    <label for="name">City:
        <input type="text" id="name" name="name" value="${city.getName()}">
    </label>
    <label for="acreage">Acreage:
        <input type="text" id="acreage" name="acreage" value="${city.getAcreage()}">
    </label>
    <label for="population">Population:
        <input type="text" id="population" name="population" value="${city.getPopulation()}">
    </label>
    <label for="GDP">GDP:
        <input type="text" id="GDP" name="GDP" value="${city.getGDP()}">
    </label>
    <label for="country">Country:
        <input type="text" id="country" name="country" value="${city.getCountry()}">
    </label>
    <input type="submit" value="Edit">
</form>
</body>
</html>
