package com.chf.action;

public class GreetAdm implements Greet {
    @Override
    public String show(String language) {
        if (language.equalsIgnoreCase("English")){
            return "Welcome! You are administrator!";
        }
        else if(language.equalsIgnoreCase("Chinese")){
            return "欢迎您!您是管理员!";
        }
        return null;
    }
}
 