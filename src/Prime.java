import java.util.Scanner;
public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        Scanner obj = new Scanner(System.in);
		        boolean primeFlag = false;
		        int a = obj.nextInt();
		        if(a<=1){
		            System.out.println("not a prime number");
		        }else if(a % 2==0){
		            System.out.println("not a prime number");
		        }else{
		            for(int i=3 ; i< a/2 ; i=i+2){
		                if(a % i==0){
		                    primeFlag = true; 
		                    System.out.println("not a prime number");
		                    break;
		                }
		            }
		            if(primeFlag != true){
		                System.out.println("It’s a prime number");
	    }
    }
  } 
}


