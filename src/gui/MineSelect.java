package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbguide.ClickerUserVO;
import gui.MainPage;
import system.Pickax;

public class MineSelect extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel, lblNewLabel_1;
	private JButton btnNewButton_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MineSelect frame = new MineSelect();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	public MineSelect() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Pickax pick = new Pickax();
		pick.infoPick();
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
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
		panel.add(btnLogout, BorderLayout.EAST);
		
		btnNewButton_2 = new JButton("점수 : " + pick.getScore());
		panel.add(btnNewButton_2, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("ID : 아이디");
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		
		lblNewLabel_1 = new JLabel("소지금 : "+pick.getMoney()+"");
		panel_1.add(lblNewLabel_1, BorderLayout.EAST);
		
<<<<<<< HEAD
		btnpi = new JButton("돌 곡괭이 +3 / 내구도 : 100");
		btnpi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PickaxInfo mc = new PickaxInfo();
			}
		});
		panel_1.add(btnpi, BorderLayout.CENTER);
=======
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("돌 곡괭이 0");
		panel_3.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("내구도 : ");
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(pick.getDura()+"");
		panel_3.add(lblNewLabel_3);
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(2, 3, 0, 0));
		
		JButton btnMineStone = new JButton("돌 광산");
		btnMineStone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineStone ms = new MineStone();
			}
		});
		panel_2.add(btnMineStone);
		
		JButton btnMineCopper = new JButton("구리 광산");
		btnMineCopper.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineCopper mc = new MineCopper();
			}
		});
		panel_2.add(btnMineCopper);
		
		JButton btnMineIron = new JButton("철 광산");
		panel_2.add(btnMineIron);
		btnMineIron.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineIron mc = new MineIron();
			}
		});
		JButton btnMineTitanium = new JButton("티타늄 광산");
		panel_2.add(btnMineTitanium);
		btnMineTitanium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineTitanium mc = new MineTitanium();
			}
		});
		
		JButton btnBack = new JButton("뒤로가기");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MiddlePage ud = new MiddlePage();
			}
		});
		panel_2.add(btnBack);
		
		JButton btnMineDiamond = new JButton("다이아몬드 광산");
		panel_2.add(btnMineDiamond);
		btnMineDiamond.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineDiamond mc = new MineDiamond();
			}
		});
		
		setVisible(true);
	}
	
	public void mineInfo(ClickerUserVO userVO) {
		lblNewLabel.setText("ID : "+userVO.getId());
		lblNewLabel_1.setText("소지금 : "+userVO.getGold()+"");
		btnNewButton_2.setText("점수 : "+userVO.getScore());
<<<<<<< HEAD
		btnpi.setText(userVO.getPickName()+" +"+userVO.getCurrentEnhance()+" 내구도 : "+userVO.getCurrentDurability());
=======
>>>>>>> branch 'master' of https://github.com/glglgl45/project.git
	}
}
