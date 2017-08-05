import java.io.*;

class PF
{
	public static void main(String[] args) throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String key = "";
		String msg = "";
		char arr [][] = new char [5][5];
		char alph [] = new char[25];
		char a = 'a';
		try{
			System.out.print("Enter Key : ");
			key = br.readLine();
			int flag = 0;
			char contain = 'j';

			for (int i = 0 ; i < key.length() ; i += 1 ) {
				if(key.charAt(i)<97 || key.charAt(i)>122){
					System.out.println("Please enter a - z ONLY...");
					System.exit(0);
				}
				if(key.charAt(i) == 'j'){
					contain = 'i';
					flag += 1;
				}
				if(key.charAt(i) == 'i'){
					flag += 1;
				}
				if (flag == 2) {
					System.out.println("i and j together in string is not ALLOWED...");
					System.exit(0);
				}
			}
			System.out.print("Enter Message : ");
			msg = br.readLine();

			if( msg.length()%2 != 0){
				System.out.println("Message length must be EVEN...");
				System.exit(0);
			}

			int len = key.length();
			int ind = 0, j = 0,i = 0,k = 0;
			for (i = 0 ; i < key.length() ; i += 1 ) {
				alph[i] = key.charAt(i);
			}

			for (i = 0 ; i <= alph.length ; i += 1 ) {
				for (ind = 0 ; ind < key.length() ; ind += 1 ) {
					if(key.charAt(ind) == a){
						break;
					}
				}
				if (a == contain) {
				}
				else{
					if (ind == key.length()) {	
						alph[len] = a;
						// System.out.println(alph[len]);
						len++;
					}
				}
				a++;
			}

			for (i = 0 ; i < arr.length ; i += 1 ) {
				for ( j = 0 ; j < arr.length ; j += 1 ) {
					arr[i][j] = alph[k++];
				}
			}
			for (i = 0 ; i < arr.length ; i += 1 ) {
				for ( j = 0 ; j < arr.length ; j += 1 ) {
					System.out.print("\t"+arr[i][j]);
				}
				System.out.println();
			}

			int pairA = 0;
			int pairB = 0;
			int pairX = 0;
			int pairY = 0;
			char pair[] = new char[2];
			char cipherText[] = new char[msg.length()];
			int switchLoop = 0;
			int cipherCounter = 0;
			int cipherLoop;

			for (cipherLoop = 0 ; cipherLoop < msg.length()/2 ; cipherLoop +=1 ) {
				pair[0] = msg.charAt(switchLoop);
				pair[1] = msg.charAt(switchLoop+1);
				switchLoop += 2;

				for (i = 0 ; i < arr.length ; i += 1 ) {
					for (j = 0 ; j < arr.length ; j += 1 ) {
						if ( arr[i][j] == pair[0] ) {
							pairA = i;
							pairB = j;
						}
						if ( arr[i][j] == pair[1] ) {
							pairX = i;
							pairY = j;
						}
					}
				}
				if ( pairA == pairX ) {
					cipherText[cipherCounter++] = arr[pairA][pairB+1];
					cipherText[cipherCounter++] = arr[pairX][pairY+1];
				}else if( pairB == pairY ){
					cipherText[cipherCounter++] = arr[pairA+1][pairB];
					cipherText[cipherCounter++] = arr[pairX+1][pairY];
				}else{
					cipherText[cipherCounter++] = arr[pairA][pairY];
					cipherText[cipherCounter++] = arr[pairX][pairB];
				}
			}
			for (i = 0 ; i < msg.length() ; i += 1 ) {
				System.out.println(cipherText[i]);
			}
			


			// System.out.println("s => ("+pairA+","+pairB+")");
			// System.out.println("o => ("+pairX+","+pairY+")");
		}catch(IOException e){
			System.out.println("PlairFairError: ");
			e.printStackTrace();
		}
	}
}