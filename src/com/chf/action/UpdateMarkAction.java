package com.chf.action;

import com.chf.entity.Mark;
import com.chf.entity.User;
import com.chf.service.CountService;
import com.chf.service.MarkService;
import com.chf.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UpdateMarkAction extends Action {
	private static final long serialVersionUID = 4878247652427455524L;
	private UserService userService;
    private MarkService markService;
	private String userName;
    private Integer NumOfUnmark=0;
    private Integer NumOfMarked=0;
    private String language;
    private Integer role;
    private String roleLan;
	@Override
	public String execute()
	{
        HttpSession session = request.getSession();
        userName= (String) session.getAttribute("UserName");
        userService=new UserService();
        markService=new MarkService();
        User user=new User();
        user=this.userService.findUserByUserName(userName);
        List<Mark> marks=markService.findMark();

        //state pattern
        for(int i=0;i<marks.size();i++){
            if (marks.get(i).getState().equalsIgnoreCase("unmark")){
                NumOfUnmark++;
            }
            else if(marks.get(i).getState().equalsIgnoreCase("marked")){
                NumOfMarked++;
            }
        }

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

        request.setAttribute("marks",marks);
        request.setAttribute("NumOfUnmark",NumOfUnmark);
        request.setAttribute("NumOfMarked",NumOfMarked);

        if(user.getRole()==2||user.getRole()==1){
            CountService countService = CountService.getInstance();
            String number = countService.getNumber().toString();
            request.setAttribute("numVisit",number);
            return "updateMark.jsp";
        }
        return "noPriviledge.jsp";
	}
}
 