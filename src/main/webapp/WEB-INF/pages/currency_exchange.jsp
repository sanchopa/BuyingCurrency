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
    <h2>Welcome: ${name}</h2>
    <form method="get" action="logout">
        <button>Logout</button>
    </form>
    <h1>Balance</h1>
<p>Balance RUB: ${balanceRUB}</p>
<p>Balance USD: ${balanceUSD}</p>
<p>Balance EUR: ${balanceEUR}</p>
    <h1>Pair</h1>
    <p>USD/RUB: ${usdrub}</p>
    <p>USD/EUR: ${usdeur}</p>
    <p>RUB/EUR: ${rubeur}</p>
</body>
</html>