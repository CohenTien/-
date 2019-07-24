package management.objectimpl;

import management.objectinterface.Commonteachermethods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import management.jdbc.DBUtil;

public class Commonteacherimpl implements Commonteachermethods{

	
	@Override
	public void queryAllcourses(String teacherid) {
		//按教师职工号查询老师的所有授课
		courseimpl cs = new courseimpl();
		cs.findTeacherAll(teacherid);
	}

	@Override
	public void addGrade(String teacherid) {
		//任课教师按照学号和课程号为学生添加成绩
		System.out.println("按照学号和课程号为学生添加成绩");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("请输入学生的学号：");
		String str1 = input.nextLine();
		System.out.println("请输入学生的课程号：");
		String str2 = input.nextLine();
		System.out.println("请输入学生的成绩：");
		String str3 = input.nextLine();
		Connection conn = DBUtil.open(); 
		
		String sql = "insert into grades(studentid,courseid,grade) values(?,?,?)"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str1); 
			pstmt.setString(2, str2);
			pstmt.setString(3, str3);
			pstmt.executeUpdate();
			System.out.println("成绩插入成功!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "教工号:"+teacherid+"\n"+"按照学号和课程号为学生添加成绩"+"\n"+"学号:"+str1+"\n"+"课程号"+str2+"\n"+"成绩"+str3;
		log.addCteacherLog(logContent);
	}

	@Override
	public void deleteGrade(String teacherid) {
		// 按输入的学号和课程号删除学生对应的成绩
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("按输入的学号和课程号删除学生对应的成绩");
		System.out.println("请输入学生的学号：");
		String str1 = input.nextLine();
		System.out.println("请输入学生的课程号：");
		String str2 = input.nextLine();
		Connection conn = DBUtil.open(); 
		String sql = "delete from grades where studentid = ? and courseid = ?"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str1); 
			pstmt.setString(2, str2);
			pstmt.executeUpdate();
			System.out.println("删除成功!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "教工号:"+teacherid+"\t按学号和课程号删除学生对应的成绩"+"\t学号:"+str1+"\t课程号"+str2;
		log.addCteacherLog(logContent);
	}

	@Override
	public void queryGrade(String teacherid) {
		// 教师按学生的学号查询学生的所有成绩
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("按输入的学号查询对应的学生的成绩");
		System.out.println("请输入学生的学号：");
		String str1 = input.nextLine();
		Connection conn = DBUtil.open(); 
		String sql = "select studentid,coursename,grade from grades,course where grades.courseid = course.courseid and teacherid = ? and studentid = ?"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacherid); 
			pstmt.setString(2, str1); 
			ResultSet rs = pstmt.executeQuery();
			System.out.println("学号\t"+"课程名\t"+"成绩");
			while(rs.next()) {
				System.out.println(rs.getString("studentid")+"\t"+rs.getString("coursename")+"\t"+rs.getString("grade"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "教工号:"+teacherid+"\t按学号查询对应的学生的成绩"+"\t学号:"+str1;
		log.addCteacherLog(logContent);
	}

	@Override
	public void alterGrade(String teacherid) {
		// 教师根据学生的学号和课程号修改学生的成绩
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("教师根据学生的学号和课程号修改学生的成绩");
		System.out.println("请输入学生的学号：");
		String str1 = input.nextLine();
		System.out.println("请输入学生的课程号：");
		String str2 = input.nextLine();
		System.out.println("请输入学生的成绩：");
		String str3 = input.nextLine();
		Connection conn = DBUtil.open(); 
		String sql = "update grades set grade = ? where studentid = ? and courseid = ?"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str3); 
			pstmt.setString(2, str1);
			pstmt.setString(3, str2);
			pstmt.executeUpdate();
			System.out.println("修改成功!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "教工号:"+teacherid+"\t根据学生的学号和课程号修改学生的成绩"+"\t学号:"+str1+"\t课程号:"+str2+"\t修改后的成绩:"+str3;
		log.addCteacherLog(logContent);
	}

	
	

}
