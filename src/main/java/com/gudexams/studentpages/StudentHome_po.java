package com.gudexams.studentpages;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gudexams.driver.DriverManager;
import com.gudexams.enums.WaitStrategy;

public final class StudentHome_po extends BasePage
{

	private final By stdDetails = By.xpath("//div[@class='col-lg-8']");
	private final By allBtn = By.xpath("//button[@class='btn btn-sm btn-all-btn']");
	private final By yetToStart = By.xpath("//button[@class='btn btn-sm btn-success']");
	private final By resume = By.xpath("//button[@class='btn btn-sm btn-primary']");
	private final By completed = By.xpath("//button[@class='btn btn-sm btn-info']");
	private final By expired = By.xpath("//button[@class='btn btn-sm btn-danger']");
	private final By homelink = By.xpath("//*[@id='sidenavAccordion']/div/div/a/text()");
	private final By searchSubject = By.name("searchSubject");
	private final By searchButton = By.xpath("//button[@type='submit']");
	private final By resumeCardHeader = By.xpath("//a[text()='Resume']");
	private final By startCardHeader = By.xpath("//a[text()='Proceed']");
	private final By expireCardHeader = By.xpath("//button[text()='Expired']");
	private final By completedCardHeader = By.xpath("//button[text()='Completed']");
	private final By logoutButton = By.xpath("//button[text()='Logout']");
	private final By totalExamCardsBy = By.xpath("//div[@class='card']");
	private final By startTime = By.xpath("//*[@id='layoutSidenav_content']/main/div/div/div[3]/div/div/div[2]/ul/li[1]/time");
	private final By endTime = By.xpath("//*[@id='layoutSidenav_content']/main/div/div/div[3]/div/div/div[2]/ul/li[2]/time");
	private final By noOfQuestion = By.xpath("//*[@id='layoutSidenav_content']/main/div/div/div[3]/div/div/div[2]/ul/li[4]");
	private final By testDuration = By.xpath("//*[@id='layoutSidenav_content']/main/div/div/div[3]/div/div/div[2]/ul/li[5]");
	private final By proceedButton = By.xpath("//a[text()='Proceed']");
	private final By continueButton = By.xpath("//a[text()='Resume']");
	
	
 	public List<Object> studentHomePageTitle()
		{
			return Arrays.asList(this, getTitle("Student Home"));
		}

	public List<Object> studentDetails()
		{
			return Arrays.asList(this, getText(stdDetails, WaitStrategy.VISIBLE, "Student details bar"));
		}

	public List<Object> allButton()
		{
			return Arrays.asList(this, getText(allBtn, WaitStrategy.VISIBLE, "All button"));
		}

	public List<Object> yetToStartButton()
		{
			return Arrays.asList(this, getText(yetToStart, WaitStrategy.VISIBLE, "Yet to start button"));
		}

	public List<Object> completedButton()
		{
			return Arrays.asList(this, getText(completed, WaitStrategy.VISIBLE, "Completed button"));
		}

	public List<Object> expiredButton()
		{
			return Arrays.asList(this, getText(expired, WaitStrategy.VISIBLE, "Expired button"));
		}

	public List<Object> homeLink()
		{
			return Arrays.asList(this, getText(homelink, WaitStrategy.VISIBLE, "Home link"));
		}

	public StudentHome_po searchSubjectButton(String paperCode)
		{
			sendKeys(searchSubject, paperCode, WaitStrategy.PRESENCE," entered in search box");
			return this;
		}

	public StudentHome_po searchButton()
		{
			click(searchButton, WaitStrategy.CLICKABLE, "Search Exam button clicked");
			return this;
		}

	public List<Object> resumeButton()
		{
			return Arrays.asList(this, getText(resume, WaitStrategy.VISIBLE, "Resume button"));
		}

	public StudentHome_po logoutButton()
		{
			click(logoutButton, WaitStrategy.CLICKABLE, "Logout button");
			return this;
		}

	public List<Object> resumeCardHeader()
		{
			return Arrays.asList(this, getText(resumeCardHeader, WaitStrategy.VISIBLE, "Resume card header"));
		}

	public List<Object> startCardHeader()
		{
			return Arrays.asList(this, getText(startCardHeader, WaitStrategy.VISIBLE, "Start card header"));
		}

	public List<Object> expiredCardHeader()
		{
			return Arrays.asList(this, getText(expireCardHeader, WaitStrategy.VISIBLE, "Expired card header"));
		}

	public List<Object> completedCardHeader()
		{
			return Arrays.asList(this, getText(completedCardHeader, WaitStrategy.VISIBLE, "Completed card header"));
		}

	public List<WebElement> numofTotalExamCards()
		{
			waitForVisable(totalExamCardsBy, WaitStrategy.NONE);
			return DriverManager.getDriver().findElements(totalExamCardsBy);
		}

	public List<WebElement> numofYetToStartCards()
		{
			waitForVisable(startCardHeader, WaitStrategy.NONE);
			return DriverManager.getDriver().findElements(startCardHeader);
		}

	public List<WebElement> numofResumeExamCards()
		{
			return DriverManager.getDriver().findElements(resumeCardHeader);
		}

	public List<WebElement> numofCompletedExamCards()
		{
			waitForVisable(completedCardHeader, WaitStrategy.NONE);
			return DriverManager.getDriver().findElements(completedCardHeader);
		}

	public List<WebElement> numofExpiredExamCards()
		{
			waitForVisable(expireCardHeader, WaitStrategy.NONE);
			return DriverManager.getDriver().findElements(expireCardHeader);
		}

	public List<Object> noOfQuestion()
		{
			return Arrays.asList(this, getText(noOfQuestion, WaitStrategy.PRESENCE, "Number of total question on card "));
		}
	
	public List<Object> examStartTime()
		{
			return Arrays.asList(this, getText(startTime, WaitStrategy.CLICKABLE, "Exam Start Time "));
		}
	
	public List<Object> examEndTime()
		{
			return Arrays.asList(this, getText(endTime, WaitStrategy.CLICKABLE, "Exam End Time "));
		}
	
	public List<Object> examDuration()
		{
			return Arrays.asList(this, getText(testDuration, WaitStrategy.CLICKABLE, "Exam Duration "));
		}

	public StudentHome_po startExam()
	{
		click(proceedButton, WaitStrategy.CLICKABLE, "Start Exam Button");
		return this;
	}
	
	public StudentHome_po continueExam()
		{
			click(continueButton, WaitStrategy.CLICKABLE, "Continue Exam Button");
			return this;
		}
	
	
}
