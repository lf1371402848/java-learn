package com.test.service.impl;

import com.test.bean.Student;
import com.test.mapper.StudentMapper;
import com.test.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2022/8/23 23:20
 * @Version: 1.0
 */

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }
}
