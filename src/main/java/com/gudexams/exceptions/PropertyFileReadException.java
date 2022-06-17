package com.gudexams.exceptions;

@SuppressWarnings("serial")
public class PropertyFileReadException extends FrameworkExceptions
{

	public PropertyFileReadException(String message)
		{
			super(message);
		}

	public PropertyFileReadException(String message, Throwable cause)
		{
			super(message, cause);
		}

}
