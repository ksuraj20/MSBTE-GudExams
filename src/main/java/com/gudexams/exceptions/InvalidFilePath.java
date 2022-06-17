package com.gudexams.exceptions;

@SuppressWarnings("serial")
public class InvalidFilePath extends FrameworkExceptions
{

	public InvalidFilePath(String message)
		{
			super(message);
		}

	public InvalidFilePath(String message, Throwable cause)
		{
			super(message, cause);
		}

}
