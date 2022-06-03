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

		// JFrame에 '사용자 모드' 문자열 추가
		JLabel UserModeLabel = new JLabel("\uC0AC\uC6A9\uC790\uBAA8\uB4DC");// "사용자 모드"
		UserModeLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		UserModeLabel.setBounds(22, 10, 189, 49);
		frame.getContentPane().add(UserModeLabel);

		// JFrame에 메뉴 사항 표시
		JLabel lblNewLabel = new JLabel("<html><body>" + "<br />(3) 지역 내 현재 운영 중인 검사소" + "</body></html>");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(32, 65, 739, 428);
		frame.getContentPane().add(lblNewLabel);

		// JFrame에 이전 버튼 추가 -> 누르면 이전 화면으로 돌아감
		JButton confirmBtn_1 = new JButton("\uC774\uC804");
		confirmBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 이전 화면 띄우기
				DB2022_FrameMain window = new DB2022_FrameMain();
				window.frame.setVisible(true);
				// 현재 창 닫기
				frame.setVisible(false);
			}
		});
		confirmBtn_1.setBounds(22, 540, 91, 35);
		frame.getContentPane().add(confirmBtn_1);

		JLabel label = new JLabel("\"지역 내 현재 운영 중인 검사소\"");
		label.setBounds(0, 0, 1000, 1000);
		frame.getContentPane().add(label);

		// JFrame에 홈 버튼 추가 -> 누르면 홈 화면으로 이동
		JButton confirmBtn_1_1 = new JButton("홈으로");
		confirmBtn_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 홈 화면 띄우기
				DB2022_FrameMain window = new DB2022_FrameMain();
				window.frame.setVisible(true);
				// 현재 창 닫기
				frame.setVisible(false);
			}
		});
		confirmBtn_1_1.setBounds(120, 540, 91, 35);
		frame.getContentPane().add(confirmBtn_1_1);

	}
}
