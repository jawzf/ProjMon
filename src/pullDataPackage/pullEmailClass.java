package pullDataPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class pullEmailClass {
	
	public String getEmail(String custid) throws IOException
	{
		System.out.println("called");
		String e="";
		int responseCode = 0;
		String arr="";
		String api = "http://192.168.1.27:8080/OrderManagement/rest/om/profilePull/"+custid;
				
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
			JsonReader jsonReader = Json.createReader(new StringReader(new String(responseJson)));
			JsonObject jsonObj = jsonReader.readObject();
			jsonReader.close();
			System.out.println(jsonObj.toString());
			e=jsonObj.getJsonObject("customerdetails").getString("email");
			System.out.println(e);
			
		}
		return e;
	}

}
