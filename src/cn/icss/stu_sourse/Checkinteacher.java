package cn.icss.stu_sourse;

import java.util.List;
import java.util.Scanner;

public class Checkinteacher {

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

			TeacherDao td = new TeacherDao();
			List<Teacher> teacher = (List<Teacher>) td.login(sid, spwd);
			if (teacher.size() > 0) {
				System.out.println("欢迎你，" + teacher.get(0).getTh_name());
				// Select.select(sid);
				
				for (int k = 0; k < 10; k++) {

					System.out.println("\t1:\t查询\t2:\t删除\t3:\t注册\t4:\t修改\t5:\t退出");
					choice = sc.nextInt();
					if (choice == 1 || choice == 2) {
						Select.select2(choice, sid);
						// Select.select2(1,sid);
					} else if (choice == 4) {
						System.out.println("输入ID，CODE");
						String id = sc.next();
						String code = sc.next();
						Select.up(id, code);
					} else if (choice == 5) {
						i=3;//让外层   for 退出
						break;
					} else if (choice == 3) {
						System.out.println("输入tid,tname,tpassword,tcourse,tlevel");
						String id = sc.next();
						String tname = sc.next();
						String tpassword = sc.next();
						String tcourse = sc.next();
						String tlevel = sc.next();
						Select.in_teacher(id, tname, tpassword, tcourse, tlevel);
					}

				} // 功能循环10

			} else {
				System.out.println("用户名或密码错误！");
			}

		}
		sc.close();
		System.out.println("系统推出");
		// System.exit(0);
		// break;
		// }

	}

}
