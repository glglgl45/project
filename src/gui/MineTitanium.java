package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.MainPage;
import ore.*;
import system.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MineTitanium extends JFrame implements ActionListener {

	private JPanel mainPanel, contentPane;
	private Pickax pick;
	private Ore titanium1;
	private Ore titanium2;
	private Ore titanium3;
	private Ore titanium4;
	private Ore titanium5;
	private JButton btnTitanium1;
	private JButton btnTitanium2;
	private JButton btnTitanium3;
	private JButton btnTitanium4;
	private JButton btnTitanium5;
	private JLabel labelMoney;
	private JLabel lavelDura;
	private JButton btnScore;

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
		
		btnScore = new JButton("점수 : " + pick.getScore());
		panel_0.add(btnScore, BorderLayout.WEST);
		btnScore.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		mainPanel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("ID : 아이디");
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		
		JButton btnpi = new JButton(pick.getPickName() + " " + pick.getLevel());
		btnpi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PickaxInfo mc = new PickaxInfo();
			}
		});
		panel_2.add(btnpi);
		
		JLabel lblNewLabel_2 = new JLabel("내구도 : ");
		panel_2.add(lblNewLabel_2);
		
		lavelDura = new JLabel(pick.getDura()+"");
		panel_2.add(lavelDura);
		
		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.EAST);
		
		JLabel lblNewLabel_1 = new JLabel("소지금 : ");
		panel.add(lblNewLabel_1);
		
		labelMoney = new JLabel(pick.getMoney()+"");
		panel.add(labelMoney);
		
		btnTitanium1 = new JButton(titanium1.name+" : "+titanium1.hp);
		contentPane.add(btnTitanium1);
		btnTitanium1.addActionListener(this);
		
		btnTitanium2 = new JButton(titanium2.name+" : "+titanium2.hp);
		contentPane.add(btnTitanium2);
		btnTitanium2.addActionListener(this);
		
		btnTitanium3 = new JButton(titanium3.name+" : "+titanium3.hp);
		contentPane.add(btnTitanium3);
		btnTitanium3.addActionListener(this);
		
		btnTitanium4 = new JButton(titanium4.name+" : "+titanium4.hp);
		contentPane.add(btnTitanium4);
		btnTitanium4.addActionListener(this);
		
		JButton back = new JButton("나가기");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect m = new MineSelect();
			}
		});
		contentPane.add(back);
		
		btnTitanium5 = new JButton(titanium5.name+" : "+titanium5.hp);
		contentPane.add(btnTitanium5);
		btnTitanium5.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnTitanium1) {
			hittitanium1();
		}
		if (e.getSource()==btnTitanium2) {
			hittitanium2();
		}
		if (e.getSource()==btnTitanium3) {
			hittitanium3();
		}
		if (e.getSource()==btnTitanium4) {
			hittitanium4();
		}
		if (e.getSource()==btnTitanium5) {
			hittitanium5();
		}
	}
	
	public void hittitanium1() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + titanium1.hit(pick.atk()));
		btnTitanium1.setText(titanium1.name+" : "+ titanium1.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
		
	}
	public void hittitanium2() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + titanium2.hit(pick.atk()));
		btnTitanium2.setText(titanium2.name+" : " + titanium2.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hittitanium3() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + titanium3.hit(pick.atk()));
		btnTitanium3.setText(titanium3.name+" : "+ titanium3.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hittitanium4() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + titanium4.hit(pick.atk()));
		btnTitanium4.setText(titanium4.name+" : "+ titanium4.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hittitanium5() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + titanium5.hit(pick.atk()));
		btnTitanium5.setText(titanium5.name+" : "+ titanium5.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
}
