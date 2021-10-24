<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String name = request.getParameter("name");
    String course = request.getParameter("course");
    float fee = Float.parseFloat(request.getParameter("fee"));
	
%>
Name is: <%= name %> <br/>
course is: <%= course %> <br/>
Fee is: <%= fee %> <br/>

<jsp:useBean id="s1" class="com.ducat.Student">
<jsp:setProperty name="s1" property="name" value="<%= name %>"/>
<jsp:setProperty name="s1" property="course" value="<%= course %>" />
<jsp:setProperty name="s1" property="fee" value="<%= fee %>"/>
</jsp:useBean>
Name : - <jsp:getProperty property="name" name="s1"/><br/>
<%  if(s1.save()){ %>
<font color='green'>Student successfully registered</font>
<%}else{ %>
<font color='red'>Student registraton fail</font>
<%} %>
</body>
</html>