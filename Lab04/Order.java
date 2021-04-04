package hust.soict.globalict.aims.order;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.utils.MyDate;
public class Order {
	public static final int MAX_NUMBER_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERED = 5;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private int Current_Qty = 0;
	private static int nbOrdered = 0;
	private MyDate dateOrdered;
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
		return Current_Qty;
	}
	public void addDigitalVideoDisc (DigitalVideoDisc disc){
		if (Current_Qty >= MAX_NUMBER_ORDERED)
		{
			System.out.println("The order is full!");
			return;
		}
		itemsOrdered[Current_Qty] = disc;
		Current_Qty += 1;
		System.out.println("The disc has been added!");
		if (Current_Qty < MAX_NUMBER_ORDERED) return;
		if (Current_Qty == MAX_NUMBER_ORDERED) System.out.println("The order is full!");
		if (Current_Qty == MAX_NUMBER_ORDERED - 1) System.out.println("The order is almost full!");
	}
	public void addDigitalVideoDisc (DigitalVideoDisc... dvdList)
	{
		if (Current_Qty >= MAX_NUMBER_ORDERED)
		{
			System.out.println("The order is full!");
			return;
		}
		int i = 0;
		while (Current_Qty < MAX_NUMBER_ORDERED && i < dvdList.length)
		{
			itemsOrdered[Current_Qty] = dvdList[i];
			Current_Qty += 1; i++;
			System.out.println("The disc has been added!");
			if (Current_Qty == MAX_NUMBER_ORDERED) System.out.println("The order is full!");
		}
	}
	public void removeDigitalVideoDisc (DigitalVideoDisc disc){
		for (int i = 0; i < Current_Qty; ++i){
			if (disc == itemsOrdered[i]){
				System.out.println("The disc is removed");
				Current_Qty--;
				for (int j = i; j < Current_Qty; ++j){
					itemsOrdered[j] = itemsOrdered[j + 1];
				}
				return;
			}
		}
		System.out.println("The disc was not found!");
	}
	public void PrintOrder()
	{
		System.out.println("***********************Order***********************");
		dateOrdered.print("dd-mmm-yyyy");
		System.out.println("Ordered Item(s):");
		for (int i = 0; i < Current_Qty; ++i)
		{
			DigitalVideoDisc tmp = itemsOrdered[i];
			System.out.println((i + 1) + ". DVD - " + tmp.getTitle() + " - " + tmp.getCategory() + " - " + tmp.getDirector() + " - " + tmp.getLength() + ": " + tmp.getCost() + " $");
		}
		System.out.println("Total cost: " + totalCost() + " $");
		System.out.println("***************************************************");
	}
	public float totalCost(){
		float tCost = 0;
		for (int i = 0; i < Current_Qty; ++i){
			tCost += itemsOrdered[i].getCost();
		}
		return tCost;
	}
	
}