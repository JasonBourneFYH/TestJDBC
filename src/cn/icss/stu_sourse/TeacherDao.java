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
			// ����������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ͨ��DriverManager��ȡ���Ӷ���===>getConnection();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "test2", "test2");
			// ��дsql���
			String sql = "select * from Teacher where tid = ? and tpassword = ?";
			// ͨ�����Ӷ����ȡ������
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_id);
			pstmt.setString(2, stu_pass);
			// ִ��sql���
			rs = pstmt.executeQuery();
			// ���������������
			while(rs.next()){
				// ����ѯ�������ݷ�װ��ѧ��������
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
		
		// ����װ�õ����ݣ����ظ������ĵ�����
		return teacher;
	}


}
