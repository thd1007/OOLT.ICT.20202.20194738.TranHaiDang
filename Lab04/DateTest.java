package hust.soict.globalict.test.utils;

import hust.soict.globalict.aims.utils.MyDate;
import hust.soict.globalict.aims.utils.DateUtils;


public class DateTest {
	public static void main(String[] args)
	{
		MyDate date1 = new MyDate(29, 2, 1992);
		MyDate date2 = new MyDate("second", "February", 1998);
		MyDate date3 = new MyDate("eleventh", "December", 1783);
		DateUtils.sortDate(date1, date2, date3);
	}
}
