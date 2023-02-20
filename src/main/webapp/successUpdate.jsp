<%@ page import="com.example.sanatoriyproj.database.repository.UserRepository" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.12.2022
  Time: 13:02
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
    String fio = request.getParameter("updFio");
    int id = Integer.parseInt(request.getParameter("updID"));
    String address = request.getParameter("updAddress");
    UserRepository userRepository = new UserRepository();
    int c = -1;
    c = userRepository.executeUpdate(String.format("UPDATE users SET address = '"+address+"' WHERE id = %d;", id));
//    if (userRepository.find(id).getFIO().matches(fio)){
//        c = userRepository.executeUpdate(String.format("UPDATE users SET address = '"+address+"' WHERE id = %d;", id));
//    }
%>
<h1 class="w3-center">Number of affected = <%=c%>.</h1>
</body>
</html>
