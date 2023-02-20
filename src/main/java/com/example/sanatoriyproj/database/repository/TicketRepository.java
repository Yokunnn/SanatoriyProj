package com.example.sanatoriyproj.database.repository;

import com.example.sanatoriyproj.database.Mapper;
import com.example.sanatoriyproj.model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketRepository extends Repository<Ticket>{
    private Mapper<Ticket> mapper = resultSet -> {
        List<Ticket> list = new ArrayList<>();
        while(resultSet.next()){
            Ticket ticket = new Ticket();
            ticket.setID(resultSet.getInt("id"));
            ticket.setType(resultSet.getString("type"));
            ticket.setUserID(resultSet.getInt("userid"));
            ticket.setPrice(resultSet.getString("price"));
            ticket.setDiet(resultSet.getString("diet"));
            ticket.setArrivalDate(resultSet.getDate("arrivaldate"));
            ticket.setDepartureDate(resultSet.getDate("departuredate"));
            list.add(ticket);
        }
        return list;
    };

    public TicketRepository(){
        setTable("ticket");
        setInsertStatement("INSERT INTO ticket (type, userid, price, diet, arrivaldate, departuredate)\n" +
                "   VALUES (?, ?, ?, ?, ?, ?)\n" +
                "   RETURNING id;");
    }

    @Override
    public List<Ticket> list() {
        return executeSelect("SELECT * FROM " + getTable(), mapper);
    }

    @Override
    public Ticket find(int id) {
        final List<Ticket> items = executeSelect(String.format("SELECT * FROM " + getTable() + " WHERE id = %d", id), mapper);
        return items.size() > 0 ? items.get(0) : null;
    }

    @Override
    public int executeInsert(Ticket ticket) {
        try (
                Connection connection = connectionHandler.getConnection();
                PreparedStatement statement = connection.prepareStatement(getInsertStatement())
                ){
            statement.setObject(1, ticket.getType());
            statement.setObject(2, ticket.getUserID());
            statement.setObject(3, Integer.parseInt(ticket.getPrice()));
            statement.setObject(4, ticket.getDiet());
            statement.setDate(5, ticket.getArrivalDate());
            statement.setDate(6, ticket.getDepartureDate());
            statement.execute();
            ResultSet inserted = statement.getResultSet();
            int insertedInt = -1;
            if(inserted.next()) {
                insertedInt = inserted.getInt(1);
            }
            return insertedInt;
        } catch (SQLException e){
            System.out.println("Unable to insert data: " + e.getMessage());
        }
        return -1;
    }
}
