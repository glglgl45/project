package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dbguide.ClickerDAO;
import dbguide.ClickerUserVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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
		
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		
		dao = new ClickerDAO();
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("★Ranking★");
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(5, 5, 674, 48);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		
		String columnNames[]= {"이름","점수"};
		model1 = new DefaultTableModel(columnNames, 0);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 373, 674, 184);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		String columnNames1[]= {"이름","점수"};
		model2 = new DefaultTableModel(columnNames1, 0);		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 74, 674, 300);
		contentPane.add(scrollPane);		
		
		table = new JTable(model1);
		model1.setNumRows(0);
		ingList();		
		scrollPane.setViewportView(table);
		
		table_2 = new JTable(model2);
		model2.setNumRows(0);
		endList();
		scrollPane_1.setViewportView(table_2);
	}
	
	public void ingList() {	//클리어 못한 유저 리스트
		vecList=dao.listIngUser();		
		
		for(ClickerUserVO vo:vecList) {
			Object[] objList = {vo.getId(),vo.getScore()};
			model1.addRow(objList);
		}
	}
	
	public void endList() { //클리어 유저 리스트
		vecList=dao.listEndUser();		
		
		for(ClickerUserVO vo:vecList) {
			Object[] objList = {vo.getId(),vo.getScore()};
			model2.addRow(objList);
		}
	}
}
