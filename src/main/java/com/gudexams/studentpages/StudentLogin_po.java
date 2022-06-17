package com.gudexams.studentpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gudexams.captcha.AutoCaptcha;
import com.gudexams.driver.DriverManager;
import com.gudexams.enums.WaitStrategy;

public final class StudentLogin_po extends BasePage
{
	private final By usernameText=By.id("username"); 
	private final By passwordText=By.id("password");
	private final By captchaText=By.id("captcha");
	private final By checkBox1=By.id("privacyCheck");
	private final By checkBox2=By.id("cameraCheck");		
	private final By loginBtn=By.id("submit");
	private final By loginMessage = By.xpath("//div[@class='alert alert-success animate__animated animate__bounceIn animate_slow']");
	private final By requiredMessage = By.xpath("//div[@class='alert alert-warning']");

	public StudentLogin_po enterUserName(String username)
		{
			sendKeys(usernameText, username,  WaitStrategy.PRESENCE, "username filed");
			return this;
		}

	public StudentLogin_po enterPassword(String password)
		{
			sendKeys(passwordText, password, WaitStrategy.PRESENCE, "password filed");
			return this;
		}


	public WebElement captchaWebelmnt()
		{
			return DriverManager.getDriver().findElement(By.xpath("//div[@class='style_captchaContainer__LdFYB']"));
		}

	public StudentLogin_po enterCaptch(String role)
		{
			sendKeys(captchaText, AutoCaptcha.captcha(AutoCaptcha.cap, captchaWebelmnt(), role), WaitStrategy.CLICKABLE, "captcha box");
			return this;
		}

	public StudentLogin_po checkBox1()
		{
			click(checkBox1, WaitStrategy.CLICKABLE, "CheckBox1");
			return this;
		}

	public StudentLogin_po checkBox2()
		{
			click(checkBox2, WaitStrategy.CLICKABLE, "CheckBox2");
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
