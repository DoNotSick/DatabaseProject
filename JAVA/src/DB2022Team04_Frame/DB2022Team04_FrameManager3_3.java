package DB2022Team04_Frame;

import javax.swing.JTextField;

import DB2022Team04_Main.DB2022Team04_ManagerMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DB2022Team04_FrameManager3_3 {

	public JFrame frame;

	public DB2022Team04_FrameManager3_3(String[] regional_center_list) {

		// ������ ����
		frame = new JFrame();
		frame.setBounds(200, 400, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("������ �޴� (3) -  �˻�� ����");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// "������ �˻�Ҹ� �����ϼ���" ��
		JLabel lblNewLabel = new JLabel("������  �˻�Ҹ� �����ϼ���");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 30, 500, 40);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);

		// "�˻�� ����" �޺� �ڽ�
		final JComboBox rcCombo = new JComboBox(regional_center_list);
		rcCombo.setBounds(20, 80, 450, 40);
		frame.getContentPane().add(rcCombo);

		// ���� ��ư -> ������ ������ �˻�� �̸��� ManagerMenu4_3 �Ű� ���ڷ� �Ѿ
		JButton confirmBtn = new JButton("����");
		confirmBtn.setBounds(380, 210, 90, 35);
		frame.getContentPane().add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = rcCombo.getSelectedItem().toString();
				DB2022Team04_ManagerMenu MM = new DB2022Team04_ManagerMenu();
				MM.menu3_3(name);

				frame.setVisible(false);
			}
		});

		// JFrame�� ���� ��ư �߰� -> ������ ���� ȭ������ ���ư�
		JButton confirmBtn_1 = new JButton("\uC774\uC804");
		confirmBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//���� ȭ�� ����
				DB2022Team04_FrameManager3 window = new DB2022Team04_FrameManager3();
				window.frame.setVisible(true);
				//���� â �ݱ�
				frame.setVisible(false);
			}
		});
		confirmBtn_1.setBounds(22, 210, 90, 35);
		frame.getContentPane().add(confirmBtn_1);

		// JFrame�� Ȩ ��ư �߰� -> ������ Ȩ ȭ������ ���ư�
		JButton confirmBtn_home = new JButton("Ȩ����");
		confirmBtn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ȩ ȭ�� ����
				DB2022Team04_FrameMain window = new DB2022Team04_FrameMain();
				window.frame.setVisible(true);
				//���� â �ݱ�
				frame.setVisible(false);
			}
		});
		confirmBtn_home.setBounds(120, 210, 90, 35);
		frame.getContentPane().add(confirmBtn_home);
	}
}
