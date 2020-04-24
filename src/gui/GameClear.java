package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameClear extends JFrame {

	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
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
//	/**
//	 * Create the frame.
//	 */
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
//
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
	
	 JLabel imageLabel = new JLabel();
	 JLabel headerLabel = new JLabel();

	 public GameClear() {
		 try {
			 setDefaultCloseOperation(EXIT_ON_CLOSE);
	         contentPane = (JPanel) getContentPane();
	         contentPane.setLayout(new BorderLayout());
	         setSize(new Dimension(700, 600));
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
	         // show it
	         this.setLocationRelativeTo(null);
	         this.setVisible(true);
	     } catch (Exception exception) {
	         exception.printStackTrace();
	     }
	 }

	 public static void main(String[] args) {
	     new GameClear();
	 }
}
