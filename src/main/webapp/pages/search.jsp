<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Bài 3 - Tìm kiếm</title>
    <style>table, th, td { border: 1px solid black; border-collapse: collapse; padding: 10px; }</style>
</head>
<body>
<h2>TÌM KIẾM VIDEO</h2>
<form action="search" method="post">
    Từ khóa: <input name="keyword" placeholder="Nhập tên video...">
    <button>Tìm</button>
</form>
<hr>
<table>
    <tr><th>ID</th><th>Title</th><th>Views</th></tr>
    <c:forEach var="v" items="${items}">
        <tr>
            <td>${v.id}</td>
            <td>${v.title}</td>
            <td>${v.views}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>