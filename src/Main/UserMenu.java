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
			
			SQL="SELECT ID FROM DB2022_MedicalCenter WHERE CURTIME() between open and close;";
			rs=st.executeQuery(SQL);
			while(rs.next())
			{
				System.out.println(rs.getString("ID"));
			}
		}
		catch(Exception e) {
			System.out.println("�����ͺ��̽� �˻� ����: "+e.getMessage());
		}
	}
	//6 -�������� �������� ������ ��
	public void menu6_c() {
		try {
			String SQL;
			
			SQL="SELECT area, Ebola, Corona, Mers, Sars FROM DB2022_EpidemicRank;";
			rs=st.executeQuery(SQL);
			System.out.println("area\t\t Ebola\t Corona\t Mers\t Sars");
			while(rs.next())
			{
				System.out.println(rs.getString("area") +"  \t" + rs.getString("Ebola") +
				"\t" + rs.getString("Corona") + "\t" + rs.getString("Mers") 
				+ "\t" +rs.getString("Sars"));
			}
		}
		catch(Exception e) {
			System.out.println("�����ͺ��̽� �˻� ����: "+e.getMessage());
		}
	}
	
	
	// �ڿ� ���� �������ָ� �� �� ���ƿ�~
	

}
