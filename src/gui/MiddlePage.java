package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbguide.ClickerDAO;
import dbguide.ClickerUserVO;
import system.Pickax;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.CardLayout;
import javax.swing.JRadioButton;
import java.awt.Color;

public class MiddlePage extends JFrame {

	private Pickax pick;
	
	private JPanel contentPane;
	private ImageIcon img;
	
	private ClickerDAO dao;
	private ClickerUserVO vo;
	
	private ButtonGroup btnGroup;
	private JRadioButton radio1, radio2, radio3, radio4, radio5;
	
	private ImageIcon icon;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiddlePage frame = new MiddlePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MiddlePage() {
		pick = new Pickax();
		dao=new ClickerDAO();
		icon = new ImageIcon(MineDiamond.class.getResource("/bckimg/middlepg.jpg"));
		//창 크기 조절
		setDefaultCloseOperation(dao.saveUser());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 650);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);		
		//창 중간에 패널 넣기
		JPanel paneCenGrid = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		contentPane.add(paneCenGrid, BorderLayout.CENTER);
		paneCenGrid.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel paneCenTop = new JPanel();
		paneCenGrid.add(paneCenTop);
		paneCenTop.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		paneCenTop.add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		

		radio1 = new JRadioButton();
		radio2 = new JRadioButton();
		radio3 = new JRadioButton();
		radio4 = new JRadioButton();
		radio5 = new JRadioButton();

		panel_8.add(radio1);
		panel_8.add(radio2);
		panel_8.add(radio3);
		panel_8.add(radio4);
		panel_8.add(radio5);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		paneCenTop.add(panel, BorderLayout.CENTER);
		

		JPanel paneCenBot = new JPanel();
		paneCenBot.setOpaque(false);
		JPanel panel_6 = new JPanel();
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(298, 81, 67, 25);
		panel_6.add(panel_9);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_9.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(MiddlePage.class.getResource("/img/scrollmid.jpg")));
		lblNewLabel_1.setBounds(0, 0, 674, 207);
		panel_6.add(lblNewLabel_1);
		
		paneCenGrid.add(paneCenBot);
		
		JButton btnMine = new JButton("");
		transBtn(btnMine);
		paneCenBot.add(btnMine);
		btnMine.addActionListener(new ActionListener() {
			@Override//광산 버튼 누를시 광산 창으로 연결
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect ms = new MineSelect();
			}
		});
		btnMine.setIcon(new ImageIcon(MiddlePage.class.getResource("/img/mine-cart.PNG")));
		//상점 버튼을 누를시 store으로 연결
		JButton btnStore = new JButton("");
		transBtn(btnStore);
		paneCenBot.add(btnStore);
		btnStore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Store s = new Store();
				s.setVisible(true);
			}
		});
		btnStore.setIcon(new ImageIcon(MiddlePage.class.getResource("/img/blacksmithing.PNG")));
		// pickLevel에 따른 곡괭이 이미지 변경
		int key=pick.getPickLevel();
		switch (key) {
		case 1:
			img=new ImageIcon(getClass().getResource("/img/pickax-stone.png"));
			break;
		case 2:
			img=new ImageIcon(getClass().getResource("/img/pickax-copper.png"));			
			break;
		case 3:
			img=new ImageIcon(getClass().getResource("/img/pickax-steel.png"));
			break;
		case 4:
			img=new ImageIcon(getClass().getResource("/img/pickax-platinum.png"));
			break;
		case 5:
			img=new ImageIcon(getClass().getResource("/img/pickax-dia.png"));
			break;
		}
		
		JPanel paneBot = new JPanel();
		contentPane.add(paneBot, BorderLayout.SOUTH);
		paneBot.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		paneBot.add(panel_3, BorderLayout.WEST);
		//아이디를 표시
		JLabel lblNewLabel_5 = new JLabel("ID : "+pick.getUserId());
		panel_3.add(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		paneBot.add(panel_4, BorderLayout.CENTER);
		

		JButton btnNewButton1 = new JButton(pick.getPickName() + " +" + pick.getLevel());
		btnNewButton1.addActionListener(new ActionListener() {
			//곡괭이에 대한 정보 표시
			@Override
			public void actionPerformed(ActionEvent e) {
				PickaxInfo pick = new PickaxInfo();
				
			}
		});

		//JButton btnNewButton1 = new JButton(pick.getPickName()+" +"+pick.getLevel());

		panel_4.add(btnNewButton1);
		// 곡괭이 내구도 표시
		JLabel lblNewLabel_3 = new JLabel("내구도 : ");
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(pick.getDura()+"");
		panel_4.add(lblNewLabel_4);
		
		JPanel panel_5 = new JPanel();
		paneBot.add(panel_5, BorderLayout.EAST);
		//아이디에 있는 소지금 표시
		JLabel lblNewLabel_6 = new JLabel("소지금 : ");
		panel_5.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(pick.getMoney()+"");
		panel_5.add(lblNewLabel_7);
		
		JPanel paneTop = new JPanel();
		contentPane.add(paneTop, BorderLayout.NORTH);
		paneTop.setLayout(new BorderLayout(0, 0));
		//왼쪽 상단에 있는 점수 표시
		JButton btnNewButton_1 = new JButton("점수 : " + pick.getScore());
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.addActionListener(new ActionListener() {
			//랭킹 점수 클릭시 랭킹점수표시판으로 연결
			@Override
			public void actionPerformed(ActionEvent e) {
				Ranking ranking = new Ranking();
				
			}
		});
		paneTop.add(btnNewButton_1, BorderLayout.WEST);
		//로그아웃 버큰 누를시 게임 종료 창 연결
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
		paneTop.add(btnLogout, BorderLayout.EAST);
	}
	

	// 버튼 투명화 메소드
	public void transBtn(JButton btn) {
		btn.setBorderPainted(false); // 버튼 테두리 투명화
		btn.setFocusPainted(false); // 버튼 클릭시 포커스 투명화
		btn.setContentAreaFilled(false); // 버튼 배경색 투명화
		// 상위 패널 또한 패널.setOpaque(false); 를 설정
	}



}
