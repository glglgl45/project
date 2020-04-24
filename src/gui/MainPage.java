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
	private JButton btnLogin, btnSignUp;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
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
		
		
//		JPanel panel = new JPanel();
//		backPanel.add(panel, BorderLayout.CENTER);
//		 
//		JPanel panel_1 = new JPanel();
//		backPanel.add(panel_1, BorderLayout.SOUTH);
		
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l = new Login();
			}
		});
		btnLogin.setBounds(500, 500, 111, 111);
		backPanel.add(btnLogin);
		
		btnSignUp = new JButton("회원가입");
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SignUp s = new SignUp();
			}
		});
		backPanel.add(btnSignUp);
		setVisible(true);
	}
}
