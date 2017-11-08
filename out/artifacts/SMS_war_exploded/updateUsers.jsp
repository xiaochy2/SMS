<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>更新用户口令</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<jsp:include page="commonUI.jsp" />
<div class="g-content">
    <h2 class="content-title">Update Users</h2>
    <div class="opeBtns">
        <a href="#" id="addUser">Add</a>
        <a href="deleteUser.action" id="delUser">Delete</a>
        <a href="#" id="updateUser">Update</a>
    </div>
    <table class="resultsTable sortable">
        <tr>
            <th></th>
            <th hidden>UserId</th>
            <th>UserName</th>
            <th>Password</th>
            <th>role</th>
            <th>roleId</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><input type="checkbox" value=${user.userName}></td>
                <td hidden class="tdUsrId">${user.id}</td>
                <td class="tdUsrName">${user.userName}</td>
                <td class="tdPwd">${user.password}</td>
                <td class="tdRole">${user.role}</td>
                <td class="tdRoleId">${user.roleId}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="addMsg-popover theme-popover">
        <div class="theme-poptit">
            <a href="javascript:void(0);" title="关闭" class="popclose"><i class="fa fa-times fa-2x"></i></a>
            <h3>Add User</h3>
        </div>
        <div class="theme-popbod dform m-pop">
            <form action="addUser.action" method="post" id="msgForm">
                <div class="msgInp">
                    <label for="userName">UserName</label>
                    <input type="text" id="userName" name="userName" placeholder="UserName" required="required" maxlength="50">
                </div>
                <div class="msgInp">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" placeholder="Password" required="required" maxlength="50">
                </div>
                <div class="msgInp">
                    <label for="role">Role</label>
                    <%--<input type="text" id="role" name="role" placeholder="Role" required="required" maxlength="50">--%>
                    <select name="role" id="role">
                        <option value="0" selected>0 Student</option>
                        <option value="1">1 Teacher</option>
                        <option value="2">2 Manager</option>
                    </select>
                </div>
                <div class="msgInp">
                    <label for="roleId">RoleID</label>
                    <input type="text" id="roleId" name="roleId" placeholder="RoleId" required="required" maxlength="50">
                </div>
                <div class="msgBtns">
                    <button type="submit" id="msgSub" class="subBtn">Submit</button>
                    <button type="button" id="msgCancel" class="cancelBtn">Cancel</button>
                </div>
            </form>
        </div>
    </div>
    <div class="updateMsg-popover theme-popover">
        <div class="theme-poptit">
            <a href="javascript:void(0);" title="关闭" class="popclose"><i class="fa fa-times fa-2x"></i></a>
            <h3>Update User</h3>
        </div>
        <div class="theme-popbod dform m-pop">
            <form action="updateUser.action" method="post" id="updateForm">
                <div class="msgInp" hidden>
                    <label for="userId">UserId</label>
                    <input type="text" id="userId" name="userId" placeholder="userId" required="required" maxlength="50">
                </div>
                <div class="msgInp">
                    <label for="updateuserName">UserName</label>
                    <input type="text" id="updateuserName" name="userName" placeholder="UserName" required="required" maxlength="50">
                </div>
                <div class="msgInp">
                    <label for="updatepassword">Password</label>
                    <input type="text" id="updatepassword" name="password" placeholder="Password" required="required" maxlength="50">
                </div>
                <div class="msgInp">
                    <label for="updaterole">Role</label>
                    <%--<input type="text" id="role" name="role" placeholder="Role" required="required" maxlength="50">--%>
                    <select name="role" id="updaterole">
                        <option value="0">0 Student</option>
                        <option value="1">1 Teacher</option>
                        <option value="2">2 Manager</option>
                    </select>
                </div>
                <div class="msgInp">
                    <label for="updateroleId">RoleID</label>
                    <input type="text" id="updateroleId" name="roleId" placeholder="RoleId" required="required" maxlength="50">
                </div>
                <div class="msgBtns">
                    <button type="submit" id="updatemsgSub" class="subBtn">Submit</button>
                    <button type="button" id="updatemsgCancel" class="cancelBtn">Cancel</button>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript" src="js/addUser.js"></script>
    <script type="text/javascript" src="js/updateUser.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#delUser").click(function(){
//                var checkedUserName = [];
//                $.each($("input[type=checkbox]:checked"), function(){
//                    checkedUserName.push($(this).val());
//                });
                if($(".resultsTable input[type=checkbox]").is(":checked")==false){
                    alert("Please choose one record!");
                   $(this).href="#";
                }
                var checkedUserName=$(".resultsTable input[type=checkbox]:checked").val();
                var checkedRole=$(".resultsTable input[type=checkbox]:checked").parents("tr").find(".tdRole").html();
                $.ajax({
                    type: "POST",
                    url: "deleteUser.action",
                    data:{
                        userName: checkedUserName,
                        role:checkedRole
                    },
                    dataType: "json"
                });
            });
        })
    </script>
</div>
</body>
</html>