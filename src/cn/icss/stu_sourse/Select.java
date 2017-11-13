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

				System.out.println("学生编号 : " + rs.getString("sno") + "\t学生姓名 : " + rs.getString("sname") + "\t授课教师 : "
						+ rs.getString("steacher") + "\t学生登录密码 : " + rs.getString("code"));
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
			// 查询
			case 1:
				if (a.length() < 5) {
					rs = stmt.executeQuery("SELECT * FROM students");
				} else {
					String aa = "SELECT * FROM students where sno = " + a;
					rs = stmt.executeQuery(aa);
				}
				while (rs.next()) {
					if (a.length() < 5) {
						System.out.println("学生编号 : " + rs.getString("sno") + "\t学生姓名 : " + rs.getString("sname")
								+ "\t授课教师 : " + rs.getString("steacher"));
					} else {
						System.out.println("学生编号 : " + rs.getString("sno") + "\t学生姓名 : " + rs.getString("sname")
								+ "\t授课教师 : " + rs.getString("steacher") + "\t学生登录密码 : " + rs.getString("code"));
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

	// 1.教师编号 2.教师姓名 3.教师授课方向 4.教师级别 5.教师登录密码
	// *
	// * 学生表：
	// * 1.学生编号 2.学生姓名 3.授课教师 4.学生登录密码

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
