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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.Color;

public class MineDiamond3 extends JFrame implements ActionListener {

	private JPanel mainPanel, contentPane;
	private Pickax pick;
	private Ore ore1;
	private Ore ore2;
	private Ore ore3;
	private Ore ore4;
	private Ore ore5;
	private JButton btnOre1;
	private JLabel labelMoney;
	private JLabel labelDura;
	private JLabel labelShowID;
	private JButton btnScore;
	private ClickerDAO dao;
	private HpBar oreHpBar1;
	private HpBar oreHpBar2;
	private HpBar oreHpBar3;
	private HpBar oreHpBar4;
	private HpBar oreHpBar5;
	private JPanel paneOreBtnBordCenFlow;
	private JPanel paneOreBtnBordCenFlow_1;
	private JPanel paneHpBordSouthBord;
	private JPanel paneHpBordSouthBord_1;
	private JPanel paneOreAndHpBord;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MineDiamond3 frame = new MineDiamond3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MineDiamond3() {
		pick = new Pickax();
		pick.infoPick();
		pick.setScore(pick.getScore()-pick.getPickLevel()*5);
		ore1= new Diamond();
		ore2= new Diamond();
		ore3= new Diamond();
		ore4= new Diamond();
		ore5 = new DiamondWall();
		oreHpBar2 = new HpBar();
		oreHpBar3 = new HpBar();
		oreHpBar4 = new HpBar();
		oreHpBar5 = new HpBar();
		dao = new ClickerDAO();
		
//		setDefaultCloseOperation(dao.saveUser());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 650);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		contentPane = new JPanel();
		contentPane.setBounds(5, 28, 704, 546);
		mainPanel.add(contentPane);
		setVisible(true);
		contentPane.setBackground(Color.DARK_GRAY);
		
		JPanel paneTopBord = new JPanel();
		paneTopBord.setBounds(5, 5, 704, 23);
		mainPanel.add(paneTopBord);
		paneTopBord.setLayout(new BorderLayout(0, 0));
		
		JButton btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dao.saveUser();	//DB에 게임 진행사항 저장
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
		paneTopBord.add(btnLogout, BorderLayout.EAST);
		
		btnScore = new JButton("점수 : " + pick.getScore());
		paneTopBord.add(btnScore, BorderLayout.WEST);
		btnScore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Ranking ranking = new Ranking();
				
			}
		});
		btnScore.addActionListener(this);
		
		JPanel paneBotBord = new JPanel();
		paneBotBord.setBounds(5, 574, 704, 33);
		mainPanel.add(paneBotBord);
		paneBotBord.setLayout(new BorderLayout(0, 0));
		
		labelShowID = new JLabel("ID : "+pick.getUserId());
		paneBotBord.add(labelShowID, BorderLayout.WEST);
		
		JPanel paneBotCenFlow = new JPanel();
		paneBotBord.add(paneBotCenFlow, BorderLayout.CENTER);
		
		JButton btnPick = new JButton(pick.getPickName() + " +" + pick.getLevel());
		btnPick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PickaxInfo mc = new PickaxInfo();
			}
		});
		paneBotCenFlow.add(btnPick);
		
		JLabel labelShowDura = new JLabel("내구도 : ");
		paneBotCenFlow.add(labelShowDura);
		
		labelDura = new JLabel(pick.getDura()+"");
		paneBotCenFlow.add(labelDura);
		
		JPanel paneBotEastFlow = new JPanel();
		paneBotBord.add(paneBotEastFlow, BorderLayout.EAST);
		
		JLabel labelShowMoney = new JLabel("소지금 : ");
		paneBotEastFlow.add(labelShowMoney);
		
		labelMoney = new JLabel(pick.getMoney()+"");
		paneBotEastFlow.add(labelMoney);
		contentPane.setLayout(null);
		
		paneOreAndHpBord = new JPanel();
		paneOreAndHpBord.setBounds(199, 180, 124, 124);
		contentPane.add(paneOreAndHpBord);
		paneOreAndHpBord.setLayout(new BorderLayout(0, 0));
		paneOreAndHpBord.setBackground(Color.LIGHT_GRAY);
		oreHpBar1 = new HpBar();
		paneOreAndHpBord.add(oreHpBar1, BorderLayout.SOUTH);
		oreHpBar1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnOre1= new JButton();
		paneOreAndHpBord.add(btnOre1, BorderLayout.CENTER);
		btnOre1.setIcon(ore1.OreImg());
		btnOre1.setBackground(Color.WHITE);
		
//		btnOre1.setOpaque(false);		
		btnOre1.setBorderPainted(false);
		btnOre1.setFocusPainted(false);
//		btnOre1.setContentAreaFilled(false);
		
		paneOreAndHpBord.setOpaque(false);
		
		
		btnOre1.addActionListener(this);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		hitOre(ore1,oreHpBar1,btnOre1);
	}
	
	public void hitOre(Ore ore, HpBar oreHpBar, JButton btnOre) {
		pick.infoPick();
		oreHpBar.settingHp(ore.maxHp, ore.hp, btnOre.getWidth()); // hp게이지 세팅(최대hp,현재hp,가로길이)
		repaint(); // 클릭시 repaint()로 hp 게이지 변화
		pick.setMoney(pick.getMoney() + ore.hit(pick.atk()));
		labelMoney.setText(pick.getMoney()+"");
		labelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
	}
}
