package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dbguide.ClickerDAO;
import dbguide.ClickerUserVO;
import system.Pickax;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

class BackImg extends JPanel {
	
	private BufferedImage img;
	
	public BackImg() {
		setLayout(null);
		try {
			URL url = getClass().getResource("/img/main-demo.png");
			img = ImageIO.read(new File(url.getFile()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}
	
	@Override
	public Dimension getPreferredSize() {
		if(img==null) {
			return new Dimension(100, 100);
		}
		return new Dimension(img.getWidth(), img.getHeight());
	}
}

public class MainPage extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JButton btnLogin, btnSignUp, btnEnd,btnSignUpDel,btnScore;
	private JTextField txtId;
	private JPasswordField txtPw;
	
	private ClickerDAO dao = new ClickerDAO();
	private Pickax pick = new Pickax();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel backPanel = new BackImg();
		contentPane.add(backPanel,BorderLayout.CENTER);
		pack();
		
		JLabel lblID = new JLabel("아이디");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblID.setBounds(230, 245, 97, 35);
		backPanel.add(lblID);
		
		txtId = new JTextField();
		txtId.setBounds(355, 248, 120, 30);
		backPanel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblPw = new JLabel("비밀번호");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblPw.setBounds(215, 307, 128, 35);
		backPanel.add(lblPw);
		
		txtPw = new JPasswordField();
		txtPw.setBounds(355, 310, 120, 30);
		backPanel.add(txtPw);
		txtPw.setColumns(10); 
		txtPw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClickerUserVO vo = new ClickerUserVO();
				vo = dao.searchUser(txtId.getText()); //DB 존재 유/무 조회
				if(vo!=null) {
					if(e.getActionCommand().equals("로그인") || e.getSource()==txtPw) {	//로그인버튼 및 txtPw에서 엔터 입력 시 진행
						if(vo.getId().equals(txtId.getText()) && //DB의 아이디와 비밀번호가 모두 일치시 진행
								vo.getPwd().equals(new String(txtPw.getPassword()))) {	
							if(vo.getProgress()==1) {
//								dispose();
								String options[] = {"확인","계정삭제","랭킹보기"};
								int sel=JOptionPane.showOptionDialog(getParent(), "이미 클리한 계정입니다.\n삭제 후 재가입하여 이용해 주세요.", "클리어 유저", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
								if(sel==2) {									
									Ranking rank = new Ranking();
								}else if(sel==1) {
									int result=dao.deleteUser(txtId.getText());
									if(result>0) {
										JOptionPane.showMessageDialog(getParent(), "삭제 완료\n재가입 후 이용해 주세요.");
										txtId.setText("");
										txtPw.setText("");
									}									
								}
							}else {
								pick=dao.insertPickax(txtId.getText());		//DB의 정보를 Pickax의 변수에 입력 
								dispose();
								MiddlePage mp = new MiddlePage();										
							}
						}else {
							JOptionPane.showMessageDialog(getParent(), "비밀번호를 확인해 주세요.");				
						}
					}else {
						JOptionPane.showMessageDialog(getParent(), "ID를 확인해 주세요.");
					}
				}else {
					JOptionPane.showMessageDialog(getParent(), "존재하지 않는 계정입니다.\n회원가입 후 이용해 주세요.");
					txtId.setText("");
					txtPw.setText("");
				}
			}
		});		
		setVisible(true);
		
		btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnLogin.setBounds(235, 368, 240, 30);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClickerUserVO vo = new ClickerUserVO();
				vo = dao.searchUser(txtId.getText()); //DB 존재 유/무 조회
				if(vo!=null) {
					if(e.getActionCommand().equals("로그인") || e.getSource()==txtPw) {	//로그인버튼 및 txtPw에서 엔터 입력 시 진행
						if(vo.getId().equals(txtId.getText()) && //DB의 아이디와 비밀번호가 모두 일치시 진행
								vo.getPwd().equals(new String(txtPw.getPassword()))) {	
							if(vo.getProgress()==1) {
//								dispose();
								String options[] = {"확인","계정삭제","랭킹보기"};
								int sel=JOptionPane.showOptionDialog(getParent(), "이미 클리한 계정입니다.\n삭제 후 재가입하여 이용해 주세요.", "클리어 유저", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
								if(sel==2) {									
									Ranking rank = new Ranking();
								}else if(sel==1) {
									int result=dao.deleteUser(txtId.getText());
									if(result>0) {
										JOptionPane.showMessageDialog(getParent(), "삭제 완료\n재가입 후 이용해 주세요.");
										txtId.setText("");
										txtPw.setText("");
									}									
								}
							}else {								
								pick=dao.insertPickax(txtId.getText());		//DB의 정보를 Pickax의 변수에 입력 
								dispose();
								MiddlePage mp = new MiddlePage();										
							}
						}else {
							JOptionPane.showMessageDialog(getParent(), "비밀번호를 확인해 주세요.");				
						}
					}else {
						JOptionPane.showMessageDialog(getParent(), "ID를 확인해 주세요.");
					}
				}else {
					JOptionPane.showMessageDialog(getParent(), "존재하지 않는 계정입니다.\n회원가입 후 이용해 주세요.");
					txtId.setText("");
					txtPw.setText("");
				}
			}
		});
		
//		btnLogin.setBorderPainted(false);
		btnLogin.setFocusPainted(false);
//		btnLogin.setContentAreaFilled(false);
		backPanel.add(btnLogin);
		
		btnSignUp = new JButton("회원가입");
		btnSignUp.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnSignUp.setBounds(235, 408, 240, 30);
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SignUp s = new SignUp();
			}
		});
		backPanel.add(btnSignUp);
		
		//btnEnd.setSelectedIcon());
		btnEnd = new JButton(new ImageIcon(MainPage.class.getResource("/gui/Exit.png")));
		btnEnd.setContentAreaFilled(false);
		btnEnd.setBorderPainted(false);
		
		btnEnd.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnEnd.setBounds(597, 511, 91, 79);
		btnEnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		backPanel.add(btnEnd);
		btnEnd.addMouseListener(this);
		
		btnSignUpDel = new JButton("회원삭제");
		btnSignUpDel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnSignUpDel.setBounds(235, 448, 240, 30);
		btnSignUpDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserDel ud = new UserDel();
			}
		});
		backPanel.add(btnSignUpDel);
		
		btnScore = new JButton("점수보기");
		btnScore.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnScore.setBounds(235, 487, 240, 30);
		btnScore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ranking ra = new Ranking();
			}
		});
		backPanel.add(btnScore);
		setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {
		btnEnd.setIcon(new ImageIcon(MainPage.class.getResource("/gui/redExit.png")));
	}
	@Override
	public void mouseExited(MouseEvent e) {
		btnEnd.setIcon(new ImageIcon(MainPage.class.getResource("/gui/Exit.png")));
	}
}