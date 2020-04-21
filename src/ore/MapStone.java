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
	private Pickax pick;
	private Upgrade grade;
	private int level = 0;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

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
		stone1 = new Stone();
		stone2 = new Stone();
		stone3 = new Stone();
		stone4 = new Stone();
		pick = new Pickax();
		pick.setStr("stone");
		grade = new Upgrade();
		
		
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
		
		JButton evol = new JButton("진화하기");
		contentPane.add(evol);
		evol.addActionListener(this);
		
		JButton back = new JButton("돌아가기");
		contentPane.add(back);
		
		
		JButton rein = new JButton("강화하기");
		contentPane.add(rein);
		rein.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("돌1")) {
			stone1.hit(pick.choicePick(level));
		}
		if(e.getActionCommand().equals("돌2")) {
			stone2.hit(pick.choicePick(level));
		}
		if(e.getActionCommand().equals("돌3")) {
			stone3.hit(pick.choicePick(level));
		}
		if(e.getActionCommand().equals("진화하기")) {
			if(pick.getStr().equals("stone")) {
				if(level==5) {
					if(grade.upgrade()==1) {
						level = 0;
						pick.setStr("copper");
					}
				} else {
					System.out.println("진화가 불가능 합니다.");
				}
			}
		}
		if(e.getActionCommand().equals("강화하기")) {
			if(level >= 5) {
				System.out.println("더이상 강화가 불가능 합니다.");
			} else if(grade.upgrade()==1) {
				level+=1;
			}
		}
	}
}
