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

public class MineSteel extends JFrame implements ActionListener {

	private JPanel mainPanel, contentPane;
	private Pickax pick;
	private Ore steel1;
	private Ore steel2;
	private Ore steel3;
	private Ore steel4;
	private Ore steel5;
	private JButton btnSteel1;
	private JButton btnSteel2;
	private JButton btnSteel3;
	private JButton btnSteel4;
	private JButton btnSteel5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MineSteel frame = new MineSteel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MineSteel() {
		pick = new Pickax();
		pick.infoPick();
		steel1 = new Steel();
		steel2 = new Steel();
		steel3 = new Steel();
		steel4 = new Steel();
		steel5 = new Steel();

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
		
		btnSteel1 = new JButton(steel1.name+" : "+steel1.hp);
		contentPane.add(btnSteel1);
		btnSteel1.addActionListener(this);
		
		btnSteel2 = new JButton(steel2.name+" : "+steel2.hp);
		contentPane.add(btnSteel2);
		btnSteel2.addActionListener(this);
		
		btnSteel3 = new JButton(steel3.name+" : "+steel3.hp);
		contentPane.add(btnSteel3);
		btnSteel3.addActionListener(this);
		
		btnSteel4 = new JButton(steel4.name+" : "+steel4.hp);
		contentPane.add(btnSteel4);
		btnSteel4.addActionListener(this);
		
		JButton back = new JButton("나가기");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect m = new MineSelect();
			}
		});
		contentPane.add(back);
		
		btnSteel5 = new JButton(steel5.name+" : "+steel5.hp);
		contentPane.add(btnSteel5);
		btnSteel5.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnSteel1) {
			hitsteel1();
		}
		if (e.getSource()==btnSteel2) {
			hitsteel2();
		}
		if (e.getSource()==btnSteel3) {
			hitsteel3();
		}
		if (e.getSource()==btnSteel4) {
			hitsteel4();
		}
		if (e.getSource()==btnSteel5) {
			hitsteel5();
		}
	}
	
	public void hitsteel1() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + steel1.hit(pick.atk()));
		btnSteel1.setText(steel1.name+" : "+ steel1.hp);
	}
	public void hitsteel2() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + steel2.hit(pick.atk()));
		btnSteel2.setText(steel2.name+" : " + steel2.hp);
	}
	public void hitsteel3() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + steel3.hit(pick.atk()));
		btnSteel3.setText(steel3.name+" : "+ steel3.hp);
	}
	public void hitsteel4() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + steel4.hit(pick.atk()));
		btnSteel4.setText(steel4.name+" : "+ steel4.hp);
	}
	public void hitsteel5() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + steel5.hit(pick.atk()));
		btnSteel5.setText(steel5.name+" : "+ steel5.hp);
	}
}
