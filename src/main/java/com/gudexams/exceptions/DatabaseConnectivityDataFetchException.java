/**
 * 
 */
package com.gudexams.exceptions;

/**
 * @author Suraj
 *
 */
@SuppressWarnings("serial")
public class DatabaseConnectivityDataFetchException extends RuntimeException
{
	public DatabaseConnectivityDataFetchException(String message)
		{
			super(message);
		}

	public DatabaseConnectivityDataFetchException(String message, Throwable cause)
		{
			super(message,cause);
		}
}
