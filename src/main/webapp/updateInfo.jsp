<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.12.2022
  Time: 0:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Sanatoriy Project</title>
</head>
<body class="w3-light-blue">
<div class="w3-container w3-light-green w3-center">
    <h1>Sanatoriy Cheburashka</h1>
    <a href="/" class="w3-display-topleft">Vihodi-ka</a>
</div>
<div class="w3-card-4">
    <form method="post" class="w3-selection w3-light-green" action="/successUpdate">
        <label>FIO:
            <input type="text" name="updFio" class="w3-input w3-animate-input w3-border"><br/>
        </label>
        <label>ID:
            <input type="text" name="updID" class="w3-input w3-animate-input w3-border"><br/>
        </label>
        <label>New Address:
            <input type="text" name="updAddress" class="w3-input w3-animate-input w3-border"><br/>
        </label>
        <button type="submit" class="w3-btn w3-blue">Change address</button>
    </form>
</div>
</body>
</html>
