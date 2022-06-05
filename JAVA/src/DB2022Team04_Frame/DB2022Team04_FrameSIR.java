package DB2022Team04_Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DB2022Team04_Main.DB2022Team04_ManagerMenu;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DB2022Team04_FrameSIR {

	public JFrame frame;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	public DB2022Team04_FrameSIR() {
		// 콤보 박스에서 사용할 스트링 배열 생성
		String[] area = { "Seodaemun-gu", "Eunpyeong-gu", "Jungnang-gu", "Mapo-gu", "Nowon-gu", "Gangbuk-gu", "Jung-gu",
				"Gwanak-gu", "Dongdaemun-gu", "Gangseo-gu" };
		String[] disease = { "SARS", "Corona", "Ebola", "Mers" };

		final int people_Eunpyeong = 36, people_Jungnang = 64, people_Mapo = 72, people_Nowon = 25,
				people_Seodaemun = 52;
		final int people_Gangbuk = 27, people_Jung = 15, people_Gwanak = 17, people_Dongdaemun = 32,
				people_Gangseo = 51;

		// 프레임 세팅
		frame = new JFrame();
		// frame.setBounds(100, 100, 835, 644);
		frame.setBounds(200, 400, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("관리자 메뉴 (4) - 전염병 모델 예측");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame에 '정보 입력' 문자열 표시
		lblNewLabel_4 = new JLabel("\uC815\uBCF4\uC785\uB825"); //"정보 입력"
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(30, 10, 264, 34);
		frame.getContentPane().add(lblNewLabel_4);

		//JFrame에 '병명' 문자열 표시
		lblNewLabel_1 = new JLabel("\uBCD1\uBA85"); //"병명"
		lblNewLabel_1.setBounds(40, 50, 400, 40);
		frame.getContentPane().add(lblNewLabel_1);

		// JFrame에 '병명' 콤보박스 생성 - disease에서 리스트 받아옴
		final JComboBox strCombo_1 = new JComboBox(disease); 
		// strCombo_1.setBounds(475, 82, 120, 21);
		strCombo_1.setBounds(40, 80, 400, 40);
		frame.getContentPane().add(strCombo_1);

		// JFrame에 '거주지역' 문자열 표시
		lblNewLabel_3 = new JLabel("\uAC70\uC8FC \uC9C0\uC5ED");//"거주 지역"
		lblNewLabel_3.setBounds(40, 120, 400, 40);
		frame.getContentPane().add(lblNewLabel_3);

		// JFrame에 '병명' 콤보박스 추가 - area에서 리스트 받아옴
		final JComboBox strCombo = new JComboBox(area);
		// strCombo.setBounds(475, 339, 120, 21);
		strCombo.setBounds(40, 150, 400, 40);
		frame.getContentPane().add(strCombo);

		// JFrame에 확인 버튼 추가 -> 누르면 전염병 모델 예측을 수행한다.
		btnNewButton = new JButton("\uD655\uC778"); //"확인"
		// btnNewButton.setBounds(617, 524, 145, 45);
		btnNewButton.setBounds(380, 300, 90, 35);
		frame.getContentPane().add(btnNewButton);

		// 확인 버튼 누르면
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DB2022Team04_ManagerMenu ManagerMenu = new DB2022Team04_ManagerMenu();

				// 입력한 정보 저장
				ManagerMenu.UserDisease = strCombo_1.getSelectedItem().toString();
				ManagerMenu.UserLocation = strCombo.getSelectedItem().toString();
				
				//입력한 정보에 따라 check_people값 설정
				if (strCombo.getSelectedItem().toString() == "Seodaemun-gu") {
					ManagerMenu.check_people = people_Seodaemun;
				}

				else if (strCombo.getSelectedItem().toString() == "Eunpyeong-gu") {
					ManagerMenu.check_people = people_Eunpyeong;
				}

				else if (strCombo.getSelectedItem().toString() == "Jungnang-gu") {
					ManagerMenu.check_people = people_Jungnang;
				}

				else if (strCombo.getSelectedItem().toString() == "Mapo-gu") {
					ManagerMenu.check_people = people_Mapo;
				}

				else if (strCombo.getSelectedItem().toString() == "Nowon-gu") {
					ManagerMenu.check_people = people_Nowon;
				}

				else if (strCombo.getSelectedItem().toString() == "Gangbuk-gu") {
					ManagerMenu.check_people = people_Gangbuk;
				}

				else if (strCombo.getSelectedItem().toString() == "Jung-gu") {
					ManagerMenu.check_people = people_Jung;
				}

				else if (strCombo.getSelectedItem().toString() == "Gwanak-gu") {
					ManagerMenu.check_people = people_Gwanak;
				}

				else if (strCombo.getSelectedItem().toString() == "Dongdaemun-gu") {
					ManagerMenu.check_people = people_Dongdaemun;
				}

				else {
					ManagerMenu.check_people = people_Gangseo;
				}

				
				//기존 창 닫기
				frame.setVisible(false);

				// ManagerMenu의 menu8_1() 메서드 호출
				ManagerMenu.menu8_1();
			}
			
		});

		// JFrame에 이전 버튼 추가 -> 누르면 이전 화면으로 이동
		btnNewButton_1 = new JButton("\uC774\uC804"); //'이전'
		// btnNewButton_1.setBounds(30, 524, 145, 45);
		btnNewButton_1.setBounds(22, 300, 90, 35);
		frame.getContentPane().add(btnNewButton_1);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//관리자 메뉴 확면 띄우기
				DB2022Team04_FrameManager window = new DB2022Team04_FrameManager();
				window.frame.setVisible(true);
				//기존 창 닫기
				frame.setVisible(false);

			}
		});

		// JFrame에 홈 버튼 추가 -> 누르면 홈 화면으로 이동
		JButton confirmBtn_home = new JButton("홈으로");
		confirmBtn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//홈 화면 띄우기
				DB2022Team04_FrameMain window = new DB2022Team04_FrameMain();
				window.frame.setVisible(true);
				//기존 창 닫기
				frame.setVisible(false);
			}
		});
		confirmBtn_home.setBounds(120, 300, 90, 35);
		frame.getContentPane().add(confirmBtn_home);

	}
}