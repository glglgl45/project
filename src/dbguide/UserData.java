package dbguide;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class UserData extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnMine, btnShop, btnPickax;
	private JLabel lblPickax, lblID, lblGold;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnMine = new JButton("광산");
		panel.add(btnMine);
		
		btnShop = new JButton("상점");
		panel.add(btnShop);
		
		lblPickax = new JLabel("");
		panel.add(lblPickax);
		
		btnPickax = new JButton("곡괭이정보");
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
		Pickax pick = new Pickax();
		
	}
	public void playInfo(ClickerUserVO userVO) {			
		lblID.setText(userVO.getId());
		lblGold.setText(userVO.getGold()+"");	
	}
 }

