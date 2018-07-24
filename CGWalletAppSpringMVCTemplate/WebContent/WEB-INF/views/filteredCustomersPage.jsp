<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Customers</title>

</head>
<body bgcolor="gray">
<h2>Details of All Customers whose Balance is below Minimum Balance</h2>
<hr>
	
<table border="1px">
		<tr bgcolor="pink">
			<td><b>Customer</b></td>
			<td><b>Mobile Number</b></td>
			<td><b>Wallet Balance</b></td>
		</tr>

	<c:forEach items="${customer}" var="customer">
		<tr bgcolor="lightblue">
			<td>${customer.name}</td>
			<td>${customer.mobileNo}</td>
			<td>${customer.wallet.balance}</td>
		</tr>
	</c:forEach>
	
</table>
</body>
</html>