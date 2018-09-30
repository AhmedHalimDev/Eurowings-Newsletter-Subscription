package com.newsletter.sub.util;

import java.util.Random;

/**
 * Utils class containing helper methods...
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 30.09.2018
 */
public class UtilsBean {

	private static Random rand = new Random();
	
	/**
	 * Check if String is null or empty.
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isNullOrEmpty(String text) {
		if(text != null && !text.trim().equals("")) {
			return false;
		}
		return true;
	}
	/**
	 * Generate random number from 1 to 3
	 * @return
	 */
	public static int generateRandom(int limit) {
		return rand.nextInt(limit) + 1;
	}
}