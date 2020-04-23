package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbguide.ClickerDAO;
import dbguide.ClickerItemVO;
import dbguide.ClickerUserVO;
import system.Pickax;
import system.Upgrade;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.CardLayout;

public class Store extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnRepair,btnEvol,btnUpgrade;
	
	private ClickerDAO dao;
	private JLabel lblNewLabel_4, lblNewLabel_6;
	private Pickax pick;
	private Upgrade grade;
	private JTextField txtPickDmg;
	private JTextField txtPickDura;
	private JTextField txtPickName;
	private JTextField txtLevel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Store frame = new Store();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Store() {
		pick = new Pickax();
		grade = new Upgrade();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);		
		
		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		
		dao=new ClickerDAO();
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new GridLayout(1, 1, 0, 0));
		
		btnRepair = new JButton(new ImageIcon(getClass().getResource("repair.png")));
		btnRepair.setBorderPainted(false);
		btnRepair.setFocusPainted(false);
//		btnRepair.setContentAreaFilled(false);
		panel_11.add(btnRepair);
		
		btnEvol = new JButton(new ImageIcon(getClass().getResource("evolve.PNG")));
		btnEvol.setFocusPainted(false);
		btnEvol.setBorderPainted(false);
		panel_11.add(btnEvol);
		
		btnUpgrade = new JButton(new ImageIcon(getClass().getResource("upgrade.png")));
		btnUpgrade.setFocusPainted(false);
		btnUpgrade.setBorderPainted(false);
		panel_11.add(btnUpgrade);
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("수리하기");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("진화하기");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("강화하기");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblNewLabel_9);
				
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnBack = new JButton("돌아가기");
		panel_6.add(btnBack);
		btnBack.addActionListener(this);
		
		JButton btnLogout = new JButton("로그아웃");
		panel_6.add(btnLogout);
		btnLogout.addActionListener(this);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("아이디");
		panel_7.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		panel_7.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("소지금");
		panel_7.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("New label");
		panel_7.add(lblNewLabel_6);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_5.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_9.add(panel_13);
		panel_13.setLayout(new GridLayout(1, 1, 0, 0));
		
		txtPickName = new JTextField();
		txtPickName.setEditable(false);
		txtPickName.setColumns(10);
		panel_13.add(txtPickName);
		
		txtLevel = new JTextField();
		txtLevel.setEditable(false);
		txtLevel.setColumns(10);
		panel_13.add(txtLevel);
		
		JLabel lblNewLabel = new JLabel("곡괭이 정보");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("공격력");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblNewLabel_1);
		
		txtPickDmg = new JTextField();
		txtPickDmg.setEditable(false);
		txtPickDmg.setColumns(10);
		panel_10.add(txtPickDmg);
		
		JPanel panel_12 = new JPanel();
		panel_5.add(panel_12);
		panel_12.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("내구도");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_12.add(lblNewLabel_2);
		
		txtPickDura = new JTextField();
		txtPickDura.setEditable(false);
		txtPickDura.setColumns(10);
		panel_12.add(txtPickDura);
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("로그아웃")) {
			ClickerUserVO userVO=dao.searchUser(lblNewLabel_4.getText());
			int result=dao.saveUser(userVO);
			if(result>0) {
//				JOptionPane.showMessageDialog(this, "저장 완료");
				String option[] = {"메인화면으로","게임 종료"};
				int qe=JOptionPane.showOptionDialog(getParent(), "로그아웃 후에 어떻게 할까요?", "Logout", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
				if(qe==0) {
					dispose();
					MainPage m = new MainPage();
					m.setVisible(true);
				}else if(result==1) {
					System.exit(0);
				}
			}
		}
		if(e.getActionCommand().equals("돌아가기")) {
			ClickerUserVO userVO=dao.searchUser(lblNewLabel_4.getText());
			int result=dao.saveUser(userVO);
			if(result>0) {
				System.out.println("저장");
				dispose();
				MiddlePage m = new MiddlePage();
			}
		}if(e.getSource()==btnRepair) {
			grade.fixPick();
		}
		if(e.getSource()==btnEvol) {
			grade.evol();
		}
		if(e.getSource()==btnUpgrade) {
			grade.upgrade();
		}
	}
	public void storeInfo(ClickerUserVO userVO) {
		ClickerItemVO itemVO=dao.searchItem(userVO.getPickName(), userVO.getCurrentEnhance());
		lblNewLabel_4.setText(userVO.getId());
		lblNewLabel_6.setText(userVO.getGold()+"");
		txtItemName.setText(userVO.getPickName()+"("+userVO.getCurrentEnhance()+")");
		txtDuribility.setText(userVO.getCurrentDurability()+"");
		txtAttack.setText(itemVO.getAttack()+"");
	}
}
