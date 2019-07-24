package management.objectimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import management.jdbc.DBUtil;
import management.objectinterface.M_teachermethods;
public class M_teacherimpl implements M_teachermethods{

	//选择设置教师课程后的主菜单
	public void updateTeachercourse(String teacherid) {
		System.out.printf("1、添加课程");
		System.out.print("\n");
		System.out.printf("2、删除某门课程");
		System.out.print("\n");
		System.out.printf("3、修改某门课程");
		System.out.print("\n");
		System.out.printf("4、退出");
		System.out.print("\n");
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		while (true) {
			System.out.printf("\n请输入操作选项：");
			int y = s1.nextInt();
			switch (y) {
			case 1:
				addTeachercourse(teacherid);
				break;
			case 2:
				deleteTeachercourse(teacherid);
				break;
			case 3:
				alterTeachercourse(teacherid);
				break;
			default:
				break;
			}
			if (y == 4) {
				break;
			}
		}
		System.out.println("再次进入教务管理信息界面");
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
	}
	
	@Override
	public void deleteTeachercourse(String teacherid) {
		//按教工号和课程号为该教师删除课程
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("按教工号和课程号为该教师删除课程");
		System.out.println("请输入教工号：");
		String str1 = input.nextLine();
		System.out.println("请输入课程号：");
		String str2 = input.nextLine();
		Connection conn = DBUtil.open(); 
		String sql = "delete from course where courseid = ? and teacherid = ?"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str2); 
			pstmt.setString(2, str1); 
			pstmt.executeUpdate();
			System.out.println("删除课程成功!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "教务工号:"+teacherid+"\t按教工号和课程号为该教师删除课程"+"\t教工号:"+str1+"\t课程号:"+str2;
		log.addMteacherLog(logContent);
	}


	@Override
	public void alterTeachercourse(String teacherid) {
		//按教工号和课程号为该教师修改课程
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("按教工号和课程号为该教师修改课程");
		System.out.println("请输入教工号：");
		String str1 = input.nextLine();
		System.out.println("请输入课程号：");
		String str2 = input.nextLine();
		System.out.println("请修改后的课程名：");
		String str3 = input.nextLine();
		Connection conn = DBUtil.open(); 
		String sql = "update course set coursename = ? where teacherid = ? and courseid = ?"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str3); 
			pstmt.setString(2, str1);
			pstmt.setString(3, str2);
			pstmt.executeUpdate();
			System.out.println("修改课程成功!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "教务工号:"+teacherid+"\t按教工号和课程号为该教师修改课程"+"\t教工号:"+str1+"\t课程号:"+str2+"\t修改后的课程名:"+str3;
		log.addMteacherLog(logContent);
	}
	@Override
	public void addTeachercourse(String teacherid) {
		//根据教工号为该教师添加课程
		System.out.println("按教工号为该教师添加课程:");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("请输入教师职工号:");
		String str1 = input.nextLine();
		System.out.println("请输入课程号:");
		String str2 = input.nextLine();
		System.out.println("请输入课程名:");
		String str3 = input.nextLine();
		Connection conn = DBUtil.open(); 
		String sql = "insert into course(teacherid,courseid,coursename) values(?,?,?)"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str1); 
			pstmt.setString(2, str2);
			pstmt.setString(3, str3);
			pstmt.executeUpdate();
			System.out.println("增加课程成功!");		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "教务工号:"+teacherid+"\t根据教工号为该教师添加课程"+"\t教工号:"+str1+"\t课程号:"+str2+"\t课程名:"+str3;
		log.addMteacherLog(logContent);
	}

	@Override
	public void queryAllgrades(String teacherid) {
		// 查询所有学生的所有成绩，显示学号、课程号和成绩
		Gradesimpl g = new Gradesimpl();
		g.queryAllgrades(teacherid);
	}

	@Override
	public void alterStudent(String teacherid) {
		// 按照学生的学号修改学生的姓名
		System.out.println("按照输入的学生学号修改学生的姓名:");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("请输入学号:");
		String str1 = input.nextLine();
		System.out.println("请输入修改后的姓名:");
		String str2 = input.nextLine();
		Connection conn = DBUtil.open(); 
		String sql = "update student set studentname = ? where studentid = ?"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str2); 
			pstmt.setString(2, str1);
			pstmt.executeUpdate();
			System.out.println("修改成功!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "教务工号:"+teacherid+"\t按照学生学号修改学生的姓名:"+"\t学号:"+str1+"\t修改后姓名:"+str2;
		log.addMteacherLog(logContent);
	}


	

	

}
