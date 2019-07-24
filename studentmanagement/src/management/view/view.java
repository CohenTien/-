package management.view;

import java.util.Scanner;

import management.objectimpl.*;

public class view {

	private static String username;
	private static Userimpl user;

	void loginview() {
		System.out.printf("**********教务信息管理系统***********");
		System.out.print("\n");
		System.out.print("***********************************");
		System.out.print("\n");
	};

	void studentview() {

		System.out.print("\n");
		System.out.printf("**********学生信息界面***********");
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("\n");
		System.out.printf("1、查询所有课程信息");
		System.out.print("\n");
		System.out.printf("2、查询所有课程成绩");
		System.out.print("\n");
		System.out.printf("3、修改登录密码");
		System.out.print("\n");
		System.out.printf("4、返回主菜单");
		System.out.print("\n");
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		while (true) {
			System.out.printf("\n请输入操作选项：");
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
		System.out.printf("**********教师信息界面***********");
		System.out.print("\n");
		System.out.print("\n");
		System.out.printf("1、查看所教授的课程");
		System.out.print("\n");
		System.out.printf("2、增加某门课的某同学成绩");
		System.out.print("\n");
		System.out.printf("3、修改某门课的某同学成绩");
		System.out.print("\n");
		System.out.printf("4、删除某门课的某同学成绩");
		System.out.print("\n");
		System.out.printf("5、查询某同学成绩");
		System.out.print("\n");
		System.out.printf("6、修改登录密码");
		System.out.print("\n");
		System.out.printf("7、返回主菜单");
		System.out.print("\n");
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		while (true) {
			System.out.printf("\n请输入操作选项：");
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
		System.out.printf("**********教务管理信息界面***********");
		System.out.print("\n");
		System.out.print("\n");
		System.out.printf("1、设置教师课程信息");
		System.out.print("\n");
		System.out.printf("2、修改学生信息");
		System.out.print("\n");
		System.out.printf("3、查询所有学生成绩");
		System.out.print("\n");
		System.out.printf("4、修改登录密码");
		System.out.print("\n");
		System.out.printf("5、返回主菜单");
		System.out.print("\n");
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		while (true) {
			System.out.printf("\n请输入操作选项：");
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
			System.out.printf("请输入登录者类型（1、学生;2、教师;3、教务老师;4、退出）：\n");
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
				System.out.println("输入错误!");
			}

		}

		System.out.println("退出系统!");

	}

}
