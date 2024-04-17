package com;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dao.GuestDAO;
import com.dao.RoomDAO;
import com.dto.GuestDTO;
import com.dto.RoomDTO;
import com.service.GuestService;
import com.service.GuestServiceImpl;
import com.service.RoomService;
import com.service.RoomServiceImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Guest_GUI0415 extends JFrame {
	
    private JPanel contentPane;
    private JPanel page1;
    private JPanel page2;
    private JPanel page3;
    private JPanel page4;
    private JPanel page5;
    private String state;
    private JLabel stateLabel;
    public JTextField phoneNum;
    private JTextField carNum;
    private JTextField timeNum;
    private JTextField name;
    private int lastpage;
    private JLabel time;
    JTable tableRoom;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Guest_GUI0415 frame = new Guest_GUI0415();
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
    public Guest_GUI0415() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	setBounds(100, 100, 650, 480);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        stateLabel = new JLabel("초기값");
        stateLabel.setBounds(250, 100, 150, 30);
        // Initialize all pages
        initializePage1();
        initializePage2();
        initializePage3();
        initializePage4();
        initializePage5();

        // Add pages to content pane
        contentPane.add(page1);
        contentPane.add(page2);
        contentPane.add(page3);
        contentPane.add(page4);
        contentPane.add(page5);

        // Show only the first page initially
        showPage(1);
    }
// 원하는 페이지를 호출해주는  메서드 입니다.
    private void showPage(int pageNumber) {
        page1.setVisible(pageNumber == 1);
        page2.setVisible(pageNumber == 2);
        page3.setVisible(pageNumber == 3);
        page4.setVisible(pageNumber == 4);
        page5.setVisible(pageNumber == 5);
    }
    
    public void initializePage1() {
        page1 = new JPanel();
        page1.setBounds(0, 0, 634, 442);
        page1.setLayout(null);
        
        
        
		String headerRoom[] = { "방 번호", "현재 상태", "수용 가능 인원", "체크인", "체크아웃" };
		DefaultTableModel modelRoom = new DefaultTableModel(headerRoom, 0);
		tableRoom = new JTable(modelRoom);
		tableRoom.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableRoom.setBounds(31, 62, 381, 119);
		JScrollPane scrolledTable = new JScrollPane(tableRoom); // 수정된 부분
		scrolledTable.setBounds(80, 32, 381, 119); // 수정된 부분
		page1.add(scrolledTable); // 수정된 부분
        
		JButton headr = new JButton("목록");
	      headr.setBounds(80, 10, 80, 20);
	      headr.addActionListener(new ActionListener() {
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
	            List<RoomDTO> list = service.find_Empty();
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
		page1.add(headr);
		
//버튼 4개를 띄웁니다.
        JButton stayBtn = new JButton("숙박");
        stayBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPage(2);
                state = "숙박";
                lastpage = 1;
                stateLabel.setText(state);
                time.setText("숙박 일수:");
            }
        });
        stayBtn.setBounds(85, 172, 150, 30);
        JButton shortBtn;
        shortBtn = new JButton("대실");
        shortBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		showPage(2);
        		state = "대실";
        		lastpage = 1;
        		stateLabel.setText(state);
        		time.setText("대실 시간:");
        	}
        });
        shortBtn.setBounds(85, 261, 150, 30);
   //
        JButton checkoutBtn = new JButton("퇴실");
        checkoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPage(3);
                state = "퇴실";
                lastpage = 1;
                stateLabel.setText(state);
            }
        });
        checkoutBtn.setBounds(300, 172, 150, 30);
        
        ///////////////////////////////////////
        JButton extendBtn;
        extendBtn = new JButton("연장");
        extendBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		showPage(3);
        		state = "연장";
        		lastpage = 1;
        		stateLabel.setText(state);
        	}
        });
        extendBtn.setBounds(300, 261, 150, 30);
        //////////////////////////////////////////
        page1.add(checkoutBtn);
        page1.add(extendBtn);
        page1.add(shortBtn);
        page1.add(stayBtn);
        
        
        
        
        
        JButton btnOpenMasterMK1 = new JButton("@");
        btnOpenMasterMK1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Master_MK1의 main 메소드를 호출하여 실행
                com.Master_MK1.main(null);
            }
        });
        btnOpenMasterMK1.setBounds(0, 400, 50, 30);
        page1.add(btnOpenMasterMK1);
        
        
        
        
    }
