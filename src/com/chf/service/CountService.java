package com.chf.service;
import com.chf.dao.CountDao;
/**
 * Created by Ying on 2017/4/30.
 */
public class CountService {
    private static CountService instance = null;

    private CountService(){}

    public static CountService getInstance(){
        CountDao countDao = new CountDao();
        if(instance == null){
            countDao.addOneVisitor();
            instance = new CountService();
        }
        countDao.amountVisitor();
        return instance;
    }
    public Integer getNumber(){
        CountDao countDao = new CountDao();
        Integer totalVisitor = countDao.amountVisitor();
        return totalVisitor;
    }

    public static  CountService releaseInstance(){
        instance = null;
        return instance;
    }
}
