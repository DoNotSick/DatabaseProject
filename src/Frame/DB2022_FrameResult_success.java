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

public class DB2022_FrameResult_success extends DB2022_UserMenu {

	public JFrame frame;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;

	public DB2022_FrameResult_success() {

		// ������ ����
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame�� "����! �ܼ�â�� Ȯ�����ּ���." ���ڿ� ǥ��
		lblNewLabel_1 = new JLabel("����! �ܼ�â�� Ȯ�����ּ���.");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(30, 110, 264, 34);
		frame.getContentPane().add(lblNewLabel_1);

		// JFrame�� ���� ��ư �߰� -> ������ ���� ȭ������ ���ư�
		btnNewButton_1 = new JButton("\uC774\uC804");
		btnNewButton_1.setBounds(22, 540, 91, 35);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				// ���� ȭ�� ����
				DB2022_FrameUser window = new DB2022_FrameUser();
				window.frame.setVisible(true);
				// ���� â �ݱ�
				frame.setVisible(false);
			}
		});

		// JFrame�� Ȩ ��ư �߰� -> ������ Ȩ ȭ������ �̵���
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
