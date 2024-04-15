package com;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTable;

public class Master_MK1 {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	JPanel MPanel;
	JPanel CPanel;
	JPanel RPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Master_MK1 window = new Master_MK1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Master_MK1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 302);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel MPanel = new Panel();
		MPanel.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(MPanel);
		MPanel.setLayout(null);
		
		JButton BackButton = new JButton("메인 화면으로");
		BackButton.setBounds(325, 223, 99, 30);
		MPanel.add(BackButton);
		
		JButton CButton = new JButton("고객 관리");
		CButton.setBounds(108, 23, 246, 81);
		CButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MPanel.setVisible(false);
				CPanel.setVisible(true);
				
			}
		});
		MPanel.add(CButton);
		
		JButton RButton = new JButton("방 관리");
		RButton.setBounds(106, 116, 246, 81);
		RButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MPanel.setVisible(false);
				RPanel.setVisible(true);
			}
		});
		MPanel.add(RButton);
		
		Panel RPanel = new Panel();
		RPanel.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(RPanel);
		RPanel.setLayout(null);
		
		JButton OButton = new JButton("1~2인실");
		OButton.setBounds(31, 10, 111, 32);
		RPanel.add(OButton);
		
		JButton TButton = new JButton("2~4인실");
		TButton.setBounds(166, 10, 111, 32);
		RPanel.add(TButton);
		
		JButton FButton = new JButton("4~6인실");
		FButton.setBounds(301, 10, 111, 32);
		RPanel.add(FButton);
		
		table = new JTable();
		table.setBounds(31, 62, 381, 119);
		RPanel.add(table);
		
		JButton Create_Rm = new JButton("생성");
		Create_Rm.setBounds(31, 204, 91, 23);
		RPanel.add(Create_Rm);
		
		JButton Update_Rm = new JButton("수정");
		Update_Rm.setBounds(166, 204, 91, 23);
		RPanel.add(Update_Rm);
		
		JButton Delete_Rm = new JButton("삭제");
		Delete_Rm.setBounds(301, 204, 91, 23);
		RPanel.add(Delete_Rm);
		
		JButton BackButtonO = new JButton("첫 화면으로");
		BackButtonO.setBounds(323, 237, 101, 26);
		BackButtonO.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RPanel.setVisible(false);
				MPanel.setVisible(true);
			}
		});
		RPanel.add(BackButtonO);
		
		Panel CPanel_1 = new Panel();
		CPanel_1.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(CPanel_1);
		CPanel_1.setLayout(null);
		
		JButton PCus = new JButton("숙박 고객");
		PCus.setBounds(35, 10, 152, 31);
		CPanel_1.add(PCus);
		
		JButton RCus = new JButton("예약 고객");
		RCus.setBounds(239, 10, 152, 31);
		CPanel_1.add(RCus);
		
		table_1 = new JTable();
		table_1.setBounds(35, 51, 356, 90);
		CPanel_1.add(table_1);
		
		JButton Create_Cu = new JButton("생성");
		Create_Cu.setBounds(35, 168, 91, 23);
		CPanel_1.add(Create_Cu);
		
		JButton Update_Cu = new JButton("수정");
		Update_Cu.setBounds(160, 168, 91, 23);
		CPanel_1.add(Update_Cu);
		
		JButton Delete_Cu = new JButton("삭제");
		Delete_Cu.setBounds(285, 168, 91, 23);
		CPanel_1.add(Delete_Cu);
		
		JButton BackButtonT = new JButton("첫 화면으로");
		BackButtonT.setBounds(333, 230, 91, 23);
		BackButtonT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CPanel_1.setVisible(false);
				MPanel.setVisible(true);
			}
		});
		CPanel_1.add(BackButtonT);
	}
}