package com.gudexams.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.gudexams.constants.FrameworkConstants;
import com.gudexams.enums.CategoryType;

public final class ExtentReport
{

	private  ExtentReport() {}

	private static  ExtentReports extent;

	@BeforeSuite
	public static void initReports()
		{
			if(Objects.isNull(extent))	
				{
					extent = new ExtentReports();
					ExtentSparkReporter extentSpark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
					extent.attachReporter(extentSpark);
					extentSpark.config().setTheme(Theme.DARK);
					extentSpark.config().setDocumentTitle("Gudexams Automation Report");
					extentSpark.config().setReportName("Automation Functional Testing");
				}
		}


	public static void flusReports()
		{
			if(Objects.nonNull(extent))
				{
					extent.flush();
				}
			ExtentManager.unload();
			try
				{
					Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
				} catch (IOException e)
				{
					e.printStackTrace();
				}

		}

	public static void createTest(String testCaseName)
		{
			ExtentManager.setExtentTest(extent.createTest(testCaseName));
		}

	public static void addAuthors(String[] authors)
		{
			for(String auth : authors)
				{
					ExtentManager.getExtentTest().assignAuthor(auth);
				}
		}

	public static void addCategories(CategoryType [] categories)
		{
			for(CategoryType catg : categories)
				{
					ExtentManager.getExtentTest().assignCategory(catg.toString());
				}
		}

}
