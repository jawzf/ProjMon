package serviceUIPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;
import java.util.Timer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonValue;

/**
 * Servlet implementation class LatLongservlet
 */
@WebServlet("/mapServlet")
public class mapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
static Timer timer;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public mapServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	 protected void doGet(HttpServletRequest request, HttpServletResponse
	 response) throws ServletException, IOException {
		 linkMapClass li=new linkMapClass();
		
		 String addressArr[]= li.getAddresses();
		 String equip_id[]=li.equip_id();
		 HttpSession equip=request.getSession();
		equip.setAttribute("equip", equip_id);
		 String jsonArr="[";
		 try {
				
				for(int i=0;i<addressArr.length;i++)
				{
					jsonArr+=getLatLongPositions(addressArr[i]);
					if(i!=addressArr.length-1)
					{
						jsonArr+=",";
					}
					else
						break;
				}	
				jsonArr+="]";
				System.out.println(jsonArr);
				response.setContentType("application/json");
				response.getWriter().print(jsonArr);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	
	 
	 
	
	 
	 
	 
	 
	 
	public static String getLatLongPositions(String address) throws Exception {
		int responseCode = 0;
		String arr="";
		String api = "https://maps.googleapis.com/maps/api/geocode/json?address="
				+ URLEncoder.encode(address, "UTF-8") + "&sensor=true&key=";
		System.out.println("EDIT CODE WITH API KEY");
		URL url = new URL(api);
		HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		httpConnection.connect();
		responseCode = httpConnection.getResponseCode();
		if (responseCode == 200) {
			BufferedReader br = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
			String str = "";
			StringBuilder responseJson = new StringBuilder();
			while ((str = br.readLine()) != null) {
				System.out.println(str);
				responseJson.append(str);

			}
			JsonReader jsonReader = Json.createReader(new StringReader(new String(responseJson)));
			JsonObject jsonObj = jsonReader.readObject();
			jsonReader.close();
			JsonArray resultsArr=jsonObj.getJsonArray("results");
			JsonNumber lat=resultsArr.getJsonObject(0).getJsonObject("geometry").getJsonObject("location").getJsonNumber("lat");
			JsonNumber lng=resultsArr.getJsonObject(0).getJsonObject("geometry").getJsonObject("location").getJsonNumber("lng");
			arr="[\""+address+"\","+lat+","+lng+"]";
			//System.out.println(arr);
			timer = new Timer();
	        //timer.schedule(new LinkServlet(),0, 10*1000);
		}
		return arr;
	}
	
	//public String getAddress(double lat,double lng) throws IOException
	public static void main(String[] args) throws IOException 
		
	
	{
		int responseCode = 0;
		String addr="";
		String api = "https://maps.googleapis.com/maps/api/geocode/json?latlng=44.4647452,7.3553838&sensor=true";
		//System.out.println("EDIT CODE WITH API KEY");
		URL url = new URL(api);
		HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		httpConnection.connect();
		responseCode = httpConnection.getResponseCode();
		if (responseCode == 200) {
			BufferedReader br = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
			String str = "";
			StringBuilder responseJson = new StringBuilder();
			while ((str = br.readLine()) != null) {
				System.out.println(str);
				responseJson.append(str);
 
			}
			JsonReader jsonReader = Json.createReader(new StringReader(new String(responseJson)));
			JsonObject jsonObj = jsonReader.readObject();
			System.out.println(jsonObj.toString());
			jsonReader.close();
			JsonArray resultsArr=jsonObj.getJsonArray("results");
			JsonNumber address=(JsonNumber) resultsArr.getJsonObject(0).getJsonObject("formatted_address");
//			JsonNumber lng=resultsArr.getJsonObject(0).getJsonObject("geometry").getJsonObject("location").getJsonNumber("lng");
//			addr="[\""+address+"\","+lat+","+lng+"]";
//			//System.out.println(arr);
//			timer = new Timer();
//	        //timer.schedule(new LinkServlet(),0, 10*1000);
		}
		//return addr;

		
		
		
	}
}
