package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import java.awt.Color;

public class DB2022_FrameMain {

	public JFrame frame;

	public DB2022_FrameMain() {
		// Frame Setting ������ ����
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 644); // ������ ũ�� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("������ ���� �ý��� Ȩ"); // title ����
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// '������ ���� �ý���' ��
		JLabel lblNewLabel = new JLabel("�����������ý���");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBounds(317, 67, 167, 33);
		frame.getContentPane().add(lblNewLabel);

		// '������ ��� ' ��ư -> Frame Manager �� �Ѿ
		JButton btnNewButton = new JButton("\uAD00\uB9AC\uC790 \uBAA8\uB4DC");// "������ ���"
		btnNewButton.setBounds(280, 179, 235, 102);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ��ư ������ ActionEvent��
				DB2022_FrameManager window = new DB2022_FrameManager();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});

		// '����� ���' ��ư -> Frame User�� �Ѿ
		JButton btnNewButton_1 = new JButton("\uC0AC\uC6A9\uC790 \uBAA8\uB4DC");// "����� ���"
		btnNewButton_1.setBounds(280, 321, 235, 102);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB2022_FrameUser window = new DB2022_FrameUser();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
	}

}
