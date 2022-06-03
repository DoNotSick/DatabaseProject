package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import Main.DB2022_ManagerMenu;
import Main.DB2022_UserMenu;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DB2022_FrameManager {

	JFrame frame;
	private JTextField textField;

	public DB2022_FrameManager() {

		// Frame Setting ������ ����
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("������ ���� �ý��� - ������ ���");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame�� '������ ���' ���ڿ� ǥ��
		JLabel managerModeLabel = new JLabel("\uAD00\uB9AC\uC790\uBAA8\uB4DC");// "�����ڸ��"
		managerModeLabel.setFont(new Font("����", Font.PLAIN, 20));
		managerModeLabel.setBounds(22, 10, 189, 49);
		frame.getContentPane().add(managerModeLabel);

		// �޴� ���� ����� JFrame�� ǥ��
		JLabel lblNewLabel = new JLabel("<html><body>" + "(1) �Ƿ�� ���� ����" + "<br />(2) �����豺 ���" + "<br />(3) �˻�� ���� ����"
				+ "<br />(4) ������ �� ����" + "</body></html>");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(32, 65, 739, 428);
		frame.getContentPane().add(lblNewLabel);

		// JFrame�� ����ڰ� ���� �Է��ϴ� ĭ ���� -> �޴� ����
		textField = new JTextField();
		textField.setBounds(642, 534, 46, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// JFrame�� Ȯ�� ��ư ���� -> ActionListener�� �о�ͼ� ��ȣ�� ���� �ش��ϴ� �޴��� �̵�
		JButton confirmBtn = new JButton("\uD655\uC778");// "Ȯ��"
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �޴� ��ȣ �Է¹ޱ�
				String number = textField.getText();
				// ��� �޴� �����ߴ��� �ܼ� â�� ���
				System.out.println("=======================================");
				System.out.println(number + "�� �޴��� Ŭ���ϼ̽��ϴ�.");

				DB2022_ManagerMenu MM = new DB2022_ManagerMenu();
				if (number.contains("1")) { // 1�� ���� ���
					// �޴��� �޴� 1���� ó���ϴ� FrameManager1 ȣ��
					DB2022_FrameManager1 window = new DB2022_FrameManager1();
					window.frame.setVisible(true);
				} else if (number.contains("3")) { // 3�� ���� ���
					// �Ŵ��� �޴� 3���� ó���ϴ� FrameManager3 ȣ��
					DB2022_FrameManager3 window = new DB2022_FrameManager3();
					window.frame.setVisible(true);
				} else {
					// 2�� ���� ��� menu�� ��ȣ�� �־ ȣ������(menu���� ó��)
					MM.menu(number);

				}
				frame.setVisible(false);
			}
		});
		confirmBtn.setBounds(700, 534, 91, 35);
		frame.getContentPane().add(confirmBtn);

		// JFrame�� ���� ��ư �߰� -> ������ ���� ȭ������ ���ư�
		JButton confirmBtn_1 = new JButton("\uC774\uC804");// "����"
		confirmBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���� ȭ�� ����
				DB2022_FrameMain window = new DB2022_FrameMain();
				window.frame.setVisible(true);
				// ���� â �ݱ�
				frame.setVisible(false);
			}
		});
		confirmBtn_1.setBounds(22, 540, 91, 35);
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
		confirmBtn_home.setBounds(120, 540, 91, 35);
		frame.getContentPane().add(confirmBtn_home);

		// '���ϴ� ��ȣ �Է�' �� "���ϴ� ��ȣ �Է� ex) 1"
		JLabel lblNewLabel_1 = new JLabel("\uC6D0\uD558\uB294 \uBC88\uD638 \uC785\uB825 ex) 1");
		lblNewLabel_1.setBounds(504, 544, 128, 15);
		frame.getContentPane().add(lblNewLabel_1);

	}
}