//페이지 2는 숙박/대실의 경우 들어갑니다.
//전화 번호, 차량번호를 입력 받습니다.
    private void initializePage2() {
        page2 = new JPanel();
        page2.setBounds(0, 0, 634, 442);
        page2.setLayout(null);
        
        //stateLabel = new JLabel(state);
        //stateLabel.setBounds(250, 100, 150, 30);
        System.out.println(state);
        page2.add(stateLabel);
        // stateLabel.setVisible(true);

        
        JButton btnToPage1 = new JButton("이전");
        btnToPage1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lastpage = 2;
                showPage(1);
            }
        });
        btnToPage1.setBounds(0, 0, 150, 30);
        page2.add(btnToPage1);
        
        JTextField phoneNum2 = new JTextField();
        phoneNum2.setBounds(300, 150, 200, 30);
        page2.add(phoneNum2);
        
        name = new JTextField();
        name.setBounds(300, 200, 200, 30);
        page2.add(name);

        carNum = new JTextField();
        carNum.setBounds(300, 250, 200, 30);
        page2.add(carNum);
        
        timeNum = new JTextField();
        timeNum.setBounds(300, 300, 200, 30);
        page2.add(timeNum);
        
        JLabel label2 = new JLabel("차량 번호:");
        label2.setBounds(200, 250, 100, 30);  // 위치와 크기 설정
        page2.add(label2);
        JLabel label1 = new JLabel("전화번호:");
        label1.setBounds(200, 150, 100, 30);  // 위치와 크기 설정
        page2.add(label1);
        
        JLabel label3 = new JLabel("이름:");
        label3.setBounds(200, 200, 100, 30);  // 위치와 크기 설정
        page2.add(label3);
        
        time = new JLabel(":");
        time.setBounds(200, 300, 100, 30);  // 위치와 크기 설정
        page2.add(time);
        
        JButton btnToPage4 = new JButton("다음");
        btnToPage4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int selectedRow = tableRoom.getSelectedRow();
            	String room_no= "";
            	if (selectedRow != -1) { // Ensure a row is selected
					// Get the values from the selected row
					room_no = tableRoom.getValueAt(selectedRow, 0).toString();
					// Print the values to console
					System.out.println("선택된 방");
					System.out.println("Room Number: " + room_no);
				}
				String guest_pno2 = phoneNum2.getText();
                String car_no = carNum.getText();
                String guest_name = name.getText();
                String stay_days = timeNum.getText();
                String room_no2 = room_no;
                
                GuestDTO dto = new GuestDTO();
	            dto.setGuest_pno(guest_pno2);
	            dto.setGuest_name(guest_name);
	            dto.setStay_days(Integer.parseInt(stay_days));
	            dto.setCar_no(car_no);
	            dto.setRoom_no(Integer.parseInt(room_no2));
	            
	            GuestService service = new GuestServiceImpl();
	            service.setDao(new GuestDAO());
	            
	            int n = service.save_P(dto);
	            System.out.println("폰번호: " + phoneNum2.getText());
	            System.out.println("이름: " + name.getText());
	            System.out.println("폰번호: " + guest_pno2);
	            System.out.println(n+"생성됨.");
	            
	            lastpage = 2;
                showPage(4);
		        }
            
        });
        
        btnToPage4.setBounds(484, 0, 150, 30);
        page2.add(btnToPage4);
        JButton btnOpenMasterMK1 = new JButton("@");
        btnOpenMasterMK1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Master_MK1의 main 메소드를 호출하여 실행
                com.Master_MK1.main(null);
            }
        });
        btnOpenMasterMK1.setBounds(0, 400, 50, 30);
        page2.add(btnOpenMasterMK1);
        
    }
