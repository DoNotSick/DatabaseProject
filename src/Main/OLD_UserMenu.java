//package Main;
//import java.awt.Window;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//import Frame.FrameResult_success;
//import Frame.FrameResult_fail;
//import Frame.FrameMenu1;
//import Frame.FrameMenu2;
//import Frame.FrameMenu4;
//import Frame.FrameMenu6;
//
//public class OLD_UserMenu  {
//	private Connection con;
//	private Connection con_1;
//	private Statement st;
//	private Statement st_1;
//	private ResultSet rs;
//	private ResultSet rs_1;
//	public String UserName, UserDisease, UserAge, UserDiseaseOX, UserInfectDate, UserLocation, patient_name;
//	int number;
//	//而댄벂�꽣�뿉 �엳�뒗 SQL怨� �뿰寃고빐二쇰뒗 肄붾뱶
//	public OLD_UserMenu() {
//		try 
//		{
//			Class.forName("com.mysql.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DB2022Team04","root","996363Kim~~");
//			con_1=DriverManager.getConnection("jdbc:mysql://localhost:3306/DB2022Team04","root","996363Kim~~");
//			st=con.createStatement();
//			st_1=con_1.createStatement();
//		}
//		catch(Exception e) {
//			System.out.println("�뜲�씠�꽣踰좎씠�뒪 �뿰寃� �삤瑜�:"+e.getMessage());
//		}
//	}
//	
//	
//	// �궗�슜�옄媛� �꽑�깮�븳 踰덊샇�뿉 �뵲�씪 �빐�떦 �븿�닔濡� 蹂대궡 以꾧굅�엫 
//	public void menu(String number) {
//		this.number=Integer.parseInt(number);
//		if (this.number==1) menu1();
//		else if(this.number==2) menu2();
//		else if(this.number==3) menu3();
//		else if(this.number==4) menu4();
//		else if(this.number==5) menu5();
//		else if(this.number==6) {
//			FrameMenu6 window = new FrameMenu6();
//			window.frame.setVisible(true);
//		}
//		else if(this.number==7) menu7();
//		else if(this.number==8) menu8();
//		else if(this.number==9) menu9();
//		else if(this.number==10) menu10();
//		else if(this.number==11) menu11();
//		
//	}
//	
//	
//	
//	
//	//�궗�슜�옄媛� 1踰� �꽑�깮�븯硫� �떎�뻾�릺�뒗 �븿�닔 
//	public void menu1() {
//		FrameMenu1 window = new FrameMenu1();
//		window.frame.setVisible(true);
//	}
//	
//	//�솚�옄 �젙蹂� �엯�젰 李쎌뿉�꽌 �솗�씤�쓣 �늻瑜닿퀬 �꽆�뼱 �샂
//		public void menu1_1() {
//			
//			try {
//				//�엯�젰 諛쏆� 媛믪쓣 db2022_infectedperson�뿉 insert�븯�뒗 荑쇰━
//				String SQL;
//				SQL = "INSERT INTO db2022_infectedperson (name, disease, age, underlying_disease, Infected, residential_area)" 
//						+ "VALUES ('" + UserName + "', '" + UserDisease + "', " + Integer.parseInt(UserAge) + ", '" + UserDiseaseOX.charAt(0) + "', '" + UserInfectDate + "', '" + UserLocation + "')";
//				int re = st.executeUpdate(SQL);
//				
//				if (re==1) {
//					System.out.println("�솚�옄�쓽 �뜲�씠�꽣媛� �꽦怨듭쟻�쑝濡� �궫�엯�릺�뿀�뒿�땲�떎.");
//				}
//				
//				//�떎瑜� �뀒�씠釉붽퉴吏� �뾽�뜲�씠�듃
//				st.executeUpdate("update db2022_InfectedPerson X natural join db2022_area Y\r\n"
//	                    + "set Y.patient_Ebola= case when X.disease= \"Ebola\" then Y.patient_Ebola+1 else Y.patient_Ebola end,\r\n"
//	                    + "Y.patient_Corona= case when X.disease= \"Corona\" then Y.patient_Corona+1 else Y.patient_Corona end,\r\n"
//	                    + "Y.patient_Mers= case when X.disease= \"Mers\" then Y.patient_Mers+1 else Y.patient_Mers end,\r\n"
//	                    + "Y.patient_SARS= case when X.disease= \"SARS\" then Y.patient_SARS+1 else Y.patient_SARS end\r\n"
//	                    + "where X.residential_area=Y.area and X.name='"+UserName+"'AND age='"+UserAge+"'");
//				
//				//�꽦怨듯뻽�떎�뒗 �븞�궡李� �쓣�슦湲�
//				FrameResult_success window1 = new FrameResult_success();
//				window1.frame.setVisible(true);
//				
//				//�궫�엯 �썑 �솚�옄 紐⑸줉 蹂댁뿬二쇨린 
//				String SQL_1;
//				System.out.printf("\n%-16s %-8s %-10s %-11s %-14s %-6s %-6s %-6s %-6s\n","name","disease","underlying","Infected","area","Ebola","Corona","Mers","SARS");
//				System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
//				SQL="select name,disease,underlying_disease,Infected,area,patient_Ebola,patient_Corona,patient_Mers,patient_SARS\r\n"
//						+ "from db2022_InfectedPerson natural join db2022_area\r\n"
//						+ "where db2022_InfectedPerson.residential_area=db2022_area.area;";
//				rs=st.executeQuery(SQL);
//				while(rs.next())
//				{
//					System.out.printf("%-16s %-8s %-10s %-11s %-14s %-6s %-6s %-6s %-6s\n",rs.getString("name"),rs.getString("disease"),rs.getString("underlying_disease"),
//							rs.getString("Infected"),rs.getString("area"),rs.getString("patient_Ebola"),rs.getString("patient_Corona"),rs.getString("patient_Mers"),rs.getString("patient_SARS"));
//					}
//				
//			}
//			catch(Exception e) {
//				System.out.println("�뜲�씠�꽣踰좎씠�뒪 寃��깋 �삤瑜�: "+e.getMessage());
//			}
//		}
//
//		
//	//�궗�슜�옄媛� 2踰� �꽑�깮�븯硫� �떎�뻾�릺�뒗 �븿�닔
//	public void menu2() {
//		try {
//			FrameMenu2 window = new FrameMenu2();
//			window.frame.setVisible(true);
//		}
//		catch(Exception e) {
//			System.out.println("�뜲�씠�꽣踰좎씠�뒪 寃��깋 �삤瑜�: "+e.getMessage());
//		}
//		
//	}
//	
//	public void menu2_1(String name,int age_1, String disease,String area,String date, String YorN) {
//		try {
//			//留덉�留됯퉴吏� name怨� age�뿉 �씪移섑븯�뒗 �젙蹂닿� �엳�뒗吏� �솗�씤�빐以� 蹂��닔 finish
//			int finish=0;
//			//name怨� age�뿉 �씪移섑븯�뒗 �젙蹂닿� �엳�뒗吏� �솗�씤�빐二쇰뒗 遺�遺�
//			String a="";
//			String SQL_1="select case when name='"+name+"' and age='"+age_1+"' then 1\r\n"
//					+ "else 0\r\n"
//					+ "end as exist\r\n"
//					+ "from db2022_InfectedPerson;";
//			rs=st.executeQuery(SQL_1);
//			
//			 while(rs.next()) {
//				 if(rs.getString("exist").contains("1")) {
//					
//					//�빐�떦 �궗�슜�옄媛� 嫄곗＜�뻽�뜕 �씠�쟾 吏��뿭�뿉�꽌, �빐�떦 �궗�슜�옄�쓽 吏��뿭 �솚�옄�닔瑜� 媛먯냼�떆�궡 
//					st.executeUpdate("update db2022_InfectedPerson X natural join db2022_area Y\r\n"
//							+ "set Y.patient_Ebola= case when X.disease= \"Ebola\" then Y.patient_Ebola-1 else Y.patient_Ebola end,\r\n"
//							+ "Y.patient_Corona= case when X.disease= \"Corona\" then Y.patient_Corona-1 else Y.patient_Corona end,\r\n"
//							+ "Y.patient_Mers= case when X.disease= \"Mers\" then Y.patient_Mers-1 else Y.patient_Mers end,\r\n"
//							+ "Y.patient_SARS= case when X.disease= \"SARS\" then Y.patient_SARS-1 else Y.patient_SARS end\r\n"
//							+ "where X.residential_area=Y.area and X.name='"+name+"'AND age='"+age_1+"'");
//					//�엯�젰�븳 �젙蹂댁� �씠由꾧낵 �굹�씠媛� 媛숈� �궗�엺�쓽 �젙蹂대�� gui�쓽 �뀓�뒪�듃�븘�뱶�� 肄ㅻ낫諛뺤뒪�뿉�꽌 媛��졇�삩 �젙蹂대줈 �뾽�뜲�씠�듃 �븳�떎. 
//					st.executeUpdate(
//							"UPDATE DB2022_InfectedPerson  "
//							+ "SET disease='"+disease+"',residential_area='"+area+"',underlying_disease='"+YorN+"',Infected='"+date+"'"
//									+ "WHERE name='"+name+"' AND age='"+age_1+"'"
//							);
//					//�빐�떦 �궗�슜�옄媛� 嫄곗＜�븯�뒗 �깉濡쒖슫 吏��뿭�뿉�꽌, �빐�떦 �궗�슜�옄�쓽 吏��뿭 �솚�옄�닔瑜� 利앷��떆�궡
//					st.executeUpdate("update db2022_InfectedPerson X natural join db2022_area Y\r\n"
//							+ "set Y.patient_Ebola= case when X.disease= \"Ebola\" then Y.patient_Ebola+1 else Y.patient_Ebola end,\r\n"
//							+ "Y.patient_Corona= case when X.disease= \"Corona\" then Y.patient_Corona+1 else Y.patient_Corona end,\r\n"
//							+ "Y.patient_Mers= case when X.disease= \"Mers\" then Y.patient_Mers+1 else Y.patient_Mers end,\r\n"
//							+ "Y.patient_SARS= case when X.disease= \"SARS\" then Y.patient_SARS+1 else Y.patient_SARS end\r\n"
//							+ "where X.residential_area=Y.area and X.name='"+name+"'AND age='"+age_1+"'");
//					//�꽦怨듯뻽�떎�뒗 �븞�궡李� �쓣�슦湲�
//					
//					//�솚�옄 �젙蹂� 異쒕젰
//					String SQL;
//					System.out.println("\n"+name+"�쓽 �젙蹂닿� �떎�쓬怨� 媛숈씠 �닔�젙�릺�뿀怨�, 吏��뿭 �궡 �솚�옄 �닔�룄 蹂�寃쎈릺�뿀�뒿�땲�떎.");
//					System.out.printf("%-16s %-8s %-10s %-11s %-14s %-6s %-6s %-6s %-6s\n","name","disease","underlying","Infected","area","Ebola","Corona","Mers","SARS");
//					System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
//					SQL="select name,disease,underlying_disease,Infected,area,patient_Ebola,patient_Corona,patient_Mers,patient_SARS\r\n"
//							+ "from db2022_InfectedPerson natural join db2022_area\r\n"
//							+ "where db2022_InfectedPerson.residential_area=db2022_area.area;";
//					rs=st.executeQuery(SQL);
//					while(rs.next())
//					{
//						System.out.printf("%-16s %-8s %-10s %-11s %-14s %-6s %-6s %-6s %-6s\n",rs.getString("name"),rs.getString("disease"),rs.getString("underlying_disease"),
//								rs.getString("Infected"),rs.getString("area"),rs.getString("patient_Ebola"),rs.getString("patient_Corona"),rs.getString("patient_Mers"),rs.getString("patient_SARS"));
//						}
//					finish=1;
//					FrameResult_success window1 = new FrameResult_success();
//					window1.frame.setVisible(true);
//					break;
//					}
//				 else finish=0;	 
//			}
//			 //�걹源뚯� �젙蹂닿� �뾾�뿀�떎硫� �뾾�뿀�떎怨� 異쒕젰
//			 if(finish==0) {System.out.println(age_1+"�꽭�쓽 "+name+"�� �뾾�뒗 �젙蹂댁엯�땲�떎. ");
//				FrameResult_fail window1 = new FrameResult_fail();
//				window1.frame.setVisible(true);
//			 }
//		}
//		catch(Exception e) {
//			System.out.println("�뜲�씠�꽣踰좎씠�뒪 寃��깋 �삤瑜�: "+e.getMessage());
//			
//		}
//	}
//	
//	
//	//3踰덈찓�돱
//	
//	public void menu3() {
//		try {
//			String SQL;
//			//�쁽�옱 �떆媛곸씠 open, close �궗�씠�뿉 �엳�뒗 蹂묒썝�쓽 ID �꽑�깮�븯�뒗 SQL援щЦ
//			SQL="SELECT ID FROM DB2022_MedicalCenter WHERE CURTIME() between open and close;";
//			//荑쇰━ �떎�뻾
//			rs=st.executeQuery(SQL);
//			if(!rs.next()) { //議곌굔�뿉 �빐�떦�븯�뒗 蹂묒썝�씠 �뾾�뒗 寃쎌슦 �븞�궡 硫붿꽭吏� 異쒕젰
//				System.out.println("�쁽�옱 �슫�쁺 以묒씤 蹂묒썝 �뾾�쓬");
//			}
//			else {
//				System.out.println("�쁽�옱 �슫�쁺 以묒씤 蹂묒썝 由ъ뒪�듃");
//				System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
//			while(rs.next())//議곌굔�뿉 �빐�떦�븯�뒗 蹂묒썝 由ъ뒪�듃 異쒕젰
//			{
//				System.out.println(rs.getString("ID"));
//			}
//			FrameResult_success window1 = new FrameResult_success();
//			window1.frame.setVisible(true);
//			}
//			
//		}
//		catch(Exception e) {//�삁�쇅泥섎━
//			System.out.println("�뜲�씠�꽣踰좎씠�뒪 寃��깋 �삤瑜�: "+e.getMessage());
//		}
//		
//	}
//	
//	public void menu4() {
//		/*FrameMenu4 window = new FrameMenu4();
//		window.frame.setVisible(true);*/
//		/*	吏��뿭 �궡 �쁽�옱 �슫�쁺 以묒씤 寃��궗�냼 異쒕젰(吏꾨즺紐⑹쟻)
//			; 寃��궗�냼 �슫�쁺 �떆�옉 < 吏�湲�  �떆媛� < �슫�쁺 留덇컧 �떆媛�.*/  //�룞�뀋
//			try {
//				String SQL;
//				SQL="select name
//                      from db2022_RegionalCenter
//                      where id in (
//                      select id
//                      from db2022_Regionalcenter
//                      where CURTIME() between open and close);
//                    "; 
//				rs=st.executeQuery(SQL);
//				System.out.println("�쁽�옱 �슫�쁺 以묒씤 寃��궗�냼 由ъ뒪�듃");
//				System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
//
//				while(rs.next())
//				{
//					System.out.println(rs.getString("name"));
//				}
//				FrameResult_success window1 = new FrameResult_success();
//				window1.frame.setVisible(true);
//			}
//			catch(Exception e) {
//				
//				System.out.println("�뜲�씠�꽣踰좎씠�뒪 寃��깋 �삤瑜�: "+e.getMessage());
//			}
//	}
//	
//	public void menu5() {
//		try {
//			String SQL;
//			SQL="SELECT *FROM DB2022_medicalcenter ORDER BY wait asc"; //��湲곗씤�썝�쓣 湲곗��쑝濡� �삤由꾩감�닚 �젙�젹 �썑 �쓽猷뚯냼 �쟾泥� �뒠�뵆 �꽑�깮
//			
//			//荑쇰━ �떎�뻾
//			rs=st.executeQuery(SQL); 
//			System.out.printf("%-45s %-10s %-15s %-15s %-13s %-13s %-3s","�쓽猷뚯냼","醫낅쪟","�쐞移�","踰덊샇","�뿬�뒗 �떆媛�","�떕�뒗 �떆媛�","��湲� �씤�썝");
//			 // 媛� �뿴�뿉 �뼱�뼡 寃껋쓣 �쓽誘명븯�뒗吏�
//			System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------"); 
//			
//			while(rs.next())
//			{//�쓽猷뚯냼 �쟾泥� �뒠�뵆 異쒕젰
//				System.out.printf("%-45s %-10s %-15s %-15s %-13s %-13s %-3s\n",rs.getString("ID"),rs.getString("kind"),rs.getString("location"),rs.getString("tel"),rs.getString("open"),rs.getString("close"),rs.getString("wait"));
//}
//			FrameResult_success window1 = new FrameResult_success();
//			window1.frame.setVisible(true);
//		}
//		catch(Exception e) {
//			System.out.println("�뜲�씠�꽣踰좎씠�뒪 寃��깋 �삤瑜�: "+e.getMessage());
//		}
//	}
//	
//	public void menu6(String patient_name) {
//		try {
//			String SQL;
//			SQL="SELECT name, disease, quarantine_period, infected, DATE_ADD(infected, INTERVAL quarantine_period DAY)\r\n"
//					+ "FROM DB2022_InfectedPerson, DB2022_Epidemic\r\n"
//					+ "WHERE DB2022_InfectedPerson.disease = DB2022_Epidemic.ID and name = \"" + patient_name + "\"";
//			rs=st.executeQuery(SQL);
//			System.out.printf("%-10s %-10s %-11s %-14s","�씠由�", "吏덈퀝", "�솗吏꾨궇吏�", "寃⑸━�빐�젣 �궇吏�");
//			System.out.println("\n--------------------------------------------------------------------------"); 
//
//			while(rs.next())
//			{
//				System.out.printf("%-10s %-10s %-14s %-14s\n",rs.getString("name"), rs.getString("disease"), rs.getString("infected"), rs.getString("DATE_ADD(infected, INTERVAL quarantine_period DAY)"));
//			}
//			FrameResult_success window1 = new FrameResult_success();
//			window1.frame.setVisible(true);
//		}
//		catch(Exception e) {
//			System.out.println("�뜲�씠�꽣踰좎씠�뒪 寃��깋 �삤瑜�: "+e.getMessage());
//		}
//	}	
//
//	//�궗�슜�옄媛� 7踰� �꽑�깮�븯硫� �떎�뻾�릺�뒗 �븿�닔 : 媛먯뿼�옄 �닔 留롮� 吏��뿭 �닚�꽌��濡� view 異쒕젰 
//		public void menu7() {
//			try {
//				int num = 1; //異뷀썑 console�뿉 異쒕젰�븷 �닚�쐞
//				int check = 0; //view 留뚮뱾�뼱�졇 �엳�뒗吏� 泥댄겕�븯�뒗 蹂��닔
//				
//				//view 留뚮뱾�뼱�졇 �엳�뒗吏� 泥댄겕�븯�뒗 荑쇰━
//				String SQL;
//				SQL = "SELECT COUNT(*) FROM information_schema.tables "
//						+ "WHERE table_schema = 'db2022team04' AND table_name = 'db2022_arearank'";
//				rs=st.executeQuery(SQL);
//				
//				while (rs.next()) {
//					check = rs.getInt(1); //view媛� 議댁옱�븯硫� 1, 議댁옱�븯吏� �븡�쑝硫� 0
//				}
//				
//				//view媛� 議댁옱�븯吏� �븡�쓣 �븣 create�븯�뒗 荑쇰━
//				if (check!=1) { 
//					String SQL1;
//					SQL1="CREATE VIEW DB2022_AreaRank " 
//							+ "AS SELECT residential_area, COUNT(residential_area) AS total_patient " 
//							+ "FROM DB2022_InfectedPerson " 
//							+ "GROUP BY residential_area " 
//							+ "ORDER BY total_patient DESC";
//					int re = st.executeUpdate(SQL1);
//					
//					if (re==0) {
//						System.out.println("create view �꽦怨�!");
//					}
//					
//				}
//				
//				//view瑜� 異쒕젰�븯�뒗 荑쇰━
//				String SQL2;
//				SQL2="SELECT * from DB2022_AreaRank";
//				rs=st.executeQuery(SQL2);
//				
//
//				System.out.printf("%-4s %-17s %-2s", "�닚�쐞", "吏��뿭", "�솚�옄 �닔");
//				System.out.println("\n--------------------------------------------------------------------------"); 
//
//				//console�뿉 view 異쒕젰
//				while(rs.next())
//				{
//					String residential_area = rs.getString(1);
//					int Patient_Num = rs.getInt(2);
//					System.out.printf("%-4s %-17s %-4s\n",num, residential_area, Patient_Num);
//					num++;
//				}
//				FrameResult_success window1 = new FrameResult_success();
//				window1.frame.setVisible(true);
//				
//			}
//			catch(Exception e) {
//				System.out.println("�뜲�씠�꽣踰좎씠�뒪 寃��깋 �삤瑜�: "+e.getMessage());
//			}
//		}
//
//	
//	public void menu8() {
//		try {
//			String SQL; String SQL1;
//			SQL="select area,\r\n"
//					+ "case GREATEST(patient_Ebola,patient_Corona,patient_Mers,patient_SARS)\r\n"
//					+ "when patient_Ebola\r\n"
//					+ "then\r\n"
//					+ "case\r\n"
//					+ "when(patient_Ebola=0) \r\n"
//					+ "then 'none'\r\n"
//					+ "when patient_Ebola!=0 and\r\n"
//					+ "patient_Ebola =patient_Corona\r\n"
//					+ "or patient_Ebola= patient_Mers\r\n"
//					+ "or patient_Ebola= patient_SARS\r\n"
//					+ "then 'Ebola and more'\r\n"
//					+ "end\r\n"
//					+ "when patient_Corona\r\n"
//					+ "then case\r\n"
//					+ "when patient_Corona!=0 and patient_Corona =patient_Ebola\r\n"
//					+ "or patient_Corona= patient_Mers\r\n"
//					+ "or patient_Corona= patient_SARS\r\n"
//					+ "then 'Corona and more'\r\n"
//					+ "else 'Corona'\r\n"
//					+ "end\r\n"
//					+ "when patient_Mers \r\n"
//					+ "then case\r\n"
//					+ "when patient_Mers!=0 and patient_Mers =patient_Ebola\r\n"
//					+ "or patient_Mers= patient_Corona\r\n"
//					+ "or patient_Mers= patient_SARS\r\n"
//					+ "then 'Mers and SARS'\r\n"
//					+ "else 'Mers'\r\n"
//					+ "end\r\n"
//					+ "when patient_SARS Then 'SARS'\r\n"
//					+ "End as 'disease'\r\n"
//					+ "from db2022_Area;\r\n"
//					+ "";
//			rs=st.executeQuery(SQL);
//			System.out.printf("%-14s %-15s\n","吏��뿭", "�솚�옄 �닔 留롮� �쟾�뿼蹂�");
//			System.out.println("--------------------------------------------------------------------------"); 
//
//			while(rs.next()) {
//				System.out.printf("%-15s %-15s\n",rs.getString(1),rs.getString(2));
//			}
//			FrameResult_success window1 = new FrameResult_success();
//			window1.frame.setVisible(true);			
//		}
//		catch(Exception e) {
//			System.out.println("�뜲�씠�꽣踰좎씠�뒪 寃��깋 �삤瑜�: "+e.getMessage());
//		}
//	}
//	
//	public void menu9() {
//		try {
//			String SQL;
//			//�궗�쟾�뿉 留뚮뱾�뼱�몦 view DB2022_EpidemicRank �씠�슜, 吏��뿭怨� 媛� �쟾�뿼蹂묐떦 媛먯뿼�옄 �닔 �꽑�깮
//			SQL="SELECT area, Ebola, Corona, Mers, Sars FROM DB2022_EpidemicRank;";
//			rs=st.executeQuery(SQL); //SQL 援щЦ �떎�뻾
//			System.out.println("吏��뿭\t\t Ebola\t Corona\t Mers\t Sars"); //媛� �뿴�씠 臾댁뾿�쓣 �굹���궡�뒗吏� �븣�젮以�
//			System.out.println("--------------------------------------------------------------------------"); 
//
//			while(rs.next())
//			{
//				//吏��뿭紐낃낵 媛� �쟾�뿼蹂� �떦 媛먯뿼�옄 �닔 異쒕젰
//				System.out.println(rs.getString("area") +"  \t" + rs.getString("Ebola") +
//				"\t" + rs.getString("Corona") + "\t" + rs.getString("Mers") 
//				+ "\t" +rs.getString("Sars"));
//			}
//			FrameResult_success window1 = new FrameResult_success();
//			window1.frame.setVisible(true);		
//		}
//		catch(Exception e) { //�삁�쇅泥섎━
//			System.out.println("�뜲�씠�꽣踰좎씠�뒪 寃��깋 �삤瑜�: "+e.getMessage());
//		}
//	}
//	
//	public void menu10() {
//		try {
//			String SQL;
//		
//			SQL="select disease, count(ID) as num_of_infected\r\n"
//					+ "  from DB2022_InfectedPerson\r\n"
//					+ "  group by disease; ";
//			rs=st.executeQuery(SQL);
//			System.out.printf("%-10s %-3s","吏덈퀝","�솚�옄 �닔");
//			System.out.println("\n--------------------------------------------------------------------------"); 
//
//			while(rs.next())
//			{
//				System.out.printf("%-10s %-3s\n",rs.getString("disease"), rs.getString("num_of_infected"));
//		}
//			FrameResult_success window1 = new FrameResult_success();
//			window1.frame.setVisible(true);	
//		}
//		catch(Exception e) {
//			System.out.println("�뜲�씠�꽣踰좎씠�뒪 寃��깋 �삤瑜�: "+e.getMessage());
//		}
//	}
//	
//	public void menu11() {
//		try {
//			String SQL;
//			SQL="SELECT disease, avg(age) as avg_age, min(infected) as outbreak\r\n" //�쟾�뿼蹂묒쓣 湲곗��쑝濡� 洹몃９�솕 �븳 �썑 �쟾�뿼蹂� 蹂� 媛먯뿼 �룊洹� �굹�씠�� 理쒖큹 諛쒕퀝 �궇吏� 怨꾩궛
//				+ "FROM DB2022_infectedPerson\r\n"
//				+ "group by disease;\r\n";
//			
//			//荑쇰━ �떎�뻾
//			rs=st.executeQuery(SQL);
//			System.out.printf("%-10s %-10s %-15s","吏덈퀝", "�룊洹좊굹�씠","諛쒕퀝�궇吏�");
//			
//			System.out.println("\n------------------------------------------------"); 
//			FrameResult_success window1 = new FrameResult_success();
//			window1.frame.setVisible(true);
//
//			while(rs.next())
//			{//�쟾�뿼蹂� �씠由꾧낵 媛� �쟾�뿼蹂묒쓽 媛먯뿼 �룊洹� �굹�씠�� 理쒖큹 諛쒕퀝 �궇吏� 異쒕젰
//				System.out.printf("%-10s %-10s %-15s\n",rs.getString("disease"), rs.getString("avg_age"), rs.getString("outbreak"));
//		}
//		}
//		catch(Exception e) {
//			System.out.println("�뜲�씠�꽣踰좎씠�뒪 寃��깋 �삤瑜�: "+e.getMessage());
//		}
//	}
//	
//	
//}
//	
//	// �뮘�뿉 留덉� �뿰寃고빐二쇰㈃ �맆 寃� 媛숈븘�슂~
//	
//
//
