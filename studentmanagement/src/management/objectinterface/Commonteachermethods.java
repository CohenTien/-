package management.objectinterface;

public interface Commonteachermethods {
	//查询所教授的所有课程
	void queryAllcourses(String teacherid);
	
	//增加某门课程的某个学生的成绩
	void addGrade(String teacherid);
	
	//删除某门课程的某个学生的成绩
	void deleteGrade(String teacherid);
	
	//查询某个学生某门课的成绩
	void queryGrade(String teacherid);
	
	//修改某个学生的某门课程
	void alterGrade(String teacherid);
	

}
