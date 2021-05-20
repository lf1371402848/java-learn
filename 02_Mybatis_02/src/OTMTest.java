import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import otm.mapper.OtmMapper;
import oto.mapper.OtoMapper;

import java.io.IOException;
import java.io.InputStream;

public class OTMTest {
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
		OtmMapper mapper = sqlSession.getMapper(OtmMapper.class);

		//查询
		//mapper.selectStudentWithAddress(1);
		mapper.findTutorWithAddressAndCourseById(1);
	}
}
