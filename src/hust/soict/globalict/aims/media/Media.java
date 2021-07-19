package hust.soict.globalict.aims.media;
import java.util.Scanner;

public abstract class Media implements Comparable<Media>{
	protected String title;
	protected String category;
	protected float cost;
	protected int ID;
	protected String type;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Media() {
		// TODO Auto-generated constructor stub
	}
	public String getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	@Override
	public boolean equals(Object o)
	{
		if (o == this) return true;
		if (!(o instanceof Media)) return false;
		Media m = (Media) o;
		return Integer.compare(ID, m.getID()) == 0;
	}
	@Override
	public int compareTo(Media o) {
		return this.title.compareTo(o.title);
	}
	public void read()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Input title: ");
		this.title = sc.nextLine();
		System.out.print("Input category: ");
		this.category = sc.nextLine();
		System.out.print("Input cost: ");
		this.cost = sc.nextFloat();
		
	}
	public void printCost(boolean Lucky)
	{
		if (Lucky)
		{
			System.out.println(String.format("%.02f", 0.0) + " $: Lucky Item");
		}
		else
		{
			System.out.println(this.getCost() + " $");
		}
	}
}
