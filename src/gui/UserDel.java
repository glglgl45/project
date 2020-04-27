package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dbguide.ClickerDAO;
import dbguide.ClickerUserVO;
import system.Pickax;
	
	class BackImg2 extends JPanel {
		
		private JPanel ContentPane;
		
		private Pickax pick;
	
		private JButton btnBack;
		
		private BufferedImage img;
		
		private ClickerUserVO vo;
		
		public BackImg2() {
			setLayout(null);
			try {
				URL url = getClass().getResource("main-demo.png");
				img = ImageIO.read(new File(url.getFile()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, null);
		}
		
		@Override
		public Dimension getPreferredSize() {
			if(img==null) {
				return new Dimension(100, 100);
			}
			return new Dimension(img.getWidth(), img.getHeight());
		}
	}
	
	public class UserDel extends JFrame implements ActionListener{

		private JPanel contentPane;
		private JButton btnUserDel;
		private JLabel lblID, lblPw;
		private JTextField txtId;
		private JPasswordField txtPw;
		private Pickax pick;
		private ClickerDAO dao;

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UserDel frame = new UserDel();
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
	public UserDel() {
		pick = new Pickax();
		dao = new ClickerDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		JPanel backPanel = new BackImg2();
		contentPane.add(backPanel,BorderLayout.CENTER);
		
		lblID = new JLabel("아이디");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblID.setBounds(230, 272, 97, 35);
		backPanel.add(lblID);
		
		txtId = new JTextField();
		txtId.setBounds(368, 275, 120, 30);
		backPanel.add(txtId);
		txtId.setColumns(10);
		
		lblPw = new JLabel("비밀번호");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblPw.setBounds(215, 332, 128, 35);
		backPanel.add(lblPw);
		
		txtPw = new JPasswordField();
		txtPw.setBounds(368, 337, 120, 30);
		backPanel.add(txtPw);
		txtPw.setColumns(10);
		
		setVisible(true);
		
		btnUserDel = new JButton("회원삭제");
		btnUserDel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnUserDel.setBounds(230, 427, 110, 30);
		backPanel.add(btnUserDel);
		
		JButton btnBack = new JButton("돌아가기");
		btnBack.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnBack.setBounds(368, 427, 110, 30);
		backPanel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage m = new MainPage();
			}
		});
		
		btnUserDel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
