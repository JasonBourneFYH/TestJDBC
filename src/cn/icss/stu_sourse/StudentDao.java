package cn.icss.stu_sourse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	// ѧ����¼����
	public List<Student> login(String stu_id, String stu_pass){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Student> student = new ArrayList<Student>();
		try {
			// ����������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ͨ��DriverManager��ȡ���Ӷ���===>getConnection();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "test2", "test2");
			// ��дsql���
			String sql = "select * from students where sno = ? and code = ?";
			// ͨ�����Ӷ����ȡ������
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			pstmt.setString(2, stu_pass);
			// ִ��sql���
			rs = pstmt.executeQuery();
			// ���������������
			while(rs.next()){
				// ����ѯ�������ݷ�װ��ѧ��������
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
		
		// ����װ�õ����ݣ����ظ������ĵ�����
		return student;
	}
}
