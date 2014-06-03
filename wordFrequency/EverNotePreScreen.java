
public class EverNotePreScreen {
	
	WordFreq counter = null;
		
	/**
	 * constructor
	 */
	EverNotePreScreen() {
		counter = new WordFreq();
		
	}

	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		EverNotePreScreen enps = new EverNotePreScreen();
		enps.run();
	}
	
	/**
	 * Run different tests 
	 */
	void run() {
		
		String sentence = "One Two Three Four, Show Me Four More Four You.";
		
		runTest(sentence, 5);
		runTest(sentence, 9);
	}
	
	/*
	 * Run the tests
	 */
	void runTest(String sentence, int count) {
		
		String[] wordFreq = counter.countWords(sentence, count);
		
		System.out.println("Results:");
		int c = 1;
		for (String x : wordFreq ) {
			System.out.println(c++ + ": String " + x);
		}
	}

}
