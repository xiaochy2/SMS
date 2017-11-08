package com.chf.action;

import com.chf.entity.Mark;
import com.chf.service.MarkService;

import java.util.List;

import static java.lang.Integer.parseInt;

public class AddMarkAction extends Action {
	private static final long serialVersionUID = 4878247652427455524L;
	private MarkService markService;
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

        stuId=request.getParameter("studentId");
        stuName=request.getParameter("studentName");
        english=request.getParameter("english");
        math=request.getParameter("math");
        physics=request.getParameter("physics");
        state="Marked";

		Mark amark=new Mark();
        amark.setStuId(parseInt(stuId));
        amark.setStuName(stuName);
        amark.setMarkEng(parseInt(english));
        amark.setMarkMath(parseInt(math));
        amark.setMarkPhy(parseInt(physics));
        amark.setState(state);
		this.markService.addMark(amark);
        List<Mark> marks=markService.findMark();
        request.setAttribute("marks",marks);
        return "updateMark.jsp";
	}
}
 