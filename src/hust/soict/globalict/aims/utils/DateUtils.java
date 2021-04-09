package hust.soict.globalict.aims.utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class DateUtils {
	public static boolean DateCompare(MyDate a, MyDate b)
	{
		return (a.getYear() < b.getYear()) || (a.getYear() == b.getYear() && a.getMonth() < b.getMonth()) || (a.getYear() == b.getYear() && a.getMonth() == b.getMonth() && a.getDay() < b.getDay());
	}
	public static void sortDate(MyDate... dates)
	{
		List<MyDate> listdates = new ArrayList<MyDate>();
		for (int i = 0; i < dates.length; ++i)
		{
			listdates.add(dates[i]);
		}
		Collections.sort(listdates, new Comparator<MyDate>(){
			public int compare(MyDate a, MyDate b)
			{
				return ((a.getYear() < b.getYear()) || (a.getYear() == b.getYear() && a.getMonth() < b.getMonth()) || (a.getYear() == b.getYear() && a.getMonth() == b.getMonth() && a.getDay() < b.getDay())) ? -1 : 1;
			}
		});
		for (MyDate date : listdates)
		{
			date.print("dd-mmm-yyyy");
		}
	}
}
