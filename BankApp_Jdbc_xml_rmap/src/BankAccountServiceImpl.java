package com.capgemini.bankapp.service.impl; 
 
 
 import com.capgemini.bankapp.model.BankAccount; 
 import com.capgemini.bankapp.dao.BankAccountDao; 
 import com.capgemini.bankapp.dao.impl.BankAccountDaoImpl; 
 import com.capgemini.bankapp.exception.BankAccountNotFoundException; 
 import com.capgemini.bankapp.exception.LowBalanceException; 
 import com.capgemini.bankapp.service.BankAccountService; 
 import org.springframework.transaction.annotation.Transactional; 
import java.util.List;
 
 
 public class BankAccountServiceImpl implements BankAccountService 
{ 
 
 
 	 private BankAccountDao bankAccountDao; 
 	// static final Logger logger = Logger.getLogger(BankAccountServiceImpl.class); 
 
 
 	public BankAccountServiceImpl(BankAccountDao bankAccountDao) 
	{ 
 		this.bankAccountDao = bankAccountDao; 
 	} 
 

	@Override 
 	public double checkBalance(long accountId) throws BankAccountNotFoundException { 
 		double balance = bankAccountDao.getBalance(accountId); 
 		return balance; 
 	} 
 
 
 	@Override 
 	public double withdraw(long accountId, double amount) throws LowBalanceException, BankAccountNotFoundException { 
		double balance = bankAccountDao.getBalance(accountId); 
		 
		if (balance < 0) { 
 			throw new BankAccountNotFoundException("BankAccount doesn't exist...."); 
 		} else if (balance - amount >= 0) { 
 			balance = balance - amount; 
			bankAccountDao.updateBalance(accountId, balance); 
			return balance; 
 		} else { 
 			throw new LowBalanceException("You don't have sufficient fund."); 
 		} 
 	} 
 
 
 	@Override 
 	public double deposit(long accountId, double amount) throws BankAccountNotFoundException { 
 		double balance = bankAccountDao.getBalance(accountId); 
 		if (balance < 0) { 
 			throw new BankAccountNotFoundException("BankAccount doesn't exist...."); 
 		} else { 
 			balance = balance + amount; 
 			bankAccountDao.updateBalance(accountId, balance); 
 			return balance; 
 		} 
 	} 
 
 

 
 	@Override 
 	public boolean deleteBankAccount(long accountId) throws BankAccountNotFoundException
	 { 
 		boolean result = bankAccountDao.deleteBankAccount(accountId); 
 
 
 		if (result) 
		{ 
 			return result; 
 		}  
 			throw new BankAccountNotFoundException("BankAccount doesn't exist...."); 
 		
 
 
 	} 


 	@Override 
 	public boolean addNewBankAccount(BankAccount account) 
	{ 
 		boolean result = bankAccountDao.addNewBankAccount(account); 
 		return result; 
 	} 
 	
	@Override 
 	public List<BankAccount> findAllBankAccountsDetails() { 
 		return bankAccountDao.findAllBankAccountsDetails(); 
 	} 
 
 
 	@Override 
 	public BankAccount searchAccountDetails(long accountId) throws BankAccountNotFoundException { 
 		return bankAccountDao.searchAccountDetails(accountId); 
 	} 
 
 
 	@Override 
 	@Transactional(rollbackFor=BankAccountNotFoundException.class) 
 	public double fundTransfer(long fromAccountId, long toAccountId, double amount) 
 			throws LowBalanceException, BankAccountNotFoundException { 
 
 
 		try { 
 			double newBalance = withdraw(fromAccountId, amount); 
 			deposit(toAccountId, amount); 
 			return newBalance; 
 		} catch (LowBalanceException | BankAccountNotFoundException e) { 
 
 
 			throw e; 
 		} 
 	} 
 
 
 	@Override 
 	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType)throws BankAccountNotFoundException { 
 		boolean result = bankAccountDao.updateBankAccountDetails(accountId, accountHolderName, accountType); 
 		return result; 
	} 
 } 



