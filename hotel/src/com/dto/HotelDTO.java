package com.dto;

public class HotelDTO {

	// emp �뀒�씠釉붿쓽 而щ읆紐낃낵 �씪移� 沅뚯옣.
	String passwd;

	public HotelDTO() {
	} // 湲곕낯 �깮�꽦�옄 �븘�닔 (**************)

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
