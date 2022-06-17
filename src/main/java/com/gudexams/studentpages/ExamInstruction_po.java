/**
 * 
 */
package com.gudexams.studentpages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gudexams.driver.DriverManager;
import com.gudexams.enums.WaitStrategy;

/**
 * @author suraj
 *
 */
public final class ExamInstruction_po extends BasePage
{
	private final By totalQuestion = By.xpath("//*[@id='layoutSidenav_content']/main/div/div/div[1]/div[2]/div[1]/ol/li[1]"); 
	private final By candPHStatus = By.xpath("//*[@id='layoutSidenav_content']/main/div/div/div[1]/div[2]/div[1]/ol/li[2]");
	private final By examDuration = By.xpath("//*[@id='layoutSidenav_content']/main/div/div/div[1]/div[2]/div[1]/ol/li[3]");
	private final By agreeCheckBox = By.xpath("//input[@type='checkbox']");
	private final By startExamButton = By.xpath("//button[text()='Start Exam']");
	private final By resumuExamButton = By.xpath("//button[text()='Continue Exam']");
	private final By warningAlertBox = By.xpath("//div[@class='modal-content']");
	private final By agreeToWarning = By.xpath("//button[text()='Okay Noted']");


	public List<Object> totalQustionCount()
		{
			return Arrays.asList(this, getText(totalQuestion, WaitStrategy.VISIBLE, "Total Question count on instrucion page "));
		}

	public List<Object> candidatePhStatus()
		{
			return Arrays.asList(this, getText(candPHStatus, WaitStrategy.VISIBLE, "Candidate PH status "));
		}

	public List<Object> examDuration()
		{
			return Arrays.asList(this, getText(examDuration, WaitStrategy.VISIBLE, "Exam Duration on instruction page "));
		}

	public ExamInstruction_po agreeCheckBox()
		{
			click(agreeCheckBox, WaitStrategy.CLICKABLE, "I Agree check box ");
			return this;
		}

	public ExamInstruction_po startExamButton()
		{
			click(startExamButton, WaitStrategy.CLICKABLE, "Start exam button ");
			return this;
		}

	public ExamInstruction_po resumeExamButton()
		{
			click(resumuExamButton, WaitStrategy.CLICKABLE, "Resume exam button ");
			return this;
		}

	public List<WebElement> warningAlertBox()
		{
			return DriverManager.getDriver().findElements(warningAlertBox);
		}

	public ExamInstruction_po agreeToResumeExam()
		{
			click(agreeToWarning, WaitStrategy.CLICKABLE, "Okay Noted button ");
			return this;
		}

}
