package management.objectinterface;

public interface Commonteachermethods {
	//��ѯ�����ڵ����пγ�
	void queryAllcourses(String teacherid);
	
	//����ĳ�ſγ̵�ĳ��ѧ���ĳɼ�
	void addGrade(String teacherid);
	
	//ɾ��ĳ�ſγ̵�ĳ��ѧ���ĳɼ�
	void deleteGrade(String teacherid);
	
	//��ѯĳ��ѧ��ĳ�ſεĳɼ�
	void queryGrade(String teacherid);
	
	//�޸�ĳ��ѧ����ĳ�ſγ�
	void alterGrade(String teacherid);
	

}
