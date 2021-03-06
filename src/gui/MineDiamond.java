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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.Color;

public class MineDiamond extends JFrame implements ActionListener, MouseListener {

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
	
	private ImageIcon icon;

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
		setTitle("광산에서 탈출하기");
		pick = new Pickax();
		pick.infoPick();
		pick.setScore(pick.getScore()-pick.getPickLevel()*5);
		ore1= new Diamond();
		ore2= new Diamond();
		ore3= new Diamond();
		ore4= new Diamond();
		ore5 = new DiamondWall();
		oreHpBar1 = new HpBar();
		oreHpBar2 = new HpBar();
		oreHpBar3 = new HpBar();
		oreHpBar4 = new HpBar();
		oreHpBar5 = new HpBar();
		dao = new ClickerDAO();
		icon = new ImageIcon(MineDiamond.class.getResource("/img/bckimg/diamine.jpg"));
		
		setDefaultCloseOperation(dao.saveUser());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 650);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
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
					MainPage m = new MainPage();
					m.setVisible(true);
					dispose();
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
		paneOreAndHpBord.setBounds(50, 60, 133, 119);
		paneCen1Ab.add(paneOreAndHpBord);
		paneOreAndHpBord.setLayout(new BorderLayout(0, 0));
		
		paneOreBtnBordCenFlow = new JPanel();
		paneOreAndHpBord.add(paneOreBtnBordCenFlow, BorderLayout.CENTER);
		btnOre1= new JButton();
		btnOre1.setIcon(ore1.OreImg());
		btnOre1.addActionListener(this);
		paneOreBtnBordCenFlow.add(btnOre1);
		transBtn(btnOre1);
		paneOreBtnBordCenFlow.setOpaque(false);
		paneOreAndHpBord.setOpaque(false);
		paneCen1Ab.setOpaque(false);
		
		paneHpBordSouthBord = new JPanel();
		paneOreAndHpBord.add(paneHpBordSouthBord, BorderLayout.SOUTH);
		paneHpBordSouthBord.setLayout(new BorderLayout(0, 0));
						
		paneHpBordSouthBord.add(oreHpBar1);
		oreHpBar1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		paneCen2Ab = new JPanel();
		contentPane.add(paneCen2Ab);
		paneCen2Ab.setLayout(null);
		
		JPanel paneOreAndHpBord_2 = new JPanel();
		paneOreAndHpBord_2.setBounds(50, 60, 133, 119);
		paneCen2Ab.add(paneOreAndHpBord_2);
		paneOreAndHpBord_2.setLayout(new BorderLayout(0, 0));
		
		paneOreBtnBordCenFlow_1 = new JPanel();
		paneOreAndHpBord_2.add(paneOreBtnBordCenFlow_1, BorderLayout.CENTER);
		paneOreBtnBordCenFlow_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnOre2= new JButton();
		paneOreBtnBordCenFlow_1.add(btnOre2);
		btnOre2.setIcon(ore2.OreImg());
		btnOre2.addActionListener(this);
		btnOre2.setBorderPainted(false);
		btnOre2.setFocusPainted(false);
		btnOre2.setContentAreaFilled(false);
