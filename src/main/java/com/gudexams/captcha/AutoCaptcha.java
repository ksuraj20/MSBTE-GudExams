package com.gudexams.captcha;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public final class AutoCaptcha
{
	private AutoCaptcha() {}

	static WebDriver driver;
	static String value;
	public static String cap;
	private static String path;

	public static String captcha(String cap,WebElement xp, String role) 
		{
			File src = xp.getScreenshotAs(OutputType.FILE);

			if (role.equalsIgnoreCase("admin"))
				{
					path=".\\src\\test\\resources\\captcha_images_admin\\captcha.png";
				}

			else if (role.equalsIgnoreCase("student")) 
				{
					path=".\\src\\test\\resources\\captcha_images_student\\captcha.png";
				}

			try
				{
					FileHandler.copy(src, new File(path));
				}
			catch (IOException e)
				{
					throw new RuntimeException("Captcha storage file path not available");
				}

			ITesseract img = new Tesseract();
			try
				{
					value=img.doOCR(new File(path));
				} 
			catch (TesseractException e)
				{
					throw new RuntimeException("TesseractException exception interrupted");
				}

			String cap1=value.replaceAll("[^a-zA-Z1-9]+", "");
			cap=cap1.substring(0, 4);

			return cap;
		}
}
