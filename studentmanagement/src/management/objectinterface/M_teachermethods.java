package management.objectinterface;

public interface M_teachermethods {
	//����ĳ�ſγ�
	void updateTeachercourse(String teacherid);
	
	//ɾ��ĳ�ſγ�
	void deleteTeachercourse(String teacherid);
	
	//�޸�ĳ�ſγ�
	void alterTeachercourse(String teacherid);
	
	//���ӿγ���Ϣ
	void addTeachercourse(String teacherid);
	
	//��ѯ���пγ̳ɼ�
	void queryAllgrades(String teacherid);
	
	//�޸�ѧ����Ϣ
	void alterStudent(String teacherid);
	
	

}
