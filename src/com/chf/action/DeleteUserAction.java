package com.chf.action;

import com.chf.entity.User;
import com.chf.service.UserService;
import static java.lang.Integer.parseInt;

import java.util.List;

public class DeleteUserAction extends Action{
	private static final long serialVersionUID = 4878247652427455524L;
	private UserService userService;
	private String userName;
    private String role;
	@Override
	public String execute()
	{
        userName = request.getParameter("userName");
        role = request.getParameter("role");

		userService=new UserService();
		User duser=new User();

        duser.setUserName(userName);

        if(role!=null){
            duser.setRole(parseInt(role));
            this.userService.deleteUser(duser);
        }

        List<User> users=userService.findUsers();
        request.setAttribute("users",users);

        return "updateUsers.jsp";
	}
}
 