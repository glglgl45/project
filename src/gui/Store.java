package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Store extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Store frame = new Store();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Store() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		Image image;
		JButton btnRepair = new JButton(new ImageIcon(getClass().getResource("repair.png")));
		btnRepair.setBorderPainted(false);
		btnRepair.setContentAreaFilled(false);
		btnRepair.setFocusPainted(false);
//		btnRepair.setBounds(220, 150, 220, 150);
//		btnRepair.setIcon(resizeIcon(getClass().getResource("repair.png"), btnRepair.getWidth() - offset, btnRepair.getHeight() - offset));
		panel_1.add(btnRepair);
		
		JButton btnNewButton_1 = new JButton("강화하기");
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnBack = new JButton("돌아가기");
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage m = new MainPage();
			}
		});
		panel_6.add(btnBack);
		
		JButton btnLogout = new JButton("로그아웃");
		panel_6.add(btnLogout);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("검이름(강화수치)");
		panel_5.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("공격력");
		panel_5.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("내구도");
		panel_5.add(lblNewLabel_2);
	}
}
