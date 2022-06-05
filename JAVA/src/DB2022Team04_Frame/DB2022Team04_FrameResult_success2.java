package DB2022Team04_Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DB2022Team04_Main.DB2022Team04_UserMenu;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DB2022Team04_FrameResult_success2 extends DB2022Team04_UserMenu{
	
	public JFrame frame;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	
	public DB2022Team04_FrameResult_success2() {
		
		//프레임 셋팅 
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		//성공했다는 텍스트창
		lblNewLabel_1 = new JLabel("성공! 콘솔창을 확인해주세요.");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(30, 110, 264, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		//이전 버튼 
		btnNewButton_1 = new JButton("\uC774\uC804");
		btnNewButton_1.setBounds(22, 540, 91, 35);
		
		frame.getContentPane().add(btnNewButton_1);
		//누르면 현재 창 사라짐 
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				DB2022Team04_FrameManager window = new DB2022Team04_FrameManager();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		
		//홈으로
		JButton confirmBtn_1_1 = new JButton("홈으로");
		confirmBtn_1_1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            DB2022Team04_FrameMain window = new DB2022Team04_FrameMain();
	            window.frame.setVisible(true);
	            frame.setVisible(false);
	         }
	      });
		confirmBtn_1_1.setBounds(120, 540, 91, 35);
		frame.getContentPane().add(confirmBtn_1_1);
		
	}

}
