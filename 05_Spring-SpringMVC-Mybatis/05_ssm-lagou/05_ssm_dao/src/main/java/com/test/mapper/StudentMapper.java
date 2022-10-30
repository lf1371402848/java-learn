package com.test.mapper;

import com.test.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    public List<Student> findAll();

    public Student findStuById(Integer sid);

    public Student findStuBySnoAndName1(Integer sno,String name);

    public Student findStuBySnoAndName2(@Param("sno") Integer sno, @Param("name") String name);

    public Student findStuBySnoAndName3(Student student);

    public Student findStuBySnoAndNameIf(Student student);

    public Student updateStudent(Student student);

    public Student updateStudentSet(Student student);

    public void insertStudent(Student student);
}
