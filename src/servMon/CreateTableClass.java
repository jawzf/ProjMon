package servMon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableClass {
	public static void main(String args[])
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con;
			Statement stmt; 
		con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger"); 
		stmt=con.createStatement();  
		String query="create table statusTable (equipID number NOT NULL UNIQUE,custID number NOT NULL,status varchar(10) check( status in ('UP','DOWN','IN-PROGRESS')))";
		stmt.executeUpdate(query);
		
		query="create table downTable (equipID number NOT NULL ,custID number NOT NULL,status varchar(10) check( status in ('DOWN','IN-PROGRESS')))";
		stmt.executeUpdate(query);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con;
			Statement stmt; 
		con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger"); 
		stmt=con.createStatement();  
		String query="create table downTable (equipID number NOT NULL ,custID number NOT NULL,status varchar(10) check( status in ('DOWN','IN-PROGRESS')))";
		stmt.executeUpdate(query);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
