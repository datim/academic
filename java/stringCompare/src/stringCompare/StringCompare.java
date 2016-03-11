package stringCompare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class StringCompare {

	public static void main(String[] args) {
		
		StringCompare stringTests = new StringCompare();
		
		stringTests.runAllTests("abcab");
		stringTests.runAllTests("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaab");
		stringTests.runAllTests("afafafaafafafafad");
		stringTests.runAllTests("afdaslfjsadfasdfsadfasldfkjlkjzlkjlkjafalkjlkjeaflfkjalkj");
	}
	
	/**
	 * Run all tests on a string
	 * @param stringToCheck
	 */
	public void runAllTests(String stringToCheck) {
		
		findAllCombinationsOfAString(stringToCheck);
		findNonRepeatingChar(stringToCheck);
	}
	
	/**
	 * Given an array of characters, write a function to print all possible combinations.  
	 * For example given a,b,c, print
	 * @param sample
	 * @param length
	 */
	public void findAllCombinationsOfAString(String stringToCheck) {
		
		List<String> combinations = new ArrayList<>();
		
		for (char charToCheck: stringToCheck.toCharArray()) {
			
		}
		
	}
	
	/**
	 * given a stream of characters that start at some time and stop, find the first character in the stream that occurred only once.  
	 * for example if the stream is 'abcacbed' the first character that occurred only once is e
	 * 
	 * Iterate over the array twice.     Efficiency is O(n) + O(n) = O(n)
	 * @param stringToCheck
	 * @param length
	 */
	private void findNonRepeatingChar(String stringToCheck) {
		
		// map to keep track of the counts we've found for each character
		final HashMap<Character, Integer> foundCharacters = new HashMap<>();
				
		for (char charToCheck: stringToCheck.toCharArray())
		
			if (foundCharacters.containsKey(charToCheck)) {
				
				// this is the first repeating character that we've found
				Integer count = foundCharacters.get(charToCheck) + 1;
				
				foundCharacters.put(charToCheck, count);
								
			} else {
				// add this character and move on
				foundCharacters.put(charToCheck, 1);
			}
	
		// now go through the string again in order to find the string
		for (char charToCheck: stringToCheck.toCharArray()) {
			
			if (foundCharacters.get(charToCheck) == 1) {
				System.out.println("First non-repeating character is " + charToCheck + " for string " + stringToCheck);
				return;
			}
		}
	}
}
