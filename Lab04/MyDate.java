package hust.soict.globalict.aims.utils;

public class MyDate {
	private int day, month, year;
	private static String[] month_name = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	private static String[] day_name = {"first", "second", "third", "forth", "fifth", "sixth", "seventh", "eighth", "nineth", "tenth", "eleventh", "twelfth", "thirdteenth", "fourteenth",
			"fifteenth", "sixteenth", "seventeenth", "eigthteenth", "nineteenth", "twentieth", "twenty first", "twenty second", "twenty third", "twenty forth", "twenty fifth",
			"twenty sixth", "twenty seventh", "twenty eighth", "twenty nineth", "thirtieth", "thirty first"};
	
	public int getMonth() {
		return month;
	}


	public int getDay() {
		return day;
	}


	public int getYear() {
		return year;
	}

	public boolean DateCheck()
	{
		if (this.day < 1 || this.month < 1 || this.year < 0) return false;
		int leap = 0;
		if ((this.year % 400 == 0) || (this.year % 4 == 0 && this.year % 100 != 0)) leap = 1;
		if (this.month == 2 && this.day > 28 + leap) return false;
		if (this.month == 1 || this.month == 3 || this.month == 1 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12)
		{
			if (this.day > 31) return false;
		}
		if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)
		{
			if (this.day > 30) return false;
		}
		return true;
		
	}
	

	public MyDate(int day, int month, int year) {
		super();
		this.month = month;
		this.day = day;
		this.year = year;
		if (!this.DateCheck())
		{
			throw new ArithmeticException("Invalid date");
		}
	}
	
	public MyDate(String day, String month, int year) {
		super();
		for (int i = 0; i < 12; ++i)
		{
			if (month == month_name[i]) {this.month = i + 1; break;}
		}
		for (int i = 0; i < 31; ++i)
		{
			if (day == day_name[i]) {this.day = i + 1; break;}
		}
		this.year = year;
		if (!this.DateCheck())
		{
			throw new ArithmeticException("Invalid date");
		}
	}
	
	
	public void print(String format)
	{
		if (format == "yyyy-mm-dd")
		{
			System.out.println(String.format("%04d", this.year) + "-" + String.format("%02d", this.month) + "-" + String.format("%02d", this.day));
		}
		if (format == "d/m/yyyy")
		{
			System.out.println(this.day + "-" + this.month + "-" + String.format("%04d", this.year));
		}
		if (format == "dd-mmm-yyyy")
		{
			System.out.println(String.format("%02d", this.day) + "-" + month_name[this.month - 1].substring(0, 3) + "-" + String.format("%04d", this.year));
		}
		if (format == "mmm d yyyy")
		{
			System.out.println(month_name[this.month - 1].substring(0, 3) + " " + this.day + " " + String.format("%04d", this.year));
		}
		if (format == "mm-dd-yyyy")
		{
			System.out.println(String.format("%02d", this.month) + "-" + String.format("%02d", this.day) + "-" + String.format("%04d", this.year));
		}
	}
}
