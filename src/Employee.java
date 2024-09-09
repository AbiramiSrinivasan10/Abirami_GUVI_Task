
import java.util.Scanner;
public class Employee {
	// Declare a private variable to store the radius of the circle
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    
    public Employee(int id, String firstName, String lastName, int salary) {
    	this.id = id;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.salary = salary;
    }
    
    public int getId() {
    	return id;
    }

    public String getFirstName() {
    	return firstName;
    }

    public String getLastName() {
    	return lastName;
    }

    public String getName() {
    	return firstName+" "+lastName;
    }
    
    public int getSalary() {
    	return salary;
    }
    
    public int getAnnualSalary() {
    	return salary*12;
    }
    
    public void setSalary(int salary) {
    	this.salary= salary ;
    }
    
    public void raiseSalary(int percent) {
    	int hikeSalary=(this.salary*percent)/100;
    	this.setSalary(this.salary+hikeSalary);
    }
    
	public static void main(String[] args) {
		// Initialize Employee details
		Employee e=new Employee(100001,"Abirami","Srinivasan",25000);
		
		//Print Employee details
		System.out.println("Employee ID: "+e.getId());
		System.out.println("Employee First Name: "+e.getFirstName());
		System.out.println("Employee Last Name: "+e.getLastName());
		System.out.println("Employee Full Name: "+e.getName());
		System.out.println("Employee Salary: "+e.getSalary());
		System.out.println("Employee Annual Salary: "+e.getAnnualSalary());
		
		//Get hike percentage to increase salary
		System.out.println("Enter hike percentage of Employee");
    	Scanner obj=new Scanner(System.in);
    	int hikePercent=obj.nextInt();
    	
    	//Print Employee hiked salary
    	e.raiseSalary(hikePercent);
		System.out.println("Employee Salary: "+e.getSalary());
		System.out.println("Employee Hiked Annual Salary: "+e.getAnnualSalary());
	}

}
