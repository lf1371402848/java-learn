import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class DBUtils {
	
	private static Connection connection = getConnection();
	
	// 获取连接
	public static Connection getConnection() {
		// 1.注册驱动
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2.创建连接
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "test", "test");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 6.关闭资源
	public static void closeAll(AutoCloseable... closeables) {
		for (AutoCloseable autoCloseable : closeables) {
			try {
				if (autoCloseable != null) {
					autoCloseable.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	// 3.创建Statement对象 4.执行dml操作
	public static int excecuteDML(String sql, Object[] para) {
		PreparedStatement pStatement = null;
		int result_num = 0;
		try {
			pStatement = connection.prepareStatement(sql);
			for (int i = 0; i < para.length; i++) {
				pStatement.setObject(i+1, para[i]);
			}
			result_num = pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(pStatement,connection);
		}
		return result_num;
	}
}
