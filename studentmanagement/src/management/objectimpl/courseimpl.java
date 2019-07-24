package management.objectimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import management.jdbc.DBUtil;
import management.objectinterface.coursemethods;

public class courseimpl implements coursemethods {

	@Override
	public void findStudentAll(String studentid) {
		// 按学号查找该学生所选修的所有课程
		System.out.println("按照学生学号查询学生选修的所有课程:");
		
		Connection conn = DBUtil.open(); 
		String sql = "select courseid,coursename from course where courseid in (select courseid from Grades where studentid = ?)"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentid); 
			ResultSet rs = pstmt.executeQuery();
			System.out.println("课程号\t"+"课程名");
			while(rs.next()) {
				System.out.println(rs.getString("courseid")+"\t"+rs.getString("coursename"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		

	}

	@Override
	public void findTeacherAll(String teacherid) {
		// 按照教师职工号查询该教师所教授的所有课程
		Connection conn = DBUtil.open(); 
		String sql = "select * from course where teacherid = ?"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacherid); 
			ResultSet rs = pstmt.executeQuery();
			System.out.println("教师\t"+"课程号\t"+"课程名\n");
			while(rs.next()) {
				System.out.println(rs.getString("courseid")+"\t"+rs.getString("coursename")+"\t"+rs.getString("teacherid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "教工号:"+teacherid+"\t查询本教师所教授的所有课程";
		log.addCteacherLog(logContent);
	}

	@Override
	public void findMteacherAll() {
		
		Connection conn = DBUtil.open(); 
		String sql = "select * from course"; 
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("课程号\t"+"课程名");
			while(rs.next()) {
				System.out.println(rs.getString("courseid")+"\t"+rs.getString("coursename"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
