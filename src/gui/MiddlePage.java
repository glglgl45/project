package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbguide.ClickerDAO;
import dbguide.ClickerUserVO;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class MiddlePage extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2;

	private ClickerDAO dao;
	private ClickerUserVO userVO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiddlePage frame = new MiddlePage();
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
	public MiddlePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		dao=new ClickerDAO();
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnMine = new JButton("광산");
		btnMine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect ms = new MineSelect();
			}
		});
		btnMine.setIcon(new ImageIcon(MiddlePage.class.getResource("/gui/mining.png")));
		panel.add(btnMine);
		
		JButton btnStore = new JButton("상점");
		btnStore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Store s = new Store();
				userVO=dao.searchUser(lblNewLabel_1.getText());
				s.storeInfo(userVO);
				s.setVisible(true);
			}
		});
		btnStore.setIcon(new ImageIcon(MiddlePage.class.getResource("/gui/shop.png")));
		panel.add(btnStore);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JButton btnPickaxInfo = new JButton("곡괭이 정보");
		btnPickaxInfo.setIcon(new ImageIcon(MiddlePage.class.getResource("/gui/infi.png")));
		btnPickaxInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userVO=dao.searchUser(lblNewLabel_1.getText());
				PickaxInfo pic = new PickaxInfo();
				int result=dao.saveUser(userVO);
				if(result>0) {
					System.out.println("저장");
				}else {
					System.err.println("실패");
				}
				pic.itemInfo(userVO);
			}
		});
		panel.add(btnPickaxInfo);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
	}
	
	public void playInfo(ClickerUserVO userVO) {	
		lblNewLabel_1.setText(userVO.getId());
		lblNewLabel_2.setText(userVO.getGold()+"");
		int result=dao.saveUser(userVO);
		if(result>0) {
			System.out.println("저장");
		}else {
			System.out.println("실패");
		}
	}

}
