package com.cg.mypaymentapp.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import javax.validation.Valid;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.service.WalletService;

@Controller
public class CustomerActionController {
	
	@Autowired
	WalletService walletService;

	@RequestMapping(value="/successfullRegistrationPage")
	public ModelAndView registerCustomer(@Valid@ModelAttribute("customer")Customer customer,BindingResult result)
	{
		try {
		if(result.hasErrors())
			return new ModelAndView("registrationPage");
		customer=walletService.createAccount(customer);
	
		}
		catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("errorPage");
		}
		return new ModelAndView("successfullRegistrationPage", "customer", customer);
	}

	@RequestMapping(value="/displayBalancePage",method=RequestMethod.POST)
	public ModelAndView getMobileNumber(@RequestParam("mobileNo")String mobileNo)
	{
		try {
			Customer customer=walletService.showBalance(mobileNo);;
			return new ModelAndView("displayBalancePage","customer",customer);
		} catch (Exception e) {
			return new ModelAndView("requestBalancePage","errorMessage",e.getMessage());
		}
	}
	
	@RequestMapping(value="/successfullDepositPage",method=RequestMethod.POST)
	public ModelAndView getDeposit(@RequestParam("mobileNo")String mobileNo,@RequestParam("wallet.balance")BigDecimal amount)
	{
		try {
			Customer customer = walletService.depositAmount(mobileNo, amount);
			return new ModelAndView("successfullDepositPage","customer",customer);
		} catch (InvalidInputException e) {
			return new ModelAndView("depositPage","errorMessage",e.getMessage());
		}
	}
	
	@RequestMapping(value="/successfullWithdrawPage")
	public ModelAndView getWithdraw(@RequestParam("mobileNo")String mobileNo,@RequestParam("wallet.balance")BigDecimal amount)
	{
		Customer customer;
		try {
			customer = walletService.withdrawAmount(mobileNo, amount);
			return new ModelAndView("successfullWithdrawPage","customer",customer);
		} catch (InvalidInputException e) {
			return new ModelAndView("withdrawPage","errorMessage",e.getMessage());
		}
	}
	
	@RequestMapping(value="/successfullFundTransferPage")
	public ModelAndView getFundTransfer(@RequestParam("sourceMobileNo")String sourceMobileNo,@RequestParam("targetMobileNo")String targetMobileNo,@RequestParam("wallet.balance")BigDecimal amount)
	{
		Customer customer;
		try {
			customer = walletService.fundTransfer(sourceMobileNo, targetMobileNo, amount);
			return new ModelAndView("successfullFundTransferPage","customer",customer);
		} catch (InvalidInputException e) {
			return new ModelAndView("fundTransferPage","errorMessage",e.getMessage());
		}
		
		
	}
	
	@RequestMapping(value="/allCustomersPage")
	public ModelAndView getAllCustomers() 
	{
		ArrayList<Customer> customer=walletService.getAllCustomers();
		
		return new ModelAndView("allCustomersPage","customer",customer);
	}

	@RequestMapping(value="/filteredCustomersPage")
	public ModelAndView getFilterCustomers(@RequestParam("amount")BigDecimal amount)
	{
		ArrayList<Customer> customer=walletService.filterCustomers(amount);
		
		return new ModelAndView("filteredCustomersPage","customer",customer);
	}
}
