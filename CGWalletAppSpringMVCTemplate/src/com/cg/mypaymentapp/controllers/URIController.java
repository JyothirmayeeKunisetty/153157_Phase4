package com.cg.mypaymentapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cg.mypaymentapp.beans.Customer;

@Controller
public class URIController {

	@RequestMapping(value="/")
	public String getIndexPage()
	{
		return "indexPage";
	}
	
	@RequestMapping(value="/registrationPage")
	public String getRegistrationPage()
	{
		return "registrationPage";
	}
	
	@RequestMapping(value="/loginPage")
	public String getLoginPage()
	{
		return "loginPage";
	}
	
	@ModelAttribute("customer")
	public Customer getCustomer()
	{
		return new Customer();
	}
	
	@RequestMapping(value="/requestBalancePage")
	public String getRequestBalancePage()
	{
		return "requestBalancePage";
	}
	
	@RequestMapping(value="/depositPage")
	public String getDepositPage()
	{
		return "depositPage";
	}
	
	@RequestMapping(value="/withdrawPage")
	public String getWithdrawPage()
	{
		return "withdrawPage";
	}
	
	@RequestMapping(value="/fundTransferPage")
	public String getFundTransferPage() {
		return "fundTransferPage";
	}
	
	@RequestMapping(value="/requestToViewFilteredCustomers")
	public String getFilterCustomersPage() {
		return "requestToViewFilteredCustomers";
	}
}
