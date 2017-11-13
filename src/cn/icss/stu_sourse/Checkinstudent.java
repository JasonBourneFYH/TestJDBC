package cn.icss.stu_sourse;

import java.util.List;
import java.util.Scanner;

public class Checkinstudent {
	public void checkin() throws Exception {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		String sid = null;
		String spwd = null;
		for (int i = 0; i < 3; i++) {
			System.out.println("账号");
			sid = sc.next();
			System.out.println("密码");
			spwd = sc.next();

			StudentDao sd = new StudentDao();
			List<Student> student = (List<Student>) sd.login(sid, spwd);
			if (student.size() > 0) {
				System.out.println("欢迎你，" + student.get(0).getStu_name());

				for (int k = 0; k < 10; k++) {
					
					System.out.println("\t1:\t查询\t2:\t退出\t3:\t注册\t4:\t修改");
					choice = sc.nextInt();
					if (choice == 1) {
						Select.select2(choice, sid);
					} else if (choice == 2) {
						i=3;//让外层   for 退出
						break;
					} else if (choice == 4) {
						System.out.println("输入ID，CODE");
						String id = sc.next();
						String code = sc.next();
						Select.up(id, code);
					} else if (choice == 3) {
						System.out.println("输入sno,sname,steacher,code");
						String sno = sc.next();
						String sname = sc.next();
						String steacher = sc.next();
						String code = sc.next();
						Select.in_student(sno, sname, steacher, code);
					}
				} // 功能循环10
			} else {
				System.out.println("用户名或密码错误！");
				// System.exit(0);
			}

		}
		sc.close();
		System.out.println("系统推出");
		// System.exit(0);
		// break;
		// }

	}
}
