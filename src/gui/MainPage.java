package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MainPage extends JFrame implements ActionListener {

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);
		panel_1.add(btnLogin);
		
		btnSignUp = new JButton("회원가입");
		btnSignUp.addActionListener(this);
		panel_1.add(btnSignUp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton btn = (JButton) e.getSource();
		if(btn==btnLogin) {
			Login l = new Login();
			
		}else if(btn==btnSignUp) {
			SignUp s = new SignUp();
		}
	}
}
