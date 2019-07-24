package management.objectimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import management.jdbc.DBUtil;
import management.objectinterface.Studentmethods;

public class Studentimpl implements Studentmethods{

	@Override
	public void queryAllcourses(String studentid) {
		// 按学号查询学生选修的所有课程
		courseimpl cs = new courseimpl();
		cs.findStudentAll(studentid);
	}

	
	@Override
	public void queryGrades(String studentid) {
		// 按学号查询学生所有课程的成绩
		Connection conn = DBUtil.open(); 
		String sql = "select studentid,courseid,grade from grades where studentid = ?"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentid);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("学号\t"+"课程号\t"+"成绩");
			while(rs.next()) {
				System.out.println(rs.getString("studentid")+"\t"+rs.getString("courseid")+"\t"+rs.getString("grade"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
