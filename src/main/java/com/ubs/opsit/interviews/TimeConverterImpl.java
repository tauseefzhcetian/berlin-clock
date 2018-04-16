package com.ubs.opsit.interviews;

public class TimeConverterImpl implements TimeConverter {
	
	
	// Display bits/colors
	private enum Display{
		O,Y,R
	}
	

	@Override
	public String convertTime(String aTime) {
		// Validate time
		validate(aTime);
		
		StringBuilder result = new StringBuilder();

		String[] timeSplitted = aTime.split(":");
		int hour = Integer.parseInt(timeSplitted[0]);
		int minutes = Integer.parseInt(timeSplitted[1]);
		int seconds = Integer.parseInt(timeSplitted[2]);

		int noOf5Hours = hour / 5;
		int noOfHours = hour % 5;
		int noOf5Minutes = minutes / 5;
		int noOfMinutes = minutes % 5;

		// first row to display seconds
		result.append((seconds % 2 == 0)?Display.Y:Display.O);
		result.append("\r\n");
		
		// second row to display 5 hours
		for (int i = 0; i < 4; i++) {
			result.append((i < noOf5Hours)?Display.R:Display.O);
		}
		result.append("\r\n");
		
		// third row to display hours
		for (int i = 0; i < 4; i++) {
			result.append((i < noOfHours)?Display.R:Display.O);
		}
		result.append("\r\n");
		
		// fourth row to display 5 minutes
		for (int i = 0; i < 11; i++) {
			result.append((i < noOf5Minutes)?(i == 2 || i == 5 || i == 8)?Display.R:Display.Y:Display.O);
		}
		result.append("\r\n");
		
		// fifth row to display minutes
		for (int i = 0; i < 4; i++) {
			result.append((i < noOfMinutes)?Display.Y:Display.O);
		}
		return result.toString();
	}

	private void validate(String aTime) {

		if (null == aTime) {
			throw new RuntimeException("Time not provided.");
		}

		String[] timeSplitted = aTime.split(":");

		if (timeSplitted.length != 3) {
			throw new RuntimeException("Time format is wrong.");
		}

		int hours, minutes, seconds = 0;

		try {
			hours = Integer.parseInt(timeSplitted[0]);
			minutes = Integer.parseInt(timeSplitted[1]);
			seconds = Integer.parseInt(timeSplitted[2]);
		} catch (NumberFormatException e) {
			throw new RuntimeException("Time not in numbers");
		}

		if (hours < 0 || hours > 24 || minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59) {
			throw new RuntimeException("Time is out of bound");
		}
	}
}
