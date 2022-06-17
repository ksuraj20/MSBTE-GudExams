/**
 * Feb 23, 2022
 * @author Suraj K
 * @version 1.0
 * tag
 */
package com.gudexams.exceptions;

/**
 * @author suraj
 *
 */
@SuppressWarnings("serial")
public class BrowesrInvocationFailedException extends RuntimeException
	{
		public BrowesrInvocationFailedException(String message)
		{
			super(message);
		}
		
		public BrowesrInvocationFailedException(String message, Throwable cause)
			{
				super(message,cause);
			}
		
	}
