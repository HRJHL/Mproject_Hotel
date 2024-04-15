package com.dto;

public class GuestDTO {

	
	String guest_pno;
	int m_count;
	String guest_name;
	int stay_days;
	String parking_yn; 
	int room_no;
	
	public GuestDTO() {}  // 기본  생성자 필수 (**************)

	    public GuestDTO(String guest_pno, int m_count, String guest_name, int stay_days, String parking_yn, int room_no) {
	        this.guest_pno = guest_pno;
	        this.m_count = m_count;
	        this.guest_name = guest_name;
	        this.stay_days = stay_days;
	        this.parking_yn = parking_yn;
	        this.room_no = room_no;
	    }

	    public String getGuest_pno() {
	        return guest_pno;
	    }

	    public void setGuest_pno(String guest_pno) {
	        this.guest_pno = guest_pno;
	    }

	    public int getM_count() {
	        return m_count;
	    }

	    public void setM_count(int m_count) {
	        this.m_count = m_count;
	    }

	    public String getGuest_name() {
	        return guest_name;
	    }

	    public void setGuest_name(String guest_name) {
	        this.guest_name = guest_name;
	    }

	    public int getStay_days() {
	        return stay_days;
	    }

	    public void setStay_days(int stay_days) {
	        this.stay_days = stay_days;
	    }

	    public String getParking_yn() {
	        return parking_yn;
	    }

	    public void setParking_yn(String parking_yn) {
	        this.parking_yn = parking_yn;
	    }

	    public int getRoom_no() {
	        return room_no;
	    }

	    public void setRoom_no(int room_no) {
	        this.room_no = room_no;
	    }

	    @Override
	    public String toString() {
	        return "GuestDTO [guest_pno=" + guest_pno + ", m_count=" + m_count + ", guest_name=" + guest_name
	                + ", stay_days=" + stay_days + ", parking_yn=" + parking_yn + ", room_no=" + room_no + "]";
	    }
	

}