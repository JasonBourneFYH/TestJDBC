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
			System.out.println("�˺�");
			sid = sc.next();
			System.out.println("����");
			spwd = sc.next();

			StudentDao sd = new StudentDao();
			List<Student> student = (List<Student>) sd.login(sid, spwd);
			if (student.size() > 0) {
				System.out.println("��ӭ�㣬" + student.get(0).getStu_name());

				for (int k = 0; k < 10; k++) {
					
					System.out.println("\t1:\t��ѯ\t2:\t�˳�\t3:\tע��\t4:\t�޸�");
					choice = sc.nextInt();
					if (choice == 1) {
						Select.select2(choice, sid);
					} else if (choice == 2) {
						i=3;//�����   for �˳�
						break;
					} else if (choice == 4) {
						System.out.println("����ID��CODE");
						String id = sc.next();
						String code = sc.next();
						Select.up(id, code);
					} else if (choice == 3) {
						System.out.println("����sno,sname,steacher,code");
						String sno = sc.next();
						String sname = sc.next();
						String steacher = sc.next();
						String code = sc.next();
						Select.in_student(sno, sname, steacher, code);
					}
				} // ����ѭ��10
			} else {
				System.out.println("�û������������");
				// System.exit(0);
			}

		}
		sc.close();
		System.out.println("ϵͳ�Ƴ�");
		// System.exit(0);
		// break;
		// }

	}
}
