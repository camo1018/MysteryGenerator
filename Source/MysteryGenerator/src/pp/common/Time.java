package pp.common;

public class Time {

	private int month;
	private int day;
	private int hour;
	private int minute;
	
	public Time(int month, int day, int hour, int minute) {
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
}
