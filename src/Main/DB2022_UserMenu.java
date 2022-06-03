package Main;

import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Frame.DB2022_FrameResult_success;
import Frame.DB2022_FrameResult_fail;
import Frame.DB2022_FrameMenu1;
import Frame.DB2022_FrameMenu2;
import Frame.DB2022_FrameMenu4;
import Frame.DB2022_FrameMenu6;

public class DB2022_UserMenu {
	private Connection con;
	private Connection con_1;
	private Statement st;
	private Statement st_1;
	private ResultSet rs;
	private ResultSet rs_1;
	public String UserName, UserDisease, UserAge, UserDiseaseOX, UserInfectDate, UserLocation, patient_name;
	int number;

	// 컴퓨터에 있는 SQL과 연결해주는 코드
	public DB2022_UserMenu() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB2022Team04", "root", "996363Kim~~");
			con_1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB2022Team04", "root", "996363Kim~~");
			st = con.createStatement();
			st_1 = con_1.createStatement();
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 오류:" + e.getMessage());
		}
	}

	// 사용자가 선택한 번호에 따라 해당 함수로 보내 줌
	public void menu(String number) {
		this.number = Integer.parseInt(number);
		if (this.number == 1)
			menu1();
		else if (this.number == 2)
			menu2();
		else if (this.number == 3)
			menu3();
		else if (this.number == 4)
			menu4();
		else if (this.number == 5)
			menu5();
		else if (this.number == 6) {
			DB2022_FrameMenu6 window = new DB2022_FrameMenu6();
			window.frame.setVisible(true);
		} else if (this.number == 7)
			menu7();
		else if (this.number == 8)
			menu8();
		else if (this.number == 9)
			menu9();
		else if (this.number == 10)
			menu10();
		else if (this.number == 11)
			menu11();

	}

	// 사용자가 1번 선택하면 실행되는 함수
	public void menu1() {
		DB2022_FrameMenu1 window = new DB2022_FrameMenu1();
		window.frame.setVisible(true);
	}

	// 환자 정보 입력 창에서 확인을 누르고 넘어 옴
	public void menu1_1() {

		try {
			// 입력 받은 값을 db2022_infectedperson에 insert하는 쿼리
			String SQL;
			SQL = "INSERT INTO db2022_infectedperson (name, disease, age, underlying_disease, Infected, residential_area)"
					+ "VALUES ('" + UserName + "', '" + UserDisease + "', " + Integer.parseInt(UserAge) + ", '"
					+ UserDiseaseOX.charAt(0) + "', '" + UserInfectDate + "', '" + UserLocation + "')";
			int re = st.executeUpdate(SQL);

			if (re == 1) {
				System.out.println("환자의 데이터가 성공적으로 삽입되었습니다.");
			}

			// 다른 테이블까지 업데이트
			st.executeUpdate("update db2022_InfectedPerson X natural join db2022_area Y\r\n"
					+ "set Y.patient_Ebola= case when X.disease= \"Ebola\" then Y.patient_Ebola+1 else Y.patient_Ebola end,\r\n"
					+ "Y.patient_Corona= case when X.disease= \"Corona\" then Y.patient_Corona+1 else Y.patient_Corona end,\r\n"
					+ "Y.patient_Mers= case when X.disease= \"Mers\" then Y.patient_Mers+1 else Y.patient_Mers end,\r\n"
					+ "Y.patient_SARS= case when X.disease= \"SARS\" then Y.patient_SARS+1 else Y.patient_SARS end\r\n"
					+ "where X.residential_area=Y.area and X.name='" + UserName + "'AND age='" + UserAge + "'");

			// 성공했다는 안내창 띄우기
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);

			// 삽입 후 환자 목록 보여주기
			String SQL_1;
			System.out.printf("\n%-16s %-8s %-10s %-11s %-14s %-6s %-6s %-6s %-6s\n", "name", "disease", "underlying",
					"Infected", "area", "Ebola", "Corona", "Mers", "SARS");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------");
			SQL = "select name,disease,underlying_disease,Infected,area,patient_Ebola,patient_Corona,patient_Mers,patient_SARS\r\n"
					+ "from db2022_InfectedPerson natural join db2022_area\r\n"
					+ "where db2022_InfectedPerson.residential_area=db2022_area.area;";
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				System.out.printf("%-16s %-8s %-10s %-11s %-14s %-6s %-6s %-6s %-6s\n", rs.getString("name"),
						rs.getString("disease"), rs.getString("underlying_disease"), rs.getString("Infected"),
						rs.getString("area"), rs.getString("patient_Ebola"), rs.getString("patient_Corona"),
						rs.getString("patient_Mers"), rs.getString("patient_SARS"));
			}

		} catch (Exception e) {
			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
		}
	}

	// 사용자가 2번 선택하면 실행되는 함수
	public void menu2() {
		try {
			DB2022_FrameMenu2 window = new DB2022_FrameMenu2();
			window.frame.setVisible(true);
		} catch (Exception e) {
			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
		}

	}

	public void menu2_1(String name, int age_1, String disease, String area, String date, String YorN) {
		try {
			// 마지막까지 name과 age에 일치하는 정보가 있는지 확인해줄 변수 finish
			int finish = 0;
			// name과 age에 일치하는 정보가 있는지 확인해주는 부분
			String a = "";
			String SQL_1 = "select case when name='" + name + "' and age='" + age_1 + "' then 1\r\n" + "else 0\r\n"
					+ "end as exist\r\n" + "from db2022_InfectedPerson;";
			rs = st.executeQuery(SQL_1);

			while (rs.next()) {
				if (rs.getString("exist").contains("1")) {

					// 해당 사용자가 거주했던 이전 지역에서, 해당 사용자의 지역 환자수를 감소시킴
					st.executeUpdate("update db2022_InfectedPerson X natural join db2022_area Y\r\n"
							+ "set Y.patient_Ebola= case when X.disease= \"Ebola\" then Y.patient_Ebola-1 else Y.patient_Ebola end,\r\n"
							+ "Y.patient_Corona= case when X.disease= \"Corona\" then Y.patient_Corona-1 else Y.patient_Corona end,\r\n"
							+ "Y.patient_Mers= case when X.disease= \"Mers\" then Y.patient_Mers-1 else Y.patient_Mers end,\r\n"
							+ "Y.patient_SARS= case when X.disease= \"SARS\" then Y.patient_SARS-1 else Y.patient_SARS end\r\n"
							+ "where X.residential_area=Y.area and X.name='" + name + "'AND age='" + age_1 + "'");
					// 입력한 정보와 이름과 나이가 같은 사람의 정보를 gui의 텍스트필드와 콤보박스에서 가져온 정보로 업데이트 한다.
					st.executeUpdate("UPDATE DB2022_InfectedPerson  " + "SET disease='" + disease
							+ "',residential_area='" + area + "',underlying_disease='" + YorN + "',Infected='" + date
							+ "'" + "WHERE name='" + name + "' AND age='" + age_1 + "'");
					// 해당 사용자가 거주하는 새로운 지역에서, 해당 사용자의 지역 환자수를 증가시킴
					st.executeUpdate("update db2022_InfectedPerson X natural join db2022_area Y\r\n"
							+ "set Y.patient_Ebola= case when X.disease= \"Ebola\" then Y.patient_Ebola+1 else Y.patient_Ebola end,\r\n"
							+ "Y.patient_Corona= case when X.disease= \"Corona\" then Y.patient_Corona+1 else Y.patient_Corona end,\r\n"
							+ "Y.patient_Mers= case when X.disease= \"Mers\" then Y.patient_Mers+1 else Y.patient_Mers end,\r\n"
							+ "Y.patient_SARS= case when X.disease= \"SARS\" then Y.patient_SARS+1 else Y.patient_SARS end\r\n"
							+ "where X.residential_area=Y.area and X.name='" + name + "'AND age='" + age_1 + "'");
					// 성공했다는 안내창 띄우기

					// 환자 정보 출력
					String SQL;
					System.out.println("\n" + name + "의 정보가 다음과 같이 수정되었고, 지역 내 환자 수도 변경되었습니다.");
					System.out.printf("%-16s %-8s %-10s %-11s %-14s %-6s %-6s %-6s %-6s\n", "name", "disease",
							"underlying", "Infected", "area", "Ebola", "Corona", "Mers", "SARS");
					System.out.println(
							"---------------------------------------------------------------------------------------------------------------------------------");
					SQL = "select name,disease,underlying_disease,Infected,area,patient_Ebola,patient_Corona,patient_Mers,patient_SARS\r\n"
							+ "from db2022_InfectedPerson natural join db2022_area\r\n"
							+ "where db2022_InfectedPerson.residential_area=db2022_area.area;";
					rs = st.executeQuery(SQL);
					while (rs.next()) {
						System.out.printf("%-16s %-8s %-10s %-11s %-14s %-6s %-6s %-6s %-6s\n", rs.getString("name"),
								rs.getString("disease"), rs.getString("underlying_disease"), rs.getString("Infected"),
								rs.getString("area"), rs.getString("patient_Ebola"), rs.getString("patient_Corona"),
								rs.getString("patient_Mers"), rs.getString("patient_SARS"));
					}
					finish = 1;
					DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
					window1.frame.setVisible(true);
					break;
				} else
					finish = 0;
			}
			// 끝까지 정보가 없었다면 없었다고 출력
			if (finish == 0) {
				System.out.println(age_1 + "세의 " + name + "은 없는 정보입니다. ");
				DB2022_FrameResult_fail window1 = new DB2022_FrameResult_fail();
				window1.frame.setVisible(true);
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 검색 오류: " + e.getMessage());

		}
	}

	// 3번메뉴

	public void menu3() {
		try {
			String SQL;
			// 현재 시각이 open, close 사이에 있는 병원의 ID 선택하는 SQL구문
			SQL = "SELECT ID FROM DB2022_MedicalCenter WHERE CURTIME() between open and close;";
			// 쿼리 실행
			rs = st.executeQuery(SQL);
			if (!rs.next()) { // 조건에 해당하는 병원이 없는 경우 안내 메세지 출력
				System.out.println("현재 운영 중인 병원 없음");
			} else {
				System.out.println("현재 운영 중인 병원 리스트");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------");
				while (rs.next())// 조건에 해당하는 병원 리스트 출력
				{
					System.out.println(rs.getString("ID"));
				}
				DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
				window1.frame.setVisible(true);
			}

		} catch (Exception e) {// 예외처리
			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
		}

	}

	public void menu4() {
		/*
		 * FrameMenu4 window = new FrameMenu4(); window.frame.setVisible(true);
		 */
		/*
		 * 지역 내 현재 운영 중인 검사소 출력(진료목적) ; 검사소 운영 시작 < 지금 시간 < 운영 마감 시간.
		 */
		try {
			String SQL;
			SQL = "select name from db2022_RegionalCenter where id in "
					+ "(select id from db2022_Regionalcenter where CURTIME() between open and close);";
			rs = st.executeQuery(SQL);
			System.out.println("현재 운영 중인 검사소 리스트");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------");

			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);
		} catch (Exception e) {

			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
		}
	}

	public void menu5() {
		try {
			String SQL;
			SQL = "SELECT *FROM DB2022_medicalcenter ORDER BY wait asc"; // 대기인원을 기준으로 오름차순 정렬 후 의료소 전체 튜플 선택

			// 쿼리 실행
			rs = st.executeQuery(SQL);
			System.out.printf("%-45s %-10s %-15s %-15s %-13s %-13s %-3s", "의료소", "종류", "위치", "번호", "여는 시간", "닫는 시간",
					"대기 인원");
			// 각 열에 어떤 것을 의미하는지
			System.out.println(
					"\n---------------------------------------------------------------------------------------------------------------------------------");

			while (rs.next()) {// 의료소 전체 튜플 출력
				System.out.printf("%-45s %-10s %-15s %-15s %-13s %-13s %-3s\n", rs.getString("ID"),
						rs.getString("kind"), rs.getString("location"), rs.getString("tel"), rs.getString("open"),
						rs.getString("close"), rs.getString("wait"));
			}
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);
		} catch (Exception e) {
			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
		}
	}

	public void menu6(String patient_name) {
		try {
			String SQL;
			SQL = "SELECT name, disease, quarantine_period, infected, DATE_ADD(infected, INTERVAL quarantine_period DAY)\r\n"
					+ "FROM DB2022_InfectedPerson, DB2022_Epidemic\r\n"
					+ "WHERE DB2022_InfectedPerson.disease = DB2022_Epidemic.ID and name = \"" + patient_name + "\"";
			rs = st.executeQuery(SQL);
			System.out.printf("%-10s %-10s %-11s %-14s", "이름", "질병", "확진날짜", "격리해제 날짜");
			System.out.println("\n--------------------------------------------------------------------------");

			while (rs.next()) {
				System.out.printf("%-10s %-10s %-14s %-14s\n", rs.getString("name"), rs.getString("disease"),
						rs.getString("infected"), rs.getString("DATE_ADD(infected, INTERVAL quarantine_period DAY)"));
			}
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);
		} catch (Exception e) {
			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
		}
	}

	// 사용자가 7번 선택하면 실행되는 함수 : 감염자 수 많은 지역 순서대로 view 출력
	public void menu7() {
		try {
			int num = 1; // 추후 console에 출력할 순위
			int check = 0; // view 만들어져 있는지 체크하는 변수

			// view 만들어져 있는지 체크하는 쿼리
			String SQL;
			SQL = "SELECT COUNT(*) FROM information_schema.tables "
					+ "WHERE table_schema = 'db2022team04' AND table_name = 'db2022_arearank'";
			rs = st.executeQuery(SQL);

			while (rs.next()) {
				check = rs.getInt(1); // view가 존재하면 1, 존재하지 않으면 0
			}

			// view가 존재하지 않을 때 create하는 쿼리
			if (check != 1) {
				String SQL1;
				SQL1 = "CREATE VIEW DB2022_AreaRank "
						+ "AS SELECT residential_area, COUNT(residential_area) AS total_patient "
						+ "FROM DB2022_InfectedPerson " + "GROUP BY residential_area " + "ORDER BY total_patient DESC";
				int re = st.executeUpdate(SQL1);

				if (re == 0) {
					System.out.println("create view 성공!");
				}

			}

			// view를 출력하는 쿼리
			String SQL2;
			SQL2 = "SELECT * from DB2022_AreaRank";
			rs = st.executeQuery(SQL2);

			System.out.printf("%-4s %-17s %-2s", "순위", "지역", "환자 수");
			System.out.println("\n--------------------------------------------------------------------------");

			// console에 view 출력
			while (rs.next()) {
				String residential_area = rs.getString(1);
				int Patient_Num = rs.getInt(2);
				System.out.printf("%-4s %-17s %-4s\n", num, residential_area, Patient_Num);
				num++;
			}
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);

		} catch (Exception e) {
			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
		}
	}

	public void menu8() {
		try {
			String SQL;
			String SQL1;
			SQL = "select area,\r\n" + "case GREATEST(patient_Ebola,patient_Corona,patient_Mers,patient_SARS)\r\n"
					+ "when patient_Ebola\r\n" + "then\r\n" + "case\r\n" + "when(patient_Ebola=0) \r\n"
					+ "then 'none'\r\n" + "when patient_Ebola!=0 and\r\n" + "patient_Ebola =patient_Corona\r\n"
					+ "or patient_Ebola= patient_Mers\r\n" + "or patient_Ebola= patient_SARS\r\n"
					+ "then 'Ebola and more'\r\n" + "end\r\n" + "when patient_Corona\r\n" + "then case\r\n"
					+ "when patient_Corona!=0 and patient_Corona =patient_Ebola\r\n"
					+ "or patient_Corona= patient_Mers\r\n" + "or patient_Corona= patient_SARS\r\n"
					+ "then 'Corona and more'\r\n" + "else 'Corona'\r\n" + "end\r\n" + "when patient_Mers \r\n"
					+ "then case\r\n" + "when patient_Mers!=0 and patient_Mers =patient_Ebola\r\n"
					+ "or patient_Mers= patient_Corona\r\n" + "or patient_Mers= patient_SARS\r\n"
					+ "then 'Mers and SARS'\r\n" + "else 'Mers'\r\n" + "end\r\n" + "when patient_SARS Then 'SARS'\r\n"
					+ "End as 'disease'\r\n" + "from db2022_Area;\r\n" + "";
			rs = st.executeQuery(SQL);
			System.out.printf("%-14s %-15s\n", "지역", "환자 수 많은 전염병");
			System.out.println("--------------------------------------------------------------------------");

			while (rs.next()) {
				System.out.printf("%-15s %-15s\n", rs.getString(1), rs.getString(2));
			}
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);
		} catch (Exception e) {
			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
		}
	}

	public void menu9() {
		try {
			String SQL;
			// 사전에 만들어둔 view DB2022_EpidemicRank 이용, 지역과 각 전염병당 감염자 수 선택
			SQL = "SELECT area, Ebola, Corona, Mers, Sars FROM DB2022_EpidemicRank;";
			rs = st.executeQuery(SQL); // SQL 구문 실행
			System.out.println("지역\t\t Ebola\t Corona\t Mers\t Sars"); // 각 열이 무엇을 나타내는지 알려줌
			System.out.println("--------------------------------------------------------------------------");

			while (rs.next()) {
				// 지역명과 각 전염병 당 감염자 수 출력
				System.out.println(rs.getString("area") + "  \t" + rs.getString("Ebola") + "\t" + rs.getString("Corona")
						+ "\t" + rs.getString("Mers") + "\t" + rs.getString("Sars"));
			}
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);
		} catch (Exception e) { // 예외처리
			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
		}
	}

	public void menu10() {
		try {
			String SQL;

			SQL = "select disease, count(ID) as num_of_infected\r\n" + "  from DB2022_InfectedPerson\r\n"
					+ "  group by disease; ";
			rs = st.executeQuery(SQL);
			System.out.printf("%-10s %-3s", "질병", "환자 수");
			System.out.println("\n--------------------------------------------------------------------------");

			while (rs.next()) {
				System.out.printf("%-10s %-3s\n", rs.getString("disease"), rs.getString("num_of_infected"));
			}
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);
		} catch (Exception e) {
			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
		}
	}

	public void menu11() {
		try {
			String SQL;
			SQL = "SELECT disease, avg(age) as avg_age, min(infected) as outbreak\r\n" // 전염병을 기준으로 그룹화 한 후 전염병 별 감염 평균
																						// 나이와 최초 발병 날짜 계산
					+ "FROM DB2022_infectedPerson\r\n" + "group by disease;\r\n";

			// 쿼리 실행
			rs = st.executeQuery(SQL);
			System.out.printf("%-10s %-10s %-15s", "질병", "평균나이", "발병날짜");

			System.out.println("\n------------------------------------------------");
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);

			while (rs.next()) {// 전염병 이름과 각 전염병의 감염 평균 나이와 최초 발병 날짜 출력
				System.out.printf("%-10s %-10s %-15s\n", rs.getString("disease"), rs.getString("avg_age"),
						rs.getString("outbreak"));
			}
		} catch (Exception e) {
			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
		}
	}

}
