package cn.icss.stu_sourse;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

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
 * 	��ʦ�����Բ鿴�Լ�ѧԱ����Ϣ�����������룩
 * 	ѧ�������Բ鿴���˵���ϸ��Ϣ
 * 2.�˳���
 * 	�˳�֮����Լ�����¼
 * 3.ע�᣺
 * 	ѧ��ע��
 * 	��ʦע��
 * 4.�޸����룺
 * 	ѧ���޸�����
 * 	��ʦ�޸�����
 * 5.ɾ��ѧ����
 * 	��ʦɾ��ѧԱ��Ϣ
 */
public class Test {
	public static void main(String[] args) {
		
		while(true){
			Scanner sc = new Scanner(System.in); 
			for(int i =0; i< 3;i++){
				System.out.println("�˺�");
				String sid = sc.nextLine();
				System.out.println("����");
				String spwd = sc.nextLine();
				
				StudentDao sd = new StudentDao();
				List<Student> student = (List<Student>) sd.login(sid, spwd);
				if(student.size()>0){
//					System.out.println("��ӭ�㣬" + stu.getStu_name());
					System.out.println("��ӭ�㣬" + student.get(0).getStu_name());
				}else{
					System.out.println("�û������������");
//					System.exit(0);
				}
				
			}
			sc.close();
			System.out.println("����3�Σ�ϵͳ�Ƴ�");
//			System.exit(0);
			break;
		}
		
	}
}
