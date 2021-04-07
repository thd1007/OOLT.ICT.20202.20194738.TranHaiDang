package hust.soict.globalict.aims.disc;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	public DigitalVideoDisc(String title) {
		super();
		title.trim();
		this.title = title;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		title.trim();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		title.trim();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		title.trim();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	
	public boolean search(String tmp)
	{
		int st = 0;
		boolean ok;
		tmp.trim();
		for (int i = 0; i < tmp.length(); ++i)
		{
			if (tmp.charAt(i) == ' ' || i == tmp.length() - 1)
			{
				if (i == tmp.length() - 1) i++;
				String tmp2 = tmp.substring(st, i);
				tmp2 = tmp2.toLowerCase();
				ok = false;
				int st2 = 0;
				for (int j = 0; j < title.length(); ++j)
				{
					if (title.charAt(j) == ' ' || j == title.length() - 1)
					{
						if (j == title.length() - 1) j++;
						if (tmp2.equals(title.substring(st2, j).toLowerCase()))
						{
							ok = true;
							break;
						}
						st2 = j + 1;
					}
				}
				st = i + 1;
				if (!ok)
				{
					return false;
				}
			}
		}
		return true;
	}
}
