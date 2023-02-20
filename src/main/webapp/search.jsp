<%@ page import="com.example.sanatoriyproj.database.repository.UserRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.sanatoriyproj.model.User" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.stream.Collectors" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 08.01.2023
  Time: 14:39
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
    <form method="post" class="w3-selection w3-light-green" action="/search">
        <label>Name filter:
            <input type="text" name="nameF" class="w3-input w3-animate-input w3-border"><br/>
        </label>
        <label>Email filter (string after @):
            <input type="text" name="emailF" class="w3-input w3-animate-input w3-border"><br/>
        </label>
        <label>ID filter (< > =):
            <input type="text" name="IDF" class="w3-input w3-animate-input w3-border"><br/>
        </label>
        <button type="submit" class="w3-btn w3-blue">Search</button>
    </form>
</div>
<%
    UserRepository userRepository = new UserRepository();
    StringBuilder queryBuilder = new StringBuilder();
    queryBuilder.append("SELECT * FROM users");

    String nameF = request.getParameter("nameF");
    String emailF = request.getParameter("emailF");
    String IDF = request.getParameter("IDF");
    if (nameF != null || emailF != null || IDF != null) {
        queryBuilder.append(" WHERE ");
        if (nameF != null) {
            queryBuilder.append("fio LIKE '" + nameF + "%'");
            if (emailF != null || IDF != null) {
                queryBuilder.append(" AND ");
            }
        }
        if (emailF != null) {
            queryBuilder.append("email LIKE '%" + emailF + "'");
            if (IDF != null) {
                queryBuilder.append(" AND ");
            }
        }
        if (IDF != null) {
            if (IDF.matches("")){
                IDF = ">-1";
            }
            List<String> parsed = Arrays.stream(IDF.split(" ")).collect(Collectors.toList());
            if (parsed.size()<=2){
                queryBuilder.append("id " + IDF);
            }
        }
    }

    String query = queryBuilder.toString();
    List<User> list = userRepository.executeSelect(query, userRepository.getMapper());
%>
<div style="overflow-y: auto; height: 350px;">
    <table class="w3-table-all">
        <caption>Users</caption>
        <tr class="w3-light-green">
            <th>ID</th>
            <th>Address</th>
            <th>Email</th>
            <th>FIO</th>
        </tr>
        <%for(User user : list){%>
        <tr>
            <td><%=user.getID()%></td>
            <td><%=user.getAddress()%></td>
            <td><%=user.getEmail()%></td>
            <td><%=user.getFIO()%></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
