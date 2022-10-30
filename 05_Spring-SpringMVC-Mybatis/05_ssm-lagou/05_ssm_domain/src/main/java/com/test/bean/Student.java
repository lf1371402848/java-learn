package com.test.bean;

import java.io.Serializable;

public class Student implements Serializable {
	private int sid;
	private int sno;
	private String name;
	private int age;

	@Override
	public String toString() {
		return "Student{" +
				"sid=" + sid +
				", sno=" + sno +
				", name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	public Student() {};

	public Student(int sno, String name, int age) {
		this.sno = sno;
		this.name = name;
		this.age = age;
	}

	public Student(int sid, int sno, String name, int age) {
		this.sid = sid;
		this.sno = sno;
		this.name = name;
		this.age = age;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
