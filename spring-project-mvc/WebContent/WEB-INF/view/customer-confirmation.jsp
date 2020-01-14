<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Customer Confirmation Page</title>
</head>
<body>
	<h3>The customer is confirmed: ${customer.firstName} ${customer.lastName}</h3>
	<hr/>
	<h3>Course Code: ${customer.courseCode}</h3>
</body>
</html>