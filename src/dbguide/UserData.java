package dbguide;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.Store;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class UserData extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnMine, btnShop, btnPickax;
	private JLabel lblPickax, lblID, lblGold;
	
	private ClickerDAO dao;

	/**
	 * Launch the application. 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserData frame = new UserData();
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
	public UserData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		dao=new ClickerDAO();
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnMine = new JButton("광산");
		btnMine.setIcon(new ImageIcon(UserData.class.getResource("/dbguide/mining.png")));
		
		panel.add(btnMine);
		
		btnShop = new JButton("상점");
		btnShop.setIcon(new ImageIcon(UserData.class.getResource("/dbguide/shop.png")));
		panel.add(btnShop);
		
		lblPickax = new JLabel("");
		panel.add(lblPickax);
		
		btnPickax = new JButton("곡괭이 정보");
		btnPickax.setIcon(new ImageIcon(UserData.class.getResource("/dbguide/infi.png")));
		panel.add(btnPickax);
		
		lblID = new JLabel("");
		panel.add(lblID);
		
		lblGold = new JLabel("");
		panel.add(lblGold);
		
		btnMine.addActionListener(this);
		btnShop.addActionListener(this);
		btnPickax.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ClickerUserVO userVO=dao.login(lblID.getText());
		if(e.getActionCommand().equals("곡괭이 정보")) {			
			Pickax pick = new Pickax();
			pick.itemInfo(userVO);
			
		}else if(e.getActionCommand().equals("상점")) {
			Store store = new Store();
			store.storeInfo(userVO);
			store.setVisible(true);
		}
	}
	
	public void playInfo(ClickerUserVO userVO) {	
		lblID.setText(userVO.getId());
		lblGold.setText(userVO.getGold()+"");
		int result=dao.saveUser(userVO);
		if(result>0) {
			System.out.println("저장");
		}else {
			System.out.println("실패");
		}
	}
 }

