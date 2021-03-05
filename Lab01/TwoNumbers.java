import java.util.Scanner;
public class TwoNumbers {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		double num1 = input.nextDouble();
		System.out.print("Enter the second number: ");
		double num2 = input.nextDouble();
		System.out.println(num1 + num2);
		System.out.println(Math.abs(num1 - num2));
		System.out.println(num1 * num2);
		System.out.println((double)num1 / num2);
		input.close();
	}
}
# OOLT.ICT.20202.20194738.TranHaiDang