//퇴실,연장의 경우 3페이지로 넘어가며 전화번호로 방과 고객 정보를 인식하고 이를 처리 합니다.
    private void initializePage3() {
        page3 = new JPanel();
        page3.setBounds(0, 0, 634, 442);
        page3.setLayout(null);

        //stateLabel = new JLabel(state);
        //stateLabel.setBounds(250, 100, 150, 30);
        page3.add(stateLabel);
        
        
        JButton btnToPage1 = new JButton("이전");
        btnToPage1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lastpage = 3;
                showPage(1);
            }
        });
        btnToPage1.setBounds(0, 0, 150, 30);
        page3.add(btnToPage1);
        
        JLabel label1 = new JLabel("전화번호:");
        label1.setBounds(200, 150, 100, 30);  // 위치와 크기 설정
        page3.add(label1);
        
        phoneNum = new JTextField();
        phoneNum.setBounds(300, 150, 200, 30);
        page3.add(phoneNum);
        
        JButton btnToPage4 = new JButton("다음");
        btnToPage4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lastpage = 3;
            	if(state.equals("연장")) {
    				String guest_pno;
    				int m_count;
    				String guest_name;
    				int stay_days=0;
    				String car_no;
    				int room_no;
    				
    				String guest_pno2 = phoneNum.getText();
            		int stay_days2=0;
            		
    				GuestService service = new GuestServiceImpl();
					service.setDao(new GuestDAO());
    				List<GuestDTO> list = service.find_G();
    				for (GuestDTO s : list) {
    					guest_pno = s.getGuest_pno();
    					m_count = s.getM_count();
    					guest_name = s.getGuest_name();
    					stay_days = s.getStay_days();
    					car_no = s.getCar_no();
    					room_no= s.getRoom_no();
    					System.out.println(guest_pno2);
    					if(guest_pno.equals(guest_pno2)) {
    						System.out.println("연장되었습니다");
    						stay_days2 = stay_days+1;
    					}
    				}
    				
            		
					GuestDTO dto = new GuestDTO();
					dto.setGuest_pno(guest_pno2);
					dto.setStay_days(stay_days2);
					
					

					int n = service.update_P(dto);
					System.out.println(n + "업데이트됨.");

            		showPage(4);
                	}
            	else {
            		String guest_pno = phoneNum.getText();
					System.out.println("선택된 고객");
					System.out.println("Guest number: " + guest_pno);

					GuestDTO dto = new GuestDTO();
					dto.setGuest_pno(guest_pno);

					GuestService service = new GuestServiceImpl();
					service.setDao(new GuestDAO());
					int n = service.remove_G(guest_pno);
					System.out.println(n + " 개가 삭제됨.");
            		showPage(5);
            		}
            }
        });
        btnToPage4.setBounds(484, 0, 150, 30);
        page3.add(btnToPage4);
        
        JButton btnOpenMasterMK1 = new JButton("@");
        btnOpenMasterMK1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Master_MK1의 main 메소드를 호출하여 실행
                com.Master_MK1.main(null);
            }
        });
        btnOpenMasterMK1.setBounds(0, 400, 50, 30);
        page3.add(btnOpenMasterMK1);
    }
//결제 창
// 퇴실이 아니라면 결제창으로 넘어옵니다.
    private void initializePage4() {
        page4 = new JPanel();
        page4.setBounds(0, 0, 634, 442);
        page4.setLayout(null);
        JLabel pay;
        pay = new JLabel("결제해주십시오");
        pay.setBounds(250, 100, 150, 30);
        page4.add(pay);
        
        JButton btnToPage5 = new JButton("다음");
        btnToPage5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lastpage = 4;
                showPage(5);
            }
        });
        btnToPage5.setBounds(484, 0, 150, 30);
        page4.add(btnToPage5);
        
        JButton btnlastpage = new JButton("이전");
        btnlastpage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
   
                showPage(lastpage);
                lastpage = 4;
            }
        });
        btnlastpage.setBounds(0, 0, 150, 30);
        page4.add(btnlastpage);
        page4.add(btnToPage5);
        JButton btnOpenMasterMK1 = new JButton("@");
        btnOpenMasterMK1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Master_MK1의 main 메소드를 호출하여 실행
                com.Master_MK1.main(null);
            }
        });
        btnOpenMasterMK1.setBounds(0, 400, 50, 30);
        page4.add(btnOpenMasterMK1);
    }

    private void initializePage5() {
        page5 = new JPanel();
        page5.setBounds(0, 0, 634, 442);
        page5.setLayout(null);
        JLabel thank;
        thank = new JLabel("감사합니다");
        thank.setBounds(250, 100, 150, 30);
        page5.add(thank);
        JButton btnToPage1 = new JButton("처음으로");
        btnToPage1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPage(1);
            }
        });
        btnToPage1.setBounds(250,  200, 150, 30);
        page5.add(btnToPage1);
        
        
        // Master_MK1 실행 버튼 추가
        JButton btnOpenMasterMK1 = new JButton("@");
        btnOpenMasterMK1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Master_MK1의 main 메소드를 호출하여 실행
                com.Master_MK1.main(null);
            }
        });
        btnOpenMasterMK1.setBounds(0, 400, 50, 30);
        page5.add(btnOpenMasterMK1);
    }
}
