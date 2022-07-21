/**
 * 
 */
package com.gudexams.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gudexams.enums.ConfigProperties;
import com.gudexams.exceptions.DatabaseConnectivityDataFetchException;
import com.gudexams.utils.PropertyUtils;



/**
 * @author Suraj
 *
 */
public class DatabaseConnection
	{
		public static void main(String args[]) throws SQLException 
			{
				
				establishDatabaseConnection("SELECT * FROM users");
				
				
				/*
				String host="localhost:";
				int port=3306;

				Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://"+host+port+"/tkietgudexam", "sk1", "12345678");
				Statement s=con.createStatement();

				ResultSet rs=s.executeQuery("select * FROM users where username='TKIET'");

				rs.next();	//to move3 forward to next index, initial it is in zero index

				System.out.println("ID is "+rs.getString("uid"));
				
				 * System.out.println("Name is "+rs.getString("Name"));
				 * System.out.println("CountryCode is "+rs.getString("CountryCode"));
				 * System.out.println("District is "+rs.getString("District"));
				 * System.out.println("Population is "+rs.getString("Population"));
				 */
				
			}
		
		public static ResultSet establishDatabaseConnection(String executableQuery)
		{
			String host = PropertyUtils.get(ConfigProperties.DBHOST),
					port = String.valueOf(PropertyUtils.get(ConfigProperties.DBPORT)),
					dbUsername = PropertyUtils.get(ConfigProperties.DBUSERNAME),
					dbPassword = String.valueOf(PropertyUtils.get(ConfigProperties.DBPASSWORD)),
					dbName = PropertyUtils.get(ConfigProperties.DATABASENAME);
			
			try
				{
					Connection connection = DriverManager.getConnection("jdbc:mysql://"+host+port+"/"+dbName, dbUsername , dbPassword);
					Statement statement = connection.createStatement();
					ResultSet result = statement.executeQuery(executableQuery);
					result.next(); //to move forward to next index, initial it is in zero index
					
					return result;
				} catch (SQLException e)
				{
					throw new DatabaseConnectivityDataFetchException("Failed to establish the connection with Database ",e);
				}
			
		}
	}
