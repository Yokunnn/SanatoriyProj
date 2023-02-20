<%@ page import="com.example.sanatoriyproj.model.User" %>
<%@ page import="com.example.sanatoriyproj.model.Ticket" %>
<%@ page import="com.example.sanatoriyproj.database.repository.UserRepository" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="com.example.sanatoriyproj.database.repository.TicketRepository" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.12.2022
  Time: 20:24
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
    <a href="/delete" class="w3-display-topRight">Udali-ka</a>
    <a href="/update" class="w3-display-topMiddle">Izmeni-ka</a>
</div>
<div class="w3-card-4">
    <form method="post" class="w3-selection w3-light-green" action="/success">
        <label>FIO:
            <input type="text" name="fio" class="w3-input w3-animate-input w3-border"><br/>
        </label>
        <label>Email:
            <input type="text" name="email" class="w3-input w3-animate-input w3-border"><br/>
        </label>
        <label>Address:
            <input type="text" name="address" class="w3-input w3-animate-input w3-border"><br/>
        </label>
        <label>Ticket type:
            <input type="text" name="type" class="w3-input w3-animate-input w3-border"><br/>
        </label>
        <label>Diet(luxury/no diet):
            <input type="text" name="diet" class="w3-input w3-animate-input w3-border"><br/>
        </label>
        <button type="submit" class="w3-btn w3-blue">Create user and ticket</button>
    </form>
</div>
</body>
</html>
