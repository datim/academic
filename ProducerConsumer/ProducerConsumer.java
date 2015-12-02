
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
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
 * Solution using priority Queue
 */

/**
 * This class implements the countWords() method, which will count the 
 * frequency of words that appear in a string and return a list 
 * of the most frequent words.
 */
public class ProducerConsumer {
	
	/**
	 * Helper class defining a comparator of two Nodes classes, for use 
	 * in priority queue. Comparison will rank nodes with greater counts
	 * as 'less', ensuring that nodes with greater counts are placed
	 * at front of priority queue
	 */
	private class ReverseWordComparitor implements Comparator<Node> {

		@Override
		public int compare(Node arg0, Node arg1) {
			
			if (arg0.count > arg1.count) {
				return -1;
			}
			else if (arg0.count < arg1.count) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	
	/**
	 * helper class containing a word / count pair. Don't enforce encapsulation.
	 */
	private class Node {
		public int count = -1;
		public String word = null;
		
		/* constructor */
		public Node(String inWord, int inCount) {
			word = inWord;
			count = inCount;
		}
	}
	
	/* constructor */
	public ProducerConsumer() {}

	public static void main(String[] args) {

		ProducerConsumer counter = new ProducerConsumer();

		
		String sentence = "One Two Three Four, Show Me Four More Four You.";
		int count = 9;
		
		System.out.println("Input String :'" + sentence + "', count:" + count);
		String[] words = counter.countWords(sentence, count);
		
		String output = "";
		for (String word: words) {
			output += word + " ";
		}
		
		System.out.println("Ordered words are " + output);
	}
	
	/**
	 * Count the frequency of words in a string.
	 * @param sentence: The document, represented as a string. 
	 * @param returnWordCount: The number of the most frequent words to return
	 * @return: List of the most common words, with most common word in the first
	 *         array entry. Return null if invalid input parameters are received
	 */
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
				Integer count = wordFreq.get(word) + 1;
				wordFreq.put(word, count);
				
			} else {
				// new word found, initial count is 1
				wordFreq.put(word, 1);
			}
		}
		
		// Construct a heap from the hashmap sorted so that most frequent words are at the nodes
		// are at the head of the queue
		ReverseWordComparitor rComparator = new ReverseWordComparitor();
		PriorityQueue<Node> sortedWords = new PriorityQueue<>(wordFreq.size(), rComparator);

		// Add items to the heap.  Insertion takes O(n)
		for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
			sortedWords.add(new Node(entry.getKey(), entry.getValue()));
		}
		
		// check if return size is valid for number of words.   If number of words less than return size,
		// adjust return size.
		if (returnWordCount > sortedWords.size()) {
			returnWordCount = sortedWords.size();
			System.out.println("Return words size " + returnWordCount + " too high. Setting to " + sortedWords.size());
		}
		
		// pop off the top number of entries until returnWordCount satisfied
		String[] returnList = new String[returnWordCount];
		
		// add the words to the return list. Worst case is O(n) where returnWordCount equals n.
		for (int i = 0; i < returnList.length; i++) {
			returnList[i] = sortedWords.remove().word;
		}
		
		return returnList;
	}
}
