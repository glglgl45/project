package test;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MineStone extends JFrame implements ActionListener {

	private JPanel mainPanel, contentPane;
	private Pickax pick;
	private Ore stone1;
	private Ore stone2;
	private Ore stone3;
	private Ore stone4;
	private Ore stone5;
	private JButton btnStone1;
	private JButton btnStone2;
	private JButton btnStone3;
	private JButton btnStone4;
	private JButton btnStone5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MineStone frame = new MineStone();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MineStone() {
		pick = new Pickax();
		pick.infoPick();
		stone1 = new Stone();
		stone2 = new Stone();
		stone3 = new Stone();
		stone4 = new Stone();
		stone5 = new Stone();

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
		
		JButton btnNewButton_1 = new JButton("로그아웃");
		panel_0.add(btnNewButton_1, BorderLayout.EAST);
		
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
		
		btnStone1 = new JButton("돌 : 20");
		contentPane.add(btnStone1);
		btnStone1.addActionListener(this);
		
		btnStone2 = new JButton("돌 : 20");
		contentPane.add(btnStone2);
		btnStone2.addActionListener(this);
		
		btnStone3 = new JButton("돌 : 20");
		contentPane.add(btnStone3);
		btnStone3.addActionListener(this);
		
		btnStone4 = new JButton("돌 : 20");
		contentPane.add(btnStone4);
		btnStone4.addActionListener(this);
		
		JButton back = new JButton("나가기");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect m = new MineSelect();
			}
		});
		contentPane.add(back);
		
		btnStone5 = new JButton("돌 : 20");
		contentPane.add(btnStone5);
		btnStone5.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnStone1) {
			hitStone1();
		}
		if (e.getSource()==btnStone2) {
			hitStone2();
		}
		if (e.getSource()==btnStone3) {
			hitStone3();
		}
		if (e.getSource()==btnStone4) {
			hitStone4();
		}
		if (e.getSource()==btnStone5) {
			hitStone5();
		}
	}
	
	public void hitStone1() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + stone1.hit(pick.atk()));
		btnStone1.setText("돌 : " + stone1.hp);
	}
	public void hitStone2() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + stone2.hit(pick.atk()));
		btnStone2.setText("돌 : " + stone2.hp);
	}
	public void hitStone3() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + stone3.hit(pick.atk()));
		btnStone3.setText("돌 : " + stone3.hp);
	}
	public void hitStone4() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + stone4.hit(pick.atk()));
		btnStone4.setText("돌 : " + stone4.hp);
	}
	public void hitStone5() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + stone5.hit(pick.atk()));
		btnStone5.setText("돌 : " + stone5.hp);
	}
}
