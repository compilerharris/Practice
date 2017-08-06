import java.util.Scanner;

class PrimeSeries{
	public static void main(String[] args) {
		System.out.println("Enter number:");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		int prime[] = new int[no];
		int i, n = 2, primeCounter = 0;
		for (int j = 0 ; j < no ; j += 1 ) {
			if (n >= no) {
				continue;
			}
			for (i = 2 ; i < n ; i += 1 ) {
				if (n%i == 0) {
					break;
				}
			}
			if (i == n)
				prime[primeCounter++] = n;
			n += 1;
		}
		System.out.println("Prime Number Series are: ");
		for (i = 0 ; i < primeCounter ; i += 1 ) {
			System.out.print(" "+prime[i]);
		}
		System.out.println();
	}
}