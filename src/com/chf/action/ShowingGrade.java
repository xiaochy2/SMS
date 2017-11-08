package com.chf.action;

import java.util.ArrayList;
import java.util.List;

public class ShowingGrade implements Grade {
    private List<Grade> grades = new ArrayList<Grade>();
    private String grade1;
    private String grade2;
    private String grade3;

    @Override
    public String showGrade(String stuName) {
        for(int i=0;i<grades.size();i++) {
            switch (grades.size()) {
                case 1: {
                    grade1=grades.get(0).showGrade(stuName);
                    break;
                }
                case 2: {
                    grade1=grades.get(0).showGrade(stuName);
                    grade2=grades.get(1).showGrade(stuName);
                    break;
                }
                case 3: {
                    grade1=grades.get(0).showGrade(stuName);
                    grade2=grades.get(1).showGrade(stuName);
                    grade3=grades.get(2).showGrade(stuName);
                    break;
                }
            }
        }
        if(grades.size()==1){
            return grade1;
        }
        else if(grades.size()==2){
            return grade1+","+grade2;
        }
        else{
            return grade1+","+grade2+","+grade3;
        }
    }

    public void add(Grade g){
        this.grades.add(g);
    }

    public void remove(Grade g){
        grades.remove(g);
    }

    public void clear(){
        System.out.println("Clearing all the subjects from ShowingGrade");
        this.grades.clear();
    }
}

 