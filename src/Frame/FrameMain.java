package Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;

public class FrameMain {

	public JFrame frame;
	
	public FrameMain() {
		//프레임 셋팅
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		
		// '전염병 관리 시스템' 글
		JLabel lblNewLabel = new JLabel("전염병관리시스템");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(317, 67, 167, 33);
		frame.getContentPane().add(lblNewLabel);
		
		
		//'관리자 모드 ' 버튼  -> Frame Manager 로 넘어감 
		JButton btnNewButton = new JButton("\uAD00\uB9AC\uC790 \uBAA8\uB4DC");
		btnNewButton.setBounds(280, 179, 235, 102);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				FrameManager window = new FrameManager();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		
		// '사용자 모드' 버튼 -> Frame User로 넘어감 
		JButton btnNewButton_1 = new JButton("\uC0AC\uC6A9\uC790 \uBAA8\uB4DC");
		btnNewButton_1.setBounds(280, 321, 235, 102);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				FrameUser window = new FrameUser();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
	}
	
	

}
