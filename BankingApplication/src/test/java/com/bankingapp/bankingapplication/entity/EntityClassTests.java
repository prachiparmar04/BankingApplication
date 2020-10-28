package com.bankingapp.bankingapplication.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
 class EntityClassTests {
/**
 * Testing CustomerDetail Model Class
 */
	@Test
	void CustomerdetailsTests() {
		Customerdetail actual = new Customerdetail(2, "prachi", "02/03/2019", "11/11/2020");
		Customerdetail expected = new Customerdetail();
		expected.setCustomerId(2);
		expected.setFromDate("02/03/2019");
		expected.setToDate("11/11/2020");
		expected.setName("prachi");
		assertEquals(expected.getCustomerId(), actual.getCustomerId());

	}
	/**
	 * Testing AccountDetails Model Class
	 */
	@Test
	void AccountsTests() {
		BankAccountDetail actual = new BankAccountDetail(2, 1111111111L, 3000L, 1000L);
		BankAccountDetail expected = new BankAccountDetail();
		expected.setCustomerId(2);
		expected.setAccNumber(1111111111L);
		expected.setAvailableBalance(3000L);
		expected.setLedgerBalance(1000L);
		assertEquals(expected.getCustomerId(), actual.getCustomerId());

	}
	/**
	 * Testing FundTransfer Model Class
	 */
	@Test
	void FundTransferTest() {
		FundTransferDetail actual = new FundTransferDetail(2, 33L, 1511111651L, 1511111333L, 4655L, "03/04/2020");
		FundTransferDetail expected = new FundTransferDetail();
		expected.setCustomerId(2);
		expected.setRecieverAccNumber(33L);
		expected.setSenderAccNumber(1511111651L);
		expected.setTranferedAmount(1511111333L);
		expected.setTransactionId(4655L);
		expected.setTransactionDate("03/04/2020");
		assertEquals(expected.getCustomerId(), actual.getCustomerId());

	}
	/**
	 * Testing BillPayment Model Class
	 */
	@Test
	void BillPaymentTest() {
		BillPaymentDetail actual = new BillPaymentDetail("BillPaymentDetail", 1511111651L, 1, "Reliance LTD", 2445L,
				"07/04/2019");
		BillPaymentDetail expected = new BillPaymentDetail();
		expected.setBillType("BillPaymentDetail");
		expected.setConsumerId(1);
		expected.setRecieverCompany("Reliance LTD");
		expected.setSenderAccNumber(1511111651L);
		expected.setTransactionAmount(2445L);
		expected.setTransactionDate("07/04/2019");
		assertEquals(expected.getConsumerId(), actual.getConsumerId());

	}
}
