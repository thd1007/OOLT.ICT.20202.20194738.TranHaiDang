package hust.soict.globalict.test.media;

import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class TestMediaCompareTo {

	public static void main(String[] args)
	{
		java.util.Collection collection = new java.util.ArrayList();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
		java.util.Iterator iterator = collection.iterator();
		System.out.println("-------------------------------");
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		java.util.Collections.sort((java.util.List)collection);
		iterator = collection.iterator();
		System.out.println("-------------------------------");
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		System.out.println("-------------------------------");
		
	}

}
