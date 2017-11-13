package charpter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test3 {
	public static final String URL = "jdbc:oracle:thin:@192.168.34.254:1521/XE";
	public static final String USER = "myhr";
	public static final String PASSWORD = "myhr";

	public static void main(String[] args) throws Exception {

		// // 1.������������
		// // Class.forName("com.mysql.jdbc.Driver");
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		// // 2. ������ݿ�����
		// Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		// // 3.�������ݿ⣬ʵ����ɾ�Ĳ�
		// Statement stmt = conn.createStatement();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			Object c = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = ((Connection) c).createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM emp ");
			// ResultSet rs = stmt.executeQuery("drop table emp cascade");

			while (rs.next()) {
				System.out.println(rs.getString(3) + "	" + rs.getInt(4) + "----");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ResultSet rs = stmt.executeQuery("SELECT sno FROM sc");
		// ��������ݣ�rs.next()����true
		// while (rs.next()) {
		// System.out.println(rs.getString("user_name") + " ���䣺" +
		// rs.getInt("sno"));
		// }

	}

}
