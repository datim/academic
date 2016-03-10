package wordFrequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Problem Statement:
 * Write a function that takes two parameters: (1) a 
 * String representing a text document and (2) an integer 
 * providing the number of items to return. Implement the 
 * function such that it returns a list of Strings ordered 
 * by word frequency, the most frequently occurring word first.  
 * Use your best judgment to decide how words are separated. 
 * Your solution should run in O(n) time where n is the number of 
 * characters in the document. Implement this function as you would 
 * for a production/commercial system. You may use any standard data structures.
 * 
 * Solution using a sorted list
 */

public class WordFrequency {
	
	private class MapComparator implements Comparator<Map.Entry<String, Integer>> {
		
		// Define comparator that compares map entries by value
		@Override
		public int compare(Map.Entry<String, Integer> a1, Map.Entry<String, Integer> a2) {
			return a1.getValue().compareTo(a2.getValue());
		}
	}
	
	public WordFrequency() {}

	public static void main(String[] args) {

		WordFrequency wordFreq = new WordFrequency();

		
		String sentence = "One Two Three Four, Show Me Four More Four You.";
		int count = 9;
		
		System.out.println("Input: " + sentence);
		String[] result = wordFreq.countWords(sentence, count);
		
		String freqString = "";
		for (String freq: result) {
			freqString += freq + " ";
		}
		System.out.println("Word Frequency: " + freqString);

		
		WordCount counter = new WordCount();
		result = counter.countWords(sentence, count);
		
		String wordCount = "";
		for (String myCount: result) {
			wordCount += myCount + " ";
		}
		
		System.out.println("Word Count: " + wordCount);
	}
	
	String[] countWords(String sentence, int returnWordCount) {
		
		// check input parameter
		if (sentence == null || sentence.isEmpty()) {
			System.out.println("Sentence not defined");
			return null;
		}
		
		// check input parameter
		if (returnWordCount <= 0) {
			System.out.println("Return Words must be greater than zero");
			return null;
		}

		// store count for each word discovered, indexed by word
		HashMap<String, Integer> wordFreq = new HashMap<>();
		
		// remove all characters that are not spaces, letters, or digits
		final String regex = "[^a-zA-Z\\d\\ ]";
		sentence = sentence.replaceAll(regex, "");
		
		// parse string by space
		StringTokenizer token = new StringTokenizer(sentence); 
		
		// count the word frequency in the sentence.  This operation is O(n)
		while (token.hasMoreElements()) {
			String word = (String) token.nextElement();
			
			if (wordFreq.containsKey(word)) {
				// existing word found. Increment word count
				wordFreq.put(word,  wordFreq.get(word) + 1);
			} else {
				// new word found, initial count is 1
				wordFreq.put(word, 1);
			}
		}
		
		// convert map to a list
		ArrayList<Map.Entry<String, Integer>> wordFreqList = new ArrayList<>(wordFreq.entrySet());
		
		// sort the list and reverse it so that the greatest counts are in the front
		MapComparator myComparator = new MapComparator();
		Collections.sort(wordFreqList, myComparator);
		Collections.reverse(wordFreqList);

		// adjust return size so that our return list is no bigger than the number of words
		if (returnWordCount > wordFreqList.size()) {
			returnWordCount = wordFreqList.size();
		}
		
		// copy results into return list
		int index = 0;
		String [] returnList = new String[returnWordCount];
		
		for (Map.Entry<String, Integer> x : wordFreqList) {
			
			returnList[index++] = x.getKey();
			
			// break if we reach end of list
			if (index >= returnWordCount) {
				break;
			}
		}
		
		return returnList;
	}

}
