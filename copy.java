import java.io.*;

class Copy
{
	public static int i = 0, spaceArrCounter = 0, ind = 0, j = 0, pairA = 0, pairB = 0, pairX = 0, pairY, switchLoop = 0, cipherLoop, cipherCounter = 0;
	public static char a = 'a';
	public static char pair[] = new char[2];
	public static void main(String[] args) throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String key = "";
		String msg = "";
		boolean lastAlpha = false;
		char arr [][] = new char [5][5];
		char alph [] = new char[25];
		int k = 0;
		try{
			System.out.println("NOTE: You can't repeat any alphabet in key");
			System.out.print("Enter Key : ");
			key = br.readLine();
			key = key.trim();
			int len = key.length();
			int flag = 0;
			char contain = 'j';

			//****************************Calling keyVerified
			keyVerified(key,contain,flag);

			System.out.print("Enter Message : ");
			msg = br.readLine();
			msg = msg.trim();
			String originalMsg = msg;
			String msgCopy = "";
			int spaceIndexArr[] = new int[msg.length()];
			msg = msg.replace(" ","X");
			char X = 'X';

			//****************************calling removeSpacePaddx
			msgCopy = removeSpacePaddx(msg,X,spaceIndexArr,msgCopy);

			if( msgCopy.length()%2 != 0){
				msgCopy += "x";
				lastAlpha = true;
			}

			System.out.println("New Message with 'x' padded: "+msgCopy);
			for (i = 0 ; i < key.length() ; i += 1 ) {
				alph[i] = key.charAt(i);
			}

			//****************************calling singleArrMatrix
			singleArrMatrix(alph,key,len,contain);

			for (i = 0 ; i < arr.length ; i += 1 ) {
				for ( j = 0 ; j < arr.length ; j += 1 ) {
					arr[i][j] = alph[k++];
				}
			}

			//****************************calling printMatrix
			printMatrix(arr);

			char cipherText[] = new char[msgCopy.length()];

			//****************************calling generateCipherText
			generateCipherText(msgCopy,arr,cipherText);

		}catch(IOException e){
			System.out.println("PlairFairError: ");
			e.printStackTrace();
		}
		System.out.println();
	}

	static void keyVerified(String key, char contain, int flag){
		for (i = 0 ; i < key.length() ; i += 1 ) {
			if(key.charAt(i)<97 || key.charAt(i)>122){
				System.out.println("ERROR: Please enter a - z ONLY...");
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
				System.out.println("ERROR: i and j together in string is not ALLOWED...");
				System.exit(0);
			}
		}
	}

	static String removeSpacePaddx(String msg, char X, int spaceIndexArr[], String msgCopy){
		for(i = 0 ; i < msg.length()-1 ; i += 1 ){
			if(msg.charAt(i) == X){
				spaceIndexArr[spaceArrCounter++] = i;
				if (msg.charAt(i - 1) == msg.charAt(i + 1)) {
					msgCopy += "x";
				}
			}
			else{
				msgCopy += msg.charAt(i);
				if (msg.charAt(i) == msg.charAt(i + 1)) {
					msgCopy += "x";
				}
			}
		}
		msgCopy += msg.charAt(i);	
		return msgCopy;	
	}

	static void singleArrMatrix(char alph[], String key, int len, char contain ){
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
					len++;
				}
			}
			a++;
		}
	}

	static void printMatrix(char arr[][]){
		for (i = 0 ; i < arr.length ; i += 1 ) {
			for ( j = 0 ; j < arr.length ; j += 1 ) {
				System.out.print("\t"+arr[i][j]);
			}
			System.out.println();
		}
	}

	static void generateCipherText(String msgCopy, char arr[][], char cipherText[]){
		for (cipherLoop = 0 ; cipherLoop < msgCopy.length()/2 ; cipherLoop +=1 ) {
			pair[0] = msgCopy.charAt(switchLoop);
			pair[1] = msgCopy.charAt(switchLoop+1);
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
			//checking rows
			if ( pairA == pairX ) {
				if (pairB == arr.length - 1) {
					pairB = 0;
					cipherText[cipherCounter++] = arr[pairA][pairB];
					cipherText[cipherCounter++] = arr[pairX][pairY+1];
				}else if (pairY == arr.length - 1) {
					pairY = 0;
					cipherText[cipherCounter++] = arr[pairA][pairB+1];
					cipherText[cipherCounter++] = arr[pairX][pairY];
				}else{
					cipherText[cipherCounter++] = arr[pairA][pairB+1];
					cipherText[cipherCounter++] = arr[pairX][pairY+1];
				}
			}else if( pairB == pairY ){
			//checking cols
				if (pairA == arr.length - 1) {
					pairA = 0;
					cipherText[cipherCounter++] = arr[pairA][pairB];
					cipherText[cipherCounter++] = arr[pairX+1][pairY];
				}else if (pairX == arr.length - 1) {
					pairX = 0;
					cipherText[cipherCounter++] = arr[pairA+1][pairB];
					cipherText[cipherCounter++] = arr[pairX][pairY];
				}else{
					cipherText[cipherCounter++] = arr[pairA+1][pairB];
					cipherText[cipherCounter++] = arr[pairX+1][pairY];
				}
			}else{
				cipherText[cipherCounter++] = arr[pairA][pairY];
				cipherText[cipherCounter++] = arr[pairX][pairB];
			}
		}
		System.out.print("Cipher Text : ");
		for (i = 0 ; i < msgCopy.length() ; i += 1 ) {
			System.out.print(cipherText[i]);
		}
	}
}