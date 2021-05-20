package com.test.service;
import com.test.bean.Student;

import java.util.List;

/**
 * Created by LuoFeng on 2018/12/8.
 */
public interface IStudentService {
    public List<Student> findAllStudents();
}
