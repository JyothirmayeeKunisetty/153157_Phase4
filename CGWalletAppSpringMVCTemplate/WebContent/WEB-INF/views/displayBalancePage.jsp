<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script>
function goBack() {
    window.history.back();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Balance</title>
</head>
<body bgcolor="violet">
	Welcome Mr./Mrs. <font size="5">${customer.name}</font><br><br>
	Current Wallet Balance: <b>${customer.wallet.balance}</b><br><br> 
</body>
<button onclick="goBack()">Go Back</button>
</html>