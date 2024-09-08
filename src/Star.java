import java.util.Scanner;
public class Star {

	public static void main(String[] args) {
		 Scanner obj = new Scanner(System.in);
		 //getting input from user
	        System.out.println("Enter Number : ");
	       int a=obj.nextInt();
	       int x=0,y=a-1;
	       //logic to print star pattern
	       for(int i=0;i<a;i++) {
	    	   for(int j=0;j<a;j++) {
	    		   if(j==x || j==y) {
	    			   System.out.print("*");
	    		   }else {
	    			   System.out.print(" ");
	    		   }
	    		   
	    	   }
	    	   x++;
	    	   y--;
	    	   System.out.println();
	       }

	}

}
