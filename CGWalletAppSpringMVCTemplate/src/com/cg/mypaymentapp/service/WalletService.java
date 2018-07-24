package com.cg.mypaymentapp.service;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.NamedQuery;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;

public interface WalletService
{
	public Customer createAccount(Customer customer);
	
	public Customer showBalance (String mobileno) throws InvalidInputException;
	
	public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, BigDecimal amount) throws InvalidInputException;
	
	public Customer depositAmount (String mobileNo,BigDecimal amount ) throws InvalidInputException;
	
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) throws InvalidInputException,InsufficientBalanceException;
	
	public ArrayList<Transaction> miniStatement(String mobileno);

	public ArrayList<Customer> getAllCustomers();

	public ArrayList<Customer> filterCustomers(BigDecimal amount);

}
