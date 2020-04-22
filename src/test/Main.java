package test;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Main extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Pickax pick;
	private Stone stone;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		pick = new Pickax();
		pick.initPick();
		pick.infoPick();
		stone = new Stone();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 3, 0, 0));
		
		JButton stone1 = new JButton("돌1");
		contentPane.add(stone1);
		stone1.addActionListener(this);
		
		JButton stone2 = new JButton("돌2");
		contentPane.add(stone2);
		stone2.addActionListener(this);
		
		JButton stone3 = new JButton("돌3");
		contentPane.add(stone3);
		stone3.addActionListener(this);
		
		JButton stone4 = new JButton("돌4");
		contentPane.add(stone4);
		stone4.addActionListener(this);
		
		JButton back = new JButton("나가기");
		contentPane.add(back);
		
		JButton stone5 = new JButton("돌5");
		contentPane.add(stone5);
		stone5.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("돌1")) {
			hitStone1();
		}
	}
	
	public void hitStone1() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + stone.hit(pick.atk()));
	}

}
