package bignumbers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Add, Subtract, Multiply, and Divide big numbers
 *
 */
public class BigNumbers {
	
	// the maximum value of a single byte
	final int MAX_ONE_BYTE = 0xFF;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BigNumbers numbers = new BigNumbers();
		
		numbers.performAddition("test\number1.txt", "test\number2.txt", "additionResult.txt");

		
	}
	
	/**
	 * Problem: Add two very large numbers together.  Each number will be read from a 
	 * file a byte at a time, and can be any length.  Save the result to a file
	 * @throws FileNotFoundException 
	 */
	private void performAddition(String fileNameNumberOne, String fileNameNumberTwo, 
								 String resultFileName) {
		
		// initialize the reading of two files.  Pass the file streams to 
		// the addition function.  Save the result in a file
		
		// open the file streams for the two numbers, and the result
		FileOutputStream fileResult;
		FileInputStream fileInputOne;
		FileInputStream fileInputTwo;
		
		try {
			fileInputOne = new FileInputStream(fileNameNumberOne);
			fileInputTwo = new FileInputStream(fileNameNumberTwo);
			fileResult = new FileOutputStream(resultFileName);
			
			// perform addition on two file streams
			add(fileInputOne, fileInputTwo, fileResult);
			
			// close the files
			fileInputOne.close();
			fileInputTwo.close();
			fileResult.close();
			
		} catch (IOException e) {
			System.out.println("Unable to add two bytes for addition.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Perform addition on two numbers of unknown length by adding the results byte by byte.
	 * Save the results to the result file stream
	 * @throws IOException 
	 */
	private void add(final FileInputStream numberOneStream, 
					 final FileInputStream numberTwoStream, 
					 final FileOutputStream result) throws IOException {
		
		// each number is an array of one byte
		byte[] numberOne = new byte[1];
		byte[] numberTwo = new byte[1];
		Boolean carryBit = false;
		
		while (true) {
			
			int numberOneAvailable = numberOneStream.read(numberOne);
			int numberTwoAvailable = numberTwoStream.read(numberTwo);

			if (numberOneAvailable != -1 && numberTwoAvailable != -1) {
				// both numbers are available. Add them
				
				int addResult = numberOne[0] + numberTwo[0];
				
				if (carryBit == true) {
					// add the carry bit from the previous byte addition
					addResult += 0x01;
				}
				
				if (addResult > MAX_ONE_BYTE) {
					carryBit = true; // carry
					
				} else {
					carryBit = false;	// no carry
				}
				
				// save the byte to file
				byte addResultByte = (byte) addResult;
				
				result.write(addResultByte);
			}
		}
	}

}
