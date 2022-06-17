package com.gudexams.utils;

public final class DynamicXapthUtils
	{
		private DynamicXapthUtils() {}
		
		public static  String getDynamicXpath(String xapth, String replaceableNewValue)
		{
			return xapth.replace(xapth, replaceableNewValue);
		}
	}
