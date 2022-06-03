package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import Main.DB2022_ManagerMenu;
import Main.DB2022_UserMenu;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DB2022_FrameManager {

	JFrame frame;
	private JTextField textField;

	public DB2022_FrameManager() {

		// Frame Setting 프레임 세팅
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("전염병 관리 시스템 - 관리자 모드");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame에 '관리자 모드' 문자열 표시
		JLabel managerModeLabel = new JLabel("\uAD00\uB9AC\uC790\uBAA8\uB4DC");// "관리자모드"
		managerModeLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		managerModeLabel.setBounds(22, 10, 189, 49);
		frame.getContentPane().add(managerModeLabel);

		// 메뉴 사항 목록을 JFrame에 표시
		JLabel lblNewLabel = new JLabel("<html><body>" + "(1) 의료소 정보 수정" + "<br />(2) 고위험군 출력" + "<br />(3) 검사소 정보 수정"
				+ "<br />(4) 전염병 모델 예측" + "</body></html>");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(32, 65, 739, 428);
		frame.getContentPane().add(lblNewLabel);

		// JFrame에 사용자가 숫자 입력하는 칸 생성 -> 메뉴 선택
		textField = new JTextField();
		textField.setBounds(642, 534, 46, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// JFrame에 확인 버튼 생성 -> ActionListener로 읽어와서 번호에 따라 해당하는 메뉴로 이동
		JButton confirmBtn = new JButton("\uD655\uC778");// "확인"
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 메뉴 번호 입력받기
				String number = textField.getText();
				// 몇번 메뉴 선택했는지 콘솔 창에 출력
				System.out.println("=======================================");
				System.out.println(number + "번 메뉴를 클릭하셨습니다.");

				DB2022_ManagerMenu MM = new DB2022_ManagerMenu();
				if (number.contains("1")) { // 1번 누른 경우
					// 메니저 메뉴 1번을 처리하는 FrameManager1 호출
					DB2022_FrameManager1 window = new DB2022_FrameManager1();
					window.frame.setVisible(true);
				} else if (number.contains("3")) { // 3번 누른 경우
					// 매니저 메뉴 3번을 처리하는 FrameManager3 호출
					DB2022_FrameManager3 window = new DB2022_FrameManager3();
					window.frame.setVisible(true);
				} else {
					// 2번 누른 경우 menu에 번호를 넣어서 호출해줌(menu에서 처리)
					MM.menu(number);

				}
				frame.setVisible(false);
			}
		});
		confirmBtn.setBounds(700, 534, 91, 35);
		frame.getContentPane().add(confirmBtn);

		// JFrame에 이전 버튼 추가 -> 누르면 이전 화면으로 돌아감
		JButton confirmBtn_1 = new JButton("\uC774\uC804");// "이전"
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

		// JFrame에 홈 버튼 추가 -> 누르면 홈 화면으로 돌아감
		JButton confirmBtn_home = new JButton("홈으로");
		confirmBtn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 홈 화면 띄우기
				DB2022_FrameMain window = new DB2022_FrameMain();
				window.frame.setVisible(true);
				// 현재 창 닫기
				frame.setVisible(false);
			}
		});
		confirmBtn_home.setBounds(120, 540, 91, 35);
		frame.getContentPane().add(confirmBtn_home);

		// '원하는 번호 입력' 글 "원하는 번호 입력 ex) 1"
		JLabel lblNewLabel_1 = new JLabel("\uC6D0\uD558\uB294 \uBC88\uD638 \uC785\uB825 ex) 1");
		lblNewLabel_1.setBounds(504, 544, 128, 15);
		frame.getContentPane().add(lblNewLabel_1);

	}
}