import java.util.Scanner;
public class greater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner obj = new Scanner(System.in);
        int a = obj.nextInt();
        int b = obj.nextInt();
        int c = obj.nextInt();
        int d = obj.nextInt();
        int y=a+b;
        int z=c+d;
        if(y>z){
            System.out.println("Sum of a+b is greater than sum of c+d");
        }else{
             System.out.println("sum of c+d is greater than sum of a+b");
        }

	}

}
