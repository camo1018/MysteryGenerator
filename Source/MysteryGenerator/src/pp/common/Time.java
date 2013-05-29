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
	
	/* Not needed
	public static boolean isLeapYear(int year) {
		if (year % 400 == 0)
			return true;
		else if (year % 100 == 0)
			return false;
		else if (year % 4 == 0)
			return true;
		else
			return false;
	}
	*/
	
	/**
	 * Given a month, generate a day that fits within that month.
	 * @return
	 */
	public static int getDaysForMonth(int month) {
		// Odd months
		if (month % 2 == 1)
			return 31;
		else if (month % 2 == 0 && month != 2)
			return 30;
		else
			return 29;
	}
	
}
