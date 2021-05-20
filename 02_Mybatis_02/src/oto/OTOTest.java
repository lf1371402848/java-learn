package oto;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import oto.mapper.OtoMapper;
import java.io.IOException;
import java.io.InputStream;

public class OTOTest {
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
		OtoMapper mapper = sqlSession.getMapper(OtoMapper.class);

		//查询
		//mapper.selectStudentWithAddress(1);
		mapper.findStudentsWithAddressById(1);
	}
}
