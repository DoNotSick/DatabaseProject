package Frame;

import javax.swing.JTextField;

import Main.DB2022_ManagerMenu;
import Main.DB2022_UserMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DB2022_FrameManager3_1 {

	public JFrame frame;
	private JTextField textField_name;
	private JTextField textField_tel;
	private JTextField textField_open;
	private JTextField textField_close;

	public DB2022_FrameManager3_1(String[] area_list) {

		// ������ ����
		frame = new JFrame();
		frame.setBounds(200, 350, 500, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("������ �޴� (3) - ���ο� �˻�� �Է�");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// �˻�� = (�˻�� �̸�, ��ġ, ����ó, ���� �ð�, ���� �ð�)
		// JFrame�� "�˻�� �̸�" ���ڿ� ǥ��
		JLabel lblNewLabel_name = new JLabel("�˻�� �̸�");
		lblNewLabel_name.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_name.setBackground(Color.WHITE);
		lblNewLabel_name.setBounds(0, 20, 500, 40);
		lblNewLabel_name.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_name);

		// JFrame�� "��ġ" ���ڿ� ǥ��
		JLabel lblNewLabel_area = new JLabel("��ġ");
		lblNewLabel_area.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_area.setBackground(Color.WHITE);
		lblNewLabel_area.setBounds(0, 120, 500, 40);
		lblNewLabel_area.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_area);

		// JFrame�� "����ó" ���ڿ� ǥ��
		JLabel lblNewLabel_tel = new JLabel("����ó");
		lblNewLabel_tel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_tel.setBackground(Color.WHITE);
		lblNewLabel_tel.setBounds(0, 220, 500, 40);
		lblNewLabel_tel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_tel);

		// JFrame�� "� ���� �ð�" ���ڿ� ǥ��
		JLabel lblNewLabel_open = new JLabel("� ���� �ð�");
		lblNewLabel_open.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_open.setBackground(Color.WHITE);
		lblNewLabel_open.setBounds(60, 320, 190, 40);
		frame.getContentPane().add(lblNewLabel_open);

		// JFrame�� "� ���� �ð�" ���ڿ� ǥ��
		JLabel lblNewLabel_close = new JLabel("� ���� �ð�");
		lblNewLabel_close.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_close.setBackground(Color.WHITE);
		lblNewLabel_close.setBounds(300, 320, 190, 40);
		frame.getContentPane().add(lblNewLabel_close);

		// JFrame�� �Ƿ�� �̸� �Է� ĭ ����
		textField_name = new JTextField();
		textField_name.setBounds(20, 60, 450, 40);
		textField_name.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_name);

		// JFrame�� ��ġ �Է� �޺��ڽ� ���� - area_list���� ����Ʈ �޾ƿ�
		final JComboBox areaCombo = new JComboBox(area_list);
		areaCombo.setBounds(20, 160, 450, 40);
		frame.getContentPane().add(areaCombo);

		// JFrame�� ����ó �Է� ĭ ����
		textField_tel = new JTextField();
		textField_tel.setBounds(20, 260, 450, 40);
		textField_tel.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_tel);

		// JFrame�� � ���� �ð� �Է� ĭ ����
		textField_open = new JTextField();
		textField_open.setBounds(20, 360, 210, 40);
		textField_open.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_open);

		// JFrame�� � ���� �ð� �Է� ĭ ����
		textField_close = new JTextField();
		textField_close.setBounds(260, 360, 210, 40);
		textField_close.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_close);

		// JFrame�� �Է� ��ư �߰� -> ������ ����ڰ� ������ ManagerMenu1_1 �Ű� ���ڷ� �Ѿ
		JButton confirmBtn = new JButton("�Է�");
		confirmBtn.setBounds(388, 420, 90, 40);
		frame.getContentPane().add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �Ű�������
				String name = textField_name.getText();
				String area = areaCombo.getSelectedItem().toString();
				String tel = textField_tel.getText();
				String open = textField_open.getText();
				String close = textField_close.getText();

				// �ش� �޴��� ó���ϴ� ManagerMenu�� menu3_1 �޼��� ȣ��
				DB2022_ManagerMenu MM = new DB2022_ManagerMenu();
				MM.menu3_1(name, area, tel, open, close);

				// Ȩ ȭ������ ���ư�
				DB2022_FrameMain mainWindow = new DB2022_FrameMain();
				mainWindow.frame.setVisible(true);

				// ���� â �ݱ�
				frame.setVisible(false);
			}
		});

		// JFrame�� ���� ��ư �߰� -> ������ ���� ȭ������ ���ư�
		JButton cancelBtn = new JButton("����");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���� ȭ�� ����
				DB2022_FrameManager3 window = new DB2022_FrameManager3();
				window.frame.setVisible(true);
				// ���� â �ݱ�
				frame.setVisible(false);
			}
		});
		cancelBtn.setBounds(22, 420, 90, 40);
		frame.getContentPane().add(cancelBtn);

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
		confirmBtn_home.setBounds(120, 420, 90, 35);
		frame.getContentPane().add(confirmBtn_home);
	}
}
