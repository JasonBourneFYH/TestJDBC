package cn.icss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * 1.DriverManager
 * 2.Connection
 * 3.Statement/PreparedStatement
 * 4.ResultSet
 */

/*
 * 练习：
 * 学生资源管理系统：
 * 教师表：
 * 1.教师编号  2.教师姓名  3.教师授课方向  4.教师级别  5.教师登录密码
 * 
 * 学生表：
 * 1.学生编号  2.学生姓名  3.授课教师  4.学生登录密码
 * 
 * 功能：
 * 1.实现登录：（最多登录3次，如果不成功，就退出该系统）
 * 	教师：可以查看所有学员的信息
 * 	学生：可以查看个人的详细信息
 * 2.退出：
 * 	退出之后可以继续登录
 */
public class TestJDBC {
	// 数据添加
	public void add(int id, String name){
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// 加载驱动类
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 通过DriverManager获取连接对象===>getConnection();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "nyhb");
			// 创建sql语句
			String sql = "insert into worker values (?,?)";
			// 通过连接对象获取语句对象===>createStatement();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, name);
			// 通过语句对象，完成数据库的操作===>插入操作（executeUpdate(sql)）
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null){
					conn.close();
				}
				if(stmt!=null){
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void queryAll(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 加载驱动类
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 通过DriverManager获取连接对象===>getConnection();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "nyhb");
			// 编写sql语句
			String sql = "select * from worker";
			// 通过连接对象获取语句对象
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 执行sql语句
			rs = pstmt.executeQuery();
			// 遍历结果集的数据
			while(rs.next()){
				System.out.println("工人编号：" + rs.getInt(1));
				System.out.println("工人姓名：" + rs.getString(2));
				System.out.println("------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null){
					conn.close();
				}
				if(stmt!=null){
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		TestJDBC tj = new TestJDBC();
//		tj.add(103, "rose");
		tj.queryAll();
	}
}
