package com.example.model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class WebServicesExample {

	public Map postdata(String city, String country) throws IOException {
		
		String url = "http://www.webservicex.net/globalweather.asmx/GetWeather";
		String USER_AGENT = "Mozilla/5.0";
		String urlParameters = "CityName="
				+city
				+"&CountryName="
				+country;
		
		Map<String, String> details = new HashMap<String, String>();
		URL urlObject = new URL(url);
		HttpURLConnection httpConnection = (HttpURLConnection) urlObject.openConnection();
		
		httpConnection.setRequestMethod("POST");
		httpConnection.setRequestProperty("User-Agent", USER_AGENT);
		httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		httpConnection.setRequestProperty("Content-length", "100");
		httpConnection.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = httpConnection.getResponseCode();
		
		String location = null;
		String time = null;
		String wind = null;
		String visibility = null;
		String skyconditions = null;
		String temperature = null;
		String dewpoint = null;
		String relativehumidity = null;
		String pressure = null;
		String status = null;
		
		try{
			Document doc1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new InputStreamReader(httpConnection.getInputStream())));
			String ex = doc1.getElementsByTagName("string").item(0).getTextContent();
			//System.out.println(ex);
			Document doc2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(ex)));
			location = doc2.getElementsByTagName("Location").item(0).getTextContent();
			time = doc2.getElementsByTagName("Time").item(0).getTextContent();
			wind = doc2.getElementsByTagName("Wind").item(0).getTextContent();
			visibility = doc2.getElementsByTagName("Visibility").item(0).getTextContent();
			skyconditions = doc2.getElementsByTagName("SkyConditions").item(0).getTextContent();
			temperature = doc2.getElementsByTagName("Temperature").item(0).getTextContent();
			dewpoint = doc2.getElementsByTagName("DewPoint").item(0).getTextContent();
			relativehumidity = doc2.getElementsByTagName("RelativeHumidity").item(0).getTextContent();
			pressure = doc2.getElementsByTagName("Pressure").item(0).getTextContent();
			status = doc2.getElementsByTagName("Status").item(0).getTextContent();
		}catch(ParserConfigurationException pe){
			
		}catch(SAXException se){
			
		}
		
		details.put("Location", location);
		details.put("Time", time);
		details.put("Wind", wind);
		details.put("Visibility", visibility);
		details.put("SkyConditions", skyconditions);
		details.put("Temperature", temperature);
		details.put("DewPoint", dewpoint);
		details.put("RelativeHumidity", relativehumidity);
		details.put("Pressure", pressure);
		details.put("Status", status);
		
		return details;
		
	}

}
