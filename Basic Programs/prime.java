import java.util.Scanner;

class Prime{
	public static void main(String[] args) {
		System.out.println("Enter number:");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		int flag = 0, i;
		for (i = 2 ; i < no ; i += 1 ) {
			if (no%i == 0) {
				break;
			}
		}
		if (i == no)
			System.out.println(no+" is a prime number.");
		else
			System.out.println(no+" is not a prime number.");
		System.out.println();
	}
}