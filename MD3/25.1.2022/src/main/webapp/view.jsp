<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/25/2022
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>All Student</h1>
<c:if test="students.isEmpty()">
    <p>Không có sinh viên nào</p>
</c:if>
<br>
<button><a href="/home?action=createGet">Thêm sinh viên</a></button>
<button><a href="/home?action=sort">Sắp xếp theo điểm tăng dần</a></button>
<button><a href="/home?action=great">Sinh viên giỏi</a></button>
<br>
<br>
<form action="/home?action=search" method="post">
    <input type="text" name="search-name">
    <input type="submit" value="Search">
</form>

<table>
    <tr>
        <td>Id</td>
        <td>Tên</td>
        <td>Tuổi</td>
        <td>Địa chỉ</td>
        <td>Điểm trung bình</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.getId()}</td>
            <td>${student.getName()}</td>
            <td>${student.getAge()}</td>
            <td>${student.getAddress()}</td>
            <td>${student.getAvg()}</td>
            <td>
                <a href="/home?action=delete&id=${student.getId()}">Xóa</a>
            </td>
            <td>
                <a href="/home?action=editGet&id=${student.getId()}">Sửa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
