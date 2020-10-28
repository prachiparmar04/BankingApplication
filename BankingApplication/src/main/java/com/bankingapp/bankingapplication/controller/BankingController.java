package com.bankingapp.bankingapplication.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankingapp.bankingapplication.entity.BankAccountDetail;
import com.bankingapp.bankingapplication.entity.BillPaymentDetail;
import com.bankingapp.bankingapplication.entity.Customerdetail;
import com.bankingapp.bankingapplication.entity.FundTransferDetail;
import com.bankingapp.bankingapplication.exception.RecordNotFoundException;
import com.bankingapp.bankingapplication.service.BankingService;

/**
 * 
 * @author PRACHI PARMAR
 *
 */
@RestController
public class BankingController {
	/**
	 * Service class injection in controller
	 */
	@Autowired
	private BankingService service;

	/**
	 * 
	 * @param customer object
	 * @return list of banks accounts of a customer
	 */
	@PostMapping("/check-accounts")
	public List<BankAccountDetail> viewBankAccounts(@RequestBody Customerdetail customer) {
		int custId = customer.getCustomerId();
		List<BankAccountDetail> accounts =  service.viewBankAccounts(custId);
		if(accounts.isEmpty()) {
			throw new RecordNotFoundException("No Records Founds of Customer with ID: "+ custId);
		}
		return accounts;
	}

	/**
	 * 
	 * @param customer object
	 * @return list of fund transfer of a customer
	 */
	@PostMapping("/check-fundTranfers")
	public List<FundTransferDetail> viewFunderTranfers(@RequestBody Customerdetail customer) {
		List<FundTransferDetail> transfers = service.viewFundTransfers(customer);
		if(transfers.isEmpty()) {
			throw new RecordNotFoundException("No Records Founds of Customer with ID: "+ customer.getCustomerId());
		}
		return transfers;

	}

	/**
	 * 
	 * @param customer object
	 * @return list of bill payment of a customer
	 */
	@PostMapping("/check-bills")
	public List<BillPaymentDetail> viewBillPayments(@RequestBody Customerdetail customer) {

		List<BillPaymentDetail> bills = service.viewBillPayments(customer);
		if(bills.isEmpty()) {
			throw new RecordNotFoundException("No Records Founds of Customer with ID: "+ customer.getCustomerId());
		}
		return bills;
	}
}
