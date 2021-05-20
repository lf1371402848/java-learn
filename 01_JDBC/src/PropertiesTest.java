import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		//写入文件
		prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		prop.setProperty("url", "jdbc:oracle:thin:@127.0.0.1:1521:XE");
		prop.setProperty("username", "test");
		prop.setProperty("password", "test");
		OutputStream os = new FileOutputStream("src/jdbc/jdbc.properties");
		prop.store(os, "jdbc Properties");
		
		//读取文件
		FileInputStream is = new FileInputStream("src/jdbc/jdbc.properties");
		prop.load(is);
		System.out.println(prop);
	}
}
