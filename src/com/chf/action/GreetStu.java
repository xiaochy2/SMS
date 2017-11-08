package com.chf.action;

public class GreetStu implements Greet {
    @Override
    public String show(String language) {
        if (language.equalsIgnoreCase("English")){
            return "Welcome! You are student!";
        }
        else if(language.equalsIgnoreCase("Chinese")){
            return "欢迎您!您是学生!";
        }
        return null;
    }
}
 