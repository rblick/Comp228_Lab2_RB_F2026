import java.util.Scanner;

/**
 * Lab2_Robert Blick_F2026
 */

public class MainDriver 
{
	public static void main(String[] args) 
	{
		//variables
		String accountNum;
		int selectedAccount=0;
		boolean validID = false;
		boolean session = true;
		double exchangeAmount = 00.00;
		
		BankAccount[] accounts = {
				new BankAccount("000000001", "Mr. Monopoly", 10000000.01),
				new BankAccount("123456789", "John Smith", 111.10),
				new BankAccount("300808673", "Robert Blick", 1995.31),
				new BankAccount("987654320", "John Doe", 561.75),
				new BankAccount("987654321", "Jane Doe", 5999.01)
		};
		
		
		//Get Account Number
		while (validID == false) 
		{
			System.out.println("Please enter your account number: ");
			Scanner scanner = new Scanner(System.in);
			accountNum = scanner.nextLine();
			selectedAccount = 0;
		
			for (BankAccount a : accounts) 
			{
				if (accountNum.equals(a.accountNum)) 
				{
					System.out.println("Hello " + accounts[selectedAccount].userName);
					System.out.println("Your balance is: $" + accounts[selectedAccount].accountBalance);
					validID = true;
					break;
				}
				selectedAccount ++;		
			}
			if (validID == false) 
			{
			System.out.println("Account number is not found");	
			}
		}
		
		
		//Make Selection
		while (session == true) {
			System.out.println("1.-Deposit, 2-Withdraw, 3-Exit");
			Scanner sc = new Scanner(System.in);
				int choice=sc.nextInt();
				switch (choice) {
				
				case 1:
					//Deposit
					System.out.println("How much would you like to deposit?");
					Scanner d = new Scanner(System.in);
					exchangeAmount = d.nextDouble();
					accounts[selectedAccount].deposit(exchangeAmount);
				 	continue;
				   
				case 2:
					//Withdraw
					System.out.println("How much would you like to withdraw?");
					Scanner w = new Scanner(System.in);
					exchangeAmount = w.nextDouble();
					
					//Check to see if user is taking more money than they have
					try 
					{
						accounts[selectedAccount].withdraw(exchangeAmount);
					}
				    catch (InsufficientFundsException e)
				    {
				    	System.out.println(e.getMessage());
				    }
					
					continue;
					
				case 3:
					//Quit
					System.out.println("Goodbye!");
					session = false;
					break;  
			}
		}
	}
}

