package com.dto;

public class HotelDTO {

	// emp 테이블의 컬럼명과 일치 권장.
	String passwd;

	public HotelDTO() {
	} // 기본 생성자 필수 (**************)

	public HotelDTO(String passwd) {
		this.passwd = passwd;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "HotelDTO [passwd=" + passwd + "]";
	}

}
