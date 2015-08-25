<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Monitoring UI</title>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false">
	
</script>
<script src="js/jquery-1.11.1.js"></script>

<script>



    
	var bounds = new google.maps.LatLngBounds();
	var markers = [];
	var map=null;
	function loadData() {
		$.ajax({
			url : "mapServlet",
			type : 'GET',
			datatype: 'json',
			success : function(result) {
				
			},
		complete: function(jqxhr,status)
			{
				console.log(jqxhr.responseText);
				showMap(jqxhr.responseText);
			}
		});
		
		
	
	}

	
	 
	function getMap() {
		loadData();
		
	}
	
			function showMap(result) {
				markers=JSON.parse(result);	
				
				var latlngPos = new google.maps.LatLng(13.0826802, 80.27071840000001);
				var myOptions = {
					zoom : 10,
					center : latlngPos,
					mapTypeId : google.maps.MapTypeId.ROADMAP
				};
				map = new google.maps.Map(document.getElementById("map"), myOptions);

				console.log(markers);
				/*var markers = [ [ 'Chennai', 13.0826802, 80.27071840000001],
						[ 'Delhi', 28.6139391, 77.2090212],
						[ 'Mumbai', 19.0759837, 72.87765589999999] ];*/
				var infoWindow = new google.maps.InfoWindow(), marker, i;
				for (i = 0; i < markers.length; i++) {
					var position = new google.maps.LatLng(markers[i][1],
							markers[i][2]);
					bounds.extend(position);
					marker = new google.maps.Marker({
						position : position,
						map : map,
						title : markers[i][0]
					});
					google.maps.event.addListener(marker, 'click', (function(
							marker, i) {
						return function() {
							 infoWindow.setContent(markers[i][0]+"<br>"+"<form method=\"post\" action=\"techServ\">" +
									
							 "<select name=\"technician_id\">"+
							 "<option>T01501</option>"+
							 "<option>T01502</option>"+
							 "<option>T01503</option></select>"+
							 "<br><br>"+
							 "<input type=\"button\" value=\"Submit\">"+
							 "<input type=\"hidden\" name=\"address\" value=position>"+
							 "</form>");
							infoWindow.open(map, marker); 
							this.setIcon('https://www.google.com/mapfiles/marker_green.png');
							//getAddress(marker.latLng);
 						
						}
					})(marker, i));

					
					map.fitBounds(bounds);
				}
			}
			
</script>
<script>
var txt;
var jSON;
var cont;
function check(conta)
{
	cont=conta;
	$.ajax({
		url : "jobServ",
		type : 'GET',
		datatype: 'json',
		success : function(result) {
			
		},
	complete: function(jqxhr,status)
		{
			console.log(jqxhr.responseText);
			txt=jqxhr.responseText;
			txt = txt.substring(0, txt.length - 2);
			txt=txt+']';
			console.log(txt);
			
			jSON=JSON.parse(txt);
			createSel();
		}
	});
	}
	
function createSel()
{
	var doo = document.getElementById("jobs");
	var div = document.getElementById("infodiv").contains(doo);
	if(!div)
	{	
			console.log(jSON[0].equipID+jSON[0].address);
			var newDiv=document.createElement('div');
			var html = '<select name=\'equipid\' id=\'jobs\'>',i;
			
			for(i = 0; i < jSON.length; i++) {
			       html += "<option value='"+jSON[i].equipID+"'>"+jSON[i].equipID+"</option>";
			   }
			
			html += '</select>';
			   newDiv.innerHTML= html;
			   document.getElementById(cont).appendChild(newDiv);
			   
			   document.getElementById("subBtn").style.visibility = "visible";
	}
	
	}


</script>


<script>
function popitup(link) {
	  var w = window.open(link.href,
	        link.target||"_blank",
	        'menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=no,resizable=no,dependent,width=500,height=250,left=0,top=0');
	  return w?false:true; // allow the link to work if popup is blocked
	 }
</script>
</head>
<body onload="getMap()">
<%response.setIntHeader("Refresh", 15); %>
<% //HttpSession equipment=request.getSession();  //(String)equip.getAttribute("equip"); %>

<h2 align="center">Network Monitoring Status</h2><h3 align="right"><a href="LoginForm.jsp">Logout</a></h3>

	<center><div id="map" style="width: 800px; height: 400px; margin-top: 10px;"></div></center><br>
	<br>
	<center>
	<input type=button value="Show Down Devices" id="scanBtn" onClick="check('infodiv')">
	<form action="resp_serv" method="post">
	<div id="infodiv"></div>
	<input type=submit value="Job Done" id="subBtn" style="visibility:hidden">
	</form>
	</center>
	
	<center><b><a href="sched_down.jsp" onclick="return popitup(this)">Schedule Downtime</a></b></center>

	 </body>
</html>
