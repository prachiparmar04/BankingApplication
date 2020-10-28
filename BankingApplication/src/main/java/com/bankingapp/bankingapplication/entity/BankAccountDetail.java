package com.bankingapp.bankingapplication.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author PRACHI PARMAR
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDetail {
	/*8
	 * Customer id of the customer
	 */
	
	@NotNull
	private int customerId;
	/**
	 * Account number of a customer 
	 */
	@Size(min = 10, max = 12)
	private Long accNumber;
	/**
	 * Available balance in the account of the customer
	 */
@NotNull
	private Long availableBalance ;
/**
 * ledger balance in the account of the customer
 */
	@NotNull
	private Long ledgerBalance;

}
