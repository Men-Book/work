package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginMysql {
	private static String url = "jdbc:mysql://127.0.0.1:3306/oam";
	private  static String name = "OAM";
	private static String pwd = "123456";
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection conn(){
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, name, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
