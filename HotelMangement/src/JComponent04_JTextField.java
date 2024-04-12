
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dao.RoomDAO;
import com.dto.RoomDTO;
import com.service.HotelService;
import com.service.HotelServiceImpl;

public class JComponent04_JTextField extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfRoomNo;
	private JTextField tfRoomCapacity;
	private JTextField tfRoomState;
	private JTextField tfRoomCheckIn;
	private JTextField tfRoomCheckOut;
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

		tfRoomNo = new JTextField();
		tfRoomNo.setBounds(86, 54, 116, 21);
		contentPane.add(tfRoomNo);
		tfRoomNo.setColumns(10);

		JLabel lblNewLabel = new JLabel("방 번호");
		lblNewLabel.setBounds(12, 57, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("사용가능 인원 수");
		lblNewLabel_1.setBounds(12, 88, 57, 15);
		contentPane.add(lblNewLabel_1);

		tfRoomCapacity = new JTextField();
		tfRoomCapacity.setColumns(10);
		tfRoomCapacity.setBounds(86, 85, 116, 21);
		contentPane.add(tfRoomCapacity);

		JLabel lblNewLabel_2 = new JLabel("방 상태");
		lblNewLabel_2.setBounds(12, 125, 57, 15);
		contentPane.add(lblNewLabel_2);

		tfRoomState = new JTextField();
		tfRoomState.setColumns(10);
		tfRoomState.setBounds(86, 122, 116, 21);
		contentPane.add(tfRoomState);

		btnSave = new JButton("저장");
		btnSave.setBounds(39, 179, 97, 23);
		contentPane.add(btnSave);

		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String roomNo = tfRoomNo.getText();
				String roomCapacity = tfRoomCapacity.getText();
				String roomState = tfRoomState.getText();

				Date currentDate = new Date();

				// 체크아웃 시간 계산-> 체크인: 현재시간, 체크아웃: 다음주
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(currentDate);
				calendar.add(Calendar.WEEK_OF_YEAR, 1);
				Date nextWeekDate = calendar.getTime();

				// 날짜 포맷을 지정
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				// 현재 시간을 요청한 형식으로 포맷하여 출력
				String checkInDate = dateFormat.format(currentDate);
				String checkOutDate = dateFormat.format(nextWeekDate);

				System.out.println(
						roomNo + "\t" + roomCapacity + "\t" + roomState + "\t" + checkInDate + "\t" + checkOutDate);

				RoomDTO dto = new RoomDTO();
				dto.setRoom_no(Integer.parseInt(roomNo));
				dto.setRoom_capacity(Integer.parseInt(roomCapacity));
				dto.setRoom_state(Integer.parseInt(roomState));
				dto.setCheckIn(checkInDate);
				dto.setCheckOut(checkOutDate);

				HotelService service = new HotelServiceImpl();
				service.setRoomDao(new RoomDAO());
				service.findAllRoom();
				int n = service.saveRoom(dto);
				System.out.println(n + "개가 저장됨");
				JOptionPane.showInternalMessageDialog(null, n + "개가 저장됨", "저장", JOptionPane.INFORMATION_MESSAGE);
			}
		});

	}
}
