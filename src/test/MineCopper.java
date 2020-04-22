package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.MainPage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MineCopper extends JFrame implements ActionListener{

	private JPanel mainPanel, contentPane;
	private Pickax pick;
	private Ore copper1;
	private Ore copper2;
	private Ore copper3;
	private Ore copper4;
	private Ore copper5;
	private JButton btnCopper1;
	private JButton btnCopper2;
	private JButton btnCopper3;
	private JButton btnCopper4;
	private JButton btnCopper5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MineCopper frame = new MineCopper();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MineCopper() {
		pick = new Pickax();
		pick.infoPick();
		copper1 = new Copper();
		copper2 = new Copper();
		copper3 = new Copper();
		copper4 = new Copper();
		copper5 = new Copper();

		setBounds(100, 100, 450, 300);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		contentPane = new JPanel();
		mainPanel.add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new GridLayout(2, 3, 0, 0));
		setVisible(true);
		
		JPanel panel_0 = new JPanel();
		mainPanel.add(panel_0, BorderLayout.NORTH);
		panel_0.setLayout(new BorderLayout(0, 0));
		
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
		panel_0.add(btnLogout, BorderLayout.EAST);
		
		JButton btnNewButton_2 = new JButton("점수 : 999999");
		panel_0.add(btnNewButton_2, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		mainPanel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("ID : 아이디");
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("소지금 : 9999");
		panel_1.add(lblNewLabel_1, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("돌 곡괭이 +3 내구도 : 100");
		panel_1.add(btnNewButton, BorderLayout.CENTER);
		
		btnCopper1 = new JButton(copper1.name + " : " + copper1.hp);
		contentPane.add(btnCopper1);
		btnCopper1.addActionListener(this);
		
		btnCopper2 = new JButton(copper2.name + " : " + copper2.hp);
		contentPane.add(btnCopper2);
		btnCopper2.addActionListener(this);
		
		btnCopper3 = new JButton(copper3.name + " : " + copper3.hp);
		contentPane.add(btnCopper3);
		btnCopper3.addActionListener(this);
		
		btnCopper4 = new JButton(copper4.name + " : " + copper4.hp);
		contentPane.add(btnCopper4);
		btnCopper4.addActionListener(this);
		
		JButton back = new JButton("나가기");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect m = new MineSelect();
			}
		});
		contentPane.add(back);
		
		btnCopper5 = new JButton(copper5.name + " : " + copper5.hp);
		contentPane.add(btnCopper5);
		btnCopper5.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnCopper1) {
			hitCopper1();
		}
		if (e.getSource()==btnCopper2) {
			hitCopper2();
		}
		if (e.getSource()==btnCopper3) {
			hitCopper3();
		}
		if (e.getSource()==btnCopper4) {
			hitCopper4();
		}
		if (e.getSource()==btnCopper5) {
			hitCopper5();
		}
	}
	
	public void hitCopper1() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + copper1.hit(pick.atk()));
		btnCopper1.setText(copper1.name + " : " + copper1.hp);
	}
	public void hitCopper2() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + copper2.hit(pick.atk()));
		btnCopper2.setText(copper2.name + " : " + copper2.hp);
	}
	public void hitCopper3() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + copper3.hit(pick.atk()));
		btnCopper3.setText(copper3.name + " : " + copper3.hp);
	}
	public void hitCopper4() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + copper4.hit(pick.atk()));
		btnCopper4.setText(copper4.name + " : " + copper4.hp);
	}
	public void hitCopper5() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + copper5.hit(pick.atk()));
		btnCopper5.setText(copper5.name + " : " + copper5.hp);
	}
}
