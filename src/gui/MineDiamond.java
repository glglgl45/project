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

public class MineDiamond extends JFrame implements ActionListener {

	private JPanel mainPanel, contentPane;
	private Pickax pick;
	private Ore diamond1;
	private Ore diamond2;
	private Ore diamond3;
	private Ore diamond4;
	private Ore diamondWall;
	private JButton btndiamond1;
	private JButton btndiamond2;
	private JButton btndiamond3;
	private JButton btndiamond4;
	private JButton btndiamond5;
	private JLabel labelMoney;
	private JLabel lavelDura;
	private JLabel lblNewLabel;
	private JButton btnScore;
	private ClickerDAO dao;

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
		pick.setScore(pick.getScore()-pick.getPickLevel()*5);
		diamond1 = new Diamond();
		diamond2 = new Diamond();
		diamond3 = new Diamond();
		diamond4 = new Diamond();
		diamondWall = new DiamondWall();
		dao = new ClickerDAO();
		
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
		
		btndiamond1 = new JButton(diamond1.name+" : "+diamond1.hp);
		btndiamond1.setIcon(new ImageIcon(MineDiamond.class.getResource("/gui/diamond.png")));
		contentPane.add(btndiamond1);
		btndiamond1.addActionListener(this);
		
		btndiamond2 = new JButton(diamond2.name+" : "+diamond2.hp);
		btndiamond2.setIcon(new ImageIcon(MineDiamond.class.getResource("/gui/diamond.png")));
		contentPane.add(btndiamond2);
		btndiamond2.addActionListener(this);
		
		btndiamond3 = new JButton(diamond3.name+" : "+diamond3.hp);
		btndiamond3.setIcon(new ImageIcon(MineDiamond.class.getResource("/gui/diamond.png")));
		contentPane.add(btndiamond3);
		btndiamond3.addActionListener(this);
		
		btndiamond4 = new JButton(diamond4.name+" : "+diamond4.hp);
		btndiamond4.setIcon(new ImageIcon(MineDiamond.class.getResource("/gui/diamond.png")));
		contentPane.add(btndiamond4);
		btndiamond4.addActionListener(this);
		
		JButton back = new JButton("나가기");
		back.setIcon(new ImageIcon(MineDiamond.class.getResource("/gui/door.png")));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect m = new MineSelect();
			}
		});
		contentPane.add(back);
		
		btndiamond5 = new JButton(diamondWall.name);
		btndiamond5.setIcon(new ImageIcon(MineDiamond.class.getResource("/gui/diamondwall.jpg")));
		contentPane.add(btndiamond5);
		btndiamond5.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btndiamond1) {
			hitdiamond1();
		}
		if (e.getSource()==btndiamond2) {
			hitdiamond2();
		}
		if (e.getSource()==btndiamond3) {
			hitdiamond3();
		}
		if (e.getSource()==btndiamond4) {
			hitdiamond4();
		}
		if (e.getSource()==btndiamond5) {
			hitdiamond5();
			if(diamondWall.hp==0) { // diamondWall의 hp가 다 닳았을 때
				dispose();
				GameClear gc = new GameClear();
			}
		}
	}
	
	public void hitdiamond1() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + diamond1.hit(pick.atk()));
		btndiamond1.setText(diamond1.name+" : "+ diamond1.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
		
	}
	public void hitdiamond2() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + diamond2.hit(pick.atk()));
		btndiamond2.setText(diamond2.name+" : " + diamond2.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hitdiamond3() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + diamond3.hit(pick.atk()));
		btndiamond3.setText(diamond3.name+" : "+ diamond3.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hitdiamond4() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + diamond4.hit(pick.atk()));
		btndiamond4.setText(diamond4.name+" : "+ diamond4.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hitdiamond5() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + diamondWall.hit(pick.atk()));
		btndiamond5.setText(diamondWall.name);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
}
