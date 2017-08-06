import java.io.*;

class Armstrong{
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String no = "";
		int i = 0, sum = 0;

		try{
			System.out.print("\nEnter number:");
			no = br.readLine();
			int len = no.length();
			int arm[] = new int[len];
			int armstrong[] = new int[len];
			for (i = 0 ; i < len ; i += 1) {
				arm[i] = Integer.parseInt(Character.toString(no.charAt(i)));
			}

			for (i = 0 ; i < len ; i += 1) {
				armstrong[i] = 1;
			}

			for (i = 0 ; i < len ; i += 1) {
				for (int j = 1 ; j <= len  ; j += 1 ) {
					armstrong[i] *= arm[i];	
				}
				System.out.println(armstrong[i]);
			}

			for (i = 0 ; i < len ; i += 1) {
				sum += armstrong[i];
			}

			if (Integer.parseInt(no) == sum)
				System.out.print("\n"+no+" is an Armstrong number.");
			else
				System.out.print("\n"+no+" is not an Armstrong number.");
		}catch(IOException e){
			e.printStackTrace();
		}

		System.out.println();
	}
}
// Armstrong number 1: 0
// Armstrong number 2: 1
// Armstrong number 3: 153
// Armstrong number 4: 370
// Armstrong number 5: 371
// Armstrong number 6: 407