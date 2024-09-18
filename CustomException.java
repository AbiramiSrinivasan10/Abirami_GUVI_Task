class InvalidAgeException  extends Exception  
{  
	public InvalidAgeException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
    }  
}  

public class CustomException {
	static void validate1 (int age) throws InvalidAgeException{    
	       if(age < 18){  
	  
	        // throw an object of user defined exception  
	        throw new InvalidAgeException("age is less than 18");    
	    }  
	       else {   
	        System.out.println("Age is Greater than 18");   
	        }   
	     }    
	  
	    // main method  
	    public static void main(String args[])  
	    {  
	        try  
	        {  
	            // calling the method   
	            validate1(13);  
	        }  
	        catch (InvalidAgeException e)  
	        {  
	            // printing the message from InvalidAgeException object  
	            System.out.println("Exception occured: " + e);  
	        }  
	  
	        System.out.println("rest of the code");    
	    }

		static void validate (int age) throws InvalidAgeException{    
		       if(age < 18){  
		  
		        // throw an object of user defined exception  
		        throw new InvalidAgeException("age is not valid to vote");    
		    }  
		       else {   
		        System.out.println("welcome to vote");   
		        }   
		     }    
		  
		    // main method  
		    public static void main1(String[] args)
		    {  
		        try  
		        {  
		            // calling the method   
		            validate1(13);  
		        }  
		        catch (InvalidAgeException ex)  
		        {  
		            System.out.println("Caught the exception");  
		    
		            // printing the message from InvalidAgeException object  
		            System.out.println("Exception occured: " + ex);  
		        }  
		  
		        System.out.println("rest of the code...");    
		    }  
		}    
	
		


