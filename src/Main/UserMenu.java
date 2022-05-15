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

	//컴퓨터에 있는 SQL과 연결해주는 코드
	public UserMenu() {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/epidemic","root","996363Kim~~");
			st=con.createStatement();
		}
		catch(Exception e) {
			System.out.println("데이터베이스 연결 오류:"+e.getMessage());
		}
	}
	
	
	// 사용자가 선택한 번호에 따라 해당 함수로 보내 줄거임 
	public void menu(String number) {
		if (number.contains("1")) menu1();
		else if (number.contains("2")) menu2();
	}
	
	
	
	
	//사용자가 1번 선택하면 실행되는 함수 
	public void menu1() {
		FrameUserInfo window = new FrameUserInfo();
		window.frame.setVisible(true);
	}
	
	
	
	//사용자가 2번 선택하면 실행되는 함수
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
			System.out.println("데이터베이스 검색 오류: "+e.getMessage());
		}
	}
	
	
	// 뒤에 마저 연결해주면 될 것 같아요~
	

}
