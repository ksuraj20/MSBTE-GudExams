package com.gudexams.constants;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.gudexams.enums.ConfigProperties;
import com.gudexams.utils.PropertyUtils;

public final class FrameworkConstants
{

	private FrameworkConstants() {}

	//For Chrome driver
	private static final String CHROMEDRIVERPATH = ".\\src\\test\\resources\\excutables\\chromedriver.exe";
	private static final String EDGEDRIVERPATH = ".\\src\\test\\resources\\excutables\\msedgedriver.exe";
	private static final String CONFIGFILEPATH =".\\src\\test\\resources\\config\\config.properties";
	private static final String EXTENTREPORTFOLDERPATH ="extent-test-output/";
	private static  String extentReportFilePath = "";
	private static final int EXPLICITWAIT =15;
	private static final String EXCELPATH=".\\src\\test\\resources\\excel\\testData.xlsx";
	private static final String TESTSHEETNAME = "testCaseData";
	private static final String USERSDATASHEET = "usersDate";
	private static final String INSTDATASHEET = "InstData";
	private static final File IMAGESTOREPATH=new File(".\\src\\test\\resources\\image-test-output\\ss.png");


	public static String getChromedriverpath()
		{
			return CHROMEDRIVERPATH;
		}

	public static String getEdgeDriverPath()
		{
			return EDGEDRIVERPATH;
		}

	//For config properties file
	public static String getConfigfilePath()
		{
			return CONFIGFILEPATH;
		}

	public static int getExplicitWait()
		{
			return EXPLICITWAIT;
		}


	public static String getExtentreportpath()
		{
			if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
				{
					return EXTENTREPORTFOLDERPATH+"/"+ System.currentTimeMillis() +"index.html";
				}

			else if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes"))
				{
					return EXTENTREPORTFOLDERPATH+"/"+"index.html";
				}
			return "";
		}

	public static String getExtentReportFilePath() 
		{
			if(extentReportFilePath.isEmpty())
				{
					extentReportFilePath = createReportPath();
				}

			return extentReportFilePath;
		}

	private static String createReportPath()
		{
			if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
				{
					return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "_index.html";
				}
			else
				{
					return EXTENTREPORTFOLDERPATH+"/index.html";
				}
		}	

	public static String getExcelFilePath()
		{
			return EXCELPATH;
		}

	public static String getTestRunSheetName()
		{
			return TESTSHEETNAME;
		}

	public static String getUsersDataSheetName()
		{
			return USERSDATASHEET;
		}

	public static String getInstituteDataSheet()
		{
			return INSTDATASHEET;
		}

	public static BufferedImage bufferImagePath()
		{
			try
				{
					return ImageIO.read(IMAGESTOREPATH);
				} 
			catch (IOException e)
				{
					e.printStackTrace();
				}
			return null;
		}

	
}
