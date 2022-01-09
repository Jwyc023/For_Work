<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>展示所有用户</title>
</head>
<body>

    <h1>用户列表</h1>

    <c:forEach items="${requestScope.users}" var="user">
        ${user.id}----${user.name}----${user.age}----<fmt:formatDate value="${user.bir}" pattern="yyyy-MM-dd"/> <br>
    </c:forEach>

</body>
</html>