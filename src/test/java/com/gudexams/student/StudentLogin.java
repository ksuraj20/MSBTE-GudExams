package com.gudexams.student;

import java.util.Map;

import org.testng.annotations.Test;

import com.gudexams.annotations.FrameworkAnnotations;
import com.gudexams.constants.FrameworkConstants;
import com.gudexams.enums.CategoryType;
import com.gudexams.exceptions.FrameworkExceptions;
import com.gudexams.studentpages.StudentLogin_po;
import com.gudexams.utils.ImageComparisonUtils;


public final class StudentLogin extends BaseTest

{	
	private StudentLogin() {} 

	@FrameworkAnnotations(category = { CategoryType.SMOKE })
	@Test 
	public  void StudentLogin1(Map<String, String> data) 
		{

			ImageComparisonUtils.getPageImage(FrameworkConstants.bufferImagePath(), 0, "bottom");

			StudentLogin_po slp = new StudentLogin_po();
			slp.enterUserName(data.get("username")).enterPassword(data.get("password"));
			slp.enterCaptch(data.get("role")).checkBox1().checkBox2().loginBtn();

			if (slp.loginMessage().size() !=0)
				{
					throw new FrameworkExceptions(slp.loginMessageText());
				}
			else if (slp.requiredMessage().size() !=0) 
				{
					throw new FrameworkExceptions("Failed to input the required values");
				}

			else
				{
					StudentHome.StudentHomePageValidation();
				}

		}

}
