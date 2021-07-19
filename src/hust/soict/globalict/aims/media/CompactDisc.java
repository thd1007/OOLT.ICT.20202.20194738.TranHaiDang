package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class CompactDisc extends Disc implements Playable, Comparable<Media>{

	private String artist;
	
	private List<Track> trackList = new ArrayList<Track>();
	public String getArtist() {
			return artist;
	}
	public CompactDisc(String director, String artist, List<Track> trackList) {
		super();
		this.director = director;
		this.artist = artist;
		this.trackList = trackList;
		this.length = 0;
		this.type = "CD";
		Scanner sc = new Scanner(System.in);
		System.out.print("Input number of track: ");
		int n = sc.nextInt();
		while (n > 0)
		{
			System.out.print("Input number of track title: ");
			String ti = sc.nextLine();
			System.out.print("Input number of track length: ");
			int le = sc.nextInt();
			trackList.add(new Track(ti, le));
		}
	}
	public CompactDisc() {
		this.read();
		this.type = "CD";
		Scanner sc = new Scanner(System.in);
		System.out.print("Input artist: ");
		this.artist = sc.nextLine();
		System.out.print("Input number of track: ");
		int n = sc.nextInt();
		while (n > 0)
		{
			System.out.print("Input number of track title: ");
			String ti = sc.nextLine();
			System.out.print("Input number of track length: ");
			int le = sc.nextInt();
			trackList.add(new Track(ti, le));
		}
	}
	public void addTrack(Track x)
	{
		for (Track t : trackList)
		{
			if (x.equals(t))
			{
				System.out.println("Track is already in the list.");
				return;
			}
		}
		trackList.add(x);
		System.out.println("Track has been added.");
	}
	public void removeTrack(Track x)
	{
		for (int i = 0; i < trackList.size(); ++i)
		{
			Track t = trackList.get(i);
			if (x.equals(t))
			{
				trackList.remove(i);
				System.out.println("Track is removed.");
				return;
			}
		}
		System.out.println("Track not founded.");
	}
	public int getLength()
	{
		if (this.length != 0) return this.length;
		int length = 0;
		for (Track t : trackList)
		{
			length += t.getLength();
		}
		this.length = length;
		return this.length;
	}
	public void print()
	{
		System.out.print(this.type + " - " + this.getTitle() + " - " + this.getCategory() + " - " + " - " + this.getLength() + ": ");
	}
	@Override
	public void play() {
		System.out.println("Disc title: " + this.getTitle() + " - " + this.artist);
		System.out.println("Total length: " + this.getLength());
		for (Track t : trackList)
		{
			t.play();
		}
	}
}
