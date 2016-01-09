 <% page import="java.util.*" %>

<html>
<body>

<h1 align="center">Weather Update</h1>
<center>
	<p>
		Status : 
		<%
			String status = request.getAttribute("Status");
			out.print(status);
		%>
	</p>
</center>

</body>
</html>