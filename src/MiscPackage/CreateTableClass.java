package MiscPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import dbConnection.ConnectionProvider;

public class CreateTableClass {
	public static void main(String args[])
	{
		try {
			
			Connection con;
			Statement stmt; 
		con=ConnectionProvider.getCon();
		stmt=con.createStatement();  
		
		String query="create table statusTable (equipID varchar(20) NOT NULL UNIQUE,custID varchar(20) NOT NULL,address varchar(30) NOT NULL,email varchar(30),status varchar(10) check( status in ('UP','DOWN','IN-PROGRESS')))";
		stmt.executeUpdate(query);
		System.out.println("sTa");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			
			Connection con;
			Statement stmt; 
		con=ConnectionProvider.getCon();
		stmt=con.createStatement();  
		String query="create table downTable (equipID varchar(20) NOT NULL ,custID varchar(20) NOT NULL,address varchar(30) NOT NULL,email varchar(30) NOT NULL,status varchar(10) check( status in ('DOWN','IN-PROGRESS')))";
		stmt.executeUpdate(query);
		System.out.println("dTa");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} try {
			
			Connection con;
			Statement stmt; 
		con=ConnectionProvider.getCon();
		stmt=con.createStatement();  
		String query="create table assignTable (equipID varchar(20) NOT NULL ,technicianID varchar(20) NOT NULL)";
		stmt.executeUpdate(query);
		System.out.println("dTa");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
