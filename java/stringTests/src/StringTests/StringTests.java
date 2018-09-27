package StringTests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringTests {

	public static void main(String[] args) {
		
		StringTests stringTests = new StringTests();
		
		// find non-repeating string
		stringTests.findNonRepeatingChar("abcab");
		stringTests.findNonRepeatingChar("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaab");
		stringTests.findNonRepeatingChar("afafafaafafafafad");
		stringTests.findNonRepeatingChar("afdaslfjsadfasdfsadfasldfkjlkjzlkjlkjafalkjlkjeaflfkjalkj");
		
		// test all combinations of a string
		stringTests.findAllCombinationsOfAString("abc");

	}
	
	/**
	 * Given an array of characters, write a function to print all possible combinations. 
	 * For example given a,b,c, print abc, acb, bac, bca, cab, cba. Characters can repeat.
	 * @param sample
	 * @param length
	 */
	public void findAllCombinationsOfAString(String stringToCheck) {
		

		// recursive solution.  For each character in the string:
		// 1) If substring greater than two:
		//     1a) for each character in string, call step 1 with substring minus that character. For
		//         combination of string results, then append character to each string
		// 2) If substring is two, return both combinations, e.g. 'ab' and 'ba'

		List<String> results = getSubStrings( stringToCheck, stringToCheck.length());
		
		// report results
		System.out.println(results.size() + " combinations of characters for string " + stringToCheck + ":");
		for (String result: results ) {
			System.out.println(" -> " + result);
		}
	}
	
	private List<String> getSubStrings(String stringToCheck, int length) {
		
		// to store the string combos
		List<String> stringCombos = new ArrayList<>();
		
		if (length == 1) {			
			// there is only one combination. The character itself
			stringCombos.add(stringToCheck);

		} else {
			// For each character in the array, find all permuations of the 
			// substring.  Add the character to the beginning of the list
		
			// loop through every character in the string
			for (int i = 0; i < length; i++) {
				String mySubString = stringToCheck.substring(0, i) + stringToCheck.substring(i+1, length);

				List<String> foundSubStrings = getSubStrings(mySubString, length - 1);
				
				for (String sub: foundSubStrings) {
					// prepend the character at index i to all sub strings
					stringCombos.add(stringToCheck.charAt(i) + sub);
				}
			}
		}
		
		return stringCombos;
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
