package test;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.MainPage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MineCopper extends JFrame implements ActionListener{

	private JPanel contentPane;
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
		pick.initPick();
		pick.infoPick();
		copper1 = new Copper();
		copper2 = new Copper();
		copper3 = new Copper();
		copper4 = new Copper();
		copper5 = new Copper();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(new GridLayout(2, 3, 0, 0));
		
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
