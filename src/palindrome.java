//Import library
import java.util.Scanner;

public class palindrome {
	public static void main(String[] args) {
		// Get input data from user
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter String : ");
	    String userInput=obj.next();
		
		String z = "";
		int strLength = userInput.length();
		
		//Reverse the input data
		for (int i = (strLength - 1); i >=0; --i) {
			 z = z + userInput.charAt(i);
		}
		
		//Check if input and reverse of input are same
	    if (userInput.equals(z)) {
	    	System.out.println(userInput + " is a Palindrome String.");
	    }
	    else {
	    	System.out.println(userInput + " is not a Palindrome String.");
	    }
	}
}
