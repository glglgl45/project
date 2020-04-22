package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
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

public class Store extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	private ClickerDAO dao;
	private JTextField txtItemName;
	private JTextField txtAttack;
	private JTextField txtDuribility;
	private Pickax pick;
	private Upgrade grade;

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

		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		
		dao=new ClickerDAO();
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 1, 0, 0));
		
		Image image;
		JButton btnRepair = new JButton(new ImageIcon(getClass().getResource("repair.png")));
		btnRepair.setBorderPainted(false);
		btnRepair.setContentAreaFilled(false);
		btnRepair.setFocusPainted(false);
		panel_1.add(btnRepair);
		
		JButton btnEvol = new JButton("진화하기");
		panel_1.add(btnEvol);
		btnEvol.addActionListener(this);
		
		JButton btnUpgrade = new JButton("강화하기");
		panel_1.add(btnUpgrade);
		btnUpgrade.addActionListener(this);
		
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
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				dispose();
				MiddlePage m = new MiddlePage();
			}
		});
		panel_6.add(btnBack);
		
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
		panel_6.add(btnLogout);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("아이디");
		panel_7.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		panel_7.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("소지금");
		panel_7.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		panel_7.add(lblNewLabel_6);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("곡괭이 이름\n(강화수치)");
		panel_5.add(lblNewLabel);
		
		txtItemName = new JTextField();
		txtItemName.setEditable(false);
		panel_5.add(txtItemName);
		txtItemName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("공격력");
		panel_5.add(lblNewLabel_1);
		
		txtAttack = new JTextField(pick.getDmg());
		txtAttack.setEditable(false);
		panel_5.add(txtAttack);
		txtAttack.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("내구도");
		panel_5.add(lblNewLabel_2);
		
		txtDuribility = new JTextField();
		txtDuribility.setEditable(false);
		panel_5.add(txtDuribility);
		txtDuribility.setColumns(10);
		
		btnLogout.addActionListener(this);
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("로그아웃")) {
			
		}
		if(e.getActionCommand().equals("돌아가기")) {
			
		}
		if(e.getActionCommand().equals("진화하기")) {
			grade.evol();
		}
		if(e.getActionCommand().equals("강화하기")) {
			grade.upgrade();
		}
	}
	public void storeInfo(ClickerUserVO userVO) {
		ClickerItemVO itemVO=dao.searchItem(userVO.getItemName());
		txtItemName.setText(userVO.getItemName()+"("+userVO.getCurrentEnhance()+")");
		txtDuribility.setText(userVO.getCurrentDurability()+"");
		txtAttack.setText(itemVO.getAttack()+"");
	}
}
