<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Welcome Page</title>
<script>
function goBack() {
    window.history.back();
}
</script>

</head>
<body bgcolor="pink">
<div>
	<br>
	Welcome Mr./Mrs. <font size="5">${customer.name}</font><br><br>
	Your Registered Mobile Number is: <b>${customer.mobileNo}</b><br><br>
	Current Wallet Balance: <b>${customer.wallet.balance}</b><br><br>
</div>
<button onclick="goBack()">Go Back</button>
</body>
</html>