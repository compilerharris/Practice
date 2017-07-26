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
		char alph [] = "zzzzzzzzzzzzzzzzzzzzzzzzzz".toCharArray();
		char a = 'a';
		try{
			System.out.print("Enter Key : ");
			key = br.readLine();
			System.out.print("Enter Message : ");
			msg = br.readLine();

			int len = key.length();
			int ind = 0, h = 0,i = 0,k, flag = 0 ;


			for (; i<len ; i += 1) {
				// if(key.charAt(h) == (char)){
				//key = sohail;
				// }
				// alph = ;
				alph[i] = key.charAt(i);
				// System.out.print(alph[i]);
			}
			for (k = 0 ; k<25 ;  k += 1,a += 1) {
				if(a == 'j'){
					continue;	
				}
				for ( h = 0 ; h < len ; h += 1 ,flag += 1) {
					if(a != (char)key.charAt(h)){
						// System.out.print(key.charAt(h));
					}
					else{
						break;
					}
				}
				if (flag>=len) {
					alph[i] = a;
					i++;
				}
			}
			System.out.println();
			for(int musa=0 ; musa<25 ; musa++){
				System.out.print(alph[musa]);
			}
		}catch(Exception e){
			// System.out.print("masla hai");
			e.printStackTrace();
		}
		// for (int i=0; i < (int)len/5 ; i++) 
		// {
		// 	// if(key.length()<=5)
		// 	// {
		// 		for (int j=0; j<5; j++)
		// 		{
		// 			arr				
		// 		}		
		// 	// }else if{

		// 	// }

		// }	
	}
}