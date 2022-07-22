/**
 * 
 */
package com.gudexams.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Suraj
 *
 */
public class DataProviderUtilsDB
	{
		//private static List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		
		public static Map<String, List<String>> dbData(List<Map<String, String>> list)
		{
			list = new ArrayList<Map<String,String>>();
			Map<String, List<String>> map = new HashMap<>();
			for (Map<String, String> m : list) {
			  for (Map.Entry<String, String> e : m.entrySet()) {
			    String key = e.getKey();
			    if (map.containsKey(key)) {
			      map.put(key, new ArrayList<String>());
			    }
			    map.get(key).add(e.getValue());
			  }
			}
			return map;
		}
	}
