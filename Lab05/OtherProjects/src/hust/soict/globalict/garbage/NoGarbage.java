package hust.soict.globalict.garbage;

public class NoGarbage {
	public void finalize() {
        System.out.println("object is garbage collected");
    }
	public static void main(String[] args)
	{
		try
		{
			GarbageCreator gc1  = new GarbageCreator();
			gc1.Create();
		}
		catch(Throwable t)
		{
			System.out.println("Exception");
			System.gc();
		}
	}
}
