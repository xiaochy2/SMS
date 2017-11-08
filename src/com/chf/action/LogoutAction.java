package com.chf.action;

import com.chf.service.CountService;

import javax.servlet.http.HttpSession;

public class LogoutAction extends Action {
    private static final long serialVersionUID = 4878247652427455524L;
    private CountService countService;
    @Override
    public String execute()
    {
        HttpSession session = request.getSession();
        session.removeAttribute("UserName");
        session.invalidate();

        countService.releaseInstance();

        return "logout.jsp";
    }
}
 