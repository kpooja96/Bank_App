package com.capgemini.bankapp.dao; 
 
 
 import java.util.List; 
 
 
 import com.capgemini.bankapp.model.BankAccount; 
import com.capgemini.bankapp.exception.BankAccountNotFoundException;
 
 
 public interface BankAccountDao { 
	
 	public double getBalance(long accountId)throws BankAccountNotFoundException; 
	public void updateBalance(long accountId, double newBalance); 
 
 	public boolean deleteBankAccount(long accountId); 

 	public boolean addNewBankAccount(BankAccount account); 
	
	public List<BankAccount> findAllBankAccountsDetails(); 

 
	public BankAccount searchAccountDetails(long accountId) throws BankAccountNotFoundException; 

 	 
	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType);
 } 
