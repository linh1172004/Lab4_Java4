<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý User - Lab 2</title>
    <style>
        body { font-family: sans-serif; }
        .container { width: 60%; margin: 20px auto; border: 1px solid #ddd; padding: 20px; border-radius: 5px; }
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 100px; font-weight: bold; }
        input[type="text"], input[type="password"], input[type="email"] { width: 300px; padding: 5px; }
        .btn { padding: 8px 15px; cursor: pointer; background: #eee; border: 1px solid #ccc; border-radius: 3px; }
        .btn:hover { background: #ddd; }
        table { width: 100%; border-collapse: collapse; margin-top: 30px; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background-color: #f4f4f4; }
        .message { color: red; font-weight: bold; margin-bottom: 15px; }
    </style>
</head>
<body>
<div class="container">
    <h2>QUẢN LÝ USER</h2>

    <div class="message">${message}</div>

    <form action="${pageContext.request.contextPath}/user/crud/index" method="post">
        <div class="form-group">
            <label>ID:</label>
            <input type="text" name="id" value="${user.id}">
        </div>
        <div class="form-group">
            <label>Password:</label>
            <input type="password" name="password" value="${user.password}">
        </div>
        <div class="form-group">
            <label>Fullname:</label>
            <input type="text" name="fullname" value="${user.fullname}">
        </div>
        <div class="form-group">
            <label>Email:</label>
            <input type="email" name="email" value="${user.email}">
        </div>
        <div class="form-group">
            <label>Role:</label>
            <input type="radio" name="admin" value="true" ${user.admin ? 'checked' : ''}> Admin
            <input type="radio" name="admin" value="false" ${!user.admin ? 'checked' : ''}> User
        </div>
        <div class="form-group">
            <button class="btn" type="submit" formaction="${pageContext.request.contextPath}/user/crud/create">Create</button>
            <button class="btn" type="submit" formaction="${pageContext.request.contextPath}/user/crud/update">Update</button>
            <button class="btn" type="submit" formaction="${pageContext.request.contextPath}/user/crud/delete">Delete</button>
            <button class="btn" type="submit" formaction="${pageContext.request.contextPath}/user/crud/reset">Reset</button>
        </div>
    </form>

    <hr>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Password</th>
            <th>Fullname</th>
            <th>Email</th>
            <th>Role</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${items}">
            <tr>
                <td>${item.id}</td>
                <td>${item.password}</td>
                <td>${item.fullname}</td>
                <td>${item.email}</td>
                <td>${item.admin ? 'Admin' : 'User'}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/crud/edit/${item.id}">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>