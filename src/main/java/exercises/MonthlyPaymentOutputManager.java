package exercises;

import java.io.Console;
import java.util.List;

public class MonthlyPaymentOutputManager extends PrintFormat {
	private LoanInfo loanInfo;

	private static final String FORMAT_STRING = "%1$-20s%2$-20s%3$-20s%4$s,%5$s,%6$s\n";
	// printf(formatString, "PaymentNumber", "PaymentAmount", "PaymentInterest",
	// "CurrentBalance", "TotalPayments",
	// "TotalInterestPaid");

	MonthlyPaymentOutputManager(LoanInfo loanInfo) {
		super();
		this.loanInfo = loanInfo;
	}

	public void printAllMonthlyPayments(Console console) {
		MonthlyPaymentProducer producer = new MonthlyPaymentProducer(loanInfo);
		List<MonthlyPayment> monthlyPaymentFullList = producer.generateAllMonthlyPayments();

		printHeader(console);
		printMonthlyPaymentList(console, monthlyPaymentFullList);
	}

	void printHeader(Console console) {
		printf(console, FORMAT_STRING, "PaymentNumber", "PaymentAmount", "PaymentInterest", "CurrentBalance",
				"TotalPayments", "TotalInterestPaid");
	}

	void printMonthlyPaymentList(Console console, List<MonthlyPayment> aMonthlyPaymentFullList) {
		// may be able to use stream to print info
		// make it work for now

		for (MonthlyPayment monthlyPayment : aMonthlyPaymentFullList) {
			printMonthlyPayment(console, monthlyPayment);
		}
	}

	void printMonthlyPayment(Console console, MonthlyPayment aMonthlyPayment) {
		printf(console, FORMAT_STRING, aMonthlyPayment.getPaymentNumber(),
				((double) aMonthlyPayment.getCurMonthlyPaymentAmountIncents()) / 100d,
				((double) aMonthlyPayment.getCurMonthlyInterestIncents()) / 100d,
				((double) aMonthlyPayment.getCurBalanceIncents()) / 100d,
				((double) aMonthlyPayment.getTotalPaymentsIncents()) / 100d,
				((double) aMonthlyPayment.getTotalInterestPaidIncents()) / 100d);
	}

}
