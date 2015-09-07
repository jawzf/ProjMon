package pullDataPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import servMon.contRun;

public class pullEmailClass {
	
	public String getEmail(int custid) throws IOException
	{
		
		InputStream iStream=contRun.class.getClassLoader().getResourceAsStream("url.properties");
		Properties props=new Properties();
		props.load(iStream);
		String yoorl=props.getProperty("url");
		String port=props.getProperty("port");		
		
		
		
		System.out.println("called");
		String e="";
		int responseCode = 0;
		String arr="";
		String api = "http://"+yoorl+":"+port+"/OrderManagement/rest/om/profilePull/"+custid;
				
		URL url = new URL(api);
		HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		httpConnection.connect();
		responseCode = httpConnection.getResponseCode();
		if (responseCode == 200) {
			BufferedReader br = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
			String str = "";
			StringBuilder responseJson = new StringBuilder();
			while ((str = br.readLine()) != null) {
				 responseJson.append(str);
			}
			System.out.println(responseJson);
			JsonReader jsonReader = Json.createReader(new StringReader(new String(responseJson)));
			JsonObject jsonObj = jsonReader.readObject();
			jsonReader.close();
			System.out.println(jsonObj.toString());
			e=jsonObj.getJsonObject("customerdetails").getString("email");
			System.out.println("Email:"+e);
			
		}
		return e;
	}

}
