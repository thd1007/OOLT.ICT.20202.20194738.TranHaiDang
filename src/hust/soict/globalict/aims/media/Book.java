package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book extends Media implements Comparable<Media>{
	
	private List<String> authors = new ArrayList<String>();
	public Book() {
		Scanner sc = new Scanner(System.in);
		this.read();
		this.type = "Book";
		System.out.print("Input number of author: ");
		int n = sc.nextInt();
		while (n > 0)
		{
			n--;
			System.out.print("Input author: ");
			String a = sc.next();
			authors.add(a);
		}
		
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
