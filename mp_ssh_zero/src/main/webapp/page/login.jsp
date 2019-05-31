<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户登录</title>
    <base href="<%=request.getContextPath()%>/"/>
</head>
<body>
<form action="login.do" method="post">
    <input type="text" name="username" placeholder="请输入用户名"/> <br>
    <input type="password" name="password" placeholder="请输入密码"/> <br>
    <input type="checkbox" name="rememberMe" />记住我 <br>
    <input type="submit" value="登录" />
</form>
</body>
</html>