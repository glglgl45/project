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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dbguide.ClickerDAO;
import dbguide.ClickerUserVO;
import system.Pickax;
import java.awt.Font;
import javax.swing.JPasswordField;


	
	class BackImg1 extends JPanel {
		
		private JPanel ContentPane;
		
		private ClickerDAO dao;
		private Pickax pick;
		private ClickerUserVO vo;
		
		private BufferedImage img;
		
		public BackImg1() {
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
	
	
	
	
	
	public class Login extends JFrame implements ActionListener {

		private JPanel contentPane;
		private JButton btnLogin;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField txtId;
		private JPasswordField txtPw;

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
	public Login() {
		Pickax pick = new Pickax();
		ClickerDAO dao = new ClickerDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		
		JPanel backPanel = new BackImg1();
		contentPane.add(backPanel,BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(304, 255, 97, 35);
		backPanel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 12));
		btnNewButton.setBounds(246, 477, 97, 23);
		backPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("돌아가기");
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 12));
		btnNewButton_1.setBounds(380, 477, 97, 23);
		backPanel.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage m = new MainPage();
			}
		});
		
		txtId = new JTextField();
		txtId.setBounds(296, 300, 116, 21);
		backPanel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_1.setBounds(296, 351, 128, 23);
		backPanel.add(lblNewLabel_1);
		
		txtPw = new JPasswordField();
		txtPw.setBounds(304, 389, 105, 21);
		backPanel.add(txtPw);
		setVisible(true);
		dao=new ClickerDAO();
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		
		ClickerDAO dao = new ClickerDAO();
		ClickerUserVO vo = dao.searchUser(txtId.getText());	//DB에 없는 아이디 입력 시 에러 발생  처리방법 필요

		if(e.getActionCommand().equals("로그인") || e.getSource()==txtPw) {
			if(((ClickerUserVO) vo).getId().equals(txtId.getText()) && ((ClickerUserVO) vo).getPwd().equals(new String(txtPw.getPassword()))) {		
				Pickax pick = new Pickax();
				pick.setUserId(txtId.getText());
				vo=dao.searchUser(txtId.getText());
				pick.setMoney(((ClickerUserVO) vo).getGold());	
				pick.setDmg(((ClickerUserVO) vo).getDamage());
				pick.setDura(((ClickerUserVO) vo).getDurability());
				pick.setLevel(((ClickerUserVO) vo).getEnhance());
				pick.setMul(((ClickerUserVO) vo).getMul());
				pick.setPickName(((ClickerUserVO) vo).getPickName());
				pick.setScore(((ClickerUserVO) vo).getScore());
				pick.setPickLevel(((ClickerUserVO) vo).getPickLevel());
				dispose();
			//	MiddlePage mp = new MiddlePage();
			}else {
				JOptionPane.showMessageDialog(this, "로그인 정보를 확인해 주세요.");
			}
		}
	}
}
