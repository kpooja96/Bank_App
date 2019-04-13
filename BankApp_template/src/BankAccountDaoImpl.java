package com.capgemini.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.model.BankAccount;
//import com.capgemini.bankapp.util.DbUtil;
import javax.sql.DataSource;

public class BankAccountDaoImpl implements BankAccountDao 
{


	public JdbcTemplate jdbcTemplate;

	public BankAccountDaoImpl(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate=jdbcTemplate;
	}

 	@Override 
 	public boolean deleteBankAccount(long accountId)
	{ 
 		String query = "DELETE FROM bankaccounts WHERE account_id=" + accountId; 
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
	
	
	

	
	
}
