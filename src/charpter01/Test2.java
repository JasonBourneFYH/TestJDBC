package charpter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test2 {
	 public static final String URL = "jdbc:oracle:thin:@192.168.34.42:1521/XE";
	 public static final String USER = "system";
	 public static final String PASSWORD = "orcl";
	public static void main(String[] args) throws Exception {

//		// 1.������������
//		// Class.forName("com.mysql.jdbc.Driver");
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		// 2. ������ݿ�����
//		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//		// 3.�������ݿ⣬ʵ����ɾ�Ĳ�
//		Statement stmt = conn.createStatement();

		 try {  
	           Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();  
	           Object c = DriverManager.getConnection(URL, USER,PASSWORD);  
	           Statement stmt = ((Connection) c).createStatement();
//	       	ResultSet rs = stmt.executeQuery("SELECT sysdate FROM dual");
//	           ResultSet rs = stmt.executeQuery("SELECT emp_pwd FROM myhr.emp");
	           ResultSet rs = stmt.executeQuery(" select username,password from dba_users");
//	           ResultSet rs = stmt.executeQuery("update myhr.emp set emp_pwd=123456");
//	       	ResultSet rs = stmt.executeQuery("drop table emp cascade");
	       
	       	while (rs.next()) {
//				System.out.println(rs.getString(3) +"	" + rs.getInt(4)+"----");
	       		System.out.println(rs.getString(1)+"\t\t"+rs.getString(2));
			}
	       } catch (Exception e) {  
	           e.printStackTrace();  
	       }  
		
//		ResultSet rs = stmt.executeQuery("SELECT sno FROM sc");
		// ��������ݣ�rs.next()����true
//		while (rs.next()) {
//			System.out.println(rs.getString("user_name") + " ���䣺" + rs.getInt("sno"));
//		}

	}

}
