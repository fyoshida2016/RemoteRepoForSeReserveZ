package model;

public class TestDataFactory {
	public static User getTestUser(){
		User user=new User();
		user.setRid(1);
		user.setLoginName("test");
		user.setPassWord("xyz");
		user.setName("Mr.x");
		user.setEmail("mrx@gmail.com");
		user.setUserType(1);
		return user;
	}

	public static Room getTestRoom(){
		Room room=new Room();
		room.setRid(1);
		room.setBuildingName("test");
		room.setFloor("1");
		room.setRoomNumber("101");
		room.setArea(50);
		room.setCapacity(20);
		room.setTel("9999");
		room.setWhiteboard(3);
		room.setProjecter(1);
		room.setScreen(1);
		room.setHdmi(0);
		room.setDsub(1);
		room.setComposite(1);
		room.setStereomini(1);
		return room;
	}

	public static Reservation getTestReservation(){
		Reservation reservation=new Reservation();
		reservation.setRid(1);
		reservation.setUser(getTestUser());
		reservation.setRoom(getTestRoom());
		reservation.setStartYear(2016);
		reservation.setStartMonth(12);
		reservation.setStartDay(6);
		reservation.setStartHour(14);
		reservation.setStartMinute(40);
		reservation.setPeriodHour(1);
		reservation.setPeriodMinute(30);
		return reservation;
	}
}
