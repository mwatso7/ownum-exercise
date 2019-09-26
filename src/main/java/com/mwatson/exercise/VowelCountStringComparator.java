package com.mwatson.exercise;

import java.util.Comparator;

public class VowelCountStringComparator implements Comparator<String> {

	@Override
	public int compare(String vowelCountString1, String vowelCountString2 ) {
		
		// Compare the part of the vowel count string containing the integer of both arguments
        return Integer.valueOf(vowelCountString1.split(",")[0]).compareTo(Integer.valueOf(vowelCountString2.split(",")[0]));
    }

}
