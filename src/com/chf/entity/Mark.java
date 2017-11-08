package com.chf.entity;

public class Mark
{
    private Integer id;

    private Integer stuId;

    private String stuName;

    private Integer markEng;

    private Integer markMath;

    private Integer markPhy;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuId() { return stuId; }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() { return stuName; }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getMarkEng() {
        return markEng;
    }

    public void setMarkEng(Integer markEng) {
        this.markEng = markEng;
    }

    public Integer getMarkMath() {
        return markMath;
    }

    public void setMarkMath(Integer markMath) {
        this.markMath = markMath;
    }

    public Integer getMarkPhy() { return markPhy; }

    public void setMarkPhy(Integer markPhy) {
        this.markPhy = markPhy;
    }

    public String getState() { return state; }

    public void setState(String state) {
        this.state = state;
    }

}
