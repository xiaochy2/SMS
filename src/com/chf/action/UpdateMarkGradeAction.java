package com.chf.action;

import com.chf.entity.Mark;
import com.chf.service.MarkService;

import java.util.List;

import static java.lang.Integer.parseInt;

public class UpdateMarkGradeAction extends Action {
	private static final long serialVersionUID = 4878247652427455524L;
    private MarkService markService;
    private String markId;
    private String stuId;
    private String stuName;
    private String english;
    private String math;
    private String physics;
    private String state;
	@Override
	public String execute()
	{
        markService=new MarkService();

        markId=request.getParameter("markId");
        stuId=request.getParameter("studentId");
        stuName=request.getParameter("studentName");
        english=request.getParameter("english");
        math=request.getParameter("math");
        physics=request.getParameter("physics");
        state="Marked";


        Mark amark=new Mark();
        amark.setId(parseInt(markId));
        amark.setStuId(parseInt(stuId));
        amark.setStuName(stuName);
        amark.setMarkEng(parseInt(english));
        amark.setMarkMath(parseInt(math));
        amark.setMarkPhy(parseInt(physics));
        amark.setState(state);
        this.markService.updateMark(amark);
        List<Mark> marks=markService.findMark();
        request.setAttribute("marks",marks);
        return "updateMark.jsp";
	}
}
 