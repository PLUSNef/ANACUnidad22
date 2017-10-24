<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person to Report Form</title>
</head>
<body> 
	<form action="PersonController">
		<label>Name:</label>
		<br />
		<input type="text" name="name" value="${person.name}"/>
		<br />
		<label>Report:</label>
		<br />
		<input type="text" name="report" value="${person.report}"/>
		<br />
		<label>Relation:</label>
		<br />
		<input type="text" name="relation" value="${person.relation}"/>
		<br />
		<input type="submit" name="btn_save" value="Save" />
	</form>
</body>
</html>