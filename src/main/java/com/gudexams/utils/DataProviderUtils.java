package com.gudexams.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.gudexams.constants.FrameworkConstants;

public final class DataProviderUtils
{
	private static List<Map<String, String>> list = new ArrayList<Map<String,String>>();

	@DataProvider(parallel = true)
	public static Object[] userDate(Method m)
		{
			String testname = m.getName();
			if(list.isEmpty())
				{
					list = ExcelUtils.getTestDetails(FrameworkConstants.getUsersDataSheetName());
				}

			List<Map<String, String>> iteratioList = new ArrayList<Map<String,String>>();

			for(int i=0; i<list.size(); i++)
				{
					if(list.get(i).get("testName").equalsIgnoreCase(testname) && list.get(i).get("execute").equalsIgnoreCase("yes"))
						{
							iteratioList.add(list.get(i));
						}
				}

			return iteratioList.toArray();
		}
}
