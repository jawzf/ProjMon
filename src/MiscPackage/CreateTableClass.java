package MiscPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import dbConnection.ConnectionProvider;

public class CreateTableClass {
	public void fillDummy()
	{
		try
		{
			Connection con;
			Statement stmt; 
		con=ConnectionProvider.getCon();
		stmt=con.createStatement();  
		
		String query="Insert into STATUSTABLE (EQUIPID,CUSTID,ADDRESS,EMAIL,STATUS) values ('987654','444444','Delhi','beingprax@gmail.com','UP')";
		stmt.executeUpdate(query);
		query="Insert into STATUSTABLE (EQUIPID,CUSTID,ADDRESS,EMAIL,STATUS) values ('C6D5','74hf74','Chennai','durejaishu@gmail.com','UP')";
		stmt.executeUpdate(query);
		query="Insert into STATUSTABLE (EQUIPID,CUSTID,ADDRESS,EMAIL,STATUS) values ('879gd65f','2122c3p0','Shimla','sushrutsood@gmail.com','UP')";
		stmt.executeUpdate(query);
		query="Insert into STATUSTABLE (EQUIPID,CUSTID,ADDRESS,EMAIL,STATUS) values ('hfjflkf8','nbvmjjff','Bangalore','karthika18j@gmail.com','UP')";
		stmt.executeUpdate(query);
		query="Insert into STATUSTABLE (EQUIPID,CUSTID,ADDRESS,EMAIL,STATUS) values ('123456','yoloyolo','New York','jokuriackal@gmail.com','UP')";
		stmt.executeUpdate(query);
		query="Insert into STATUSTABLE (EQUIPID,CUSTID,ADDRESS,EMAIL,STATUS) values ('4444','9797','6B,Block 3,Kences Brindavan, Kilpauk,Chennai','asd','UP')";
		stmt.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void createTables()
	{
try {
			
			Connection con;
			Statement stmt; 
		con=ConnectionProvider.getCon();
		stmt=con.createStatement();  
		
		String query="create table statusTable (equipID varchar(20) NOT NULL UNIQUE,custID varchar(20) NOT NULL,address varchar(30) NOT NULL,email varchar(30),status varchar(20) check( status in ('UP','DOWN','IN-PROGRESS')))";
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
		String query="create table downTable (equipID varchar(20) NOT NULL ,custID varchar(20) NOT NULL,address varchar(30) NOT NULL,email varchar(30) NOT NULL,status varchar(20) check( status in ('DOWN','IN-PROGRESS')))";
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
		String query="create table assignTable (equipID varchar(20) NOT NULL UNIQUE ,technicianID varchar(20) NOT NULL)";
		stmt.executeUpdate(query);
		System.out.println("dTa");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public static void main(String args[])
	{
		try {
			
			Connection con;
			Statement stmt; 
		con=ConnectionProvider.getCon();
		stmt=con.createStatement();  
		
		String query="create table statusTable (equipID varchar(20) NOT NULL UNIQUE,custID varchar(20) NOT NULL,address varchar(30) NOT NULL,email varchar(30),status varchar(20) check( status in ('UP','DOWN','IN-PROGRESS')))";
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
		String query="create table downTable (equipID varchar(20) NOT NULL ,custID varchar(20) NOT NULL,address varchar(30) NOT NULL,email varchar(30) NOT NULL,status varchar(20) check( status in ('DOWN','IN-PROGRESS')))";
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
		String query="create table assignTable (equipID varchar(20) NOT NULL UNIQUE ,technicianID varchar(20) NOT NULL)";
		stmt.executeUpdate(query);
		System.out.println("dTa");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
