/**
 * 
 */
package com.gudexams.adminpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gudexams.captcha.AutoCaptcha;
import com.gudexams.driver.DriverManager;
import com.gudexams.enums.WaitStrategy;
import com.gudexams.studentpages.StudentHome_po;

/**
 * @author suraj
 *
 */
public class AdminLogin_po extends BasePage
{

	private final By selectRole = By.id("adminType");
	private final By usernameText=By.id("username"); 
	private final By passwordText=By.id("password");
	private final By captchaText=By.id("captcha");
	private final By loginBtn=By.id("submit");
	private final By loginMessage = By.xpath("//div[@class='col-lg-12 alert alert-success animate__animated animate__bounceIn animate_slow']");
	private final By requiredMessage = By.xpath("//div[@class='alert alert-warning']");
	

	public WebElement selectRole()
		{
			return DriverManager.getDriver().findElement(selectRole);
		}

	public AdminLogin_po enterUserName(String username)
		{
			sendKeys(usernameText, username, WaitStrategy.CLICKABLE, "Username field");
			return this;
		}

	public AdminLogin_po enterPassword(String password)
		{
			sendKeys(passwordText, password, WaitStrategy.CLICKABLE, "Password field");
			return this;
		}

	public WebElement captchaWebelmnt()
		{
			return DriverManager.getDriver().findElement(By.xpath("//div[@class='style_captchaContainer__LdFYB']"));
		}

	public AdminLogin_po enterCaptch(String role)
		{
			sendKeys(captchaText, AutoCaptcha.captcha(AutoCaptcha.cap, captchaWebelmnt(), role), WaitStrategy.CLICKABLE, "captcha box");
			return this;
		}

	public StudentHome_po loginBtn()
		{
			click(loginBtn, WaitStrategy.CLICKABLE, "Login Button");
			return new StudentHome_po();
		}
	
	public List<WebElement> loginMessage()
		{
			return DriverManager.getDriver().findElements(loginMessage);
		}

	public List<WebElement> requiredMessage()
		{
			return DriverManager.getDriver().findElements(requiredMessage);
		}

	public String loginMessageText()
		{
			return DriverManager.getDriver().findElement(loginMessage).getText();
		}

}
