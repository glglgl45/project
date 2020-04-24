package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbguide.ClickerDAO;
import gui.MainPage;
import ore.*;
import system.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

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
	private JLabel labelMoney;
	private JLabel lavelDura;
	private JLabel lblNewLabel;
	private JButton btnScore;
	private ClickerDAO dao;

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
		pick.setScore(pick.getScore()-pick.getPickLevel()*5);
		titanium1 = new Titanium();
		titanium2 = new Titanium();
		titanium3 = new Titanium();
		titanium4 = new Titanium();
		titanium5 = new Titanium();
		dao = new ClickerDAO();
		
		setDefaultCloseOperation(dao.saveUser());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
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
				dao.saveUser();
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
		btnScore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Ranking ranking = new Ranking();
				
			}
		});
		btnScore.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		mainPanel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("ID : "+pick.getUserId());
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		
		JButton btnpi = new JButton(pick.getPickName() + " +" + pick.getLevel());
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
		
		btntitanium1 = new JButton(titanium1.name+" : "+titanium1.hp);
		btntitanium1.setIcon(new ImageIcon(MineTitanium.class.getResource("/gui/titanium.png")));
		contentPane.add(btntitanium1);
		btntitanium1.addActionListener(this);
		
		btntitanium2 = new JButton(titanium2.name+" : "+titanium2.hp);
		btntitanium2.setIcon(new ImageIcon(MineTitanium.class.getResource("/gui/titanium.png")));
		contentPane.add(btntitanium2);
		btntitanium2.addActionListener(this);
		
		btntitanium3 = new JButton(titanium3.name+" : "+titanium3.hp);
		btntitanium3.setIcon(new ImageIcon(MineTitanium.class.getResource("/gui/titanium.png")));
		contentPane.add(btntitanium3);
		btntitanium3.addActionListener(this);
		
		btntitanium4 = new JButton(titanium4.name+" : "+titanium4.hp);
		btntitanium4.setIcon(new ImageIcon(MineTitanium.class.getResource("/gui/titanium.png")));
		contentPane.add(btntitanium4);
		btntitanium4.addActionListener(this);
		
		JButton back = new JButton("나가기");
		back.setIcon(new ImageIcon(MineTitanium.class.getResource("/gui/door.png")));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect m = new MineSelect();
			}
		});
		contentPane.add(back);
		
		btntitanium5 = new JButton(titanium5.name+" : "+titanium5.hp);
		btntitanium5.setIcon(new ImageIcon(MineTitanium.class.getResource("/gui/titanium.png")));
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
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
		
	}
	public void hittitanium2() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + titanium2.hit(pick.atk()));
		btntitanium2.setText(titanium2.name+" : " + titanium2.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hittitanium3() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + titanium3.hit(pick.atk()));
		btntitanium3.setText(titanium3.name+" : "+ titanium3.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hittitanium4() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + titanium4.hit(pick.atk()));
		btntitanium4.setText(titanium4.name+" : "+ titanium4.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hittitanium5() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + titanium5.hit(pick.atk()));
		btntitanium5.setText(titanium5.name+" : "+ titanium5.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
}
