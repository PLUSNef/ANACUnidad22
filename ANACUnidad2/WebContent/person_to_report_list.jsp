<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person to report list</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
				<form action="PersonController">
					<input type="submit" name="btn_new" value="New" />
				</form>
			</th>
			<th>PersonId</th>
			<th>Name</th>
			<th>Report</th>
			<th>Relation</th>
			

		</tr>
		<c:forEach var="person" items="${persons}">
			<tr>
				<td>
					<form action="PersonController">
						<input type="hidden" name="id" value="${person.id}" /> <input
							type="submit" name="btn_edit" value="Edit" /> <input
							type="submit" name="btn_delete" value="Delete" />
					</form>
				</td>
				<td>${person.id}</td>
				<td>${person.name}</td>
				<td>${person.report}</td>
				<td>${person.relation}</td>


			</tr>
		</c:forEach>
	</table>
</body>
</html>