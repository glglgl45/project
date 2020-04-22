package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TestUp04221700 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Pickax pick;
	private Ore stone1;
	private JButton btnStone1;
	private Upgrade grade;
	private JButton btnUpgrade;
	private JButton btnEvol;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestUp04221700 frame = new TestUp04221700();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TestUp04221700() {
		pick = new Pickax();
		pick.infoPick();
		grade = new Upgrade();
		stone1 = new Stone();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnStone1 = new JButton(stone1.name + " : " + stone1.hp);
		contentPane.add(btnStone1);
		btnStone1.addActionListener(this);
		
		btnUpgrade = new JButton("강화하기");
		contentPane.add(btnUpgrade, BorderLayout.EAST);
		btnUpgrade.addActionListener(this);
		
		btnEvol = new JButton("진화하기");
		contentPane.add(btnEvol, BorderLayout.WEST);
		btnEvol.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnStone1) {
			hitStone1();
		}
		if (e.getActionCommand().equals("강화하기")) {
			grade.upgrade();
		}
		if(e.getActionCommand().equals("진화하기")) {
			grade.evol();
		}
	}
	
	public void hitStone1() {
		pick.infoPick();
		pick.setMoney(pick.getMoney() + stone1.hit(pick.atk()));
		btnStone1.setText(stone1.name + " : " + stone1.hp);
	}

}
