package hust.soict.globalict.garbage;


public class GarbageCreator {
	public void Create()
	{
		StringBuffer ss = new StringBuffer("garbage");
		for (int i = 0; i < 1000; ++i)
		{
			System.out.println(i);
			ss.append(ss);
		}
	}
}
