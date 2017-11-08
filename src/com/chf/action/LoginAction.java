package com.chf.action;

import java.util.List;

import com.chf.entity.Mark;
import com.chf.entity.User;

import com.chf.service.MarkService;
import com.chf.service.UserService;
import com.chf.service.CountService;

import javax.servlet.http.HttpSession;

public class LoginAction extends Action {
    private static final long serialVersionUID = 4878247652427455524L;
    private UserService userService;
    private MarkService markService;
    private CountService countService;
    private String userName;
    private String passWord;
    private String language;
    private String roleLan;
    private Integer role;

    @Override
    public String execute()
    {
        HttpSession session = request.getSession();
        userName=request.getParameter("username");
        passWord=request.getParameter("password");

        userService=new UserService();
        markService=new MarkService();

        List<Mark> marks=markService.findMark();
        
        request.setAttribute("marks",marks);
        User luser=new User();
        luser=this.userService.findUserByUserName(userName);

        session.setAttribute("UserName",luser.getUserName());
        session.setAttribute("Role",luser.getRole());

        role=luser.getRole();
        language="English";

        //show greet[adapter pattern,factory pattern]
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

        if(luser!=null){
            if((luser.getPassword()).equals(passWord)){
                countService = CountService.getInstance();
                String number = countService.getNumber().toString();
                request.setAttribute("numVisit",number);
                return "viewMark.jsp";
            }
        }
        return "fail.jsp";
    }
}
 