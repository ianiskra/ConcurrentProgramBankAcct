/*
	Making a Deposit Task in Banking Software
	This is related to Concurrent Programming.
	DepositTask.java
*/
import java.util.concurrent.*;

public class DepositTask implements Runnable{

	// Instance variable with private access
	private BankAccount account;

	// Constructor to handle deposits
	public DepositTask(BankAccount a){
		account = a;
	}

	public void run(){

		for(int k = 0; k < 10; k++){

			// Could be random
			int depositAmt = 5;
			account.deposit(depositAmt);

			try{
				// original 4 in msec
				Thread.sleep(4);
			}
			catch(InterruptedException e){
				System.out.println(e);
				System.exit(1);
			}
		}
	}
}