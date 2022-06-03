//package Frame;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//
//import Main.ManagerMenu;
//
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.Font;
//
//public class FrameSIR {
//
//	public JFrame frame;
//	private JLabel lblNewLabel_1;
//	private JButton btnNewButton;
//	private JButton btnNewButton_1;
//	private JLabel lblNewLabel_3;
//	private JLabel lblNewLabel_4;
//	
//	public FrameSIR() {
//		// 콤보박스에서 사용할 스트링 배열
//		String[] area = { "Seodaemun-gu", "Eunpyeong-gu", "Jungnang-gu", "Mapo-gu", "Nowon-gu", "Gangbuk-gu", "Jung-gu",
//				"Gwanak-gu", "Dongdaemun-gu", "Gangseo-gu" };
//		String[] disease = { "SARS", "Corona", "Ebola", "Mers" };
//		
//		final int people_Eunpyeong=36, people_Jungnang=64, people_Mapo=72, people_Nowon=25, people_Seodaemun=52;
//		final int people_Gangbuk=27, people_Jung=15, people_Gwanak=17, people_Dongdaemun=32, people_Gangseo=51;
//
//		// 프레임 셋팅
//		frame = new JFrame();
//		frame.setBounds(100, 100, 835, 644);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLocationRelativeTo(null);
//		frame.getContentPane().setLayout(null);
//
//		// '사용자 정보 입력' 글
//		lblNewLabel_4 = new JLabel("\uC0AC\uC6A9\uC790 \uC815\uBCF4\uC785\uB825");
//		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 20));
//		lblNewLabel_4.setBounds(30, 10, 264, 34);
//		frame.getContentPane().add(lblNewLabel_4);
//		
//		
//
//		// '병명' 글
//		lblNewLabel_1 = new JLabel("\uBCD1\uBA85");
//		lblNewLabel_1.setBounds(418, 76, 107, 34);
//		frame.getContentPane().add(lblNewLabel_1);
//
//		// '병명' 콤보박스
//		final JComboBox strCombo_1 = new JComboBox(disease);
//		strCombo_1.setBounds(475, 82, 120, 21);
//		frame.getContentPane().add(strCombo_1);
//		
//
//		// '거주지역' 글
//		lblNewLabel_3 = new JLabel("\uAC70\uC8FC \uC9C0\uC5ED");
//		lblNewLabel_3.setBounds(390, 332, 107, 34);
//		frame.getContentPane().add(lblNewLabel_3);
//
//		// '거주지역' 콤보박스
//		final JComboBox strCombo = new JComboBox(area);
//		strCombo.setBounds(475, 339, 120, 21);
//		frame.getContentPane().add(strCombo);
//		
//		
//		// 이전 버튼
//		btnNewButton_1 = new JButton("\uC774\uC804");
//		btnNewButton_1.setBounds(30, 524, 145, 45);
//		frame.getContentPane().add(btnNewButton_1);
//
//		//이전 버튼 누르면 관리자 메뉴 화면으로 이동
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				FrameManager window = new FrameManager();
//				window.frame.setVisible(true);
//				frame.setVisible(false);
//
//			}
//		});
//
//		//확인 버튼
//		btnNewButton = new JButton("\uD655\uC778");
//		btnNewButton.setBounds(617, 524, 145, 45);
//		frame.getContentPane().add(btnNewButton);
//		
//		//확인 버튼 누르면
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//						
//				ManagerMenu ManagerMenu = new ManagerMenu();
//				
//				//현재 창에서 입력한 정보를 모두 저장해서
//				ManagerMenu.UserDisease = strCombo_1.getSelectedItem().toString();
//				ManagerMenu.UserLocation = strCombo.getSelectedItem().toString();
//				
//				//userMenu.check_people = Integer.parseInt("people_" + strCombo.getSelectedItem().toString().replace("-gu",""));
//				
//				if (strCombo.getSelectedItem().toString() == "Seodaemun-gu") {
//					ManagerMenu.check_people = people_Seodaemun;
//				}
//				
//				else if (strCombo.getSelectedItem().toString() == "Eunpyeong-gu") {
//					ManagerMenu.check_people = people_Eunpyeong;
//				}
//				
//				else if (strCombo.getSelectedItem().toString() == "Jungnang-gu") {
//					ManagerMenu.check_people = people_Jungnang;
//				}
//				
//				else if (strCombo.getSelectedItem().toString() == "Mapo-gu") {
//					ManagerMenu.check_people = people_Mapo;
//				}
//				
//				else if (strCombo.getSelectedItem().toString() == "Nowon-gu") {
//					ManagerMenu.check_people = people_Nowon;
//				}
//				
//				else if (strCombo.getSelectedItem().toString() == "Gangbuk-gu") {
//					ManagerMenu.check_people = people_Gangbuk;
//				}
//				
//				else if (strCombo.getSelectedItem().toString() == "Jung-gu") {
//					ManagerMenu.check_people = people_Jung;
//				}
//				
//				else if (strCombo.getSelectedItem().toString() == "Gwanak-gu") {
//					ManagerMenu.check_people = people_Gwanak;
//				}
//				
//				else if (strCombo.getSelectedItem().toString() == "Dongdaemun-gu") {
//					ManagerMenu.check_people = people_Dongdaemun;
//				}
//				
//				else {
//					ManagerMenu.check_people = people_Gangseo;
//				}
//		
//				//관리자 메뉴 화면으로 돌아감
//				FrameManager window = new FrameManager();
//				window.frame.setVisible(true);
//				frame.setVisible(false);
//				
//				//ManagerMenu의 menu8_1() 메소드로 넘김
//				ManagerMenu.menu8_1();
//			}
//		});
//		
//	}
//}