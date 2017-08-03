import java.io.*;

class PF
{
	public static void main(String[] args) throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String key = "";
		String msg = "";
		String arr [][] = new String [5][5];
		char alph [] = new char[25];	
		char a = 'a';
		try{
			System.out.print("Enter Key : ");
			key = br.readLine();
			int flag = 0;
			char contain = 'j';

			for (int i = 0 ; i < key.length() ; i += 1 ) {
				if(key.charAt(i)<96 && key.charAt(i)>123){
					throw new ArrayIndexOutOfBoundsException();
				}
				if(key.charAt(i) == 'j'){
					contain = 'i';
					flag += 1;
				}
				if(key.charAt(i) == 'i'){
					flag += 1;
				}
				if (flag == 2) {
					throw new Exception();
				}
			}
			System.out.print("Enter Message : ");
			msg = br.readLine();

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

			for (i = 0 ; i < 5 ; i += 1 ) {
				for ( j = 0 ; j < 5 ; j += 1 ) {
					arr[i][j] = Character.toString(alph[k++]);
				}
			}
			for (i = 0 ; i < 5 ; i += 1 ) {
				for ( j = 0 ; j < 5 ; j += 1 ) {
					System.out.print("\t"+arr[i][j]);
				}
				System.out.println();
			}

			// for (i = 0 ; i < alph.length ; i += 1 ) {
			// 	System.out.print("\t"+alph[i]);
			// }
		}catch(IOException e){
			e.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException e1){
			System.out.println("Please enter a - z ONLY...");
		}catch(Exception e2){
			System.out.println("i and j together in string is not ALLOWED...");
		}
	}
}