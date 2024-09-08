import java.util.Scanner;
public class Largenumber {
    public static void main(String[] args) {
          	//Getting input via STDIN
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter First Number : ");
       int i=obj.nextInt();
       System.out.println("Enter Second Number : ");
       int j=obj.nextInt();
       System.out.println("Enter Third Number : ");
       int k=obj.nextInt();
       //Compare inputs to find which one is larger using if statement
       if(i>j && i>k){
           System.out.println("Largest Number is: "+i);
       }else if(j>i && j>k){
           System.out.println("Largest Number is: "+j);
       }else{
           System.out.println("Largest Number is: "+k);
       }
       }
              
    }

