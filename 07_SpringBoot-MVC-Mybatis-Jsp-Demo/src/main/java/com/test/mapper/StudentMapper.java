package com.test.mapper;

import com.test.bean.Student;

import java.util.List;

public interface StudentMapper {
	public List<Student> findAllStudents();
}