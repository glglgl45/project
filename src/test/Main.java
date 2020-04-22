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
	private static Pickax pick;
	private int mapNum = 0;
	private JButton btnNewButton;
	private JPanel centerPane1;

	public static void main(String[] args) {
		pick = new Pickax();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel topPane = new JPanel();
		contentPane.add(topPane, BorderLayout.NORTH);
		
		JPanel botPane = new JPanel();
		contentPane.add(botPane, BorderLayout.SOUTH);
		
		centerPane1 = new JPanel();
		contentPane.add(centerPane1, BorderLayout.CENTER);
		
		btnNewButton = new JButton("로그인");
		centerPane1.add(btnNewButton);
		btnNewButton.addActionListener(this);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("로그인")) {
			mapNum = 1;
			System.out.println("로그인 버튼");
			contentPane.remove(centerPane1);
		}
	}

}
