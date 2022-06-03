package Frame;

import javax.swing.JTextField;

import Main.DB2022_ManagerMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DB2022_FrameManager1_3 {

	public JFrame frame;

	public DB2022_FrameManager1_3(String[] medical_center_list) {

		// ������ ����
		frame = new JFrame();
		frame.setBounds(200, 400, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("������ �޴� (1) - �Ƿ�� ����");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame�� "������ �Ƿ�Ҹ� �����ϼ���" ���ڿ� ǥ��
		JLabel lblNewLabel = new JLabel("������ �Ƿ�Ҹ� �����ϼ���");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 30, 500, 40);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);

		// JFrame�� "�Ƿ�� ����" �޺� �ڽ� ����
		final JComboBox mcCombo = new JComboBox(medical_center_list);
		mcCombo.setBounds(20, 80, 450, 40);
		frame.getContentPane().add(mcCombo);

		// JFrame�� ���� ��ư �߰� -> ������ ������ �Ƿ�� �̸��� ManagerMenu1_3 �Ű� ���ڷ� �Ѿ
		JButton confirmBtn = new JButton("����");
		confirmBtn.setBounds(380, 210, 90, 35);
		frame.getContentPane().add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = mcCombo.getSelectedItem().toString();
				// ManagerMenu�� menu1_3 ȣ��
				DB2022_ManagerMenu MM = new DB2022_ManagerMenu();
				MM.menu1_3(name);
				// Ȩ ȭ������ ���ư�
				DB2022_FrameMain mainWindow = new DB2022_FrameMain();
				mainWindow.frame.setVisible(true);
				// ���� â �ݱ�
				frame.setVisible(false);
			}
		});

		// JFrame�� ���� ��ư �߰� -> ������ ���� ȭ������ ���ư�
		JButton confirmBtn_1 = new JButton("\uC774\uC804");// "����"
		confirmBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���� ȭ�� ����
				DB2022_FrameManager1 window = new DB2022_FrameManager1();
				window.frame.setVisible(true);
				// ���� â �ݱ�
				frame.setVisible(false);
			}
		});
		confirmBtn_1.setBounds(22, 210, 90, 35);
		frame.getContentPane().add(confirmBtn_1);

		// JFrame�� Ȩ ��ư �߰� -> ������ Ȩ ȭ������ ���ư�
		JButton confirmBtn_home = new JButton("Ȩ����");
		confirmBtn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ȩ ȭ�� ����
				DB2022_FrameMain window = new DB2022_FrameMain();
				window.frame.setVisible(true);
				// ���� â �ݱ�
				frame.setVisible(false);
			}
		});
		confirmBtn_home.setBounds(120, 210, 90, 35);
		frame.getContentPane().add(confirmBtn_home);
	}
}
