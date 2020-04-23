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

public class MineIron extends JFrame implements ActionListener {

	private JPanel mainPanel, contentPane;
	private Pickax pick;
	private Ore iron1;
	private Ore iron2;
	private Ore iron3;
	private Ore iron4;
	private Ore iron5;
	private JButton btniron1;
	private JButton btniron2;
	private JButton btniron3;
	private JButton btniron4;
	private JButton btniron5;
	private JLabel labelMoney;
	private JLabel lavelDura;
	private JButton btnScore;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MineIron frame = new MineIron();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MineIron() {
		pick = new Pickax();
		pick.infoPick();
		iron1 = new Iron();
		iron2 = new Iron();
		iron3 = new Iron();
		iron4 = new Iron();
		iron5 = new Iron();

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
		
		btniron1 = new JButton(iron1.name+" : "+iron1.hp);
		btniron1.setIcon(new ImageIcon(MineIron.class.getResource("/gui/iron.png")));
		contentPane.add(btniron1);
		btniron1.addActionListener(this);
		
		btniron2 = new JButton(iron2.name+" : "+iron2.hp);
		btniron2.setIcon(new ImageIcon(MineIron.class.getResource("/gui/iron.png")));
		contentPane.add(btniron2);
		btniron2.addActionListener(this);
		
		btniron3 = new JButton(iron3.name+" : "+iron3.hp);
		btniron3.setIcon(new ImageIcon(MineIron.class.getResource("/gui/iron.png")));
		contentPane.add(btniron3);
		btniron3.addActionListener(this);
		
		btniron4 = new JButton(iron4.name+" : "+iron4.hp);
		btniron4.setIcon(new ImageIcon(MineIron.class.getResource("/gui/iron.png")));
		contentPane.add(btniron4);
		btniron4.addActionListener(this);
		
		JButton back = new JButton("나가기");
		back.setIcon(new ImageIcon(MineIron.class.getResource("/gui/door.png")));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect m = new MineSelect();
			}
		});
		contentPane.add(back);
		
		btniron5 = new JButton(iron5.name+" : "+iron5.hp);
		btniron5.setIcon(new ImageIcon(MineIron.class.getResource("/gui/iron.png")));
		contentPane.add(btniron5);
		btniron5.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btniron1) {
			hitiron1();
		}
		if (e.getSource()==btniron2) {
			hitiron2();
		}
		if (e.getSource()==btniron3) {
			hitiron3();
		}
		if (e.getSource()==btniron4) {
			hitiron4();
		}
		if (e.getSource()==btniron5) {
			hitiron5();
		}
	}
	
	public void hitiron1() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + iron1.hit(pick.atk()));
		btniron1.setText(iron1.name+" : "+ iron1.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
		
	}
	public void hitiron2() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + iron2.hit(pick.atk()));
		btniron2.setText(iron2.name+" : " + iron2.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hitiron3() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + iron3.hit(pick.atk()));
		btniron3.setText(iron3.name+" : "+ iron3.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hitiron4() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + iron4.hit(pick.atk()));
		btniron4.setText(iron4.name+" : "+ iron4.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hitiron5() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + iron5.hit(pick.atk()));
		btniron5.setText(iron5.name+" : "+ iron5.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
}
