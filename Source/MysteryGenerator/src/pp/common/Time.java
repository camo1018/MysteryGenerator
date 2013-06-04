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
	 * Add a specified number of minutes to time.  Supports negative integers as well.
	 * @param minutes
	 */
	public void addMinutes(int minute) {
		int minutesSum = this.minute + minute;
		int hoursToAdd = minutesSum / 60;
		
		hour+= hoursToAdd;
		this.minute = minutesSum % 60;
	}
	
	/**
	 * Converts the time into multiples of five, to make estimates 	
	 */
	public void toMultiplesOfFive() {
		double multiple = (double)minute / 5.0;
		int roundedMultiple = (int)Math.round(multiple);
		
		minute = 5 * roundedMultiple;
	}
	
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
	
	public String toString() {
		String result = "";
		result+= month+"/"+day+" "+hour+":"+minute;
		return result;
	}
	
}
