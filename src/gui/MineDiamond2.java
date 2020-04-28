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

public class MineDiamond2 extends JFrame implements ActionListener {

	private JPanel mainPanel, contentPane;
	private Pickax pick;
	private Ore ore1;
	private Ore ore2;
	private Ore ore3;
	private Ore ore4;
	private Ore ore5;
	private JButton btnOre1;
	private JButton btnOre2;
	private JButton btnOre3;
	private JButton btnOre4;
	private JButton btnOre5;
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
	private JPanel paneCen2Ab;
	private JPanel paneCen3Ab;
	private JPanel paneCen4Ab;
	private JPanel paneCen5Ab;
	private JPanel paneCen6Ab;
	private JPanel paneOreBtnBordCenFlow;
	private JPanel paneOreBtnBordCenFlow_1;
	private JPanel paneHpBordSouthBord;
	private JPanel paneHpBordSouthBord_2;
	private JPanel paneHpBordSouthBord_1;
	private JPanel paneOreAndHpBord;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MineDiamond2 frame = new MineDiamond2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MineDiamond2() {
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
		contentPane.setBackground(new Color(255, 0, 0, 0));
		
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
		
		paneCen2Ab = new JPanel();
		paneCen2Ab.setBounds(235, 0, 234, 273);
		contentPane.add(paneCen2Ab);
		paneCen2Ab.setLayout(null);
		paneCen2Ab.setBackground(new Color(255, 0, 0, 0));
		
		JPanel paneOreAndHpBord_2 = new JPanel();
		paneOreAndHpBord_2.setBounds(44, 48, 133, 119);
		paneCen2Ab.add(paneOreAndHpBord_2);
		paneOreAndHpBord_2.setLayout(new BorderLayout(0, 0));
		paneOreAndHpBord_2.setBackground(new Color(255, 0, 0, 0));
		
		paneOreBtnBordCenFlow_1 = new JPanel();
		paneOreAndHpBord_2.add(paneOreBtnBordCenFlow_1, BorderLayout.CENTER);
		paneOreBtnBordCenFlow_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		paneOreBtnBordCenFlow_1.setBackground(new Color(255, 0, 0, 0));
		
		btnOre2= new JButton();
		paneOreBtnBordCenFlow_1.add(btnOre2);
		btnOre2.setBorderPainted(false);
		btnOre2.setFocusPainted(false);
		btnOre2.setContentAreaFilled(false);
		btnOre2.setIcon(ore2.OreImg());
		btnOre2.addActionListener(this);
		
		paneHpBordSouthBord_1 = new JPanel();
		paneOreAndHpBord_2.add(paneHpBordSouthBord_1, BorderLayout.SOUTH);
		paneHpBordSouthBord_1.setLayout(new BorderLayout(0, 0));
						
		oreHpBar2 = new HpBar();
		paneHpBordSouthBord_1.add(oreHpBar2);
		oreHpBar2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		paneHpBordSouthBord_2 = new JPanel();
		paneHpBordSouthBord_2.setBounds(-223, 69, 106, 23);
		paneCen2Ab.add(paneHpBordSouthBord_2);
		paneHpBordSouthBord_2.setLayout(new BorderLayout(0, 0));
		
		paneCen3Ab = new JPanel();
		paneCen3Ab.setBounds(469, 0, 234, 273);
		contentPane.add(paneCen3Ab);
		paneCen3Ab.setLayout(null);
		
		JPanel paneOreAndHpBord_3 = new JPanel();
		paneOreAndHpBord_3.setBounds(44, 38, 133, 119);
		paneCen3Ab.add(paneOreAndHpBord_3);
		paneOreAndHpBord_3.setLayout(new BorderLayout(0, 0));
		
		paneOreBtnBordCenFlow = new JPanel();
		paneOreAndHpBord_3.add(paneOreBtnBordCenFlow, BorderLayout.CENTER);
		paneOreBtnBordCenFlow.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnOre3= new JButton();
		paneOreBtnBordCenFlow.add(btnOre3);
		btnOre3.setBorderPainted(false);
		btnOre3.setFocusPainted(false);
		btnOre3.setContentAreaFilled(false);
		btnOre3.setIcon(ore3.OreImg());
		btnOre3.addActionListener(this);
		
		paneHpBordSouthBord = new JPanel();
		paneOreAndHpBord_3.add(paneHpBordSouthBord, BorderLayout.SOUTH);
		paneHpBordSouthBord.setLayout(new BorderLayout(0, 0));
						
		oreHpBar3 = new HpBar();
		paneHpBordSouthBord.add(oreHpBar3);
		oreHpBar3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		paneCen4Ab = new JPanel();
		paneCen4Ab.setBounds(1, 273, 234, 273);
		contentPane.add(paneCen4Ab);
		paneCen4Ab.setLayout(null);
		
		JPanel paneOreAndHpBord_4 = new JPanel();
		paneOreAndHpBord_4.setBounds(44, 48, 133, 119);
		paneCen4Ab.add(paneOreAndHpBord_4);
		paneOreAndHpBord_4.setLayout(new BorderLayout(0, 0));
		
		paneOreBtnBordCenFlow = new JPanel();
		paneOreAndHpBord_4.add(paneOreBtnBordCenFlow, BorderLayout.CENTER);
		paneOreBtnBordCenFlow.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnOre4= new JButton();
		paneOreBtnBordCenFlow.add(btnOre4);
		btnOre4.setBorderPainted(false);
		btnOre4.setFocusPainted(false);
		btnOre4.setContentAreaFilled(false);
		btnOre4.setIcon(ore4.OreImg());
		btnOre4.addActionListener(this);
		
		paneHpBordSouthBord = new JPanel();
		paneOreAndHpBord_4.add(paneHpBordSouthBord, BorderLayout.SOUTH);
		paneHpBordSouthBord.setLayout(new BorderLayout(0, 0));
						
		oreHpBar4 = new HpBar();
		paneHpBordSouthBord.add(oreHpBar4);
		oreHpBar4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		paneCen5Ab = new JPanel();
		paneCen5Ab.setBounds(235, 273, 234, 273);
		contentPane.add(paneCen5Ab);
		
		
		
		JButton back = new JButton("나가기");
		paneCen5Ab.add(back);
		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		back.setIcon(new ImageIcon(MineDiamond2.class.getResource("/img/door.png")));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect m = new MineSelect();
			}
		});
		
		paneCen6Ab = new JPanel();
		paneCen6Ab.setBounds(469, 273, 234, 273);
		contentPane.add(paneCen6Ab);
		
		JPanel paneOreAndHpBord_5 = new JPanel();
		paneOreAndHpBord_5.setBounds(44, 48, 133, 119);
		paneCen6Ab.add(paneOreAndHpBord_5);
		paneOreAndHpBord_5.setLayout(new BorderLayout(0, 0));
		
		paneOreBtnBordCenFlow_1 = new JPanel();
		paneOreAndHpBord_5.add(paneOreBtnBordCenFlow_1, BorderLayout.CENTER);
		paneOreBtnBordCenFlow_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnOre5= new JButton();
		paneOreBtnBordCenFlow_1.add(btnOre5);
		btnOre5.setBorderPainted(false);
		btnOre5.setFocusPainted(false);
		btnOre5.setContentAreaFilled(false);
		btnOre5.setIcon(ore5.OreImg());
		btnOre5.addActionListener(this);
		
		paneHpBordSouthBord_1 = new JPanel();
		paneOreAndHpBord_5.add(paneHpBordSouthBord_1, BorderLayout.SOUTH);
		paneHpBordSouthBord_1.setLayout(new BorderLayout(0, 0));
						
		oreHpBar5 = new HpBar();
		paneHpBordSouthBord_1.add(oreHpBar5);
		oreHpBar5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		paneOreAndHpBord = new JPanel();
		paneOreAndHpBord.setBounds(-122, 99, 524, 23);
		contentPane.add(paneOreAndHpBord);
		paneOreAndHpBord.setLayout(new BorderLayout(0, 0));
		paneOreAndHpBord.setBackground(new Color(255, 0, 0, 0));
		btnOre1= new JButton();
		btnOre1.setBounds(49, 117, 132, 108);
		contentPane.add(btnOre1);
		btnOre1.setBorderPainted(false);
		btnOre1.setFocusPainted(false);
		btnOre1.setContentAreaFilled(false);
		btnOre1.setIcon(ore1.OreImg());
		oreHpBar1 = new HpBar();
		oreHpBar1.setBounds(23, 99, 132, 23);
		contentPane.add(oreHpBar1);
		oreHpBar1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnOre1.addActionListener(this);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 702, 540);
		mainPanel.add(lblNewLabel);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnOre1) {
			hitOre(ore1,oreHpBar1,btnOre1);
		}
		if (e.getSource()==btnOre2) {
			hitOre(ore2,oreHpBar2,btnOre2);
		}
		if (e.getSource()==btnOre3) {
			hitOre(ore3,oreHpBar3,btnOre3);
		}
		if (e.getSource()==btnOre4) {
			hitOre(ore4,oreHpBar4,btnOre4);
		}
		if (e.getSource()==btnOre5) {
			hitOre(ore5,oreHpBar5,btnOre5);
		}
		
	}
	
	public void hitOre(Ore ore, HpBar oreHpBar, JButton btnOre) {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + ore.hit(pick.atk()));
		labelMoney.setText(pick.getMoney()+"");
		labelDura.setText(pick.getDura()+"");
		btnScore.setText("점수 : " + pick.getScore());
		oreHpBar.settingHp(ore.maxHp, ore.hp, btnOre.getWidth()); // hp게이지 세팅(최대hp,현재hp,가로길이)
		repaint(); // 클릭시 repaint()로 hp 게이지 변화
	}
}