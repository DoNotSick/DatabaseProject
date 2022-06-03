package Frame;

import javax.swing.JTextField;

import Main.DB2022_ManagerMenu;
import Main.DB2022_UserMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DB2022_FrameManager3_1 {

	public JFrame frame;
	private JTextField textField_name;
	private JTextField textField_tel;
	private JTextField textField_open;
	private JTextField textField_close;

	public DB2022_FrameManager3_1(String[] area_list) {

		// 프레임 셋팅
		frame = new JFrame();
		frame.setBounds(200, 350, 500, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("관리자 메뉴 (3) - 새로운 검사소 입력");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// 검사소 = (검사소 이름, 위치, 연락처, 시작 시각, 마감 시각)
		// JFrame에 "검사소 이름" 문자열 표시
		JLabel lblNewLabel_name = new JLabel("검사소 이름");
		lblNewLabel_name.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_name.setBackground(Color.WHITE);
		lblNewLabel_name.setBounds(0, 20, 500, 40);
		lblNewLabel_name.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_name);

		// JFrame에 "위치" 문자열 표시
		JLabel lblNewLabel_area = new JLabel("위치");
		lblNewLabel_area.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_area.setBackground(Color.WHITE);
		lblNewLabel_area.setBounds(0, 120, 500, 40);
		lblNewLabel_area.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_area);

		// JFrame에 "연락처" 문자열 표시
		JLabel lblNewLabel_tel = new JLabel("연락처");
		lblNewLabel_tel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_tel.setBackground(Color.WHITE);
		lblNewLabel_tel.setBounds(0, 220, 500, 40);
		lblNewLabel_tel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_tel);

		// JFrame에 "운영 시작 시각" 문자열 표시
		JLabel lblNewLabel_open = new JLabel("운영 시작 시각");
		lblNewLabel_open.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_open.setBackground(Color.WHITE);
		lblNewLabel_open.setBounds(60, 320, 190, 40);
		frame.getContentPane().add(lblNewLabel_open);

		// JFrame에 "운영 마감 시각" 문자열 표시
		JLabel lblNewLabel_close = new JLabel("운영 마감 시각");
		lblNewLabel_close.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_close.setBackground(Color.WHITE);
		lblNewLabel_close.setBounds(300, 320, 190, 40);
		frame.getContentPane().add(lblNewLabel_close);

		// JFrame에 의료소 이름 입력 칸 생성
		textField_name = new JTextField();
		textField_name.setBounds(20, 60, 450, 40);
		textField_name.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_name);

		// JFrame에 위치 입력 콤보박스 생성 - area_list에서 리스트 받아옴
		final JComboBox areaCombo = new JComboBox(area_list);
		areaCombo.setBounds(20, 160, 450, 40);
		frame.getContentPane().add(areaCombo);

		// JFrame에 연락처 입력 칸 생성
		textField_tel = new JTextField();
		textField_tel.setBounds(20, 260, 450, 40);
		textField_tel.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_tel);

		// JFrame에 운영 시작 시각 입력 칸 생성
		textField_open = new JTextField();
		textField_open.setBounds(20, 360, 210, 40);
		textField_open.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_open);

		// JFrame에 운영 마감 시각 입력 칸 생성
		textField_close = new JTextField();
		textField_close.setBounds(260, 360, 210, 40);
		textField_close.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_close);

		// JFrame에 입력 버튼 추가 -> 누르면 사용자가 정보가 ManagerMenu1_1 매개 인자로 넘어감
		JButton confirmBtn = new JButton("입력");
		confirmBtn.setBounds(388, 420, 90, 40);
		frame.getContentPane().add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 매개변수들
				String name = textField_name.getText();
				String area = areaCombo.getSelectedItem().toString();
				String tel = textField_tel.getText();
				String open = textField_open.getText();
				String close = textField_close.getText();

				// 해당 메뉴를 처리하는 ManagerMenu의 menu3_1 메서드 호출
				DB2022_ManagerMenu MM = new DB2022_ManagerMenu();
				MM.menu3_1(name, area, tel, open, close);

				// 홈 화면으로 돌아감
				DB2022_FrameMain mainWindow = new DB2022_FrameMain();
				mainWindow.frame.setVisible(true);

				// 현재 창 닫기
				frame.setVisible(false);
			}
		});

		// JFrame에 이전 버튼 추가 -> 누르면 이전 화면으로 돌아감
		JButton cancelBtn = new JButton("이전");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 이전 화면 띄우기
				DB2022_FrameManager3 window = new DB2022_FrameManager3();
				window.frame.setVisible(true);
				// 현재 창 닫기
				frame.setVisible(false);
			}
		});
		cancelBtn.setBounds(22, 420, 90, 40);
		frame.getContentPane().add(cancelBtn);

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
		confirmBtn_home.setBounds(120, 420, 90, 35);
		frame.getContentPane().add(confirmBtn_home);
	}
}
