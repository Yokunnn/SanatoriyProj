package com.example.sanatoriyproj.database.repository;

import com.example.sanatoriyproj.database.Mapper;
import com.example.sanatoriyproj.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends Repository<User> {

    private Mapper<User> mapper = resultSet -> {
        List<User> list = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setID(resultSet.getInt("id"));
            user.setFIO(resultSet.getString("fio"));
            user.setEmail(resultSet.getString("email"));
            user.setAddress(resultSet.getString("address"));
            list.add(user);
        }
        return list;
    };

    public Mapper<User> getMapper() {
        return mapper;
    }

    public UserRepository(){
        setTable("users");
        setInsertStatement("INSERT INTO users (fio, email, address)\n" +
                "   VALUES (?, ?, ?)\n" +
                "   RETURNING id;");
    }

    @Override
    public List<User> list() {
        return executeSelect("SELECT * FROM " + getTable(), mapper);
    }

    @Override
    public User find(int id) {
        final List<User> items = executeSelect(String.format("SELECT * FROM " + getTable() + " WHERE id = %d", id), mapper);
        return items.size() > 0 ? items.get(0) : null;
    }

    @Override
    public int executeInsert(User user) {
        try (
                Connection connection = connectionHandler.getConnection();
                PreparedStatement statement = connection.prepareStatement(getInsertStatement())
        ){
            statement.setObject(1, user.getFIO());
            statement.setObject(2, user.getEmail());
            statement.setObject(3, user.getAddress());
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
