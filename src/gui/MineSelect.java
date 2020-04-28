package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
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
import gui.MainPage;
import system.Pickax;
import javax.swing.ImageIcon;

public class MineSelect extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel, lblNewLabel_1;
	private JButton btnNewButton_2,btnpi;
	
	private Pickax pick;
	private ClickerDAO dao;
	private ClickerUserVO vo;
	private ImageIcon icon;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MineSelect frame = new MineSelect();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MineSelect() {
		dao=new ClickerDAO();
		pick = new Pickax();
		pick.infoPick();		
		icon = new ImageIcon(MineDiamond.class.getResource("/img/bckimg/mineselect.JPG"));
		
		setDefaultCloseOperation(dao.saveUser());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
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
		panel.add(btnLogout, BorderLayout.EAST);
		
		btnNewButton_2 = new JButton("점수 : " + pick.getScore());
		panel.add(btnNewButton_2, BorderLayout.WEST);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Ranking ranking = new Ranking();
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("ID : "+pick.getUserId());
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		
		lblNewLabel_1 = new JLabel("소지금 : "+pick.getMoney()+"");
		panel_1.add(lblNewLabel_1, BorderLayout.EAST);
		
		btnpi = new JButton("돌 곡괭이 +3 / 내구도 : 100");
		btnpi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PickaxInfo mc = new PickaxInfo();
			}
		});
		panel_1.add(btnpi, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton(pick.getPickName() + " +" + pick.getLevel());
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PickaxInfo mc = new PickaxInfo();
				
			}
		});
		panel_3.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("내구도 : ");
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(pick.getDura()+"");
		panel_3.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(2, 3, 0, 0));
		
		JButton btnMineStone = new JButton("돌 광산");
		btnMineStone.setIcon(new ImageIcon(MineSelect.class.getResource("/img/entrance/entrance-stone.png")));
		btnMineStone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineStone ms = new MineStone();
			}
		});

		transBtn(btnMineStone);
		panel_2.add(btnMineStone);
		
		JButton btnMineCopper = new JButton("구리 광산");
		transBtn(btnMineCopper);
		btnMineCopper.setIcon(new ImageIcon(MineSelect.class.getResource("/img/entrance/entrance-copper.png")));
		btnMineCopper.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineCopper mc = new MineCopper();
			}
		});
		panel_2.add(btnMineCopper);
		
		JButton btnMineIron = new JButton("철 광산");
		transBtn(btnMineIron);
		btnMineIron.setIcon(new ImageIcon(MineSelect.class.getResource("/img/entrance/entrance-iron.png")));
		panel_2.add(btnMineIron);
		btnMineIron.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineIron mc = new MineIron();
			}
		});
		JButton btnMineTitanium = new JButton("티타늄 광산");
		transBtn(btnMineTitanium);
		btnMineTitanium.setIcon(new ImageIcon(MineSelect.class.getResource("/img/entrance/entrance-titanium.png")));
		panel_2.add(btnMineTitanium);
		btnMineTitanium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineTitanium mc = new MineTitanium();
			}
		});
		
		JButton btnBack = new JButton("");
		transBtn(btnBack);
		btnBack.setIcon(new ImageIcon(MineSelect.class.getResource("/img/GTFO.png")));
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MiddlePage ud = new MiddlePage();
			}
		});
		panel_2.add(btnBack);
		
		JButton btnMineDiamond = new JButton("다이아몬드 광산");
		transBtn(btnMineDiamond);
		btnMineDiamond.setIcon(new ImageIcon(MineSelect.class.getResource("/img/entrance/entrance-diamond.png")));
		panel_2.add(btnMineDiamond);
		btnMineDiamond.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineDiamond mc = new MineDiamond();
			}
		});		
		setVisible(true);
	}
	
	// 버튼 투명화 메소드
	public void transBtn(JButton btn) {
		btn.setBorderPainted(false); // 버튼 테두리 투명화
		btn.setFocusPainted(false); // 버튼 클릭시 포커스 투명화
		btn.setContentAreaFilled(false); // 버튼 배경색 투명화
		// 상위 패널 또한 패널.setOpaque(false); 를 설정
	}


}
