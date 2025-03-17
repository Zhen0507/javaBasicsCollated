<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Form</title>
</head>
<body>
    <h1>用户注册</h1>
    <form:form action="/user/submit" method="post" modelAttribute="user">
        <div>
            <label>用户名:</label>
            <form:input path="username" />
        </div>
        <div>
            <label>邮箱:</label>
            <form:input path="email" />
        </div>
        <div>
            <label>年龄:</label>
            <form:input path="age" />
        </div>
        <div>
            <input type="submit" value="提交" />
        </div>
    </form:form>
</body>
</html> 