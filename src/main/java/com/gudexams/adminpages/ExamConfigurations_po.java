/**
 * 
 */
package com.gudexams.adminpages;

import com.gudexams.enums.WaitStrategy;

/**
 * @author suraj
 *
 */
public class ExamConfigurations_po extends BasePage
{
	static String val = "//a[text()='%value%']";

	public ExamConfigurations_po clickLinks(String linkName)
		{
			click(val, WaitStrategy.CLICKABLE, linkName, linkName);
			return this;
		}


}
