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

	// ��ǻ�Ϳ� �ִ� SQL�� �������ִ� �ڵ�
	public DB2022_UserMenu() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB2022Team04", "root", "996363Kim~~");
			con_1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB2022Team04", "root", "996363Kim~~");
			st = con.createStatement();
			st_1 = con_1.createStatement();
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����:" + e.getMessage());
		}
	}

	// ����ڰ� ������ ��ȣ�� ���� �ش� �Լ��� ���� ��
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

	// ����ڰ� 1�� �����ϸ� ����Ǵ� �Լ�
	public void menu1() {
		DB2022_FrameMenu1 window = new DB2022_FrameMenu1();
		window.frame.setVisible(true);
	}

	// ȯ�� ���� �Է� â���� Ȯ���� ������ �Ѿ� ��
	public void menu1_1() {

		try {
			// �Է� ���� ���� db2022_infectedperson�� insert�ϴ� ����
			String SQL;
			SQL = "INSERT INTO db2022_infectedperson (name, disease, age, underlying_disease, Infected, residential_area)"
					+ "VALUES ('" + UserName + "', '" + UserDisease + "', " + Integer.parseInt(UserAge) + ", '"
					+ UserDiseaseOX.charAt(0) + "', '" + UserInfectDate + "', '" + UserLocation + "')";
			int re = st.executeUpdate(SQL);

			if (re == 1) {
				System.out.println("ȯ���� �����Ͱ� ���������� ���ԵǾ����ϴ�.");
			}

			// �ٸ� ���̺���� ������Ʈ
			st.executeUpdate("update db2022_InfectedPerson X natural join db2022_area Y\r\n"
					+ "set Y.patient_Ebola= case when X.disease= \"Ebola\" then Y.patient_Ebola+1 else Y.patient_Ebola end,\r\n"
					+ "Y.patient_Corona= case when X.disease= \"Corona\" then Y.patient_Corona+1 else Y.patient_Corona end,\r\n"
					+ "Y.patient_Mers= case when X.disease= \"Mers\" then Y.patient_Mers+1 else Y.patient_Mers end,\r\n"
					+ "Y.patient_SARS= case when X.disease= \"SARS\" then Y.patient_SARS+1 else Y.patient_SARS end\r\n"
					+ "where X.residential_area=Y.area and X.name='" + UserName + "'AND age='" + UserAge + "'");

			// �����ߴٴ� �ȳ�â ����
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);

			// ���� �� ȯ�� ��� �����ֱ�
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
			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());
		}
	}

	// ����ڰ� 2�� �����ϸ� ����Ǵ� �Լ�
	public void menu2() {
		try {
			DB2022_FrameMenu2 window = new DB2022_FrameMenu2();
			window.frame.setVisible(true);
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());
		}

	}

	public void menu2_1(String name, int age_1, String disease, String area, String date, String YorN) {
		try {
			// ���������� name�� age�� ��ġ�ϴ� ������ �ִ��� Ȯ������ ���� finish
			int finish = 0;
			// name�� age�� ��ġ�ϴ� ������ �ִ��� Ȯ�����ִ� �κ�
			String a = "";
			String SQL_1 = "select case when name='" + name + "' and age='" + age_1 + "' then 1\r\n" + "else 0\r\n"
					+ "end as exist\r\n" + "from db2022_InfectedPerson;";
			rs = st.executeQuery(SQL_1);

			while (rs.next()) {
				if (rs.getString("exist").contains("1")) {

					// �ش� ����ڰ� �����ߴ� ���� ��������, �ش� ������� ���� ȯ�ڼ��� ���ҽ�Ŵ
					st.executeUpdate("update db2022_InfectedPerson X natural join db2022_area Y\r\n"
							+ "set Y.patient_Ebola= case when X.disease= \"Ebola\" then Y.patient_Ebola-1 else Y.patient_Ebola end,\r\n"
							+ "Y.patient_Corona= case when X.disease= \"Corona\" then Y.patient_Corona-1 else Y.patient_Corona end,\r\n"
							+ "Y.patient_Mers= case when X.disease= \"Mers\" then Y.patient_Mers-1 else Y.patient_Mers end,\r\n"
							+ "Y.patient_SARS= case when X.disease= \"SARS\" then Y.patient_SARS-1 else Y.patient_SARS end\r\n"
							+ "where X.residential_area=Y.area and X.name='" + name + "'AND age='" + age_1 + "'");
					// �Է��� ������ �̸��� ���̰� ���� ����� ������ gui�� �ؽ�Ʈ�ʵ�� �޺��ڽ����� ������ ������ ������Ʈ �Ѵ�.
					st.executeUpdate("UPDATE DB2022_InfectedPerson  " + "SET disease='" + disease
							+ "',residential_area='" + area + "',underlying_disease='" + YorN + "',Infected='" + date
							+ "'" + "WHERE name='" + name + "' AND age='" + age_1 + "'");
					// �ش� ����ڰ� �����ϴ� ���ο� ��������, �ش� ������� ���� ȯ�ڼ��� ������Ŵ
					st.executeUpdate("update db2022_InfectedPerson X natural join db2022_area Y\r\n"
							+ "set Y.patient_Ebola= case when X.disease= \"Ebola\" then Y.patient_Ebola+1 else Y.patient_Ebola end,\r\n"
							+ "Y.patient_Corona= case when X.disease= \"Corona\" then Y.patient_Corona+1 else Y.patient_Corona end,\r\n"
							+ "Y.patient_Mers= case when X.disease= \"Mers\" then Y.patient_Mers+1 else Y.patient_Mers end,\r\n"
							+ "Y.patient_SARS= case when X.disease= \"SARS\" then Y.patient_SARS+1 else Y.patient_SARS end\r\n"
							+ "where X.residential_area=Y.area and X.name='" + name + "'AND age='" + age_1 + "'");
					// �����ߴٴ� �ȳ�â ����

					// ȯ�� ���� ���
					String SQL;
					System.out.println("\n" + name + "�� ������ ������ ���� �����Ǿ���, ���� �� ȯ�� ���� ����Ǿ����ϴ�.");
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
			// ������ ������ �����ٸ� �����ٰ� ���
			if (finish == 0) {
				System.out.println(age_1 + "���� " + name + "�� ���� �����Դϴ�. ");
				DB2022_FrameResult_fail window1 = new DB2022_FrameResult_fail();
				window1.frame.setVisible(true);
			}
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());

		}
	}

	// 3���޴�

	public void menu3() {
		try {
			String SQL;
			// ���� �ð��� open, close ���̿� �ִ� ������ ID �����ϴ� SQL����
			SQL = "SELECT ID FROM DB2022_MedicalCenter WHERE CURTIME() between open and close;";
			// ���� ����
			rs = st.executeQuery(SQL);
			if (!rs.next()) { // ���ǿ� �ش��ϴ� ������ ���� ��� �ȳ� �޼��� ���
				System.out.println("���� � ���� ���� ����");
			} else {
				System.out.println("���� � ���� ���� ����Ʈ");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------");
				while (rs.next())// ���ǿ� �ش��ϴ� ���� ����Ʈ ���
				{
					System.out.println(rs.getString("ID"));
				}
				DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
				window1.frame.setVisible(true);
			}

		} catch (Exception e) {// ����ó��
			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());
		}

	}

	public void menu4() {
		/*
		 * FrameMenu4 window = new FrameMenu4(); window.frame.setVisible(true);
		 */
		/*
		 * ���� �� ���� � ���� �˻�� ���(�������) ; �˻�� � ���� < ���� �ð� < � ���� �ð�.
		 */
		try {
			String SQL;
			SQL = "select name from db2022_RegionalCenter where id in "
					+ "(select id from db2022_Regionalcenter where CURTIME() between open and close);";
			rs = st.executeQuery(SQL);
			System.out.println("���� � ���� �˻�� ����Ʈ");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------");

			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);
		} catch (Exception e) {

			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());
		}
	}

	public void menu5() {
		try {
			String SQL;
			SQL = "SELECT *FROM DB2022_medicalcenter ORDER BY wait asc"; // ����ο��� �������� �������� ���� �� �Ƿ�� ��ü Ʃ�� ����

			// ���� ����
			rs = st.executeQuery(SQL);
			System.out.printf("%-45s %-10s %-15s %-15s %-13s %-13s %-3s", "�Ƿ��", "����", "��ġ", "��ȣ", "���� �ð�", "�ݴ� �ð�",
					"��� �ο�");
			// �� ���� � ���� �ǹ��ϴ���
			System.out.println(
					"\n---------------------------------------------------------------------------------------------------------------------------------");

			while (rs.next()) {// �Ƿ�� ��ü Ʃ�� ���
				System.out.printf("%-45s %-10s %-15s %-15s %-13s %-13s %-3s\n", rs.getString("ID"),
						rs.getString("kind"), rs.getString("location"), rs.getString("tel"), rs.getString("open"),
						rs.getString("close"), rs.getString("wait"));
			}
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());
		}
	}

	public void menu6(String patient_name) {
		try {
			String SQL;
			SQL = "SELECT name, disease, quarantine_period, infected, DATE_ADD(infected, INTERVAL quarantine_period DAY)\r\n"
					+ "FROM DB2022_InfectedPerson, DB2022_Epidemic\r\n"
					+ "WHERE DB2022_InfectedPerson.disease = DB2022_Epidemic.ID and name = \"" + patient_name + "\"";
			rs = st.executeQuery(SQL);
			System.out.printf("%-10s %-10s %-11s %-14s", "�̸�", "����", "Ȯ����¥", "�ݸ����� ��¥");
			System.out.println("\n--------------------------------------------------------------------------");

			while (rs.next()) {
				System.out.printf("%-10s %-10s %-14s %-14s\n", rs.getString("name"), rs.getString("disease"),
						rs.getString("infected"), rs.getString("DATE_ADD(infected, INTERVAL quarantine_period DAY)"));
			}
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());
		}
	}

	// ����ڰ� 7�� �����ϸ� ����Ǵ� �Լ� : ������ �� ���� ���� ������� view ���
	public void menu7() {
		try {
			int num = 1; // ���� console�� ����� ����
			int check = 0; // view ������� �ִ��� üũ�ϴ� ����

			// view ������� �ִ��� üũ�ϴ� ����
			String SQL;
			SQL = "SELECT COUNT(*) FROM information_schema.tables "
					+ "WHERE table_schema = 'db2022team04' AND table_name = 'db2022_arearank'";
			rs = st.executeQuery(SQL);

			while (rs.next()) {
				check = rs.getInt(1); // view�� �����ϸ� 1, �������� ������ 0
			}

			// view�� �������� ���� �� create�ϴ� ����
			if (check != 1) {
				String SQL1;
				SQL1 = "CREATE VIEW DB2022_AreaRank "
						+ "AS SELECT residential_area, COUNT(residential_area) AS total_patient "
						+ "FROM DB2022_InfectedPerson " + "GROUP BY residential_area " + "ORDER BY total_patient DESC";
				int re = st.executeUpdate(SQL1);

				if (re == 0) {
					System.out.println("create view ����!");
				}

			}

			// view�� ����ϴ� ����
			String SQL2;
			SQL2 = "SELECT * from DB2022_AreaRank";
			rs = st.executeQuery(SQL2);

			System.out.printf("%-4s %-17s %-2s", "����", "����", "ȯ�� ��");
			System.out.println("\n--------------------------------------------------------------------------");

			// console�� view ���
			while (rs.next()) {
				String residential_area = rs.getString(1);
				int Patient_Num = rs.getInt(2);
				System.out.printf("%-4s %-17s %-4s\n", num, residential_area, Patient_Num);
				num++;
			}
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);

		} catch (Exception e) {
			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());
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
			System.out.printf("%-14s %-15s\n", "����", "ȯ�� �� ���� ������");
			System.out.println("--------------------------------------------------------------------------");

			while (rs.next()) {
				System.out.printf("%-15s %-15s\n", rs.getString(1), rs.getString(2));
			}
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());
		}
	}

	public void menu9() {
		try {
			String SQL;
			// ������ ������ view DB2022_EpidemicRank �̿�, ������ �� �������� ������ �� ����
			SQL = "SELECT area, Ebola, Corona, Mers, Sars FROM DB2022_EpidemicRank;";
			rs = st.executeQuery(SQL); // SQL ���� ����
			System.out.println("����\t\t Ebola\t Corona\t Mers\t Sars"); // �� ���� ������ ��Ÿ������ �˷���
			System.out.println("--------------------------------------------------------------------------");

			while (rs.next()) {
				// ������� �� ������ �� ������ �� ���
				System.out.println(rs.getString("area") + "  \t" + rs.getString("Ebola") + "\t" + rs.getString("Corona")
						+ "\t" + rs.getString("Mers") + "\t" + rs.getString("Sars"));
			}
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);
		} catch (Exception e) { // ����ó��
			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());
		}
	}

	public void menu10() {
		try {
			String SQL;

			SQL = "select disease, count(ID) as num_of_infected\r\n" + "  from DB2022_InfectedPerson\r\n"
					+ "  group by disease; ";
			rs = st.executeQuery(SQL);
			System.out.printf("%-10s %-3s", "����", "ȯ�� ��");
			System.out.println("\n--------------------------------------------------------------------------");

			while (rs.next()) {
				System.out.printf("%-10s %-3s\n", rs.getString("disease"), rs.getString("num_of_infected"));
			}
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());
		}
	}

	public void menu11() {
		try {
			String SQL;
			SQL = "SELECT disease, avg(age) as avg_age, min(infected) as outbreak\r\n" // �������� �������� �׷�ȭ �� �� ������ �� ���� ���
																						// ���̿� ���� �ߺ� ��¥ ���
					+ "FROM DB2022_infectedPerson\r\n" + "group by disease;\r\n";

			// ���� ����
			rs = st.executeQuery(SQL);
			System.out.printf("%-10s %-10s %-15s", "����", "��ճ���", "�ߺ���¥");

			System.out.println("\n------------------------------------------------");
			DB2022_FrameResult_success window1 = new DB2022_FrameResult_success();
			window1.frame.setVisible(true);

			while (rs.next()) {// ������ �̸��� �� �������� ���� ��� ���̿� ���� �ߺ� ��¥ ���
				System.out.printf("%-10s %-10s %-15s\n", rs.getString("disease"), rs.getString("avg_age"),
						rs.getString("outbreak"));
			}
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());
		}
	}

}
