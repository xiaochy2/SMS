package com.chf.action;

public class GreetTea implements Greet {
    @Override
    public String show(String language) {
        if (language.equalsIgnoreCase("English")){
            return "Welcome! You are teacher!";
        }
        else if(language.equalsIgnoreCase("Chinese")){
            return "欢迎您!您是老师!";
        }
        return null;
    }
}
 