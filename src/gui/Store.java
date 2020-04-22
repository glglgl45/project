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
import dbguide.UserData;

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

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Store() {
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
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		Image image;
		JButton btnRepair = new JButton(new ImageIcon(getClass().getResource("repair.png")));
		btnRepair.setBorderPainted(false);
		btnRepair.setContentAreaFilled(false);
		btnRepair.setFocusPainted(false);
//		btnRepair.setBounds(220, 150, 220, 150);
//		btnRepair.setIcon(resizeIcon(getClass().getResource("repair.png"), btnRepair.getWidth() - offset, btnRepair.getHeight() - offset));
		panel_1.add(btnRepair);
		
		JButton btnNewButton_1 = new JButton("강화하기");
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnBack = new JButton("돌아가기");
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				dispose();
				MainPage m = new MainPage();
			}
		});
		panel_6.add(btnBack);
		
		JButton btnLogout = new JButton("로그아웃");
		panel_6.add(btnLogout);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("검이름(강화수치)");
		panel_5.add(lblNewLabel);
		
		txtItemName = new JTextField();
		txtItemName.setEditable(false);
		panel_5.add(txtItemName);
		txtItemName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("공격력");
		panel_5.add(lblNewLabel_1);
		
		txtAttack = new JTextField();
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
			
		}else if(e.getActionCommand().equals("돌아가기")) {
			
		}
	}
	
	public void storeInfo(ClickerUserVO userVO) {
		ClickerItemVO itemVO=dao.searchItem(userVO.getItemName());
		txtItemName.setText(userVO.getItemName()+"("+userVO.getCurrentEnhance()+")");
		txtDuribility.setText(userVO.getCurrentDurability()+"");
		txtAttack.setText(itemVO.getAttack()+"");
	}
}
