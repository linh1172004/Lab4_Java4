<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>ĐĂNG NHẬP (BÀI 2)</h2>
<h3 style="color:red">${message}</h3>
<form action="login" method="post">
    Username/Email: <input name="username" required> <br><br>
    Password: <input type="password" name="password" required> <br><br>
    <button>Login</button>
</form>
</body>
</html>