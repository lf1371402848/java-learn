
import bean.Student;
import mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestMybatis {
	public static void main(String[] args) {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//动态获得XxxxMapper接口的实现类
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

		//查询
		List<Student> s1 = studentMapper.findAllStudents();
		for (Student s: s1) {
			System.out.println(s);
		}

		//插入
		/*Student s2 = new Student(21945, "测试", 25);
		s2.setPhone(new PhoneNumber("86", "120", "8888888"));
		studentMapper.insertStudent(s2);
		sqlSession.commit();*/

		//更新
		/*s1.setName("测试更新");
		studentMapper.updateStudent(s1);
		sqlSession.commit();*/

		//刪除
		studentMapper.deleteStudentById(2);
		sqlSession.commit();
	}
}
