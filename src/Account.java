
import java.util.Scanner;
public class Account {
	private double balance;
	
	public Account(double balance) {
		this.balance = balance;
	}

	public Account() {
		this.balance = 25000.0;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void withdrawAmount(double Amount) {
		double balance=this.balance-Amount;
		this.setBalance(balance);
	}
	
	public void depositAmount(double Amount) {
		double balance=this.balance+Amount;
		this.setBalance(balance);
	}

	public static void main(String[] args) {
		// Display initial balance
		Account a1=new Account();
		System.out.println("Balance without user input: "+a1.getBalance());
		
		// Display user balance
		System.out.println("Enter user account balance: ");
    	Scanner obj=new Scanner(System.in);
    	Double balance=obj.nextDouble();
		Account a2=new Account(balance);
		System.out.println("Balance with user input: "+a2.getBalance());
		
		//Deposit amount
		a2.depositAmount(5000.0);
		System.out.println("Balance after deposit 0f 5000: "+a2.getBalance());
		
		//Withdraw amount
		a2.withdrawAmount(2000.0);
		System.out.println("Balance after withdrawal of 2000: "+a2.getBalance());

	}

}
