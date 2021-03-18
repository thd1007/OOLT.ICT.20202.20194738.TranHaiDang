
public class Order {
	public static final int MAX_NUMBER_ORDERED = 10;
	
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private int Current_Qty = 0;
	public int qtyOrdered(){
		return Current_Qty;
	}
	public void addDigitalVideoDisc (DigitalVideoDisc disc){
		for (int i = 0; i < Current_Qty; ++i){
			if (disc == itemsOrdered[i]){
				System.out.println("The disc is already in cart!");
				return;
			}
		}
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
	public float totalCost(){
		float tCost = 0;
		for (int i = 0; i < Current_Qty; ++i){
			tCost += itemsOrdered[i].getCost();
		}
		return tCost;
	}
	
}
