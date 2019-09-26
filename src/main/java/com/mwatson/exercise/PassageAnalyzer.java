package com.mwatson.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PassageAnalyzer {
	
	private String text;
	private String[] words;
	
	public PassageAnalyzer(String passage) {
		
		// Create the file input and build inventory
    	this.text = passage;
		this.words = this.text.split(" ");
	}
	
	public Map<Character, Integer> getSortedMapOfVowelCount() {
		
		// Create the vowel count map
		Map<Character, Integer> vowelCount = createVowelCountMap();
		
		// Turn the vowel count map into a list of strings that can be sorted
		List<String> sortedList = createSortedStringList(vowelCount);
		
		Map<Character, Integer> sortedVowelCount = new LinkedHashMap<Character, Integer>();
		
		// Populate new vowel count map with the sorted list
		for (String vowelCountString : sortedList) {
			sortedVowelCount.put(vowelCountString.split(",")[1].toCharArray()[0], Integer.valueOf(vowelCountString.split(",")[0]));
		}
		
		return sortedVowelCount;
	}
	
	public String getMostUsedVowel() {
		
		// Create the vowel count map
		Map<Character, Integer> vowelCount = createVowelCountMap();

		// Turn the vowel count map into a list of strings that can be sorted
		List<String> sortedList = createSortedStringList(vowelCount);
		
		return sortedList.get(0).split(",")[1];
	}
	
	public String getLastWordWithVowel(String vowel) {
		
		// Loop through list of words from back to front
		for(int index = this.words.length - 1; index >= 0; index--) {
			// Return the first word containing the vowel
			if(words[index].contains(vowel)) {
				return this.words[index];
			}
		}
		
		return "N/A";
	}
	
	private Map<Character, Integer> createVowelCountMap() {
		
		// Create map of vowel count and set initial key bindings to 0
		Map<Character, Integer> vowelCount = new LinkedHashMap<Character, Integer>();
		vowelCount.put('u', 0);
		vowelCount.put('e', 0);
		vowelCount.put('i', 0);
		vowelCount.put('o', 0);
		vowelCount.put('a', 0);

		// Loop through text as a character array
		for (char character : text.toCharArray()) {
			
			// Increase count value if the character is a vowel
			if (vowelCount.containsKey(character)) {
				vowelCount.put(character, vowelCount.get(character) + 1);
			}
		}
		
		return vowelCount;
	}
	
	private List<String> createSortedStringList(Map<Character, Integer> vowelCount) {

		// Turn the vowel count map into a list of strings that can be sorted
		List<String> sortedList = new ArrayList<String>();
		sortedList.add(vowelCount.get('a').toString() + ",a");
		sortedList.add(vowelCount.get('e').toString() + ",e");
		sortedList.add(vowelCount.get('i').toString() + ",i");
		sortedList.add(vowelCount.get('o').toString() + ",o");
		sortedList.add(vowelCount.get('u').toString() + ",u");

		// Sort list of strings using comparator and reverse
		Collections.sort(sortedList, new VowelCountStringComparator());
		Collections.reverse(sortedList);
		
		return sortedList;
	}
}
