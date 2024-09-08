//Import library
import java.util.Scanner;

public class Reversestring {

	public static void main(String[] args) {
		// Get input data from user
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter String : ");
	    String userInput=obj.next();
		 
		String z = "";
		int strLength = userInput.length();
		
		//Reverse the input data and print
		for (int i = (strLength - 1); i >=0; --i) {
		      z = z + userInput.charAt(i);
		}
		System.out.println("Reversed String is : "+z);
	}

}
