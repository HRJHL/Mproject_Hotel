package com;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.dao.RoomDAO;
import com.dto.RoomDTO;
import com.service.RoomService;
import com.service.RoomServiceImpl;

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
		Panel RPanel = new Panel();
		Panel CPanel = new Panel();
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

		RPanel.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(RPanel);
		RPanel.setLayout(null);

		JButton OButton = new JButton("1~2인실");
		OButton.setBounds(31, 10, 111, 32);
		RPanel.add(OButton);

		JButton TButton = new JButton("3~4인실");
		TButton.setBounds(166, 10, 111, 32);
		RPanel.add(TButton);

		JButton FButton = new JButton("5~6인실");
		FButton.setBounds(301, 10, 111, 32);
		RPanel.add(FButton);

		String header[] = { "방 번호", "현재 상태", "수용 가능 인원", "체크인", "체크아웃" };
		DefaultTableModel model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBounds(31, 62, 381, 119);
		JScrollPane scrolledTable = new JScrollPane(table); // 수정된 부분
		scrolledTable.setBounds(31, 62, 381, 119); // 수정된 부분
		RPanel.add(scrolledTable); // 수정된 부분

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

		OButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				int room_no;
				int room_state;
				int room_capacity;
				String room_checkin_time;
				String room_checkout_time;

				RoomService service = new RoomServiceImpl();
				service.setDao(new RoomDAO());
				List<RoomDTO> list = service.find_R12();
				for (RoomDTO s : list) {
					room_no = s.getRoom_no();
					room_state = s.getRoom_state();
					room_capacity = s.getRoom_capacity();
					room_checkin_time = s.getRoom_checkin_time();
					room_checkout_time = s.getRoom_checkout_time();
					String[] row = { Integer.toString(room_no), Integer.toString(room_state),
							Integer.toString(room_capacity), room_checkin_time, room_checkout_time };
					model.addRow(row);
				}

			}
		});

		TButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				int room_no;
				int room_state;
				int room_capacity;
				String room_checkin_time;
				String room_checkout_time;

				RoomService service = new RoomServiceImpl();
				service.setDao(new RoomDAO());
				List<RoomDTO> list = service.find_R34();
				for (RoomDTO s : list) {
					room_no = s.getRoom_no();
					room_state = s.getRoom_state();
					room_capacity = s.getRoom_capacity();
					room_checkin_time = s.getRoom_checkin_time();
					room_checkout_time = s.getRoom_checkout_time();
					String[] row = { Integer.toString(room_no), Integer.toString(room_state),
							Integer.toString(room_capacity), room_checkin_time, room_checkout_time };
					model.addRow(row);
				}

			}
		});

		FButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				int room_no;
				int room_state;
				int room_capacity;
				String room_checkin_time;
				String room_checkout_time;

				RoomService service = new RoomServiceImpl();
				service.setDao(new RoomDAO());
				List<RoomDTO> list = service.find_R56();
				for (RoomDTO s : list) {
					room_no = s.getRoom_no();
					room_state = s.getRoom_state();
					room_capacity = s.getRoom_capacity();
					room_checkin_time = s.getRoom_checkin_time();
					room_checkout_time = s.getRoom_checkout_time();
					String[] row = { Integer.toString(room_no), Integer.toString(room_state),
							Integer.toString(room_capacity), room_checkin_time, room_checkout_time };
					model.addRow(row);
				}

			}
		});
		
		Delete_Rm.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) { // Ensure a row is selected
		            // Get the values from the selected row
		            String room_no = table.getValueAt(selectedRow, 0).toString();
		            // Print the values to console
		            System.out.println("선택된 방");
		            System.out.println("Room Number: " + room_no);
		            
		            RoomDTO dto = new RoomDTO();
		            dto.setRoom_no(Integer.parseInt(room_no));
		            
		            RoomService service = new RoomServiceImpl();
		            service.setDao(new RoomDAO());
		            int n = service.remove_R(Integer.parseInt(room_no));
		            System.out.println(n+" 개가 삭제됨.");
		            
		        }
		    }
		});
		
		Update_Rm.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) { // Ensure a row is selected
		            // Get the values from the selected row
		            String room_no = table.getValueAt(selectedRow, 0).toString();
		            String roomState = table.getValueAt(selectedRow, 1).toString();
		            String capacity = table.getValueAt(selectedRow, 2).toString();
		            String checkIn = table.getValueAt(selectedRow, 3).toString();
		            String checkOut = table.getValueAt(selectedRow, 4).toString();
		            // Print the values to console
		            System.out.println("Selected Room:");
		            System.out.println("Room Number: " + room_no);
		            
		            // Create a new JFrame for the update popup
		            JFrame updateFrame = new JFrame("Update Room");
		            updateFrame.setSize(400, 300);
		            
		            // Create text fields for each column
		            JTextField capacityField = new JTextField(10);
		            JTextField stateField = new JTextField(10);
		            JTextField checkinField = new JTextField(10);
		            JTextField checkoutField = new JTextField(10);
		            
		            // Set default values to text fields
		            capacityField.setText(capacity);
		            stateField.setText(roomState);
		            checkinField.setText(checkIn);
		            checkoutField.setText(checkOut);
		            
		            // Add text fields to the frame
		            updateFrame.add(new JLabel("Capacity:"));
		            updateFrame.add(capacityField);
		            updateFrame.add(new JLabel("State:"));
		            updateFrame.add(stateField);
		            updateFrame.add(new JLabel("Check-In Time:"));
		            updateFrame.add(checkinField);
		            updateFrame.add(new JLabel("Check-Out Time:"));
		            updateFrame.add(checkoutField);
		            
		            // Create a button to confirm update
		            JButton updateButton = new JButton("Update");
		            updateButton.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    // Get values from text fields
		                    String newCapacity = capacityField.getText();
		                    String newState = stateField.getText();
		                    String newCheckIn = checkinField.getText();
		                    String newCheckOut = checkoutField.getText();
		                    
		                    // Perform update operation using values
		                    // updateRoom(selectedRow, newCapacity, newState, newCheckIn, newCheckOut);
		                    
		                    // Close the update frame
		                    updateFrame.dispose();
		                }
		            });
		            
		            // Add update button to the frame
		            updateFrame.add(updateButton);
		            
		            // Set layout for the frame
		            updateFrame.setLayout(new FlowLayout());
		            updateFrame.setVisible(true);
		        }
		    }
		});

	}
}