package management.objectinterface;

public interface Studentmethods {
	
	//根据学号查询所有课程
	void queryAllcourses(String studentid);
	
	//根据学号查询所有课程成绩
	void queryGrades(String studentid);

}
