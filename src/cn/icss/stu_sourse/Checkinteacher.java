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
			System.out.println("�˺�");
			sid = sc.next();
			System.out.println("����");
			spwd = sc.next();

			TeacherDao td = new TeacherDao();
			List<Teacher> teacher = (List<Teacher>) td.login(sid, spwd);
			if (teacher.size() > 0) {
				System.out.println("��ӭ�㣬" + teacher.get(0).getTh_name());
				// Select.select(sid);
				
				for (int k = 0; k < 10; k++) {

					System.out.println("\t1:\t��ѯ\t2:\tɾ��\t3:\tע��\t4:\t�޸�\t5:\t�˳�");
					choice = sc.nextInt();
					if (choice == 1 || choice == 2) {
						Select.select2(choice, sid);
						// Select.select2(1,sid);
					} else if (choice == 4) {
						System.out.println("����ID��CODE");
						String id = sc.next();
						String code = sc.next();
						Select.up(id, code);
					} else if (choice == 5) {
						i=3;//�����   for �˳�
						break;
					} else if (choice == 3) {
						System.out.println("����tid,tname,tpassword,tcourse,tlevel");
						String id = sc.next();
						String tname = sc.next();
						String tpassword = sc.next();
						String tcourse = sc.next();
						String tlevel = sc.next();
						Select.in_teacher(id, tname, tpassword, tcourse, tlevel);
					}

				} // ����ѭ��10

			} else {
				System.out.println("�û������������");
			}

		}
		sc.close();
		System.out.println("ϵͳ�Ƴ�");
		// System.exit(0);
		// break;
		// }

	}

}
