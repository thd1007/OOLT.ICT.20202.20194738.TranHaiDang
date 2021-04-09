package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String title, String category, float cost, List<String> authors) {
		super();
		title.trim();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.authors = authors;
		this.type = "Book";
	}
	public void addAuthor(String authorName)
	{
		for (String x : authors)
		{
			if (x.equals(authorName))
			{
				System.out.println("The author is already added.");
				return;
			}
		}
		authors.add(authorName);
		System.out.println("The author is added.");
	}
	public void removeAuthor(String authorName)
	{
		for (int i = 0; i < authors.size(); ++i)
		{
			if (authors.get(i).equals(authorName))
			{
				authors.remove(i);
				System.out.println("The author is removed.");
				return;
			}
		}
		System.out.println("The author is not found.");
	}
	public void print()
	{
		System.out.print(this.type + " - " + this.getTitle() + " - " + this.getCategory() +  ": ");
	}
}
