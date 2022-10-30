package com.test.service;

import com.test.mapper.StudentMapper;
import com.test.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private StudentMapper studentMapper;

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentMapper.findAllStudents();
    }
}
