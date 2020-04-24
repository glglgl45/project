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

public class MineStone extends JFrame implements ActionListener {

	private JPanel mainPanel, contentPane;
	private Pickax pick;
	private Ore stone1;
	private Ore stone2;
	private Ore stone3;
	private Ore stone4;
	private Ore wood;
	private JButton btnStone1;
	private JButton btnStone2;
	private JButton btnStone3;
	private JButton btnStone4;
	private JButton btnStone5;
	private JLabel labelMoney;
	private JLabel lavelDura;
	private JLabel lblNewLabel;
	private JButton btnScore;
	private ClickerDAO dao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MineStone frame = new MineStone();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MineStone() {
		pick = new Pickax();
		pick.infoPick();
		pick.setScore(pick.getScore()-pick.getPickLevel()*5);
		stone1 = new Stone();
		stone2 = new Stone();
		stone3 = new Stone();
		stone4 = new Stone();
		wood = new Wood();
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
		
		btnStone1 = new JButton(stone1.name+" : "+stone1.hp);
		btnStone1.setIcon(new ImageIcon(MineStone.class.getResource("/gui/stone.png")));
		contentPane.add(btnStone1);
		btnStone1.addActionListener(this);
		
		btnStone2 = new JButton(stone2.name+" : "+stone2.hp);
		btnStone2.setIcon(new ImageIcon(MineStone.class.getResource("/gui/stone.png")));
		contentPane.add(btnStone2);
		btnStone2.addActionListener(this);
		
		btnStone3 = new JButton(stone3.name+" : "+stone3.hp);
		btnStone3.setIcon(new ImageIcon(MineStone.class.getResource("/gui/stone.png")));
		contentPane.add(btnStone3);
		btnStone3.addActionListener(this);
		
		btnStone4 = new JButton(stone4.name+" : "+stone4.hp);
		btnStone4.setIcon(new ImageIcon(MineStone.class.getResource("/gui/stone.png")));
		contentPane.add(btnStone4);
		btnStone4.addActionListener(this);
		
		JButton back = new JButton("나가기");
		back.setIcon(new ImageIcon(MineStone.class.getResource("/gui/door.png")));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect m = new MineSelect();
			}
		});
		contentPane.add(back);
		
		btnStone5 = new JButton(wood.name+" : "+wood.hp);
		btnStone5.setIcon(new ImageIcon(MineStone.class.getResource("/gui/wood.png")));
		contentPane.add(btnStone5);
		btnStone5.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnStone1) {
			hitStone1();
		}
		if (e.getSource()==btnStone2) {
			hitStone2();
		}
		if (e.getSource()==btnStone3) {
			hitStone3();
		}
		if (e.getSource()==btnStone4) {
			hitStone4();
		}
		if (e.getSource()==btnStone5) {
			hitStone5();
		}
	}
	
	public void hitStone1() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + stone1.hit(pick.atk()));
		btnStone1.setText(stone1.name+" : "+ stone1.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
		
	}
	public void hitStone2() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + stone2.hit(pick.atk()));
		btnStone2.setText(stone2.name+" : " + stone2.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hitStone3() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + stone3.hit(pick.atk()));
		btnStone3.setText(stone3.name+" : "+ stone3.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hitStone4() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + stone4.hit(pick.atk()));
		btnStone4.setText(stone4.name+" : "+ stone4.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hitStone5() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + wood.hit(pick.atkWood()));
		btnStone5.setText(wood.name+" : "+ wood.hp);
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
}
