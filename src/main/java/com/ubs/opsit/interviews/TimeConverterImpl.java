package com.ubs.opsit.interviews;

public class TimeConverterImpl implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
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
		if (seconds % 2 == 0) {
			result.append("Y");
		} else {
			result.append("O");
		}
		result.append("\r\n");
		// second row to display 5 hours 
		for (int i = 0; i < 4; i++) {
			if (i < noOf5Hours) {
				result.append("R");
			} else {
				result.append("O");
			}
		}
		result.append("\r\n");
		// third row to display hours
		for (int i = 0; i < 4; i++) {
			if (i < noOfHours) {
				result.append("R");
			} else {
				result.append("O");
			}
		}
		result.append("\r\n");
		// fourth row to display 5 minutes
		for (int i = 0; i < 11; i++) {
			if (i < noOf5Minutes) {
				if (i == 2 || i == 5 || i == 8) {
					result.append("R");
				} else {
					result.append("Y");
				}
			} else {
				result.append("O");
			}
		}
		result.append("\r\n");
		// fifth row to display minutes
		for (int i = 0; i < 4; i++) {
			if (i < noOfMinutes) {
				result.append("Y");
			} else {
				result.append("O");
			}
		}

		// System.out.println(result);
		return result.toString();
	}

}
