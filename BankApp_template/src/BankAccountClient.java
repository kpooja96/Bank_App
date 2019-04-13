package com.capgemini.bankapp.client; 
 
 
 import java.io.BufferedReader; 
 import java.io.IOException; 
 import java.io.InputStreamReader; 
 import java.util.List; 
 
 
 
 
 import com.capgemini.banapp.exception.BankAccountNotFoundException; 
// import com.capgemini.bankapp.exception.LowBalanceException; 
 import com.capgemini.bankapp.model.BankAccount; 
 import com.capgemini.bankapp.service.BankAccountService; 
 import com.capgemini.bankapp.service.impl.BankAccountServiceImpl; 
 import org.springframework.context.ApplicationContext; 
 import org.springframework.context.support.ClassPathXmlApplicationContext; 
 
 
 public class BankAccountClient  
 { 
 
 
 	// static final Logger logger = Logger.getLogger(BankAccountClient.class); 
 
 
 	public static void main(String[] args)  
 	{ 
 		int choice; 
 		String accountHolderName; 
 		String accountType; 
 		double accountBalance; 
 		double amount; 
 		long accountId; 
 		long fromAccount; 
 		long toAccount; 
 
 
 		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml"); 
		BankAccountService bankService= (BankAccountService)context.getBean("bankAccountServiceImpl"); 
 
 
 		 
 		// BankAccountService bankService = new BankAccountServiceImpl(); 
 		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))  
 		{ 
 			while (true)  
 			{ 
 				System.out.println("1.Add New BankAccount\n2.Withdraw\n3.Deposit\n4.Check Balance"); 
 				System.out.println("5.Fund Transfer\n6.Delete BankAccount\n7.Display BankAccount Details"); 
 				System.out.println("8.Search BankAccount\n9.Update Account\n10.Exit"); 
 
 
 				System.out.print("Enter your choice :"); 
 				choice = Integer.parseInt(reader.readLine()); 
 
 
 				switch (choice)  
 				{ 
				case 1: 
 					System.out.println("Enter Account Holder Name"); 
 					accountHolderName = reader.readLine(); 
 					System.out.println("Enter Account Type"); 
 					accountType = reader.readLine(); 
 					System.out.println("Enter Account Balance"); 
 					accountBalance = Double.parseDouble(reader.readLine()); 
 					BankAccount account = new BankAccount(accountHolderName, accountType, accountBalance); 
 					if (bankService.addNewBankAccount(account))  
 					{ 
						System.out.println("Account created successfully\n"); 
 					}  
 					else  
 					{ 
 						System.out.println("failed to create\n"); 
 					} 
					break; 
			
				case 2: 
 					System.out.println("Enter your Account Id:"); 
 					accountId = Long.parseLong(reader.readLine()); 
 
 
 					if (bankService.deleteBankAccount(accountId)) { 
 						System.out.println("Account Deleted successfully.."); 
 					} else { 
 						System.out.println("Account can't delete.."); 
 						System.out.println(); 
 					} 
 					break; 
				/*
				case 3: 
 					System.out.println("Enter your Account Id:"); 
 					accountId = Long.parseLong(reader.readLine()); 
 					System.out.println("Update your name:"); 
 					accountHolderName = reader.readLine(); 
 					System.out.println("Update account type:"); 
 					accountType = reader.readLine(); 
 					if (accountService.updateBankAccountDetails(accountId, accountHolderName, accountType)) { 
 						System.out.println("Bank Detail Updated Successfully...."); 
 					} 


				*/
				case 3: 
 					System.out.println("Thanks for banking with us"); 
					System.exit(0); 
 				} 
 			} 
 		} catch (IOException e) { 
 			// logger.error("Exception :", e); 
 		} 
 	} 
 } 

