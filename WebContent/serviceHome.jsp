<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
			url : "LatLongservlet",
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
							 infoWindow.setContent(markers[i][0]+"<br>"+"<form method=\"post\">" +
							 "<select>"+
							 "<option>a</option>"+
							 "<option>b</option>"+
							 "<option>c</option></select>"+
							 "<br><br>"+
							 "<input type=\"button\" value=\"Submit\">"+
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
</head>
<body onload="getMap()">
<%response.setIntHeader("Refresh", 10); %>
	<div id="map" style="width: 600px; height: 600px; margin-top: 10px;"></div>
</body>
</html>
