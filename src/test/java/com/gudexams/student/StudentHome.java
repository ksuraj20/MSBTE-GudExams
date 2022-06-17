/**
 * 
 */
package com.gudexams.student;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.gudexams.functions.ExtractInt;
import com.gudexams.functions.SplitString;
import com.gudexams.studentpages.StudentHome_po;

/**
 * @author suraj
 *
 */
public final class StudentHome extends BaseTest
{
	static StudentHome_po shp = new StudentHome_po();
	static String numberTotalQuestions;
	static String testDuration;
	static String examCurrentStringStatus;
	static String paperCode;

	private StudentHome() {}


	@Test
	public static void StudentHomePageValidation()
		{

			shp.studentDetails().get(1);

			//HomePage Title
			assertThat(shp.studentHomePageTitle().get(1))
			.isEqualTo("Online Exam");

			//All Exam 
			assertThat(shp.allButton().get(1))
			.isEqualTo(String.valueOf(shp.numofTotalExamCards().size()));

			//Yet To Start Exam

			assertThat(shp.yetToStartButton().get(1))
			.isEqualTo(String.valueOf(shp.numofYetToStartCards().size()));


			//Resume Exam
			assertThat(shp.resumeButton().get(1))
			.isEqualTo(String.valueOf(shp.numofResumeExamCards().size()));

			//Completed Exam
			assertThat(shp.completedButton().get(1))
			.isEqualTo(String.valueOf(shp.numofCompletedExamCards().size()));

			//Expired Exam
			assertThat(shp.expiredButton().get(1))
			.isEqualTo(String.valueOf(shp.numofExpiredExamCards().size()));

			//Cross check the all button and sum of all buttons
			int allCards=(shp.numofYetToStartCards().size()+shp.numofResumeExamCards().size()+shp.numofCompletedExamCards().size()+shp.numofExpiredExamCards().size());
			assertThat(shp.allButton().get(1))
			.isEqualTo(String.valueOf(allCards));

			testDuration = ExtractInt.extractInt(String.valueOf(shp.examDuration().get(1)));

			searchExams();
		}

	@Test
	public static void searchExams()
		{
			//Search exam process and search exam result validation
			if(shp.numofYetToStartCards().size() != 0)
				{
					String startExamCardText= String.valueOf(shp.startCardHeader().get(1));
					shp.searchSubjectButton(SplitString.splitString(startExamCardText, "-", 0)).searchButton();
					examCurrentStringStatus="Start Exam";

					//Search Result Validation
					System.out.println("a1.="+shp.numofYetToStartCards().size());
					assertThat(shp.numofYetToStartCards().size())
					.isEqualTo(1);
				}
			else if(shp.numofResumeExamCards().size() !=0)
				{
					String resumeExamCardText= String.valueOf(shp.resumeCardHeader().get(1));
					shp.searchSubjectButton(SplitString.splitString(resumeExamCardText, "-", 0)).searchButton();
					examCurrentStringStatus="Continue Exam";

					//Search Result Validation
					assertThat(shp.numofResumeExamCards())
					.isEqualTo(1);
				}
			else
				{
					throw new RuntimeException("Zero number of Start and Resume exam(s) found, There are "+shp.numofCompletedExamCards().size()+" Completed Exam(s) and "+shp.numofExpiredExamCards().size()+" Expired Exam(s)");
				}


			cardInfoValidation();
		}

	@Test
	public static void cardInfoValidation()
		{
			//To print the exam card details 
			shp.examStartTime().get(1);
			shp.examEndTime().get(1);
			shp.noOfQuestion().get(1);
			shp.examDuration().get(1);

			// To get the total number of questions
			numberTotalQuestions=ExtractInt.extractInt(String.valueOf(shp.noOfQuestion().get(1)));
			try
				{
					Thread.sleep(3000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}

			// Start & Resume Exam process
			if (shp.numofResumeExamCards().size() !=0)
				{
					shp.continueExam();
				}
			else if (shp.numofYetToStartCards().size() !=0) 
				{
					shp.startExam();
				}

			ExamInstructions.validateInstructionsPage();
		}

}
