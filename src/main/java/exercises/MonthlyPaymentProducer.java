package exercises;

import java.util.ArrayList;
import java.util.List;

public class MonthlyPaymentProducer {
	//Keep track of generated MonthlyPayment
	List<MonthlyPayment> monthlyPaymentList =  new ArrayList<>();

	private LoanInfo loanInfo;
		
	public MonthlyPaymentProducer(LoanInfo loanInfo) {
		super();
		this.loanInfo = loanInfo;
	}

	public List<MonthlyPayment> getMonthlyPaymentList() {
		return monthlyPaymentList;
	}

	public List<MonthlyPayment> generateAllMonthlyPayments() {
		MonthlyPayment firstPayment = createFirstMonthlyPayment();
		generateAllMonthlyFromCurPayments(firstPayment);
		return monthlyPaymentList;
	}
	
	private MonthlyPayment createFirstMonthlyPayment() {
		MonthlyPayment firstMonthlyPayment = 
				new MonthlyPayment(loanInfo, 0, 0 , 0, loanInfo.getAmountBorrowedIncents(), 0, 0);
		monthlyPaymentList.add(firstMonthlyPayment);
		return firstMonthlyPayment;
	}
		
	private void generateAllMonthlyFromCurPayments(
			MonthlyPayment curMonthlyPayment) {
		MonthlyPayment nextMonthlyPayment = curMonthlyPayment.generateNextMonthlyPayment();
		if (nextMonthlyPayment == null) {
			//done			
			return;
		}
		else {
			monthlyPaymentList.add(nextMonthlyPayment); // add all newly created elements to list
			generateAllMonthlyFromCurPayments(nextMonthlyPayment);
		}
	}
			
}
