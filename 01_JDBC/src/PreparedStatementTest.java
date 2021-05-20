import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			// 1.注册驱动
			// 2.创建连接
			// 3.创建Statement对象
			// 4.执行sql语句
			String updateSQL = "update Student set name = ?";
			Object[] para = {"lf21"};
			int  result_num = DBUtils.excecuteDML(updateSQL, para);

			// 5.处理结果集
			System.out.println("操作成功" + result_num + '条');

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.关闭资源
			DBUtils.closeAll(resultSet, pStatement, conn);
		}
	}
}
