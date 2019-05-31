<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录成功页</title>
    <base href="<%=request.getContextPath()%>/"/>
</head>
<body>
你好，<shiro:principal/>
<br>
<shiro:hasRole name="admin">
    你的角色是：管理员
</shiro:hasRole>
<br>
<a href="logout.do">安全退出</a>
</body>
</html>