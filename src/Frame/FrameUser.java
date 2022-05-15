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

public class FrameUser {

	JFrame frame;
	private JTextField textField;


	public FrameUser() {
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		
		//'����� ���' ��
		JLabel UserModeLabel = new JLabel("\uC0AC\uC6A9\uC790\uBAA8\uB4DC");
		UserModeLabel.setFont(new Font("����", Font.PLAIN, 20));
		UserModeLabel.setBounds(22, 10, 189, 49);
		frame.getContentPane().add(UserModeLabel);
		
		// �޴� ���� �� 
		JLabel lblNewLabel = new JLabel("<html><body>"
				+ "(1) ȯ�� ���� �Է�"
				+ "<br />(2) ȯ�� �� ���� ���� ������� ������ ���̺�"
				+ "<br />(1) ��¼�� ��¼��"
				+ "<br />(1) ��¼�� ��¼��"
				+ "<br />(1) ��¼�� ��¼��"
				+ "<br />(1) ��¼�� ��¼��"
				+ "<br />(1) ��¼�� ��¼��"
				+ "<br />(1) ��¼�� ��¼��"
				+ "</body></html>");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(32, 65, 739, 428);
		frame.getContentPane().add(lblNewLabel);
		
		
		// ����ڰ� �Է��� ĭ
		textField = new JTextField();
		textField.setBounds(642, 534, 46, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		//Ȯ�� ��ư -> ������ ����ڰ� �Է��� ���� UserMenu �Ű� ���ڷ� �Ѿ
		JButton confirmBtn = new JButton("\uD655\uC778");
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText();
				System.out.println(number);
				UserMenu UM = new UserMenu();
				UM.menu(number);
				frame.setVisible(false);
			}
		});
		confirmBtn.setBounds(700, 534, 91, 35);
		frame.getContentPane().add(confirmBtn);
		
		
		
		//���� ��ư
		JButton confirmBtn_1 = new JButton("\uC774\uC804");
		confirmBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameMain window = new FrameMain();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		confirmBtn_1.setBounds(22, 540, 91, 35);
		frame.getContentPane().add(confirmBtn_1);
		
		
		//'���ϴ� ��ȣ �Է� ex)' ��
		JLabel lblNewLabel_1 = new JLabel("\uC6D0\uD558\uB294 \uBC88\uD638 \uC785\uB825 ex) 1");
		lblNewLabel_1.setBounds(504, 544, 128, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
	}
}
