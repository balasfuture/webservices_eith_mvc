# _webservices_with_mvc_

A sample project to explain MVC architecture with Web Services

**_Project Explanation_**  
    MVC architecture used by most of the web applications in order to seperate the view logic from business logic  
	This project will get the Current Weather Update for a particular city  
	The Wethaer update is provided by the website [WeahterUpadte](http://webservicex.com)  
	Here the user will give the input (View) and then the browser post the request to the controller (Controller).  
	The Controller invokes Model which in turn returns the result to the controller.  
	Once the Controller get the result , the controller forwards the result to the User (View).  
	In Model , by doing HTTP Post to the website [WeahterUpadte](http://webservicex.com) getting the weather update for the user requested city.

**_To Execute_**  
	copy the the [SourceFiles](https://github.com/balasfuture/webservices_with_mvc)  
	Using tomcat library compile the java files under src directory  
		cmd to compile : javac -classpath "<path_to_tomcat_server>\lib\servlet-api.jar;classes" -d classes src\<java_files>  
	Create the follwong folder structure under webapps in tomcat   
	mvc_webservices -> WEB-INF -> Classes  
	Please copy the files from webservices_with_mvc  
	* copy the index.html (inside web directory) to mvc_webservices  
	* copy the web.xml (inside etc directory) to WEB-INF in mvc_webservices  
	* copy the content in classes directory to clasess in WEB-INF in mvc_webservices  
	Launch the tomcat server and invoke the URL : localhost:<port_number>/mvc_webservices/index.html
	
	

	
	

	
