package exercises;

import java.io.Console;

public class TermInputManager extends InputManager{
	private static final String TERM_PROMPT = "Please enter the term, in years, over which the loan is repaid:";

	private static final TermInputManager instance = new TermInputManager();
	
	private TermInputManager() {		
	}
	
	public static final TermInputManager getInstance() {
		return instance;
	}

	
	public final int getTerm(Console console) {
		int retVal = 0;
		
		boolean isInvalidTerm = true; // assume the term input was wrong
		while (isInvalidTerm) {
			String line = readLine(console, TERM_PROMPT);
			try {
				retVal = Integer.parseInt(line);
				if ( !TermValidator.isValidTerm(retVal)) {
					printf(console, getReminder(TermValidator.MIN_TERM_IN_YEAR, TermValidator.MAX_TERM_IN_YEAR));					
				} else {
					isInvalidTerm = false;
				}
				
			}catch(NumberFormatException e) {
				//input not in right format, loop back
				printf(console, getReminder(TermValidator.MIN_TERM_IN_YEAR, TermValidator.MAX_TERM_IN_YEAR));					
			}
			
		}
		return retVal;
	}
	
}
