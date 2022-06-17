package com.gudexams.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.gudexams.enums.ConfigProperties;
import com.gudexams.utils.PropertyUtils;

public class ReTryFailedTests implements IRetryAnalyzer
{
	private int count = 0;
	private int reTryCount = 1;
	private static boolean toRetryMethod;

	public boolean retry(ITestResult result)
		{
			boolean value=false;

			if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes") || toRetryMethod )
				{
					value = count<reTryCount ; 
					count++;
					System.out.println(result.getMethod().getMethodName() + " is retrying for "+count+" time");

				}
			return value;
		}
	
	public static boolean setRetry(boolean condition)
	{
		return toRetryMethod==condition;
	}

}

