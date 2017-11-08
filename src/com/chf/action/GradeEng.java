/** 
 * Project Name:MVCDemo 
 * File Name:UpdateUserAction.java 
 * Package Name:com.chf.action 
 * Date:2014年12月17日 上午10:35:40 
 * Copyright (c) 2014, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package com.chf.action;

import com.chf.service.*;

import java.util.List;

public class GradeEng implements Grade {
    private MarkService markService;
    @Override
    public String showGrade(String stuName) {
        String grade;
        String showMark;
        showMark = "English";
        markService=new MarkService();
        grade = markService.findMarkNameByUserName(stuName,showMark);
        return grade;
    }
}
 