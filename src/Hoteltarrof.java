import java.util.Scanner;
public class Hoteltarrof {
public static void main(String[] args) {
	Scanner obj=new Scanner(System.in);
	//getting input from user
	System.out.print("Enter Month: ");
	int Month=obj.nextInt();
	System.out.print("Enter Rent: ");
	float Rent=obj.nextFloat();
	System.out.print("Enter number of Days: ");
	int Days=obj.nextInt();
	//Calculating Tarrif
	float Tarrif=Rent*Days;
	double r=((Rent+(Rent*0.2))*Days);
	//using switch statement to print correct values
	switch(Month) {
	case 1:
		System.out.println("Hotel tarriff: "+String.format("%.2f",Tarrif));
		break;
	case 2:
		System.out.println("Hotel tarriff: "+String.format("%.2f",Tarrif));
		break;
	case 3: 
		System.out.println("Hotel tarriff: "+String.format("%.2f",Tarrif));
		break;
	case 4:
	System.out.println("Hotel Tarrif: "+String.format("%.2f",r));
		break;
	case 5:
		System.out.println("Hotel tarriff: "+String.format("%.2f",r));
		break;
	case 6:
		System.out.println("Hotel tarriff: "+String.format("%.2f",r));
		break;
	case 7:
		System.out.println("Hotel tarriff: "+String.format("%.2f",Tarrif));
		break;
	case 8:
		System.out.println("Hotel tarriff: "+String.format("%.2f",Tarrif));
		break;
	case 9:
		System.out.println("Hotel tarriff: "+String.format("%.2f",Tarrif));
		break;
	case 10:
		System.out.println("Hotel tarriff: "+String.format("%.2f",Tarrif));
		break;
	case 11:
		System.out.println("Hotel tarriff: "+String.format("%.2f",r));
		break;
	case 12:
		System.out.println("Hotel tarriff: "+String.format("%.2f",r));
	break ;
	}
	}
}


