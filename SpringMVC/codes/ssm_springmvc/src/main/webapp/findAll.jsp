<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用来展示所有用户信息</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
    <script>
        $(function(){
            alert();
        })
    </script>
</head>
<body>

    <h1>展示用户列表</h1>
    <c:forEach items="${requestScope.users}" var="user">
        ${user.id} ==== ${user.name} ==== ${user.age} ==== ${user.bir} <br>
    </c:forEach>

    <a href="${pageContext.request.contextPath}/add.jsp">添加用户信息</a>
</body>
</html>