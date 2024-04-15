package com.dto;

public class RoomSDTO {

	
	String breakfast_yn;
	String cleaning_yn;
	String delivery_yn;
	int room_no;
	
	public RoomSDTO() {}  // 기본  생성자 필수 (**************)

	public RoomSDTO(String breakfast_yn, String cleaning_yn, String delivery_yn, int room_no) {
	    this.breakfast_yn = breakfast_yn;
	    this.cleaning_yn = cleaning_yn;
	    this.delivery_yn = delivery_yn;
	    this.room_no = room_no;
	}

	public String getBreakfast_yn() {
	    return breakfast_yn;
	}

	public void setBreakfast_yn(String breakfast_yn) {
	    this.breakfast_yn = breakfast_yn;
	}

	public String getCleaning_yn() {
	    return cleaning_yn;
	}

	public void setCleaning_yn(String cleaning_yn) {
	    this.cleaning_yn = cleaning_yn;
	}

	public String getDelivery_yn() {
	    return delivery_yn;
	}

	public void setDelivery_yn(String delivery_yn) {
	    this.delivery_yn = delivery_yn;
	}

	public int getRoom_no() {
	    return room_no;
	}

	public void setRoom_no(int room_no) {
	    this.room_no = room_no;
	}

	@Override
	public String toString() {
	    return "RoomSDTO [breakfast_yn=" + breakfast_yn + ", cleaning_yn=" + cleaning_yn
	            + ", delivery_yn=" + delivery_yn + ", room_no=" + room_no + "]";
	}

}