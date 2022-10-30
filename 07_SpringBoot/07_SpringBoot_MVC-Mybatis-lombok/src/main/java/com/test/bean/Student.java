package com.test.bean;

import lombok.Data;

@Data
public class Student {
	private int studId;
	private int sno;
	private String name;
	private int age;

	public Student() {};

	public Student(int sno, String name, int age) {
		this.sno = sno;
		this.name = name;
		this.age = age;
	}

	public Student(int studId, int sno, String name, int age) {
		this.studId = studId;
		this.sno = sno;
		this.name = name;
		this.age = age;
	}
}
