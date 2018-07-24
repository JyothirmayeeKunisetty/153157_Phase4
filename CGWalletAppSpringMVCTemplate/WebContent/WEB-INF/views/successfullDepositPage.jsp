<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function goBack() {
    window.history.back();
}
</script>

</head>
<body bgcolor="slateblue">
	Welcome Mr./Mrs. <font size="5">${customer.name}</font><br><br>
	You have successfully Deposited Amount...<br><br>
	Updated Wallet Balance: <b>${customer.wallet.balance}</b><br><br>
<button onclick="goBack()">Go Back</button>
</body>
</html>