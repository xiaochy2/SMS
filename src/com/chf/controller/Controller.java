package com.chf.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chf.action.*;

public class Controller implements Filter
{
    private Action action;
    @Override
    public void destroy()
    {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException
    {
        RequestDispatcher dispatcher=null;
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)res;
        String servletPath=request.getServletPath();
        System.out.println(servletPath);
        String[] pathSplit=servletPath.split("[.]");

        String actionName=pathSplit[0];
        String ext=pathSplit[1];
        System.out.println(actionName+":"+ext);
        if(!ext.equals("action"))
        {
            chain.doFilter(req,res);
        }
        else
        {
            try
            {
                switch(actionName){
                    case "/addUser":{
                        action=new AddUserAction();
                        action.setRequest(request);
                        action.setResponse(response);
                        String result=action.execute();
                        dispatcher=request.getRequestDispatcher(result);
                        dispatcher.forward(request,response);
                        break;
                    }
                    case "/deleteUser":{
                        action=new DeleteUserAction();
                        action.setRequest(request);
                        action.setResponse(response);
                        String result=action.execute();
                        dispatcher=request.getRequestDispatcher(result);
                        dispatcher.forward(request,response);
                        break;
                    }
                    case "/updateUser":{
                        action=new UpdateUserAction();
                        action.setRequest(request);
                        action.setResponse(response);
                        String result=action.execute();
                        dispatcher=request.getRequestDispatcher(result);
                        dispatcher.forward(request,response);
                        break;
                    }
                    case "/login":{
                        action=new LoginAction();
                        action.setRequest(request);
                        action.setResponse(response);
                        String result=action.execute();
                        dispatcher=request.getRequestDispatcher(result);
                        dispatcher.forward(request,response);
                        break;
                    }
                    case "/logout":{
                        action=new LogoutAction();
                        action.setRequest(request);
                        action.setResponse(response);
                        String result=action.execute();
                        dispatcher=request.getRequestDispatcher(result);
                        dispatcher.forward(request,response);
                        break;
                    }
                    case "/viewMark":{
                        action=new ViewMarkAction();
                        action.setRequest(request);
                        action.setResponse(response);
                        String result=action.execute();
                        dispatcher=request.getRequestDispatcher(result);
                        dispatcher.forward(request,response);
                        break;
                    }
                    case "/addMark":{
                        action=new AddMarkAction();
                        action.setRequest(request);
                        action.setResponse(response);
                        String result=action.execute();
                        dispatcher=request.getRequestDispatcher(result);
                        dispatcher.forward(request,response);
                        break;
                    }
                    case "/updateMarkGrade":{
                        action=new UpdateMarkGradeAction();
                        action.setRequest(request);
                        action.setResponse(response);
                        String result=action.execute();
                        dispatcher=request.getRequestDispatcher(result);
                        dispatcher.forward(request,response);
                        break;
                    }
                    case "/deleteMark":{
                        action=new DeleteMarkAction();
                        action.setRequest(request);
                        action.setResponse(response);
                        String result=action.execute();
                        dispatcher=request.getRequestDispatcher(result);
                        dispatcher.forward(request,response);
                        break;
                    }
                    case "/updateMark":{
                        action=new UpdateMarkAction();
                        action.setRequest(request);
                        action.setResponse(response);
                        String result=action.execute();
                        dispatcher=request.getRequestDispatcher(result);
                        dispatcher.forward(request,response);
                        break;
                    }
                    case "/viewUser":{
                        action=new ViewUserAction();
                        action.setRequest(request);
                        action.setResponse(response);
                        String result=action.execute();
                        dispatcher=request.getRequestDispatcher(result);
                        dispatcher.forward(request,response);
                        break;
                    }
                }
            }
            catch(Exception err)
            {
                throw new ServletException(err);
            }
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException
    {
    }
}
