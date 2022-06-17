/**
 * 
 */
package com.gudexams.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


/**
 * @author suraj
 *
 */
public final class ImageComparisonUtils
{
	private ImageComparisonUtils() {}

	static final String BOTTOMPAD = "bottom";
	static final String RIGHTPAD = "right";


	public static BufferedImage getPageImage(BufferedImage source, int padding, String padType)
		{
			if(padding == 0)
				{
					return source;
				}

			BufferedImage newImage = new BufferedImage(source.getWidth(), source.getHeight() + padding, BufferedImage.TYPE_INT_ARGB);

			switch (padType)
			{
			case BOTTOMPAD:
				newImage = new BufferedImage(source.getWidth(), source.getHeight() + padding, BufferedImage.TYPE_INT_ARGB);
				break;

			case RIGHTPAD:
				newImage = new BufferedImage(source.getWidth() + padding, source.getHeight(), BufferedImage.TYPE_INT_ARGB);
				break;

			default :
				throw new  RuntimeException("Image padType not found");

			}

			Graphics2D g2 = newImage.createGraphics();
			g2.setPaint(Color.BLACK);
			g2.fillRect(0, 0, source.getWidth(), source.getHeight() + padding);
			g2.drawImage(source, null, 0, 0);
			return newImage;

		}

	public static void compareImages(BufferedImage actualImage, BufferedImage exceptedImage)
		{

			if(actualImage.getHeight() != exceptedImage.getHeight() || actualImage.getWidth() != exceptedImage.getWidth())
				{
					if(actualImage.getHeight() > exceptedImage.getHeight())
						{
							System.out.println("Due to image height difference, we are padding the excepted image to the bottom");
							exceptedImage = ImageComparisonUtils.getPageImage(exceptedImage, actualImage.getHeight() - exceptedImage.getHeight(), BOTTOMPAD);
						}
					else
						{
							System.out.println("Due to image height difference, we are padding the actual image to the bottom");
							actualImage = ImageComparisonUtils.getPageImage(actualImage, exceptedImage.getHeight() - actualImage.getHeight(), BOTTOMPAD);
						}

					if(actualImage.getWidth() > exceptedImage.getWidth())
						{
							System.out.println("Due to image width difference, we are padding the excepted image to the right");
							exceptedImage = ImageComparisonUtils.getPageImage(exceptedImage, actualImage.getWidth() - exceptedImage.getWidth(), RIGHTPAD);
						}
					else
						{
							System.out.println("Due to image width difference, we are padding the actual image to the right");
							actualImage =  ImageComparisonUtils.getPageImage(actualImage, exceptedImage.getWidth() - actualImage.getWidth(), RIGHTPAD);
						}
				}


		}

}
