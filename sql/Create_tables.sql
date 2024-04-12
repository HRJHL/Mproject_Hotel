create table tb_room
	( ROOM_NO int primary key, ROOM_STATE int CHECK(ROOM_STATE IN ( 1, 2, 3, 4 )), ROOM_CAPACITY int, ROOM_CHECKIN_TIME datetime, ROOM_CHECKOUT_TIME datetime);
create table tb_guest
	(GUEST_PNO varchar(20) primary key, M_COUNT int not null, GUEST_NAME varchar(20) not null, STAY_DAYS int not null, CAR_NO varchar(10) default null, ROOM_NO int, constraint foreign key(ROOM_NO) references tb_room(ROOM_NO));
create table tb_room_service
	(BREAKFAST_YN varchar(1) not null, CLEANING_YN varchar(1) not null, DELIVERY_YN varchar(1) not null, ROOM_NO int, constraint foreign key(ROOM_NO) references tb_room(ROOM_NO));
create table hotel (PASSWD varchar(20) primary key default '0000');
