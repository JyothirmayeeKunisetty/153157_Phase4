<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request to View All Customers</title>
</head>
<body bgcolor="lightblue">
<br>
<div align="center">
<h1>Request to View Filtered Customers</h1>
<hr>
<form action="filteredCustomersPage" method="post">
			<table>
				<tr>
					<td>Enter Amount:</td>
					<td><input name="amount" size="30"></input></td>
				</tr>
			</table>
			<br> <input type="submit" value="Get Filtered Customers">
		</form>
	</div>
</body>
</html>