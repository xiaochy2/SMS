package com.chf.dao;

import com.chf.dao.dbhelp.DBUtil;

import java.sql.ResultSet;

/**
 * Created by Ying on 2017/4/30.
 */
public class CountDao {
    public int addOneVisitor(){
        StringBuffer sql = new StringBuffer();
        int i=0;
        try{
            sql.append("UPDATE count SET times = times+1 WHERE type=1;");
            i = DBUtil.executeUpdateInsertDelete(sql.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return i;
    }
    public Integer amountVisitor(){
        StringBuffer sql = new StringBuffer();
        int count = 0;
        try {
            sql.append("SELECT * FROM count where type='1';");
            ResultSet set = DBUtil.executeQuery(sql.toString());
            while (set.next()){
                count = set.getInt("times");
                break;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return count;
    }
}
