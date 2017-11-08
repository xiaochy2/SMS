package com.chf.action;

public class GreetFactory {
    //use getShow method to get greet type
    public static Greet getShow(Integer roleId){
        if(roleId == null){
            return null;
        }
        if(roleId==0){
            return new GreetStu();

        } else if(roleId==1){
            return new GreetTea();

        } else if(roleId==2){
            return new GreetAdm();
        }
        return null;
    }
}
 