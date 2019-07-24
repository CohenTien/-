package management.objectimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import management.jdbc.DBUtil;
import management.objectinterface.Userlogin;

public class Userimpl implements Userlogin {

	@Override
	public String login() {
		// �����˺ź������¼ϵͳ
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String str1,str2;
		while (true) {
			System.out.println("�������˺�:");
			str1 = input.nextLine();
			System.out.println("����������:");
			str2 = input.nextLine();
			Connection conn = DBUtil.open();
			String sql = "select username,userpassword from user where username = ? and userpassword = ?";
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, str1);
				pstmt.setString(2, str2);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					break;
				}else {
					
					System.out.println("�˺Ż������������������!");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("��½�ɹ�!");
		return str1;
	}


	@Override
	public void alterPassword(String username) {
		// �޸�����
		System.out.println("��ʼ�޸�����");
		String str1,str2;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		do {
		System.out.println("������������:");
		str1 = input.nextLine();
		System.out.println("���ٴ�����������:");
		str2 = input.nextLine();
		if(!str1.equals(str2)) {
			System.out.println("������������벻һ��,����������");
		}
		}while(!str1.equals(str2));
		Connection conn = DBUtil.open();
		String sql = "update user set userpassword = ? where username = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str1);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
			System.out.println("�����޸ĳɹ�!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
