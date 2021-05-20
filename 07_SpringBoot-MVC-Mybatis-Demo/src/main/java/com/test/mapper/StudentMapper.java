package com.test.mapper;
import com.test.bean.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
	public List<Student> findAllStudents();
}