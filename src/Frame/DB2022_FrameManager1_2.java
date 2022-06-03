package Frame;

import javax.swing.JTextField;

import Main.DB2022_ManagerMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DB2022_FrameManager1_2 {

	public JFrame frame;
	private JTextField textField_name;
	private JTextField textField_tel;
	private JTextField textField_open;
	private JTextField textField_close;
	private JTextField textField_wait;
	private String mc;

	public DB2022_FrameManager1_2(String[] area_list, String[] medical_center_list) {

		// ������ ����
		frame = new JFrame();
		frame.setBounds(50, 250, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("������ �޴� (1) - �Ƿ�� ���� ����");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame�� "�Ƿ�Ҹ� �����ϼ���" ���ڿ� ǥ��
		JLabel lblNewLabel = new JLabel("�Ƿ�Ҹ� �����ϼ���");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 20, 800, 40);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);

		// JFrame�� "���� �Ƿ�� ���" �޺��ڽ� ����
		final JComboBox mcCombo = new JComboBox(medical_center_list);
		mcCombo.setBounds(50, 60, 700, 40);
		frame.getContentPane().add(mcCombo);

		// ���� ���� ���� �޴�
		// JFrame�� "���������� �����ϼ���" ���ڿ� ǥ��
		lblNewLabel = new JLabel("���� ������ �����ϼ���");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 25));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 170, 800, 40);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);

		// "�Ƿ�� �̸�" ���ڿ� ǥ��
		JLabel lblNewLabel_name = new JLabel("�Ƿ�� �̸�");
		lblNewLabel_name.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_name.setBackground(Color.WHITE);
		lblNewLabel_name.setBounds(0, 220, 800, 40);
		lblNewLabel_name.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_name);

		// JFrame�� "�Ƿ��� ����" ���ڿ� ǥ��
		JLabel lblNewLabel_type = new JLabel("�Ƿ��� ����");
		lblNewLabel_type.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_type.setBackground(Color.WHITE);
		lblNewLabel_type.setBounds(0, 320, 400, 40);
		lblNewLabel_type.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_type);

		// JFrame�� "��ġ" ���ڿ� ǥ��
		JLabel lblNewLabel_area = new JLabel("��ġ");
		lblNewLabel_area.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_area.setBackground(Color.WHITE);
		lblNewLabel_area.setBounds(400, 320, 400, 40);
		lblNewLabel_area.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_area);

		// JFrame�� "����ó" ���ڿ� ǥ��
		JLabel lblNewLabel_tel = new JLabel("����ó");
		lblNewLabel_tel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_tel.setBackground(Color.WHITE);
		lblNewLabel_tel.setBounds(0, 420, 400, 40);
		lblNewLabel_tel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_tel);

		// JFrame�� "����ο�" ���ڿ� ǥ��
		JLabel lblNewLabel_wait = new JLabel("��� �ο�");
		lblNewLabel_wait.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_wait.setBackground(Color.WHITE);
		lblNewLabel_wait.setBounds(400, 420, 400, 40);
		lblNewLabel_wait.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_wait);

		// JFrame�� "� ���� �ð�" ���ڿ� ǥ��
		JLabel lblNewLabel_open = new JLabel("� ���� �ð� (tt:mm:ss)");
		lblNewLabel_open.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_open.setBackground(Color.WHITE);
		lblNewLabel_open.setBounds(0, 520, 400, 40);
		lblNewLabel_open.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_open);

		// JFrame�� "� ���� �ð�" ���ڿ� ǥ��
		JLabel lblNewLabel_close = new JLabel("� ���� �ð� (tt:mm:ss)");
		lblNewLabel_close.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_close.setBackground(Color.WHITE);
		lblNewLabel_close.setBounds(400, 520, 400, 40);
		lblNewLabel_close.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_close);

		// JFrame�� �Ƿ�� �̸� �Է� ĭ ����
		textField_name = new JTextField();
		textField_name.setBounds(20, 260, 750, 40);
		textField_name.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_name);

		// JFrame�� �Ƿ��� ���� �Է� �޺��ڽ� ���� - "hospital", "clinic" �� ����
		String[] type_list = { "", "hospital", "clinic" };
		final JComboBox typeCombo = new JComboBox(type_list);
		typeCombo.setBounds(20, 360, 350, 40);
		frame.getContentPane().add(typeCombo);

		// JFrame�� ��ġ �Է� �޺��ڽ� ���� - area_list���� ����Ʈ �޾ƿ�
		final JComboBox areaCombo = new JComboBox(area_list);
		areaCombo.setBounds(420, 360, 350, 40);
		frame.getContentPane().add(areaCombo);

		// JFrame�� ����ó �Է� ĭ ����
		textField_tel = new JTextField();
		textField_tel.setBounds(20, 460, 350, 40);
		textField_tel.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_tel);

		// JFrame�� ��� �ο� �Է� ĭ ����
		textField_wait = new JTextField();
		textField_wait.setBounds(420, 460, 350, 40);
		textField_wait.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_wait);

		// JFrame�� � ���� �ð� �Է� ĭ ����
		textField_open = new JTextField();
		textField_open.setBounds(20, 560, 350, 40);
		textField_open.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_open);

		// JFrame�� � ���� �ð� �Է� ĭ ����
		textField_close = new JTextField();
		textField_close.setBounds(420, 560, 350, 40);
		textField_close.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_close);

		// JFrame�� �Է� ��ư �߰� -> ������ ���������� ManagerMenu1_2 �Ű� ���ڷ� �Ѿ
		JButton confirmBtn = new JButton("�Է�");
		confirmBtn.setBounds(678, 615, 90, 40);
		frame.getContentPane().add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �ް� ���ڵ�
				String ID = mcCombo.getSelectedItem().toString();
				String name = textField_name.getText();
				String type = typeCombo.getSelectedItem().toString();
				String area = areaCombo.getSelectedItem().toString();
				String tel = textField_tel.getText();
				String open = textField_open.getText();
				String close = textField_close.getText();
				String wait = textField_wait.getText();

				// ManagerMenu�� menu1_2 ȣ��
				DB2022_ManagerMenu MM = new DB2022_ManagerMenu();
				MM.menu1_2(ID, name, type, area, tel, open, close, wait);
				// Ȩ ȭ������ ���ư�
				DB2022_FrameMain mainWindow = new DB2022_FrameMain();
				mainWindow.frame.setVisible(true);
				//���� â �ݱ�
				frame.setVisible(false);
			}
		});

		// JFrame�� ���� ��ư �߰� -> ������ ���� ȭ������ ���ư�
		JButton cancleBtn = new JButton("\uC774\uC804");
		cancleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���� ȭ�� ����
				DB2022_FrameManager1 window = new DB2022_FrameManager1();
				window.frame.setVisible(true);
				// ���� â �ݱ�
				frame.setVisible(false);
			}
		});
		cancleBtn.setBounds(22, 615, 90, 35);
		frame.getContentPane().add(cancleBtn);

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
		confirmBtn_home.setBounds(120, 615, 90, 35);
		frame.getContentPane().add(confirmBtn_home);
	}
}
