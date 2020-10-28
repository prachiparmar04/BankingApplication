package com.bankingapp.bankingapplication.entity;


import javax.persistence.Id;
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
public class BillPaymentDetail {
	/**
	 * Type of bill Payment , eg : electricity, dth, etc
	 */
private String billType;
/**
 * Account Number of the Sender
 */
@Size(min = 10,max = 12)
private Long senderAccNumber;
/**
 * ConsumerId is the Customer Id of a Customer
 */
@Id
private int consumerId;
/**
 * Receiver company of the bill, eg Reliance,airtel,etc
 */
private String recieverCompany;
/**
 * Amount of the bill
 */
private Long transactionAmount;
/*
 * date of transaction of the bill
 */
private String transactionDate;
}
