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

public class Hotel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JButton btnSave;

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
		
		btnSave = new JButton("저장");
		btnSave.setBounds(161, 211, 91, 23);
		contentPane.add(btnSave);
		
		textField = new JTextField();
		textField.setBounds(139, 37, 96, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 93, 96, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(139, 152, 96, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnSave.addActionListener(new ActionListener() {
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
				int n = service.save(dto);
				System.out.println(n+"개가 저장됨");
				JOptionPane.showInternalMessageDialog(null, n+"개가 저장됨",
			             "저장", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
