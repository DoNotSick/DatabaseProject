package DB2022Team04_Frame;

import javax.swing.JTextField;

import DB2022Team04_Main.DB2022Team04_ManagerMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DB2022Team04_FrameManager3_3 {

	public JFrame frame;

	public DB2022Team04_FrameManager3_3(String[] regional_center_list) {

		// 프레임 셋팅
		frame = new JFrame();
		frame.setBounds(200, 400, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("관리자 메뉴 (3) -  검사소 삭제");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// "삭제할 검사소를 선택하세요" 글
		JLabel lblNewLabel = new JLabel("삭제할  검사소를 선택하세요");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 30, 500, 40);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);

		// "검사소 선택" 콤보 박스
		final JComboBox rcCombo = new JComboBox(regional_center_list);
		rcCombo.setBounds(20, 80, 450, 40);
		frame.getContentPane().add(rcCombo);

		// 삭제 버튼 -> 누르면 삭제할 검사소 이름이 ManagerMenu4_3 매개 인자로 넘어감
		JButton confirmBtn = new JButton("삭제");
		confirmBtn.setBounds(380, 210, 90, 35);
		frame.getContentPane().add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = rcCombo.getSelectedItem().toString();
				DB2022Team04_ManagerMenu MM = new DB2022Team04_ManagerMenu();
				MM.menu3_3(name);

				frame.setVisible(false);
			}
		});

		// JFrame에 이전 버튼 추가 -> 누르면 이전 화면으로 돌아감
		JButton confirmBtn_1 = new JButton("\uC774\uC804");
		confirmBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//이전 화면 띄우기
				DB2022Team04_FrameManager3 window = new DB2022Team04_FrameManager3();
				window.frame.setVisible(true);
				//현재 창 닫기
				frame.setVisible(false);
			}
		});
		confirmBtn_1.setBounds(22, 210, 90, 35);
		frame.getContentPane().add(confirmBtn_1);

		// JFrame에 홈 버튼 추가 -> 누르면 홈 화면으로 돌아감
		JButton confirmBtn_home = new JButton("홈으로");
		confirmBtn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//홈 화면 띄우기
				DB2022Team04_FrameMain window = new DB2022Team04_FrameMain();
				window.frame.setVisible(true);
				//현재 창 닫기
				frame.setVisible(false);
			}
		});
		confirmBtn_home.setBounds(120, 210, 90, 35);
		frame.getContentPane().add(confirmBtn_home);
	}
}
