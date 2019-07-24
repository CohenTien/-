package management.jdbc;


import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//���ݿ����ӹ�����
public class DBUtil {
	private static String driver; // ���ݿ���������
	private static String url;
	private static String username;
	private static String password;

	static {
		Properties prop = new Properties();
		try {
			Reader in = new FileReader("src\\config.properties");
			prop.load(in);
			// System.out.println("���ݿ������ļ�config��ȡ��");
		} catch (Exception e) {
			System.out.println("���ݿ������ļ�config��ȡʧ��");
			e.printStackTrace();
		}

		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");

		// driver="com.mysql.cj.jdbc.Driver";
		// url="jdbc:mysql://localhost:3306/student?serverTimezone=UTC";//Э��������Э�飬IP���˿ڣ�����
		// username="root";
		// password="201711143011";
	}

	public static Connection open() { // ���ݿ� ���ӽ�������
		try {
			Class.forName(driver); // ����
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

	public static void close(Connection conn) { // �ر����ݿ�����
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

}