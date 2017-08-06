import java.util.Scanner;

class Factorial{
	public static void main(String[] args) {
		System.out.println("Enter number:");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		int fact = 1;
		for (int i = no ; i > 0 ; i -= 1) {
			fact *= i;
		}
		System.out.println("Factorial of "+no+" is "+fact);
	}
}