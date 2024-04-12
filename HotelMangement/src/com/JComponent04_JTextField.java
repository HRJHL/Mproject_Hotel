package com;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dao.GuestDAO;
import com.dto.GuestDTO;
import com.service.GuestService;
import com.service.GuestServiceImpl;

public class JComponent04_JTextField extends JFrame {

	private JPanel contentPane;
	private JTextField tfGno;
	private JTextField tfGname;
	private JTextField tfGsal;
	JButton btnSave;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComponent04_JTextField frame = new JComponent04_JTextField();
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
	public JComponent04_JTextField() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfGno = new JTextField();
		tfGno.setBounds(86, 54, 116, 21);
		contentPane.add(tfGno);
		tfGno.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("손님 번호");
		lblNewLabel.setBounds(12, 57, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("손님명");
		lblNewLabel_1.setBounds(12, 88, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		tfGname = new JTextField();
		tfGname.setColumns(10);
		tfGname.setBounds(86, 85, 116, 21);
		contentPane.add(tfGname);
		
		JLabel lblNewLabel_2 = new JLabel("세일");
		lblNewLabel_2.setBounds(12, 125, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		tfGsal = new JTextField();
		tfGsal.setColumns(10);
		tfGsal.setBounds(86, 122, 116, 21);
		contentPane.add(tfGsal);
		
		btnSave = new JButton("저장");
		btnSave.setBounds(39, 179, 97, 23);
		contentPane.add(btnSave);
		
		//button 이벤트 처리
	    btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String guest_pno = tfGno.getText();
				String guest_name = tfGname.getText();
				String parking_yn = tfGsal.getText();
				
				System.out.println(guest_pno+"\t"+guest_name+"\t"+parking_yn);
				
			}
		});
		
		
		
	}
}