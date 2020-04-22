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
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener {

	private JPanel mPanel;
	private JTextField txtID;
	private JPasswordField txtPW;
	private JButton btnLog, btnBack;
	
	private ClickDAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mPanel = new JPanel();
		mPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(mPanel);
		setVisible(true);
		dao=new ClickDAO();
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		mPanel.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("로그인이 필요합니다");
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		mPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);
		
		txtID = new JTextField();
		panel_1.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		txtPW = new JPasswordField();
		panel_1.add(txtPW);
		
		JPanel panel_2 = new JPanel();
		mPanel.add(panel_2, BorderLayout.SOUTH);
		
		btnLog = new JButton("로그인");
		panel_2.add(btnLog);
		
		btnBack = new JButton("돌아가기");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage m = new MainPage();
			}
		});
		panel_2.add(btnBack);
		
		btnLog.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("로그인")) {
			
			ClickUserVO vo=dao.login(txtID.getText());	//DB에 없는 아이디 입력 시 에러 발생  처리방법 필요
			
			if(vo.getId().equals(txtID.getText()) && vo.getPwd().equals(txtPW.getText())) {	//passwordtxtfield getText()메서드 대체 메서드 필요
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 정보 확인");
				System.out.println(vo.getId()+"\t"+vo.getPwd());
			}
		}else {
			
		}
	}

}
