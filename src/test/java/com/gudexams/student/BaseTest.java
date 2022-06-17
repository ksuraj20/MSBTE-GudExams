package com.gudexams.student;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.gudexams.driver.Driver;

public class BaseTest
{

	protected BaseTest() {}

	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data)
		{
			Map<String, String> map = (Map<String, String>)data[0];
			Driver.initDriver(map.get("browser"),map.get("role"));

		}

	@AfterMethod
	protected void tearDown()
		{
			Driver.quitDriver();
		}
}
