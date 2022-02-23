<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/25/2022
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create new student</h1>
<form action="${pageContext.request.contextPath}/home?action=createPost" method="post">
    <label for="id">Id:
        <input type="text" id="id" name="id">
    </label>
    <label for="name">Name:
        <input type="text" id="name" name="name">
    </label>
    <label for="age">Tuổi:
        <input type="text" id="age" name="age">
    </label>
    <label for="address">Địa chỉ:
        <input type="text" id="address" name="address">
    </label>
    <label for="avg">Điểm trung bình:
        <input type="text" id="avg" name="avg">
    </label>
    <input type="submit" value="Create">
</form>
</body>
</html>
