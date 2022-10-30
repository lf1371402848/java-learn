package com.test;

import com.test.bean.Student;
import com.test.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2022/8/15 23:28
 * @Version: 1.0
 */

public class test {

    @Test
    public void test1() throws IOException {
        InputStream as = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(as);
        SqlSession session = factory.openSession();

        System.out.println("-------------存入一级缓存---------------");

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> list = mapper.findAll();

        for (Student student : list) {
            System.out.println(student);
        }

        session.close();
    }

    @Test
    public void test2() throws IOException {
        InputStream as = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(as);
        SqlSession session = factory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.findStuById(1);
        System.out.println(student);
        session.close();
    }

    @Test
    public void test3() throws IOException {
        InputStream as = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(as);
        SqlSession session = factory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.findStuBySnoAndName1(21945, "测试更新");
        System.out.println(student);
        session.close();
    }

    @Test
    public void test4() throws IOException {
        InputStream as = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(as);
        SqlSession session = factory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.findStuBySnoAndName2(21945, "测试更新");
        System.out.println(student);
        session.close();
    }

    @Test
    public void test5() throws IOException {
        InputStream as = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(as);
        SqlSession session = factory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student s = new Student();
        s.setSno(21945);
        s.setName("测试更新");
        Student student = mapper.findStuBySnoAndName3(s);
        System.out.println(student);
        session.close();
    }

    @Test
    public void test6() throws IOException {
        InputStream as = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(as);
        SqlSession session = factory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student s = new Student();
        s.setSid(5);
        s.setSno(21945);
        s.setName("正常一点");
        Student student = mapper.updateStudent(s);
        System.out.println(student);

        session.commit();
        session.close();
    }

    @Test
    public void test7() throws IOException {
        InputStream as = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(as);
        SqlSession session = factory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student s = new Student();
        s.setSid(7);
        s.setSno(21944);
        s.setName("正常一点");
        mapper.insertStudent(s);
        System.out.println(s);

        session.commit();
        session.close();
    }

    @Test
    public void test8() throws IOException {
        InputStream as = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(as);
        SqlSession session = factory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student s = new Student();
        s.setSno(21945);
        Student student = mapper.findStuBySnoAndNameIf(s);
        System.out.println(student);
        session.close();
    }

    @Test
    public void test9() throws IOException {
        InputStream as = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(as);
        SqlSession session = factory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student s = new Student();
        s.setSid(5);
        s.setSno(21945);
        s.setName("正常一点");
        Student student = mapper.updateStudentSet(s);
        System.out.println(student);

        session.commit();
        session.close();
    }
}
