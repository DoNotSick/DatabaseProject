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
		frame.setTitle("사용자 메뉴 (6) - 격리 해제 날짜 안내");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame에 "이름을 입력하세요" 문자열 표시
		JLabel lblNewLabel = new JLabel("이름을 입력하세요");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(140, 30, 320, 40);
		frame.getContentPane().add(lblNewLabel);

		// JFrame에 이름 입력 칸 생성
		textField = new JTextField();
		textField.setBounds(20, 70, 360, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// JFrame에 입력 버튼 추가 -> 누르면 사용자가 입력한 정보가 UserMenu6 매개 인자로 넘어감
		JButton confirmBtn = new JButton("입력");
		confirmBtn.setBounds(390, 70, 80, 40);
		frame.getContentPane().add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//이름 입력받음
				String patient_name = textField.getText();
				DB2022_UserMenu UM = new DB2022_UserMenu();
				//해당 메뉴를 처리하는 UserMenu의 menu6 호출
				UM.menu6(patient_name);
				frame.setVisible(false);
			}
		});

		// JFrame에 이전 버튼 추가 -> 누르면 이전 화면으로 돌아감
		JButton confirmBtn_1 = new JButton("\uC774\uC804");
		confirmBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//이전 화면 띄우기
				DB2022_FrameUser window = new DB2022_FrameUser();
				window.frame.setVisible(true);
				//현재 창 닫기
				frame.setVisible(false);
			}
		});
		confirmBtn_1.setBounds(22, 540, 91, 35);
		frame.getContentPane().add(confirmBtn_1);

		// JFrame에 홈 버튼 추가
		JButton confirmBtn_1_1 = new JButton("홈으로");
		confirmBtn_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//홈 화면 띄우기
				DB2022_FrameMain window = new DB2022_FrameMain();
				window.frame.setVisible(true);
				//현재 창 닫기
				frame.setVisible(false);
			}
		});
		confirmBtn_1_1.setBounds(120, 540, 91, 35);
		frame.getContentPane().add(confirmBtn_1_1);
	}
}
