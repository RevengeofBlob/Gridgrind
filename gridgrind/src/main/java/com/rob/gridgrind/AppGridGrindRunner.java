package com.rob.gridgrind;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

/**
 * App Runner for Grid Grind
 * 
 * @author Ryan Baker
 *
 */
public class AppGridGrindRunner {
	public static void main(String[] args) {

		/*
		 * Read properties from file
		 * 
		 * @see http://tutorials.jenkov.com/java-collections/properties.html
		 */
		Properties prop = new Properties();
		
		try (FileReader fileReader = new FileReader(args[0])) {
			prop.load(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Set row and col to property value.
		int row = Integer.parseInt(prop.getProperty("row"));
		int col = Integer.parseInt(prop.getProperty("col"));

		// Store and print out the grid of numbers
		String sPrint = getGrid(col, row);
		System.out.println(sPrint);

	}

	public static String getGrid(int rowCount, int colCount) {

		// Validate row count
		if (rowCount <= 0) {
			throw new RuntimeException("You done goofed. Your rows must be greater than 0. You entered: " + rowCount);
		}

		// Validate column count
		if (colCount <= 0) {
			throw new RuntimeException(
					"You done goofed. Your columns must be greater than 0. You entered: " + colCount);
		}
		
		/*
		 * Generate a random number from 0-9 (inclusive)
		 * 
		 * @see https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
		 */
		Random r = new Random();
		int low = 0;
		int high = 10;
		
		//Validate random range
		if(low > high) {
			throw new RuntimeException(
					"You done goofed. The high value must be greater than the low value. You entered: " + low + " for low and " + high + " for high.");
		}
		
		// Build grid
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < colCount; i++) {
			for (int j = 0; j < rowCount; j++) {
				int result = r.nextInt(high-low) + low;
				sb.append(result);
			}
			sb.append(System.getProperty("line.separator"));
		}

		// Result
		return sb.toString();
	}
}
