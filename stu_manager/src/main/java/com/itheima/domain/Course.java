package com.itheima.domain;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable{
    private int cno        ;//int(6)
    private String cname      ;//varchar(20)
    private String cTeacher   ;//varchar(10)
    private String ccredit    ;//varchar(4)
    private String cmaxcount  ;//varchar(4)

    /**
     * 选修该课程的所有学生（一对多）
     */
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getcTeacher() {
        return cTeacher;
    }

    public void setcTeacher(String cTeacher) {
        this.cTeacher = cTeacher;
    }

    public String getCcredit() {
        return ccredit;
    }

    public void setCcredit(String ccredit) {
        this.ccredit = ccredit;
    }

    public String getCmaxcount() {
        return cmaxcount;
    }

    public void setCmaxcount(String cmaxcount) {
        this.cmaxcount = cmaxcount;
    }

}
