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
import system.Pickax;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Graphics;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;

public class MiddlePage extends JFrame implements ActionListener{

	private int pos = 1;
	private Pickax pick;
	
	private JPanel contentPane;
	private JPanel paneCenTop;
	
	private ClickerDAO dao;
	
	private ButtonGroup btnGroup;
	private JRadioButton radio1, radio2, radio3, radio4, radio5, radio6, radio7;

	private ImageIcon scroll1, scroll2, scroll3, scroll4, scroll5, scroll6, scroll7;
	private ImageIcon icon;
	
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
		setTitle("광산에서 탈출하기");
		pick = new Pickax();
		dao=new ClickerDAO();
		
		// 이미지 세팅
		icon = new ImageIcon(MiddlePage.class.getResource("/img/bckimg/middlepg.jpg"));
		scroll1 = new ImageIcon(MiddlePage.class.getResource("/img/scroll/scroll1.png"));
		scroll2 = new ImageIcon(MiddlePage.class.getResource("/img/scroll/scroll2.png"));
		scroll3 = new ImageIcon(MiddlePage.class.getResource("/img/scroll/scroll3.png"));
		scroll4 = new ImageIcon(MiddlePage.class.getResource("/img/scroll/scroll4.png"));
		scroll5 = new ImageIcon(MiddlePage.class.getResource("/img/scroll/scroll5.png"));
		scroll6 = new ImageIcon(MiddlePage.class.getResource("/img/scroll/scroll6.png"));
		scroll7 = new ImageIcon(MiddlePage.class.getResource("/img/scroll/scroll7.png"));
		
		//창 크기 조절
		setDefaultCloseOperation(dao.saveUser()); // 강제종료 시 계정 정보 저장
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
		
		paneCenTop = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				
				if(pos == 1) {
					g.drawImage(scroll1.getImage(), 0, 0, null);
				} else if(pos == 2) {
					g.drawImage(scroll2.getImage(), 0, 0, null);
				} else if(pos == 3) {
					g.drawImage(scroll3.getImage(), 0, 0, null);
				} else if(pos == 4) {
					g.drawImage(scroll4.getImage(), 0, 0, null);
				} else if(pos == 5) {
					g.drawImage(scroll5.getImage(), 0, 0, null);
				} else if(pos == 6) {
					g.drawImage(scroll6.getImage(), 0, 0, null);
				} else if(pos == 7) {
					g.drawImage(scroll7.getImage(), 0, 0, null);
				}
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		paneCenGrid.add(paneCenTop);
		paneCenTop.setLayout(new BorderLayout(0, 0));
		
		JPanel paneRadio = new JPanel();
		paneRadio.setBackground(Color.GREEN);
		paneCenTop.add(paneRadio, BorderLayout.SOUTH);
		paneRadio.setOpaque(false);
		
		JPanel paneRadioBtn = new JPanel();
		paneRadio.add(paneRadioBtn);
		paneRadioBtn.setOpaque(false);
		
		// 라디오 버튼 생성
		radio1 = new JRadioButton();
		radio2 = new JRadioButton();
		radio3 = new JRadioButton();
		radio4 = new JRadioButton();
		radio5 = new JRadioButton();
		radio6 = new JRadioButton();
		radio7 = new JRadioButton();
		
		// 기본 선택값 부여
		radio1.setSelected(true);

		// 라디오 버튼 리스너 추가
		radio1.addActionListener(this);
		radio2.addActionListener(this);
		radio3.addActionListener(this);
		radio4.addActionListener(this);
		radio5.addActionListener(this);
		radio6.addActionListener(this);
		radio7.addActionListener(this);
		
		// 라디오 버튼 투명화
		radio1.setOpaque(false);
		radio2.setOpaque(false);
		radio3.setOpaque(false);
		radio4.setOpaque(false);
		radio5.setOpaque(false);
		radio6.setOpaque(false);
		radio7.setOpaque(false);

		// 라디오 버튼 그룹화
		btnGroup = new ButtonGroup();
		btnGroup.add(radio1);
		btnGroup.add(radio2);
		btnGroup.add(radio3);
		btnGroup.add(radio4);
		btnGroup.add(radio5);
		btnGroup.add(radio6);
		btnGroup.add(radio7);

		paneRadioBtn.add(radio1);
		paneRadioBtn.add(radio2);
		paneRadioBtn.add(radio3);
		paneRadioBtn.add(radio4);
		paneRadioBtn.add(radio5);
		paneRadioBtn.add(radio6);
		paneRadioBtn.add(radio7);
		
		
		JPanel paneScroll = new JPanel();
		paneScroll.setBackground(Color.PINK);
		paneCenTop.add(paneScroll, BorderLayout.CENTER);
		paneScroll.setOpaque(false);

		JPanel paneCenBot = new JPanel();
		paneCenBot.setOpaque(false);
		
		paneCenGrid.add(paneCenBot);
		paneCenBot.setLayout(null);
		
		JButton btnMine = new JButton("");
		btnMine.setBounds(80, 5, 280, 258);
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
		btnStore.setBounds(354, 5, 257, 233);
		transBtn(btnStore);
		paneCenBot.add(btnStore);
		btnStore.setContentAreaFilled(false);
		btnStore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Store s = new Store();
				s.setVisible(true);
			}
		});
		btnStore.setIcon(new ImageIcon(MiddlePage.class.getResource("/img/blacksmithing.PNG")));
		
		JLabel lblNewLabel_2 = new JLabel("광산가기");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(171, 238, 108, 25);
		paneCenBot.add(lblNewLabel_2);
		
		JLabel lblNewLabel_8 = new JLabel("상점가기");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(437, 238, 94, 25);
		paneCenBot.add(lblNewLabel_8);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==radio1) {
			pos = 1;
			repaint();
		} else if(e.getSource()==radio2) {
			pos = 2;
			repaint();
		} else if(e.getSource()==radio3) {
			pos = 3;
			repaint();
		} else if(e.getSource()==radio4) {
			pos = 4;
			repaint();
		} else if(e.getSource()==radio5) {
			pos = 5;
			repaint();
		} else if(e.getSource()==radio6) {
			pos = 6;
			repaint();
		} else if(e.getSource()==radio7) {
			pos = 7;
			repaint();
		}
	}
}
