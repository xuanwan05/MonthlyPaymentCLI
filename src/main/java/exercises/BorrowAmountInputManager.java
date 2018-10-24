package exercises;

import java.io.Console;

public class BorrowAmountInputManager extends InputManager {
	private static final String AMOUNT_PROMPT = "Please enter the amount you would like to borrow: ";

	private static final BorrowAmountInputManager instance = new BorrowAmountInputManager();
	
	private BorrowAmountInputManager() {		
	}
	
	public static final BorrowAmountInputManager getInstance() {
		return instance;
	}

	public final double getBorrowAmount(Console console) {
		double retVal = 0d;

		boolean isInvalidDouble = true; // assume the borrow amount input was wrong
		while (isInvalidDouble) {
			String line = readLine(console, AMOUNT_PROMPT);
			try {
				retVal = Double.parseDouble(line);
				if (!BorrowAmountValidator.isValidBorrowAmount(retVal)) {
					printf(console, getReminder(BorrowAmountValidator.MIN_AMOUNT, BorrowAmountValidator.MAX_AMOUNT));
				} else {
					isInvalidDouble = false;
				}
			} catch (NumberFormatException e) {
				printf(console, getReminder(BorrowAmountValidator.MIN_AMOUNT, BorrowAmountValidator.MAX_AMOUNT));
			}
		}
		return retVal;
	}

}
