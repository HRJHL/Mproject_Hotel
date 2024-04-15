package com;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.GuestDAO;
import com.dto.GuestDTO;
import com.service.GuestService;
import com.service.GuestServiceImpl;

import com.dao.RoomDAO;
import com.dto.RoomDTO;
import com.service.RoomService;
import com.service.RoomServiceImpl;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Hotel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel frame = new Hotel();
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
	public Hotel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 10, 189, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(32, 28, 96, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(32, 68, 96, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(32, 116, 96, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btn1 = new JButton("다음");
		btn1.setBounds(37, 176, 91, 23);
		panel.add(btn1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(220, 10, 204, 231);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.setBounds(39, 24, 96, 21);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(39, 72, 96, 21);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btn2 = new JButton("완료");
		btn2.setBounds(44, 155, 91, 23);
		panel_1.add(btn2);
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String guest_pno = textField.getText();
				String guest_name = textField_1.getText();
				String room_no = textField_2.getText();
				
				System.out.println(guest_pno+"\t"+guest_name+"\t"+room_no);
				
				GuestDTO dto = new GuestDTO();
				dto.setGuest_pno(guest_pno);
				dto.setGuest_name(guest_name);
				dto.setRoom_no(Integer.parseInt(room_no));
				
				GuestService service = new GuestServiceImpl();
				service.setDao(new GuestDAO());
				int n = service.save_G(dto);
				System.out.println(n+"개가 저장됨");
				JOptionPane.showInternalMessageDialog(null, n+"개가 저장됨",
			             "저장", JOptionPane.INFORMATION_MESSAGE);
				panel_1.setVisible(true);
				panel.setVisible(false);
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String room_no = textField_3.getText();
				String room_capacity = textField_4.getText();
				
				System.out.println(room_no+"\t"+room_capacity);
				
				RoomDTO dto = new RoomDTO();
				dto.setRoom_no(Integer.parseInt(room_no));
				dto.setRoom_capacity(Integer.parseInt(room_capacity));
				
				RoomService service = new RoomServiceImpl();
				service.setDao(new RoomDAO());
				int n = service.save_R(dto);
				System.out.println(n+"개가 저장됨");
				JOptionPane.showInternalMessageDialog(null, n+"개가 저장됨",
			             "저장", JOptionPane.INFORMATION_MESSAGE);
				panel.setVisible(true);
				panel_1.setVisible(false);
			}
		});
	}
}