//		transBtn(btnOre2);
		paneOreBtnBordCenFlow_1.setOpaque(false);
		paneOreAndHpBord_2.setOpaque(false);
		paneCen2Ab.setOpaque(false); 
		
		paneHpBordSouthBord_1 = new JPanel();
		paneOreAndHpBord_2.add(paneHpBordSouthBord_1, BorderLayout.SOUTH);
		paneHpBordSouthBord_1.setLayout(new BorderLayout(0, 0));
						
		oreHpBar2 = new HpBar();
		paneHpBordSouthBord_1.add(oreHpBar2);
		oreHpBar2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		paneCen3Ab = new JPanel();
		contentPane.add(paneCen3Ab);
		paneCen3Ab.setLayout(null);
		
		JPanel paneOreAndHpBord_3 = new JPanel();
		paneOreAndHpBord_3.setBounds(50, 60, 133, 119);
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
		paneOreBtnBordCenFlow.setOpaque(false);
		paneOreAndHpBord_3.setOpaque(false);
		paneCen3Ab.setOpaque(false);
		
		paneHpBordSouthBord = new JPanel();
		paneOreAndHpBord_3.add(paneHpBordSouthBord, BorderLayout.SOUTH);
		paneHpBordSouthBord.setLayout(new BorderLayout(0, 0));
						
		oreHpBar3 = new HpBar();
		paneHpBordSouthBord.add(oreHpBar3);
		oreHpBar3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		paneCen4Ab = new JPanel();
		contentPane.add(paneCen4Ab);
		paneCen4Ab.setLayout(null);
		
		JPanel paneOreAndHpBord_4 = new JPanel();
		paneOreAndHpBord_4.setBounds(50, 60, 133, 119);
		paneCen4Ab.add(paneOreAndHpBord_4);
		paneOreAndHpBord_4.setLayout(new BorderLayout(0, 0));
		
		paneOreBtnBordCenFlow = new JPanel();
		paneOreAndHpBord_4.add(paneOreBtnBordCenFlow, BorderLayout.CENTER);
		paneOreBtnBordCenFlow.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnOre4= new JButton();
		paneOreBtnBordCenFlow.add(btnOre4);
		btnOre4.setIcon(ore4.OreImg());
		btnOre4.addActionListener(this);

		transBtn(btnOre4);
		paneOreBtnBordCenFlow.setOpaque(false);
		paneOreAndHpBord_4.setOpaque(false);
		paneCen4Ab.setOpaque(false);
		
		paneHpBordSouthBord = new JPanel();
		paneOreAndHpBord_4.add(paneHpBordSouthBord, BorderLayout.SOUTH);
		paneHpBordSouthBord.setLayout(new BorderLayout(0, 0));
						
		oreHpBar4 = new HpBar();
		paneHpBordSouthBord.add(oreHpBar4);
		oreHpBar4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		paneCen5Ab = new JPanel();
		contentPane.add(paneCen5Ab);
		paneCen5Ab.setLayout(null);
		
		JButton back = new JButton("");
		back.setBounds(30, 65, 172, 108);
		paneCen5Ab.add(back);
		transBtn(back);
		paneCen5Ab.setOpaque(false);
		back.setIcon(new ImageIcon(MineDiamond.class.getResource("/img/door.png")));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MineSelect m = new MineSelect();
				dispose();
			}
		});
		
		paneCen6Ab = new JPanel();
		contentPane.add(paneCen6Ab);
		paneCen6Ab.setLayout(null);
		
		JPanel paneOreAndHpBord_5 = new JPanel();
		paneOreAndHpBord_5.setBounds(0, 45, 243, 181);
		paneCen6Ab.add(paneOreAndHpBord_5);
		paneOreAndHpBord_5.setLayout(new BorderLayout(0, 0));
		
		paneOreBtnBordCenFlow_1 = new JPanel();
		paneOreAndHpBord_5.add(paneOreBtnBordCenFlow_1, BorderLayout.CENTER);
		paneOreBtnBordCenFlow_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnOre5= new JButton();
		paneOreBtnBordCenFlow_1.add(btnOre5);
		transBtn(btnOre5);
		paneOreBtnBordCenFlow_1.setOpaque(false);
		paneOreAndHpBord_5.setOpaque(false);
		paneCen4Ab.setOpaque(false);
		paneCen6Ab.setOpaque(false);
		btnOre5.setIcon(ore5.OreImg());
		btnOre5.addActionListener(this);
		
		paneHpBordSouthBord_1 = new JPanel();
		paneOreAndHpBord_5.add(paneHpBordSouthBord_1, BorderLayout.SOUTH);
		paneHpBordSouthBord_1.setLayout(new BorderLayout(0, 0));
						
		oreHpBar5 = new HpBar();
		paneHpBordSouthBord_1.add(oreHpBar5);
		oreHpBar5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnOre1.addMouseListener(this);
		btnOre2.addMouseListener(this);
		btnOre3.addMouseListener(this);
		btnOre4.addMouseListener(this);
		btnOre5.addMouseListener(this);
		back.addMouseListener(this);

		btnOre1.setCursor(pick.cursor());
		btnOre2.setCursor(pick.cursor());
		btnOre3.setCursor(pick.cursor());
		btnOre4.setCursor(pick.cursor());
		btnOre5.setCursor(pick.cursor());
		back.setCursor(pick.exitCursor());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnOre1) {
			hitOre(ore1,oreHpBar1,btnOre1);
			if(ore1.hp==0) {
				btnOre1.setIcon(new ImageIcon(MineStone.class.getResource("/img/ore/diamondBroken.png")));
			}
		}
		if (e.getSource()==btnOre2) {
			hitOre(ore2,oreHpBar2,btnOre2);
			if(ore2.hp==0) {
				btnOre2.setIcon(new ImageIcon(MineStone.class.getResource("/img/ore/diamondBroken.png")));
			}
		}
		if (e.getSource()==btnOre3) {
			hitOre(ore3,oreHpBar3,btnOre3);
			if(ore3.hp==0) {
				btnOre3.setIcon(new ImageIcon(MineStone.class.getResource("/img/ore/diamondBroken.png")));
			}
		}
		if (e.getSource()==btnOre4) {
			hitOre(ore4,oreHpBar4,btnOre4);
			if(ore4.hp==0) {
				btnOre4.setIcon(new ImageIcon(MineStone.class.getResource("/img/ore/diamondBroken.png")));
			}
		}
		if (e.getSource()==btnOre5) {
			hitOre(ore5,oreHpBar5,btnOre5);
			if(ore5.hp==0) {
				dao.saveEndUser();
				GameClear gc = new GameClear();
				dispose();				
			}
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
	// 버튼 투명화 메소드
	public void transBtn(JButton btn) {
		btn.setBorderPainted(false); // 버튼 테두리 투명화
		btn.setFocusPainted(false); // 버튼 클릭시 포커스 투명화
		btn.setContentAreaFilled(false); // 버튼 배경색 투명화
		// 상위 패널 또한 패널.setOpaque(false); 를 설정
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		btnOre1.setCursor(pick.click());
		btnOre2.setCursor(pick.click());
		btnOre3.setCursor(pick.click());
		btnOre4.setCursor(pick.click());
		btnOre5.setCursor(pick.click());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		btnOre1.setCursor(pick.cursor());
		btnOre2.setCursor(pick.cursor());
		btnOre3.setCursor(pick.cursor());
		btnOre4.setCursor(pick.cursor());
		btnOre5.setCursor(pick.cursor());
	}
}
