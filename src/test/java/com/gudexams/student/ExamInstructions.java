/**
 * 
 */
package com.gudexams.student;

import org.testng.annotations.Test;

import com.gudexams.functions.ExtractInt;
import com.gudexams.studentpages.ExamInstruction_po;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author suraj
 *
 */
public final class ExamInstructions extends BaseTest
{
	private ExamInstructions(){}

	static String instructionPageTotalQCount;
	static String examDuration;

	static ExamInstruction_po eip = new ExamInstruction_po();

	@Test
	public static void validateInstructionsPage()
		{
			//To cross check the total question of instruction page and card 
			instructionPageTotalQCount=ExtractInt.extractInt(String.valueOf(eip.totalQustionCount().get(1)));
			assertThat(StudentHome.numberTotalQuestions)
			.isEqualTo(instructionPageTotalQCount);

			//To cross check the test duration of instruction page and card 
			examDuration = ExtractInt.extractInt(String.valueOf(eip.examDuration().get(1)));
			assertThat(StudentHome.testDuration)
			.isEqualTo(examDuration);

			startExamProcess();
		}

	@Test
	public static void startExamProcess()
		{
			eip.agreeCheckBox();

			if (StudentHome.examCurrentStringStatus.equalsIgnoreCase("Start Exam"))
				{
					eip.startExamButton();
				}

			else if (StudentHome.examCurrentStringStatus.equalsIgnoreCase("Continue Exam"))
				{
					eip.resumeExamButton();
					if(eip.warningAlertBox().size() !=0)
						{
							eip.agreeToResumeExam();
						}

				}

			StartExam.exam();

		}

}
