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
		frame.setTitle("전염병 관리 시스템 - 사용자 모드");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame에 '사용자 모드' 문자열 표시
		JLabel UserModeLabel = new JLabel("\uC0AC\uC6A9\uC790\uBAA8\uB4DC");//"사용자모드"
		UserModeLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		UserModeLabel.setBounds(22, 10, 189, 49);
		frame.getContentPane().add(UserModeLabel);

		//  JFrame에 메뉴 사항 표시
		JLabel lblNewLabel = new JLabel("<html><body>" + "===진료===================================="
				+ "<br />(1) 환자 정보 입력" + "<br />(2) 환자 정보 수정" + "<br />(3) 현재 운영중인 병원 " + "<br />(4) 현재 운영중인 검사소"
				+ "<br />(5) 의료소를 대기 인원 적은 순서대로" + "<br />(6) 자가 격리 기간 안내"
				+ "<br /><br />===통계====================================" + "<br />(7) 감염자 수 많은 지역 순서대로"
				+ "<br />(8) 지역별로 환자 수 많은 전염병" + "<br />(9) 지역별 전염병 당 감염자 수" + "<br />(10) 특정 병 걸린 환자 수"
				+ "<br />(11) 전염병 별 감염자 평균 나이, 확진날짜"

				+ "</body></html>");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(32, 65, 739, 428);
		frame.getContentPane().add(lblNewLabel);

		//  JFrame에 메뉴 입력 칸 추가
		textField = new JTextField();
		textField.setBounds(642, 534, 46, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		//  JFrame에 확인 버튼 추가 -> 누르면 해당 메뉴 처리하는 메서드 호출
		JButton confirmBtn = new JButton("\uD655\uC778");
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//메뉴 입력받기
				String number = textField.getText();
				//몇번 메뉴 선택했는지 콘솔창에 출력
				System.out.println("\n\n=======================================");
				System.out.println(number + "번 메뉴를 클릭하셨습니다.\n");
				DB2022Team04_UserMenu UM = new DB2022Team04_UserMenu();
				//해당 메뉴 처리하는 메서드 호출
				UM.menu(number);
				//기존 창 닫기
				frame.setVisible(false);
			}
		});
		confirmBtn.setBounds(700, 534, 91, 35);
		frame.getContentPane().add(confirmBtn);

		//  JFrame에 이전 버튼 추가 -> 누르면 이전 화면으로 돌아감
		JButton confirmBtn_1 = new JButton("\uC774\uC804"); //"이전"
		confirmBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//이전 화면 띄우기
				DB2022Team04_FrameMain window = new DB2022Team04_FrameMain();
				window.frame.setVisible(true);
				//기존 창 닫기
				frame.setVisible(false);
			}
		});
		confirmBtn_1.setBounds(22, 540, 91, 35);
		frame.getContentPane().add(confirmBtn_1);

		//  JFrame에 사용자 입력 지시하는 '원하는 번호 입력 ex) 1' 문자열 표시
		JLabel lblNewLabel_1 = new JLabel("\uC6D0\uD558\uB294 \uBC88\uD638 \uC785\uB825 ex) 1");//'원하는 번호 입력 ex) 1'
		lblNewLabel_1.setBounds(504, 544, 128, 15);
		frame.getContentPane().add(lblNewLabel_1);

	}
}
