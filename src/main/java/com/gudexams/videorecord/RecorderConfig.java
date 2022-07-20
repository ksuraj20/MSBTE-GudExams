/**
 * 
 */
package com.gudexams.videorecord;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeSuite;

import atu.testrecorder.ATUTestRecorder;

/**
 * @author Suraj
 *
 */
public final class RecorderConfig
	{
		private RecorderConfig()
			{
			}

		private static ATUTestRecorder recorder;

		@BeforeSuite
		public static synchronized void startRecord()
			{
				DateFormat dateFormat = new SimpleDateFormat("YYYY-MMM-dd(E) (HH-mm-ss)");
				Date date = new Date();

				try
					{
						recorder = new ATUTestRecorder(
								".//atu-record-output//"+ dateFormat.format(date), true);
					} catch (Exception e)
					{
						e.printStackTrace();
					}

				try
					{
						recorder.start();
					} catch (Exception e)
					{
						e.printStackTrace();
					}
			}

		public static void stopRecorder()
			{
				try
					{
						recorder.stop();
					} catch (Exception e)
					{
						e.printStackTrace();
					}
			}
	}
