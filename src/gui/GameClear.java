package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import system.Pickax;

public class GameClear extends JFrame implements MouseListener, KeyListener {

	private JPanel contentPane;
	JLabel imageLabel = new JLabel();
	JLabel headerLabel = new JLabel();
	private JLabel guideLabel;
	 
	private Pickax pick = new Pickax();
	 
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
	        contentPane.add(headerLabel, BorderLayout.NORTH);
	        // add the image label
	        ImageIcon ii = new ImageIcon(this.getClass().getResource("clear.gif"));
	        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        imageLabel.setIcon(ii);
	        contentPane.add(imageLabel, BorderLayout.CENTER);
	        // add the subtitle label
	        guideLabel = new JLabel();
	        guideLabel.setText("Click or Press");
	        guideLabel.setForeground(Color.WHITE);
	        guideLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	        guideLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        contentPane.add(guideLabel, BorderLayout.SOUTH);
//	        contentPane.add(sublbl, java.awt.BorderLayout.SOUTH);
	        addKeyListener(this);
	        addMouseListener(this);
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
	 
	ImageIcon setIcon = new ImageIcon(GameClear.class.getResource("smile.png")); 
	String[] str = {"랭킹 보러 가기"};
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		int opReturn= JOptionPane.showOptionDialog(this,"축하합니다\n"+pick.getUserId()+"님의"+"점수는 "+pick.getScore()+"점 입니다.\n"+"랭킹보러 갑시다아~", "추카포카찡",
				JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, setIcon, str, str[0]);
		if(opReturn==0) {
			dispose();
			Ranking r = new Ranking();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		int opReturn= JOptionPane.showOptionDialog(this,"축하합니다\n"+pick.getUserId()+"님의"+"점수는 "+pick.getScore()+"점 입니다.\n"+"랭킹보러 갑시다아~", "추카포카찡",
				JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, setIcon, str, str[0]);
		if(opReturn==0) {
			dispose();
			Ranking r = new Ranking();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}

class subtitle {
	
	public void move() {
		
//		int x = posX + xSpeed;
//		int y = posY + ySpeed;
//		
//		if
	}
}