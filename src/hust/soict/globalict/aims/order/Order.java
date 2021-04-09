package hust.soict.globalict.aims.order;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.utils.MyDate;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Order {
	public static final int MAX_NUMBER_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERED = 5;
	private List<Media> itemsOrdered = new ArrayList<Media>();
	private static int nbOrdered = 0;
	private MyDate dateOrdered;
	private int ID;
	public int getID() {
		return ID;
	}
	public Order(int day, int month, int year) {
		super();
		if (nbOrdered == MAX_LIMITED_ORDERED)
		{
			throw new ArithmeticException("Maximum number of orders reached");
		}
		this.dateOrdered = new MyDate(day, month, year);
		nbOrdered++;
	}
	public Order(String day, String month, int year) {
		super();
		if (nbOrdered == MAX_LIMITED_ORDERED)
		{
			throw new ArithmeticException("Maximum number of orders reached");
		}
		this.dateOrdered = new MyDate(day, month, year);
		nbOrdered++;
	}
	public int qtyOrdered(){
		return itemsOrdered.size();
	}
	public List<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	public void addMedia(Media... MediaList)
	{
		if (itemsOrdered.size()  >= MAX_NUMBER_ORDERED)
		{
			System.out.println("The order is full!");
			return;
		}
		int i = 0;
		while (itemsOrdered.size() < MAX_NUMBER_ORDERED && i < MediaList.length)
		{
			itemsOrdered.add(MediaList[i]); i++;
			System.out.println("The item has been added!");
			if (itemsOrdered.size() == MAX_NUMBER_ORDERED) System.out.println("The order is full!");
		}
	}
	
	private Media getALuckyItem()
	{
		int rand = (int)(Math.random() * itemsOrdered.size());
		return itemsOrdered.get(rand);
		
	}
	public void removeMedia(Media media){
		for (int i = 0; i < itemsOrdered.size(); ++i){
			if (media == itemsOrdered.get(i)){
				System.out.println("The item is removed");
				itemsOrdered.remove(i);
				return;
			}
		}
		System.out.println("The item was not found!");
	}

	public void printDate()
	{
		dateOrdered.print("dd-mmm-yyyy");
	}
	public void PrintOrder()
	{
		Media Lucky = getALuckyItem();
		System.out.println("***********************Order***********************");
		dateOrdered.print("dd-mmm-yyyy");
		System.out.println("Ordered Item(s):");
		for (int i = 0; i < itemsOrdered.size(); ++i)
		{
			if (itemsOrdered.get(i).getType().equals("Book"))
			{
				Book tmp = (Book) itemsOrdered.get(i);
				tmp.print();
				if (tmp.equals(Lucky)) tmp.printCost(true);
				else tmp.printCost(false);
			}
			else
			{
				DigitalVideoDisc tmp = (DigitalVideoDisc) itemsOrdered.get(i);
				tmp.print();
				if (tmp.equals(Lucky)) tmp.printCost(true);
				else tmp.printCost(false);
			}
			
		}
		System.out.println("Total cost: " + String.format("%.02f", totalCost(Lucky)) + " $");
		System.out.println("***************************************************");
	}
	public float totalCost(Media Lucky){
		float tCost = 0;
		for (int i = 0; i < itemsOrdered.size(); ++i){
			if (itemsOrdered.get(i).equals(Lucky)) continue;
			tCost += itemsOrdered.get(i).getCost();
		}
		return tCost;
	}
	
}