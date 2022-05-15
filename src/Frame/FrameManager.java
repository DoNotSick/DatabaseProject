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

public class FrameManager {

	JFrame frame;
	private JTextField textField;


	public FrameManager() {
		
		//프레임 셋팅 
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		
		//'관리자 모드' 글
		JLabel managerModeLabel = new JLabel("\uAD00\uB9AC\uC790\uBAA8\uB4DC");
		managerModeLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		managerModeLabel.setBounds(22, 10, 189, 49);
		frame.getContentPane().add(managerModeLabel);
		
		
		//메뉴 사항 목록 글
		JLabel lblNewLabel = new JLabel("<html><body>"
				+ "(1) 어쩌구 저쩌구"
				+ "<br />(1) 어쩌구 저쩌구"
				+ "<br />(1) 어쩌구 저쩌구"
				+ "<br />(1) 어쩌구 저쩌구"
				+ "<br />(1) 어쩌구 저쩌구"
				+ "<br />(1) 어쩌구 저쩌구"
				+ "<br />(1) 어쩌구 저쩌구"
				+ "<br />(1) 어쩌구 저쩌구"
				+ "</body></html>");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(32, 65, 739, 428);
		frame.getContentPane().add(lblNewLabel);
		
		
		//사용자가 숫자 입력하는 칸
		textField = new JTextField();
		textField.setBounds(642, 534, 46, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		//확인 버튼
		JButton confirmBtn = new JButton("\uD655\uC778");
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText();
				System.out.println(number);
			}
		});
		confirmBtn.setBounds(700, 534, 91, 35);
		frame.getContentPane().add(confirmBtn);
		
		
		//이전 버튼 
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
		
		
		//'원하는 번호 입력' 글
		JLabel lblNewLabel_1 = new JLabel("\uC6D0\uD558\uB294 \uBC88\uD638 \uC785\uB825 ex) 1");
		lblNewLabel_1.setBounds(504, 544, 128, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
	}
}
