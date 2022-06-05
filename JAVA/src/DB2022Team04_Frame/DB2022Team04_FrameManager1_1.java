package DB2022Team04_Frame;

import javax.swing.JTextField;

import DB2022Team04_Main.DB2022Team04_ManagerMenu;
import DB2022Team04_Main.DB2022Team04_UserMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DB2022Team04_FrameManager1_1 {

	public JFrame frame;
	private JTextField textField_name;
	private JTextField textField_tel;
	private JTextField textField_open;
	private JTextField textField_close;
	private JTextField textField_wait;

	public DB2022Team04_FrameManager1_1(String[] area_list) {

		// 프레임 셋팅
		frame = new JFrame();
		frame.setBounds(200, 350, 500, 715);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("관리자 메뉴 (1) - 새로운 의료소 입력");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// 의료소 = (의료소 이름, 의료기관 종류, 위치, 연락처, 시작 시각, 마감 시각, 대기 인원)
		// JFrame에 "의료소 이름" 문자열 표시
		JLabel lblNewLabel_name = new JLabel("의료소 이름");
		lblNewLabel_name.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_name.setBackground(Color.WHITE);
		lblNewLabel_name.setBounds(0, 20, 500, 40);
		lblNewLabel_name.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_name);

		// JFrame에 "의료기관 종류" 문자열 표시
		JLabel lblNewLabel_type = new JLabel("의료기관 종류");
		lblNewLabel_type.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_type.setBackground(Color.WHITE);
		lblNewLabel_type.setBounds(0, 120, 500, 40);
		lblNewLabel_type.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_type);

		// JFrame에 "위치" 문자열 표시
		JLabel lblNewLabel_area = new JLabel("위치");
		lblNewLabel_area.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_area.setBackground(Color.WHITE);
		lblNewLabel_area.setBounds(0, 220, 500, 40);
		lblNewLabel_area.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_area);

		// JFrame에 "연락처" 문자열 표시
		JLabel lblNewLabel_tel = new JLabel("연락처");
		lblNewLabel_tel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_tel.setBackground(Color.WHITE);
		lblNewLabel_tel.setBounds(0, 320, 500, 40);
		lblNewLabel_tel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_tel);

		// JFrame에 "운영 시작 시각(tt:mm:ss)" 문자열 표시
		JLabel lblNewLabel_open = new JLabel(" 운영 시작 시각(tt:mm:ss)");
		lblNewLabel_open.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_open.setBackground(Color.WHITE);
		lblNewLabel_open.setBounds(20, 420, 210, 40);
		frame.getContentPane().add(lblNewLabel_open);

		// JFrame에 "운영 마감 시각(tt:mm:ss)" 문자열 표시
		JLabel lblNewLabel_close = new JLabel(" 운영 마감 시각(tt:mm:ss)");
		lblNewLabel_close.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_close.setBackground(Color.WHITE);
		lblNewLabel_close.setBounds(260, 420, 210, 40);
		frame.getContentPane().add(lblNewLabel_close);

		// JFrame에 "대기인원" 문자열 표시
		JLabel lblNewLabel_wait = new JLabel("대기 인원");
		lblNewLabel_wait.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_wait.setBackground(Color.WHITE);
		lblNewLabel_wait.setBounds(0, 520, 500, 40);
		lblNewLabel_wait.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_wait);

		// JFrame에 의료소 이름 입력 칸 생성
		textField_name = new JTextField();
		textField_name.setBounds(20, 60, 450, 40);
		textField_name.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_name);

		// JFrame에 의료기관 종류 입력 콤보박스 생성 - "hospital", "clinic" 중 선택
		String[] type_list = { "", "hospital", "clinic" };
		final JComboBox typeCombo = new JComboBox(type_list);
		typeCombo.setBounds(20, 160, 450, 40);
		frame.getContentPane().add(typeCombo);

		// JFrame에 위치 입력 콤보박스 생성 - area_list에서 리스트 받아옴
		final JComboBox areaCombo = new JComboBox(area_list);
		areaCombo.setBounds(20, 260, 450, 40);
		frame.getContentPane().add(areaCombo);

		// JFrame에 연락처 입력 칸 생성
		textField_tel = new JTextField();
		textField_tel.setBounds(20, 360, 450, 40);
		textField_tel.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_tel);

		// JFrame에 운영 시작 시각 입력 칸 생성
		textField_open = new JTextField();
		textField_open.setBounds(20, 460, 210, 40);
		textField_open.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_open);

		// JFrame에 운영 마감 시각 입력 칸 생성
		textField_close = new JTextField();
		textField_close.setBounds(260, 460, 210, 40);
		textField_close.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_close);

		// JFrame에 대기 인원 입력 칸 생성
		textField_wait = new JTextField();
		textField_wait.setBounds(20, 560, 450, 40);
		textField_wait.setHorizontalAlignment(JTextField.CENTER);
		frame.getContentPane().add(textField_wait);

		// JFrame에 입력 버튼 추가 -> 누르면 사용자 정보가 ManagerMenu1_1 매개 인자로 넘어감
		JButton confirmBtn = new JButton("입력");
		confirmBtn.setBounds(388, 620, 90, 40);
		frame.getContentPane().add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 매개 인자들
				String name = textField_name.getText();
				String type = typeCombo.getSelectedItem().toString();
				String area = areaCombo.getSelectedItem().toString();
				String tel = textField_tel.getText();
				String open = textField_open.getText();
				String close = textField_close.getText();
				int wait = Integer.parseInt(textField_wait.getText());

				// ManagerMenu의 menu1_1 호출
				DB2022Team04_ManagerMenu MM = new DB2022Team04_ManagerMenu();
				MM.menu1_1(name, type, area, tel, open, close, wait);
				

				frame.setVisible(false);
			}
		});

		// JFrame에 이전 버튼 추가 -> 누르면 이전 화면으로 돌아감
		JButton cancelBtn = new JButton("이전");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 이전 화면 띄우기
				DB2022Team04_FrameManager1 window = new DB2022Team04_FrameManager1();
				window.frame.setVisible(true);
				// 현재 창 닫기
				frame.setVisible(false);
			}
		});
		cancelBtn.setBounds(22, 620, 90, 40);
		frame.getContentPane().add(cancelBtn);

		// JFrame에 홈 버튼 추가 -> 누르면 홈 화면으로 돌아감
		JButton confirmBtn_home = new JButton("홈으로");
		confirmBtn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 홈 화면 뜨우기
				DB2022Team04_FrameMain window = new DB2022Team04_FrameMain();
				window.frame.setVisible(true);
				// 현재 창 닫기
				frame.setVisible(false);
			}
		});
		confirmBtn_home.setBounds(120, 620, 91, 40);
		frame.getContentPane().add(confirmBtn_home);
	}
}
