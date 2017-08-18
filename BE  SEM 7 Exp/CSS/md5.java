import java.io.*;
import java.security.*;
import java.math.BigInteger;
  public class md5 {
	  public static String getmd5(String input) {
	try {
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] messageDigest = md.digest(input.getBytes());
		System.out.println("Byte Representation: " + messageDigest);
		
		
		BigInteger number = new BigInteger (1,messageDigest);
		System.out.println("number: " +number);
		String hashtext = number.toString(16);
	
		while (hashtext.length() < 32)
		{
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}
	catch(NoSuchAlgorithmException e)
{
	throw new RuntimeException(e);
}
}
public static void main (String args[]) throws NoSuchAlgorithmException,IOException 
{
	System.out.println("Enter The String");
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String text1 = br.readLine();
	System.out.println("hash value:"+getmd5("text1"));
}
}
/*
Enter The String
Hello AIKTC
Byte Representation: [B@15db9742
number: 275107619229391243953060781836866262335
hash value:cef7ccd89dacf1ced6f5ec91d759953f
*/

