package hust.soict.globalict.aims.media;

public class Media {
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
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
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
