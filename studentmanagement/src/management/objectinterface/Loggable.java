package management.objectinterface;

public interface Loggable {
	
	
	/**
	 * ��־��Ϣ���������� ��Ϣ�����桢����
	 */
	/*enum TYPE {
		Cteacher,Mteacher
	};*/

	/**
	 * ���һ����־
	 * 
	 * @param type
	 *            ��־����
	 * @param logContent
	 *            ��־������
	 */
	void addCteacherLog(String logContent);

	void addMteacherLog(String logContent);
	/**
	 * 
	 * @return ������־�ļ��е���������
	 */
	String readLog();
}