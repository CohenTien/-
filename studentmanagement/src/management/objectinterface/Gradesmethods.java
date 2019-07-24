package management.objectinterface;

public interface Gradesmethods {
	//根据课程号查询所有成绩
	void queryCoursegrade();
	
	//根据学号查询成绩
	void queryStudentgrade(String teacherid);
	
	//查询所有成绩
	void queryAllgrades(String teacherid);

}
