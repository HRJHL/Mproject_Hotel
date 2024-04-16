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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Guest_GUI extends JFrame {
	
    private JPanel contentPane;
    private JPanel page1;
    private JPanel page2;
    private JPanel page3;
    private JPanel page4;
    private JPanel page5;
    private String state;
    private JLabel stateLabel;
    private JTextField phoneNum;
    private JTextField carNum;
    private JTextField timeNum;
    private int lastpage;
    private JLabel time;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Guest_GUI frame = new Guest_GUI();
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
    public Guest_GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    
    private void initializePage1() {
        page1 = new JPanel();
        page1.setBounds(0, 0, 634, 442);
        page1.setLayout(null);
        
        
        
		String headerRoom[] = { "방 번호", "현재 상태", "수용 가능 인원", "체크인", "체크아웃" };
		DefaultTableModel modelRoom = new DefaultTableModel(headerRoom, 0);
		JTable tableRoom = new JTable(modelRoom);
		tableRoom.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableRoom.setBounds(31, 62, 381, 119);
		JScrollPane scrolledTable = new JScrollPane(tableRoom); // 수정된 부분
		scrolledTable.setBounds(80, 32, 381, 119); // 수정된 부분
		page1.add(scrolledTable); // 수정된 부분
        
        
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

        
        
        
        JButton btnToPage4 = new JButton("다음");
        btnToPage4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lastpage = 2;
                showPage(4);
            }
        });
        btnToPage4.setBounds(484, 0, 150, 30);
        page2.add(btnToPage4);
        
        JButton btnToPage1 = new JButton("이전");
        btnToPage1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lastpage = 2;
                showPage(1);
            }
        });
        btnToPage1.setBounds(0, 0, 150, 30);
        page2.add(btnToPage1);
        phoneNum = new JTextField();
        phoneNum.setBounds(300, 150, 200, 30);
        page2.add(phoneNum);

        carNum = new JTextField();
        carNum.setBounds(300, 200, 200, 30);
        page2.add(carNum);
        
        timeNum = new JTextField();
        timeNum.setBounds(300, 250, 200, 30);
        page2.add(timeNum);
        
        JLabel label2 = new JLabel("차량 번호:");
        label2.setBounds(200, 200, 100, 30);  // 위치와 크기 설정
        page2.add(label2);
        JLabel label1 = new JLabel("전화번호:");
        label1.setBounds(200, 150, 100, 30);  // 위치와 크기 설정
        page2.add(label1);
        
        time = new JLabel(":");
        time.setBounds(200, 250, 100, 30);  // 위치와 크기 설정
        page2.add(time);
        
    }
//퇴실,연장의 경우 3페이지로 넘어가며 전화번호로 방과 고객 정보를 인식하고 이를 처리 합니다.
    private void initializePage3() {
        page3 = new JPanel();
        page3.setBounds(0, 0, 634, 442);
        page3.setLayout(null);

        //stateLabel = new JLabel(state);
        //stateLabel.setBounds(250, 100, 150, 30);
        page3.add(stateLabel);
        
        JButton btnToPage4 = new JButton("다음");
        btnToPage4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lastpage = 3;
            	if(state.equals("연장")) {
            		showPage(4);
                	}
            	else {
            		showPage(5);
            		}
            }
        });
        btnToPage4.setBounds(484, 0, 150, 30);
        page3.add(btnToPage4);
        
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
    }
}
