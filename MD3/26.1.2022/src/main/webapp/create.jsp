<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/26/2022
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create new city</h1>
<form class="form-control" action="/home?action=createPost" method="post">
    <label for="id">Id:
        <input type="text" id="id" name="id">
    </label>
    <label for="name">Name:
        <input type="text" id="name" name="name">
    </label>
    <label for="acreage">Acreage:
        <input type="text" id="acreage" name="acreage">
    </label>
    <label for="population">Population:
        <input type="text" id="population" name="population">
    </label>
    <label for="GDP">GDP:
        <input type="text" id="GDP" name="GDP">
    </label>
    <label for="country">Country:
        <input type="text" id="country" name="country">
    </label>
    <input type="submit" value="Create">
</form>
</body>
</html>
