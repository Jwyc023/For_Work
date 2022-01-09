<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>展示所有用户信息</title>
</head>
<body>


    <h1>用户信息</h1>
    <c:forEach items="${requestScope.users}" var="user">
        ${user.id}====${user.name}====${user.age}====${user.bir} <a href="">删除</a> <a href="">修改</a><br>
    </c:forEach>


    <a href="">添加</a>

</body>
</html>