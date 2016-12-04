package model;

public class Reservation {
	private int rid;
	private User user;
	private Room room;
	private int StartYear;
	private int startMonth;
	private int startDay;
	private int startHour;
	private int startMinute;
	private int periodHour;
	private int periodMinute;

	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public int getStartYear() {
		return StartYear;
	}
	public void setStartYear(int startYear) {
		StartYear = startYear;
	}
	public int getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}
	public int getStartDay() {
		return startDay;
	}
	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}
	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getStartMinute() {
		return startMinute;
	}
	public void setStartMinute(int startMinute) {
		this.startMinute = startMinute;
	}
	public int getPeriodHour() {
		return periodHour;
	}
	public void setPeriodHour(int periodHour) {
		this.periodHour = periodHour;
	}
	public int getPeriodMinute() {
		return periodMinute;
	}
	public void setPeriodMinute(int periodMinute) {
		this.periodMinute = periodMinute;
	}

}
