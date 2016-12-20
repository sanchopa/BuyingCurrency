<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<title>Enter currency exchange</title>
    <style>
        <%@include file='css/style.css' %>
    </style>
</head>
<body>
  <form method="post" action="/currency_exchange">
  <h1>Enter currency exchange</h1>
    <p>
      <label for="login">Login:</label>
      <input type="text" name="login" id="login" value="Ivan">
    </p>
    <p>
      <label for="password">Password:</label>
      <input type="text" name="password" id="password" value="0000">
    </p>
    <p class="login-submit">
      <button type="submit" class="login-button">Enter</button>
    </p>
  </form>
</body>
</html>
