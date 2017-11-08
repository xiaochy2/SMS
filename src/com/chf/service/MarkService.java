package com.chf.service;

import com.chf.dao.MarkDao;
import com.chf.entity.Mark;

import java.util.List;

public class MarkService {

    private MarkDao markDao = new MarkDao();

    public List<Mark> findMark()
    {
        List<Mark> list= markDao.findMarkAll();

        return list;
    }

	public String findMarkNameByUserName(String userName, String showMark){
        String grade;
        grade=markDao.findMarkByUserName(userName,showMark);
		return grade;
	}

    public void addMark(Mark amark){
        this.markDao.insert(amark);
    }
    public void deleteMark(Mark dmark){
        this.markDao.delete(dmark);
    }
    public void updateMark(Mark umark){
        this.markDao.update(umark);
    }
}
