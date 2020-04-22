package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbguide.ClickDAO;
import dbguide.ClickUserVO;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;

public class SignUp extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtID, txtPW;
	private JButton btnSignUp, btnBack;
	
	private ClickDAO dao;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					signUp frame = new signUp();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); -- x키 누르면 같이 꺼짐
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setVisible(true);
		setContentPane(contentPane);
		
		dao=new ClickDAO();
		
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
		
		txtPW = new JTextField();
		panel_1.add(txtPW);
		txtPW.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("비밀번호 확인");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		btnSignUp = new JButton("회원가입");
		panel_2.add(btnSignUp);
		
		btnBack = new JButton("돌아가기");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_2.add(btnBack);
		
		btnSignUp.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("회원가입")) {
			dbguide.ClickUserVO vo = new dbguide.ClickUserVO();
			vo.setId(txtID.getText());	
			vo.setPwd(txtPW.getText());				
			txtID.setText("");
			txtPW.setText("");
			
			int result=dao.signUp(vo);
			if(result>0) {
				System.out.println("가입 완료");
			}else {
				System.out.println("내용확인필요"); //힘내요................ㅂㅂㅂㅂㅂㅂㅂ
			}
		}
	}
}
