<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/function.css">
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<form action="login.action" class="m-login">
    <div class="m-login-heading">
        <h2>Student Manage System</h2>
    </div>
    <div class="m-login-content">
        <div class="u-username u-input">
            <i class="fa fa-user"></i>
            <input type="text" id="username" name="username" class="small"maxlength="10" required="required" placeholder="UserName" autofocus="autofocus">
        </div>
        <div class="u-password u-input">
            <i class="fa fa-lock"></i>
            <input type="password" id="password" name="password"class="small" maxlength="10" placeholder="Password">
        </div>
        <button type="submit" id="loginBtn">Log in</button>
    </div>
</form>
</body>
</html>