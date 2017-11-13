package cn.icss.stu_sourse;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Test2 {

	private static Scanner sc;

	public static void main(String[] args) throws Exception {
		int i =0;
		while (true) {
			System.out.println("-------------------------");
			System.out.println("教师登录输入1\t学生登录输入2");
			System.out.println("-------------------------");
			sc = new Scanner(System.in);

			i = sc.nextInt();
			if (i == 1)
				try {
					{
						Checkinteacher tea = new Checkinteacher();
						tea.checkin();
						main(args);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			else if (i == 2)
				try {
					{
						Checkinstudent stu = new Checkinstudent();
						stu.checkin();
						main(args);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			sc.close();
		}

	}

}
