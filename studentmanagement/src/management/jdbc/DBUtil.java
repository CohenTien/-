package management.jdbc;


import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//数据库连接工具类
public class DBUtil {
	private static String driver; // 数据库连接驱动
	private static String url;
	private static String username;
	private static String password;

	static {
		Properties prop = new Properties();
		try {
			Reader in = new FileReader("src\\config.properties");
			prop.load(in);
			// System.out.println("数据库配置文件config读取中");
		} catch (Exception e) {
			System.out.println("数据库配置文件config读取失败");
			e.printStackTrace();
		}

		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");

		// driver="com.mysql.cj.jdbc.Driver";
		// url="jdbc:mysql://localhost:3306/student?serverTimezone=UTC";//协议名，子协议，IP，端口，库名
		// username="root";
		// password="201711143011";
	}

	public static Connection open() { // 数据库 连接建立方法
		try {
			Class.forName(driver); // 驱动
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn) { // 关闭数据库连接
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

}