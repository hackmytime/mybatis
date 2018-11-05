package com.itheima.domain;

import java.util.List;

public class Student {
    private int sno      ;//int(8)
    private String sname    ;//varchar(10)
    private String spasswd  ;//varchar(32)
    private String ssex     ;//varchar(2)
    private String syear    ;//year(4)
    private String spro     ;//varchar(20)
    /**
     * 学生所选课程（1对多）
     */
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpasswd() {
        return spasswd;
    }

    public void setSpasswd(String spasswd) {
        this.spasswd = spasswd;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSyear() {
        return syear;
    }

    public void setSyear(String syear) {
        this.syear = syear;
    }

    public String getSpro() {
        return spro;
    }

    public void setSpro(String spro) {
        this.spro = spro;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", spasswd='" + spasswd + '\'' +
                ", ssex='" + ssex + '\'' +
                ", syear='" + syear + '\'' +
                ", spro='" + spro + '\'' +
                '}';
    }
}
