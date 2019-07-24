package management.objectimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import management.jdbc.DBUtil;
import management.objectinterface.M_teachermethods;
public class M_teacherimpl implements M_teachermethods{

	//ѡ�����ý�ʦ�γ̺�����˵�
	public void updateTeachercourse(String teacherid) {
		System.out.printf("1����ӿγ�");
		System.out.print("\n");
		System.out.printf("2��ɾ��ĳ�ſγ�");
		System.out.print("\n");
		System.out.printf("3���޸�ĳ�ſγ�");
		System.out.print("\n");
		System.out.printf("4���˳�");
		System.out.print("\n");
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		while (true) {
			System.out.printf("\n���������ѡ�");
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
		System.out.println("�ٴν�����������Ϣ����");
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
	}
	
	@Override
	public void deleteTeachercourse(String teacherid) {
		//���̹��źͿγ̺�Ϊ�ý�ʦɾ���γ�
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("���̹��źͿγ̺�Ϊ�ý�ʦɾ���γ�");
		System.out.println("������̹��ţ�");
		String str1 = input.nextLine();
		System.out.println("������γ̺ţ�");
		String str2 = input.nextLine();
		Connection conn = DBUtil.open(); 
		String sql = "delete from course where courseid = ? and teacherid = ?"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str2); 
			pstmt.setString(2, str1); 
			pstmt.executeUpdate();
			System.out.println("ɾ���γ̳ɹ�!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "���񹤺�:"+teacherid+"\t���̹��źͿγ̺�Ϊ�ý�ʦɾ���γ�"+"\t�̹���:"+str1+"\t�γ̺�:"+str2;
		log.addMteacherLog(logContent);
	}


	@Override
	public void alterTeachercourse(String teacherid) {
		//���̹��źͿγ̺�Ϊ�ý�ʦ�޸Ŀγ�
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("���̹��źͿγ̺�Ϊ�ý�ʦ�޸Ŀγ�");
		System.out.println("������̹��ţ�");
		String str1 = input.nextLine();
		System.out.println("������γ̺ţ�");
		String str2 = input.nextLine();
		System.out.println("���޸ĺ�Ŀγ�����");
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
			System.out.println("�޸Ŀγ̳ɹ�!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "���񹤺�:"+teacherid+"\t���̹��źͿγ̺�Ϊ�ý�ʦ�޸Ŀγ�"+"\t�̹���:"+str1+"\t�γ̺�:"+str2+"\t�޸ĺ�Ŀγ���:"+str3;
		log.addMteacherLog(logContent);
	}
	@Override
	public void addTeachercourse(String teacherid) {
		//���ݽ̹���Ϊ�ý�ʦ��ӿγ�
		System.out.println("���̹���Ϊ�ý�ʦ��ӿγ�:");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("�������ʦְ����:");
		String str1 = input.nextLine();
		System.out.println("������γ̺�:");
		String str2 = input.nextLine();
		System.out.println("������γ���:");
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
			System.out.println("���ӿγ̳ɹ�!");		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "���񹤺�:"+teacherid+"\t���ݽ̹���Ϊ�ý�ʦ��ӿγ�"+"\t�̹���:"+str1+"\t�γ̺�:"+str2+"\t�γ���:"+str3;
		log.addMteacherLog(logContent);
	}

	@Override
	public void queryAllgrades(String teacherid) {
		// ��ѯ����ѧ�������гɼ�����ʾѧ�š��γ̺źͳɼ�
		Gradesimpl g = new Gradesimpl();
		g.queryAllgrades(teacherid);
	}

	@Override
	public void alterStudent(String teacherid) {
		// ����ѧ����ѧ���޸�ѧ��������
		System.out.println("���������ѧ��ѧ���޸�ѧ��������:");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("������ѧ��:");
		String str1 = input.nextLine();
		System.out.println("�������޸ĺ������:");
		String str2 = input.nextLine();
		Connection conn = DBUtil.open(); 
		String sql = "update student set studentname = ? where studentid = ?"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str2); 
			pstmt.setString(2, str1);
			pstmt.executeUpdate();
			System.out.println("�޸ĳɹ�!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Mylog log = new Mylog();
		String logContent = "���񹤺�:"+teacherid+"\t����ѧ��ѧ���޸�ѧ��������:"+"\tѧ��:"+str1+"\t�޸ĺ�����:"+str2;
		log.addMteacherLog(logContent);
	}


	

	

}
