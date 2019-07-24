package management.objectinterface;

public interface Userlogin {

	//登录并验证
	String login();
	
	//修改密码
	void alterPassword(String username);
}
