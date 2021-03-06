package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import system.Pickax;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

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
		setTitle("광산에서 탈출하기");
		pick=new Pickax();
		setBounds(100, 100, 730, 250);
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
		
		JLabel lblImg = new JLabel();
		lblImg.setIcon(new ImageIcon(PickaxInfo.class.getResource(pick.pickImg())));
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		cent_panel_6.add(lblImg, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		east_panel_2.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("내구도");
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
		
		JLabel lblNewLabel_5 = new JLabel("곡괭이 이름");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		top_panel_4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("공격력");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		top_panel_4.add(lblNewLabel_7);
		
		JLabel lblName = new JLabel(pick.getPickName() + " +" + pick.getLevel());
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		top_panel_4.add(lblName);
		
		JLabel lblDmg = new JLabel((int)(pick.getDmg()*pick.getMul())+"");
		lblDmg.setHorizontalAlignment(SwingConstants.CENTER);
		top_panel_4.add(lblDmg);
		
		JPanel bot_panel_5 = new JPanel();
		cent_panel_3.add(bot_panel_5);
		bot_panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel txt = new JLabel();
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		bot_panel_5.add(txt, BorderLayout.CENTER);
		
		if(pick.getPickLevel()==1) {
			txt.setText("돌로 된 곡괭이. 돌 광석을 채광할 수 있다.");
			if(pick.getLevel()>=3) {
				txt.setText("돌로 된 곡괭이. 운이 좋다면 구리 광석을 채광할 수 있다.");
			}
		} else if(pick.getPickLevel()==2) {
			txt.setText("구리로 된 곡괭이. 구리 광석을 채광할 수 있다.");
			if(pick.getLevel()>=3) {
				txt.setText("구리로 된 곡괭이. 운이 좋다면 철 광석을 채광할 수 있다.");
			}
		} else if(pick.getPickLevel()==3) {
			txt.setText("철로 된 곡괭이. 철 광석을 채광할 수 있다.");
			if(pick.getLevel()==5) {
				txt.setText("철로 된 곡괭이. 운이 좋다면 티타늄 광석을 채광할 수 있다.");
			}
		} else if(pick.getPickLevel()==4) {
			txt.setText("티타늄으로 된 곡괭이. 티타늄 광석을 채광할 수 있다.");
			if(pick.getLevel()>=3) {
				txt.setText("티타늄으로 된 곡괭이. 운이 좋다면 다이아몬드 광석을 채광할 수 있다.");
			}
		} else if(pick.getPickLevel()==5) {
			txt.setText("다이아몬드로 된 곡괭이. 다이아몬드 광석을 채광할 수 있다. 진화의 마지막 단계");
			if(pick.getLevel()>=4) {
				txt.setText("다이아몬드로 된 곡괭이. 진화의 마지막 단계. 운이 좋다면 혹시...?");
			} else if(pick.getLevel()==5) {
				txt.setText("다이아몬드로 된 곡괭이. 진화의 마지막 단계. 이 정도라면...");
			}
		} 
		
//		JPanel bot_panel = new JPanel();
//		contentPane.add(bot_panel);
	}
}
