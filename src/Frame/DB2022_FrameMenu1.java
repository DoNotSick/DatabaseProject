package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Main.DB2022_UserMenu;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DB2022_FrameMenu1 {

	public JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblEx;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private JLabel lblEx_1;
	private JTextField textField_3;
	private JLabel lblNewLabel_3;
	private JTextField textField_5;
	private JLabel lblExmapogu;
	private JLabel lblNewLabel_4;

	public DB2022_FrameMenu1() {
		// 콤보박스에서 사용할 스트링 배열 생성
		String[] area = { "Seodaemun-gu", "Eunpyeong-gu", "Jungnang-gu", "Mapo-gu", "Nowon-gu", "Gangbuk-gu", "Jung-gu",
				"Gwanak-gu", "Dongdaemun-gu", "Gangseo-gu" };
		String[] disease = { "SARS", "Corona", "Ebola", "Mers" };
		String[] YorN = { "O", "X" };

		// 프레임 셋팅
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame에 '사용자 정보 입력' 문자열 표시
		lblNewLabel_4 = new JLabel("\uD658\uC790 \uC815\uBCF4\uC785\uB825");// "사용자 정보 입력"
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(30, 10, 264, 34);
		frame.getContentPane().add(lblNewLabel_4);

		// JFrame에 '이름' 문자열 추가
		JLabel lblNewLabel = new JLabel("\uC774\uB984");// "이름"
		lblNewLabel.setBounds(136, 76, 107, 34);
		frame.getContentPane().add(lblNewLabel);

		// JFrame에 '이름' 입력 칸 생성
		textField = new JTextField();
		textField.setBounds(198, 83, 96, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// JFrame에 '병명' 문자열 표시
		lblNewLabel_1 = new JLabel("\uBCD1\uBA85");// "병명"
		lblNewLabel_1.setBounds(418, 76, 107, 34);
		frame.getContentPane().add(lblNewLabel_1);

		// JFrame에 '병명' 콤보박스 생성 -> disease에서 리스트 받아옴
		final JComboBox strCombo_1 = new JComboBox(disease);
		strCombo_1.setBounds(475, 82, 120, 21);
		frame.getContentPane().add(strCombo_1);

		// JFrame에 '나이' 문자열 표시
		lblEx = new JLabel("\uB098\uC774");
		lblEx.setBounds(136, 212, 107, 34);
		frame.getContentPane().add(lblEx);

		// JFrame에 '나이' 입력 칸 생성
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(198, 219, 96, 21);
		frame.getContentPane().add(textField_2);

		// JFrame에 '기저질환 여부' 문자열 표시
		lblNewLabel_2 = new JLabel(" \uAE30\uC800\uC9C8\uD658 \uC5EC\uBD80");// "기저질환 여부"
		lblNewLabel_2.setBounds(379, 212, 107, 34);
		frame.getContentPane().add(lblNewLabel_2);

		// JFrame에 '기저질환 여부' 콤보박스 생성
		final JComboBox strCombo_1_1 = new JComboBox(YorN); // YorN에서 리스트 받아옴
		strCombo_1_1.setBounds(475, 218, 120, 21);
		frame.getContentPane().add(strCombo_1_1);

		// JFrame에 '확진날짜' 문자열 표시
		lblEx_1 = new JLabel("\uD655\uC9C4 \uB0A0\uC9DC");// "확진 날짜"
		lblEx_1.setBounds(124, 332, 107, 34);
		frame.getContentPane().add(lblEx_1);

		// JFrame에 '확진날짜' 입력 칸 생성
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(198, 339, 96, 21);
		frame.getContentPane().add(textField_3);

		// JFrame에 '거주지역' 문자열 표시
		lblNewLabel_3 = new JLabel("\uAC70\uC8FC \uC9C0\uC5ED"); // "거주 지역"
		lblNewLabel_3.setBounds(390, 332, 107, 34);
		frame.getContentPane().add(lblNewLabel_3);

		// JFrame에 '거주지역' 콤보박스 생성 - area에서 리스트 받아옴
		final JComboBox strCombo = new JComboBox(area);
		strCombo.setBounds(475, 339, 120, 21);
		frame.getContentPane().add(strCombo);

		// JFrame에 '확진 날짜' 예시 표시 - 사용자 편의를 위해 추가
		JLabel lblEx_2 = new JLabel("ex> 2022-05-15 \uB85C \uC785\uB825");// "ex> 2022-05-15 로 입력"
		lblEx_2.setBounds(124, 358, 177, 34);
		frame.getContentPane().add(lblEx_2);

		// JFrame에 확인 버튼 추가 -> 누르면 사용자 정보가 menu1_1으로 넘어감
		btnNewButton = new JButton("\uD655\uC778"); // "확인"
		btnNewButton.setBounds(617, 524, 145, 45);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {// 클릭 이벤트 발생 시
			public void actionPerformed(ActionEvent e) {

				DB2022_UserMenu userMenu = new DB2022_UserMenu();
				// 현재 창에서 입력한 정보들 저장
				userMenu.UserName = textField.getText();
				userMenu.UserName = textField.getText();
				userMenu.UserDisease = strCombo_1.getSelectedItem().toString();
				userMenu.UserAge = textField_2.getText();
				userMenu.UserDiseaseOX = strCombo_1_1.getSelectedItem().toString();
				userMenu.UserInfectDate = textField_3.getText();
				userMenu.UserLocation = strCombo.getSelectedItem().toString();
				frame.setVisible(false);

				// UserMenu의 menu1_1() 메소드로 넘김
				userMenu.menu1_1();
			}
		});

		// JFrame에 이전 버튼 추가 -> 누르면 이전 화면으로 돌아감
		btnNewButton_1 = new JButton("\uC774\uC804"); // "이전"
		btnNewButton_1.setBounds(22, 540, 91, 35);
		frame.getContentPane().add(btnNewButton_1);

		// 이전 버튼 누르면 사용자 메뉴 화면으로 이동
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 이전 화면 띄우기
				DB2022_FrameUser window = new DB2022_FrameUser();
				window.frame.setVisible(true);
				// 현재 창 닫기
				frame.setVisible(false);

			}
		});

		// JFrame에 홈 버튼 추가 -> 누르면 홈 화면으로 돌아감
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