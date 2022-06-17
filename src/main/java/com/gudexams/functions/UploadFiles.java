/**
 * 
 */
package com.gudexams.functions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * @author suraj
 *
 */
public final class UploadFiles
{
	private UploadFiles() {}
	static Robot robo;

	public static void uploadFile(String filePath)
		{
			try
				{
					robo = new Robot();
				} catch (AWTException e)
				{
					e.printStackTrace();
				}

			StringSelection selection = new StringSelection(filePath);// Enter file path
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);// Copy filepath to clipboard
			robo.setAutoDelay(3000);// To sleep for 3sec
			robo.keyPress(KeyEvent.VK_CONTROL);// To press the key
			robo.keyPress(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_CONTROL);// To release the key
			robo.keyRelease(KeyEvent.VK_V);
			robo.setAutoDelay(3000);
			robo.keyPress(KeyEvent.VK_ENTER);
		}
}
