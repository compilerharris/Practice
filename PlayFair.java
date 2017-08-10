import java.io.*;
import java.util.*;

class Untitled
{
	public static int i = 0, spaceArrCounter = 0, ind = 0, j = 0, k = 0, pairA = 0, pairB = 0, pairX = 0, pairY = 0, spacePaddCounter = 0;
	public static int switchLoop = 0, cipherLoop, cipherCounter = 0, fdtextCounter = 0, mainVar = 0;
	public static char a = 'a';
	public static char pair[] = new char[2];
    public static boolean lastAlpha = false;
	public static void main(String[] args) throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String key = "";
		String msg = "";
		char arr [][] = new char [5][5];
		char alph [] = new char[25];
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
			int msgLen = msg.length();
			String originalMsg = msg;
			String msgCopy = "";
			int spaceIndexArr[] = new int[msgLen];
			for ( i = 0 ; i < spaceIndexArr.length ; i += 1 ) {
				spaceIndexArr[i] = 'H';
			}
			msg = msg.replace(" ","X");
			char X = 'X';

			//****************************calling removeSpacePaddx
			msgCopy = removeSpacePaddx(msg,X,spaceIndexArr,msgCopy);

			msgCopy = getEvenLen(msgCopy);

			// System.out.println("New Message with 'x' padded: "+msgCopy);
			for (i = 0 ; i < key.length() ; i += 1 ) {
				alph[i] = key.charAt(i);
			}

			//****************************calling singleArrMatrix
			singleArrMatrix(alph,key,len,contain);

			generateMatrix(arr,alph);

			//****************************calling printMatrix
			printMatrix(arr);

			char cipherText[] = new char[msgCopy.length()];

			//****************************calling generateCipherText
			generateCipherText(msgCopy,arr,cipherText);

			char dCipherText[] = new char[cipherText.length];

			generateDecryptedText(cipherText,arr,dCipherText);

 			if (lastAlpha) {
 				// dCipherText = Arrays.copyOfRange(dCipherText,0,cipherCounter-1);
 				dCipherText[cipherCounter-1] = 'Z';
 			}

 			removexfromDecryptedText(dCipherText);

			// System.out.print("\nDecrypted Text without x: ");
			// for (i = 0 ; i < mainVar ; i += 1 ) {
			// 	System.out.print(dCipherText[i]);
			// }			

			char fDText[] = new char[100];				

			decryption(originalMsg,spaceIndexArr,fDText,dCipherText);
				
			System.out.print("\nDecrypted Text: ");
			for (i = 0 ; i <= originalMsg.length() ; i += 1 ) {
				System.out.print(fDText[i]);
			}			

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

	static String getEvenLen(String msgCopy){
		if( msgCopy.length()%2 != 0){
			msgCopy += "x";
			lastAlpha = true;
		}
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

	static void generateMatrix(char arr[][], char alph[]){
		for (i = 0 ; i < arr.length ; i += 1 ) {
			for ( j = 0 ; j < arr.length ; j += 1 ) {
				arr[i][j] = alph[k++];
			}
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

	static void generateDecryptedText(char cipherText[], char arr[][], char dCipherText[]){
		switchLoop = 0;cipherCounter = 0;
		for (cipherLoop = 0 ; cipherLoop < cipherText.length/2 ; cipherLoop +=1 ) {
			pair[0] = cipherText[switchLoop];
			pair[1] = cipherText[switchLoop+1];
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
				if (pairB == 0) {
					pairB = arr.length - 1;
					dCipherText[cipherCounter++] = arr[pairA][pairB];
					dCipherText[cipherCounter++] = arr[pairX][pairY-1];
				}else if (pairY == 0) {
					pairY = arr.length - 1;
					dCipherText[cipherCounter++] = arr[pairA][pairB-1];
					dCipherText[cipherCounter++] = arr[pairX][pairY];
				}else{
					dCipherText[cipherCounter++] = arr[pairA][pairB-1];
					dCipherText[cipherCounter++] = arr[pairX][pairY-1];
				}
			}else if( pairB == pairY ){
			//checking cols
				if (pairA == 0) {
					pairA = arr.length - 1;
					dCipherText[cipherCounter++] = arr[pairA][pairB];
					dCipherText[cipherCounter++] = arr[pairX-1][pairY];
				}else if (pairX == 0) {
					pairX = arr.length - 1;
					dCipherText[cipherCounter++] = arr[pairA-1][pairB];
					dCipherText[cipherCounter++] = arr[pairX][pairY];
				}else{
					dCipherText[cipherCounter++] = arr[pairA-1][pairB];
					dCipherText[cipherCounter++] = arr[pairX-1][pairY];
				}
			}else{
				dCipherText[cipherCounter++] = arr[pairA][pairY];
				dCipherText[cipherCounter++] = arr[pairX][pairB];
			}
		}
		// System.out.print("\nDecrypted Text : ");
		// for (i = 0 ; i < dCipherText.length ; i += 1 ) {
		// 	System.out.print(dCipherText[i]);
		// }
	}

	static void removexfromDecryptedText(char dCipherText[]){
		for(i = 0 ; i < dCipherText.length ; i += 1 ){
			if (dCipherText[i] == 'x') {
				if (dCipherText[i-1] != dCipherText[i+1]) {
					dCipherText[mainVar++] = dCipherText[i];	
				}
			}else{
				dCipherText[mainVar++] = dCipherText[i]; 
			}
		}
	}

	static void decryption(String originalMsg, int spaceIndexArr[], char fDText[], char dCipherText[]){
		mainVar = 0;
		for (i = 0 ; i < originalMsg.length() ; i += 1 ) {
			if (i == spaceIndexArr[spacePaddCounter]) {
			// System.out.print("i="+i+"spaceIndex: "+spaceIndexArr[spacePaddCounter]+"fdtextCounter: "+fdtextCounter);
				fDText[fdtextCounter++] = ' ';
				spacePaddCounter += 1;
			}else{
				fDText[fdtextCounter++] = dCipherText[mainVar++];
			}
		}
	}
}
