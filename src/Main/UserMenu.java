package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Frame.FrameUserInfo;

public class UserMenu {
	private Connection con;
	private Statement st;
	private ResultSet rs;

	//��ǻ�Ϳ� �ִ� SQL�� �������ִ� �ڵ�
	public UserMenu() {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/epidemic","root","996363Kim~~");
			st=con.createStatement();
		}
		catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ����:"+e.getMessage());
		}
	}
	
	
	// ����ڰ� ������ ��ȣ�� ���� �ش� �Լ��� ���� �ٰ��� 
	public void menu(String number) {
		if (number.contains("1")) menu1();
		else if (number.contains("2")) menu2();
	}
	
	
	
	
	//����ڰ� 1�� �����ϸ� ����Ǵ� �Լ� 
	public void menu1() {
		FrameUserInfo window = new FrameUserInfo();
		window.frame.setVisible(true);
	}
	
	
	
	//����ڰ� 2�� �����ϸ� ����Ǵ� �Լ�
	public void menu2() {
		try {
			String SQL;
			SQL="SELECT Area FROM Area ORDER BY Patient";
			rs=st.executeQuery(SQL);
			while(rs.next())
			{
				System.out.println(rs.getString("Area"));
		}
		}
		catch(Exception e) {
			System.out.println("�����ͺ��̽� �˻� ����: "+e.getMessage());
		}
	}
	
	
	// �ڿ� ���� �������ָ� �� �� ���ƿ�~
	

}
