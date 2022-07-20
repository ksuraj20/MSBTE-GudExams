/**
 * 
 */
package com.gudexams.admin;

import java.util.Map;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.gudexams.adminpages.AddInstitute_po;
import com.gudexams.annotations.FrameworkAnnotations;
import com.gudexams.constants.FrameworkConstants;
import com.gudexams.enums.CategoryType;
import com.gudexams.utils.DataProviderUtils;

/**
 * @author suraj
 *
 */
public class AddInstitute extends BaseTest
	{
		
		@FrameworkAnnotations(category = { CategoryType.SMOKE })
		@Test
		public static void addInstitute(Map<String, String> data)
		{
			DataProviderUtils.setSheetName(FrameworkConstants.getInstituteDataSheet());
			
			AddInstitute_po ai = new AddInstitute_po();
			Select ut = new Select(ai.userType());
			
			//Select Institute user type from dropdown
			ut.selectByIndex(0);
			
			//Get the input details from excel sheet
			ai.enterUsername(data.get("Username")).enterInstName(data.get("Inst_Name"));
			
			//Select region
			Select sr = new Select(ai.selectRegion());
			sr.selectByIndex(1);
			
			ai.enterInstEmail(data.get("Inst_Email")).enterInstMobile(data.get("Inst_Mobile_No")).instPassword(data.get("Inst_Password")).submitButton();
			
		}
		
	}
