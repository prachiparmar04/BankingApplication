package com.bankingapp.bankingapplication.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bankingapp.bankingapplication.entity.BankAccountDetail;
import com.bankingapp.bankingapplication.entity.BillPaymentDetail;
import com.bankingapp.bankingapplication.entity.Customerdetail;
import com.bankingapp.bankingapplication.entity.FundTransferDetail;


/**
 * 
 * @author PRACHI PARMAR
 *
 */
@Service
public class BankingService {

	/**
	 * static list of bank accounts of different customer static list of fund
	 * transfer of different customer static list of bill payments of different
	 * customer
	 */
	private static List<BankAccountDetail> bankAccounts = new ArrayList<>();
	private static List<FundTransferDetail> funds = new ArrayList<>();
	private static List<BillPaymentDetail> payments = new ArrayList<>();

	static {
		bankAccounts.add(new BankAccountDetail(45, 1111111111L, 3000L, 1000L));
		bankAccounts.add(new BankAccountDetail(3, 1511111651L, 6000L, 2000L));
		bankAccounts.add(new BankAccountDetail(1, 1911661111L, 9000L, 3000L));
		bankAccounts.add(new BankAccountDetail(2, 1111111111L, 3000L, 1000L));
		bankAccounts.add(new BankAccountDetail(4, 1511911651L, 7000L, 2000L));
		bankAccounts.add(new BankAccountDetail(1, 1911661111L, 8000L, 3000L));

		funds.add(new FundTransferDetail(2, 33L, 1511111651L, 1511111333L, 4655L, "03/04/2020"));
		funds.add(new FundTransferDetail(1, 34L, 1511111651L, 1511111333L, 4655L, "03/04/2022"));
		funds.add(new FundTransferDetail(33, 35L, 1511111651L, 1511111333L, 4655L, "03/04/2018"));
		funds.add(new FundTransferDetail(12, 63L, 1511111651L, 1511111333L, 4655L, "03/04/2019"));
		funds.add(new FundTransferDetail(2, 36L, 1511111651L, 1511111333L, 4655L, "03/06/2019"));
		funds.add(new FundTransferDetail(4, 83L, 1511111651L, 1511111333L, 4655L, "08/04/2019"));

		payments.add(new BillPaymentDetail("Electricity Bill", 1511111651L, 1, "Reliance LTD", 2445L, "23/04/2019"));
		payments.add(new BillPaymentDetail("DTH Bill", 1511111651L, 2, "Airtel", 275L, "02/04/2020"));
		payments.add(new BillPaymentDetail("Recharge Bill", 1511111651L, 2, "Jio", 445L, "07/04/2020"));
		payments.add(new BillPaymentDetail("Water Bill", 1511111651L, 2, "MBDC", 245L, "04/04/2019"));
		payments.add(new BillPaymentDetail("Gas Bill", 1511111651L, 4, "ONGC", 245L, "01/04/2019"));
		payments.add(new BillPaymentDetail("Recharge Bill", 1511111651L, 4, "Idea", 244L, "08/07/2019"));
	}
	
	/**
	 * 
	 * @param Customer id
	 * @return bank accounts for a customer
	 */
	public List<BankAccountDetail> viewBankAccounts(int id) {

		List<BankAccountDetail> accounts = new ArrayList<>();

		for (BankAccountDetail account : bankAccounts) {
			if (account.getCustomerId() == id) {
				accounts.add(account);
			}

		}
		
		return accounts;

	}

	/**
	 * 
	 * @param account : CustomerDetails Object
	 * @return list of fund transfer between the start date and end date of a
	 *         customer
	 */
	public List<FundTransferDetail> viewFundTransfers(Customerdetail account) {

		List<FundTransferDetail> transfers = new ArrayList<>();

		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date date1 = date.parse(account.getFromDate());
			Date date2 = date.parse(account.getToDate());
			for (FundTransferDetail fund : funds) {

				Date transferDate = date.parse(fund.getTransactionDate());

				if (transferDate.after(date1) && transferDate.before(date2)
						&& account.getCustomerId() == fund.getCustomerId()) {

					transfers.add(fund);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return transfers;

	}

	/**
	 * 
	 * @param account : CustomerDetails Object
	 * @return list of bill payment between the start date and end date of a
	 *         customer
	 */
	public List<BillPaymentDetail> viewBillPayments(Customerdetail account) {

		List<BillPaymentDetail> bills = new ArrayList<>();
		

		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date date1 = date.parse(account.getFromDate());
			Date date2 = date.parse(account.getToDate());

			for (BillPaymentDetail bill : payments) {

				Date billDate = date.parse(bill.getTransactionDate());

				if (billDate.after(date1) && billDate.before(date2)
						&& account.getCustomerId() == bill.getConsumerId()) {

					bills.add(bill);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return bills;

	}
}
