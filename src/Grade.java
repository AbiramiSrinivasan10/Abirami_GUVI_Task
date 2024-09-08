import java.util.Scanner;
public class Grade {
	public static void main(String[] args) {
		//Get user input
    	System.out.println("Enter student Mark : ");
    	Scanner obj=new Scanner(System.in);
    	int mark=obj.nextInt();
    	    	//Check mark and print grade
    	if(mark==100) {
    		System.out.println("Grade : S");
    	}
    	else if(mark>=90 && mark<=99){
    		System.out.println("Grade : A");
    	}
    	else if(mark>=80 && mark<=89){
    		System.out.println("Grade : B");
    	}
    	else if(mark>=70 && mark<=79){
    		System.out.println("Grade : C");
    	}
    	else if(mark>=60 && mark<=69){
    		System.out.println("Grade : D");
    	}
    	else if(mark>=50 && mark<=59){
    		System.out.println("Grade : E");
    	}
    	else if(mark<50){
    		System.out.println("Grade : F");
    	}
    	else {
    		System.out.println("Invalid Input");
    	}	
	}
}