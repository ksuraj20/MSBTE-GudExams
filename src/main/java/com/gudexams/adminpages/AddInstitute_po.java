/**
 * 
 */
package com.gudexams.adminpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gudexams.driver.DriverManager;
import com.gudexams.enums.WaitStrategy;

/**
 * @author suraj
 *
 */
public class AddInstitute_po extends BasePage
{

	private final By userType = By.id("regType");
	private final By userName = By.id("controllerName");
	private final By instName = By.id("orgName");
	private final By region = By.id("region");
	private final By instEmail = By.id("email");
	private final By instMobile = By.id("email");
	private final By instPassword = By.id("email");
	private final By submitbtn = By.xpath("//button[@type='Submit']");

	public WebElement userType()
		{
			return DriverManager.getDriver().findElement(userType);
		}

	public AddInstitute_po enterUsername(String username)
		{
			sendKeys(userName, username, WaitStrategy.VISIBLE, "Username");
			return this;
		}

	public AddInstitute_po enterInstName(String instituteName)
		{
			sendKeys(instName, instituteName, WaitStrategy.VISIBLE, "Institute Name");
			return this;
		}

	public WebElement selectRegion()
		{
			return DriverManager.getDriver().findElement(region);
		}

	public AddInstitute_po enterInstEmail(String instituteEmail)
		{
			sendKeys(instEmail, instituteEmail, WaitStrategy.VISIBLE, "Institute Email");
			return this;
		}

	public AddInstitute_po enterInstMobile(String instituteMobile)
		{
			sendKeys(instMobile, instituteMobile, WaitStrategy.VISIBLE, "Institute Mobile");
			return this;
		}

	public AddInstitute_po instPassword(String instPass)
		{
			sendKeys(instPassword, instPass, WaitStrategy.VISIBLE, "Institute Password");
			return this;
		}

	public AddInstitute_po submitButton()
		{
			click(submitbtn, WaitStrategy.CLICKABLE, "Submit");
			return this;
		}

}
