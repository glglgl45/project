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

//import img.*;

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
import javax.swing.UIManager;
import java.awt.SystemColor;

public class MineStone extends JFrame implements ActionListener {

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
<<<<<<< HEAD
	private HpBar oreHpBar;
=======
	private HpBar oreHpBar5;
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
	private JPanel paneCen1Ab;
	private JPanel paneCen2Ab;
	private JPanel paneCen3Ab;
	private JPanel paneCen4Ab;
	private JPanel paneCen5Ab;
	private JPanel paneCen6Ab;
	private JPanel paneOreBtnBordCenFlow;
	private JPanel paneOreBtnBordCenFlow_1;
	private JPanel paneHpBordSouthBord;
	private JPanel paneHpBordSouthBord_1;

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
		ore1 = new Stone();
		ore2 = new Stone();
		ore3 = new Stone();
		ore4 = new Stone();
		ore5 = new Wood();
		oreHpBar1 = new HpBar();
		oreHpBar2 = new HpBar();
		oreHpBar3 = new HpBar();
		oreHpBar4 = new HpBar();
		oreHpBar5 = new HpBar();
		dao = new ClickerDAO();
		
<<<<<<< HEAD
=======
<<<<<<< HEAD
		
=======
<<<<<<< HEAD
		
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
		setDefaultCloseOperation(dao.saveUser());
<<<<<<< HEAD
=======
=======
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
//		setDefaultCloseOperation(dao.saveUser());
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
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
		
		JPanel paneTopBord = new JPanel();
		mainPanel.add(paneTopBord, BorderLayout.NORTH);
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
		mainPanel.add(paneBotBord, BorderLayout.SOUTH);
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
		
		paneCen1Ab = new JPanel();
		contentPane.add(paneCen1Ab);
		paneCen1Ab.setLayout(null);
		
		JPanel paneOreAndHpBord = new JPanel();
		paneOreAndHpBord.setBounds(44, 48, 133, 119);
		paneCen1Ab.add(paneOreAndHpBord);
		paneOreAndHpBord.setLayout(new BorderLayout(0, 0));
		
		paneOreBtnBordCenFlow = new JPanel();
		paneOreAndHpBord.add(paneOreBtnBordCenFlow, BorderLayout.CENTER);
		
<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
		btnOre1 = new JButton();
		paneOreBtnBordCenFlow.add(btnOre1);
		btnOre1.setIcon(ore1.OreImg());
		btnOre1.addActionListener(this);
<<<<<<< HEAD
=======
=======
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
		btnStone1 = new JButton();
		paneOreBtnBordCenFlow.add(btnStone1);
		btnStone1.setBorderPainted(false);
		btnStone1.setFocusPainted(false);
		btnStone1.setContentAreaFilled(false);
		btnStone1.setIcon(new ImageIcon(MineStone.class.getResource("/img/stone.png")));
		btnStone1.addActionListener(this);
<<<<<<< HEAD
=======
		btnOre1 = new JButton();
		paneOreBtnBordCenFlow.add(btnOre1);
		btnOre1.setIcon(new ImageIcon(MineStone.class.getResource("/img/stone.png")));
		btnOre1.addActionListener(this);
=======
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
		
		paneHpBordSouthBord = new JPanel();
		paneOreAndHpBord.add(paneHpBordSouthBord, BorderLayout.SOUTH);
		paneHpBordSouthBord.setLayout(new BorderLayout(0, 0));
						
		paneHpBordSouthBord.add(oreHpBar1);
		oreHpBar1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		paneCen2Ab = new JPanel();
		contentPane.add(paneCen2Ab);
		paneCen2Ab.setLayout(null);
		
		JPanel paneOreAndHpBord_2 = new JPanel();
		paneOreAndHpBord_2.setBounds(44, 48, 133, 119);
		paneCen2Ab.add(paneOreAndHpBord_2);
		paneOreAndHpBord_2.setLayout(new BorderLayout(0, 0));
		
		paneOreBtnBordCenFlow_1 = new JPanel();
		paneOreAndHpBord_2.add(paneOreBtnBordCenFlow_1, BorderLayout.CENTER);
		paneOreBtnBordCenFlow_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
<<<<<<< HEAD
		btnStone2 = new JButton();
		paneOreBtnBordCenFlow_1.add(btnStone2);
		btnStone2.setBorderPainted(false);
		btnStone2.setFocusPainted(false);
		btnStone2.setContentAreaFilled(false);
		btnStone2.setIcon(new ImageIcon(MineStone.class.getResource("/img/stone.png")));
		btnStone2.addActionListener(this);
=======
		btnOre2 = new JButton();
		paneOreBtnBordCenFlow_1.add(btnOre2);
		btnOre2.setIcon(new ImageIcon(MineStone.class.getResource("/img/stone.png")));
		btnOre2.addActionListener(this);
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
		
		paneHpBordSouthBord_1 = new JPanel();
		paneOreAndHpBord_2.add(paneHpBordSouthBord_1, BorderLayout.SOUTH);
		paneHpBordSouthBord_1.setLayout(new BorderLayout(0, 0));
		dao = new ClickerDAO();
						
		oreHpBar2 = new HpBar();
		paneHpBordSouthBord_1.add(oreHpBar2);
		oreHpBar2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		paneCen3Ab = new JPanel();
		contentPane.add(paneCen3Ab);
		paneCen3Ab.setLayout(null);
		
		JPanel paneOreAndHpBord_3 = new JPanel();
		paneOreAndHpBord_3.setBounds(44, 38, 133, 119);
		paneCen3Ab.add(paneOreAndHpBord_3);
		paneOreAndHpBord_3.setLayout(new BorderLayout(0, 0));
		
