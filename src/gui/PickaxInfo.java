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
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;

public class PickaxInfo extends JFrame{
	private JPanel contentPane;
	private Pickax pick;
	
//	private ClickerDAO dao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pickax frame = new Pickax();
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
	//곡괭이 정보 창 크기
	public PickaxInfo() {
		pick=new Pickax();
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel top_panel = new JPanel();
		contentPane.add(top_panel);
		top_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel east_panel_2 = new JPanel();
		top_panel.add(east_panel_2, BorderLayout.WEST);
		east_panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel cent_panel_6 = new JPanel();
		east_panel_2.add(cent_panel_6, BorderLayout.CENTER);
		cent_panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(null);
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		cent_panel_6.add(lblImg, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		east_panel_2.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("★내구도★");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		JLabel lblDura = new JLabel(pick.getDura()+"");
		lblDura.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDura);
		
		
		JPanel cent_panel_3 = new JPanel();
		top_panel.add(cent_panel_3, BorderLayout.CENTER);
		cent_panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel top_panel_4 = new JPanel();
		cent_panel_3.add(top_panel_4);
		top_panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("★곡괭이 이름★");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		top_panel_4.add(lblNewLabel_5);
		
		JLabel lblName = new JLabel(pick.getPickName() + " +" + pick.getLevel());
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		top_panel_4.add(lblName);
		
		JLabel lblNewLabel_7 = new JLabel("★공격력★");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		top_panel_4.add(lblNewLabel_7);
		
		JLabel lblDmg = new JLabel(pick.getDmg()+"");
		lblDmg.setHorizontalAlignment(SwingConstants.CENTER);
		top_panel_4.add(lblDmg);
		
		JPanel bot_panel_5 = new JPanel();
		cent_panel_3.add(bot_panel_5);
		bot_panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		bot_panel_5.add(lblNewLabel_4, BorderLayout.CENTER);
		
		JPanel bot_panel = new JPanel();
		contentPane.add(bot_panel);
	}
}
