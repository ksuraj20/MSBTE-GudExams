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
public final class StartExam_po extends BasePage
{
	private final By paperCode = By.xpath("//*[@class='sub-ject']");
	private final By examTimer = By.xpath("//*[@class='displayedTime']/div");
	private final By proctoringMessage = By.xpath("//*[text()='You are Proctored by Invigilator']");
	private final By optionsRadioButton = By.name("option");
	private final By usernameOnExamPage = By.xpath("//*[@id='myExamm']/div[4]/div[1]");
	private final By questionButtonsPalet = By.xpath("//div[@class='card que-btn']");
	private final By overallSummeryPalet = By.xpath("//div[@class='over-summery']");
	private final By cameraDisplayBox = By.xpath("//video[@id='myVideo']");
	private final By endExamButtonMessage = By.xpath("//*[text()='End Exam Button Available on Last Question']");
	private final By previousQuestionButton = By.xpath("//button[text()='Previous']"); 
	private final By nextQuestionButton = By.xpath("//button[text()='Save & Next']");
	private final By saveNnextQuestionButton = By.xpath("//button[text()='Save & Next']");
	private final By toBeReviewCheckBox = By.name("reviewlater");
	private final By questionText = By.xpath("//*[@id='myExamm']/div[3]/div/div[3]/div[2]/div/span/p");
	private final By questionNumber = By.xpath("//*[@id='myExamm']/div[3]/div/div[3]/div[1]");
	private final By agreeToWarning = By.xpath("//button[text()='Okay Noted']");
	private final By closeWarningButton = By.xpath("//button[text()='Close']");
	private final By warningWindow = By.xpath("//div[@class='modal-content']");
	private final By subjectiveTextBox = By.xpath("//div[@aria-label='Rich Text Editor, main']");
	private final By uploadFileButton = By.xpath("//button[text()='Upload Answer as File']");
	private final By chooseFileButton = By.id("file");
	private final By uploadAnswerButton = By.xpath("//button[text()='Upload Answer']");
	private final By endExamButton = By.xpath("//button[text()='End Exam']");
	private final By endExamFinalConf = By.xpath("//button[text()='Yes'");

	public List<Object> getPaperCode()
		{
			return Arrays.asList(this, getText(paperCode, WaitStrategy.VISIBLE, "PaperCode on Exam page "));
		}

	public List<Object> getExamTimer()
		{
			return Arrays.asList(this, getText(examTimer, WaitStrategy.PRESENCE, "Exam Page Timer "));
		}

	public List<Object> proctoringMessageDisplay()
		{
			return Arrays.asList(DriverManager.getDriver().findElements(proctoringMessage),getText(proctoringMessage, WaitStrategy.VISIBLE, "Proctoring message "));
		}

	public List<WebElement> optionsRadioButton()
		{
			return DriverManager.getDriver().findElements(optionsRadioButton);
		}

	public List<Object> getUsernameFromExamPage()
		{
			return Arrays.asList(this, getText(usernameOnExamPage, WaitStrategy.VISIBLE, "Username From Exam Page"));
		}

	public List<Object> getQuestionButtonsPalet()
		{
			return Arrays.asList(this, getText(questionButtonsPalet, WaitStrategy.VISIBLE, "Question Buttons Palet "));
		}

	public List<Object> getOverallSummeryPalet()
		{
			return Arrays.asList(this, getText(overallSummeryPalet, WaitStrategy.VISIBLE, "Overall Summery Palet "));
		}

	public List<WebElement> cameraAvailability()
		{
			return DriverManager.getDriver().findElements(cameraDisplayBox);
		}

	public List<Object> getEndExamButtonMessage()
		{
			return Arrays.asList(DriverManager.getDriver().findElements(endExamButtonMessage),getText(endExamButtonMessage, WaitStrategy.VISIBLE, "End Exam button message  "));
		}

	public StartExam_po previousQuestionButton()
		{
			click(previousQuestionButton, WaitStrategy.CLICKABLE, "Previous Question Button ");
			return this;
		}

	public StartExam_po nextButton()
		{
			click(nextQuestionButton, WaitStrategy.CLICKABLE, "Next Question Button ");
			return this;
		}
	
	public StartExam_po saveNnextButton()
		{
			click(saveNnextQuestionButton, WaitStrategy.CLICKABLE, "Save & Next Question Button ");
			return this;
		}

	public StartExam_po checkToBeReviewed()
		{
			click(toBeReviewCheckBox, WaitStrategy.CLICKABLE, "To Be Reviewed Checkbox");
			return this;
		}

	public List<Object> getQuestionText()
		{
			return Arrays.asList(this, getText(questionText, WaitStrategy.VISIBLE, "Question "));
		}

	public List<Object> getQuestionNumberText()
		{
			return Arrays.asList(this, getText(questionNumber, WaitStrategy.VISIBLE, "Question Number"));
		}

	public StartExam_po agreeToWarningMessageButton()
		{
			click(agreeToWarning, WaitStrategy.CLICKABLE, "Agree to warning message ");
			return this;
		}

	public StartExam_po closeWarningAlertButton()
		{
			click(closeWarningButton, WaitStrategy.CLICKABLE, "Agree to warning message ");
			return this;
		}

	public List<WebElement> warnigPopUpWindow()
		{
			return DriverManager.getDriver().findElements(warningWindow);
		}

	public List<WebElement> agreeWarningMessage()
		{
			return DriverManager.getDriver().findElements(agreeToWarning);
		}

	public List<WebElement> closeWarningMessage()
		{
			return DriverManager.getDriver().findElements(closeWarningButton);
		}

	public List<WebElement> subjectiveExamTextBox()
		{
			return DriverManager.getDriver().findElements(subjectiveTextBox);
		}

	public StartExam_po enterAnswerInTextBox(String answer)
		{
			sendKeys(subjectiveTextBox, answer , WaitStrategy.CLICKABLE, "Subjective Exam Text box");
			return this;
		}

	public List<WebElement> uploadFileButton()
		{
			return DriverManager.getDriver().findElements(uploadFileButton);
		}

	public StartExam_po uploadFileButtonClick()
		{
			click(uploadFileButton, WaitStrategy.CLICKABLE, "Upload File button ");
			return this;
		}

	public StartExam_po chooseFileButton()
		{
			click(chooseFileButton, WaitStrategy.CLICKABLE, "Choose file button ");
			return this;
		}

	public StartExam_po uploadAnswer()
		{
			click(uploadAnswerButton, WaitStrategy.CLICKABLE, "Upload Answer Button ");
			return this;
		}

	public StartExam_po endExamButton()
		{
			click(endExamButton, WaitStrategy.CLICKABLE, "End Exam Button ");
			return this;
		}

	public StartExam_po endExamFinalConfirmation()
		{
			click(endExamFinalConf, WaitStrategy.CLICKABLE, "End Exam final confirmation Yes button ");
			return this;
		}
}
