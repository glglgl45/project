package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameClear extends JFrame {

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GameClear frame = new GameClear();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	} 
//
//	public GameClear() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 700, 600);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//		
//		add(new MyPanel());
//	}
//}
//
//class MyPanel extends JPanel { 
//	Image image; 
//	MyPanel() throws MalformedURLException { 
//		image = Toolkit.getDefaultToolkit().createImage("gui/clear.gif"); } 
//	public void paintComponent(Graphics g) { 
//		super.paintComponent(g); 
//		if (image != null) {
//			g.drawImage(image, 0, 0, this); 
//		} 
//	}
	 private JPanel contentPane;
	 JLabel imageLabel = new JLabel();
	 JLabel headerLabel = new JLabel();
	 private JLabel sublbl;
	 
	 public GameClear() {
		 try {
			 setDefaultCloseOperation(EXIT_ON_CLOSE);
	         contentPane = (JPanel) getContentPane();
	         contentPane.setLayout(new BorderLayout());
	         contentPane.setBackground(Color.BLACK);
	         setSize(new Dimension(700, 600));
	         headerLabel.setForeground(Color.WHITE);
	         headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
	         // add the header label
	         headerLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
	         headerLabel.setText("Game Clear!");
	         contentPane.add(headerLabel, java.awt.BorderLayout.NORTH);
	         // add the image label
	         ImageIcon ii = new ImageIcon(this.getClass().getResource("clear.gif"));
	         imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
	         imageLabel.setIcon(ii);
	         contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);
	         // add the subtitle label
	         
	         contentPane.add(sublbl, java.awt.BorderLayout.SOUTH);
	         
	         
	         // show it
	         this.setLocationRelativeTo(null);
	         this.setVisible(true);
	     } catch (Exception exception) {
	         exception.printStackTrace();
	     }
	 }
	 
	 @Override
		public void paintComponents(Graphics g) {
			super.paintComponents(g);
			
		}

	 public static void main(String[] args) {
	     new GameClear();
	 }
}

class subtitle {
	
	public void move() {
		
		int x = posX + xSpeed;
		int y = posY + ySpeed;
		
		if
	}
}