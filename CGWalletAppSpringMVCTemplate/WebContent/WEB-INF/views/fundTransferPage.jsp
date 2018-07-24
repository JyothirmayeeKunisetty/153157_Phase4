<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function goBack() {
    window.history.back();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fund Transfer Page</title>
</head>
<body bgcolor="lightsteelblue">

<div align="center">
		<h1>Funds Transfer Page</h1>
		<hr>
		<form action="successfullFundTransferPage" method="post">
			<table>
				<tr>
					<td>Enter Source Mobile Number to transfer</td>
					<td><input name="sourceMobileNo" size="30"></input></td>
				</tr>
				<tr>
					<td>Enter Destination Mobile Number </td>
					<td><input name="targetMobileNo" size="30"></input></td>
				</tr>
				<tr>
					<td>Enter Amount to transfer:</td>
					<td><input name="wallet.balance" size="30"></input></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Transfer">
		</form>
		<font color="red">
			<c:if test="${not empty errorMessage}">
				${errorMessage}
			</c:if>
		</font>
</div>
<button onclick="goBack()">Go Back</button>
</body>
</html>