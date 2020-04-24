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
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

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
	private HpBar oreHpBar1;
	private HpBar oreHpBar2;
	private HpBar oreHpBar3;
	private HpBar oreHpBar4;
	private HpBar woodHpBar;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;

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
		
		oreHpBar1 = new HpBar(stone1.maxHp, stone1.hp);
		oreHpBar1.setLocation(56, 156);
		oreHpBar1.setSize(100, 20);
		oreHpBar2 = new HpBar(stone2.maxHp, stone2.hp);
		oreHpBar3 = new HpBar(stone3.maxHp, stone3.hp);
		oreHpBar4 = new HpBar(stone4.maxHp, stone4.hp);
		woodHpBar = new HpBar(wood.maxHp, wood.hp);
		
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
		
		panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		btnStone1 = new JButton();
		btnStone1.setBounds(45, 27, 133, 109);
		panel_3.add(btnStone1);
		btnStone1.setIcon(new ImageIcon(MineStone.class.getResource("/gui/stone.png")));
		panel_3.add(oreHpBar1);
		
		panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		btnStone2 = new JButton();
		panel_4.add(btnStone2);
		btnStone2.setIcon(new ImageIcon(MineStone.class.getResource("/gui/stone.png")));
		btnStone2.addActionListener(this);
		
		panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		btnStone3 = new JButton();
		panel_5.add(btnStone3);
		btnStone3.setIcon(new ImageIcon(MineStone.class.getResource("/gui/stone.png")));
		btnStone3.addActionListener(this);
		
		panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		btnStone4 = new JButton();
		panel_6.add(btnStone4);
		btnStone4.setIcon(new ImageIcon(MineStone.class.getResource("/gui/stone.png")));
		btnStone4.addActionListener(this);
		
		panel_7 = new JPanel();
		contentPane.add(panel_7);
		
		JButton back = new JButton("나가기");
		panel_7.add(back);
		back.setIcon(new ImageIcon(MineStone.class.getResource("/gui/door.png")));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect m = new MineSelect();
			}
		});
		
		panel_8 = new JPanel();
		contentPane.add(panel_8);
		
		btnStone5 = new JButton();
		panel_8.add(btnStone5);
		btnStone5.setIcon(new ImageIcon(MineStone.class.getResource("/gui/wood.png")));
		btnStone5.addActionListener(this);
		btnStone1.addActionListener(this);
		
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
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
		oreHpBar1.setCurHp(stone1.hp);
		oreHpBar1.setMaxHp(stone1.maxHp);
		repaint();
	}
	public void hitStone2() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + stone2.hit(pick.atk()));
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hitStone3() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + stone3.hit(pick.atk()));
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hitStone4() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + stone4.hit(pick.atk()));
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
	public void hitStone5() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + wood.hit(pick.atkWood()));
		labelMoney.setText(pick.getMoney()+"");
		lavelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
}
