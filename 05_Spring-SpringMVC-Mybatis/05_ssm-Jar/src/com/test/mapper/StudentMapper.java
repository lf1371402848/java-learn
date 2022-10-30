package com.test.mapper;
import com.test.bean.Student;

import java.util.List;


public interface StudentMapper {

//	@Select(value = "select * from student")
	public List<Student> findAllStudents();

	public Student findStudentById(int studId);

	public int insertStudent(Student student);

	public int updateStudent(Student student);

	public int deleteStudentById(int studId);
}