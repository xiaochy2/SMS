package com.chf.action;

import com.chf.entity.Mark;
import com.chf.service.MarkService;

import java.util.List;


public class DeleteMarkAction extends Action{
	private static final long serialVersionUID = 4878247652427455524L;
	private MarkService markService;
	private String stuName;

	@Override
	public String execute()
	{
        stuName = request.getParameter("stuName");
		markService=new MarkService();
		Mark dmark=new Mark();
		dmark.setStuName(stuName);
		this.markService.deleteMark(dmark);
        List<Mark> marks=markService.findMark();
        request.setAttribute("marks",marks);
        return "updateMark.jsp";
	}
}
 