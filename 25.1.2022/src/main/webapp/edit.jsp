<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/25/2022
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/home?action=editPost" method="post">
    <label for="id" hidden>ID:
        <input type="text" id="id" name="id" value="${student.getId()}" hidden>
    </label>
    <label for="name">Tên:
        <input type="text" id="name" name="name" value="${student.getName()}">
    </label>
    <label for="age">Tuổi:
        <input type="text" id="age" name="age" value="${student.getAge()}">
    </label>
    <label for="address">Địa chỉ:
        <input type="text" id="address" name="address" value="${student.getAddress()}">
    </label>
    <label for="avg">Điểm trung bình:
        <input type="text" id="avg" name="avg" value="${student.getAvg()}">
    </label>
    <input type="submit" value="Edit">
</form>
</body>
</html>
