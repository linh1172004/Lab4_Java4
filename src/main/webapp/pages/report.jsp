<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Bài 4 - Thống kê</title>
    <style>table, th, td { border: 1px solid black; border-collapse: collapse; padding: 10px; }</style>
</head>
<body>
<h2>THỐNG KÊ LƯỢT CHIA SẺ (SHARE)</h2>
<table>
    <tr>
        <th>Tiêu đề Video</th>
        <th>Số lượt Share</th>
        <th>Ngày Share đầu</th>
        <th>Ngày Share cuối</th>
    </tr>
    <c:forEach var="row" items="${items}">
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
            <td>${row[2]}</td>
            <td>${row[3]}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>