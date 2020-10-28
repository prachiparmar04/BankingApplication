package com.bankingapp.bankingapplication.entity;

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
public class FundTransferDetail {
	/**
	 * Customer Id of a Customer
	 */
	private int customerId;

	/**
	 * Transaction id of a transaction
	 */
	private Long transactionId;

	/**
	 * Senders Account Number of a fund transfer
	 */
	@Size(min = 10, max = 12)
	private Long senderAccNumber;

	/**
	 * Receiver Account Number of a fund transfer
	 */
	@Size(min = 10, max = 12)
	private Long recieverAccNumber;

	/**
	 * amount of the Transfer
	 */
	private Long tranferedAmount;

	/**
	 * Transaction date of the transfer
	 */
	private String transactionDate;

}
