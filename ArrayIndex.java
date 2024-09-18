
public class ArrayIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar[] = { 1, 2, 3, 4, 5 };
		String s = "Abirami";  

        try {
            for (int i = 0; i <= ar.length; i++)
                System.out.print(ar[i]+" ");
            
             }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
        	String substring = s.substring(2, 8); 
        }
        catch(StringIndexOutOfBoundsException g) {
        	System.out.println(g);
        }
	}

}
