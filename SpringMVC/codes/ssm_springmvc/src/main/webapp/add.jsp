<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>添加用户信息</title>
</head>
<body>

    <h1>添加用户信息</h1>
    <form action="${pageContext.request.contextPath}/user/save" method="post">
        姓名:<input type="text" name="name"/> <br>
        年龄:<input type="text" name="age"/> <br>
        生日:<input type="text" name="bir"/> <br>
        <input type="submit" value="保存用户信息">
    </form>
</body>
</html>