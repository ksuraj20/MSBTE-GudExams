package com.gudexams.studentpages;

import org.openqa.selenium.By;
import com.gudexams.driver.DriverManager;
import com.gudexams.enums.WaitStrategy;
import com.gudexams.factories.ExplicitWaitFactory;
import com.gudexams.reports.ExtentLogger;

public class BasePage
{

	protected void click(By by, WaitStrategy waitstrategy, String elementName)
		{
			ExplicitWaitFactory.performExplicitWait(waitstrategy, by).click();
			ExtentLogger.pass(elementName+" is clicked", true);
		}

	protected void sendKeys(By by, String value, WaitStrategy waitstrategy, String elementName)
		{
			ExplicitWaitFactory.performExplicitWait(waitstrategy, by).clear();
			ExplicitWaitFactory.performExplicitWait(waitstrategy, by).sendKeys(value);
			ExtentLogger.pass(value + " is entered successfully in "+ elementName, true);
		}

	protected String getTitle(String pageName)
		{
			String title = DriverManager.getDriver().getTitle();
			ExtentLogger.pass("Title of the "+pageName +" page is:- "+title, true);
			return title;
		}

	protected String getText(By by, WaitStrategy waitstrategy, String elementName)
		{
			String text= ExplicitWaitFactory.performExplicitWait(waitstrategy, by).getText();
			ExtentLogger.pass("Text of the "+elementName+" is :- "+text,true);
			return text;
		}

	protected void waitForVisable(By by, WaitStrategy waitStrategy)
		{
			ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		}

}
