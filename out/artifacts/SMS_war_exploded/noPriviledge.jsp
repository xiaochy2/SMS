<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>失败界面</title>
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">
    <style type="text/css">
        body {
            background-color: #eee;
        }

        body, h1, p {
            font-family: "Helvetica Neue", "Segoe UI", Segoe, Helvetica, Arial, "Lucida Grande", sans-serif;
            font-weight: normal;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        .container {
            margin-left:  auto;
            margin-right:  auto;
            margin-top: 177px;
            max-width: 1170px;
            padding-right: 15px;
            padding-left: 15px;
        }

        .row:before, .row:after {
            display: table;
            content: " ";
        }

        .col-md-6 {
            width: 50%;
        }

        .col-md-push-3 {
            margin-left: 25%;
        }

        h1 {
            font-size: 48px;
            font-weight: 300;
            margin: 0 0 20px 0;
        }

        .lead {
            font-size: 21px;
            font-weight: 200;
            margin-bottom: 20px;
        }

        p {
            margin: 0 0 10px;
        }

        a {
            color: #3282e6;
            text-decoration: none;
        }
        .failPage .fa-frown-o{
            color: darkgreen;
            margin-bottom: 20px;
            font-size: 100px;
        }
    </style>
</head>
<body>
<div class="container text-center failPage" id="logout">
    <div class="row">
        <div class="col-md-12">
            <i class="fa fa-frown-o"></i>
            <h1>You have no privilege!</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-push-3">
            <p class="lead"><a href="viewMark.jsp">Return Main Page!</a></p>
        </div>
    </div>
</div>
</body>
</html>