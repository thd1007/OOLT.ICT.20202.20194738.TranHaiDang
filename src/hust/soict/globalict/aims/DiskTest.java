package hust.soict.globalict.aims;

import java.util.Arrays;
import java.util.Date;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.order.Order;

public class DiskTest {
	public static void main(String[] args)
	{
		Date d = new Date();
		@SuppressWarnings("deprecation")
		Order anOrder = new Order(d.getDate(), d.getMonth() + 1, d.getYear() + 1900);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		Book book1 = new Book("Harry Potter", "Fantasy", 10.00f,  Arrays.asList("J.K.Rowling"));
		anOrder.addMedia(dvd1, dvd2, dvd3, book1);
		anOrder.PrintOrder();
		System.out.println(dvd1.search("The King"));
	}
}
