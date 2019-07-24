package management.view;

import java.util.Scanner;

import management.objectimpl.*;

public class view {

	private static String username;
	private static Userimpl user;

	void loginview() {
		System.out.printf("**********������Ϣ����ϵͳ***********");
		System.out.print("\n");
		System.out.print("***********************************");
		System.out.print("\n");
	};

	void studentview() {

		System.out.print("\n");
		System.out.printf("**********ѧ����Ϣ����***********");
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("\n");
		System.out.printf("1����ѯ���пγ���Ϣ");
		System.out.print("\n");
		System.out.printf("2����ѯ���пγ̳ɼ�");
		System.out.print("\n");
		System.out.printf("3���޸ĵ�¼����");
		System.out.print("\n");
		System.out.printf("4���������˵�");
		System.out.print("\n");
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		while (true) {
			System.out.printf("\n���������ѡ�");
			int x = s1.nextInt();
			Studentimpl student = new Studentimpl();
			switch (x) {
			case 1:
				student.queryAllcourses(username);
				break;
			case 2:
				student.queryGrades(username);
				break;
			case 3:
				user.alterPassword(username);
				break;
			default:
				break;
			}
			if (x == 4)
				break;
		}
	}

	void teacherview() {
		System.out.print("\n");
		System.out.printf("**********��ʦ��Ϣ����***********");
		System.out.print("\n");
		System.out.print("\n");
		System.out.printf("1���鿴�����ڵĿγ�");
		System.out.print("\n");
		System.out.printf("2������ĳ�ſε�ĳͬѧ�ɼ�");
		System.out.print("\n");
		System.out.printf("3���޸�ĳ�ſε�ĳͬѧ�ɼ�");
		System.out.print("\n");
		System.out.printf("4��ɾ��ĳ�ſε�ĳͬѧ�ɼ�");
		System.out.print("\n");
		System.out.printf("5����ѯĳͬѧ�ɼ�");
		System.out.print("\n");
		System.out.printf("6���޸ĵ�¼����");
		System.out.print("\n");
		System.out.printf("7���������˵�");
		System.out.print("\n");
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		while (true) {
			System.out.printf("\n���������ѡ�");
			int y = s1.nextInt();
			Commonteacherimpl cteacher = new Commonteacherimpl();
			switch (y) {
			case 1:
				cteacher.queryAllcourses(username);
				break;
			case 2:
				cteacher.addGrade(username);
				break;
			case 3:
				cteacher.alterGrade(username);
				break;
			case 4:
				cteacher.deleteGrade(username);
				break;
			case 5:
				cteacher.queryGrade(username);
				break;
			case 6:
				user.alterPassword(username);
				break;
			default:
				break;
			}
			if (y == 7)
				break;
		}
	}

	void mteacherview() {
		System.out.print("\n");
		System.out.printf("**********���������Ϣ����***********");
		System.out.print("\n");
		System.out.print("\n");
		System.out.printf("1�����ý�ʦ�γ���Ϣ");
		System.out.print("\n");
		System.out.printf("2���޸�ѧ����Ϣ");
		System.out.print("\n");
		System.out.printf("3����ѯ����ѧ���ɼ�");
		System.out.print("\n");
		System.out.printf("4���޸ĵ�¼����");
		System.out.print("\n");
		System.out.printf("5���������˵�");
		System.out.print("\n");
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		while (true) {
			System.out.printf("\n���������ѡ�");
			int z = s1.nextInt();
			M_teacherimpl Mteacher = new M_teacherimpl();
			switch (z) {
			case 1:
				Mteacher.updateTeachercourse(username);
				break;
			case 2:
				Mteacher.alterStudent(username);
				break;
			case 3:
				Mteacher.queryAllgrades(username);
				break;
			case 4:
				user.alterPassword(username);
				break;
			default:
				break;
			}
			if (z == 5)
				break;
		}
	}

	public static void display() {
		view v = new view();
		v.loginview();
		int a;
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		while (true) {
			System.out.printf("�������¼�����ͣ�1��ѧ��;2����ʦ;3��������ʦ;4���˳�����\n");
			a = s1.nextInt();
			if (a == 4) {
				break;
			}
			if (a == 1||a == 2||a == 3) {
				user = new Userimpl();
				username = user.login();
			}
			switch (a) {
			case 1:
				v.studentview();
				break;
			case 2:
				v.teacherview();
				break;
			case 3:
				v.mteacherview();
				break;
			default:
				System.out.println("�������!");
			}

		}

		System.out.println("�˳�ϵͳ!");

	}

}
