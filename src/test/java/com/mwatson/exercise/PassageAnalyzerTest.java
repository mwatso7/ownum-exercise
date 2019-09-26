package com.mwatson.exercise;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;



/**
 * Unit testing for PassageAnalyzer class
 */

public class PassageAnalyzerTest {

	@Test
	public void testSimplePassage() {
		
		String testPassage = "This is a simple passage for testing purposes";
		PassageAnalyzer testPassageAnalyzer = new PassageAnalyzer(testPassage);
		
		assertEquals(Integer.valueOf(3), testPassageAnalyzer.getSortedMapOfVowelCount().get('a'));
		assertEquals(Integer.valueOf(4), testPassageAnalyzer.getSortedMapOfVowelCount().get('i'));
		assertEquals(Integer.valueOf(2), testPassageAnalyzer.getSortedMapOfVowelCount().get('o'));
		assertEquals("i", testPassageAnalyzer.getMostUsedVowel());
		assertEquals("testing", testPassageAnalyzer.getLastWordWithVowel("i"));
		assertEquals("passage", testPassageAnalyzer.getLastWordWithVowel("a"));
	}
	
	@Test
	public void testEmptyPassage() {
		
		String testPassage = "";
		PassageAnalyzer testPassageAnalyzer = new PassageAnalyzer(testPassage);
		
		assertEquals(Integer.valueOf(0), testPassageAnalyzer.getSortedMapOfVowelCount().get('a'));
		assertEquals(Integer.valueOf(0), testPassageAnalyzer.getSortedMapOfVowelCount().get('i'));
		assertEquals(Integer.valueOf(0), testPassageAnalyzer.getSortedMapOfVowelCount().get('o'));
		assertEquals("N/A", testPassageAnalyzer.getMostUsedVowel());
		assertEquals("N/A", testPassageAnalyzer.getLastWordWithVowel("i"));
		assertEquals("N/A", testPassageAnalyzer.getLastWordWithVowel("a"));
	}
	
	@Test
	public void testPaddedPassage() {
		
		String testPassage = "    This   passage    ";
		PassageAnalyzer testPassageAnalyzer = new PassageAnalyzer(testPassage);
		
		assertEquals(Integer.valueOf(2), testPassageAnalyzer.getSortedMapOfVowelCount().get('a'));
		assertEquals(Integer.valueOf(1), testPassageAnalyzer.getSortedMapOfVowelCount().get('i'));
		assertEquals(Integer.valueOf(0), testPassageAnalyzer.getSortedMapOfVowelCount().get('o'));
		assertEquals("a", testPassageAnalyzer.getMostUsedVowel());
		assertEquals("This", testPassageAnalyzer.getLastWordWithVowel("i"));
		assertEquals("passage", testPassageAnalyzer.getLastWordWithVowel("a"));
		assertEquals("N/A", testPassageAnalyzer.getLastWordWithVowel("o"));
	}
	
	@Test
	public void testSingleWordPassage() {
		
		String testPassage = "passage";
		PassageAnalyzer testPassageAnalyzer = new PassageAnalyzer(testPassage);
		
		assertEquals(Integer.valueOf(2), testPassageAnalyzer.getSortedMapOfVowelCount().get('a'));
		assertEquals(Integer.valueOf(1), testPassageAnalyzer.getSortedMapOfVowelCount().get('e'));
		assertEquals(Integer.valueOf(0), testPassageAnalyzer.getSortedMapOfVowelCount().get('o'));
		assertEquals("a", testPassageAnalyzer.getMostUsedVowel());
		assertEquals("N/A", testPassageAnalyzer.getLastWordWithVowel("i"));
		assertEquals("passage", testPassageAnalyzer.getLastWordWithVowel("a"));
	}
	
}
