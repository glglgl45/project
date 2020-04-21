package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class User extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textSword;
	private JTextField gold;

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
		
		textID = new JTextField();
		panel_1.add(textID);
		textID.setColumns(5);
		
		JLabel lblNewLabel_1 = new JLabel("장비정보");
		panel_1.add(lblNewLabel_1);
		
		textSword = new JTextField();
		panel_1.add(textSword);
		textSword.setColumns(5);
		
		JLabel lblNewLabel_2 = new JLabel("소지금");
		panel_1.add(lblNewLabel_2);
		
		gold = new JTextField();
		panel_1.add(gold);
		gold.setColumns(10);
	}

}
