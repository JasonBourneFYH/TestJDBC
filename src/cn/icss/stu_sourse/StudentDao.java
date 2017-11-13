package cn.icss.stu_sourse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	// 学生登录方法
	public List<Student> login(String stu_id, String stu_pass){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Student> student = new ArrayList<Student>();
		try {
			// 加载驱动类
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 通过DriverManager获取连接对象===>getConnection();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "test2", "test2");
			// 编写sql语句
			String sql = "select * from students where sno = ? and code = ?";
			// 通过连接对象获取语句对象
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			pstmt.setString(2, stu_pass);
			// 执行sql语句
			rs = pstmt.executeQuery();
			// 遍历结果集的数据
			while(rs.next()){
				// 将查询到的数据封装到学生对象中
				Student stu = new Student();
				stu.setStu_id(rs.getString(1));
				stu.setStu_pass(rs.getString(3));
				stu.setStu_name(rs.getString(2));
				stu.setTh_id(rs.getString(4));
				student.add(stu);
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
		
		// 将封装好的数据，返回给方法的调用者
		return student;
	}
}
