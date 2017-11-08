package com.chf.dao;

import com.chf.dao.dbhelp.DBUtil;
import com.chf.entity.User;
import com.chf.entity.Mark;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarkDao {

	public int update(Mark mark) {
		StringBuffer sql = new StringBuffer();
		int i = 0;
		try {
			sql.append("UPDATE mark SET stuId='" + mark.getStuId() + "',");
            sql.append("stuName='"+mark.getStuName()+"',");
            sql.append("English='"+mark.getMarkEng()+"',");
            sql.append("Math='"+mark.getMarkMath()+"',");
            sql.append("Physics='"+mark.getMarkPhy()+"',");
            sql.append("state='"+mark.getState()+"'");
            sql.append("WHERE id='" + mark.getId() + "';");

			i = DBUtil.executeUpdateInsertDelete(sql.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return i;
	}

	public int delete(Mark mark) {
		StringBuffer sql = new StringBuffer();

		sql.append("delete from mark where stuName='" + mark.getStuName() + "';");

		return DBUtil.executeUpdateInsertDelete(sql.toString());
	}

    public int insert(Mark mark) {
        StringBuffer sql = new StringBuffer();

        sql.append("insert into mark(stuId,stuName,English,Math,Physics,state)");
        sql.append("values('" + mark.getStuId() + "',");
        sql.append("'" + mark.getStuName() + "',");
        sql.append("'" + mark.getMarkEng() + "',");
        sql.append("'" + mark.getMarkMath() + "',");
        sql.append("'" + mark.getMarkPhy() + "',");
        sql.append("'" + mark.getState() + "');");

        return DBUtil.executeUpdateInsertDelete(sql.toString());
    }

	public String findMarkByUserName(String userName, String showMark) {
		StringBuffer sql = new StringBuffer();
        String grade = null;
		sql.append("select "+showMark+" from mark where stuName='"+userName+"';");

		try {
            ResultSet set = DBUtil.executeQuery(sql.toString());
            while (set.next()) {
                grade=set.getString(showMark);
                break;
            }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        return grade;
	}

    public List<Mark> findMarkAll(){
        List<Mark> list = new ArrayList<Mark>();

        StringBuffer sql=new StringBuffer();
        sql.append("SELECT * FROM mark;");

        try{
            ResultSet set=DBUtil.executeQuery(sql.toString());
            while(set.next()){
                Mark mark=new Mark();
                mark.setId(set.getInt("id"));
                mark.setStuId(set.getInt("stuId"));
                mark.setStuName(set.getString("stuName"));
                mark.setMarkEng(set.getInt("English"));
                mark.setMarkMath(set.getInt("Math"));
                mark.setMarkPhy(set.getInt("Physics"));
                mark.setState(set.getString("state"));

                list.add(mark);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
	
}
