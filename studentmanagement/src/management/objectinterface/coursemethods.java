package management.objectinterface;

public interface coursemethods {
	//根据学号查询所有课程
	void findStudentAll(String studentid);

	//根据普通老师的教工号查询教师的所有课程
	void findTeacherAll(String teacherid);
	
	//根据教务老师的教工号查询所有的课程
	void findMteacherAll();
	
}
