package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

class BackImg extends JPanel {
	
	private BufferedImage img;
	
	public BackImg() {
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

public class MainPage extends JFrame {

	private JPanel contentPane;
	private JButton btnLogin, btnSignUp, btnEnd;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel backPanel = new BackImg();
		contentPane.add(backPanel,BorderLayout.CENTER);
		pack();
		
		btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l = new Login();
			}
		});
		btnLogin.setBounds(227, 270, 250, 50);
//		btnLogin.setBorderPainted(false);
		btnLogin.setFocusPainted(false);
//		btnLogin.setContentAreaFilled(false);
		backPanel.add(btnLogin);
		
		btnSignUp = new JButton("회원가입");
		btnSignUp.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		btnSignUp.setBounds(227, 356, 250, 50);
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SignUp s = new SignUp();
			}
		});
		backPanel.add(btnSignUp);
		
		btnEnd = new JButton("게임종료");
		btnEnd.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		btnEnd.setBounds(227, 440, 250, 50);
		btnEnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		backPanel.add(btnEnd);
		
		setVisible(true);
	}
}
