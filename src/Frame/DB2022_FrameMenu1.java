package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Main.DB2022_UserMenu;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DB2022_FrameMenu1 {

	public JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblEx;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private JLabel lblEx_1;
	private JTextField textField_3;
	private JLabel lblNewLabel_3;
	private JTextField textField_5;
	private JLabel lblExmapogu;
	private JLabel lblNewLabel_4;

	public DB2022_FrameMenu1() {
		// �޺��ڽ����� ����� ��Ʈ�� �迭 ����
		String[] area = { "Seodaemun-gu", "Eunpyeong-gu", "Jungnang-gu", "Mapo-gu", "Nowon-gu", "Gangbuk-gu", "Jung-gu",
				"Gwanak-gu", "Dongdaemun-gu", "Gangseo-gu" };
		String[] disease = { "SARS", "Corona", "Ebola", "Mers" };
		String[] YorN = { "O", "X" };

		// ������ ����
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame�� '����� ���� �Է�' ���ڿ� ǥ��
		lblNewLabel_4 = new JLabel("\uD658\uC790 \uC815\uBCF4\uC785\uB825");// "����� ���� �Է�"
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(30, 10, 264, 34);
		frame.getContentPane().add(lblNewLabel_4);

		// JFrame�� '�̸�' ���ڿ� �߰�
		JLabel lblNewLabel = new JLabel("\uC774\uB984");// "�̸�"
		lblNewLabel.setBounds(136, 76, 107, 34);
		frame.getContentPane().add(lblNewLabel);

		// JFrame�� '�̸�' �Է� ĭ ����
		textField = new JTextField();
		textField.setBounds(198, 83, 96, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// JFrame�� '����' ���ڿ� ǥ��
		lblNewLabel_1 = new JLabel("\uBCD1\uBA85");// "����"
		lblNewLabel_1.setBounds(418, 76, 107, 34);
		frame.getContentPane().add(lblNewLabel_1);

		// JFrame�� '����' �޺��ڽ� ���� -> disease���� ����Ʈ �޾ƿ�
		final JComboBox strCombo_1 = new JComboBox(disease);
		strCombo_1.setBounds(475, 82, 120, 21);
		frame.getContentPane().add(strCombo_1);

		// JFrame�� '����' ���ڿ� ǥ��
		lblEx = new JLabel("\uB098\uC774");
		lblEx.setBounds(136, 212, 107, 34);
		frame.getContentPane().add(lblEx);

		// JFrame�� '����' �Է� ĭ ����
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(198, 219, 96, 21);
		frame.getContentPane().add(textField_2);

		// JFrame�� '������ȯ ����' ���ڿ� ǥ��
		lblNewLabel_2 = new JLabel(" \uAE30\uC800\uC9C8\uD658 \uC5EC\uBD80");// "������ȯ ����"
		lblNewLabel_2.setBounds(379, 212, 107, 34);
		frame.getContentPane().add(lblNewLabel_2);

		// JFrame�� '������ȯ ����' �޺��ڽ� ����
		final JComboBox strCombo_1_1 = new JComboBox(YorN); // YorN���� ����Ʈ �޾ƿ�
		strCombo_1_1.setBounds(475, 218, 120, 21);
		frame.getContentPane().add(strCombo_1_1);

		// JFrame�� 'Ȯ����¥' ���ڿ� ǥ��
		lblEx_1 = new JLabel("\uD655\uC9C4 \uB0A0\uC9DC");// "Ȯ�� ��¥"
		lblEx_1.setBounds(124, 332, 107, 34);
		frame.getContentPane().add(lblEx_1);

		// JFrame�� 'Ȯ����¥' �Է� ĭ ����
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(198, 339, 96, 21);
		frame.getContentPane().add(textField_3);

		// JFrame�� '��������' ���ڿ� ǥ��
		lblNewLabel_3 = new JLabel("\uAC70\uC8FC \uC9C0\uC5ED"); // "���� ����"
		lblNewLabel_3.setBounds(390, 332, 107, 34);
		frame.getContentPane().add(lblNewLabel_3);

		// JFrame�� '��������' �޺��ڽ� ���� - area���� ����Ʈ �޾ƿ�
		final JComboBox strCombo = new JComboBox(area);
		strCombo.setBounds(475, 339, 120, 21);
		frame.getContentPane().add(strCombo);

		// JFrame�� 'Ȯ�� ��¥' ���� ǥ�� - ����� ���Ǹ� ���� �߰�
		JLabel lblEx_2 = new JLabel("ex> 2022-05-15 \uB85C \uC785\uB825");// "ex> 2022-05-15 �� �Է�"
		lblEx_2.setBounds(124, 358, 177, 34);
		frame.getContentPane().add(lblEx_2);

		// JFrame�� Ȯ�� ��ư �߰� -> ������ ����� ������ menu1_1���� �Ѿ
		btnNewButton = new JButton("\uD655\uC778"); // "Ȯ��"
		btnNewButton.setBounds(617, 524, 145, 45);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {// Ŭ�� �̺�Ʈ �߻� ��
			public void actionPerformed(ActionEvent e) {

				DB2022_UserMenu userMenu = new DB2022_UserMenu();
				// ���� â���� �Է��� ������ ����
				userMenu.UserName = textField.getText();
				userMenu.UserName = textField.getText();
				userMenu.UserDisease = strCombo_1.getSelectedItem().toString();
				userMenu.UserAge = textField_2.getText();
				userMenu.UserDiseaseOX = strCombo_1_1.getSelectedItem().toString();
				userMenu.UserInfectDate = textField_3.getText();
				userMenu.UserLocation = strCombo.getSelectedItem().toString();
				frame.setVisible(false);

				// UserMenu�� menu1_1() �޼ҵ�� �ѱ�
				userMenu.menu1_1();
			}
		});

		// JFrame�� ���� ��ư �߰� -> ������ ���� ȭ������ ���ư�
		btnNewButton_1 = new JButton("\uC774\uC804"); // "����"
		btnNewButton_1.setBounds(22, 540, 91, 35);
		frame.getContentPane().add(btnNewButton_1);

		// ���� ��ư ������ ����� �޴� ȭ������ �̵�
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���� ȭ�� ����
				DB2022_FrameUser window = new DB2022_FrameUser();
				window.frame.setVisible(true);
				// ���� â �ݱ�
				frame.setVisible(false);

			}
		});

		// JFrame�� Ȩ ��ư �߰� -> ������ Ȩ ȭ������ ���ư�
		JButton confirmBtn_1_1 = new JButton("Ȩ����");
		confirmBtn_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ȩ ȭ�� ����
				DB2022_FrameMain window = new DB2022_FrameMain();
				window.frame.setVisible(true);
				// ���� â �ݱ�
				frame.setVisible(false);
			}
		});
		confirmBtn_1_1.setBounds(120, 540, 91, 35);
		frame.getContentPane().add(confirmBtn_1_1);

	}
}