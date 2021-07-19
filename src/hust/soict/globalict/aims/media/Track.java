package hust.soict.globalict.aims.media;

public class Track implements Playable, Comparable<Track>{

	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	@Override
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	@Override
	public boolean equals(Object o)
	{
		if (o == this) return true;
		if (!(o instanceof Track)) return false;
		Track m = (Track) o;
		return (Integer.compare(length, m.getLength()) == 0 && title.equals(m.getTitle()));
	}
	@Override
	public int compareTo(Track n)
	{
		return this.title.compareTo(n.getTitle());
	}

}
