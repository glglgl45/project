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

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class MiddlePage extends JFrame {

	private Pickax pick;
	
	private JPanel contentPane;
	private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2;

	private ClickerDAO dao;
	private ClickerUserVO userVO;
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

	/**
	 * Create the frame.
	 */
	public MiddlePage() {
		pick = new Pickax();
		dao=new ClickerDAO();
//		dao = pick
		pick.setMoney(userVO.getGold());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnMine = new JButton("광산");
		btnMine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect ms = new MineSelect();
				userVO=dao.searchUser(lblNewLabel_1.getText());
				ms.mineInfo(userVO);
			}
		});
		btnMine.setIcon(new ImageIcon(MiddlePage.class.getResource("/gui/mining.png")));
		panel.add(btnMine);
		
		JButton btnStore = new JButton("상점");
		btnStore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				userVO=dao.searchUser(lblNewLabel_1.getText());	
				Store s = new Store();
				s.storeInfo(userVO);
				s.setVisible(true);
			}
		});
		btnStore.setIcon(new ImageIcon(MiddlePage.class.getResource("/gui/shop.png")));
		panel.add(btnStore);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MiddlePage.class.getResource("/gui/pickax-dia.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JButton btnPickaxInfo = new JButton("곡괭이 정보");
		btnPickaxInfo.setIcon(new ImageIcon(MiddlePage.class.getResource("/gui/infi.png")));
		btnPickaxInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userVO=dao.searchUser(lblNewLabel_1.getText());
				PickaxInfo pic = new PickaxInfo();
				int result=dao.saveUser(userVO);
				if(result>0) {
					System.out.println("저장");
				}else {
					System.err.println("실패");
				}
//				pic.itemInfo(userVO);
			}
		});
		panel.add(btnPickaxInfo);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.WEST);
		
		JLabel lblNewLabel_5 = new JLabel("ID : 아이디");
		panel_3.add(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("돌곡괭이 0");
		panel_4.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("내구도 : ");
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(pick.getDura()+"");
		panel_4.add(lblNewLabel_4);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.EAST);
		
		JLabel lblNewLabel_6 = new JLabel("소지금 : ");
		panel_5.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(pick.getMoney()+"");
		panel_5.add(lblNewLabel_7);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_1 = new JButton("점수 : " + pick.getScore());
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(btnNewButton_1, BorderLayout.WEST);
		
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
		panel_2.add(btnLogout, BorderLayout.EAST);
	}
	
	public void playInfo(ClickerUserVO userVO) {	
		lblNewLabel_1.setText(userVO.getId());
		lblNewLabel_2.setText(userVO.getGold()+"");
		int result=dao.saveUser(userVO);
		if(result>0) {
			System.out.println("저장");
		}else {
			System.out.println("실패");
		}
	}
}
