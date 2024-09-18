//importing java files
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Readfile {  
  public static void main(String[] args) {  
	  //using try catch block for FileNotFoundException
    try {
      File myObj = new File("student.txt");
      Scanner myReader = new Scanner(myObj);  
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
  }  

}
