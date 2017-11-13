package cn.icss.stu_sourse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USER = "test2";
	public static final String PASSWORD = "test2";

	public static void select(String a) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();

			// ResultSet rs = null;
			if (a.length() < 5) {
				rs = stmt.executeQuery("SELECT * FROM students");
			} else {
				String aa = "SELECT * FROM students where sno = " + a;
				rs = stmt.executeQuery(aa);
			}
			while (rs.next()) {

				System.out.println("ѧ����� : " + rs.getString("sno") + "\tѧ������ : " + rs.getString("sname") + "\t�ڿν�ʦ : "
						+ rs.getString("steacher") + "\tѧ����¼���� : " + rs.getString("code"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void select2(int x, String a) throws Exception {
		int getx = x;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			switch (getx) {
			// ��ѯ
			case 1:
				if (a.length() < 5) {
					rs = stmt.executeQuery("SELECT * FROM students");
				} else {
					String aa = "SELECT * FROM students where sno = " + a;
					rs = stmt.executeQuery(aa);
				}
				while (rs.next()) {
					if (a.length() < 5) {
						System.out.println("ѧ����� : " + rs.getString("sno") + "\tѧ������ : " + rs.getString("sname")
								+ "\t�ڿν�ʦ : " + rs.getString("steacher"));
					} else {
						System.out.println("ѧ����� : " + rs.getString("sno") + "\tѧ������ : " + rs.getString("sname")
								+ "\t�ڿν�ʦ : " + rs.getString("steacher") + "\tѧ����¼���� : " + rs.getString("code"));
					}
				}
				break;
			//
			case 2:
				if (a.length() < 5) {
					String aa = "delete  FROM students where sno in (select s.sno from students s,";
					aa += "teacher t where s.steacher=t.tname  and tid= " + a + ") ";
					rs = stmt.executeQuery(aa);
				}
				break;
			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void up(String a, String b) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			// ResultSet rs = null;
			if (a.length() < 5) {
				String aa = "update teacher set tpassword = " + b + "  where tid = " + a;
				rs = stmt.executeQuery(aa);
			} else {
				String aa = "update students set code =" + b + " where sno =" + a;
				rs = stmt.executeQuery(aa);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// insert
	public static void in_student(String a, String b, String d, String f) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			String aa = "insert into students (sno,sname,steacher,code) values";
			aa += "( " + a + ", " + b + "," + d + "," + f +  ")";
			rs = stmt.executeQuery(aa);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// 1.��ʦ��� 2.��ʦ���� 3.��ʦ�ڿη��� 4.��ʦ���� 5.��ʦ��¼����
	// *
	// * ѧ����
	// * 1.ѧ����� 2.ѧ������ 3.�ڿν�ʦ 4.ѧ����¼����

	public static void in_teacher(String a, String b, String d, String f, String g) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			String aa = "INSERT INTO teacher(tid, tname,tpassword,tcourse,tlevel) VALUES";
			aa += "( " + a + ", " + b + "," + d + "," + f + "," + g + ")";
			rs = stmt.executeQuery(aa);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
