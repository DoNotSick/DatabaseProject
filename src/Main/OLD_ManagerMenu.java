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
//	public int check_people; //Ư�� ���� �α� ��
//	public String UserDisease, UserLocation;
//
//	// �Ƿ�� ������ ���� ����(������ �޴� 1-1)
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
//	// �Ƿ�� ���� ������ ���� ����(������ �޴� 1-2)
//	public String[] medical_center_list;
//
//	// �˻�� ���� ������ ���� ����(������ �޴� 4)
//	public String[] regional_center_list;
//
//	// SQL�� �������ִ� �ڵ�
//	public ManagerMenu() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB2022Team04", "DB2022Team04", "DB2022Team04");
//			st = con.createStatement();
//		} catch (Exception e) {
//			System.out.println("�����ͺ��̽� ���� ����:" + e.getMessage());
//		}
//	}
//
//	// �����ڰ� ������ ��ȣ�� ���� �ش� �Լ��� ���� �ٰ���
//	public void menu(String number) {
//		if (number.contains("2"))
//			menu2();
//		else if (number.contains("4")) {
//			menu8();
//		}
//	}
//
//	// ������ �޴� (1)�� ���� �Լ�
//	// �Ƿ�� ���� ���� �� ������ ��ϵ� �Ƿ�� ��� Ȯ��
//	public String[] get_medical_center_list() {
//		try {
//			// �Ƿ�� ��� �˻� �� array_list�� ����
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
//			// �Ƿ�� ��� �������� ArrayList -> array�� ����
//			array = new String[array_list.size()];
//			for (String temp : array_list) {
//				array[index_count++] = temp;
//			}
//
//		} catch (Exception e) {
//			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());
//		}
//		return array;
//	}
//
//	// ������ �޴� (1), (3)�� ���� �Լ�
//	// ��ϵ� ���� ��� Ȯ��(���� �����̼ǿ� ���Ե� �������θ� ���� ����)
//	public String[] get_area_list() {
//		try {
//			// ���� ��� �˻� �� area_list�� ����
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
//			// ���� ��� �������� ArrayList -> Array�� ����
//			array = new String[array_list.size()];
//			for (String temp : array_list) {
//				array[index_count++] = temp;
//			}
//		} catch (Exception e) {
//			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());
//		}
//		return array;
//	}
//
//	// ������ �޴� (1)-1�� ������� �ѱ�
//	public void activate_menu1_1() {
//		// ���� ��� ����
//		area_list = null;
//		area_list = get_area_list();
//		// �˻��� ���� ����� GUI ���������� �ѱ�
//		FrameManager1_1 window = new FrameManager1_1(area_list);
//		window.frame.setVisible(true);
//	}
//
//	// ������ �޴� (1)-2�� �������, �Ƿ�� ��� �ѱ�
//	public void activate_menu1_2() {
//		// ���� ��� ����
//		area_list = null;
//		medical_center_list = null;
//		area_list = get_area_list();
//		medical_center_list = get_medical_center_list();
//
//		// �˻��� ���� ����� GUI ���������� �ѱ�
//		FrameManager1_2 window = new FrameManager1_2(area_list, medical_center_list);
//		window.frame.setVisible(true);
//
//	}
//
//	// ������ �޴� (1)-3�� ������� �ѱ�
//	public void activate_menu1_3() {
//		// ���� ��� ����
//		medical_center_list = null;
//		medical_center_list = get_medical_center_list();
//
//		// �˻��� ���� ����� GUI ���������� �ѱ�
//		FrameManager1_3 window = new FrameManager1_3(medical_center_list);
//		window.frame.setVisible(true);
//
//	}
//
//	// �����ڰ� 2�� �����ϸ� ����Ǵ� �Լ�
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
//			System.out.println(" �����豺 ����Ʈ ");
//			System.out.println("---------------");
//			while (rs.next()) {
//				System.out.println(rs.getString(1));
//			}
//		} catch (Exception e) {
//			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());
//		}
//		JOptionPane.showMessageDialog(null, "����� �ܼ�â�� ��µǾ����ϴ�.\n", "��¿Ϸ�ȳ�", JOptionPane.INFORMATION_MESSAGE);
//
//	}
//
//	// ������ �޴� (3)�� ���� �Լ�
//	// �˻�� ���� ���� �� ������ ��ϵ� �˻�� ��� Ȯ��
//	public String[] get_regional_center_list() {
//		try {
//			// �˻�� ��� �˻� �� array_list�� ����
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
//			// �˻�� ��� �������� ArrayList -> array�� ����
//			array = new String[array_list.size()];
//			for (String temp : array_list) {
//				array[index_count++] = temp;
//			}
//
//		} catch (Exception e) {
//			System.out.println("�����ͺ��̽� �˻� ����: " + e.getMessage());
//		}
//		return array;
//	}
//
//	// ������ �޴� (3)-1�� ������� �ѱ�
//	public void activate_menu3_1() {
//		// ���� ��� ����
//		area_list = null;
//		area_list = get_area_list();
//
//		// �˻��� ���� ����� GUI ���������� �ѱ�
//		FrameManager3_1 window = new FrameManager3_1(area_list);
//		window.frame.setVisible(true);
//
//	}
//
//	// ������ �޴� (3)-2�� �������, �Ƿ�� ��� �ѱ�
//	public void activate_menu3_2() {
//		// ���� ��� ����
//		area_list = null;
//		regional_center_list = null;
//		area_list = get_area_list();
//		regional_center_list = get_regional_center_list();
//
//		// �˻��� ���� ����� GUI ���������� �ѱ�
//		FrameManager3_2 window = new FrameManager3_2(area_list, regional_center_list);
//		window.frame.setVisible(true);
//
//	}
//
//	// ������ �޴� (3)-3�� ������� �ѱ�
//	public void activate_menu3_3() {
//		// ���� ��� ����
//		regional_center_list = null;
//		regional_center_list = get_regional_center_list();
//
//		// �˻��� ���� ����� GUI ���������� �ѱ�
//		FrameManager3_3 window = new FrameManager3_3(regional_center_list);
//		window.frame.setVisible(true);
//
//	}
//
//	// ������ �޴� (1) -> "���ο� �Ƿ�� ���� �Է�" �����ϸ� ����Ǵ� �Լ�
//	public void menu1_1(String name, String type, String area, String tel, String open, String close, int wait) {
//		try {
//			// auto commit ����
//			con.setAutoCommit(false);
//
//			/*
//			 * // ���� �� ���������̼ǿ��� �ش� ���� ��� SQL = "SELECT * FROM DB2022_Area WHERE area = \"" +
//			 * area + "\""; rs = st.executeQuery(SQL); rs.next();
//			 * System.out.println("Area information before update");
//			 * System.out.println("area\t medical_center_count");
//			 * System.out.println(rs.getString("area") + "\t\t" +
//			 * rs.getInt("medical_center_count") + "\n");
//			 */
//
//			// ���ο� �Ƿ�� ���� ����
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
//			// ���� �����̼ǿ��� ���� �� ���� �� + 1
//			SQL = "UPDATE DB2022_Area SET medical_center_count = medical_center_count + 1 " + "WHERE area = \"" + area
//					+ "\"";
//			st.executeUpdate(SQL);
//
//			// �����ͺ��̽��� ���� ���� �ݿ�
//			con.commit();
//
//			// ��� transaction �ݿ� �� auto commit true�� ����
//			con.setAutoCommit(true);
//
//			// ���Ե� �Ƿ�� ���� �˻� �� ���
//			System.out.println("Insertion is completed!");
//			System.out.println("Inserted information");
//			SQL = "SELECT * FROM DB2022_MedicalCenter WHERE ID = \"" + name + "\"";
//			rs = st.executeQuery(SQL);
//			rs.next();
//			System.out.println("�Ƿ�� �̸�\t: " + rs.getString("ID"));
//			System.out.println("�Ƿ��� ����\t: " + rs.getString("kind"));
//			System.out.println("��ġ\t\t: " + rs.getString("location"));
//			System.out.println("����ó\t\t: " + rs.getString("tel"));
//			System.out.println("� ���� �ð�\t: " + rs.getString("open"));
//			System.out.println("� ���� �ð�\t: " + rs.getString("close"));
//			System.out.println("��� �ο�\t\t: " + rs.getInt("wait"));
//
//			/*
//			 * // ���� �� ���� �����̼ǿ��� �ش� ���� ��� SQL = "SELECT * FROM DB2022_Area WHERE area = \""
//			 * + area + "\""; rs = st.executeQuery(SQL); rs.next();
//			 * System.out.println("\nArea information after update");
//			 * System.out.println("area\t medical_center_count");
//			 * System.out.println(rs.getString("area") + "\t\t" +
//			 * rs.getInt("medical_center_count"));
//			 */
//
//			// ���� �� �Ƿ�� ����Ʈ ���
//			System.out.println("\n���� �� �Ƿ�� ����Ʈ");
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
//			System.out.println("�����ͺ��̽� ���� ����: " + e.getMessage());
//		}
//
//		JOptionPane.showMessageDialog(null, "����� �ܼ�â�� ��µǾ����ϴ�.\n", "��¿Ϸ�ȳ�", JOptionPane.INFORMATION_MESSAGE);
//	}
//
//	// ������ �޴� (1) -> "�Ƿ�� ���� ����" �����ϸ� ����Ǵ� �Լ�
//	public void menu1_2(String ID, String name, String type, String area, String tel, String open, String close,
//			String wait) {
//		try {
//			// ���� �� �Ƿ�� ����
//			System.out.println("[���� �� �Ƿ�� ����]");
//			SQL = "SELECT * FROM DB2022_MedicalCenter WHERE ID = \"" + ID + "\"";
//			rs = st.executeQuery(SQL);
//			rs.next();
//			System.out.println("�Ƿ�� �̸�\t: " + rs.getString("ID"));
//			System.out.println("�Ƿ��� ����\t: " + rs.getString("kind"));
//			System.out.println("��ġ\t\t: " + rs.getString("location"));
//			System.out.println("����ó\t\t: " + rs.getString("tel"));
//			System.out.println("� ���� �ð�\t: " + rs.getString("open"));
//			System.out.println("� ���� �ð�\t: " + rs.getString("close"));
//			System.out.println("��� �ο�\t\t: " + rs.getInt("wait"));
//
//			// �Ƿ�� ���� ������Ʈ
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
//			// ���� �� �Ƿ�� ����
//			System.out.println("\n[���� �� �Ƿ�� ����]");
//			if (!name.equals(""))
//				SQL = "SELECT * FROM DB2022_MedicalCenter WHERE ID = \"" + name + "\"";
//			else
//				SQL = "SELECT * FROM DB2022_MedicalCenter WHERE ID = \"" + ID + "\"";
//
//			rs = st.executeQuery(SQL);
//			rs.next();
//			System.out.println("�Ƿ�� �̸�\t: " + rs.getString("ID"));
//			System.out.println("�Ƿ��� ����\t: " + rs.getString("kind"));
//			System.out.println("��ġ\t\t: " + rs.getString("location"));
//			System.out.println("����ó\t\t: " + rs.getString("tel"));
//			System.out.println("� ���� �ð�\t: " + rs.getString("open"));
//			System.out.println("� ���� �ð�\t: " + rs.getString("close"));
//			System.out.println("��� �ο�\t\t: " + rs.getInt("wait"));
//
//			// ���� �� �Ƿ�� ����Ʈ ���
//			System.out.println("\n���� �� �Ƿ�� ����Ʈ");
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
//			System.out.println("�����ͺ��̽� ���� ����: " + e.getMessage());
//		}
//		JOptionPane.showMessageDialog(null, "����� �ܼ�â�� ��µǾ����ϴ�.\n", "��¿Ϸ�ȳ�", JOptionPane.INFORMATION_MESSAGE);
//	}
//
//	// ������ �޴� (1) -> �Ƿ�� ���� �����ϸ� ����Ǵ� �Լ�
//	public void menu1_3(String name) {
//		try {
//			SQL = "DELETE FROM DB2022_MedicalCenter WHERE ID = \"" + name + "\"";
//			st.executeUpdate(SQL);
//
//			System.out.println("�Ƿ�� " + name + " ���� �Ϸ�.");
//
//			// ���� �� �Ƿ�� ����Ʈ ���
//			System.out.println("���� �� �Ƿ�� ����Ʈ");
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
//			System.out.println("�����ͺ��̽� ���� ����: " + e.getMessage());
//		}
//		JOptionPane.showMessageDialog(null, "����� �ܼ�â�� ��µǾ����ϴ�.\n", "��¿Ϸ�ȳ�", JOptionPane.INFORMATION_MESSAGE);
//	}
//
//	// ������ �޴� (3) -> "���ο� �˻�� ���� �Է�" �����ϸ� ����Ǵ� �Լ�
//	public void menu3_1(String name, String area, String tel, String open, String close) {
//		try {
//			// ���ο� �˻�� ���� ����
//			pSt = con.prepareStatement(
//					"INSERT INTO DB2022_RegionalCenter (name, area, contact, open, close)" + "VALUES(?, ?, ?, ?, ?)");
//			pSt.setString(1, name);
//			pSt.setString(2, area);
//			pSt.setString(3, tel);
//			pSt.setString(4, open);
//			pSt.setString(5, close);
//			pSt.executeUpdate();
//
//			// ���Ե� �˻�� ���� �˻� �� ���
//			System.out.println("Insertion is completed!");
//			System.out.println("Inserted information");
//			SQL = "SELECT * FROM DB2022_RegionalCenter WHERE name = \"" + name + "\"";
//			rs = st.executeQuery(SQL);
//			rs.next();
//			System.out.println("�˻�� �̸�\t: " + rs.getString("name"));
//			System.out.println("��ġ\t\t: " + rs.getString("area"));
//			System.out.println("����ó\t\t: " + rs.getString("contact"));
//			System.out.println("� ���� �ð�\t: " + rs.getString("open"));
//			System.out.println("� ���� �ð�\t: " + rs.getString("close"));
//
//			// ���� �� �˻�� ����Ʈ ���
//			System.out.println("���� �� �˻�� ����Ʈ");
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
//			System.out.println("�����ͺ��̽� ���� ����: " + e.getMessage());
//		}
//		JOptionPane.showMessageDialog(null, "����� �ܼ�â�� ��µǾ����ϴ�.\n", "��¿Ϸ�ȳ�", JOptionPane.INFORMATION_MESSAGE);
//	}
//
//	// ������ �޴� (3) -> "�˻�� ���� ����" �����ϸ� ����Ǵ� �Լ�
//	public void menu3_2(String original_name, String name, String area, String tel, String open, String close) {
//		try {
//			// ���� �� �˻�� ����
//			System.out.println("[���� �� �˻�� ����]");
//			SQL = "SELECT * FROM DB2022_RegionalCenter WHERE name = \"" + original_name + "\"";
//			rs = st.executeQuery(SQL);
//			rs.next();
//			System.out.println("�˻�� �̸�\t: " + rs.getString("name"));
//			System.out.println("��ġ\t\t: " + rs.getString("area"));
//			System.out.println("����ó\t\t: " + rs.getString("contact"));
//			System.out.println("� ���� �ð�\t: " + rs.getString("open"));
//			System.out.println("� ���� �ð�\t: " + rs.getString("close"));
//
//			// �˻�� ���� ������Ʈ
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
//			// ���� �� �˻�� ����
//			System.out.println("\n[���� �� �˻�� ����]");
//			if (!name.equals(""))
//				SQL = "SELECT * FROM DB2022_RegionalCenter WHERE name = \"" + name + "\"";
//			else
//				SQL = "SELECT * FROM DB2022_RegionalCenter WHERE name = \"" + original_name + "\"";
//
//			rs = st.executeQuery(SQL);
//			rs.next();
//
//			System.out.println("�˻�� �̸�\t: " + rs.getString("name"));
//			System.out.println("��ġ\t\t: " + rs.getString("area"));
//			System.out.println("����ó\t\t: " + rs.getString("contact"));
//			System.out.println("� ���� �ð�\t: " + rs.getString("open"));
//			System.out.println("� ���� �ð�\t: " + rs.getString("close"));
//
//			// ���� �� �˻�� ����Ʈ ���
//			System.out.println("���� �� �˻�� ����Ʈ");
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
//			System.out.println("�����ͺ��̽� ���� ����: " + e.getMessage());
//		}
//		JOptionPane.showMessageDialog(null, "����� �ܼ�â�� ��µǾ����ϴ�.\n", "��¿Ϸ�ȳ�", JOptionPane.INFORMATION_MESSAGE);
//	}
//
//	// ������ �޴� (3) -> �˻�� ���� �����ϸ� ����Ǵ� �Լ�
//	public void menu3_3(String name) {
//		try {
//			SQL = "DELETE FROM DB2022_RegionalCenter WHERE name = \"" + name + "\"";
//			st.executeUpdate(SQL);
//
//			System.out.println("�˻�� " + name + " ���� �Ϸ�.");
//
//			// ���� �� �˻�� ����Ʈ ���
//			System.out.println("���� �� �˻�� ����Ʈ");
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
//			System.out.println("�����ͺ��̽� ���� ����: " + e.getMessage());
//		}
//		JOptionPane.showMessageDialog(null, "����� �ܼ�â�� ��µǾ����ϴ�.\n", "��¿Ϸ�ȳ�", JOptionPane.INFORMATION_MESSAGE);
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
//			int total_infect = 1; //��ü ������ ��			
//			int check_people2 = 1; //Ư�� ���� ������ ��
//			float check_beta = 1; //Ư�� �������� ������ ��
//			int check_recovery = 1; //Ư�� �������� ȸ�� �Ⱓ
//			float infect_num = 1; //Ư�� �������� ���ʰ������������
//			
//			float num1=1; //��ü �������� ������ ��
//			int num2=1; //��ü �������� ȸ�� �Ⱓ
//			float[] danger = new float[4]; //��ü �������� ���ʰ������������
//			
//			int i=0;
//			
//			//��ü ������ �� ���ϱ�
//			String SQL;
//			SQL = "SELECT COUNT(*) FROM DB2022_InfectedPerson;";
//			rs=st.executeQuery(SQL);
//			
//			while (rs.next()) {
//				total_infect = rs.getInt(1);
//			}
//			
//			//Ư�� ���� ������ �� ���ϱ�
//			String SQL2;
//			SQL2 = "SELECT total_patient FROM DB2022_AreaRank WHERE residential_area = ' " + UserLocation + " ' " + ";";
//			rs=st.executeQuery(SQL2);
//			
//			while (rs.next()) {
//				check_people2 = rs.getInt(1);
//			}
//			
//			//Ư�� ���� ������ ���� ȸ�� �Ⱓ �� ���ϱ�
//			String SQL3;
//			SQL3 = "SELECT R0, quarantine_period FROM DB2022_Epidemic WHERE ID = ' " + UserDisease + " ' " + ";";
//			rs=st.executeQuery(SQL3);
//			
//			while (rs.next()) {
//				check_beta = rs.getFloat(1);
//				check_recovery = rs.getInt(2);
//			}
//			
//			//Ư�� ������ Ư�� �������� ���ʰ������������ ���ϱ�
//			infect_num = check_beta * (check_people-check_people2) * check_recovery;
//			
//			//Ư�� ������ Ư�� �������� ���� ���ʰ�������������� 1���� Ŭ ��� ������ �� ���� �߼�, ���� ��� ���� �߼�
//			if (infect_num > 1) {
//				System.out.println(UserLocation + "���� " + UserDisease + "�� ������ ���� ���� ���� �߼��� �ֽ��ϴ�. ������ �ּ���.");
//			}
//			
//			else {
//				System.out.println(UserLocation + "���� " + UserDisease + "�� ������ ���� ���� ���� �߼��� �ֽ��ϴ�.");
//			}
//			
//			//��ü �������� ���� ������ ���� ȸ�� �Ⱓ �� ���ϱ�
//			String SQL4;
//			SQL4 = "SELECT R0, quarantine_period FROM DB2022_Epidemic;";
//			rs=st.executeQuery(SQL4);
//			
//			//�� ����, ��ü �������� ���� ���ʰ������������ ���ϱ�
//			while (rs.next()) {
//				num1 = rs.getFloat(1);
//				num2 = rs.getInt(2);
//				danger[i] = num1 * (391-total_infect) * num2;
//				i++;
//			}
//			
//			System.out.println("");
//			
//			System.out.println("���ʰ�������������� Ŭ���� �ش� �������� ���� ���ķ��� ũ�ٴ� ���Դϴ�.");
//			System.out.println("���� Ebola�� ���ʰ����������� " + danger[0] + " �Դϴ�.");
//			System.out.println("���� Corona�� ���ʰ����������� " + danger[1] + " �Դϴ�.");
//			System.out.println("���� Mers�� ���ʰ����������� " + danger[2] + " �Դϴ�.");
//			System.out.println("���� Sars�� ���ʰ����������� " + danger[3] + " �Դϴ�.");
//			
//		}
//		catch(Exception e) {
//			System.out.println("�����ͺ��̽� �˻� ����: "+e.getMessage());
//		}
//	}
//	
//
//}