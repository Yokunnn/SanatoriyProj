<%@ page import="com.example.sanatoriyproj.database.repository.ProcedureRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.sanatoriyproj.model.Procedure" %>
<%@ page import="com.example.sanatoriyproj.database.repository.RoomRepository" %>
<%@ page import="com.example.sanatoriyproj.model.Room" %>
<%@ page import="com.example.sanatoriyproj.database.repository.BuildingRepository" %>
<%@ page import="com.example.sanatoriyproj.model.Building" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.12.2022
  Time: 14:38
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
    <a href="/insert" class="w3-display-topleft">Zahodi-ka</a>
    <a href="/delete" class="w3-display-topRight">Udali-ka</a>
    <a href="/update" class="w3-display-topMiddle">Izmeni-ka</a>
    <a href="/search" class="w3-display-bottomMiddle">Naidi-ka</a>
  </div>
  <div class="w3-container w3-center">
    <%
      ProcedureRepository procedureRepository = new ProcedureRepository();
      List<Procedure> procedures = procedureRepository.list();
      RoomRepository roomRepository = new RoomRepository();
      List<Room> rooms = roomRepository.list();
      BuildingRepository buildingRepository = new BuildingRepository();
      List<Building> buildings = buildingRepository.list();
    %>
    <table class="w3-table-all">
      <caption>Procedures</caption>
      <tr class="w3-light-green">
        <th>ID</th>
        <th>Name</th>
        <th>DateTime</th>
      </tr>
      <%for(Procedure procedure : procedures){%>
      <tr>
        <td><%=procedure.getID()%></td>
        <td><%=procedure.getName()%></td>
        <td><%=procedure.getDatetime()%></td>
      </tr>
      <%
      }
      %>
    </table>
    <table class="w3-table-all">
      <caption>Rooms</caption>
      <tr class="w3-light-green">
        <th>ID</th>
        <th>Type</th>
        <th>Condition</th>
        <th>BedNum</th>
        <th>Floor</th>
      </tr>
      <%for(Room room : rooms){%>
      <tr>
        <td><%=room.getID()%></td>
        <td><%=room.getType()%></td>
        <td><%=room.getCondition()%></td>
        <td><%=room.getBedNum()%></td>
        <td><%=room.getFloor()%></td>
      </tr>
      <%
        }
      %>
    </table>
    <table class="w3-table-all">
      <caption>Buildings</caption>
      <tr class="w3-light-green">
        <th>ID</th>
        <th>Type</th>
        <th>FloorNum</th>
      </tr>
        <%for(Building building : buildings){%>
      <tr>
        <td><%=building.getID()%></td>
        <td><%=building.getType()%></td>
        <td><%=building.getFloorNum()%></td>
      </tr>
        <%
      }
      %>
    </table>
  </div>
</body>
</html>
