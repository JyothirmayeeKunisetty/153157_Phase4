<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Request Balance Page</title>
<script>
function goBack() {
    window.history.back();
}
</script>

<style type="text/css">
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body bgcolor="violet">
	<div align="center">
		<h1>Request Balance Page</h1>
		<hr>
		<form action="displayBalancePage" method="post" name="balanceFrm">
			<table>
				<tr>
					<td>Enter Mobile Number to Display Balance:</td>
					<td><input name="mobileNo" size="30"></input></td>
				</tr>
			</table>
			<br> <input type="submit" value="Get Balance">
		</form>
		<font color="red">
			<c:if test="${not empty errorMessage}">
				${errorMessage}
			</c:if>
		</font>
	<button onclick="goBack()">Go Back</button>
	</div>
</body>
</html>