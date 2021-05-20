package com.test.bean;

public class Student {
    private Integer sid;
    private String sname;
    private String fav;
    private Teacher teacher_by_auto;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", fav='" + fav + '\'' +
                ", teacher_by_auto=" + teacher_by_auto +
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

    public Student(Integer sid, String sname, String fav, Teacher teacher_by_auto) {
        this.sid = sid;
        this.sname = sname;
        this.fav = fav;
        this.teacher_by_auto = teacher_by_auto;
    }

    public Teacher getTeacher_by_auto() {
        return teacher_by_auto;
    }

    public void setTeacher_by_auto(Teacher teacher_by_auto) {
        this.teacher_by_auto = teacher_by_auto;
    }

    public Student() {
    }
}
