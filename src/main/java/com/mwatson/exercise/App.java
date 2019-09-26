package com.mwatson.exercise;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * ownum-exercise
 * 
 * Read in locally stored text file and output a list of vowels and the amount of times 
 * they appear in the file to the console, then output the last word in the file that 
 * contains the most used vowel.
 * 
 * Author: Maxwell Watson
 *
 */

public class App {
	
    public static void main( String[] args ) {
    	
    	// Create the file for passage
    	String fileName = "passage.txt";
		File searchFile = new File(fileName);
		
		String passage = "";
		
		// Read in the passage file
		try (Scanner fileReader = new Scanner(searchFile)) {
			
			// Concatenate each line of the file in to the passage string
			while (fileReader.hasNextLine()) {
				passage += fileReader.nextLine();
			}
			
		} catch (IOException exception) {
			System.out.println("Unable to read from file" + exception);
		}
		
		// Create a passage analyzer object
		PassageAnalyzer passageAnalyzer = new PassageAnalyzer(passage);
		
		// Create the sorted vowel count map
		Map<Character, Integer> vowelCount = passageAnalyzer.getSortedMapOfVowelCount();
		
		System.out.println("Sorted list of vowel count:");
		
		// Print the sorted vowel count map
		for (Character vowelKey : vowelCount.keySet()) {
			System.out.println(vowelKey + ": " + vowelCount.get(vowelKey));
		}
		
		// Get the most used vowel
		String vowel = vowelCount.keySet().toArray()[0].toString();
		
		// Get the last word with the most used vowel
		String lastWord = passageAnalyzer.getLastWordWithVowel(vowel);
		
		// Print the last word
		System.out.println("\nLast word containing most used vowel(" + vowel + "): " + lastWord);
		
    }
    
}
