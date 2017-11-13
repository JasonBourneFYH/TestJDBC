package charpter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test1 {
	 public static final String URL = "jdbc:oracle:thin:@localhost:1521/XE";
	 public static final String USER = "test2";
	 public static final String PASSWORD = "test2";
	public static void main(String[] args) throws Exception {

//		// 1.加载驱动程序
//		// Class.forName("com.mysql.jdbc.Driver");
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		// 2. 获得数据库连接
//		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//		// 3.操作数据库，实现增删改查
//		Statement stmt = conn.createStatement();

		 try {  
	           Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();  
	           Object c = DriverManager.getConnection(URL, USER,PASSWORD);  
	           Statement stmt = ((Connection) c).createStatement();
//	       	ResultSet rs = stmt.executeQuery("SELECT sno FROM sc where cno=4");
	       	ResultSet rs = stmt.executeQuery("drop user scott cascade");
	        
	       	/**
	       	 * executeUpdate
	       	 * executeInsert
	       	 * executeDelete
	       	 *
	       	 */
	       	while (rs.next()) {
				System.out.println(" sno ：" + rs.getInt("sno"));
			}
	       } catch (Exception e) {  
	           e.printStackTrace();  
	       }  
		
//		ResultSet rs = stmt.executeQuery("SELECT sno FROM sc");
		// 如果有数据，rs.next()返回true
//		while (rs.next()) {
//			System.out.println(rs.getString("user_name") + " 年龄：" + rs.getInt("sno"));
//		}

	}

}
