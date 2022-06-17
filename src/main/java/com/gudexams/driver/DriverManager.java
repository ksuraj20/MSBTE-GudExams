package com.gudexams.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager
{

	private DriverManager () {}

	private static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	//Use this method to access the driver
	public static WebDriver getDriver()
		{
			return dr.get();
		}

	public static void setDriver(WebDriver driverRef)
		{
			dr.set(driverRef);
		}

	public static void unload()
		{
			dr.remove();
		}


}
