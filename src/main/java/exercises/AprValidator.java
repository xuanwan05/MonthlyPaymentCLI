package exercises;

public class AprValidator {

	static final double MIN_ANNUAL_PERCENTAGE_RATE = 0.000001d;
	static final double MAX_ANNUAL_PERCENTAGE_RATE = 100d;

	public static boolean isValidAPRValue(double rate) {
		return MIN_ANNUAL_PERCENTAGE_RATE <= rate && rate <= MAX_ANNUAL_PERCENTAGE_RATE;
	}

}
