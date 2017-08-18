import java.util.*;
class ceaserc {
	int k, tmp;
	String ip, op;
	static String all = "";
	Scanner iv = new Scanner(System.in);

	public int k() {
		System.out.print("\nEnter your key: ");
		k = iv.nextInt();
		while(k < 1 || k > 26) {
			System.out.println("[key is out ofbounds]");
			System.out.print("\nPlease Enter key between 1 to 26: ");
			k = iv.nextInt();}
	return k;}

	public void encrypt(){
		System.out.print("\nEnter Plain Text: ");
		ip = iv.nextLine();
		k = this.k();
		op = "";
		for(int i = 0; i < ip.length(); i++)
			op += all.charAt(( all.indexOf(ip.charAt(i)) + k) % all.length());
		System.out.println("\nCipher Text is: [" + op + "]"); }

	public void decrypt() {
		iv.nextLine();
		System.out.print("\nEnter Cipher Text: ");
		ip = iv.nextLine();
		k = this.k();
		op = "";
		for(int i = 0; i < ip.length(); i++) {
			tmp = all.indexOf(ip.charAt(i)) - k;
			if(tmp < 0) tmp = tmp + all.length();
			op += all.charAt(tmp);}
	System.out.println("\nPlain Text: [" + op + "]");}

	public static void main(String[] args) {
		ceaserc obj = new ceaserc();

		for(int i = 32; i <= 126; i++) 
			all += (char) i;
		obj.encrypt();
		obj.decrypt();
	}
}
/* 
Enter Plain Text: Hello AIKTC

Enter your key: 2

Cipher Text is: [Jgnnq"CKMVE]

Enter Cipher Text: Jgnnq"CKMVE

Enter your key: 2

Plain Text: [Hello AIKTC]
*/
