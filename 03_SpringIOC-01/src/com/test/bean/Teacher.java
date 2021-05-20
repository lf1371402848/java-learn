package com.test.bean;

import java.util.Objects;

public class Teacher {
    private Integer tid;
    private String tname;
    private String fav;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", fav='" + fav + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return tid.equals(teacher.tid) && tname.equals(teacher.tname) && fav.equals(teacher.fav);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, tname, fav);
    }

    public Teacher() {
    }

    public Teacher(Integer tid, String tname, String fav) {
        this.tid = tid;
        this.tname = tname;
        this.fav = fav;
    }
}
