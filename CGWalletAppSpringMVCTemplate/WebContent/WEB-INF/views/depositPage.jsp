<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<script>
function goBack() {
    window.history.back();
}
</script>
<title>Deposit Page</title>
</head>
<body bgcolor="orchid">
<div align="center">
		<h1>Deposit Page</h1>
		<hr>
		<form action="successfullDepositPage" method="post">
			<table>
				<tr>
					<td>Enter Mobile Number to Deposit:</td>
					<td><input name="mobileNo" size="30"></input></td>
				</tr>
				<tr>
					<td>Enter Amount to Deposit:</td>
					<td><input name="wallet.balance" size="30"></input></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Deposit">
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