package com.test.service;

import com.test.bean.Student;
import com.test.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional//事务控制,整合了SpringAop处理事务
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAllStudents() {
        List<Student> list = studentMapper.findAllStudents();
        return list;
    }
}
