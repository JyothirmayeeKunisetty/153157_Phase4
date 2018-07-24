package com.cg.mypaymentapp.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Transaction;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.repo.WalletRepo;

@Component(value = "service")
public class WalletServiceImpl implements WalletService {
	long millis = System.currentTimeMillis();
	@Autowired
	private WalletRepo repo;

	public Customer createAccount(Customer customer) {
		return repo.save(customer);
	}

	public Customer showBalance(String mobileNo) throws InvalidInputException {
		
		if(!isValidMobile(mobileNo)) {
			throw new InvalidInputException("Invalid Mobile Number\n");
		}
		else {
			Customer customer=repo.findOne(mobileNo);
			if(customer!=null) {
				return repo.save(customer);
			}else
				throw new InvalidInputException("Account with given Mobile Number Not Found\n");
		}
	}

	public Customer depositAmount(String mobileNo, BigDecimal amount) throws InsufficientBalanceException, InvalidInputException{
		if (!isValidMobile(mobileNo)) 
		{
			throw new InvalidInputException("Incorrect Details");
		}
		if(!isValidAmount(amount))
		{
			throw new InvalidInputException("Please Enter Valid Amount");
		}
		Customer customer = repo.findOne(mobileNo);
		if (customer != null) {
			Wallet balance = customer.getWallet();
			balance.setBalance(balance.getBalance().add(amount));
			return repo.save(customer);
		} else {
			throw new InvalidInputException("Account with mobile number not found ");
		}
	}

	public Customer withdrawAmount(String mobileNo, BigDecimal amount) throws InvalidInputException,InsufficientBalanceException {
		if (!isValidMobile(mobileNo)) 
		{
			throw new InvalidInputException("Incorrect Details");
		}
		if(!isValidAmount(amount))
		{
			throw new InvalidInputException("Please Enter Valid Amount");
		}
		Customer customer = repo.findOne(mobileNo);
		if (customer != null) {
			Wallet balance = customer.getWallet();
			if (balance.getBalance().compareTo(amount) > 0) {
				balance.setBalance(balance.getBalance().subtract(amount));
				return repo.save(customer);
			} else {
				throw new InsufficientBalanceException("Insufficient Balance");
			}
		} else {
			throw new InvalidInputException("Account with Mobile Number Not Found");
		}
	}

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws InvalidInputException {

		if (!isValidMobile(sourceMobileNo)) 
		{
			throw new InvalidInputException("Invalid Source Customer Mobile Number");
		}
		if (!isValidMobile(targetMobileNo)) 
		{
			throw new InvalidInputException("Invalid Target Customer Mobile Number");
		}
		if(!isValidAmount(amount))
		{
			throw new InvalidInputException("Please Enter Valid Amount");
		}
		
		Customer sourceCustomer = repo.findOne(sourceMobileNo);
		Customer destinationCustomer = repo.findOne(targetMobileNo);

		if (sourceCustomer != null && destinationCustomer != null) 
		{
			Wallet sourceBalance = sourceCustomer.getWallet();
			Wallet destinationBalance = destinationCustomer.getWallet();
			if (sourceBalance.getBalance().compareTo(amount) > 0) 
			{
				sourceBalance.setBalance(sourceBalance.getBalance().subtract(amount));
				destinationBalance.setBalance(destinationBalance.getBalance().add(amount));
				repo.save(destinationCustomer);
				return repo.save(sourceCustomer);
			} 
			else 
			{
				throw new InsufficientBalanceException("Insufficient Balance");
			}
		}
		else 
		{
			throw new InvalidInputException("Account with Mobile Number Not Found ");
		}
		
		
	}
	
	private boolean isValidMobile(String mobileNo) {
		if(String.valueOf(mobileNo).matches("[1-9][0-9]{9}")) {
			return true;
		}
		return false;
	}
	
	private boolean isValidAmount(BigDecimal amount) {
		BigDecimal val = new BigDecimal("0");
		if (amount.compareTo(val) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public ArrayList<Transaction> miniStatement(String mobileno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Customer> getAllCustomers() {
		
		return (ArrayList<Customer>) repo.findAll();
	}

	@Override
	public ArrayList<Customer> filterCustomers(BigDecimal amount) {
		
		return repo.filterCustomers(amount);
	}

}
