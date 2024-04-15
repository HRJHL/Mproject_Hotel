package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;

public class MasterGUI extends JFrame {

	private JPanel Frame;
	private JTable RMlist;
	private JTable CustomerList;
	JPanel HotelEdit;
	JPanel CtmEdit;
	JPanel RmEdit;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MasterGUI frame = new MasterGUI();
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
	public MasterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 411);
		Frame = new JPanel();
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Frame);
		Frame.setLayout(null);
		
		JPanel CtmEdit = new JPanel();
		CtmEdit.setBounds(0, 0, 598, 364);
		Frame.add(CtmEdit);
		CtmEdit.setLayout(null);
		CtmEdit.setVisible(false);
		
		JButton Acustomer = new JButton("숙박 고객");
		Acustomer.setBounds(53, 41, 180, 51);
		CtmEdit.add(Acustomer);
		
		JButton Rcustomer = new JButton("예약 고객");
		Rcustomer.setBounds(53, 119, 180, 51);
		CtmEdit.add(Rcustomer);
		
		JButton Bcustomer = new JButton("블랙리스트");
		Bcustomer.setBounds(53, 202, 180, 51);
		CtmEdit.add(Bcustomer);
		
		CustomerList = new JTable();
		CustomerList.setBounds(315, 45, 271, 298);
		CtmEdit.add(CustomerList);
		
		JLabel lblNewLabel = new JLabel("고객 관리");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(240, 10, 90, 21);
		CtmEdit.add(lblNewLabel);
		

		
		JPanel RmEdit = new JPanel();
		RmEdit.setBounds(0, 0, 598, 364);
		Frame.add(RmEdit);
		RmEdit.setLayout(null);
		RmEdit.setVisible(false);
		
		JButton RBone = new JButton("1~2인실");
		RBone.setBounds(43, 50, 166, 60);
		RmEdit.add(RBone);
		
		JButton RBtwo = new JButton("2~4인실");
		RBtwo.setBounds(43, 137, 166, 60);
		RmEdit.add(RBtwo);
		
		JButton RBthree = new JButton("4~6인실");
		RBthree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		RBthree.setBounds(43, 223, 166, 60);
		RmEdit.add(RBthree);
		
		RMlist = new JTable();
		RMlist.setBounds(293, 50, 281, 304);
		RmEdit.add(RMlist);
		
		JLabel lblNewLabel_1 = new JLabel("방 관리");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(240, 10, 90, 21);
		RmEdit.add(lblNewLabel_1);
		

		
		JPanel HotelEdit = new JPanel();
		HotelEdit.setBounds(0, 0, 598, 364);
		Frame.add(HotelEdit);
		HotelEdit.setLayout(null);
		
		JButton RmEditB = new JButton("방 관리");
		RmEditB.setBounds(96, 48, 411, 105);
		RmEditB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HotelEdit.setVisible(false);
				RmEdit.setVisible(true);
			}
		});
		
		HotelEdit.add(RmEditB);
		
		JButton CtmEditB = new JButton("고객 관리");
		CtmEditB.setBounds(98, 209, 411, 105);
		CtmEditB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HotelEdit.setVisible(false);	
				CtmEdit.setVisible(true);
			}
		});
		HotelEdit.add(CtmEditB);
		
		JButton CustomerB = new JButton("첫  화면으로");
		CustomerB.setBounds(53, 302, 129, 41);
			CustomerB.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					CtmEdit.setVisible(false);
					HotelEdit.setVisible(true);
				}
			});
		CtmEdit.add(CustomerB);
		
		JButton RoomRB = new JButton("첫  화면으로");
		RoomRB.setBounds(53, 302, 129, 41);
		RoomRB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RmEdit.setVisible(false);
				HotelEdit.setVisible(true);
			}
		});

		RmEdit.add(RoomRB);
		
		
		
	}
	}