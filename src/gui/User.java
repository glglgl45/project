package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbguide.ClickerDAO;
import dbguide.ClickerItemVO;
import dbguide.ClickerUserVO;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtID, txtSword, txtGold;
	
	private ClickerDAO dao;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		dao=new ClickerDAO();
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnMine = new JButton("광산");
		panel.add(btnMine);
		
		JButton btnshop = new JButton("상점");
		panel.add(btnshop);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblID = new JLabel("ID");
		panel_1.add(lblID);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		panel_1.add(txtID);
		txtID.setColumns(5);
		
		JLabel lblNewLabel_1 = new JLabel("장비정보");
		panel_1.add(lblNewLabel_1);
		
		txtSword = new JTextField();
		txtSword.setEditable(false);
		panel_1.add(txtSword);
		txtSword.setColumns(5);
		
		JLabel lblNewLabel_2 = new JLabel("소지금");
		panel_1.add(lblNewLabel_2);
		
		txtGold = new JTextField();
		txtGold.setEditable(false);
		panel_1.add(txtGold);
		txtGold.setColumns(10);
		
		btnshop.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("상점")) {
			Store store = new Store();
			ClickerUserVO userVO=dao.login(txtID.getText());
			store.storeInfo(userVO);
			store.setVisible(true);
		}
	}
	
	public void playInfo(ClickerUserVO userVO) {
		txtSword.setText(userVO.getItemName()+"("+userVO.getCurrentEnhance()+")");			
		txtID.setText(userVO.getId());
		txtGold.setText(userVO.getGold()+"");	
	}
}
