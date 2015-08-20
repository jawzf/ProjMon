package servMon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class testClass {
	public static void main(String args[])
	{
		try
		{
			URL url = new URL("http://localhost:8079/MonitServ/testServlet");
			/*URLConnection myURLConnection = myURL.openConnection();
			myURLConnection.connect();*/
			
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())); 
			String line = in.readLine(); 

			System.out.println( line );	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
