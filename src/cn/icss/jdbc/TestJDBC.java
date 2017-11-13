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
 * ��ϰ��
 * ѧ����Դ����ϵͳ��
 * ��ʦ��
 * 1.��ʦ���  2.��ʦ����  3.��ʦ�ڿη���  4.��ʦ����  5.��ʦ��¼����
 * 
 * ѧ����
 * 1.ѧ�����  2.ѧ������  3.�ڿν�ʦ  4.ѧ����¼����
 * 
 * ���ܣ�
 * 1.ʵ�ֵ�¼��������¼3�Σ�������ɹ������˳���ϵͳ��
 * 	��ʦ�����Բ鿴����ѧԱ����Ϣ
 * 	ѧ�������Բ鿴���˵���ϸ��Ϣ
 * 2.�˳���
 * 	�˳�֮����Լ�����¼
 */
public class TestJDBC {
	// �������
	public void add(int id, String name){
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// ����������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ͨ��DriverManager��ȡ���Ӷ���===>getConnection();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "nyhb");
			// ����sql���
			String sql = "insert into worker values (?,?)";
			// ͨ�����Ӷ����ȡ������===>createStatement();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, name);
			// ͨ��������������ݿ�Ĳ���===>���������executeUpdate(sql)��
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
			// ����������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ͨ��DriverManager��ȡ���Ӷ���===>getConnection();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "nyhb");
			// ��дsql���
			String sql = "select * from worker";
			// ͨ�����Ӷ����ȡ������
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ִ��sql���
			rs = pstmt.executeQuery();
			// ���������������
			while(rs.next()){
				System.out.println("���˱�ţ�" + rs.getInt(1));
				System.out.println("����������" + rs.getString(2));
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
