package exercises;

public class TermValidator {
	static final int MIN_TERM_IN_YEAR = 1;
	static final int MAX_TERM_IN_YEAR = 1000000;

	public static boolean isValidTerm(int years) {
		return MIN_TERM_IN_YEAR <= years && years <= MAX_TERM_IN_YEAR;
	}

}
