//importing ArrayList 
import java.util.ArrayList;
public class Array {

	public static void main(String[] args) {
	//creating a Array
	 ArrayList<String> fruits=new ArrayList<String>();
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Mango");
		fruits.add("jackfruit");
		System.out.println("Fruits Array : "+fruits);
		//using clear method to remove all elements in array
		fruits.clear();
		System.out.println("After Removing all elements : "+fruits);
	}
	}

	
