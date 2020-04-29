package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import dbguide.ClickerDAO;
import dbguide.ClickerUserVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Ranking extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model1, model2;
	private ClickerDAO dao;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private Vector<ClickerUserVO> vecList;
	private ImageIcon icon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranking frame = new Ranking();
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
	public Ranking() {
		setTitle("광산에서 탈출하기");
		// 랭킹점수 창 크기
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel()/*{
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		}*/;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		icon = new ImageIcon(Ranking.class.getResource("/img/bckimg/middlepg.jpg"));
		
		dao = new ClickerDAO();
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel paneTop = new JPanel();
		contentPane.add(paneTop, BorderLayout.NORTH);
//		paneTop.setOpaque(false);

		//랭킹 이름 만들기
		JLabel lblNewLabel = new JLabel("★Ranking★");
		lblNewLabel.setIcon(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		paneTop.add(lblNewLabel);
		
		JPanel paneBot = new JPanel();
		contentPane.add(paneBot, BorderLayout.CENTER);
		paneBot.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel paneCenTop = new JPanel();
		paneBot.add(paneCenTop);
		
		JPanel paneCenBot = new JPanel();
		paneBot.add(paneCenBot);
		
		
		//ScrollPane 안에 컬럼 만들기
		String columnNames[]= {"순위","이름","점수","곡괭이","강화","소지금"};
		model1 = new DefaultTableModel(columnNames, 0);
		paneCenTop.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		paneCenTop.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		String columnNames1[]= {"순위","이름","점수","곡괭이","강화","소지금"};
		model2 = new DefaultTableModel(columnNames1, 0);		
		paneCenBot.setLayout(new BorderLayout(0, 0));
		
		JPanel panePlaying = new JPanel();
		paneCenBot.add(panePlaying, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("플레이 유저");
		panePlaying.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		paneCenBot.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane);	
		
		
		table = new JTable(model1);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	//테이블 컬럼 사이즈 자동 변환 false
		table.getColumnModel().getColumn(0).setPreferredWidth(50);	//테이블 컬럼 사이즈 조정
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		model1.setNumRows(0);
		ingList();		
		scrollPane.setViewportView(table);
		
		table_2 = new JTable(model2);
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	//테이블 컬럼 사이즈 자동 변환 false
		table_2.getColumnModel().getColumn(0).setPreferredWidth(50);	//테이블 컬럼 사이즈 조정
		table_2.getColumnModel().getColumn(1).setPreferredWidth(150);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(150);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_2.getColumnModel().getColumn(5).setPreferredWidth(120);
		model2.setNumRows(0);
		endList();
		scrollPane_1.setViewportView(table_2);
		
		JPanel paneClear = new JPanel();
		paneCenTop.add(paneClear, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("클리어 유저");
		paneClear.add(lblNewLabel_1);
		
		
		
		// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		// 정렬할 테이블의 ColumnModel을 가져옴
		TableColumnModel tcmSchedule = table.getColumnModel();
		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}TableColumnModel tcmSchedule1 = table_2.getColumnModel();
		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule1.getColumnCount(); i++) {
			tcmSchedule1.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}		
	}
	
	public void ingList() {	//클리어 못한 유저 리스트
		vecList=dao.listIngUser();		
		int i=1;
		for(ClickerUserVO vo:vecList) {
			Object[] objList = {i++,vo.getId(),vo.getScore(),vo.getPickName(),"+"+vo.getEnhance(),vo.getGold()};
			model1.addRow(objList);
		}
	}
	
	public void endList() { //클리어 유저 리스트
		vecList=dao.listEndUser();		
		int i=1;
		for(ClickerUserVO vo:vecList) {
			Object[] objList = {i++, vo.getId(),vo.getScore(),vo.getPickName(),"+"+vo.getEnhance(),vo.getGold()};
			model2.addRow(objList);
		}
	}
}
