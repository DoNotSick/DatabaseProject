package DB2022Team04_Frame;

import javax.swing.JTextField;

import DB2022Team04_Main.DB2022Team04_ManagerMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DB2022Team04_FrameManager3_2 {

	public JFrame frame;
	private JTextField textField_name;
	private JTextField textField_tel;
	private JTextField textField_open;
	private JTextField textField_close;
	private JTextField textField_wait;
	private String mc;

	public DB2022Team04_FrameManager3_2(String[] area_list, String[] regional_center_list) {

		// 프레임 셋팅
		frame = new JFrame();
		frame.setBounds(50, 250, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("관리자 메뉴 (3) - 검사소 정보 수정");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame에 "검사소를 선택하세요" 문자열 표시
		JLabel lblNewLabel = new JLabel("검사소를 선택하세요");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 20, 800, 40);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);

		// JFrame에 "기존 검사소 목록" 콤보 박스 생성
		final JComboBox rcCombo = new JComboBox(regional_center_list);
		rcCombo.setBounds(50, 60, 700, 40);
		frame.getContentPane().add(rcCombo);

		// 수정 사항 기재
		// JFrame에 "수정사항을 기재하세요" 문자열 추가
		lblNewLabel = new JLabel("수정 사항을 기재하세요");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 170, 800, 40);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);

		// JFrame에 "검사소 이름" 문자열 표시
		JLabel lblNewLabel_name = new JLabel("검사소 이름");
		lblNewLabel_name.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_name.setBackground(Color.WHITE);
		lblNewLabel_name.setBounds(0, 220, 800, 40);
		lblNewLabel_name.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_name);

		// JFrame에 "위치" 문자열 표시
		JLabel lblNewLabel_area = new JLabel("위치");
		lblNewLabel_area.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_area.setBackground(Color.WHITE);
		lblNewLabel_area.setBounds(0, 320, 400, 40);
		lblNewLabel_area.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_area);

		// JFrame에 "연락처" 문자열 표시
		JLabel lblNewLabel_tel = new JLabel("연락처");
		lblNewLabel_tel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_tel.setBackground(Color.WHITE);
		lblNewLabel_tel.setBounds(400, 320, 400, 40);
		lblNewLabel_tel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_tel);

		// JFrame에 "운영 시작 시각" 문자열 표시
		JLabel lblNewLabel_open = new JLabel("운영 시작 시각");
		lblNewLabel_open.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_open.setBackground(Color.WHITE);
		lblNewLabel_open.setBounds(0, 420, 400, 40);
		lblNewLabel_open.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_open);

		// JFrame에 "운영 마감 시각" 문자열 표시
		JLabel lblNewLabel_close = new JLabel("운영 마감 시각");
		lblNewLabel_close.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_close.setBackground(Color.WHITE);
		lblNewLabel_close.setBounds(400, 420, 400, 40);
		lblNewLabel_close.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_close);

		// JFrame에 의료소 이름 입력 칸 생성
		textField_name = new JTextField();
		textField_name.setBounds(20, 260, 750, 40);
		textField_name.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_name);

		// JFrame에 위치 입력 콤보박스 생성
		final JComboBox areaCombo = new JComboBox(area_list);
		areaCombo.setBounds(20, 360, 350, 40);
		frame.getContentPane().add(areaCombo);

		// JFrame에 연락처 입력 칸 생성
		textField_tel = new JTextField();
		textField_tel.setBounds(420, 360, 350, 40);
		textField_tel.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_tel);

		// JFrame에 운영 시작 시각 입력 칸 생성
		textField_open = new JTextField();
		textField_open.setBounds(20, 460, 350, 40);
		textField_open.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_open);

		// JFrame에 운영 마감 시각 입력 칸 생성
		textField_close = new JTextField();
		textField_close.setBounds(420, 460, 350, 40);
		textField_close.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_close);

		// JFrame에 입력 버튼 추가 -> 누르면 수정사항이 ManagerMenu1_2 매개 인자로 넘어감
		JButton confirmBtn = new JButton("입력");
		confirmBtn.setBounds(678, 515, 90, 40);
		frame.getContentPane().add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 매개변수들
				String original_name = rcCombo.getSelectedItem().toString();
				String name = textField_name.getText();
				String area = areaCombo.getSelectedItem().toString();
				String tel = textField_tel.getText();
				String open = textField_open.getText();
				String close = textField_close.getText();
				// 해당 메뉴를 처리하는 ManagerMenu의 menu3_2() 호출
				DB2022Team04_ManagerMenu MM = new DB2022Team04_ManagerMenu();
				MM.menu3_2(original_name, name, area, tel, open, close);
				
				// 현재 창 닫기
				frame.setVisible(false);
			}
		});

		// JFrame에 이전 버튼 추가 -> 누르면 이전 화면으로 돌아감
		JButton cancleBtn = new JButton("\uC774\uC804");
		cancleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 이전 화면 띄우기
				DB2022Team04_FrameManager3 window = new DB2022Team04_FrameManager3();
				window.frame.setVisible(true);
				// 현재 창 닫기
				frame.setVisible(false);
			}
		});
		cancleBtn.setBounds(22, 515, 90, 35);
		frame.getContentPane().add(cancleBtn);

		// JFrame에 홈 버튼 추가 -> 누르면 홈 화면으로 돌아감
		JButton confirmBtn_home = new JButton("홈으로");
		confirmBtn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 홈 화면 띄우기
				DB2022Team04_FrameMain window = new DB2022Team04_FrameMain();
				window.frame.setVisible(true);
				// 현재 창 닫기
				frame.setVisible(false);
			}
		});
		confirmBtn_home.setBounds(120, 515, 90, 35);
		frame.getContentPane().add(confirmBtn_home);
	}
}
