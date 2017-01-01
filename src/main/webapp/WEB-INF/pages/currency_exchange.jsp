<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Currency exchange</title>
    <style>
        <%@include file='css/style.css' %>
    </style>
</head>
<body>
    <h1>Currency exchange</h1>
    <h1>Welcome: ${name}</h1>
    <form method="get" action="logout">
        <button>Logout</button>
    </form>
<p>Balance RUB: ${balanceRUB}</p>
<p>Balance USD: ${balanceUSD}</p>
<p>Balance EUR: ${balanceEUR}</p>
</body>
</html>