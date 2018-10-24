package exercises;

import java.io.Console;
import java.util.IllegalFormatException;

public class PrintFormat {
	public void print(String s) {
		printf(null, "%s", s);
	}

	public void printf(Console console, String formatString, Object... args) {
		try {
			if (console != null) {
				console.printf(formatString, args);
			} else {
				System.out.print(String.format(formatString, args));
			}
		} catch (IllegalFormatException e) {
			System.err.print("Error printing...\n");
		}
	}
}
