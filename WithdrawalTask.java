/*
Making a Withdrawal Task in Banking Software.
This is related to Concurrent Programming.
WithdrawTask.java
*/
import java.util.concurrent.*;

public class WithdrawalTask implements Runnable{

	// instance variable with private access
	private BankAccount account;

	// Constructor to build BankAccount
	public WithdrawalTask(BankAccount a){
		account = a;
	}

	// Runs the withdrawal
	public void run(){

		// 
		for(int k = 0; k < 10; k++){

			// Could be a random amount
			int withdrawAmt = 2;

			account.withdrawal(withdrawAmt);

			try{
				// in msec
				Thread.sleep(8);
			}
			catch(InterruptedException e){
				System.out.println(1);
			}
		}
	}
}