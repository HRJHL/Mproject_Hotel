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

import com.dao.EmpDAO;
import com.dto.EmpDTO;
import com.service.EmpService;
import com.service.EmpServiceImpl;

public class JComponent04_JTextField extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmpno;
	private JTextField tfEname;
	private JTextField tfSal;
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
		
		tfEmpno = new JTextField();
		tfEmpno.setBounds(86, 54, 116, 21);
		contentPane.add(tfEmpno);
		tfEmpno.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("사원번호");
		lblNewLabel.setBounds(12, 57, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("사원명");
		lblNewLabel_1.setBounds(12, 88, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		tfEname = new JTextField();
		tfEname.setColumns(10);
		tfEname.setBounds(86, 85, 116, 21);
		contentPane.add(tfEname);
		
		JLabel lblNewLabel_2 = new JLabel("SAL");
		lblNewLabel_2.setBounds(12, 125, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		tfSal = new JTextField();
		tfSal.setColumns(10);
		tfSal.setBounds(86, 122, 116, 21);
		contentPane.add(tfSal);
		
		btnSave = new JButton("저장");
		btnSave.setBounds(39, 179, 97, 23);
		contentPane.add(btnSave);
		
		//button 이벤트 처리
	    btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String empno = tfEmpno.getText();
				String ename = tfEname.getText();
				String sal = tfSal.getText();
				
				System.out.println(empno+"\t"+ename+"\t"+sal);
				
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(Integer.parseInt(empno));
				dto.setEname(ename);
				dto.setSal(Integer.parseInt(sal));
				
				EmpService service = new EmpServiceImpl();
				service.setDao(new EmpDAO());
				int n = service.save(dto);
				System.out.println(n+"개가 저장됨");
				JOptionPane.showInternalMessageDialog(null, n+"개가 저장됨",
			             "저장", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		
	}
}