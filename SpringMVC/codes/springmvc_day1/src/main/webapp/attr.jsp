<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>测试数据传递</title>
</head>
<body>


    <h1>用来测试request作用域数据传递</h1>
    <h3>获取request作用域数据:${requestScope.username}</h3>
    <h3>获取request作用域数据:${username}</h3>
    <hr color="red">
    <h3>id:${requestScope.user.id}</h3>
    <h3>name:${requestScope.user.name}</h3>
    <h3>age:${requestScope.user.age}</h3>
    <h3>bir: <fmt:formatDate value="${requestScope.user.bir}" pattern="yyyy-MM-dd"/></h3>
    <hr color="red">
    <c:forEach items="${requestScope.users}" var="user">
        id:${user.id} === ${user.name} === ${user.age} === <fmt:formatDate value="${user.bir}"/> <br>
    </c:forEach>

    <hr color="green">
    <h3>获取地址栏数据:${param.name}</h3>
    <h3>id:${sessionScope.user.id}</h3>
    <h3>name:${sessionScope.user.name}</h3>
    <h3>age:${sessionScope.user.age}</h3>
    <h3>bir:${sessionScope.user.bir}</h3>
</body>
</html>
