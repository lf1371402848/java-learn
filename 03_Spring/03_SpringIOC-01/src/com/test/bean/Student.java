package com.test.bean;

public class Student {
    private Integer sid;
    private String sname;
    private String fav;
    private Teacher teacher;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", fav='" + fav + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    public Student(Integer sid, String sname, String fav, Teacher teacher) {
        this.sid = sid;
        this.sname = sname;
        this.fav = fav;
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student() {
    }
}
