import java.util.Scanner;
public class Person {
	//Declare a private variable to store the name of the person
	private String name;
	//Declare a private variable to store the age of the person
	private int age;
	//constructor for the person class 
	public Person (String name,int age){
		//set the variable to provide parameter
		this.name=name;
		this.age=age;
	}
	//Method to retrieve the name of the person
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
    public static void main (String args[]) {
    	//get input from user
    	System.out.println("Enter Name: ");
    	Scanner obj=new Scanner(System.in);
    	String inputName=obj.next();
  	    System.out.println("Enter Age: ");
    	int inputAge=obj.nextInt();
    	
    	//Create an object
    	Person p=new Person(inputName, inputAge);
    	//Get name and age
    	String outputName = p.getName();
    	int outputAge = p.getAge();
    	System.out.println("Name: "+outputName);
    	System.out.println("Age: "+outputAge);
    }
}
