package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbguide.ClickerDAO;
import dbguide.ClickerUserVO;
import system.Pickax;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;

public class SignUp extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtID;
	private JPasswordField txtPW;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton btnSignUp, btnBack;
	private JTextField textField;
	
	private ClickerDAO dao;
	private Pickax pick;
	private ClickerUserVO vo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); -- x키 누르면 같이 꺼짐
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setVisible(true);
		setContentPane(contentPane);
		
		dao=new ClickerDAO();
		pick=new Pickax();
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("회원가입을 해주세요");
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		
		txtID = new JTextField();
		panel_1.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		panel_1.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("비밀번호 확인");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		
		passwordField_1 = new JPasswordField();
		panel_1.add(passwordField_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		btnSignUp = new JButton("회원가입");
		panel_2.add(btnSignUp);
		
		btnBack = new JButton("돌아가기");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage mp = new MainPage();
			}
		});
		panel_2.add(btnBack);
		
		btnSignUp.addActionListener(this);
		txtPW.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("회원가입") || e.getSource()==txtPW) {
			vo = new ClickerUserVO();
			if(txtID.getText()!=null && new String(passwordField.getPassword())!=null && new String(passwordField_1.getPassword())!=null) {
				
				if(new String(passwordField.getPassword()).equals(new String(passwordField_1.getPassword()))) {	//비밀번호-비밀번호 확인의 정보 비교
					//초기 설정 값
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
					vo.setProgress(0);		//엔딩확인 초기값
					
//					txtID.setText("");
					passwordField.setText("");
					passwordField_1.setText("");						
					
					int result=dao.insertUser(vo);
					if(result>0) {						
						JOptionPane.showMessageDialog(this, "가입 완료");
						pick.setUserId(txtID.getText());
						MiddlePage mp = new MiddlePage();
//						mp.playInfo();
					}else {
						JOptionPane.showMessageDialog(this, "아이디 중복");
					}				
				}else if(!(new String(passwordField.getPassword()).equals(new String(passwordField_1.getPassword())))) {
					JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
				}				
			}else if(txtID.getText()==null || new String(passwordField.getPassword())==null || new String(passwordField_1.getPassword())==null) {
				JOptionPane.showMessageDialog(this, "정보를 모두 기입해 주세요");
			}
		}
	}
}
