package ore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MapStone extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Stone stone1;
	private Stone stone2;
	private Stone stone3;
	private Stone stone4;
	private Stone stone5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MapStone frame = new MapStone();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MapStone() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 3, 0, 0));
		
		JButton Stone1 = new JButton("돌1");
		contentPane.add(Stone1);
		Stone1.addActionListener(this);
		
		JButton Stone2 = new JButton("돌2");
		contentPane.add(Stone2);
		Stone2.addActionListener(this);
		
		JButton Stone3 = new JButton("돌3");
		contentPane.add(Stone3);
		Stone3.addActionListener(this);
		
		JButton Stone4 = new JButton("돌4");
		contentPane.add(Stone4);
		Stone4.addActionListener(this);
		
		JButton back = new JButton("돌아가기");
		contentPane.add(back);
		
		
		JButton Stone6 = new JButton("돌5");
		contentPane.add(Stone6);
		Stone6.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("돌1")) {
			stone1.hit(3);
		}		
	}
}
