package charpter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * 1.DriverManager
 * 2.Connection
 * 3.Statement/PreparedStatement
 * 4.ResultSet
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
	
	/**
	 * 
	 * delete
	 * @param args
	 */
	public void del(int id){
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// 加载驱动类
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 通过DriverManager获取连接对象===>getConnection();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "nyhb");
			// 创建sql语句
			String sql = "delete from worker where id=(?)";
			// 通过连接对象获取语句对象===>createStatement();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
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
	
	/**
	 * 
	 * update
	 * @param args
	 */
	public void upa(int id, String name){
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// 加载驱动类
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 通过DriverManager获取连接对象===>getConnection();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "nyhb");
			// 创建sql语句
			String sql = "update worker set name=(?) where id=(?)";
			// 通过连接对象获取语句对象===>createStatement();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(2, id);
			stmt.setString(1, name);
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
	
	public static void main(String[] args) {
		TestJDBC tj = new TestJDBC();
//		tj.add(103, "rose");
//		tj.del(101);
		tj.upa(103,"cccccccccc");
		
	}
}
