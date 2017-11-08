package com.chf.action;

public class GreetAdapterImp implements GreetAdapter {

    private GreetLanguage greetLanguage = new GreetLanguage();

    @Override
    public String GreetEnglishShow(Integer role){
        return greetLanguage.greetEnglish(role);
    }

    @Override
    public String GreetChineseShow(Integer role){
        return greetLanguage.greetChinese(role);
    }
}
 