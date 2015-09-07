package MiscPackage;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import servMon.contRun;
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
		
		String query="Insert into STATUSTABLE (EQUIPID,CUSTID,ADDRESS,EMAIL,STATUS) values ('987654',444444,'Delhi','beingprax@gmail.com','UP')";
		stmt.executeUpdate(query);
		query="Insert into STATUSTABLE (EQUIPID,CUSTID,ADDRESS,EMAIL,STATUS) values ('C6D5',744474,'Chennai','durejaishu@gmail.com','UP')";
		stmt.executeUpdate(query);
		query="Insert into STATUSTABLE (EQUIPID,CUSTID,ADDRESS,EMAIL,STATUS) values ('879gd65f',2122000,'Shimla','sushrutsood@gmail.com','UP')";
		stmt.executeUpdate(query);
		query="Insert into STATUSTABLE (EQUIPID,CUSTID,ADDRESS,EMAIL,STATUS) values ('hfjflkf8',747474,'Bangalore','karthika18j@gmail.com','UP')";
		stmt.executeUpdate(query);
		query="Insert into STATUSTABLE (EQUIPID,CUSTID,ADDRESS,EMAIL,STATUS) values ('123456',888888,'New York','jokuriackal@gmail.com','UP')";
		stmt.executeUpdate(query);
		query="Insert into STATUSTABLE (EQUIPID,CUSTID,ADDRESS,EMAIL,STATUS) values ('4444',4565655,'6B,Block 3,Kences Brindavan, Kilpauk,Chennai','asd','UP')";
		stmt.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void createTables()
	{
		InputStream iStream=contRun.class.getClassLoader().getResourceAsStream("url.properties");
		Properties props=new Properties();
		try {
			props.load(iStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String id=props.getProperty("provId");
			
try {
			
			Connection con;
			Statement stmt; 
		con=ConnectionProvider.getCon();
		stmt=con.createStatement();  
		
		String query="create table statusTable (equipID varchar(20) NOT NULL UNIQUE,custID number(20) NOT NULL,address varchar(60) NOT NULL,email varchar(30),status varchar(20) check( status in ('UP','DOWN','IN-PROGRESS')))";
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
		String query="create table downTable (equipID varchar(20) NOT NULL ,custID number(20) NOT NULL,address varchar(60) NOT NULL,email varchar(30) NOT NULL,status varchar(20) check( status in ('DOWN','IN-PROGRESS')))";
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
		String query="create table assignTable (equipID varchar(20) NOT NULL UNIQUE ,technicianID varchar(20) NOT NULL UNIQUE)";
		stmt.executeUpdate(query);
		System.out.println("dTa");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//View Creation
		
		
		
		
		try {
			
			Connection con;
			Statement stmt; 
		con=ConnectionProvider.getCon();
		stmt=con.createStatement();  
		System.out.println("bs:"+id);
		String query="create or replace view equipment as select ont_id as equipid,customer_id as custid from "+id+".ont union all SELECT pon_port_id as equipid, customer_id as custid from "+id+".ont";
		stmt.executeUpdate(query);
		System.out.println("equV");
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
try {
			
			Connection con;
			Statement stmt; 
		con=ConnectionProvider.getCon();
		stmt=con.createStatement();  
		String query="create or replace view addView as select customer_id as custid,concat(concat(concat(concat(streetname,','),city),','),state) as address from "+id+".customer";
		stmt.executeUpdate(query);
		System.out.println("addV");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			
			Connection con;
			Statement stmt; 
		con=ConnectionProvider.getCon();
		stmt=con.createStatement();  
		String query="create or replace view proView as select equipment.equipid,equipment.custid,addview.address from equipment left join addview on equipment.custid=addview.custid";
		stmt.executeUpdate(query);
		System.out.println("proV");
		
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
