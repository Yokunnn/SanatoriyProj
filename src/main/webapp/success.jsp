<%@ page import="com.example.sanatoriyproj.database.repository.TicketRepository" %>
<%@ page import="java.sql.Date" %>
<%@ page import="com.example.sanatoriyproj.model.Ticket" %>
<%@ page import="com.example.sanatoriyproj.database.repository.UserRepository" %>
<%@ page import="com.example.sanatoriyproj.model.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.12.2022
  Time: 0:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <title>Sanatoriy Project</title></head>
<body class="w3-light-blue">
<div class="w3-container w3-light-green w3-center">
  <h1>Sanatoriy Cheburashka</h1>
  <a href="/" class="w3-display-topleft">Vihodi-ka</a>
  <a href="/delete" class="w3-display-topRight">Udali-ka</a>
  <a href="/update" class="w3-display-topMiddle">Izmeni-ka</a>
</div>
<%
  String fio = request.getParameter("fio");
  String email = request.getParameter("email");
  String address = request.getParameter("address");
  String type = request.getParameter("type");
  String diet = request.getParameter("diet");
  User user = new User(fio, email, address);
  UserRepository userRepository = new UserRepository();
  int userID = userRepository.executeInsert(user);

  Ticket ticket = new Ticket(type, userID, "1000", diet, Date.valueOf("2023-01-02"), Date.valueOf("2023-01-09"));
  TicketRepository ticketRepository = new TicketRepository();
  int ticketID = ticketRepository.executeInsert(ticket);
%>
<h1 class="w3-center">Your userID = <%=userID%> and ticketID = <%=ticketID%>. Remember it for another operations.</h1>
</body>
</html>
