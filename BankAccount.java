/*
Viewing the Bank Account info in Banking Software.
This is related to Concurrent Programming.
BankAccount.java
*/
import java.util.concurrent.*;

// Shared Resource: Bank Account acts a monitor for threads
public class BankAccount{

	// Instance variable with private access
	private int balance = 0;

	// Constructor for Bank Account
	public BankAccount(int initBalance){
		balance = initBalance;
	}

	// Monitors all threads in queues by sychronization
	public synchronized void withdrawal(int amt){

		// Check if amount is in the red
		if(amt < 0){
			System.out.println("Withdrawal amount must be >= 0");
			return;
		}

		// What's left over
		int z = balance - amt;

		try{
			// 5 msec
			Thread.sleep(5);
		}
		catch(InterruptedException e){
			System.out.println(e);
			System.exit(1);
		}

		// Check for account balance leftover
		if(z >= 0){
			balance = z;
			System.out.println("Withdrawal: $" + amt + " Balance is $" + balance);
		}
		// Otherwise insufficent amount
		else{
			System.out.println("Withdrawal: Rejected for insufficient funds");
		}
	}

	// Retrieves Account Balance
	public int getBalance(){
		return balance;
	}
}