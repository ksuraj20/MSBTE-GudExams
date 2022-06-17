package com.gudexams.utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import com.gudexams.constants.FrameworkConstants;
import com.gudexams.enums.ConfigProperties;
import com.gudexams.exceptions.PropertyFileReadException;

public final class PropertyUtils
{

	private PropertyUtils() {}

	private static Properties pro = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<String, String>();
	static
	{
		try
		{
			FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigfilePath());
			pro.load(fis);

			for(Entry<Object, Object> entry: pro.entrySet())
				{
					CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
				}

		} 
		catch (Exception e)
			{
				e.printStackTrace();
			} 

	}

	public static String get(ConfigProperties key) 
		{
			if(Objects.isNull(key) || Objects.isNull(CONFIGMAP))
				{
					throw new PropertyFileReadException("Property name "+ key +" is not found. Please check ReadPropertyFile class");
				}
			return CONFIGMAP.get(key.name().toLowerCase());
		}

}
