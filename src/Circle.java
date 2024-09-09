// Define the Circle class

import java.util.Scanner;

public class Circle {
	// Declare a private variable to store the radius of the circle
    private double radius;
    // Constructor for the Circle class that initializes the radius variable
    public Circle(double radius) {
     // Set the radius variable to the provided radius parameter
        this.radius = radius;
    }
    public Circle() {
        // Set the radius variable to the provided radius parameter
           this.radius = 8.0;
       }

    // Method to calculate and return the circumference of the circle
    public double getCircumference() {
        // Calculate the circumference using the formula 2 * π * radius and return the result
        return 2 * Math.PI * radius;
    }

	public static void main(String[] args) {
		// Calculate circumference by passing radius from user
    	System.out.println("Enter Radius: ");
    	Scanner obj=new Scanner(System.in);
    	Double inputRadius=obj.nextDouble();
		Circle c1=new Circle(inputRadius);
		System.out.println("Circumference with user input: "+c1.getCircumference());
		
		// Calculate circumference without passing radius
		Circle c2=new Circle();
		System.out.println("Circumference without input: "+c2.getCircumference());	
	}

}
