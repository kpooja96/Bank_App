package com.capgemini.bankapp.service; 
 
 
 import java.util.List; 
 
 
 import com.capgemini.bankapp.exception.BankAccountNotFoundException; 
 import com.capgemini.bankapp.exception.LowBalanceException; 
 import com.capgemini.bankapp.model.BankAccount; 
 
 
 public interface BankAccountService { 
 	 
 
 
 	public double checkBalance(long accountId) throws BankAccountNotFoundException; 
 
 
 	public double withdraw(long accountId, double amount) throws BankAccountNotFoundException, LowBalanceException; 
 
 
 	public double deposit(long accountId, double amount) throws BankAccountNotFoundException; 
 
 
 	public boolean deleteBankAccount(long accountId) throws BankAccountNotFoundException; 
 
 
 	public boolean addNewBankAccount(BankAccount account); 
 
 
 	public List<BankAccount> findAllBankAccountsDetails(); 
 
 
 	public BankAccount searchAccountDetails(long accountId) throws BankAccountNotFoundException; 
 
 
	public double fundTransfer(long fromAccount, long toAccount, double amount) 
 			throws BankAccountNotFoundException, LowBalanceException; 
 
 
 	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType)throws BankAccountNotFoundException; 
 
 

 
 } 
