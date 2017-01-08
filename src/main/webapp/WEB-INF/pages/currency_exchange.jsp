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
<body class="currency_exchange">
<div class="header">
    <h1>Currency exchange</h1>
</div>
<div class="block1">
    <div class="balance">
        <h2>Balance</h2>
        <p>Balance USD: ${balanceUSD}</p>
        <p>Balance RUB: ${balanceRUB}</p>
        <p>Balance EUR: ${balanceEUR}</p>
    </div>
    <div class="pair">
        <h2>Pair</h2>
        <p>USD/RUB: ${usdrub}</p>
        <p>EUR/RUB: ${eurrub}</p>
        <p>EUR/USD: ${eurusd}</p>
    </div>
</div>
<div class="block2">
<div class="welcome">
    <form method="get" action="logout">
        <label id="name" for="logout">${name}</label>
        <button id="logout">Logout</button>
    </form>

</div>
<div class="buy">
    <h2>Buy currency</h2>
    <form action="buy" method="post">
        <p><label for="currency1">Buy currency</label>
        <select id="currency1" name="currency1">
            <option value="USD">USD</option>
            <option value="RUB">RUB</option>
            <option value="EUR">EUR</option>
        </select></p>
        <p><label for="currency2">for</label>
        <select id="currency2" name="currency2">
            <option value="USD">USD</option>
            <option value="RUB">RUB</option>
            <option value="EUR">EUR</option>
        </select></p>
        <label for="sum">Sum:</label>
        <input type="text" name="sum" id="sum" value="0">
        <p><input type="submit" value="Buy"></p>
    </form>
</div>
</div>
<div class="history">
    <h2>History operation</h2>
    <p>${history}</p>
</div>
</body>
</html>