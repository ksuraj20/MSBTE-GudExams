/**
 * 
 */
package com.gudexams.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gudexams.enums.ConfigProperties;
import com.gudexams.exceptions.DatabaseConnectivityDataFetchException;
import com.gudexams.utils.PropertyUtils;

/**
 * @author Suraj
 *
 */
public class DatabaseConncetionAndDataRetrive
{
	private static Connection connection;
	private static List<Map<String, String>> list = null;

	public static void main(String[] args)
		{
			dbDataProvider("SELECT * FROM users", "username");
		}

	private static Connection establishDatabaseConnection()
		{
			String host = PropertyUtils.get(ConfigProperties.DBHOST),
					port = PropertyUtils.get(ConfigProperties.DBPORT),
					dbUsername = PropertyUtils.get(ConfigProperties.DBUSERNAME),
					dbPassword = PropertyUtils.get(ConfigProperties.DBPASSWORD),
					dbName = PropertyUtils.get(ConfigProperties.DATABASENAME);

			try
				{
					connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + dbName,
							dbUsername, dbPassword);
					return connection;
				} catch (SQLException e)
				{
					throw new DatabaseConnectivityDataFetchException(
							"Failed to establish the connection with Database ", e);
				}
		}

	private static void getDbData(String executableQuery)
		{
			connection = establishDatabaseConnection();

			try
				{
					Statement statement = connection.createStatement();
					ResultSet result = statement.executeQuery(executableQuery);
					//result.next();

					Map<String,String> map =null;
					list = new ArrayList<Map<String, String>>();

					int columnCount = result.getMetaData().getColumnCount();
					if (columnCount == 0)
						throw new DatabaseConnectivityDataFetchException(
								"Failed to retrive the data from givin table ");

					while(result.next())
						{
							map = new HashMap<String, String>(); 

							for(int j=1; j<=columnCount; j++)
								{
									String key = result.getMetaData().getColumnName(j);
									String value = result.getString(j);
									//System.out.println(key+"     "+value);
									map.put(key, value);
								}
							list.add(map);
						}

				} catch (SQLException e)
				{
					throw new DatabaseConnectivityDataFetchException(
							"Failed to establish the connection with Database ", e);
				}
		}

	public static void dbDataProvider(String sqlQuery, String dataParameter) 
		{
			getDbData(sqlQuery);

			for (Map<String, String> l2 : list)
				{
					System.out.println(l2.get(dataParameter));
				}
		}

}
