package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Main.*;

public class DB2022_FrameMenu4 {

	public JFrame frame;
	private JTextField textField;
	public JLabel label;

	public DB2022_FrameMenu4() {
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame�� '����� ���' ���ڿ� �߰�
		JLabel UserModeLabel = new JLabel("\uC0AC\uC6A9\uC790\uBAA8\uB4DC");// "����� ���"
		UserModeLabel.setFont(new Font("����", Font.PLAIN, 20));
		UserModeLabel.setBounds(22, 10, 189, 49);
		frame.getContentPane().add(UserModeLabel);

		// JFrame�� �޴� ���� ǥ��
		JLabel lblNewLabel = new JLabel("<html><body>" + "<br />(3) ���� �� ���� � ���� �˻��" + "</body></html>");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(32, 65, 739, 428);
		frame.getContentPane().add(lblNewLabel);

		// JFrame�� ���� ��ư �߰� -> ������ ���� ȭ������ ���ư�
		JButton confirmBtn_1 = new JButton("\uC774\uC804");
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

		JLabel label = new JLabel("\"���� �� ���� � ���� �˻��\"");
		label.setBounds(0, 0, 1000, 1000);
		frame.getContentPane().add(label);

		// JFrame�� Ȩ ��ư �߰� -> ������ Ȩ ȭ������ �̵�
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
