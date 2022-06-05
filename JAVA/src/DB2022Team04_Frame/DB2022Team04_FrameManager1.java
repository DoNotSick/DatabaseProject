package DB2022Team04_Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import DB2022Team04_Main.DB2022Team04_ManagerMenu;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DB2022Team04_FrameManager1 {

	JFrame frame;

	public DB2022Team04_FrameManager1() {

		// ������ ����
		frame = new JFrame();
		frame.setBounds(200, 400, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("������ �޴� (1) - �Ƿ�� ���� ����");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame�� "���� �۾��� �����ϼ���" ���ڿ� ǥ��
		JLabel lblNewLabel = new JLabel("���� �۾��� �����ϼ���");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(140, 30, 320, 40);
		frame.getContentPane().add(lblNewLabel);

		// JFrame�� "���� �۾�" �޺� �ڽ� ���� - "���ο� �Ƿ�� �Է�", "�Ƿ�� ���� ����", "�Ƿ�� ����" �� ����
		String edit_list[] = { "���ο� �Ƿ�� �Է�", "�Ƿ�� ���� ����", "�Ƿ�� ����" };
		final JComboBox editCombo = new JComboBox(edit_list);

		editCombo.setBounds(40, 70, 400, 40);
		frame.getContentPane().add(editCombo);

		// JFrame�� Ȯ�� ��ư �߰� -> �ɼ� �����ϸ� �ش� �޴� ó���ϴ� �޼��� ȣ��
		JButton confirmBtn = new JButton("Ȯ��");
		confirmBtn.setBounds(380, 300, 90, 35);
		frame.getContentPane().add(confirmBtn);

		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB2022Team04_ManagerMenu MM = new DB2022Team04_ManagerMenu();
				String edit = editCombo.getSelectedItem().toString();
				if (edit == "���ο� �Ƿ�� �Է�") { // ù ��° �ɼ� ������ ���
					MM.activate_menu1_1(); // �ش� �޴��� ó���ϴ� activate_menu1_1() ȣ��
				} else if (edit == "�Ƿ�� ���� ����") { // �� ��° �ɼ� ������ ���
					MM.activate_menu1_2(); // �ش� �޴��� ó���ϴ� activate_menu1_2() ȣ��
				} else if (edit == "�Ƿ�� ����") { // �� ��° �ɼ� ������ ���
					MM.activate_menu1_3(); // �ش� �޴��� ó���ϴ� activate_menu1_3() ȣ��
				}
				frame.setVisible(false);
			}
		});

		// JFrame�� ���� ��ư �߰� -> ������ ���� ȭ������ ���ư�
		JButton cancelBtn = new JButton("����");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���� ȭ�� ����
				DB2022Team04_FrameManager window = new DB2022Team04_FrameManager();
				window.frame.setVisible(true);
				// ���� â �ݱ�
				frame.setVisible(false);
			}
		});
		cancelBtn.setBounds(22, 300, 90, 35);
		frame.getContentPane().add(cancelBtn);

		// JFrame�� Ȩ ��ư �߰� -> ������ Ȩ ȭ������ ���ư�
		JButton confirmBtn_home = new JButton("Ȩ����");
		confirmBtn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ȩ ȭ�� ����
				DB2022Team04_FrameMain window = new DB2022Team04_FrameMain();
				window.frame.setVisible(true);
				// ���� â �ݱ�
				frame.setVisible(false);
			}
		});
		confirmBtn_home.setBounds(120, 300, 90, 35);
		frame.getContentPane().add(confirmBtn_home);
	}
}
