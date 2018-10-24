package exercises;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IllegalFormatException;

public class InputManager extends PrintFormat {
	String readLine(Console console, String userPrompt) {
		String line = "";
		try {
			if (console != null) {
				line = console.readLine(userPrompt);
			} else {
				// print("console is null\n");
				BufferedReader bufferedReader = new BufferedReader(new

				InputStreamReader(System.in));
				print(userPrompt);
				line = bufferedReader.readLine();
			}
			line.trim();
		} catch (IOException e) {
			throw new RuntimeException("IO exception. This should rarely or never happen."
					+ " Program needs to be terminated if it ever does.", e);
		}
		return line;
	}
	
	String getReminder(Number min, Number max) {
		StringBuilder sb = new StringBuilder();
		sb.append("Please enter a positive value between ");
		sb.append(min);
		sb.append(" and ");
		sb.append(max);
		sb.append(". ");
		sb.append(System.lineSeparator()); //Added a line separator for better read

		return sb.toString();
	}


}
