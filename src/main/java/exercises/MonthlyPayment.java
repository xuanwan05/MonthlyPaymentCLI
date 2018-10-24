package exercises;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MonthlyPayment {
	@JsonIgnore
	private LoanInfo loanInfo;

	private int paymentNumber;
	private long curMonthlyPaymentAmountIncents;
	private long curMonthlyInterestIncents;
	private long curBalanceIncents;
	private long totalPaymentsIncents;
	private long totalInterestPaidIncents;

	public MonthlyPayment() {
	}

	public MonthlyPayment(LoanInfo loanInfo) {
		super();
		this.loanInfo = loanInfo;
	}

	public MonthlyPayment(LoanInfo loanInfo, int paymentNumber, long curMonthlyPaymentAmountIncents,
			long curMonthlyInterestIncents, long curBalanceIncents, long totalPaymentsIncents,
			long totalInterestPaidIncents) {
		super();
		this.loanInfo = loanInfo;
		this.paymentNumber = paymentNumber;
		this.curMonthlyPaymentAmountIncents = curMonthlyPaymentAmountIncents;
		this.curMonthlyInterestIncents = curMonthlyInterestIncents;
		this.curBalanceIncents = curBalanceIncents;
		this.totalPaymentsIncents = totalPaymentsIncents;
		this.totalInterestPaidIncents = totalInterestPaidIncents;
	}

	public LoanInfo getLoanInfo() {
		return loanInfo;
	}

	public void setLoanInfo(LoanInfo loanInfo) {
		this.loanInfo = loanInfo;
	}

	public int getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public long getCurMonthlyPaymentAmountIncents() {
		return curMonthlyPaymentAmountIncents;
	}

	public void setCurMonthlyPaymentAmountIncents(long curMonthlyPaymentAmountIncents) {
		this.curMonthlyPaymentAmountIncents = curMonthlyPaymentAmountIncents;
	}

	public long getCurMonthlyInterestIncents() {
		return curMonthlyInterestIncents;
	}

	public void setCurMonthlyInterestIncents(long curMonthlyInterestIncents) {
		this.curMonthlyInterestIncents = curMonthlyInterestIncents;
	}

	public long getCurBalanceIncents() {
		return curBalanceIncents;
	}

	public void setCurBalanceIncents(long curBalanceIncents) {
		this.curBalanceIncents = curBalanceIncents;
	}

	public long getTotalPaymentsIncents() {
		return totalPaymentsIncents;
	}

	public void setTotalPaymentsIncents(long totalPaymentsIncents) {
		this.totalPaymentsIncents = totalPaymentsIncents;
	}

	public long getTotalInterestPaidIncents() {
		return totalInterestPaidIncents;
	}

	public void setTotalInterestPaidIncents(long totalInterestPaidIncents) {
		this.totalInterestPaidIncents = totalInterestPaidIncents;
	}

	public MonthlyPayment generateNextMonthlyPayment() {

		if (curBalanceIncents <= 0) {
			return null; // no balance, then done.
		}
		if (paymentNumber > loanInfo.getInitialTermMonths()) {
			return null; // paymentNumber can not be bigger than the number of term months.
		}

		long curMonthlyInterest = Math.round(((double) curBalanceIncents) * loanInfo.getMonthlyInterest());

		// the amount required to payoff the loan
		long curPayoffAmount = curBalanceIncents + curMonthlyInterest;
		// the amount to payoff the remaining balance may be less than the
		// calculated monthlyPaymentAmount

		long curMonthlyPaymentAmount = Math.min(loanInfo.getMonthlyPaymentAmountIncents(),
				curPayoffAmount);

		// it's possible that the calculated monthlyPaymentAmount is 0,
		// or the monthly payment only covers the interest payment - i.e. no
		// principal
		// so the last payment needs to payoff the loan
		if ((paymentNumber == loanInfo.getInitialTermMonths() - 1) &&
				((curMonthlyPaymentAmount == 0) || (curMonthlyPaymentAmount == curMonthlyInterest))) {
			curMonthlyPaymentAmount = curPayoffAmount;
		}
		// Calculate C = M - H, this is your monthly payment minus your monthly
		// interest,
		// so it is the amount of principal you pay for that month
		long curMonthlyPrincipalPaid = curMonthlyPaymentAmount - curMonthlyInterest;

		// Calculate Q = P - C, this is the new balance of your principal of
		// your loan.

		long newBalance = curBalanceIncents - curMonthlyPrincipalPaid;
		long newTotalPaymentsIncents = totalPaymentsIncents + curMonthlyPaymentAmount;
		long newTotalInterestPaidIncents = totalInterestPaidIncents + curMonthlyInterest;

		return new MonthlyPayment(loanInfo, paymentNumber + 1, curMonthlyPaymentAmount, 
				curMonthlyInterest, newBalance,
				newTotalPaymentsIncents, newTotalInterestPaidIncents);
	}
	
	

}
