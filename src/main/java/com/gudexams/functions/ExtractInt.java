/**
 * 
 */
package com.gudexams.functions;

/**
 * @author suraj
 *
 */
public final class ExtractInt
	{
		
		private ExtractInt() { }
		
		public static String extractInt(String stringInput)
		{
			// Replacing every non-digit number
			// with a space(" ")
			stringInput = stringInput.replaceAll("[^\\d]", " ");

			// Remove extra spaces from the beginning
			// and the ending of the string
			stringInput = stringInput.trim();

			// Replace all the consecutive white
			// spaces with a single space
			stringInput = stringInput.replaceAll(" +", " ");

			if (stringInput.equals(""))
				return "-1";

			return stringInput;

		}
		
		
	}
