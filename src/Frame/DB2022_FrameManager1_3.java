package Frame;

import javax.swing.JTextField;

import Main.DB2022_ManagerMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DB2022_FrameManager1_3 {

	public JFrame frame;

	public DB2022_FrameManager1_3(String[] medical_center_list) {

		// 프레임 세팅
		frame = new JFrame();
		frame.setBounds(200, 400, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("관리자 메뉴 (1) - 의료소 삭제");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame에 "삭제할 의료소를 선택하세요" 문자열 표시
		JLabel lblNewLabel = new JLabel("삭제할 의료소를 선택하세요");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 30, 500, 40);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);

		// JFrame에 "의료소 선택" 콤보 박스 생성
		final JComboBox mcCombo = new JComboBox(medical_center_list);
		mcCombo.setBounds(20, 80, 450, 40);
		frame.getContentPane().add(mcCombo);

		// JFrame에 삭제 버튼 추가 -> 누르면 삭제할 의료소 이름이 ManagerMenu1_3 매개 인자로 넘어감
		JButton confirmBtn = new JButton("삭제");
		confirmBtn.setBounds(380, 210, 90, 35);
		frame.getContentPane().add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = mcCombo.getSelectedItem().toString();
				// ManagerMenu의 menu1_3 호출
				DB2022_ManagerMenu MM = new DB2022_ManagerMenu();
				MM.menu1_3(name);
				// 홈 화면으로 돌아감
				DB2022_FrameMain mainWindow = new DB2022_FrameMain();
				mainWindow.frame.setVisible(true);
				// 현재 창 닫기
				frame.setVisible(false);
			}
		});

		// JFrame에 이전 버튼 추가 -> 누르면 이전 화면으로 돌아감
		JButton confirmBtn_1 = new JButton("\uC774\uC804");// "이전"
		confirmBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 이전 화면 띄우기
				DB2022_FrameManager1 window = new DB2022_FrameManager1();
				window.frame.setVisible(true);
				// 현재 창 닫기
				frame.setVisible(false);
			}
		});
		confirmBtn_1.setBounds(22, 210, 90, 35);
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
		confirmBtn_home.setBounds(120, 210, 90, 35);
		frame.getContentPane().add(confirmBtn_home);
	}
}
