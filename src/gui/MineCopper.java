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
import javax.swing.ImageIcon;

public class MineCopper extends JFrame implements ActionListener {

	private JPanel mainPanel, contentPane;
	private Pickax pick;
	private Ore copper1;
	private Ore copper2;
	private Ore copper3;
	private Ore copper4;
	private Ore copper5;
	private JButton btncopper1;
	private JButton btncopper2;
	private JButton btncopper3;
	private JButton btncopper4;
	private JButton btncopper5;
	private JLabel labelMoney;
	private JLabel lavelDura;
	private JButton btnScore;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MineCopper frame = new MineCopper();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MineCopper() {
		pick = new Pickax();
		pick.infoPick();
		copper1 = new Copper();
		copper2 = new Copper();
		copper3 = new Copper();
		copper4 = new Copper();
		copper5 = new Copper();

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
		
		btncopper1 = new JButton(copper1.name+" : "+copper1.hp);
		btncopper1.setIcon(new ImageIcon(MineCopper.class.getResource("/gui/copper.png")));
		contentPane.add(btncopper1);
		btncopper1.addActionListener(this);
		
		btncopper2 = new JButton(copper2.name+" : "+copper2.hp);
		btncopper2.setIcon(new ImageIcon(MineCopper.class.getResource("/gui/copper.png")));
		contentPane.add(btncopper2);
		btncopper2.addActionListener(this);
		
		btncopper3 = new JButton(copper3.name+" : "+copper3.hp);
		btncopper3.setIcon(new ImageIcon(MineCopper.class.getResource("/gui/copper.png")));
		contentPane.add(btncopper3);
		btncopper3.addActionListener(this);
		
		btncopper4 = new JButton(copper4.name+" : "+copper4.hp);
		btncopper4.setIcon(new ImageIcon(MineCopper.class.getResource("/gui/copper.png")));
		contentPane.add(btncopper4);
		btncopper4.addActionListener(this);
		
		JButton back = new JButton("나가기");
		back.setIcon(new ImageIcon(MineCopper.class.getResource("/gui/door.png")));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect m = new MineSelect();
			}
		});
		contentPane.add(back);
		
		btncopper5 = new JButton(copper5.name+" : "+copper5.hp);
		btncopper5.setIcon(new ImageIcon(MineCopper.class.getResource("/gui/copper.png")));
		contentPane.add(btncopper5);
		btncopper5.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btncopper1) {
			hitcopper1();
		}
		if (e.getSource()==btncopper2) {
			hitcopper2();
		}
		if (e.getSource()==btncopper3) {
			hitcopper3();
		}
		if (e.getSource()==btncopper4) {
			hitcopper4();
		}
		if (e.getSource()==btncopper5) {
			hitcopper5();
		}
	}
	
	public void hitcopper1() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + copper1.hit(pick.atk()));
		btncopper1.setText(copper1.name+" : "+ copper1.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
		
	}
	public void hitcopper2() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + copper2.hit(pick.atk()));
		btncopper2.setText(copper2.name+" : " + copper2.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hitcopper3() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + copper3.hit(pick.atk()));
		btncopper3.setText(copper3.name+" : "+ copper3.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hitcopper4() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + copper4.hit(pick.atk()));
		btncopper4.setText(copper4.name+" : "+ copper4.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hitcopper5() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + copper5.hit(pick.atk()));
		btncopper5.setText(copper5.name+" : "+ copper5.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
}
