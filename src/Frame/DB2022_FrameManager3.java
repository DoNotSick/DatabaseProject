package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Main.DB2022_ManagerMenu;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DB2022_FrameManager3 {

	JFrame frame;

	public DB2022_FrameManager3() {

		// 프레임 셋팅
		frame = new JFrame();
		frame.setBounds(200, 400, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("관리자 메뉴 (3) - 검사소 정보 수정");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame에 "수정 작업을 선택하세요" 문자열 표시
		JLabel lblNewLabel = new JLabel("수정 작업을 선택하세요");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(140, 30, 320, 40);
		frame.getContentPane().add(lblNewLabel);

		// JFrame에 "수정 작업" 콤보 박스 생성
		String edit_list[] = { "새로운 검사소 입력", "검사소 정보 수정", "검사소 삭제" };
		final JComboBox editCombo = new JComboBox(edit_list);

		editCombo.setBounds(40, 70, 400, 40);
		frame.getContentPane().add(editCombo);

		// JFrame에 확인 버튼 추가 -> 누르면 해당 메뉴 처리하는 메서드 호출
		JButton confirmBtn = new JButton("확인");
		confirmBtn.setBounds(380, 300, 90, 35);
		frame.getContentPane().add(confirmBtn);

		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB2022_ManagerMenu MM = new DB2022_ManagerMenu();
				String edit = editCombo.getSelectedItem().toString();
				if (edit == "새로운 검사소 입력") { // "세로운 검사소 입력" 옵션 선택시
					MM.activate_menu3_1(); // 해당 메뉴 처리하는 ManagerMenu의 activate_menu3_1() 호출
				} else if (edit == "검사소 정보 수정") { // "검사소 정보 수정" 옵션 선택시
					MM.activate_menu3_2(); // 해당 메뉴 처리하는 ManagerMenu의 activate_menu3_2() 호출
				} else if (edit == "검사소 삭제") {// "검사소 삭제" 옵션 선택시
					MM.activate_menu3_3(); // 해당 메뉴 처리하는 ManagerMenu의 activate_menu3_3() 호출
				}
				frame.setVisible(false);
			}
		});

		// JFrame에 이전 버튼 추가 -> 누르면 이전 화면으로 돌아감
		JButton cancelBtn = new JButton("이전");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 이전 화면 띄우기
				DB2022_FrameManager window = new DB2022_FrameManager();
				window.frame.setVisible(true);
				// 현재 창 닫기
				frame.setVisible(false);
			}
		});
		cancelBtn.setBounds(22, 300, 90, 35);
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
		confirmBtn_home.setBounds(120, 300, 90, 35);
		frame.getContentPane().add(confirmBtn_home);
	}
}
