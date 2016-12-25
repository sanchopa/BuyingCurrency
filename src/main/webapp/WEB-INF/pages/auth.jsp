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
      <label for="name">Login:</label>
      <input type="text" name="name" id="name" value="Ivan">
    </p>
    <p class="login-submit">
      <button type="submit" class="login-button">Enter</button>
    </p>
  </form>
</body>
</html>
