package DB2022Team04_Frame;

import javax.swing.JTextField;

import DB2022Team04_Main.DB2022Team04_ManagerMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DB2022Team04_FrameManager3_2 {

	public JFrame frame;
	private JTextField textField_name;
	private JTextField textField_tel;
	private JTextField textField_open;
	private JTextField textField_close;
	private JTextField textField_wait;
	private String mc;

	public DB2022Team04_FrameManager3_2(String[] area_list, String[] regional_center_list) {

		// ������ ����
		frame = new JFrame();
		frame.setBounds(50, 250, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("������ �޴� (3) - �˻�� ���� ����");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame�� "�˻�Ҹ� �����ϼ���" ���ڿ� ǥ��
		JLabel lblNewLabel = new JLabel("�˻�Ҹ� �����ϼ���");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 20, 800, 40);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);

		// JFrame�� "���� �˻�� ���" �޺� �ڽ� ����
		final JComboBox rcCombo = new JComboBox(regional_center_list);
		rcCombo.setBounds(50, 60, 700, 40);
		frame.getContentPane().add(rcCombo);

		// ���� ���� ����
		// JFrame�� "���������� �����ϼ���" ���ڿ� �߰�
		lblNewLabel = new JLabel("���� ������ �����ϼ���");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 25));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 170, 800, 40);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);

		// JFrame�� "�˻�� �̸�" ���ڿ� ǥ��
		JLabel lblNewLabel_name = new JLabel("�˻�� �̸�");
		lblNewLabel_name.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_name.setBackground(Color.WHITE);
		lblNewLabel_name.setBounds(0, 220, 800, 40);
		lblNewLabel_name.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_name);

		// JFrame�� "��ġ" ���ڿ� ǥ��
		JLabel lblNewLabel_area = new JLabel("��ġ");
		lblNewLabel_area.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_area.setBackground(Color.WHITE);
		lblNewLabel_area.setBounds(0, 320, 400, 40);
		lblNewLabel_area.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_area);

		// JFrame�� "����ó" ���ڿ� ǥ��
		JLabel lblNewLabel_tel = new JLabel("����ó");
		lblNewLabel_tel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_tel.setBackground(Color.WHITE);
		lblNewLabel_tel.setBounds(400, 320, 400, 40);
		lblNewLabel_tel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_tel);

		// JFrame�� "� ���� �ð�" ���ڿ� ǥ��
		JLabel lblNewLabel_open = new JLabel("� ���� �ð�");
		lblNewLabel_open.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_open.setBackground(Color.WHITE);
		lblNewLabel_open.setBounds(0, 420, 400, 40);
		lblNewLabel_open.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_open);

		// JFrame�� "� ���� �ð�" ���ڿ� ǥ��
		JLabel lblNewLabel_close = new JLabel("� ���� �ð�");
		lblNewLabel_close.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_close.setBackground(Color.WHITE);
		lblNewLabel_close.setBounds(400, 420, 400, 40);
		lblNewLabel_close.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_close);

		// JFrame�� �Ƿ�� �̸� �Է� ĭ ����
		textField_name = new JTextField();
		textField_name.setBounds(20, 260, 750, 40);
		textField_name.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_name);

		// JFrame�� ��ġ �Է� �޺��ڽ� ����
		final JComboBox areaCombo = new JComboBox(area_list);
		areaCombo.setBounds(20, 360, 350, 40);
		frame.getContentPane().add(areaCombo);

		// JFrame�� ����ó �Է� ĭ ����
		textField_tel = new JTextField();
		textField_tel.setBounds(420, 360, 350, 40);
		textField_tel.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_tel);

		// JFrame�� � ���� �ð� �Է� ĭ ����
		textField_open = new JTextField();
		textField_open.setBounds(20, 460, 350, 40);
		textField_open.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_open);

		// JFrame�� � ���� �ð� �Է� ĭ ����
		textField_close = new JTextField();
		textField_close.setBounds(420, 460, 350, 40);
		textField_close.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_close);

		// JFrame�� �Է� ��ư �߰� -> ������ ���������� ManagerMenu1_2 �Ű� ���ڷ� �Ѿ
		JButton confirmBtn = new JButton("�Է�");
		confirmBtn.setBounds(678, 515, 90, 40);
		frame.getContentPane().add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �Ű�������
				String original_name = rcCombo.getSelectedItem().toString();
				String name = textField_name.getText();
				String area = areaCombo.getSelectedItem().toString();
				String tel = textField_tel.getText();
				String open = textField_open.getText();
				String close = textField_close.getText();
				// �ش� �޴��� ó���ϴ� ManagerMenu�� menu3_2() ȣ��
				DB2022Team04_ManagerMenu MM = new DB2022Team04_ManagerMenu();
				MM.menu3_2(original_name, name, area, tel, open, close);
				
				// ���� â �ݱ�
				frame.setVisible(false);
			}
		});

		// JFrame�� ���� ��ư �߰� -> ������ ���� ȭ������ ���ư�
		JButton cancleBtn = new JButton("\uC774\uC804");
		cancleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���� ȭ�� ����
				DB2022Team04_FrameManager3 window = new DB2022Team04_FrameManager3();
				window.frame.setVisible(true);
				// ���� â �ݱ�
				frame.setVisible(false);
			}
		});
		cancleBtn.setBounds(22, 515, 90, 35);
		frame.getContentPane().add(cancleBtn);

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
		confirmBtn_home.setBounds(120, 515, 90, 35);
		frame.getContentPane().add(confirmBtn_home);
	}
}
