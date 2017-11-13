package cn.icss.stu_sourse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {

	public List<Teacher> login(String stu_id, String stu_pass){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Teacher> teacher = new ArrayList<Teacher>();
		try {
			// 加载驱动类
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 通过DriverManager获取连接对象===>getConnection();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "test2", "test2");
			// 编写sql语句
			String sql = "select * from Teacher where tid = ? and tpassword = ?";
			// 通过连接对象获取语句对象
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			pstmt.setString(2, stu_pass);
			// 执行sql语句
			rs = pstmt.executeQuery();
			// 遍历结果集的数据
			while(rs.next()){
				// 将查询到的数据封装到学生对象中
				Teacher tea = new Teacher();
				tea.setTh_id(rs.getString(1));
				tea.setTh_pass(rs.getString(3));
				tea.setTh_course(rs.getString(4));
				tea.setTh_level(rs.getString(5));
				tea.setTh_name(rs.getString(2));
				teacher.add(tea);
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
		return teacher;
	}


}
