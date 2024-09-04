import java.util.Scanner;
public class Factorial {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		       
		  Scanner obj = new Scanner(System.in);
		        int a = obj.nextInt();
		        int f = 1;
		        for(int i = 1; i <= a; ++i)
		        {
		          // factorial = factorial * i;
		            f *= i;
		        }
		        System.out.printf("Factorial of num is " + f);
		        }
			}

