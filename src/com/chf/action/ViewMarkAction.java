package com.chf.action;

import com.chf.entity.User;
import com.chf.service.CountService;
import com.chf.service.UserService;
import com.chf.entity.Mark;
import com.chf.service.MarkService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ViewMarkAction extends Action {
	private static final long serialVersionUID = 4878247652427455524L;
	private UserService userService;
    private MarkService markService;
	private String userName;
    private String[] subject;
    private String showMark;
    private String stuName;
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

        role=user.getRole();

        request.setAttribute("marks",marks);

        stuName=request.getParameter("stuName");
        subject=request.getParameterValues("subject");
        language=request.getParameter("language");
        if (language==null){
            language="English";
        }
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

        //search grade[composite pattern]
        ShowingGrade showing = new ShowingGrade();
        Grade english = new GradeEng();
        Grade math = new GradeMath();
        Grade physics = new GradePhy();
        if (subject!=null){
            for(int i=0;i<subject.length;i++) {
                switch (subject[i]) {
                    case "english": {
                        showing.add(english);
                        break;
                    }
                    case "math": {
                        showing.add(math);
                        break;
                    }
                    case "physics": {
                        showing.add(physics);
                        break;
                    }
                }
            }
        }
        else{
            showing.add(english);
            showing.add(math);
            showing.add(physics);
        }
        showMark = showing.showGrade(stuName);
        request.setAttribute("grade",showMark);

        //show different page according to different role[strategy pattern]
        if(user.getRole()==2||user.getRole()==1||user.getRole()==0){
            CountService countService = CountService.getInstance();
            String number = countService.getNumber().toString();
            request.setAttribute("numVisit",number);
            return "viewMark.jsp";
        }
        return "noPriviledge.jsp";
	}
}
 