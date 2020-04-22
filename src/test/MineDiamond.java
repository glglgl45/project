package test;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbguide.UserData;
import gui.MainPage;

public class MineDiamond extends JFrame implements ActionListener {

	private JPanel mainPanel, contentPane;
	private Pickax pick;
	private Ore diamond1;
	private Ore diamond2;
	private Ore diamond3;
	private Ore diamond4;
	private Ore diamond5;
	private JButton btnDiamond1;
	private JButton btnDiamond2;
	private JButton btnDiamond3;
	private JButton btnDiamond4;
	private JButton btnDiamond5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MineDiamond frame = new MineDiamond();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MineDiamond() {
		pick = new Pickax();
		pick.infoPick();
		diamond1 = new Diamond();
		diamond2 = new Diamond();
		diamond3 = new Diamond();
		diamond4 = new Diamond();
		diamond5 = new Diamond();

		setBounds(100, 100, 450, 300);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		contentPane = new JPanel();
		mainPanel.add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new GridLayout(2, 3, 0, 0));
		setVisible(true);
		
		JPanel panel_0 = new JPanel();
		mainPanel.add(panel_0, BorderLayout.NORTH);
		panel_0.setLayout(new BorderLayout(0, 0));
		
		JButton btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String option[] = {"메인화면으로","게임 종료"};
				int result=JOptionPane.showOptionDialog(getParent(), "로그아웃 후에 어떻게 할까요?", "Logout", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
				if(result==0) {
					dispose();
					MainPage m = new MainPage();
					m.setVisible(true);
				}else if(result==1) {
					System.exit(0);
				}
			}
		});
		panel_0.add(btnLogout, BorderLayout.EAST);
		
		JButton btnNewButton_2 = new JButton("점수 : 999999");
		panel_0.add(btnNewButton_2, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		mainPanel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("ID : 아이디");
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("소지금 : 9999");
		panel_1.add(lblNewLabel_1, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("돌 곡괭이 +3 내구도 : 100");
		panel_1.add(btnNewButton, BorderLayout.CENTER);
		
		btnDiamond1 = new JButton(diamond1.name+" : "+diamond1.hp);
		contentPane.add(btnDiamond1);
		btnDiamond1.addActionListener(this);
		
		btnDiamond2 = new JButton(diamond2.name+" : "+diamond2.hp);
		contentPane.add(btnDiamond2);
		btnDiamond2.addActionListener(this);
		
		btnDiamond3 = new JButton(diamond3.name+" : "+diamond3.hp);
		contentPane.add(btnDiamond3);
		btnDiamond3.addActionListener(this);
		
		btnDiamond4 = new JButton(diamond4.name+" : "+diamond4.hp);
		contentPane.add(btnDiamond4);
		btnDiamond4.addActionListener(this);
		
		JButton back = new JButton("나가기");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserData ud = new UserData();
			}
		});
		contentPane.add(back);
		
		btnDiamond5 = new JButton(diamond5.name+" : "+diamond5.hp);
		contentPane.add(btnDiamond5);
		btnDiamond5.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnDiamond1) {
			hitdiamond1();
		}
		if (e.getSource()==btnDiamond2) {
			hitdiamond2();
		}
		if (e.getSource()==btnDiamond3) {
			hitdiamond3();
		}
		if (e.getSource()==btnDiamond4) {
			hitdiamond4();
		}
		if (e.getSource()==btnDiamond5) {
			hitdiamond5();
		}
	}
	
	public void hitdiamond1() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + diamond1.hit(pick.atk()));
		btnDiamond1.setText(diamond1.name+" : "+ diamond1.hp);
	}
	public void hitdiamond2() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + diamond2.hit(pick.atk()));
		btnDiamond2.setText(diamond2.name+" : " + diamond2.hp);
	}
	public void hitdiamond3() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + diamond3.hit(pick.atk()));
		btnDiamond3.setText(diamond3.name+" : "+ diamond3.hp);
	}
	public void hitdiamond4() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + diamond4.hit(pick.atk()));
		btnDiamond4.setText(diamond4.name+" : "+ diamond4.hp);
	}
	public void hitdiamond5() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + diamond5.hit(pick.atk()));
		btnDiamond5.setText(diamond5.name+" : "+ diamond5.hp);
	}
}
