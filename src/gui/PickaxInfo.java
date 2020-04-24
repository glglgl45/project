package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbguide.ClickerDAO;
import dbguide.ClickerItemVO;
import dbguide.ClickerUserVO;
import system.Pickax;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PickaxInfo extends JFrame{
	private JPanel contentPane;
	private JLabel lblNewLabel_1, lblNewLabel_3, lblNewLabel_5;
	private Pickax pick;
	
//	private ClickerDAO dao;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Pickax frame = new Pickax();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public PickaxInfo() {
		pick=new Pickax();
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("★곡괭이★");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel(pick.getPickName() + " +" + pick.getLevel());
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("★공격력★");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel(pick.getDmg()+"");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("★내구도★");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel(pick.getDura()+"");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_5);
	}
}
