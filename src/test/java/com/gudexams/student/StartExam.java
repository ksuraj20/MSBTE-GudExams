/**
 * 
 */
package com.gudexams.student;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.gudexams.enums.ConfigProperties;
import com.gudexams.functions.UploadFiles;
import com.gudexams.studentpages.StartExam_po;
import com.gudexams.utils.PropertyUtils;

/**
 * @author suraj
 *
 */
public final class StartExam extends BaseTest
{
	private StartExam() {}

	static int examTotalDuration = Integer.parseInt(ExamInstructions.examDuration);
	static int examTotalQuestions = Integer.parseInt(ExamInstructions.instructionPageTotalQCount);
	static StartExam_po sep = new StartExam_po();

	@Test
	public static void exam() 
		{
			System.out.println("pcode is= "+sep.getPaperCode().get(1));
			System.out.println("exam timer is= "+sep.getExamTimer().get(1));
			System.out.println("proctoring message="+sep.proctoringMessageDisplay().get(1));
			System.out.println("Username from examPage="+sep.getUsernameFromExamPage().get(1));
			handelAlerts();

			int TotalQuestions = Integer.parseInt(ExamInstructions.instructionPageTotalQCount);

			for(int s=1; s<TotalQuestions;s++)
				{
					handelAlerts();

					if (sep.optionsRadioButton().size() !=0)
						{
							objectiveExam();
							handelAlerts();						
						}

					else if (sep.subjectiveExamTextBox().size() !=0 || sep.uploadFileButton().size() !=0 )
						{
							subjectiveExam();
							handelAlerts();
						}

					if (PropertyUtils.get(ConfigProperties.ISFULLTIMEEXAM).equalsIgnoreCase("yes"))
						{
							fullTimeExam();
						}
				}

			//End Exam
			sep.endExamButton().endExamButton().endExamFinalConfirmation();

		}

	public static void handelAlerts()
		{
			if (sep.warnigPopUpWindow().size() !=0)
				{
					if (sep.agreeWarningMessage().size() !=0)
						{
							sep.agreeToWarningMessageButton();
						}
					else if (sep.closeWarningMessage().size() !=0)
						{
							sep.closeWarningAlertButton();
						}
				}
		}

	public static void objectiveExam()
		{
			handelAlerts();
			Random ran = new Random();
			int ind = ran.nextInt(sep.optionsRadioButton().size());
			handelAlerts();
			sep.getQuestionNumberText();
			sep.optionsRadioButton().get(ind).click();
			handelAlerts();
			sep.nextButton();
			handelAlerts();
		}

	public static void subjectiveExam()
		{
			handelAlerts();
			if (sep.uploadFileButton().size() !=0)
				{
					sep.uploadFileButtonClick().chooseFileButton();

					//AutoIt code have to write
					UploadFiles.uploadFile(".\\src\\test\\resources\\uploadFilesResources\\9816B.jpg");

					sep.uploadAnswer(); // To upload above selected file
				}
			else
				{
					sep.enterAnswerInTextBox("Upload File Button is not available or upload answer is not aplicable for this question ");
				}

			handelAlerts();// To close the upload answer pop-up
			sep.saveNnextButton();
		}

	public static void fullTimeExam()
		{
			long timeDelay = examTotalDuration / examTotalQuestions;
			try
				{
					Thread.sleep(TimeUnit.MINUTES.toMillis(timeDelay));
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}

		}

}
