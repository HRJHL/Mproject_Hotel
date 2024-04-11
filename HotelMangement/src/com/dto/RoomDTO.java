package com.dto;

public class RoomDTO {

	int room_no;
	int room_state;
	int room_capacity;
	String room_checkin_time;
	String room_checkout_time;

	public RoomDTO() {
	} // 기본 생성자 필수 (**************)

	public RoomDTO(int room_no, int room_state, int room_capacity, String room_checkin_time,
			String room_checkout_time) {
		this.room_no = room_no;
		this.room_state = room_state;
		this.room_capacity = room_capacity;
		this.room_checkin_time = room_checkin_time;
		this.room_checkout_time = room_checkout_time;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public int getRoom_state() {
		return room_state;
	}

	public void setRoom_state(int room_state) {
		this.room_state = room_state;
	}

	public int getRoom_capacity() {
		return room_capacity;
	}

	public void setRoom_capacity(int room_capacity) {
		this.room_capacity = room_capacity;
	}

	public String getCheckIn() {
		return room_checkin_time;
	}

	public void setCheckIn(String room_checkin_time) {
		this.room_checkin_time = room_checkin_time;
	}

	public String getCheckOut() {
		return room_checkout_time;
	}

	public void setCheckOut(String room_checkout_time) {
		this.room_checkout_time = room_checkout_time;
	}

	@Override
	public String toString() {
		return "RoomDTO [room_no=" + room_no + ", room_state=" + room_state + ", room_capacity=" + room_capacity
				+ ", room_checkin_time=" + room_checkin_time + ", room_checkout_time=" + room_checkout_time + "]";
	}

}
