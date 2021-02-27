import java.util.Scanner;
public class FirstDegree
{
	public static String one_variables(int a, int b)
	{
		if (a == 0)
		{
			if (b == 0) return "Infinitely many solutions";
			else return "No solution";
		}
		return "x = " + (double)(-b / a);
	}
	public static String two_variables(int a1, int b1, int c1, int a2, int b2, int c2)
	{
		int D = a1 * b2 - a2 * b1;
		int D1 = c1 * b2 - c2 * b1;
		int D2 = a1 * c2 - a2 * c1;
		if (D == 0)
		{
			if (D1 == 0 && D2 == 0) return "Infinitely many solutions";
			else return "No solution";
		}
		return "(x, y) = (" + (double)(D1 / D) + ", " + (double)(D2 / D) + ")";
	}
	public static void main(String args[])
	{	
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a: ");
		int a = input.nextInt();
		System.out.print("Enter b: ");
		int b = input.nextInt();
		System.out.println(one_variables(a, b));
		System.out.print("Enter first equation's coefficent: ");
		int a1 = input.nextInt(); int b1 = input.nextInt(); int c1 = input.nextInt();
		System.out.print("Enter second equation's coefficent: ");
		int a2 = input.nextInt(); int b2 = input.nextInt(); int c2 = input.nextInt();
		System.out.println(two_variables(a1, b1, c1, a2, b2, c2));
		input.close();
	}
}
