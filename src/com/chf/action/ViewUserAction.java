package com.chf.action;

import com.chf.entity.User;
import com.chf.service.CountService;
import com.chf.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ViewUserAction extends Action {
	private static final long serialVersionUID = 4878247652427455524L;
	private UserService userService;
	private String userName;
    private String language;
    private Integer role;
    private String roleLan;
	@Override
	public String execute()
	{
        HttpSession session = request.getSession();
		userName= (String) session.getAttribute("UserName");
		userService=new UserService();
		User user=new User();
        user=this.userService.findUserByUserName(userName);
        List<User> users=userService.findUsers();
        request.setAttribute("users",users);

        //show greet[adapter pattern,factory pattern]
        role=user.getRole();
        language=request.getParameter("language");
        if (language==null){
           language="English";
        }
        GreetAdapter greetAdapter = new GreetAdapterImp();
        if(language!=null){
            if (language.equalsIgnoreCase("Chinese")){
                roleLan=greetAdapter.GreetChineseShow(role);
            }
            else if(language.equalsIgnoreCase("English")){
                roleLan=greetAdapter.GreetEnglishShow(role);
            }
        }
        request.setAttribute("roleLan",roleLan);

        if(user.getRole()==2){
            CountService countService = CountService.getInstance();
            String number = countService.getNumber().toString();
            request.setAttribute("numVisit",number);
            return "updateUsers.jsp";
        }
        return "noPriviledge.jsp";
	}
}
 