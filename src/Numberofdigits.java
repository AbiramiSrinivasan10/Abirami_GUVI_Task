import java.util.Scanner;
public class Numberofdigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner obj = new Scanner(System.in);
       int a=obj.nextInt();
       int c=0;
       while(a!=0)
       {
           a /= 10;
        c++;
       }
       System.out.println("Number of digits: " + c);
    }
}
