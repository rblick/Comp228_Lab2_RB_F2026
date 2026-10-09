/**
 * Lab2_Robert Blick_F2026
 */

public class BankAccount 
{
	//Variables
	String accountNum = "000000000";
	int minAccountNumLength = 9;
	String userName = "";
	double accountBalance;
	double exchangeAmount;
	boolean vaid;
	
	//Constructor and validator for BankAccount objects  
	public BankAccount(String accountNum, String userName, double accountBalance) 
	{
		if (accountNum.matches("[0-9]{9}")) 
		{
			this.accountNum = accountNum;
		}
		else 
		{
			System.out.println("Invalid account number.");
		}
		
		if (userName != null) 
		{
	        this.userName = userName;
	    } 
		else 
	    {
	        System.out.println("Name cannot be blank.");
	    }
		
		if (accountBalance >= 0) 
		{
			this.accountBalance = accountBalance;
		}
	    else 
	    {
	        System.out.println("Balance cannot be negative.");
	    }
	}
	
	//Method for depositing 
	public void deposit(double exchangeAmount)
	{
		this.exchangeAmount = exchangeAmount;
		accountBalance = accountBalance + exchangeAmount;
		System.out.printf("Your balance is now: $%.2f%n", accountBalance);
	}
	
	//Method for withdrawing
	public void withdraw(double exchangeAmount) throws InsufficientFundsException
	{
		this.exchangeAmount = exchangeAmount;
			
		if (exchangeAmount > accountBalance) 
		{
			throw new InsufficientFundsException("Insufficient funds!");
		}
			
		accountBalance = accountBalance - exchangeAmount;
		System.out.printf("Your balance is now: $%.2f%n", accountBalance);
		
	}	
	
}	

//Exception Handler for withdrawing more than your balance
class InsufficientFundsException extends Exception 
{
	public InsufficientFundsException(String message) 
	{
        super(message);
    }
}
