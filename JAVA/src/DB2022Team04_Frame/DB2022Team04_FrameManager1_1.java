package DB2022Team04_Frame;

import javax.swing.JTextField;

import DB2022Team04_Main.DB2022Team04_ManagerMenu;
import DB2022Team04_Main.DB2022Team04_UserMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DB2022Team04_FrameManager1_1 {

	public JFrame frame;
	private JTextField textField_name;
	private JTextField textField_tel;
	private JTextField textField_open;
	private JTextField textField_close;
	private JTextField textField_wait;

	public DB2022Team04_FrameManager1_1(String[] area_list) {

		// ������ ����
		frame = new JFrame();
		frame.setBounds(200, 350, 500, 715);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("������ �޴� (1) - ���ο� �Ƿ�� �Է�");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// �Ƿ�� = (�Ƿ�� �̸�, �Ƿ��� ����, ��ġ, ����ó, ���� �ð�, ���� �ð�, ��� �ο�)
		// JFrame�� "�Ƿ�� �̸�" ���ڿ� ǥ��
		JLabel lblNewLabel_name = new JLabel("�Ƿ�� �̸�");
		lblNewLabel_name.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_name.setBackground(Color.WHITE);
		lblNewLabel_name.setBounds(0, 20, 500, 40);
		lblNewLabel_name.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_name);

		// JFrame�� "�Ƿ��� ����" ���ڿ� ǥ��
		JLabel lblNewLabel_type = new JLabel("�Ƿ��� ����");
		lblNewLabel_type.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_type.setBackground(Color.WHITE);
		lblNewLabel_type.setBounds(0, 120, 500, 40);
		lblNewLabel_type.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_type);

		// JFrame�� "��ġ" ���ڿ� ǥ��
		JLabel lblNewLabel_area = new JLabel("��ġ");
		lblNewLabel_area.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_area.setBackground(Color.WHITE);
		lblNewLabel_area.setBounds(0, 220, 500, 40);
		lblNewLabel_area.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_area);

		// JFrame�� "����ó" ���ڿ� ǥ��
		JLabel lblNewLabel_tel = new JLabel("����ó");
		lblNewLabel_tel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_tel.setBackground(Color.WHITE);
		lblNewLabel_tel.setBounds(0, 320, 500, 40);
		lblNewLabel_tel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_tel);

		// JFrame�� "� ���� �ð�(tt:mm:ss)" ���ڿ� ǥ��
		JLabel lblNewLabel_open = new JLabel(" � ���� �ð�(tt:mm:ss)");
		lblNewLabel_open.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel_open.setBackground(Color.WHITE);
		lblNewLabel_open.setBounds(20, 420, 210, 40);
		frame.getContentPane().add(lblNewLabel_open);

		// JFrame�� "� ���� �ð�(tt:mm:ss)" ���ڿ� ǥ��
		JLabel lblNewLabel_close = new JLabel(" � ���� �ð�(tt:mm:ss)");
		lblNewLabel_close.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel_close.setBackground(Color.WHITE);
		lblNewLabel_close.setBounds(260, 420, 210, 40);
		frame.getContentPane().add(lblNewLabel_close);

		// JFrame�� "����ο�" ���ڿ� ǥ��
		JLabel lblNewLabel_wait = new JLabel("��� �ο�");
		lblNewLabel_wait.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_wait.setBackground(Color.WHITE);
		lblNewLabel_wait.setBounds(0, 520, 500, 40);
		lblNewLabel_wait.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_wait);

		// JFrame�� �Ƿ�� �̸� �Է� ĭ ����
		textField_name = new JTextField();
		textField_name.setBounds(20, 60, 450, 40);
		textField_name.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_name);

		// JFrame�� �Ƿ��� ���� �Է� �޺��ڽ� ���� - "hospital", "clinic" �� ����
		String[] type_list = { "", "hospital", "clinic" };
		final JComboBox typeCombo = new JComboBox(type_list);
		typeCombo.setBounds(20, 160, 450, 40);
		frame.getContentPane().add(typeCombo);

		// JFrame�� ��ġ �Է� �޺��ڽ� ���� - area_list���� ����Ʈ �޾ƿ�
		final JComboBox areaCombo = new JComboBox(area_list);
		areaCombo.setBounds(20, 260, 450, 40);
		frame.getContentPane().add(areaCombo);

		// JFrame�� ����ó �Է� ĭ ����
		textField_tel = new JTextField();
		textField_tel.setBounds(20, 360, 450, 40);
		textField_tel.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_tel);

		// JFrame�� � ���� �ð� �Է� ĭ ����
		textField_open = new JTextField();
		textField_open.setBounds(20, 460, 210, 40);
		textField_open.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_open);

		// JFrame�� � ���� �ð� �Է� ĭ ����
		textField_close = new JTextField();
		textField_close.setBounds(260, 460, 210, 40);
		textField_close.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_close);

		// JFrame�� ��� �ο� �Է� ĭ ����
		textField_wait = new JTextField();
		textField_wait.setBounds(20, 560, 450, 40);
		textField_wait.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_wait);

		// JFrame�� �Է� ��ư �߰� -> ������ ����� ������ ManagerMenu1_1 �Ű� ���ڷ� �Ѿ
		JButton confirmBtn = new JButton("�Է�");
		confirmBtn.setBounds(388, 620, 90, 40);
		frame.getContentPane().add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �Ű� ���ڵ�
				String name = textField_name.getText();
				String type = typeCombo.getSelectedItem().toString();
				String area = areaCombo.getSelectedItem().toString();
				String tel = textField_tel.getText();
				String open = textField_open.getText();
				String close = textField_close.getText();
				int wait = Integer.parseInt(textField_wait.getText());

				// ManagerMenu�� menu1_1 ȣ��
				DB2022Team04_ManagerMenu MM = new DB2022Team04_ManagerMenu();
				MM.menu1_1(name, type, area, tel, open, close, wait);
				

				frame.setVisible(false);
			}
		});

		// JFrame�� ���� ��ư �߰� -> ������ ���� ȭ������ ���ư�
		JButton cancelBtn = new JButton("����");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���� ȭ�� ����
				DB2022Team04_FrameManager1 window = new DB2022Team04_FrameManager1();
				window.frame.setVisible(true);
				// ���� â �ݱ�
				frame.setVisible(false);
			}
		});
		cancelBtn.setBounds(22, 620, 90, 40);
		frame.getContentPane().add(cancelBtn);

		// JFrame�� Ȩ ��ư �߰� -> ������ Ȩ ȭ������ ���ư�
		JButton confirmBtn_home = new JButton("Ȩ����");
		confirmBtn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ȩ ȭ�� �߿��
				DB2022Team04_FrameMain window = new DB2022Team04_FrameMain();
				window.frame.setVisible(true);
				// ���� â �ݱ�
				frame.setVisible(false);
			}
		});
		confirmBtn_home.setBounds(120, 620, 91, 40);
		frame.getContentPane().add(confirmBtn_home);
	}
}
