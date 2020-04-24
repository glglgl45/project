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
	private ImageIcon img;
	
	private ClickerDAO dao;
	private ClickerUserVO vo;
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(dao.saveUser());
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
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MiddlePage.class.getResource("/gui/scroll2.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MiddlePage.class.getResource("/gui/scroll1.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		btnMine.setIcon(new ImageIcon(MiddlePage.class.getResource("/gui/mining.png")));
		panel.add(btnMine);
		
		JButton btnStore = new JButton("상점");
		btnStore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Store s = new Store();
				s.setVisible(true);
			}
		});
		btnStore.setIcon(new ImageIcon(MiddlePage.class.getResource("/gui/shop.png")));
		panel.add(btnStore);
		int key=pick.getPickLevel();
		switch (key) {
		case 1:
			img=new ImageIcon(getClass().getResource("pickax-stone.png"));
			break;
		case 2:
			img=new ImageIcon(getClass().getResource("pickax-copper.png"));			
			break;
		case 3:
			img=new ImageIcon(getClass().getResource("pickax-steel.png"));
			break;
		case 4:
			img=new ImageIcon(getClass().getResource("pickax-platinum.png"));
			break;
		case 5:
			img=new ImageIcon(getClass().getResource("pickax-dia.png"));
			break;
		}
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.WEST);
		
		JLabel lblNewLabel_5 = new JLabel("ID : "+pick.getUserId());
		panel_3.add(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		

		JButton btnPickInfo = new JButton(pick.getPickName() + " +" + pick.getLevel());
		btnPickInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PickaxInfo pick = new PickaxInfo();
				
			}
		});

		//JButton btnNewButton1 = new JButton(pick.getPickName()+" +"+pick.getLevel());

		panel_4.add(btnPickInfo);
		
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
		panel_2.add(btnLogout, BorderLayout.EAST);
	}
}
