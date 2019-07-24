package management.objectimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import management.jdbc.DBUtil;
import management.objectinterface.Gradesmethods;
public class Gradesimpl implements Gradesmethods{

	@Override
	public void queryCoursegrade() {
		// ���γ̺Ų�ѯ ����ѧ���ĳɼ�
		Connection conn = DBUtil.open(); 
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫ��ѯ�Ŀγ̺ţ�");
		String str = input.nextLine();
		String sql = "select studentid,course.coursename,grade from grades,course where grades.courseid = course.courseid and course.courseid = ?"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str); 
			ResultSet rs = pstmt.executeQuery();
			System.out.println("ѧ��\t"+"�γ���\t"+"�ɼ�");
			while(rs.next()) {
				System.out.println(rs.getString("studentid")+"\t"+rs.getString("coursename")+"\t"+rs.getString("grade"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public void queryStudentgrade(String teacherid) {
		// ��ѧ�Ų�ѯѧ�������гɼ�
		Commonteacherimpl ct = new Commonteacherimpl();
		ct.queryGrade(teacherid);
	}

	@Override
	public void queryAllgrades(String teacherid) {
		// ��ѯ����ѧ�������гɼ�
		Connection conn = DBUtil.open(); 
		String sql = "select * from grades"; 
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("ѧ��\t"+"�γ���\t"+"�ɼ�");
			while(rs.next()) {
				System.out.println(rs.getString("studentid")+"\t"+rs.getString("courseid")+"\t"+rs.getString("grade"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "���񹤺�:"+teacherid+"\t��ѯ����ѧ�������гɼ�";
		log.addMteacherLog(logContent);
		
	}

	

}
