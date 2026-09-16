package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;
	public void getDbconnection(String url,String username,String password){
	try{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(url,username,password);
	}catch (Exception e) {}
	}
	
	public void getDbconnection(){
		try{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "admin123");
		}catch (Exception e) {}
		}
	public void closeDbConnection() throws SQLException{
		conn.close();
	}
	public ResultSet executeConSelectQuery(String query) throws SQLException {
		ResultSet resutSet=null;
		try {
			Statement stat = conn.createStatement();
			 resutSet = stat.executeQuery(query);
		} catch (Exception e) {}
		return resutSet;
	}
	public int executeConNonSelectQuery(String query) {
		int result=0;
		try {
			Statement stat = conn.createStatement();
			 stat.executeUpdate(query);
		} catch (Exception e) {}
		return result;
		
	}
}
