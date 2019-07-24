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
		// 按照账号和密码登录系统
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String str1,str2;
		while (true) {
			System.out.println("请输入账号:");
			str1 = input.nextLine();
			System.out.println("请输入密码:");
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
					
					System.out.println("账号或密码错误，请重新输入!");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("登陆成功!");
		return str1;
	}


	@Override
	public void alterPassword(String username) {
		// 修改密码
		System.out.println("开始修改密码");
		String str1,str2;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		do {
		System.out.println("请输入新密码:");
		str1 = input.nextLine();
		System.out.println("请再次输入新密码:");
		str2 = input.nextLine();
		if(!str1.equals(str2)) {
			System.out.println("两次输入的密码不一致,请重新输入");
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
			System.out.println("密码修改成功!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
