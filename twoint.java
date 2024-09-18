//import the Scanner class to get the input from user
import java.util.Scanner;
public class twoint {

	public static void main(String[] args) {
		//create Scanner object
		Scanner obj=new Scanner(System.in);
		//read user input
		System.out.println("Enter num1: ");
		int num1=obj.nextInt();
		System.out.println("Enter num2: ");
		int num2=obj.nextInt();
	try
	{
		 //code that may raise exception  
		int div=num1/num2;
		System.out.println("Division of two Numbers: "+div);
	}
	catch(ArithmeticException e) {
		
		System.out.println("Second Number is Zero: "+e);
	}
	}

}
