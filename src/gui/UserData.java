package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class UserData extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblimage;
	private JButton btnMine, btnShop, btnData;

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
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lblimage = new JLabel("");
		panel_1.add(lblimage, BorderLayout.CENTER);
		
		btnData = new JButton("곡괭이정보");
		panel.add(btnData);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel_2.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_3.add(lblNewLabel_1, BorderLayout.CENTER);
		
		btnMine.addActionListener(this);
		btnShop.addActionListener(this);
		btnData.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
