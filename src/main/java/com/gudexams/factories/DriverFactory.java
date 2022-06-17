/**
 * Feb 23, 2022
 * @author Suraj K
 * @version 1.0
 * tag
 */
package com.gudexams.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import com.gudexams.enums.ConfigProperties;
import com.gudexams.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author suraj
 *
 */
@SuppressWarnings("deprecation")
public final class DriverFactory
{
	private DriverFactory() {}
	static WebDriver driver;

	@Parameters("browser")
	public static WebDriver getDriver(String browser) throws MalformedURLException
		{
			String runMode = PropertyUtils.get(ConfigProperties.RUNMODE);
			DesiredCapabilities cap = new DesiredCapabilities();


			if(browser.equalsIgnoreCase("chrome"))
				{
					ChromeOptions cp= new ChromeOptions();
					cp.addArguments("use-fake-ui-for-media-stream");
					cp.addArguments("--incognito");
					cp.addArguments("--disable-notifications");
					cp.setCapability("marionette", true);
					cp.addArguments("start-maximized");
					cp.setCapability("autoAcceptAlerts", "true");
					cp.setCapability("autoGrantPermissions", "true");
					cap.setCapability(ChromeOptions.CAPABILITY, cp);

					if(runMode.equalsIgnoreCase("remote"))
						{
							cap.setBrowserName(BrowserType.CHROME);
							driver= new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), cp);
						}
					else 
						{
							WebDriverManager.chromedriver().setup();
							driver = new ChromeDriver(cp);
						}

				}
			else if(browser.equalsIgnoreCase("edge") || browser.equalsIgnoreCase("MicrosoftEdge"))
				{

					EdgeOptions eOptions = new EdgeOptions();
					eOptions.addArguments("start-maximized");
					eOptions.addArguments("--incognito");
					eOptions.addArguments("--disable-notifications");

					if(runMode.equalsIgnoreCase("remote"))
						{
							cap.setBrowserName(BrowserType.EDGE);
							driver= new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), eOptions); 
						}
					else
						{
							WebDriverManager.edgedriver().setup();
							driver = new EdgeDriver(eOptions);
						}
				}
			return driver;

		}
}

