/**
 * 
 */
package com.parsa.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * @author ramesh
 *
 */
public class DatabaseService {
	PropertiesService prop=new PropertiesService();
	

	Connection con=null;
	public Connection getDatabaseConnection() throws SQLException{
		if(con == null)
		{
		  if (prop != null && prop.getProperties() != null)
		  {
			  try {
				Class.forName(prop.getProperties().getProperty("dbdriver"));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  con =   DriverManager.getConnection(prop.getProperties().getProperty("url"), prop.getProperties().getProperty("dbuser"), prop.getProperties().getProperty("dbpassword"));
		  }
		}
		return con;
	}



}