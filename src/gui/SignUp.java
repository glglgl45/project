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
import javax.swing.JOptionPane;
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
				URL url = getClass().getResource("/img/main-demo.png");
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
	
	
	
	
	
	public class SignUp extends JFrame implements ActionListener{

		private JPanel contentPane;
		private JButton btnLogin;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField txtID;
		private JPasswordField passwordField;
		private JPasswordField passwordField1;
		private Pickax pick;
		private ClickerDAO dao;

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
	public SignUp() {
		pick = new Pickax();
		dao = new ClickerDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		
		JPanel backPanel = new BackImg1();
		contentPane.add(backPanel,BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(304, 244, 97, 35);
		backPanel.add(lblNewLabel);
		
		JButton btnSignUp = new JButton("회원가입");
		btnSignUp.setFont(new Font("굴림", Font.BOLD, 12));
		btnSignUp.setBounds(246, 477, 97, 23);
		backPanel.add(btnSignUp);
		
		
		txtID = new JTextField();
		txtID.setBounds(296, 284, 116, 21);
		backPanel.add(txtID);
		txtID.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(296, 351, 116, 21);
		backPanel.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_1.setBounds(293, 317, 128, 23);
		backPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호확인");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_2.setBounds(255, 385, 204, 35);
		backPanel.add(lblNewLabel_2);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(296, 430, 116, 21);
		backPanel.add(passwordField1);
		passwordField1.setColumns(10);
		setVisible(true);
		dao=new ClickerDAO();
		
		JButton btnBack = new JButton("돌아가기");
		btnBack.setFont(new Font("굴림", Font.BOLD, 12));
		btnBack.setBounds(380, 477, 97, 23);
		backPanel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage m = new MainPage();
			}
		});
//		backPanel.add(btnBack);
		
		btnSignUp.addActionListener(this);
		passwordField1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("회원가입") || e.getSource()==passwordField1) {		//회원가입 버튼 및 passwordField1에서 엔터 입력 시
			if(txtID.getText()!=null && 	//아이디, 비밀번호, 비밀번호 확인 칸의 입력상태 확인
					new String(passwordField.getPassword())!=null && 
					new String(passwordField1.getPassword())!=null) {	
				
				if(new String(passwordField.getPassword()).equals(new String(passwordField1.getPassword()))) {	//비밀번호-비밀번호 확인의 정보 비교
					ClickerUserVO vo = new ClickerUserVO();
					//초기 설정 값 (회원가입 시 DB에 입력될 초기 값)
					vo.setId(txtID.getText());	
					vo.setPwd(new String(passwordField.getPassword()));
					vo.setDurability(pick.getDura());
					vo.setEnhance(pick.getLevel());
					vo.setGold(pick.getMoney());
					vo.setPickLevel(pick.getPickLevel());
					vo.setScore(pick.getScore());
					vo.setPickName(pick.getPickName());
					vo.setDamage(pick.getDmg());
					vo.setMul(pick.getMul());
					vo.setProgress(0);	//엔딩확인 초기값
					
					//txtID.setText("");	//테스트 중
					passwordField.setText("");
					passwordField1.setText("");						
					
					int result=dao.insertUser(vo);	//DB에 저장
					if(result>0) {	//DB에 INSERT 성공 시
						JOptionPane.showMessageDialog(this, "가입 완료");
						pick.setUserId(txtID.getText());
						MiddlePage mp = new MiddlePage();
					}else {
						JOptionPane.showMessageDialog(this, "아이디 중복");
					}				
				}else if(!(new String(passwordField.getPassword()).equals(new String(passwordField1.getPassword())))) {	//비밀번호-비밀번호 확인 입력 정보 확인
					JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
				}				
			}else if(txtID.getText()==null || //아이디, 비밀번호, 비밀번호 확인의 빈칸 확인
					new String(passwordField.getPassword())==null || 
					new String(passwordField1.getPassword())==null) {
				JOptionPane.showMessageDialog(this, "정보를 모두 기입해 주세요");
			}
		}
	}
}
