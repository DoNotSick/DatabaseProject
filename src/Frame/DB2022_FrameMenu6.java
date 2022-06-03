package Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Main.*;

public class DB2022_FrameMenu6 {

	public JFrame frame;
	private JTextField textField;

	public DB2022_FrameMenu6() {
		frame = new JFrame();
		frame.setBounds(200, 400, 500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("����� �޴� (6) - �ݸ� ���� ��¥ �ȳ�");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame�� "�̸��� �Է��ϼ���" ���ڿ� ǥ��
		JLabel lblNewLabel = new JLabel("�̸��� �Է��ϼ���");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(140, 30, 320, 40);
		frame.getContentPane().add(lblNewLabel);

		// JFrame�� �̸� �Է� ĭ ����
		textField = new JTextField();
		textField.setBounds(20, 70, 360, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// JFrame�� �Է� ��ư �߰� -> ������ ����ڰ� �Է��� ������ UserMenu6 �Ű� ���ڷ� �Ѿ
		JButton confirmBtn = new JButton("�Է�");
		confirmBtn.setBounds(390, 70, 80, 40);
		frame.getContentPane().add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�̸� �Է¹���
				String patient_name = textField.getText();
				DB2022_UserMenu UM = new DB2022_UserMenu();
				//�ش� �޴��� ó���ϴ� UserMenu�� menu6 ȣ��
				UM.menu6(patient_name);
				frame.setVisible(false);
			}
		});

		// JFrame�� ���� ��ư �߰� -> ������ ���� ȭ������ ���ư�
		JButton confirmBtn_1 = new JButton("\uC774\uC804");
		confirmBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//���� ȭ�� ����
				DB2022_FrameUser window = new DB2022_FrameUser();
				window.frame.setVisible(true);
				//���� â �ݱ�
				frame.setVisible(false);
			}
		});
		confirmBtn_1.setBounds(22, 540, 91, 35);
		frame.getContentPane().add(confirmBtn_1);

		// JFrame�� Ȩ ��ư �߰�
		JButton confirmBtn_1_1 = new JButton("Ȩ����");
		confirmBtn_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ȩ ȭ�� ����
				DB2022_FrameMain window = new DB2022_FrameMain();
				window.frame.setVisible(true);
				//���� â �ݱ�
				frame.setVisible(false);
			}
		});
		confirmBtn_1_1.setBounds(120, 540, 91, 35);
		frame.getContentPane().add(confirmBtn_1_1);
	}
}
