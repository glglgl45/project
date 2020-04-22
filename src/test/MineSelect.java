package test;

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

import gui.MainPage;
import gui.MiddlePage;

public class MineSelect extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
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
		panel.add(btnLogout, BorderLayout.EAST);
		
		JButton btnNewButton_2 = new JButton("점수 : 999999");
		panel.add(btnNewButton_2, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("ID : 아이디");
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("소지금 : 9999");
		panel_1.add(lblNewLabel_1, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("돌 곡괭이 +3 내구도 : 100");
		panel_1.add(btnNewButton, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(2, 3, 0, 0));
		
		JButton btnMineStone = new JButton("돌 광산");
		btnMineStone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineStone ms = new MineStone();
			}
		});
		panel_2.add(btnMineStone);
		
		JButton btnMineCopper = new JButton("구리 광산");
		btnMineCopper.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineCopper mc = new MineCopper();
			}
		});
		panel_2.add(btnMineCopper);
		
		JButton btnMineIron = new JButton("철 광산");
		panel_2.add(btnMineIron);
		btnMineIron.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineIron mc = new MineIron();
			}
		});
		JButton btnMineTitanium = new JButton("티타늄 광산");
		panel_2.add(btnMineTitanium);
		btnMineTitanium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineTitanium mc = new MineTitanium();
			}
		});
		
		JButton btnBack = new JButton("뒤로가기");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MiddlePage mp = new MiddlePage();
			}
		});
		panel_2.add(btnBack);
		
		JButton btnMineDiamond = new JButton("다이아몬드 광산");
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

}
