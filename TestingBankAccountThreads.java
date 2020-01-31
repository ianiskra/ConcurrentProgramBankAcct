/*
Test the Bank Account Threads in Banking Software.
This is related to Concurrent Programming.
TestingBankAccountThreads.java
*/
import java.util.concurrent.*;

public class TestingBankAccountThreads{

	// Create Bank Account object by instantiation
	public static BankAccount account = new BankAccount(100);

	public static void main(String[] args){
		System.out.println("Main: Initial Account Balance: $"
			+ account.getBalance());

		// Threading Process in Concurrency
		Thread depositThread = new Thread(new DepositTask(account));
		Thread withdrawThread = new Thread(new WithdrawalTask(account));

		// Invoke independent tasks
		depositThread.start();
		withdrawThread.start();

		// Wait for threads to complete
		try{
			depositThread.join();
			withdrawThread.join();
		}
		catch(InterruptedException e){
			System.out.println(e);
			System.exit(1);
		}

		// Account Balance Printout based from Threading
		System.out.println("Main: Final Balance is $" + account.getBalance() );
	}
}