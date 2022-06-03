//package Main;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.swing.JOptionPane;
//import java.util.ArrayList;
//
//import Frame.FrameManager1_1;
//import Frame.FrameManager1_2;
//import Frame.FrameManager1_3;
//import Frame.FrameManager3_1;
//import Frame.FrameManager3_2;
//import Frame.FrameManager3_3;
//import Frame.FrameSIR;
//
//public class ManagerMenu {
//	private Connection con;
//	private Statement st;
//	private PreparedStatement pSt;
//	private ResultSet rs;
//	private String SQL;
//	public int check_people; //특정 지역 인구 수
//	public String UserDisease, UserLocation;
//
//	// 의료소 삽입을 위한 변수(관리자 메뉴 1-1)
//	public int edit;
//	public String name;
//	public String type;
//	public String area;
//	public String tel;
//	public String open;
//	public String close;
//	public int wait;
//	public String[] array;
//	public String[] area_list;
//
//	// 의료소 정보 수정을 위한 변수(관리자 메뉴 1-2)
//	public String[] medical_center_list;
//
//	// 검사소 정보 수정을 위한 변수(관리자 메뉴 4)
//	public String[] regional_center_list;
//
//	// SQL과 연결해주는 코드
//	public ManagerMenu() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB2022Team04", "DB2022Team04", "DB2022Team04");
//			st = con.createStatement();
//		} catch (Exception e) {
//			System.out.println("데이터베이스 연결 오류:" + e.getMessage());
//		}
//	}
//
//	// 관리자가 선택한 번호에 따라 해당 함수로 보내 줄거임
//	public void menu(String number) {
//		if (number.contains("2"))
//			menu2();
//		else if (number.contains("4")) {
//			menu8();
//		}
//	}
//
//	// 관리자 메뉴 (1)을 위한 함수
//	// 의료소 정보 수정 시 기존에 등록된 의료소 목록 확인
//	public String[] get_medical_center_list() {
//		try {
//			// 의료소 목록 검색 후 array_list에 저장
//			ArrayList<String> array_list = new ArrayList<String>();
//			array = null;
//			int index_count = 0;
//			SQL = "SELECT ID FROM DB2022_MedicalCenter";
//			rs = st.executeQuery(SQL);
//			while (rs.next()) {
//				array_list.add(rs.getString("ID"));
//			}
//			;
//
//			// 의료소 목록 변수형을 ArrayList -> array로 변경
//			array = new String[array_list.size()];
//			for (String temp : array_list) {
//				array[index_count++] = temp;
//			}
//
//		} catch (Exception e) {
//			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
//		}
//		return array;
//	}
//
//	// 관리자 메뉴 (1), (3)를 위한 함수
//	// 등록된 지역 목록 확인(지역 릴레이션에 포함된 지역으로만 수정 가능)
//	public String[] get_area_list() {
//		try {
//			// 지역 목록 검색 후 area_list에 저장
//			ArrayList<String> array_list = new ArrayList<String>();
//			array = null;
//			int index_count = 0;
//			SQL = "SELECT area FROM DB2022_Area";
//			rs = st.executeQuery(SQL);
//			array_list.add("");
//			while (rs.next()) {
//				array_list.add(rs.getString("area"));
//			}
//			;
//
//			// 지역 목록 변수형을 ArrayList -> Array로 변경
//			array = new String[array_list.size()];
//			for (String temp : array_list) {
//				array[index_count++] = temp;
//			}
//		} catch (Exception e) {
//			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
//		}
//		return array;
//	}
//
//	// 관리자 메뉴 (1)-1에 지역목록 넘김
//	public void activate_menu1_1() {
//		// 지역 목록 저장
//		area_list = null;
//		area_list = get_area_list();
//		// 검색된 지역 목록을 GUI 프레임으로 넘김
//		FrameManager1_1 window = new FrameManager1_1(area_list);
//		window.frame.setVisible(true);
//	}
//
//	// 관리자 메뉴 (1)-2에 지역목록, 의료소 목록 넘김
//	public void activate_menu1_2() {
//		// 지역 목록 저장
//		area_list = null;
//		medical_center_list = null;
//		area_list = get_area_list();
//		medical_center_list = get_medical_center_list();
//
//		// 검색된 지역 목록을 GUI 프레임으로 넘김
//		FrameManager1_2 window = new FrameManager1_2(area_list, medical_center_list);
//		window.frame.setVisible(true);
//
//	}
//
//	// 관리자 메뉴 (1)-3에 지역목록 넘김
//	public void activate_menu1_3() {
//		// 지역 목록 저장
//		medical_center_list = null;
//		medical_center_list = get_medical_center_list();
//
//		// 검색된 지역 목록을 GUI 프레임으로 넘김
//		FrameManager1_3 window = new FrameManager1_3(medical_center_list);
//		window.frame.setVisible(true);
//
//	}
//
//	// 관리자가 2번 선택하면 실행되는 함수
//	public void menu2() {
//		// FrameManager window = new FrameManager();
//		// window.frame.setVisible(true);
//		try {
//			String SQL;
//
//			SQL = "select I.name\r\n" + "from DB2022_InfectedPerson as I, DB2022_Epidemic as E\r\n"
//					+ "where I.disease = E.id and (I.underlying_disease = 'O' or\r\n" + "E.fatality_rate >= 0.5);\r\n"
//					+ " ";
//			rs = st.executeQuery(SQL);
//			System.out.println(" 고위험군 리스트 ");
//			System.out.println("---------------");
//			while (rs.next()) {
//				System.out.println(rs.getString(1));
//			}
//		} catch (Exception e) {
//			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
//		}
//		JOptionPane.showMessageDialog(null, "결과가 콘솔창에 출력되었습니다.\n", "출력완료안내", JOptionPane.INFORMATION_MESSAGE);
//
//	}
//
//	// 관리자 메뉴 (3)을 위한 함수
//	// 검사소 정보 수정 시 기존에 등록된 검사소 목록 확인
//	public String[] get_regional_center_list() {
//		try {
//			// 검사소 목록 검색 후 array_list에 저장
//			ArrayList<String> array_list = new ArrayList<String>();
//			array = null;
//			int index_count = 0;
//			SQL = "SELECT name FROM DB2022_RegionalCenter";
//			rs = st.executeQuery(SQL);
//			while (rs.next()) {
//				array_list.add(rs.getString("name"));
//			}
//			;
//
//			// 검사소 목록 변수형을 ArrayList -> array로 변경
//			array = new String[array_list.size()];
//			for (String temp : array_list) {
//				array[index_count++] = temp;
//			}
//
//		} catch (Exception e) {
//			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
//		}
//		return array;
//	}
//
//	// 관리자 메뉴 (3)-1에 지역목록 넘김
//	public void activate_menu3_1() {
//		// 지역 목록 저장
//		area_list = null;
//		area_list = get_area_list();
//
//		// 검색된 지역 목록을 GUI 프레임으로 넘김
//		FrameManager3_1 window = new FrameManager3_1(area_list);
//		window.frame.setVisible(true);
//
//	}
//
//	// 관리자 메뉴 (3)-2에 지역목록, 의료소 목록 넘김
//	public void activate_menu3_2() {
//		// 지역 목록 저장
//		area_list = null;
//		regional_center_list = null;
//		area_list = get_area_list();
//		regional_center_list = get_regional_center_list();
//
//		// 검색된 지역 목록을 GUI 프레임으로 넘김
//		FrameManager3_2 window = new FrameManager3_2(area_list, regional_center_list);
//		window.frame.setVisible(true);
//
//	}
//
//	// 관리자 메뉴 (3)-3에 지역목록 넘김
//	public void activate_menu3_3() {
//		// 지역 목록 저장
//		regional_center_list = null;
//		regional_center_list = get_regional_center_list();
//
//		// 검색된 지역 목록을 GUI 프레임으로 넘김
//		FrameManager3_3 window = new FrameManager3_3(regional_center_list);
//		window.frame.setVisible(true);
//
//	}
//
//	// 관리자 메뉴 (1) -> "새로운 의료소 정보 입력" 선택하면 실행되는 함수
//	public void menu1_1(String name, String type, String area, String tel, String open, String close, int wait) {
//		try {
//			// auto commit 해제
//			con.setAutoCommit(false);
//
//			/*
//			 * // 수정 전 지역릴레이션에서 해당 투플 출력 SQL = "SELECT * FROM DB2022_Area WHERE area = \"" +
//			 * area + "\""; rs = st.executeQuery(SQL); rs.next();
//			 * System.out.println("Area information before update");
//			 * System.out.println("area\t medical_center_count");
//			 * System.out.println(rs.getString("area") + "\t\t" +
//			 * rs.getInt("medical_center_count") + "\n");
//			 */
//
//			// 새로운 의료소 투플 삽입
//			pSt = con.prepareStatement("INSERT INTO DB2022_MedicalCenter (ID, kind, location, tel, open, close, wait)"
//					+ "VALUES(?, ?, ?, ?, ?, ?, ?)");
//			pSt.setString(1, name);
//			pSt.setString(2, type);
//			pSt.setString(3, area);
//			pSt.setString(4, tel);
//			pSt.setString(5, open);
//			pSt.setString(6, close);
//			pSt.setInt(7, wait);
//			pSt.executeUpdate();
//
//			// 지역 릴레이션에서 지역 내 병원 수 + 1
//			SQL = "UPDATE DB2022_Area SET medical_center_count = medical_center_count + 1 " + "WHERE area = \"" + area
//					+ "\"";
//			st.executeUpdate(SQL);
//
//			// 데이터베이스에 수정 사항 반영
//			con.commit();
//
//			// 모든 transaction 반영 후 auto commit true로 설정
//			con.setAutoCommit(true);
//
//			// 삽입된 의료소 정보 검색 후 출력
//			System.out.println("Insertion is completed!");
//			System.out.println("Inserted information");
//			SQL = "SELECT * FROM DB2022_MedicalCenter WHERE ID = \"" + name + "\"";
//			rs = st.executeQuery(SQL);
//			rs.next();
//			System.out.println("의료소 이름\t: " + rs.getString("ID"));
//			System.out.println("의료기관 종류\t: " + rs.getString("kind"));
//			System.out.println("위치\t\t: " + rs.getString("location"));
//			System.out.println("연락처\t\t: " + rs.getString("tel"));
//			System.out.println("운영 시작 시각\t: " + rs.getString("open"));
//			System.out.println("운영 종료 시각\t: " + rs.getString("close"));
//			System.out.println("대기 인원\t\t: " + rs.getInt("wait"));
//
//			/*
//			 * // 수정 후 지역 릴레이션에서 해당 투플 출력 SQL = "SELECT * FROM DB2022_Area WHERE area = \""
//			 * + area + "\""; rs = st.executeQuery(SQL); rs.next();
//			 * System.out.println("\nArea information after update");
//			 * System.out.println("area\t medical_center_count");
//			 * System.out.println(rs.getString("area") + "\t\t" +
//			 * rs.getInt("medical_center_count"));
//			 */
//
//			// 수정 후 의료소 리스트 출력
//			System.out.println("\n수정 후 의료소 리스트");
//			SQL = "SELECT * FROM DB2022_MedicalCenter";
//			rs = st.executeQuery(SQL);
//			System.out.printf("%-70s", "ID");
//			System.out.printf("%-30s", "kind");
//			System.out.printf("%-30s", "location");
//			System.out.printf("%-20s", "tel");
//			System.out.print("  open  ");
//			System.out.print("   close  ");
//			System.out.print("\twait\n");
//			System.out.println(
//					"======================================================================================================================================================================================");
//
//			while (rs.next()) {
//				System.out.printf("%-70s", rs.getString(1));
//				System.out.printf("%-30s", rs.getString(2));
//				System.out.printf("%-30s", rs.getString(3));
//				System.out.printf("%-20s", rs.getString(4));
//				System.out.print(rs.getString(5) + "\t");
//				System.out.print(rs.getString(6) + "\t");
//				System.out.print(rs.getInt(7));
//				System.out.println();
//			}
//
//		} catch (Exception e) {
//			System.out.println("데이터베이스 삽입 오류: " + e.getMessage());
//		}
//
//		JOptionPane.showMessageDialog(null, "결과가 콘솔창에 출력되었습니다.\n", "출력완료안내", JOptionPane.INFORMATION_MESSAGE);
//	}
//
//	// 관리자 메뉴 (1) -> "의료소 정보 수정" 선택하면 실행되는 함수
//	public void menu1_2(String ID, String name, String type, String area, String tel, String open, String close,
//			String wait) {
//		try {
//			// 수정 전 의료소 정보
//			System.out.println("[수정 전 의료소 정보]");
//			SQL = "SELECT * FROM DB2022_MedicalCenter WHERE ID = \"" + ID + "\"";
//			rs = st.executeQuery(SQL);
//			rs.next();
//			System.out.println("의료소 이름\t: " + rs.getString("ID"));
//			System.out.println("의료기관 종류\t: " + rs.getString("kind"));
//			System.out.println("위치\t\t: " + rs.getString("location"));
//			System.out.println("연락처\t\t: " + rs.getString("tel"));
//			System.out.println("운영 시작 시각\t: " + rs.getString("open"));
//			System.out.println("운영 종료 시각\t: " + rs.getString("close"));
//			System.out.println("대기 인원\t\t: " + rs.getInt("wait"));
//
//			// 의료소 정보 업데이트
//			if (!type.equals("")) {
//				SQL = "UPDATE DB2022_MedicalCenter SET kind = \"" + type + "\"" + "WHERE ID = \"" + ID + "\"";
//				st.executeUpdate(SQL);
//			}
//
//			if (!area.equals("")) {
//				SQL = "UPDATE DB2022_MedicalCenter SET location = \"" + area + "\"" + "WHERE ID = \"" + ID + "\"";
//				st.executeUpdate(SQL);
//			}
//
//			if (!tel.equals("")) {
//				SQL = "UPDATE DB2022_MedicalCenter SET tel = \"" + tel + "\"" + "WHERE ID = \"" + ID + "\"";
//				st.executeUpdate(SQL);
//			}
//
//			if (!open.equals("")) {
//				SQL = "UPDATE DB2022_MedicalCenter SET open = \"" + open + "\"" + "WHERE ID = \"" + ID + "\"";
//				st.executeUpdate(SQL);
//			}
//
//			if (!close.equals("")) {
//				SQL = "UPDATE DB2022_MedicalCenter SET close = \"" + close + "\"" + "WHERE ID = \"" + ID + "\"";
//				st.executeUpdate(SQL);
//			}
//
//			if (!wait.equals("")) {
//				int wait_int = Integer.parseInt(wait);
//				SQL = "UPDATE DB2022_MedicalCenter SET wait = \"" + wait_int + "\"" + "WHERE ID = \"" + ID + "\"";
//				st.executeUpdate(SQL);
//			}
//
//			if (!name.equals("")) {
//				SQL = "UPDATE DB2022_MedicalCenter SET ID = \"" + name + "\"" + "WHERE ID = \"" + ID + "\"";
//				st.executeUpdate(SQL);
//			}
//
//			// 수정 후 의료소 정보
//			System.out.println("\n[수정 후 의료소 정보]");
//			if (!name.equals(""))
//				SQL = "SELECT * FROM DB2022_MedicalCenter WHERE ID = \"" + name + "\"";
//			else
//				SQL = "SELECT * FROM DB2022_MedicalCenter WHERE ID = \"" + ID + "\"";
//
//			rs = st.executeQuery(SQL);
//			rs.next();
//			System.out.println("의료소 이름\t: " + rs.getString("ID"));
//			System.out.println("의료기관 종류\t: " + rs.getString("kind"));
//			System.out.println("위치\t\t: " + rs.getString("location"));
//			System.out.println("연락처\t\t: " + rs.getString("tel"));
//			System.out.println("운영 시작 시각\t: " + rs.getString("open"));
//			System.out.println("운영 종료 시각\t: " + rs.getString("close"));
//			System.out.println("대기 인원\t\t: " + rs.getInt("wait"));
//
//			// 수정 후 의료소 리스트 출력
//			System.out.println("\n수정 후 의료소 리스트");
//			SQL = "SELECT * FROM DB2022_MedicalCenter";
//			rs = st.executeQuery(SQL);
//			System.out.printf("%-70s", "ID");
//			System.out.printf("%-30s", "kind");
//			System.out.printf("%-30s", "location");
//			System.out.printf("%-20s", "tel");
//			System.out.print("  open  ");
//			System.out.print("   close  ");
//			System.out.print("\twait\n");
//			System.out.println(
//					"======================================================================================================================================================================================");
//
//			while (rs.next()) {
//				System.out.printf("%-70s", rs.getString(1));
//				System.out.printf("%-30s", rs.getString(2));
//				System.out.printf("%-30s", rs.getString(3));
//				System.out.printf("%-20s", rs.getString(4));
//				System.out.print(rs.getString(5) + "\t");
//				System.out.print(rs.getString(6) + "\t");
//				System.out.print(rs.getInt(7));
//				System.out.println();
//			}
//
//		} catch (Exception e) {
//			System.out.println("데이터베이스 갱신 오류: " + e.getMessage());
//		}
//		JOptionPane.showMessageDialog(null, "결과가 콘솔창에 출력되었습니다.\n", "출력완료안내", JOptionPane.INFORMATION_MESSAGE);
//	}
//
//	// 관리자 메뉴 (1) -> 의료소 삭제 선택하면 실행되는 함수
//	public void menu1_3(String name) {
//		try {
//			SQL = "DELETE FROM DB2022_MedicalCenter WHERE ID = \"" + name + "\"";
//			st.executeUpdate(SQL);
//
//			System.out.println("의료소 " + name + " 삭제 완료.");
//
//			// 수정 후 의료소 리스트 출력
//			System.out.println("수정 후 의료소 리스트");
//			SQL = "SELECT * FROM DB2022_MedicalCenter";
//			rs = st.executeQuery(SQL);
//			System.out.printf("%-70s", "ID");
//			System.out.printf("%-30s", "kind");
//			System.out.printf("%-30s", "location");
//			System.out.printf("%-20s", "tel");
//			System.out.print("  open  ");
//			System.out.print("   close  ");
//			System.out.print("\twait\n");
//			System.out.println(
//					"======================================================================================================================================================================================");
//
//			while (rs.next()) {
//				System.out.printf("%-70s", rs.getString(1));
//				System.out.printf("%-30s", rs.getString(2));
//				System.out.printf("%-30s", rs.getString(3));
//				System.out.printf("%-20s", rs.getString(4));
//				System.out.print(rs.getString(5) + "\t");
//				System.out.print(rs.getString(6) + "\t");
//				System.out.print(rs.getInt(7));
//				System.out.println();
//			}
//
//		} catch (Exception e) {
//			System.out.println("데이터베이스 갱신 오류: " + e.getMessage());
//		}
//		JOptionPane.showMessageDialog(null, "결과가 콘솔창에 출력되었습니다.\n", "출력완료안내", JOptionPane.INFORMATION_MESSAGE);
//	}
//
//	// 관리자 메뉴 (3) -> "새로운 검사소 정보 입력" 선택하면 실행되는 함수
//	public void menu3_1(String name, String area, String tel, String open, String close) {
//		try {
//			// 새로운 검사소 투플 삽입
//			pSt = con.prepareStatement(
//					"INSERT INTO DB2022_RegionalCenter (name, area, contact, open, close)" + "VALUES(?, ?, ?, ?, ?)");
//			pSt.setString(1, name);
//			pSt.setString(2, area);
//			pSt.setString(3, tel);
//			pSt.setString(4, open);
//			pSt.setString(5, close);
//			pSt.executeUpdate();
//
//			// 삽입된 검사소 정보 검색 후 출력
//			System.out.println("Insertion is completed!");
//			System.out.println("Inserted information");
//			SQL = "SELECT * FROM DB2022_RegionalCenter WHERE name = \"" + name + "\"";
//			rs = st.executeQuery(SQL);
//			rs.next();
//			System.out.println("검사소 이름\t: " + rs.getString("name"));
//			System.out.println("위치\t\t: " + rs.getString("area"));
//			System.out.println("연락처\t\t: " + rs.getString("contact"));
//			System.out.println("운영 시작 시각\t: " + rs.getString("open"));
//			System.out.println("운영 종료 시각\t: " + rs.getString("close"));
//
//			// 수정 후 검사소 리스트 출력
//			System.out.println("수정 후 검사소 리스트");
//			SQL = "SELECT * FROM DB2022_RegionalCenter";
//			rs = st.executeQuery(SQL);
//			System.out.print("ID");
//			System.out.printf("%-30s", "name");
//			System.out.printf("%-30s", "area");
//			System.out.printf("%-20s", "contact");
//			System.out.print("open\t");
//			System.out.print("\tclose\n");
//			System.out.println(
//					"==========================================================================================================");
//
//			while (rs.next()) {
//				System.out.print(rs.getInt(1));
//				System.out.printf("%-30s", rs.getString(2));
//				System.out.printf("%-30s", rs.getString(3));
//				System.out.printf("%-20s", rs.getString(4));
//				System.out.print(rs.getString(5) + "\t");
//				System.out.print(rs.getString(6) + "\t");
//				System.out.println();
//			}
//
//		} catch (Exception e) {
//			System.out.println("데이터베이스 삽입 오류: " + e.getMessage());
//		}
//		JOptionPane.showMessageDialog(null, "결과가 콘솔창에 출력되었습니다.\n", "출력완료안내", JOptionPane.INFORMATION_MESSAGE);
//	}
//
//	// 관리자 메뉴 (3) -> "검사소 정보 수정" 선택하면 실행되는 함수
//	public void menu3_2(String original_name, String name, String area, String tel, String open, String close) {
//		try {
//			// 수정 전 검사소 정보
//			System.out.println("[수정 전 검사소 정보]");
//			SQL = "SELECT * FROM DB2022_RegionalCenter WHERE name = \"" + original_name + "\"";
//			rs = st.executeQuery(SQL);
//			rs.next();
//			System.out.println("검사소 이름\t: " + rs.getString("name"));
//			System.out.println("위치\t\t: " + rs.getString("area"));
//			System.out.println("연락처\t\t: " + rs.getString("contact"));
//			System.out.println("운영 시작 시각\t: " + rs.getString("open"));
//			System.out.println("운영 종료 시각\t: " + rs.getString("close"));
//
//			// 검사소 정보 업데이트
//			if (!area.equals("")) {
//				SQL = "UPDATE DB2022_RegionalCenter SET area = \"" + area + "\"" + "WHERE name = \"" + original_name
//						+ "\"";
//				st.executeUpdate(SQL);
//			}
//
//			if (!tel.equals("")) {
//				SQL = "UPDATE DB2022_RegionalCenter SET contact = \"" + tel + "\"" + "WHERE name = \"" + original_name
//						+ "\"";
//				st.executeUpdate(SQL);
//			}
//
//			if (!open.equals("")) {
//				SQL = "UPDATE DB2022_RegionalCenter SET open = \"" + open + "\"" + "WHERE name = \"" + original_name
//						+ "\"";
//				st.executeUpdate(SQL);
//			}
//
//			if (!close.equals("")) {
//				SQL = "UPDATE DB2022_RegionalCenter SET close = \"" + close + "\"" + "WHERE name = \"" + original_name
//						+ "\"";
//				st.executeUpdate(SQL);
//			}
//
//			if (!name.equals("")) {
//				SQL = "UPDATE DB2022_RegionalCenter SET name = \"" + name + "\"" + "WHERE name = \"" + original_name
//						+ "\"";
//				st.executeUpdate(SQL);
//			}
//
//			// 수정 후 검사소 정보
//			System.out.println("\n[수정 후 검사소 정보]");
//			if (!name.equals(""))
//				SQL = "SELECT * FROM DB2022_RegionalCenter WHERE name = \"" + name + "\"";
//			else
//				SQL = "SELECT * FROM DB2022_RegionalCenter WHERE name = \"" + original_name + "\"";
//
//			rs = st.executeQuery(SQL);
//			rs.next();
//
//			System.out.println("검사소 이름\t: " + rs.getString("name"));
//			System.out.println("위치\t\t: " + rs.getString("area"));
//			System.out.println("연락처\t\t: " + rs.getString("contact"));
//			System.out.println("운영 시작 시각\t: " + rs.getString("open"));
//			System.out.println("운영 종료 시각\t: " + rs.getString("close"));
//
//			// 수정 후 검사소 리스트 출력
//			System.out.println("수정 후 검사소 리스트");
//			SQL = "SELECT * FROM DB2022_RegionalCenter";
//			rs = st.executeQuery(SQL);
//			System.out.print("ID");
//			System.out.printf("%-30s", "name");
//			System.out.printf("%-30s", "area");
//			System.out.printf("%-20s", "contact");
//			System.out.print("open\t");
//			System.out.print("\tclose\n");
//			System.out.println(
//					"==========================================================================================================");
//
//			while (rs.next()) {
//				System.out.print(rs.getInt(1));
//				System.out.printf("%-30s", rs.getString(2));
//				System.out.printf("%-30s", rs.getString(3));
//				System.out.printf("%-20s", rs.getString(4));
//				System.out.print(rs.getString(5) + "\t");
//				System.out.print(rs.getString(6) + "\t");
//				System.out.println();
//			}
//		} catch (Exception e) {
//			System.out.println("데이터베이스 갱신 오류: " + e.getMessage());
//		}
//		JOptionPane.showMessageDialog(null, "결과가 콘솔창에 출력되었습니다.\n", "출력완료안내", JOptionPane.INFORMATION_MESSAGE);
//	}
//
//	// 관리자 메뉴 (3) -> 검사소 삭제 선택하면 실행되는 함수
//	public void menu3_3(String name) {
//		try {
//			SQL = "DELETE FROM DB2022_RegionalCenter WHERE name = \"" + name + "\"";
//			st.executeUpdate(SQL);
//
//			System.out.println("검사소 " + name + " 삭제 완료.");
//
//			// 수정 후 검사소 리스트 출력
//			System.out.println("수정 후 검사소 리스트");
//			SQL = "SELECT * FROM DB2022_RegionalCenter";
//			rs = st.executeQuery(SQL);
//			System.out.print("ID");
//			System.out.printf("%-30s", "name");
//			System.out.printf("%-30s", "area");
//			System.out.printf("%-20s", "contact");
//			System.out.print("open\t");
//			System.out.print("\tclose\n");
//			System.out.println(
//					"==========================================================================================================");
//
//			while (rs.next()) {
//				System.out.print(rs.getInt(1));
//				System.out.printf("%-30s", rs.getString(2));
//				System.out.printf("%-30s", rs.getString(3));
//				System.out.printf("%-20s", rs.getString(4));
//				System.out.print(rs.getString(5) + "\t");
//				System.out.print(rs.getString(6) + "\t");
//				System.out.println();
//			}
//
//		} catch (Exception e) {
//			System.out.println("데이터베이스 갱신 오류: " + e.getMessage());
//		}
//		JOptionPane.showMessageDialog(null, "결과가 콘솔창에 출력되었습니다.\n", "출력완료안내", JOptionPane.INFORMATION_MESSAGE);
//	}
//	
//	public void menu8() {
//		FrameSIR window8 = new FrameSIR();
//		window8.frame.setVisible(true);
//	}
//	
//	public void menu8_1() {
//		try {
//			
//			int total_infect = 1; //전체 감염자 수			
//			int check_people2 = 1; //특정 지역 감염자 수
//			float check_beta = 1; //특정 전염병의 전염률 값
//			int check_recovery = 1; //특정 전염병의 회복 기간
//			float infect_num = 1; //특정 전염병의 기초감염재생산지수
//			
//			float num1=1; //전체 전염병의 전염률 값
//			int num2=1; //전체 전염병의 회복 기간
//			float[] danger = new float[4]; //전체 전염병의 기초감염재생산지수
//			
//			int i=0;
//			
//			//전체 감염자 수 구하기
//			String SQL;
//			SQL = "SELECT COUNT(*) FROM DB2022_InfectedPerson;";
//			rs=st.executeQuery(SQL);
//			
//			while (rs.next()) {
//				total_infect = rs.getInt(1);
//			}
//			
//			//특정 지역 감염자 수 구하기
//			String SQL2;
//			SQL2 = "SELECT total_patient FROM DB2022_AreaRank WHERE residential_area = ' " + UserLocation + " ' " + ";";
//			rs=st.executeQuery(SQL2);
//			
//			while (rs.next()) {
//				check_people2 = rs.getInt(1);
//			}
//			
//			//특정 지역 전염률 값과 회복 기간 값 구하기
//			String SQL3;
//			SQL3 = "SELECT R0, quarantine_period FROM DB2022_Epidemic WHERE ID = ' " + UserDisease + " ' " + ";";
//			rs=st.executeQuery(SQL3);
//			
//			while (rs.next()) {
//				check_beta = rs.getFloat(1);
//				check_recovery = rs.getInt(2);
//			}
//			
//			//특정 지역의 특정 전염병의 기초감염재생산지수 구하기
//			infect_num = check_beta * (check_people-check_people2) * check_recovery;
//			
//			//특정 지역의 특정 전염병에 대해 기초감염재생산지수가 1보다 클 경우 감염자 수 증가 추세, 작을 경우 감소 추세
//			if (infect_num > 1) {
//				System.out.println(UserLocation + "에서 " + UserDisease + "의 감염자 수는 현재 증가 추세에 있습니다. 유의해 주세요.");
//			}
//			
//			else {
//				System.out.println(UserLocation + "에서 " + UserDisease + "의 감염자 수는 현재 감소 추세에 있습니다.");
//			}
//			
//			//전체 전염병에 대해 전염률 값과 회복 기간 값 구하기
//			String SQL4;
//			SQL4 = "SELECT R0, quarantine_period FROM DB2022_Epidemic;";
//			rs=st.executeQuery(SQL4);
//			
//			//전 지역, 전체 전염병에 대한 기초감염재생산지수 구하기
//			while (rs.next()) {
//				num1 = rs.getFloat(1);
//				num2 = rs.getInt(2);
//				danger[i] = num1 * (391-total_infect) * num2;
//				i++;
//			}
//			
//			System.out.println("");
//			
//			System.out.println("기초감염재생산지수가 클수록 해당 전염병의 감염 전파력이 크다는 뜻입니다.");
//			System.out.println("현재 Ebola의 기초감염재생산수는 " + danger[0] + " 입니다.");
//			System.out.println("현재 Corona의 기초감염재생산수는 " + danger[1] + " 입니다.");
//			System.out.println("현재 Mers의 기초감염재생산수는 " + danger[2] + " 입니다.");
//			System.out.println("현재 Sars의 기초감염재생산수는 " + danger[3] + " 입니다.");
//			
//		}
//		catch(Exception e) {
//			System.out.println("데이터베이스 검색 오류: "+e.getMessage());
//		}
//	}
//	
//
//}