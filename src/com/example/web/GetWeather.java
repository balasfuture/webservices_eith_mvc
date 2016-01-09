package com.example.web;

import com.example.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class GetWeather extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		
		WebServicesExample services = new WebServicesExample();
		Map weatherDetails = services.postdata(city, country);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>"
					+"<body>"
					+"<h1 align=\"center\">Weather Update for the city "+city+"</h1>");
		
		
	
		if(weatherDetails.get("Status") == null){
			out.println("<h1 align=\"center\">The Weather Update for the city "+city+" is not currently available</h1>");
		}else{
			out.println("<h1 align=\"center\">Location: "+weatherDetails.get("Location")
			+"<br>"
			+"<h1 align=\"center\">Time: "+weatherDetails.get("Time")
			+"<br>"
			+"<h1 align=\"center\">Wind: "+weatherDetails.get("Wind")
			+"<br>"
			+"<h1 align=\"center\">Visibility: "+weatherDetails.get("Visibility")
			+"<br>"
			+"<h1 align=\"center\">SkyConditions: "+weatherDetails.get("SkyConditions")
			+"<br>"
			+"<h1 align=\"center\">Temperature: "+weatherDetails.get("Temperature")
			+"<br>"
			+"<h1 align=\"center\">DewPoint: "+weatherDetails.get("DewPoint")
			+"<br>"
			+"<h1 align=\"center\">RelativeHumidity: "+weatherDetails.get("RelativeHumidity")
			+"<br>"
			+"<h1 align=\"center\">Pressure: "+weatherDetails.get("Pressure")
			+"<br>");
		}
		
		out.println("</body>"
					+"</html>");
	}
}