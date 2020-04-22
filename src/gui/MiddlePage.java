package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class MiddlePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiddlePage frame = new MiddlePage();
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
	public MiddlePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnMine = new JButton("광산");
		btnMine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MineSelect ms = new MineSelect();
			}
		});
		btnMine.setIcon(new ImageIcon(MiddlePage.class.getResource("/gui/mining.png")));
		panel.add(btnMine);
		
		JButton btnStore = new JButton("상점");
		btnStore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Store s = new Store();
			}
		});
		btnStore.setIcon(new ImageIcon(MiddlePage.class.getResource("/gui/shop.png")));
		panel.add(btnStore);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JButton btnPickaxInfo = new JButton("곡괭이 정보");
		btnPickaxInfo.setIcon(new ImageIcon(MiddlePage.class.getResource("/gui/infi.png")));
		btnPickaxInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PickaxInfo pic = new PickaxInfo();
			}
		});
		panel.add(btnPickaxInfo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
	}

}
