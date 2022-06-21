package com.gudexams.admin;

import java.util.Map;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.gudexams.adminpages.AdminLogin_po;
import com.gudexams.adminpages.ExamConfigurations_po;
import com.gudexams.annotations.FrameworkAnnotations;
import com.gudexams.enums.CategoryType;
import com.gudexams.exceptions.FrameworkExceptions;



public final class AdminLogin extends BaseTest
{
	static String sheetName = "Inst_data";
	
	@FrameworkAnnotations(category = { CategoryType.SMOKE })
	
	@Test
	public static void adminLoginPage(Map<String, String> data )
		{
			data.getOrDefault(data.get("sheetName"), sheetName);
			AdminLogin_po alp = new AdminLogin_po();

			Select rs = new Select(alp.selectRole());

			rs.selectByVisibleText(data.get("selectRole"));	
			alp.enterUserName(data.get("username")).enterPassword(data.get("password")).enterCaptch(data.get("role")).loginBtn();
		
			if (alp.loginMessage().size() !=0)
				{
					throw new FrameworkExceptions(alp.loginMessageText());
				}
			else if (alp.requiredMessage().size() !=0) 
				{
					throw new FrameworkExceptions("Failed to input the required values");
				}
			
			ExamConfigurations_po ec = new ExamConfigurations_po();
			
			ec.clickLinks("Exam Configurations");
			ec.clickLinks("Add Institutes");
			
			AddInstitute.addInstitute(data);
		}

}
