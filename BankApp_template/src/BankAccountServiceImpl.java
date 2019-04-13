package com.capgemini.bankapp.service.impl; 
 
 
 import java.util.List; 
 import org.springframework.jdbc.core.JdbcTemplate; 
 
 
 import com.capgemini.banapp.exception.BankAccountNotFoundException; 
 import com.capgemini.banapp.exception.LowBalanceException; 
 import com.capgemini.bankapp.dao.BankAccountDao; 
 import com.capgemini.bankapp.dao.impl.BankAccountDaoImpl; 
 import com.capgemini.bankapp.model.BankAccount; 
 import com.capgemini.bankapp.service.BankAccountService; 
 //import com.capgemini.bankapp.util.DbUtil; 
 
 
 public class BankAccountServiceImpl implements BankAccountService 
{ 
 
 
 	 private BankAccountDao bankAccountDao; 
 	// static final Logger logger = Logger.getLogger(BankAccountServiceImpl.class); 
 
 
 	public BankAccountServiceImpl(BankAccountDao bankAccountDao) 
	{ 
 		this.bankAccountDao = bankAccountDao; 
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
 	
 } 
