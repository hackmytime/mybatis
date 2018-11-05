package com.itheima.domain;

import java.util.List;

public class Teacher {
    private int tno      ;//int(4)
    private String tname    ;//varchar(10)
    private String tPasswd  ;//varchar(32)
    private String tSex     ;//varchar(2)
    private String tAge     ;//varchar(4)

    /**
     * 老师和课程一对多关系
     */
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String gettPasswd() {
        return tPasswd;
    }

    public void settPasswd(String tPasswd) {
        this.tPasswd = tPasswd;
    }

    public String gettSex() {
        return tSex;
    }

    public void settSex(String tSex) {
        this.tSex = tSex;
    }

    public String gettAge() {
        return tAge;
    }

    public void settAge(String tAge) {
        this.tAge = tAge;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tno=" + tno +
                ", tname='" + tname + '\'' +
                ", tPasswd='" + tPasswd + '\'' +
                ", tSex='" + tSex + '\'' +
                ", tAge='" + tAge + '\'' +
                '}';
    }
}
