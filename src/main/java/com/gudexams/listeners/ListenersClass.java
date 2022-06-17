package com.gudexams.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.gudexams.annotations.FrameworkAnnotations;
import com.gudexams.reports.ExtentLogger;
import com.gudexams.reports.ExtentReport;

public class ListenersClass implements ITestListener, ISuiteListener
{


	public void onStart(ISuite suite)
		{
			ExtentReport.initReports();
		}

	public void onFinish(ISuite suite)
		{
			ExtentReport.flusReports();
		}

	public void onTestStart(ITestResult result)
		{
			ExtentReport.createTest(result.getMethod().getDescription());
			ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author());
			ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());
		}

	public void onTestSuccess(ITestResult result)
		{
			ExtentLogger.pass(result.getMethod().getMethodName()+ " is passed",true);
		}

	public void onTestFailure(ITestResult result)
		{
			ExtentLogger.fail(result.getMethod().getMethodName()+ " is failed", true);
			ExtentLogger.fail(result.getThrowable().getMessage());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		}

	public void onTestSkipped(ITestResult result)
		{
			ExtentLogger.skip(result.getMethod().getMethodName()+ " is skipped", true);
		}


}
