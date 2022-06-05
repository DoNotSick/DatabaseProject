package DB2022Team04_Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import DB2022Team04_Main.*;

public class DB2022Team04_FrameUser {

	public JFrame frame;
	private JTextField textField;

	public DB2022Team04_FrameUser() {
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("������ ���� �ý��� - ����� ���");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame�� '����� ���' ���ڿ� ǥ��
		JLabel UserModeLabel = new JLabel("\uC0AC\uC6A9\uC790\uBAA8\uB4DC");//"����ڸ��"
		UserModeLabel.setFont(new Font("����", Font.PLAIN, 20));
		UserModeLabel.setBounds(22, 10, 189, 49);
		frame.getContentPane().add(UserModeLabel);

		//  JFrame�� �޴� ���� ǥ��
		JLabel lblNewLabel = new JLabel("<html><body>" + "===����===================================="
				+ "<br />(1) ȯ�� ���� �Է�" + "<br />(2) ȯ�� ���� ����" + "<br />(3) ���� ����� ���� " + "<br />(4) ���� ����� �˻��"
				+ "<br />(5) �Ƿ�Ҹ� ��� �ο� ���� �������" + "<br />(6) �ڰ� �ݸ� �Ⱓ �ȳ�"
				+ "<br /><br />===���====================================" + "<br />(7) ������ �� ���� ���� �������"
				+ "<br />(8) �������� ȯ�� �� ���� ������" + "<br />(9) ������ ������ �� ������ ��" + "<br />(10) Ư�� �� �ɸ� ȯ�� ��"
				+ "<br />(11) ������ �� ������ ��� ����, Ȯ����¥"

				+ "</body></html>");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(32, 65, 739, 428);
		frame.getContentPane().add(lblNewLabel);

		//  JFrame�� �޴� �Է� ĭ �߰�
		textField = new JTextField();
		textField.setBounds(642, 534, 46, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		//  JFrame�� Ȯ�� ��ư �߰� -> ������ �ش� �޴� ó���ϴ� �޼��� ȣ��
		JButton confirmBtn = new JButton("\uD655\uC778");
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�޴� �Է¹ޱ�
				String number = textField.getText();
				//��� �޴� �����ߴ��� �ܼ�â�� ���
				System.out.println("\n\n=======================================");
				System.out.println(number + "�� �޴��� Ŭ���ϼ̽��ϴ�.\n");
				DB2022Team04_UserMenu UM = new DB2022Team04_UserMenu();
				//�ش� �޴� ó���ϴ� �޼��� ȣ��
				UM.menu(number);
				//���� â �ݱ�
				frame.setVisible(false);
			}
		});
		confirmBtn.setBounds(700, 534, 91, 35);
		frame.getContentPane().add(confirmBtn);

		//  JFrame�� ���� ��ư �߰� -> ������ ���� ȭ������ ���ư�
		JButton confirmBtn_1 = new JButton("\uC774\uC804"); //"����"
		confirmBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//���� ȭ�� ����
				DB2022Team04_FrameMain window = new DB2022Team04_FrameMain();
				window.frame.setVisible(true);
				//���� â �ݱ�
				frame.setVisible(false);
			}
		});
		confirmBtn_1.setBounds(22, 540, 91, 35);
		frame.getContentPane().add(confirmBtn_1);

		//  JFrame�� ����� �Է� �����ϴ� '���ϴ� ��ȣ �Է� ex) 1' ���ڿ� ǥ��
		JLabel lblNewLabel_1 = new JLabel("\uC6D0\uD558\uB294 \uBC88\uD638 \uC785\uB825 ex) 1");//'���ϴ� ��ȣ �Է� ex) 1'
		lblNewLabel_1.setBounds(504, 544, 128, 15);
		frame.getContentPane().add(lblNewLabel_1);

	}
}
