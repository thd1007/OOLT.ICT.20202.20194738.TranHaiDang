package hust.soict.globalict.aims.media;

import java.util.Scanner;

public class DigitalVideoDisc extends Disc implements Playable, Comparable<Media>{
	private String director;
	public DigitalVideoDisc(String title) {
		super();
		title.trim();
		this.title = title;
		this.type = "DVD";
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		title.trim();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.type = "DVD";
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		title.trim();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.type = "DVD";
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(length, director);
		title.trim();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.type = "DVD";
	}
	
	public DigitalVideoDisc() {
		this.type = "DVD";
	}

	public String getDirector() {
		return director;
	}
	public void readDVD()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Input director: ");
		this.director = sc.nextLine();
		
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
	public void print()
	{
		System.out.print(this.type + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": ");
	}

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	
}
