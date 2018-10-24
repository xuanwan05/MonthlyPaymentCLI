package exercises;

public class BorrowAmountValidator {

	static final double MIN_AMOUNT = 0.01d;
	static final double MAX_AMOUNT = 1000000000000d;

	public static boolean isValidBorrowAmount(double amount) {
		return MIN_AMOUNT <= amount && amount <= MAX_AMOUNT;
	}

	public static String getBorrowAmountReminder() {
		StringBuilder sb = new StringBuilder();
		sb.append("Please enter a positive value between ");
		sb.append(MIN_AMOUNT);
		sb.append(" and ");
		sb.append(MAX_AMOUNT);
		sb.append(". ");

		return sb.toString();
	}

}
