/**
 * 
 */
package com.gudexams.functions;

/**
 * @author suraj
 *
 */
public final class SplitString
{

	private  SplitString() { }

	public static String splitString(String entireInputString, String splitSymbol, int numOfSplitsymbol)
		{
			String[] parts = entireInputString.split("\\"+splitSymbol);
			return parts[numOfSplitsymbol];
		}



}
