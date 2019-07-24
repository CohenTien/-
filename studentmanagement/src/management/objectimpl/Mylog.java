package management.objectimpl;

import management.objectinterface.Loggable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mylog implements Loggable {
	public static File Cteacherlog = new File("Cteacherlog.log");
	public static File Mteacherlog = new File("Mteacherlog.log");

	@Override
	public void addCteacherLog(String logContent) {
		try {
			// TODO Auto-generated method stub
			FileWriter write = new FileWriter(Cteacherlog, true);
			BufferedWriter bwrite = new BufferedWriter(write);
			Date nowTime = new Date();
			SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time = matter.format(nowTime);
			bwrite.write("**********普通老师**************");
			bwrite.newLine();
			bwrite.write(time);
			bwrite.newLine();
			bwrite.write(logContent);
			bwrite.newLine();
			bwrite.write("*****************************");
			bwrite.newLine();
			bwrite.close();
			write.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void addMteacherLog(String logContent) {
		// TODO Auto-generated method stub
		try {
			// TODO Auto-generated method stub
			FileWriter write = new FileWriter(Mteacherlog, true);
			BufferedWriter bwrite = new BufferedWriter(write);
			Date nowTime = new Date();
			SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time = matter.format(nowTime);
			bwrite.write("*************教务老师***********");
			bwrite.newLine();
			bwrite.write(time);
			bwrite.newLine();
			bwrite.write(logContent);
			bwrite.newLine();
			bwrite.write("*****************************");
			bwrite.newLine();
			bwrite.close();
			write.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public String readLog() {
		// TODO Auto-generated method stub
		return null;
	}

}
