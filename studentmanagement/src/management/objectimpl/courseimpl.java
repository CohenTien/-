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
		// ��ѧ�Ų��Ҹ�ѧ����ѡ�޵����пγ�
		System.out.println("����ѧ��ѧ�Ų�ѯѧ��ѡ�޵����пγ�:");
		
		Connection conn = DBUtil.open(); 
		String sql = "select courseid,coursename from course where courseid in (select courseid from Grades where studentid = ?)"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentid); 
			ResultSet rs = pstmt.executeQuery();
			System.out.println("�γ̺�\t"+"�γ���");
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
		// ���ս�ʦְ���Ų�ѯ�ý�ʦ�����ڵ����пγ�
		Connection conn = DBUtil.open(); 
		String sql = "select * from course where teacherid = ?"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacherid); 
			ResultSet rs = pstmt.executeQuery();
			System.out.println("��ʦ\t"+"�γ̺�\t"+"�γ���\n");
			while(rs.next()) {
				System.out.println(rs.getString("courseid")+"\t"+rs.getString("coursename")+"\t"+rs.getString("teacherid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "�̹���:"+teacherid+"\t��ѯ����ʦ�����ڵ����пγ�";
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
			System.out.println("�γ̺�\t"+"�γ���");
			while(rs.next()) {
				System.out.println(rs.getString("courseid")+"\t"+rs.getString("coursename"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
