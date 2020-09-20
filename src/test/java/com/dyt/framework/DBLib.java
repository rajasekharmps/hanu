package com.dyt.framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dyt.hrm.config.Configuration;

public class DBLib extends Configuration{
	
	Connection conn = null;
	Statement stmt = null;
	
	//=================================
	public void DBConnection()
	{
		try {
			System.out.println("Connecting  to a selected database.");
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");			
		    conn = DriverManager.getConnection(DB_DETAILS, DB_USER, DB_PWD); 
		    System.out.println("Connected database successfully.");
		    System.out.println("Creating statement...");
		    stmt = conn.createStatement();
		}
		catch(Exception e) {
			System.out.println("DB Connection failed.");
			e.printStackTrace();
		}
	}
	//=================================
	public String[] getData(String sqlQuery)
	{
		DBConnection();
		String[] arr = new String[10];
		try {
			ResultSet rs = stmt.executeQuery(sqlQuery);
		    int i=0;		   
		    while(rs.next())
		    {		         
		   	 arr[i]  = rs.getString("us_name");		   	 
		   	 i++;	       
		    }
		    rs.close();
		}

		catch(SQLException se){	     
	      se.printStackTrace();
	   }
		catch(Exception e){     
			e.printStackTrace();
		}
		return arr;
	}
	//=================================
	
	public static void main(String[] args) {
		DBLib obj = new DBLib();
		String query = "SELECT * from user_profile";
		String[] data = obj.getData(query);
		for(String x : data)
			if (x!= null)
				System.out.println(x);		
	} 
}
