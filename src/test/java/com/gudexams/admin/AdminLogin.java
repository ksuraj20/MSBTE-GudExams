package com.gudexams.admin;

import java.util.Map;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.gudexams.adminpages.AdminLogin_po;
import com.gudexams.annotations.FrameworkAnnotations;
import com.gudexams.enums.CategoryType;
import com.gudexams.exceptions.FrameworkExceptions;
import com.gudexams.student.BaseTest;



public final class AdminLogin extends BaseTest
{
	@FrameworkAnnotations(category = { CategoryType.SMOKE })
	
	@Test
	public void adminLoginPage(Map<String, String> data)
		{

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
			
		}

}
