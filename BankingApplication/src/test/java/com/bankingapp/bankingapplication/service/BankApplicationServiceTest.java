package com.bankingapp.bankingapplication.service;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import com.bankingapp.bankingapplication.entity.BankAccountDetail;
import com.bankingapp.bankingapplication.entity.BillPaymentDetail;
import com.bankingapp.bankingapplication.entity.Customerdetail;
import com.bankingapp.bankingapplication.entity.FundTransferDetail;

@ExtendWith(MockitoExtension.class)
class BankApplicationServiceTest {
	@InjectMocks
	BankingService service;

	@Test
	void testViewBankAccounts() {
		List<BankAccountDetail> actual = new ArrayList<>();
		actual.add(new BankAccountDetail(2, 1111111111L, 3000L, 1000L));
		List<BankAccountDetail> expected = service.viewBankAccounts(2);

		System.out.println(expected.size() + "    " + actual.size());
		assertEquals(expected.get(0).getAccNumber(), actual.get(0).getAccNumber());
		assertEquals(expected.get(0).getAvailableBalance(), actual.get(0).getAvailableBalance());
		assertEquals(expected.get(0).getLedgerBalance(), actual.get(0).getLedgerBalance());
	}

	@Test
	void testViewFundTransfers() {
		List<FundTransferDetail> actual = new ArrayList<>();
		Customerdetail customer = new Customerdetail(2, "prachi", "02/03/2019", "11/11/2020");
		actual.add(new FundTransferDetail(2, 33L, 1511111651L, 1511111333L, 4655L, "03/04/2020"));
		actual.add(new FundTransferDetail(2, 36L, 1511111651L, 1511111333L, 4655L, "03/06/2019"));
		List<FundTransferDetail> expected = service.viewFundTransfers(customer);
		assertEquals(expected.size(), actual.size());
	}

	@Test
	void testNotViewFundTransfers() {
		List<FundTransferDetail> actual = new ArrayList<>();
		Customerdetail customer = new Customerdetail(22, "prachi", "0203/2019", "1111/2020");
		// actual.add(new
		// FundTransferDetail(2,33L,1511111651L,1511111333L,4655L,"03042020"));
		List<BillPaymentDetail> expected = service.viewBillPayments(customer);
		assertNotNull(actual);
		assertNotNull(expected);

	}

	@Test
	void testViewBillPayments() {
		List<BillPaymentDetail> actual = new ArrayList<>();
		Customerdetail customer = new Customerdetail(1, "prachi", "02/03/2019", "11/11/2020");
		actual.add(new BillPaymentDetail("Electricity Bill", 1511111651L, 1, "Reliance LTD", 2445L, "07/04/2019"));

		List<BillPaymentDetail> expected = service.viewBillPayments(customer);
		assertEquals(expected.size(), actual.size());
	}

	@Test
	void testnotViewBillPayments() {
		List<BillPaymentDetail> actual = new ArrayList<>();
		Customerdetail customer = new Customerdetail(11, "prachi", "02/03/2019", "1111/2020");

		List<BillPaymentDetail> expected = service.viewBillPayments(customer);
		assertNotNull(actual);
		assertNotNull(expected);
	}

}
