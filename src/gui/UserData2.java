package gui;

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
import javax.swing.ImageIcon;

public class UserData2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnMine, btnShop, btnData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserData2 frame = new UserData2();
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
	public UserData2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnMine = new JButton("광산");
		btnMine.setIcon(new ImageIcon(UserData2.class.getResource("/gui/mining.png")));
		panel.add(btnMine);
		
		btnShop = new JButton("상점");
		btnShop.setIcon(new ImageIcon(UserData2.class.getResource("/gui/shop.png")));
		panel.add(btnShop);
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		
		btnData = new JButton("곡괭이 정보");
		btnData.setIcon(new ImageIcon(UserData2.class.getResource("/gui/infi.png")));
		panel.add(btnData);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel.add(lblNewLabel_2);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Pickax pick = new Pickax();
		
	}

}
