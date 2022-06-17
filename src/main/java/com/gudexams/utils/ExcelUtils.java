package com.gudexams.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gudexams.constants.FrameworkConstants;
import com.gudexams.exceptions.InvalidFilePath;

public final class ExcelUtils
{
	private ExcelUtils() {}

	public static List<Map<String, String>> getTestDetails(String sheetName) 
		{
			List<Map<String, String>> list = null;

			try
			{
				FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelFilePath());
				@SuppressWarnings("resource")
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet sheet = workbook.getSheet(sheetName);

				int lastRowNum = sheet.getLastRowNum();
				int lastClmnNum = sheet.getRow(0).getLastCellNum();

				Map<String,String> map =null;
				list = new ArrayList<Map<String, String>>();

				for(int i=1; i<=lastRowNum;i++) 
					{ 
						map = new HashMap<String, String>(); 
						for(int j=0;j<lastClmnNum;j++) 
							{
								String key= sheet.getRow(0).getCell(j).getStringCellValue();
								String value = sheet.getRow(i).getCell(j).getStringCellValue();
								map.put(key, value);
							}
						list.add(map);

					} 
			}
			catch (FileNotFoundException e)
				{
					throw new InvalidFilePath("Excel file is not find, Please check the file path");
				} catch (IOException e)
				{
					e.printStackTrace();
				}

			return list;



		}
}
