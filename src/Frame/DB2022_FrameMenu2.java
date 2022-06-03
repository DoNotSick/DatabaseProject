package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Main.DB2022_UserMenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class DB2022_FrameMenu2 {
	String[] area = { "Seodaemun-gu", "Eunpyeong-gu", "Jungnang-gu", "Mapo-gu", "Nowon-gu", "Gangbuk-gu", "Jung-gu",
			"Gwanak-gu", "Dongdaemun-gu", "Gangseo-gu" };
	String[] disease = { "SARS", "Corona", "Ebola", "Mers" };
	String[] YorN = { "O", "X" };

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblEx;
	DB2022_UserMenu UM = new DB2022_UserMenu();

	public DB2022_FrameMenu2() {
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame에 '이름' 문자열 추가
		JLabel lblNewLabel = new JLabel("\uC774\uB984"); // "이름"
		lblNewLabel.setBounds(170, 107, 50, 15);
		frame.getContentPane().add(lblNewLabel);

		// JFrame에 '나이' 문자열 표시
		JLabel lblNewLabel_1 = new JLabel("\uB098\uC774"); // "나이"
		lblNewLabel_1.setBounds(471, 107, 50, 15);
		frame.getContentPane().add(lblNewLabel_1);

		// JFrame에 이름 입력 칸 생성
		textField = new JTextField();
		textField.setBounds(170, 137, 96, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// JFrame에 나이 입력 칸 생성
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(471, 137, 96, 21);
		frame.getContentPane().add(textField_1);

		// JFrame에 '거주지역' 문자열 표시
		lblNewLabel_2 = new JLabel("\uC0AC\uC6A9\uC790 \uC815\uBCF4 \uC218\uC815");// "거주지역"
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(33, 26, 248, 64);
		frame.getContentPane().add(lblNewLabel_2);

		// JFrame에 '병명' 문자열 표시
		lblNewLabel_1 = new JLabel("\uBCD1\uBA85"); // "병명"
		lblNewLabel_1.setBounds(170, 325, 107, 34);
		frame.getContentPane().add(lblNewLabel_1);

		// JFrame에 '병명' 콤보박스 생성 -> disease에서 리스트 받아옴
		final JComboBox strCombo_1 = new JComboBox(disease);
		strCombo_1.setBounds(170, 365, 96, 21);
		frame.getContentPane().add(strCombo_1);

		// JFrame에 '기저질환여부' 문자열 표시
		lblNewLabel_2 = new JLabel(" \uAE30\uC800\uC9C8\uD658 \uC5EC\uBD80");// "기저질환 여부"
		lblNewLabel_2.setBounds(464, 424, 107, 34);
		frame.getContentPane().add(lblNewLabel_2);

		// JFrame에 '기저질환 여부' 콤보박스 생성
		final JComboBox strCombo_1_1 = new JComboBox(YorN);
		strCombo_1_1.setBounds(474, 468, 96, 21);
		frame.getContentPane().add(strCombo_1_1);

		// JFrame에 '확진날짜' 문자열 표시
		JLabel lblEx_1 = new JLabel("\uD655\uC9C4 \uB0A0\uC9DC");// "확진 날짜"
		lblEx_1.setBounds(159, 424, 107, 34);
		frame.getContentPane().add(lblEx_1);

		// JFrame에 '확진날짜' 입력 칸 생성
		final JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(170, 463, 96, 21);
		frame.getContentPane().add(textField_3);

		// JFrame에 '거주지역' 문자열 표시
		lblNewLabel_3 = new JLabel("\uAC70\uC8FC \uC9C0\uC5ED"); // "거주 지역"
		lblNewLabel_3.setBounds(471, 325, 107, 34);
		frame.getContentPane().add(lblNewLabel_3);

		// JFrame에 '거주지역' 콤보박스 생성 -> area에서 리스트 받아옴
		final JComboBox strCombo = new JComboBox(area);
		strCombo.setBounds(471, 365, 96, 21);
		frame.getContentPane().add(strCombo);

		// JFrame에 '확진 날짜' 예시 표시
		JLabel lblEx_2 = new JLabel("ex> 2022-05-15 \uB85C \uC785\uB825"); // "ex> 2022-05-15 로 입력"
		lblEx_2.setBounds(222, 424, 177, 34);
		frame.getContentPane().add(lblEx_2);

		// JFrame에 확인 버튼 추가 -> 누르면 사용자 정보가 menu2_1로 넘어감
		JButton confirmBtn = new JButton("\uD655\uC778");// "확인"
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 이름 입력
				String name = textField.getText();
				int age_1 = 0;
				try {
					// 나이 입력
					String age = textField_1.getText();
					age_1 = Integer.parseInt(age);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				// 현재 창에서 입력한 정보들 저장
				String disease = strCombo_1.getSelectedItem().toString();
				String area = strCombo.getSelectedItem().toString();
				String date = textField_3.getText();
				String YorN = strCombo_1_1.getSelectedItem().toString();

				UM.menu2_1(name, age_1, disease, area, date, YorN);
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

		// JFrame에 "수정할 내용" 문자열 표시
		lblNewLabel_3 = new JLabel("\uC218\uC815\uD560 \uB0B4\uC6A9");// "수정할 내용"
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(33, 261, 248, 64);
		frame.getContentPane().add(lblNewLabel_3);

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