		paneOreBtnBordCenFlow = new JPanel();
		paneOreAndHpBord_3.add(paneOreBtnBordCenFlow, BorderLayout.CENTER);
		paneOreBtnBordCenFlow.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
<<<<<<< HEAD
		btnStone3 = new JButton();
		paneOreBtnBordCenFlow.add(btnStone3);
		btnStone3.setBorderPainted(false);
		btnStone3.setFocusPainted(false);
		btnStone3.setContentAreaFilled(false);
		btnStone3.setIcon(new ImageIcon(MineStone.class.getResource("/img/stone.png")));
		btnStone3.addActionListener(this);
=======
		btnOre3 = new JButton();
		paneOreBtnBordCenFlow.add(btnOre3);
		btnOre3.setIcon(new ImageIcon(MineStone.class.getResource("/img/stone.png")));
		btnOre3.addActionListener(this);
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
		
		paneHpBordSouthBord = new JPanel();
		paneOreAndHpBord_3.add(paneHpBordSouthBord, BorderLayout.SOUTH);
		paneHpBordSouthBord.setLayout(new BorderLayout(0, 0));
		dao = new ClickerDAO();
						
		oreHpBar3 = new HpBar();
		paneHpBordSouthBord.add(oreHpBar3);
		oreHpBar3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnOre3.addActionListener(this);
		
		paneCen4Ab = new JPanel();
		contentPane.add(paneCen4Ab);
		paneCen4Ab.setLayout(null);
		
		JPanel paneOreAndHpBord_4 = new JPanel();
		paneOreAndHpBord_4.setBounds(44, 48, 133, 119);
		paneCen4Ab.add(paneOreAndHpBord_4);
		paneOreAndHpBord_4.setLayout(new BorderLayout(0, 0));
		
		paneOreBtnBordCenFlow = new JPanel();
		paneOreAndHpBord_4.add(paneOreBtnBordCenFlow, BorderLayout.CENTER);
		paneOreBtnBordCenFlow.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
<<<<<<< HEAD
		btnStone4 = new JButton();
		paneOreBtnBordCenFlow.add(btnStone4);
		btnStone4.setBorderPainted(false);
		btnStone4.setFocusPainted(false);
		btnStone4.setContentAreaFilled(false);
		btnStone4.setIcon(new ImageIcon(MineStone.class.getResource("/img/stone.png")));
		btnStone4.addActionListener(this);
=======
		btnOre4 = new JButton();
		paneOreBtnBordCenFlow.add(btnOre4);
		btnOre4.setIcon(new ImageIcon(MineStone.class.getResource("/img/stone.png")));
		btnOre4.addActionListener(this);
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
		
		paneHpBordSouthBord = new JPanel();
		paneOreAndHpBord_4.add(paneHpBordSouthBord, BorderLayout.SOUTH);
		paneHpBordSouthBord.setLayout(new BorderLayout(0, 0));
		dao = new ClickerDAO();
						
		oreHpBar4 = new HpBar();
		paneHpBordSouthBord.add(oreHpBar4);
		oreHpBar4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
<<<<<<< HEAD
		btnOre4.addActionListener(this);
=======
<<<<<<< HEAD
=======
		btnStone4.addActionListener(this);
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
		
		paneCen5Ab = new JPanel();
		contentPane.add(paneCen5Ab);
		
		
		
		JButton back = new JButton("나가기");
		paneCen5Ab.add(back);
<<<<<<< HEAD
		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
<<<<<<< HEAD
		back.setIcon(new ImageIcon(MineStone.class.getResource("/gui/door.png")));
=======
		back.setIcon(new ImageIcon(MineStone.class.getResource("/img/door.png")));
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
=======
		back.setIcon(new ImageIcon(MineStone.class.getResource("/img/door.png")));
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect m = new MineSelect();
			}
		});
		
		paneCen6Ab = new JPanel();
		contentPane.add(paneCen6Ab);
		paneCen6Ab.setLayout(null);
		
		JPanel paneOreAndHpBord_5 = new JPanel();
		paneOreAndHpBord_5.setBounds(40, 5, 133, 119);
		paneCen6Ab.add(paneOreAndHpBord_5);
		paneOreAndHpBord_5.setLayout(new BorderLayout(0, 0));
		
		paneOreBtnBordCenFlow_1 = new JPanel();
		paneOreAndHpBord_5.add(paneOreBtnBordCenFlow_1, BorderLayout.CENTER);
		paneOreBtnBordCenFlow_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
<<<<<<< HEAD
		btnStone5 = new JButton();
		paneOreBtnBordCenFlow_1.add(btnStone5);
		btnStone5.setBorderPainted(false);
		btnStone5.setFocusPainted(false);
		btnStone5.setContentAreaFilled(false);
		btnStone5.setIcon(new ImageIcon(MineStone.class.getResource("/img/wood.png")));
		btnStone5.addActionListener(this);
=======
		btnOre5 = new JButton();
		paneOreBtnBordCenFlow_1.add(btnOre5);
		btnOre5.setIcon(new ImageIcon(MineStone.class.getResource("/img/wood.png")));
		btnOre5.addActionListener(this);
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
		
		paneHpBordSouthBord_1 = new JPanel();
		paneOreAndHpBord_5.add(paneHpBordSouthBord_1, BorderLayout.SOUTH);
		paneHpBordSouthBord_1.setLayout(new BorderLayout(0, 0));
		dao = new ClickerDAO();
						
		paneHpBordSouthBord_1.add(oreHpBar5);
		oreHpBar5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		

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
