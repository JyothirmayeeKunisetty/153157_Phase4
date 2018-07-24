<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Registration Page</title>
<style type="text/css">

function goBack() {
    window.history.back();
}

.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body bgcolor="lightblue">
	<div align="center">
	<h1>Registration Page</h1>
		<hr>
		<h2>Enter Your Details for Registration:</h2>
		<form:form action="successfullRegistrationPage" method="post"
				modelAttribute="customer">
		<table>
				<tr>
					<td>Name:</td>
					<td><form:input path="name" size="30"></form:input></td>
					<td><form:errors path="name" cssClass="error"></form:errors></td>
				</tr>
				<tr>
					<td>Mobile Number:</td>
					<td><form:input path="mobileNo" size="30"></form:input></td>
					<td><form:errors path="mobileNo" cssClass="error"></form:errors></td>
				</tr>
				<tr>
					<td>Wallet Balance:</td>
					<td><form:input path="wallet.balance" size="30"></form:input></td>
					<td><form:errors path="wallet.balance" cssClass="error"></form:errors></td>
				</tr>	
			</table>
			<br>
			<input type="submit" value="Register">
			</form:form>
		<br>
	</div>
<button onclick="goBack()">Go Back</button>
</body>
</html>