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
		assertEquals("i", testPassageAnalyzer.getMostUsedVowel());
		assertEquals("testing", testPassageAnalyzer.getLastWordWithVowel("i"));
	}
	
}
