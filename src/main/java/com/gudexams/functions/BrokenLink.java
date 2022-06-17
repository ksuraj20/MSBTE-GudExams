/**
 * 
 */
package com.gudexams.functions;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * @author suraj
 *
 */
public final class BrokenLink
{
	private BrokenLink() {}

	public static void isLinkBroken(String inputURL)
		{
			try {
				URL url = new URL(inputURL);
				HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
				connection.setConnectTimeout(5000);
				connection.connect();

				if (connection.getResponseCode() >=404)
					{
						System.out.println(inputURL +" "+ connection.getResponseMessage()+" is broken link");
					}
				else
					{
						System.out.println(inputURL +" "+ connection.getResponseMessage());
					}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
}
