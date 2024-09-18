//importing ArrayList
import java.util.ArrayList;
public class ListtoArray {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		//adding values in list
	      list.add("Apple");
	      list.add("Orange");
	      list.add("Banana");
	      list.add("Pineapple");
	      //print Contents of list 
	      System.out.println("Contents of list ::"+list);
	      String[] myArray = new String[list.size()];
	      //convert list to Array using Syntax
	      list.toArray(myArray);

	      for(int i=0; i<myArray.length; i++){
	         System.out.println("Element at the index "+i+" is ::"+myArray[i]);

	}

}
}