package Frame;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrameUserInfo {

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

	public FrameUserInfo() {
		// 콤보박스에서 사용할 스트링 배열
		String[] area = { "Seodaemun-gu", "Eunpyeong-gu", "Jungnang-gu", "Mapo-gu", "Nowon-gu", "Gangbuk-gu", "Jung-gu",
				"Gwanak-gu", "Dongdaemun-gu", "Gangseo-gu" };
		String[] disease = { "SARS", "Corona", "Ebola" };
		String[] YorN = { "O", "X" };

		// 프레임 셋팅
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// '사용자 정보 입력' 글
		lblNewLabel_4 = new JLabel("\uC0AC\uC6A9\uC790 \uC815\uBCF4\uC785\uB825");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(30, 10, 264, 34);
		frame.getContentPane().add(lblNewLabel_4);

		// '이름' 글
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(136, 76, 107, 34);
		frame.getContentPane().add(lblNewLabel);

		// '이름' 입력 칸
		textField = new JTextField();
		textField.setBounds(198, 83, 96, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// '병명' 글
		lblNewLabel_1 = new JLabel("\uBCD1\uBA85");
		lblNewLabel_1.setBounds(418, 76, 107, 34);
		frame.getContentPane().add(lblNewLabel_1);

		// '병명' 콤보박스
		final JComboBox strCombo_1 = new JComboBox(disease);
		strCombo_1.setBounds(475, 82, 96, 21);
		frame.getContentPane().add(strCombo_1);

		// '나이' 글
		lblEx = new JLabel("\uB098\uC774");
		lblEx.setBounds(136, 212, 107, 34);
		frame.getContentPane().add(lblEx);

		// '나이' 입력 칸
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(198, 219, 96, 21);
		frame.getContentPane().add(textField_2);

		// '기저질환여부' 글
		lblNewLabel_2 = new JLabel(" \uAE30\uC800\uC9C8\uD658 \uC5EC\uBD80");
		lblNewLabel_2.setBounds(379, 212, 107, 34);
		frame.getContentPane().add(lblNewLabel_2);

		// '기저질환 여부' 콤보박스
		final JComboBox strCombo_1_1 = new JComboBox(YorN);
		strCombo_1_1.setBounds(475, 218, 96, 21);
		frame.getContentPane().add(strCombo_1_1);

		
		// '확진날짜' 글
		lblEx_1 = new JLabel("\uD655\uC9C4 \uB0A0\uC9DC");
		lblEx_1.setBounds(124, 332, 107, 34);
		frame.getContentPane().add(lblEx_1);

		// '확진날짜' 입력 칸
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(198, 339, 96, 21);
		frame.getContentPane().add(textField_3);

		// '거주지역' 글
		lblNewLabel_3 = new JLabel("\uAC70\uC8FC \uC9C0\uC5ED");
		lblNewLabel_3.setBounds(390, 332, 107, 34);
		frame.getContentPane().add(lblNewLabel_3);

		// '거주지역' 콤보박스
		final JComboBox strCombo = new JComboBox(area);
		strCombo.setBounds(475, 339, 96, 21);
		frame.getContentPane().add(strCombo);

		// '확진 날짜' 예시
		JLabel lblEx_2 = new JLabel("ex> 2022-05-15 \uB85C \uC785\uB825");
		lblEx_2.setBounds(124, 358, 177, 34);
		frame.getContentPane().add(lblEx_2);

		// 이전 버튼
				btnNewButton_1 = new JButton("\uC774\uC804");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FrameUser window = new FrameUser();
						window.frame.setVisible(true);
						frame.setVisible(false);

					}
				});

				// 확인 버튼
				btnNewButton = new JButton("\uD655\uC778");
				btnNewButton.setBounds(617, 524, 145, 45);
				frame.getContentPane().add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name = textField.getText();
						System.out.println(name);
						System.out.println(strCombo.getSelectedItem().toString());
						
					}
				});

				btnNewButton_1.setBounds(30, 524, 145, 45);
				frame.getContentPane().add(btnNewButton_1);

		
	}
}
