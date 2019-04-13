package com.capgemini.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.*; 
import com.capgemini.bankapp.map.*; 
import org.springframework.jdbc.core.JdbcTemplate;
import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.model.BankAccount;
//import com.capgemini.bankapp.util.DbUtil;
import com.capgemini.bankapp.exception.BankAccountNotFoundException;

public class BankAccountDaoImpl implements BankAccountDao 
{


	public JdbcTemplate jdbcTemplate;

	public BankAccountDaoImpl(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate=jdbcTemplate;
	}


	@Override 
	public double getBalance(long accountId) { 
 		String query = "SELECT account_balance FROM bankaccount WHERE account_id=?"; 
 		double balance = -1; 
		
			balance=jdbcTemplate.queryForObject(query, new Object[]{accountId},Double.class); 
			 
		 
		return balance; 
	} 

 
	@Override 
	public void updateBalance(long accountId, double newBalance) { 
		String query = "UPDATE bankaccount SET account_balance='"+newBalance+"' WHERE account_id='"+accountId+"' "; 
		jdbcTemplate.update(query); 
		 
	} 


 	@Override 
 	public boolean deleteBankAccount(long accountId)
	{ 
 		String query = "DELETE FROM bankaccount WHERE account_id=" + accountId; 
 		int result=jdbcTemplate.update(query); 
 		if(result>0)
		{ 
 			return true; 
 		}else
		{ 
 			return false; 
		} 
 	}
 
 

	
	@Override
	public boolean addNewBankAccount(BankAccount account) {
		
		int result=jdbcTemplate.update("INSERT INTO bankaccount (customer_name,account_type,account_balance) VALUES(?,?,?)",new Object[]{account.getAccountHolderName(),account. getAccountType(),account.getAccountBalance()}); 

		if(result==1)
			return true;
		else
			return false;

	}
	
	@Override 
	public List<BankAccount> findAllBankAccountsDetails() { 
		String query = "SELECT * FROM bankaccount"; 
		List <BankAccount> account = jdbcTemplate.query(query, new BankMapper()); 
		return account; 
	} 

 
	@Override 
	public BankAccount searchAccountDetails(long accountId)  { 
		String query = "SELECT * FROM bankaccount WHERE account_id=?"; 
		BankAccount account = null; 
		
			account = jdbcTemplate.queryForObject(query,new Object[]{accountId},new BankMapper()); 
 		
 		return account; 
 	} 
 
 
 	@Override 
 	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType) { 
 
 
 		String query = "UPDATE bankaccount SET customer_name='"+accountHolderName+"',account_type='"+accountType+"' WHERE account_id='"+accountId+"' "; 
 			 
 			 
 			int result = jdbcTemplate.update(query); 
 			 
 			if(result>0)
				return true;
			return false;
 				 
	} 
 

 } 

	

	
	

