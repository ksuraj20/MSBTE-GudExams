/**
 * 
 */
package com.gudexams.functions;

import org.openqa.selenium.JavascriptExecutor;

import com.gudexams.driver.DriverManager;

/**
 * @author suraj
 *
 */
public final class NetworkPerformance
{

	private NetworkPerformance() { }

	public static String getNetworkPerformance() 
		{
			String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
			String netData = ((JavascriptExecutor)DriverManager.getDriver()).executeScript(scriptToExecute).toString();
			return netData;
		}

}
