package com.gudexams.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import com.gudexams.enums.ConfigProperties;
import com.gudexams.exceptions.BrowesrInvocationFailedException;
import com.gudexams.factories.DriverFactory;
import com.gudexams.utils.PropertyUtils;
import com.gudexams.videorecord.RecorderConfig;

public class Driver
{

	private Driver() {}

	//Driver initialization
	public static void initDriver(String browser, String role)
		{
			if(Objects.isNull(DriverManager.getDriver()))
				{
					try
						{
							DriverManager.setDriver(DriverFactory.getDriver(browser));
							RecorderConfig.startRecord();
						} 
					catch (MalformedURLException e)
						{
							throw new BrowesrInvocationFailedException("Browser Invocation failed. Please check capabilities of browser ",e);
						}
				}

			if(role.equalsIgnoreCase("admin"))
				{
					DriverManager.getDriver().navigate().to(PropertyUtils.get(ConfigProperties.URLADMIN));
				}
			else if(role.equalsIgnoreCase("student"))
				{
					DriverManager.getDriver().navigate().to(PropertyUtils.get(ConfigProperties.URLSTUDENT));
				}
			else
				{
					throw new RuntimeException("Didn't recognize the role");
				}

		}
	//Driver close
	public static void quitDriver()
		{
			if(Objects.nonNull(DriverManager.getDriver()))
				{
					RecorderConfig.stopRecorder();
					DriverManager.getDriver().quit();
					DriverManager.unload();
				}
		}
}
