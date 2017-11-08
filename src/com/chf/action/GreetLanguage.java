package com.chf.action;

public class GreetLanguage {
    private String greetRoleL;

    GreetFactory greetFactory = new GreetFactory();

    public String greetEnglish(Integer role){
        greetRoleL=greetFactory.getShow(role).show("English");
        return greetRoleL;
    }
    public String greetChinese(Integer role){
        greetRoleL=greetFactory.getShow(role).show("Chinese");
        return greetRoleL;
    }
}
 