package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Main.DB2022_UserMenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class DB2022_FrameMenu2 {
	String[] area = { "Seodaemun-gu", "Eunpyeong-gu", "Jungnang-gu", "Mapo-gu", "Nowon-gu", "Gangbuk-gu", "Jung-gu",
			"Gwanak-gu", "Dongdaemun-gu", "Gangseo-gu" };
	String[] disease = { "SARS", "Corona", "Ebola", "Mers" };
	String[] YorN = { "O", "X" };

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblEx;
	DB2022_UserMenu UM = new DB2022_UserMenu();

	public DB2022_FrameMenu2() {
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame�� '�̸�' ���ڿ� �߰�
		JLabel lblNewLabel = new JLabel("\uC774\uB984"); // "�̸�"
		lblNewLabel.setBounds(170, 107, 50, 15);
		frame.getContentPane().add(lblNewLabel);

		// JFrame�� '����' ���ڿ� ǥ��
		JLabel lblNewLabel_1 = new JLabel("\uB098\uC774"); // "����"
		lblNewLabel_1.setBounds(471, 107, 50, 15);
		frame.getContentPane().add(lblNewLabel_1);

		// JFrame�� �̸� �Է� ĭ ����
		textField = new JTextField();
		textField.setBounds(170, 137, 96, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// JFrame�� ���� �Է� ĭ ����
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(471, 137, 96, 21);
		frame.getContentPane().add(textField_1);

		// JFrame�� '��������' ���ڿ� ǥ��
		lblNewLabel_2 = new JLabel("\uC0AC\uC6A9\uC790 \uC815\uBCF4 \uC218\uC815");// "��������"
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(33, 26, 248, 64);
		frame.getContentPane().add(lblNewLabel_2);

		// JFrame�� '����' ���ڿ� ǥ��
		lblNewLabel_1 = new JLabel("\uBCD1\uBA85"); // "����"
		lblNewLabel_1.setBounds(170, 325, 107, 34);
		frame.getContentPane().add(lblNewLabel_1);

		// JFrame�� '����' �޺��ڽ� ���� -> disease���� ����Ʈ �޾ƿ�
		final JComboBox strCombo_1 = new JComboBox(disease);
		strCombo_1.setBounds(170, 365, 96, 21);
		frame.getContentPane().add(strCombo_1);

		// JFrame�� '������ȯ����' ���ڿ� ǥ��
		lblNewLabel_2 = new JLabel(" \uAE30\uC800\uC9C8\uD658 \uC5EC\uBD80");// "������ȯ ����"
		lblNewLabel_2.setBounds(464, 424, 107, 34);
		frame.getContentPane().add(lblNewLabel_2);

		// JFrame�� '������ȯ ����' �޺��ڽ� ����
		final JComboBox strCombo_1_1 = new JComboBox(YorN);
		strCombo_1_1.setBounds(474, 468, 96, 21);
		frame.getContentPane().add(strCombo_1_1);

		// JFrame�� 'Ȯ����¥' ���ڿ� ǥ��
		JLabel lblEx_1 = new JLabel("\uD655\uC9C4 \uB0A0\uC9DC");// "Ȯ�� ��¥"
		lblEx_1.setBounds(159, 424, 107, 34);
		frame.getContentPane().add(lblEx_1);

		// JFrame�� 'Ȯ����¥' �Է� ĭ ����
		final JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(170, 463, 96, 21);
		frame.getContentPane().add(textField_3);

		// JFrame�� '��������' ���ڿ� ǥ��
		lblNewLabel_3 = new JLabel("\uAC70\uC8FC \uC9C0\uC5ED"); // "���� ����"
		lblNewLabel_3.setBounds(471, 325, 107, 34);
		frame.getContentPane().add(lblNewLabel_3);

		// JFrame�� '��������' �޺��ڽ� ���� -> area���� ����Ʈ �޾ƿ�
		final JComboBox strCombo = new JComboBox(area);
		strCombo.setBounds(471, 365, 96, 21);
		frame.getContentPane().add(strCombo);

		// JFrame�� 'Ȯ�� ��¥' ���� ǥ��
		JLabel lblEx_2 = new JLabel("ex> 2022-05-15 \uB85C \uC785\uB825"); // "ex> 2022-05-15 �� �Է�"
		lblEx_2.setBounds(222, 424, 177, 34);
		frame.getContentPane().add(lblEx_2);

		// JFrame�� Ȯ�� ��ư �߰� -> ������ ����� ������ menu2_1�� �Ѿ
		JButton confirmBtn = new JButton("\uD655\uC778");// "Ȯ��"
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �̸� �Է�
				String name = textField.getText();
				int age_1 = 0;
				try {
					// ���� �Է�
					String age = textField_1.getText();
					age_1 = Integer.parseInt(age);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				// ���� â���� �Է��� ������ ����
				String disease = strCombo_1.getSelectedItem().toString();
				String area = strCombo.getSelectedItem().toString();
				String date = textField_3.getText();
				String YorN = strCombo_1_1.getSelectedItem().toString();

				UM.menu2_1(name, age_1, disease, area, date, YorN);
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

		// JFrame�� "������ ����" ���ڿ� ǥ��
		lblNewLabel_3 = new JLabel("\uC218\uC815\uD560 \uB0B4\uC6A9");// "������ ����"
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(33, 261, 248, 64);
		frame.getContentPane().add(lblNewLabel_3);

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
