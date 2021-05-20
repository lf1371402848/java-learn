import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) throws ClassNotFoundException {

		// 1.注册驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try (
				// 2.创建连接
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "test", "test");
				// 3.创建Statement对象
				PreparedStatement pStatement = conn.prepareStatement("select * from Student");
				// 4.执行sql语句
				ResultSet resultSet = pStatement.executeQuery();){
			
			// 5.处理结果集
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getInt(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
