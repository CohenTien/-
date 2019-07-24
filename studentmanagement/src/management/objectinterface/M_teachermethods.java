package management.objectinterface;

public interface M_teachermethods {
	//设置某门课程
	void updateTeachercourse(String teacherid);
	
	//删除某门课程
	void deleteTeachercourse(String teacherid);
	
	//修改某门课程
	void alterTeachercourse(String teacherid);
	
	//增加课程信息
	void addTeachercourse(String teacherid);
	
	//查询所有课程成绩
	void queryAllgrades(String teacherid);
	
	//修改学生信息
	void alterStudent(String teacherid);
	
	

}
