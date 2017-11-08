<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<jsp:include page="commonUI.jsp" />
<div class="g-content">
    <a href="toFindUser.action">查找用户</a>
    <a href="toAddUser.action">增加用户</a>
    <a href="toDeleteUser.action">删除用户</a>
    <a href="toUpdateUser.action">更新用户</a>
</div>
</body>
</html>