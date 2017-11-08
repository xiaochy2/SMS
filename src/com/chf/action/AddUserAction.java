package com.chf.action;

import java.util.List;

import com.chf.entity.User;
import com.chf.service.UserService;

import static java.lang.Integer.parseInt;

public class AddUserAction extends Action {
	private static final long serialVersionUID = 4878247652427455524L;
	private UserService userService;
	private String userName;
	private String passWord;
    private String role;
    private String roleId;
	@Override
	public String execute()
	{
		userName=request.getParameter("userName");
		passWord=request.getParameter("password");
        role=request.getParameter("role");
        roleId=request.getParameter("roleId");
		userService=new UserService();
		User auser=new User();
		auser.setUserName(userName);
		auser.setPassword(passWord);
        auser.setRole(parseInt(role));
        auser.setRoleId(parseInt(roleId));
		this.userService.addUser(auser);
        List<User> users=userService.findUsers();
        request.setAttribute("users",users);
        return "updateUsers.jsp";
	}

}
 