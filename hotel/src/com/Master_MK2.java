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

import com.dao.GuestDAO;
import com.dto.GuestDTO;
import com.service.GuestService;
import com.service.GuestServiceImpl;

public class Master_MK2 {

	private JFrame frame;
	private JTable tableRoom;
	private JTable tableRoom2;
	private JTable tableGuest;
	JPanel HPanel;
	JPanel MPanel;
	JPanel CPanel;
	JPanel RPanel;
	JPanel page1;
	JPanel page2;
	JPanel page3;
	JPanel page4;
	JPanel page5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Master_MK2 window = new Master_MK2();
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
	public Master_MK2() {
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
		
		Panel HPanel = new Panel(); // 홈
		Panel MPanel = new Panel(); // 메인
		Panel RPanel = new Panel(); // 방 관리
		Panel CPanel = new Panel(); // 고객 관리
		Panel page1 = new Panel(); // 고객 메인
		Panel page2 = new Panel(); // 숙박/대실
		Panel page3 = new Panel(); 
		Panel page4 = new Panel();
		Panel page5 = new Panel();
		
		page1.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(page1);
		page1.setLayout(null);
		page1.setVisible(false);
		
		String headerRoom2[] = { "방 번호", "현재 상태", "수용 가능 인원", "체크인", "체크아웃" };
		DefaultTableModel modelRoom2 = new DefaultTableModel(headerRoom2, 0);
		JTable tableRoom2 = new JTable(modelRoom2);
		tableRoom2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableRoom2.setBounds(35, 51, 356, 90);
		JScrollPane scrolledTable2 = new JScrollPane(tableRoom2); // 수정된 부분
		scrolledTable2.setBounds(35, 51, 356, 90); // 수정된 부분
		page1.add(scrolledTable2); // 수정된 부분
		
		JButton headr = new JButton("목록");
		headr.setBounds(40, 10, 90, 30);
		headr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model2 = (DefaultTableModel) tableRoom2.getModel();

				model2.setRowCount(0);
				int room_no;
				int room_state;
				int room_capacity;
				String room_checkin_time;
				String room_checkout_time;
				
				RoomService service = new RoomServiceImpl();
				service.setDao(new RoomDAO());
				List<RoomDTO> list = service.find_Q();
				for (RoomDTO s : list) {
					room_no = s.getRoom_no();
					room_state = s.getRoom_state();
					room_capacity = s.getRoom_capacity();
					room_checkin_time = s.getRoom_checkin_time();
					room_checkout_time = s.getRoom_checkout_time();
					

					String[] row = { Integer.toString(room_no), Integer.toString(room_state), Integer.toString(room_capacity),room_checkin_time, room_checkout_time};

					model2.addRow(row);
				}
			}
		});
		page1.add(headr);
		
		JButton stayBtn = new JButton("숙박");
		stayBtn.setBounds(40, 150, 90, 30);
		stayBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CPanel.setVisible(false);
				MPanel.setVisible(false);
				RPanel.setVisible(false);
				page1.setVisible(false);
				page2.setVisible(true);
			}
		});
		page1.add(stayBtn);
		
		JButton shortBtn = new JButton("대실");
		shortBtn.setBounds(160, 150, 90, 30);
		shortBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CPanel.setVisible(false);
				MPanel.setVisible(false);
				RPanel.setVisible(false);
				page1.setVisible(false);
				page2.setVisible(true);
			}
		});
		page1.add(shortBtn);
		
		JButton checkBtn = new JButton("퇴실");
		checkBtn.setBounds(40, 200, 90, 30);
		checkBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CPanel.setVisible(false);
				MPanel.setVisible(false);
				RPanel.setVisible(false);
				page1.setVisible(false);
				page2.setVisible(false);
				page3.setVisible(true);
			}
		});
		page1.add(checkBtn);
		//페이지1
		JButton extendBtn = new JButton("연장");
		extendBtn.setBounds(160, 200, 90, 30);
		extendBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CPanel.setVisible(false);
				MPanel.setVisible(false);
				RPanel.setVisible(false);
				page1.setVisible(false);
				page2.setVisible(false);
				page3.setVisible(true);
			}
		});
		page1.add(extendBtn);
		
		
		JButton PBackButton = new JButton("고객 관리자");
		PBackButton.setBounds(325, 223, 99, 30);
		PBackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CPanel.setVisible(false);
				RPanel.setVisible(false);
				MPanel.setVisible(false);
				page1.setVisible(false);
				HPanel.setVisible(true);
			}
		});
		page1.add(PBackButton);
		
		page2.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(page2);
		page2.setLayout(null);
		page2.setVisible(false);
		
		JButton p2backButton = new JButton("이전");
		p2backButton.setBounds(50, 223, 99, 30);
		p2backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				page2.setVisible(false);
				page1.setVisible(true);
			}
		});
		page2.add(p2backButton);
		
		JTextField phoneNum = new JTextField();
        phoneNum.setBounds(100, 50, 200, 30);
        page2.add(phoneNum);

        JTextField carNum = new JTextField();
        carNum.setBounds(100, 90, 200, 30);
        page2.add(carNum);
        
        JTextField name = new JTextField();
        name.setBounds(100, 130, 200, 30);
        page2.add(name);
        
        JLabel label2 = new JLabel("차량 번호:");
        label2.setBounds(30, 50, 100, 30);  // 위치와 크기 설정
        page2.add(label2);
        JLabel label1 = new JLabel("전화번호:");
        label1.setBounds(30, 90, 100, 30);  // 위치와 크기 설정
        page2.add(label1);
        
        JLabel time = new JLabel(" 시간 :");
        time.setBounds(30, 130, 100, 30);  // 위치와 크기 설정
        page2.add(time);
        
        JButton p2nextButton = new JButton("다음");
		p2nextButton.setBounds(220, 223, 99, 30);
		p2nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableRoom2.getSelectedRow();
		        if (selectedRow != -1) { // Ensure a row is selected
		            // Get the values from the selected row
		            String room_no = tableRoom2.getValueAt(selectedRow, 0).toString();
		            String capacity = tableRoom2.getValueAt(selectedRow, 2).toString();
				page2.setVisible(false);
				page4.setVisible(true);
				
				String guest_pno = phoneNum.getText();
				String m_count = capacity;
                String car_no = carNum.getText();
                String guest_name = name.getText();
                
                GuestDTO dto = new GuestDTO();
	            dto.setGuest_pno(guest_pno);
	            dto.setM_count(Integer.parseInt(m_count));
	            dto.setCar_no(car_no);
	            dto.setGuest_name(guest_name);
       
	            
	            GuestService service = new GuestServiceImpl();
	            service.setDao(new GuestDAO());
	            
	            int n = service.save_P(dto);
	            System.out.println(n+"업데이트됨.");
		        }
			}
		});
		page2.add(p2nextButton);
	
        
		HPanel.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(HPanel);
		HPanel.setLayout(null);
		
		JButton HBackButton = new JButton("메인 화면으로");
		HBackButton.setBounds(325, 223, 99, 30);
		HPanel.add(HBackButton);

		JButton HCButton = new JButton("고객용");
		HCButton.setBounds(108, 23, 246, 81);
		HCButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HPanel.setVisible(false);
				CPanel.setVisible(false);
				MPanel.setVisible(false);
				RPanel.setVisible(false);
				page1.setVisible(true);
			}
		});
		HPanel.add(HCButton);

		JButton HRButton = new JButton("관리자용");
		HRButton.setBounds(106, 116, 246, 81);
		HRButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HPanel.setVisible(false);
				MPanel.setVisible(true);
				RPanel.setVisible(false);
				CPanel.setVisible(false);
				page1.setVisible(false);
			}
		});
		HPanel.add(HRButton);
		
		MPanel.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(MPanel);
		MPanel.setLayout(null);

		JButton BackButton = new JButton("고객 관리자");
		BackButton.setBounds(325, 223, 99, 30);
		BackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CPanel.setVisible(false);
				RPanel.setVisible(false);
				MPanel.setVisible(false);
				page1.setVisible(false);
				HPanel.setVisible(true);
			}
		});
		MPanel.add(BackButton);

		JButton CButton = new JButton("고객 관리");
		CButton.setBounds(108, 23, 246, 81);
		CButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CPanel.setVisible(true);
				MPanel.setVisible(false);
				RPanel.setVisible(false);
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

		String headerRoom[] = { "방 번호", "현재 상태", "수용 가능 인원", "체크인", "체크아웃" };
		DefaultTableModel modelRoom = new DefaultTableModel(headerRoom, 0);
		tableRoom = new JTable(modelRoom);
		tableRoom.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableRoom.setBounds(31, 62, 381, 119);
		JScrollPane scrolledTable = new JScrollPane(tableRoom); // 수정된 부분
		scrolledTable.setBounds(31, 62, 381, 119); // 수정된 부분
		RPanel.add(scrolledTable); // 수정된 부분

		JButton Create_Rm = new JButton("생성 방");
		Create_Rm.setBounds(31, 204, 91, 23);
		RPanel.add(Create_Rm);

		JButton Update_Rm = new JButton("수정 방");
		Update_Rm.setBounds(166, 204, 91, 23);
		RPanel.add(Update_Rm);

		JButton Delete_Rm = new JButton("삭제 방");
		Delete_Rm.setBounds(301, 204, 91, 23);
		RPanel.add(Delete_Rm);

		JButton BackButtonO = new JButton("관리자페이지");
		BackButtonO.setBounds(323, 237, 101, 26);
		BackButtonO.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CPanel.setVisible(false);
				RPanel.setVisible(false);
				MPanel.setVisible(true);
			}
		});
		RPanel.add(BackButtonO);

		CPanel.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(CPanel);
		CPanel.setLayout(null);

		JButton PCus = new JButton("숙박 고객");
		PCus.setBounds(35, 10, 152, 31);
		CPanel.add(PCus);

		JButton RCus = new JButton("예약 고객");
		RCus.setBounds(239, 10, 152, 31);
		CPanel.add(RCus);

		String headerGuest[] = { "고객 번호", "현재 인원", "고객 이름", "숙박일", "차 번호", "방 번호" };
		DefaultTableModel modelGuest = new DefaultTableModel(headerGuest, 0);
		tableGuest = new JTable(modelGuest);
		tableGuest.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableGuest.setBounds(35, 51, 356, 90);
		JScrollPane scrolledTableG = new JScrollPane(tableGuest); // 수정된 부분
		scrolledTableG.setBounds(35, 51, 356, 90); // 수정된 부분
		CPanel.add(scrolledTableG); // 수정된 부분

		JButton Create_Cu = new JButton("생성 숙");
		Create_Cu.setBounds(35, 168, 91, 23);
		CPanel.add(Create_Cu);

		JButton Update_Cu = new JButton("수정 숙");
		Update_Cu.setBounds(160, 168, 91, 23);
		CPanel.add(Update_Cu);

		JButton Delete_Cu = new JButton("삭제 숙");
		Delete_Cu.setBounds(285, 168, 91, 23);
		CPanel.add(Delete_Cu);

		JButton BackButtonT = new JButton("관리자페이지");
		BackButtonT.setBounds(333, 230, 91, 23);
		BackButtonT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CPanel.setVisible(false);
				MPanel.setVisible(true);
			}
		});
		CPanel.add(BackButtonT);

		OButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableRoom.getModel();
				model.setRowCount(0);
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

				DefaultTableModel model = (DefaultTableModel) tableRoom.getModel();
				model.setRowCount(0);
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
				DefaultTableModel model = (DefaultTableModel) tableRoom.getModel();
				model.setRowCount(0);
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
				int selectedRow = tableRoom.getSelectedRow();
				if (selectedRow != -1) { // Ensure a row is selected
					// Get the values from the selected row
					String room_no = tableRoom.getValueAt(selectedRow, 0).toString();
					// Print the values to console
					System.out.println("선택된 방");
					System.out.println("Room Number: " + room_no);

					RoomDTO dto = new RoomDTO();
					dto.setRoom_no(Integer.parseInt(room_no));

					RoomService service = new RoomServiceImpl();
					service.setDao(new RoomDAO());
					int n = service.remove_R(Integer.parseInt(room_no));
					System.out.println(n + " 개가 삭제됨.");

				}
			}
		});

		Update_Rm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableRoom.getSelectedRow();
				if (selectedRow != -1) { // Ensure a row is selected
					// Get the values from the selected row
					String room_no = tableRoom.getValueAt(selectedRow, 0).toString();
					String roomState = tableRoom.getValueAt(selectedRow, 1).toString();
					String capacity = tableRoom.getValueAt(selectedRow, 2).toString();
					String checkIn = null;
					if (tableRoom.getValueAt(selectedRow, 3) == null) {
						checkIn = null;
					} else
						tableRoom.getValueAt(selectedRow, 3).toString();
					String checkOut = null;
					if (tableRoom.getValueAt(selectedRow, 4) == null) {
						checkOut = null;
					} else
						tableRoom.getValueAt(selectedRow, 3).toString();
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
					JButton updateButton = new JButton("수정완료");
					updateButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// Get values from text fields
							String room_capacity = capacityField.getText();
							String room_state = stateField.getText();
							String room_checkin_time = checkinField.getText();
							String room_checkout_time = checkoutField.getText();

							RoomDTO dto = new RoomDTO();
							dto.setRoom_no(Integer.parseInt(room_no));
							dto.setRoom_capacity(Integer.parseInt(room_capacity));
							dto.setRoom_state(Integer.parseInt(room_state));
							dto.setRoom_checkin_time(room_checkin_time);
							dto.setRoom_checkout_time(room_checkout_time);
							RoomService service = new RoomServiceImpl();
							service.setDao(new RoomDAO());

							int n = service.update_R(dto);
							System.out.println(n + "업데이트됨.");

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

		PCus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableGuest.getModel();

				model.setRowCount(0);
				String guest_pno;
				int m_count;
				String guest_name;
				int stay_days;
				
				int room_no;

				GuestService service = new GuestServiceImpl();
				service.setDao(new GuestDAO());
				List<GuestDTO> list = service.find_G();
				for (GuestDTO s : list) {
					room_no = s.getRoom_no();
					guest_pno = s.getGuest_pno();
					guest_name = s.getGuest_name();
					m_count = s.getM_count();
					stay_days = s.getStay_days();
					

					String[] row = { guest_pno, Integer.toString(m_count), guest_name, Integer.toString(stay_days),
							 Integer.toString(room_no) };

					model.addRow(row);
				}

			}
		});
		
		Delete_Rm.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = tableRoom.getSelectedRow();
		        if (selectedRow != -1) { // Ensure a row is selected
		            // Get the values from the selected row
		            String room_no = tableRoom.getValueAt(selectedRow, 0).toString();
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
		        int selectedRow = tableRoom.getSelectedRow();
		        if (selectedRow != -1) { // Ensure a row is selected
		            // Get the values from the selected row
		            String room_no = tableRoom.getValueAt(selectedRow, 0).toString();
		            String roomState = tableRoom.getValueAt(selectedRow, 1).toString();
		            String capacity = tableRoom.getValueAt(selectedRow, 2).toString();
		            String checkIn = tableRoom.getValueAt(selectedRow, 3).toString();
		            String checkOut = tableRoom.getValueAt(selectedRow, 4).toString();
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
		            JButton updateButton = new JButton("수정완료");
		            updateButton.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    // Get values from text fields
		                    String room_capacity = capacityField.getText();
		                    String room_state = stateField.getText();
		                    String room_checkin_time = checkinField.getText();
		                    String room_checkout_time = checkoutField.getText();
		                    
		                    RoomDTO dto = new RoomDTO();
				            dto.setRoom_no(Integer.parseInt(room_no));
				            dto.setRoom_capacity(Integer.parseInt(room_capacity));
				            dto.setRoom_state(Integer.parseInt(room_state));
				            dto.setRoom_checkin_time(room_checkin_time);
				            dto.setRoom_checkout_time(room_checkout_time);
				            RoomService service = new RoomServiceImpl();
				            service.setDao(new RoomDAO());
				            
				            int n = service.update_R(dto);
				            System.out.println(n+"업데이트됨.");
		                    
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
		
		Create_Rm.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		            
		            // Create a new JFrame for the update popup
		            JFrame updateFrame = new JFrame("Create Room");
		            updateFrame.setSize(400, 300);
		            
		            // Create text fields for each column
		            JTextField noField = new JTextField(10);
		            JTextField capacityField = new JTextField(10);
		            
		            
		            
		            // Add text fields to the frame
		            updateFrame.add(new JLabel("No:"));
		            updateFrame.add(noField);
		            updateFrame.add(new JLabel("Capacity:"));
		            updateFrame.add(capacityField);
		            
		            
		            // Create a button to confirm update
		            JButton updateButton = new JButton("생성완료");
		            updateButton.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    // Get values from text fields
		                	String room_no = noField.getText();
		                    String room_capacity = capacityField.getText();
		                    
		                    
		                    RoomDTO dto = new RoomDTO();
				            dto.setRoom_no(Integer.parseInt(room_no));
				            dto.setRoom_capacity(Integer.parseInt(room_capacity));
				            
				            RoomService service = new RoomServiceImpl();
				            service.setDao(new RoomDAO());
				            
				            int n = service.save_R(dto);
				            System.out.println(n+"업데이트됨.");
		                    
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
		    
		});
		
		//고객
		Delete_Cu.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = tableGuest.getSelectedRow();
		        if (selectedRow != -1) { // Ensure a row is selected
		            // Get the values from the selected row
		            String guest_pno = tableGuest.getValueAt(selectedRow, 0).toString();
		            // Print the values to console
		            System.out.println("선택된 고객");
		            System.out.println("Guest number: " + guest_pno);
		            
		            GuestDTO dto = new GuestDTO();
		            dto.setGuest_pno(guest_pno);
		            
		            GuestService service = new GuestServiceImpl();
		            service.setDao(new GuestDAO());
		            int n = service.remove_G(Integer.parseInt(guest_pno));
		            System.out.println(n+" 개가 삭제됨.");
		            
		        }
		    }
		});
		
		Update_Cu.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = tableGuest.getSelectedRow();
		        if (selectedRow != -1) { // Ensure a row is selected
		            // Get the values from the selected row
		            String guest_pno = tableGuest.getValueAt(selectedRow, 0).toString();
		            String m_count = tableGuest.getValueAt(selectedRow, 1).toString();
		            String stay_days = tableGuest.getValueAt(selectedRow, 2).toString();
		            String guest_name = tableGuest.getValueAt(selectedRow, 3).toString();
		            
		            // Print the values to console
		            System.out.println("Selected Room:");
		            System.out.println("Room Number: " + guest_pno);
		            
		            // Create a new JFrame for the update popup
		            JFrame updateFrame = new JFrame("Update Guest");
		            updateFrame.setSize(400, 300);
		            
		            // Create text fields for each column
		            JTextField countField = new JTextField(10);
		            JTextField nameField = new JTextField(10);
		            JTextField daysField = new JTextField(10);
		            
		            // Set default values to text fields
		            countField.setText(m_count);
		            nameField.setText(guest_name);
		            daysField.setText(stay_days);
		            
		            
		            // Add text fields to the frame
		            updateFrame.add(new JLabel("Capacity:"));
		            updateFrame.add(countField);
		            updateFrame.add(new JLabel("State:"));
		            updateFrame.add(nameField);
		            updateFrame.add(new JLabel("Check-In Time:"));
		            updateFrame.add(daysField);
		           
		            
		            // Create a button to confirm update
		            JButton updateButton = new JButton("수정완료");
		            updateButton.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    // Get values from text fields
		                    String m_count = countField.getText();
		                    String guest_name = nameField.getText();
		                    String stay_days = daysField.getText();
		                   
		                    GuestDTO dto = new GuestDTO();
				            dto.setGuest_pno(guest_pno);
				            dto.setM_count(Integer.parseInt(m_count));
				            dto.setStay_days(Integer.parseInt(stay_days));
				            dto.setGuest_name(guest_name);
				            GuestService service = new GuestServiceImpl();
				            service.setDao(new GuestDAO());
				            
				            int n = service.update_G(dto);
				            System.out.println(n+"업데이트됨.");
		                    
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
		
		Create_Cu.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		            
		            // Create a new JFrame for the update popup
		            JFrame updateFrame = new JFrame("Create Guest");
		            updateFrame.setSize(400, 300);
		            
		            // Create text fields for each column
		            JTextField pnoField = new JTextField(10);
		            JTextField nameField = new JTextField(10);
		            JTextField noField = new JTextField(10);
		            
		            
		            
		            // Add text fields to the frame
		            updateFrame.add(new JLabel("Pno:"));
		            updateFrame.add(pnoField);
		            updateFrame.add(new JLabel("No:"));
		            updateFrame.add(noField);
		            updateFrame.add(new JLabel("Name:"));
		            updateFrame.add(nameField);
		            
		            
		            // Create a button to confirm update
		            JButton updateButton = new JButton("생성완료");
		            updateButton.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    // Get values from text fields
		                	String room_no = noField.getText();
		                    String guest_name = nameField.getText();
		                    String guest_pno = pnoField.getText();
		                    
		                    
		                    GuestDTO dto = new GuestDTO();
				            dto.setRoom_no(Integer.parseInt(room_no));
				            dto.setGuest_pno(guest_pno);
				            dto.setGuest_name(guest_name);
				            
				            GuestService service = new GuestServiceImpl();
				            service.setDao(new GuestDAO());
				            
				            int n = service.save_G(dto);
				            System.out.println(n+"업데이트됨.");
		                    
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
		    
		});
	}
}