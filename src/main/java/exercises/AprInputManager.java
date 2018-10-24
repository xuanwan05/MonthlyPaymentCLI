package exercises;

import java.io.Console;

public class AprInputManager extends InputManager {
	private static final String APR_PROMPT = "Please enter the annual percentage rate used to repay the loan:";

	private static final AprInputManager instance = new AprInputManager();
	
	private AprInputManager() {		
	}
	
	public static final AprInputManager getInstance() {
		return instance;
	}
	
	public final double getApr(Console console) {
		double retVal = 0d;

		boolean isInvalidDouble = true; // assume the borrow amount input was wrong
		while (isInvalidDouble) {
			String line = readLine(console, APR_PROMPT);
			try {
				retVal = Double.parseDouble(line);
				if (!AprValidator.isValidAPRValue(retVal)) {
					printf(console, getReminder(AprValidator.MIN_ANNUAL_PERCENTAGE_RATE,
							AprValidator.MAX_ANNUAL_PERCENTAGE_RATE));
				} else {
					isInvalidDouble = false;
				}
			} catch (NumberFormatException e) {
				printf(console,	getReminder(AprValidator.MIN_ANNUAL_PERCENTAGE_RATE, 
								AprValidator.MAX_ANNUAL_PERCENTAGE_RATE));
			}
		}
		return retVal;
	}

}
