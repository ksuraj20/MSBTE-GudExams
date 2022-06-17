package com.gudexams.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.gudexams.utils.DataProviderUtils;

public class AnnotationTransformer implements IAnnotationTransformer
{

	@SuppressWarnings("rawtypes")
	public void transform(ITestAnnotation annotation,  Class testClass, Constructor testConstructor, Method testMethod)
		{
			annotation.setDataProvider("userDate");
			annotation.setDataProviderClass(DataProviderUtils.class);
			annotation.setRetryAnalyzer(ReTryFailedTests.class);
		}


}
