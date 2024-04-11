package hotel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class hello {

	public static void main(String[] args) {
		System.out.println("hello");
		System.out.println("잘보이시나요");

		System.out.println("네");

		System.out.println("네");

		System.out.println("한영욱 업로드");

		System.out.println("한영욱 업로드");
		System.out.println("장호영 업로드");
		System.out.println("네");

		Date currentDate = new Date();
		// 날짜 포맷을 지정
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 현재 시간을 요청한 형식으로 포맷하여 출력
		String formattedDate = dateFormat.format(currentDate);
		System.out.println("현재 시간: " + formattedDate);
	}

}
