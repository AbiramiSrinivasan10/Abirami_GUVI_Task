import java.util.Scanner;
public class Numberpattern {
	public static void main(String[] args) {
		//Get user input data
		Scanner obj=new Scanner(System.in);
		int a=obj.nextInt();
		int x,y,z=1;
		//Loop to print next line
	    for(x=1;x<=a;x++)
		{
	    	//Loop to print numbers increasing with loop iteration
    		for(y=1;y<x+1;y++)
    		{
    		    System.out.print(z + " ");
    		    z++;
    		}
    		System.out.println();
		}
	}
}

