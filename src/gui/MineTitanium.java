package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ore.*;
import system.*;

import javax.swing.JButton;

public class MineTitanium extends JFrame implements ActionListener {

	private JPanel mainPanel, contentPane;
	private Pickax pick;
	private Ore titanium1;
	private Ore titanium2;
	private Ore titanium3;
	private Ore titanium4;
	private Ore titanium5;
	private JButton btntitanium1;
	private JButton btntitanium2;
	private JButton btntitanium3;
	private JButton btntitanium4;
	private JButton btntitanium5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MineTitanium frame = new MineTitanium();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MineTitanium() {
		pick = new Pickax();
		pick.infoPick();
		titanium1 = new Titanium();
		titanium2 = new Titanium();
		titanium3 = new Titanium();
		titanium4 = new Titanium();
		titanium5 = new Titanium();

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
		
		JButton btnNewButton_1 = new JButton("로그아웃");
		panel_0.add(btnNewButton_1, BorderLayout.EAST);
		
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
		
		btntitanium1 = new JButton(titanium1.name+" : "+titanium1.hp);
		contentPane.add(btntitanium1);
		btntitanium1.addActionListener(this);
		
		btntitanium2 = new JButton(titanium2.name+" : "+titanium2.hp);
		contentPane.add(btntitanium2);
		btntitanium2.addActionListener(this);
		
		btntitanium3 = new JButton(titanium3.name+" : "+titanium3.hp);
		contentPane.add(btntitanium3);
		btntitanium3.addActionListener(this);
		
		btntitanium4 = new JButton(titanium4.name+" : "+titanium4.hp);
		contentPane.add(btntitanium4);
		btntitanium4.addActionListener(this);
		
		JButton back = new JButton("나가기");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect m = new MineSelect();
			}
		});
		contentPane.add(back);
		
		btntitanium5 = new JButton(titanium5.name+" : "+titanium5.hp);
		contentPane.add(btntitanium5);
		btntitanium5.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btntitanium1) {
			hittitanium1();
		}
		if (e.getSource()==btntitanium2) {
			hittitanium2();
		}
		if (e.getSource()==btntitanium3) {
			hittitanium3();
		}
		if (e.getSource()==btntitanium4) {
			hittitanium4();
		}
		if (e.getSource()==btntitanium5) {
			hittitanium5();
		}
	}
	
	public void hittitanium1() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + titanium1.hit(pick.atk()));
		btntitanium1.setText(titanium1.name+" : "+ titanium1.hp);
	}
	public void hittitanium2() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + titanium2.hit(pick.atk()));
		btntitanium2.setText(titanium2.name+" : " + titanium2.hp);
	}
	public void hittitanium3() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + titanium3.hit(pick.atk()));
		btntitanium3.setText(titanium3.name+" : "+ titanium3.hp);
	}
	public void hittitanium4() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + titanium4.hit(pick.atk()));
		btntitanium4.setText(titanium4.name+" : "+ titanium4.hp);
	}
	public void hittitanium5() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + titanium5.hit(pick.atk()));
		btntitanium5.setText(titanium5.name+" : "+ titanium5.hp);
	}
}
