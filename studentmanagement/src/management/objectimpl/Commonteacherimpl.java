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
		//����ʦְ���Ų�ѯ��ʦ�������ڿ�
		courseimpl cs = new courseimpl();
		cs.findTeacherAll(teacherid);
	}

	@Override
	public void addGrade(String teacherid) {
		//�ον�ʦ����ѧ�źͿγ̺�Ϊѧ����ӳɼ�
		System.out.println("����ѧ�źͿγ̺�Ϊѧ����ӳɼ�");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("������ѧ����ѧ�ţ�");
		String str1 = input.nextLine();
		System.out.println("������ѧ���Ŀγ̺ţ�");
		String str2 = input.nextLine();
		System.out.println("������ѧ���ĳɼ���");
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
			System.out.println("�ɼ�����ɹ�!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "�̹���:"+teacherid+"\n"+"����ѧ�źͿγ̺�Ϊѧ����ӳɼ�"+"\n"+"ѧ��:"+str1+"\n"+"�γ̺�"+str2+"\n"+"�ɼ�"+str3;
		log.addCteacherLog(logContent);
	}

	@Override
	public void deleteGrade(String teacherid) {
		// �������ѧ�źͿγ̺�ɾ��ѧ����Ӧ�ĳɼ�
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("�������ѧ�źͿγ̺�ɾ��ѧ����Ӧ�ĳɼ�");
		System.out.println("������ѧ����ѧ�ţ�");
		String str1 = input.nextLine();
		System.out.println("������ѧ���Ŀγ̺ţ�");
		String str2 = input.nextLine();
		Connection conn = DBUtil.open(); 
		String sql = "delete from grades where studentid = ? and courseid = ?"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str1); 
			pstmt.setString(2, str2);
			pstmt.executeUpdate();
			System.out.println("ɾ���ɹ�!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "�̹���:"+teacherid+"\t��ѧ�źͿγ̺�ɾ��ѧ����Ӧ�ĳɼ�"+"\tѧ��:"+str1+"\t�γ̺�"+str2;
		log.addCteacherLog(logContent);
	}

	@Override
	public void queryGrade(String teacherid) {
		// ��ʦ��ѧ����ѧ�Ų�ѯѧ�������гɼ�
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("�������ѧ�Ų�ѯ��Ӧ��ѧ���ĳɼ�");
		System.out.println("������ѧ����ѧ�ţ�");
		String str1 = input.nextLine();
		Connection conn = DBUtil.open(); 
		String sql = "select studentid,coursename,grade from grades,course where grades.courseid = course.courseid and teacherid = ? and studentid = ?"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacherid); 
			pstmt.setString(2, str1); 
			ResultSet rs = pstmt.executeQuery();
			System.out.println("ѧ��\t"+"�γ���\t"+"�ɼ�");
			while(rs.next()) {
				System.out.println(rs.getString("studentid")+"\t"+rs.getString("coursename")+"\t"+rs.getString("grade"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "�̹���:"+teacherid+"\t��ѧ�Ų�ѯ��Ӧ��ѧ���ĳɼ�"+"\tѧ��:"+str1;
		log.addCteacherLog(logContent);
	}

	@Override
	public void alterGrade(String teacherid) {
		// ��ʦ����ѧ����ѧ�źͿγ̺��޸�ѧ���ĳɼ�
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("��ʦ����ѧ����ѧ�źͿγ̺��޸�ѧ���ĳɼ�");
		System.out.println("������ѧ����ѧ�ţ�");
		String str1 = input.nextLine();
		System.out.println("������ѧ���Ŀγ̺ţ�");
		String str2 = input.nextLine();
		System.out.println("������ѧ���ĳɼ���");
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
			System.out.println("�޸ĳɹ�!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "�̹���:"+teacherid+"\t����ѧ����ѧ�źͿγ̺��޸�ѧ���ĳɼ�"+"\tѧ��:"+str1+"\t�γ̺�:"+str2+"\t�޸ĺ�ĳɼ�:"+str3;
		log.addCteacherLog(logContent);
	}

	
	

}
