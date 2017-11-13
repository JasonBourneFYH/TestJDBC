package cn.icss.stu_sourse;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

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
 * 	教师：可以查看自己学员的信息（不包括密码）
 * 	学生：可以查看个人的详细信息
 * 2.退出：
 * 	退出之后可以继续登录
 * 3.注册：
 * 	学生注册
 * 	老师注册
 * 4.修改密码：
 * 	学生修改密码
 * 	老师修改密码
 * 5.删除学生：
 * 	老师删除学员信息
 */
public class Test {
	public static void main(String[] args) {
		
		while(true){
			Scanner sc = new Scanner(System.in); 
			for(int i =0; i< 3;i++){
				System.out.println("账号");
				String sid = sc.nextLine();
				System.out.println("密码");
				String spwd = sc.nextLine();
				
				StudentDao sd = new StudentDao();
				List<Student> student = (List<Student>) sd.login(sid, spwd);
				if(student.size()>0){
//					System.out.println("欢迎你，" + stu.getStu_name());
					System.out.println("欢迎你，" + student.get(0).getStu_name());
				}else{
					System.out.println("用户名或密码错误！");
//					System.exit(0);
				}
				
			}
			sc.close();
			System.out.println("错误3次，系统推出");
//			System.exit(0);
			break;
		}
		
	}
}
