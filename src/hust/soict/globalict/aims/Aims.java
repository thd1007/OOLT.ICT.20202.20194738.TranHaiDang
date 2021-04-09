package hust.soict.globalict.aims;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.util.Scanner;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.order.Order;


public class Aims {

	private static List<Order> Orders = new ArrayList<Order>();
	private static List<Media> Storage = new ArrayList<Media>();
	private static Scanner scanner = new Scanner(System.in);
	private static void createNewOrder()
	{
		Date d = new Date();
		@SuppressWarnings("deprecation")
		Order anOrder = new Order(d.getDate(), d.getMonth() + 1, d.getYear() + 1900);
		Orders.add(anOrder);
		System.out.println("An order has been created.");
	}
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        @SuppressWarnings("unused")
			double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	private static void addItem()
	{
		for (int i = 0; i < Storage.size(); ++i)
		{
			Media x = Storage.get(i);
			System.out.print(i + " ");
			if (x.getType().equals("Book"))
			{
				Book tmp = (Book)x;
				tmp.print();
				x.printCost(false);
			}
			else
			{
				DigitalVideoDisc tmp = (DigitalVideoDisc)x;
				tmp.print();
				x.printCost(false);
			}
		}
		int orderID;
		String OrderID;
		while (true)
		{
			System.out.print("Input order id: ");
			OrderID = scanner.nextLine();
			if (isNumeric(OrderID))
			{
				orderID = (int)Double.parseDouble(OrderID);
				if (orderID < Orders.size()) break;
			}
			System.out.println("Invalid order ID. Please try again.");
		}
		System.out.print("Input number of item: ");
		int num = scanner.nextInt();
		for (int i = 0; i < num; ++i)
		{
			System.out.print("Input item ID: ");
			int id = scanner.nextInt();
			boolean ok = false;
			for (Media x : Storage)
			{
				if (x.getID() == id)
				{
					ok = true;
					Orders.get(orderID).addMedia(x);
					break;
				}
			}
			if (!ok) System.out.println("Item not found.");
			
		}
	}
	private static void deleteItem()
	{
		if (Orders.size() == 0)
		{
			System.out.println("There is no order.");
			return;
		}
		for (int i = 0; i < Orders.size(); ++i)
		{
			System.out.print("Order " + i + ": ");
			Orders.get(i).printDate();
		}
		int orderID;
		String OrderID;
		while (true)
		{
			System.out.print("Input order id: ");
			OrderID = scanner.nextLine();
			if (isNumeric(OrderID))
			{
				orderID = (int)Double.parseDouble(OrderID);
				if (orderID < Orders.size()) break;
			}
			System.out.println("Invalid order ID. Please try again.");
		}
		System.out.print("Input item ID (number only): ");
		int id = scanner.nextInt();
		boolean ok = false;
		for (int i = 0; i < Orders.get(orderID).getItemsOrdered().size(); ++i)
		{
			Media x = Orders.get(orderID).getItemsOrdered().get(i);
			if (x.getID() == id)
			{
				ok = true;
				Orders.get(orderID).getItemsOrdered().remove(i);
				System.out.println("An item has been removed.");
				break;
			}
		}
		if (!ok) System.out.println("Item not found.");
	}
	private static void printOrder()
	{
		int orderID;
		while (true)
		{
			System.out.print("Input order id: ");
			orderID = scanner.nextInt();
			if (orderID < Orders.size()) break;
			System.out.println("Invalid order ID. Please try again.");
		}
		Orders.get(orderID).PrintOrder();
	}
	private static void addStorage()
	{
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		Book book1 = new Book("Harry Potter", "Fantasy", 10.00f,  Arrays.asList("J.K.Rowling"));
		Storage.add(dvd1); Storage.add(dvd2); Storage.add(dvd3); Storage.add(book1);
		for (int i = 0; i < Storage.size(); ++i)
		{
			Storage.get(i).setID(i);
		}
	}
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add items to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void main(String[] args)
	{
		addStorage();
		while (true)
		{
			boolean ok = false;
			showMenu();
			int choice = scanner.nextInt();
			switch(choice){
			case 1:
				createNewOrder();
				break;
			case 2:
				addItem();
				break;
			case 3:
				deleteItem();
				break;
			case 4:
				printOrder();
				break;
			default:
				ok = true;
				System.out.println("Thank you for shopping!");
			}
			if (ok) break;
		}
		scanner.close();
	}

}
