package com.bankingapp.bankingapplication.entity;

import javax.persistence.Id;
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
public class Customerdetail {
	/**
	 * ID of Customer
	 */
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	private String name;
	/**
	 * Start Date of details required by customer
	 */
	
	private String fromDate;
	/**
	 * End date, up to which details are required by the customer
	 */
	
	private String  toDate;
	
	
	
}
