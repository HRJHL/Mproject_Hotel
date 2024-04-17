package com;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.dao.GuestDAO;
import com.dao.RoomDAO;
import com.dto.GuestDTO;
import com.dto.RoomDTO;
import com.service.GuestService;
import com.service.GuestServiceImpl;
import com.service.RoomService;
import com.service.RoomServiceImpl;

public class Master_MK1 {

	private JFrame frame;
	private JTable tableRoom;
	private JTable tableGuest;
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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Panel MPanel = new Panel(); // 메인
		Panel RPanel = new Panel(); // 방 관리
		Panel CPanel = new Panel(); // 고객 관리
		Panel PPanel = new Panel();
		
		
		
		
		
	      PPanel.setBounds(0, 0, 436, 263);
	      frame.getContentPane().add(PPanel);
	      PPanel.setLayout(null);
	     
	      JTextField passwordField = new JPasswordField();
	      passwordField.setToolTipText("Password");
	      passwordField.setBounds(123, 136, 176, 30);
	      PPanel.add(passwordField);
	     
	      JLabel lblNewLabel = new JLabel("비밀번호를 입력하세요");
	      lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
	      lblNewLabel.setBounds(123, 52, 217, 39);
	      PPanel.add(lblNewLabel);
	     
	      JButton PasswordB = new JButton("다음");
	      PasswordB.setBounds(285, 192, 111, 39);
	      PasswordB.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            PPanel.setVisible(false);
	            MPanel.setVisible(true);
	         }
	      });
	      PPanel.add(PasswordB);
		
		
		
		
		
		
		MPanel.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(MPanel);
		MPanel.setLayout(null);

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

		JButton Create_Rm = new JButton("생성");
		Create_Rm.setBounds(31, 190, 91, 23);
		RPanel.add(Create_Rm);

		JButton Update_Rm = new JButton("수정");
		Update_Rm.setBounds(166, 190, 91, 23);
		RPanel.add(Update_Rm);

		JButton Delete_Rm = new JButton("삭제");
		Delete_Rm.setBounds(301, 190, 91, 23);
		RPanel.add(Delete_Rm);

		JButton BackButtonO = new JButton("첫 화면으로");
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


		String headerGuest[] = { "고객 번호", "현재 인원", "고객 이름", "숙박일", "차 번호", "방 번호" };
		DefaultTableModel modelGuest = new DefaultTableModel(headerGuest, 0);
		tableGuest = new JTable(modelGuest);
		tableGuest.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableGuest.setBounds(35, 51, 356, 90);
		JScrollPane scrolledTableG = new JScrollPane(tableGuest); // 수정된 부분
		scrolledTableG.setBounds(35, 51, 356, 90); // 수정된 부분
		CPanel.add(scrolledTableG); // 수정된 부분

		JButton Create_Cu = new JButton("생성");
		Create_Cu.setBounds(35, 168, 91, 23);
		CPanel.add(Create_Cu);

		JButton Update_Cu = new JButton("수정");
		Update_Cu.setBounds(160, 168, 91, 23);
		CPanel.add(Update_Cu);

		JButton Delete_Cu = new JButton("삭제");
		Delete_Cu.setBounds(285, 168, 91, 23);
		CPanel.add(Delete_Cu);

		JButton BackButtonT = new JButton("첫 화면으로");
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
		
		Create_Rm.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {

	            // Create a new JFrame for the update popup
	            JFrame updateFrame = new JFrame("Create Room");
	            updateFrame.setSize(400, 300);

	            // Create text fields for each column
	            JTextField room_noField = new JTextField(10);
	            JTextField capacityField = new JTextField(10);
	            JTextField stateField = new JTextField(10);

	            // Add text fields to the frame
	            updateFrame.add(new JLabel("Room_no:"));
	            updateFrame.add(room_noField);
	            updateFrame.add(new JLabel("Capacity:"));
	            updateFrame.add(capacityField);
	            updateFrame.add(new JLabel("State:"));
	            updateFrame.add(stateField);

	            // Create a button to confirm update
	            JButton updateButton = new JButton("생성완료");
	            updateButton.addActionListener(new ActionListener() {
	               @Override
	               public void actionPerformed(ActionEvent e) {
	                  // Get values from text fields
	                  int room_no = Integer.parseInt(room_noField.getText());
	                  int capacity = Integer.parseInt(capacityField.getText());
	                  int state = Integer.parseInt(stateField.getText());

	                  RoomDTO dto = new RoomDTO();
	                  dto.setRoom_no(room_no);
	                  dto.setRoom_capacity(capacity);
	                  dto.setRoom_state(state);

	                  RoomService service = new RoomServiceImpl();
	                  service.setDao(new RoomDAO());

	                  int n = service.save_R(dto);
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
				String car_no;
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
					car_no = s.getCar_no();

					String[] row = { guest_pno, Integer.toString(m_count), guest_name, Integer.toString(stay_days),
							car_no, Integer.toString(room_no) };

					model.addRow(row);
				}

			}
		});

		// 고객
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
					int n = service.remove_G(guest_pno);
					System.out.println(n + " 개가 삭제됨.");

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
			
		});
		
		
	    // 버튼: 메인 패널에 Guest GUI 열기
	    JButton btnOpenGuestGUIMain = new JButton("Open Guest GUI");
	    btnOpenGuestGUIMain.setBounds(0, 223, 150, 30);
	    btnOpenGuestGUIMain.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Guest_GUI0415 guestGUI = new Guest_GUI0415();
	            guestGUI.setVisible(true);
	        }
	    });
	    MPanel.add(btnOpenGuestGUIMain);

	    // 버튼: 방 관리 패널에 Guest GUI 열기
	    JButton btnOpenGuestGUIRoom = new JButton("Open Guest GUI");
	    btnOpenGuestGUIRoom.setBounds(0, 223, 150, 30);
	    btnOpenGuestGUIRoom.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Guest_GUI0415 guestGUI = new Guest_GUI0415();
	            guestGUI.setVisible(true);
	        }
	    });
	    RPanel.add(btnOpenGuestGUIRoom);

	    // 버튼: 고객 관리 패널에 Guest GUI 열기
	    JButton btnOpenGuestGUICustomer = new JButton("Open Guest GUI");
	    btnOpenGuestGUICustomer.setBounds(0, 223, 150, 30);
	    btnOpenGuestGUICustomer.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Guest_GUI0415 guestGUI = new Guest_GUI0415();
	            guestGUI.setVisible(true);
	        }
	    });
	    CPanel.add(btnOpenGuestGUICustomer);

		
		
	}




}

