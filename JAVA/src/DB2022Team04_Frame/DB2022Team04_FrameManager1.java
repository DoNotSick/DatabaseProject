package DB2022Team04_Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import DB2022Team04_Main.DB2022Team04_ManagerMenu;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DB2022Team04_FrameManager1 {

	JFrame frame;

	public DB2022Team04_FrameManager1() {

		// 프레임 세팅
		frame = new JFrame();
		frame.setBounds(200, 400, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("관리자 메뉴 (1) - 의료소 정보 수정");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// JFrame에 "수정 작업을 선택하세요" 문자열 표시
		JLabel lblNewLabel = new JLabel("수정 작업을 선택하세요");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(140, 30, 320, 40);
		frame.getContentPane().add(lblNewLabel);

		// JFrame에 "수정 작업" 콤보 박스 생성 - "새로운 의료소 입력", "의료소 정보 수정", "의료소 삭제" 중 선택
		String edit_list[] = { "새로운 의료소 입력", "의료소 정보 수정", "의료소 삭제" };
		final JComboBox editCombo = new JComboBox(edit_list);

		editCombo.setBounds(40, 70, 400, 40);
		frame.getContentPane().add(editCombo);

		// JFrame에 확인 버튼 추가 -> 옵션 선택하면 해당 메뉴 처리하는 메서드 호출
		JButton confirmBtn = new JButton("확인");
		confirmBtn.setBounds(380, 300, 90, 35);
		frame.getContentPane().add(confirmBtn);

		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB2022Team04_ManagerMenu MM = new DB2022Team04_ManagerMenu();
				String edit = editCombo.getSelectedItem().toString();
				if (edit == "새로운 의료소 입력") { // 첫 번째 옵션 선택한 경우
					MM.activate_menu1_1(); // 해당 메뉴를 처리하는 activate_menu1_1() 호출
				} else if (edit == "의료소 정보 수정") { // 두 번째 옵션 선택한 경우
					MM.activate_menu1_2(); // 해당 메뉴를 처리하는 activate_menu1_2() 호출
				} else if (edit == "의료소 삭제") { // 세 번째 옵션 선택한 경우
					MM.activate_menu1_3(); // 해당 메뉴를 처리하는 activate_menu1_3() 호출
				}
				frame.setVisible(false);
			}
		});

		// JFrame에 이전 버튼 추가 -> 누르면 이전 화면으로 돌아감
		JButton cancelBtn = new JButton("이전");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 이전 화면 띄우기
				DB2022Team04_FrameManager window = new DB2022Team04_FrameManager();
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
				DB2022Team04_FrameMain window = new DB2022Team04_FrameMain();
				window.frame.setVisible(true);
				// 현재 창 닫기
				frame.setVisible(false);
			}
		});
		confirmBtn_home.setBounds(120, 300, 90, 35);
		frame.getContentPane().add(confirmBtn_home);
	}
}
