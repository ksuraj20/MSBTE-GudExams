/**
 * 
 */
package com.gudexams.functions;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebElement;


/**
 * @author suraj
 *
 */
public final class BrokenImage
{
	private BrokenImage() {}

	static int initialBrokenImageCount;
	static Map<Object, Object> getBrokenImagesDetails=new HashMap<>();

	public static void isBrokenImage(WebElement imageElementName)
		{
			try
				{
					HttpClient client = HttpClientBuilder.create().build();
					HttpGet requestGet = new HttpGet(imageElementName.getAttribute("src"));
					HttpResponse response = client.execute(requestGet);

					if(response.getStatusLine().getStatusCode() !=200)
						{
							initialBrokenImageCount++;
							getBrokenImagesDetails.put("Broken Img no. "+initialBrokenImageCount, "Image source is- "+ imageElementName.getAttribute("src"));
						}

				}
			catch (Exception e)
				{
					e.printStackTrace();
				}

		}
}
