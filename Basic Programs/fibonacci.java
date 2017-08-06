import java.util.Scanner;

class Fibonacci{
	public static void main(String[] args) {
		System.out.println("Enter number:");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		int fibo[] = new int[no];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2 ; i < no ; i += 1) {
			fibo[i] += fibo[i - 1] + fibo[i - 2];
		}
		System.out.println("Fibonacci series are: ");
		for (int i = 0 ; i < no ; i += 1) {
			System.out.print("\t"+fibo[i]);
		}
		System.out.println();
	}
}