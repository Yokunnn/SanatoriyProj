package com.example.sanatoriyproj.database.repository;

import com.example.sanatoriyproj.database.ConnectionHandler;
import com.example.sanatoriyproj.database.Mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

public abstract class Repository<T> {

    protected ConnectionHandler connectionHandler;
    protected String table;
    protected String insertStatement;

    public Repository(){
        connectionHandler = new ConnectionHandler();
    }

    public abstract List<T> list();

    public abstract T find(int id);

    protected String getTable() {
        return table;
    }

    protected void setTable(String table) {
        this.table = table;
    }

    protected String getInsertStatement() {
        return insertStatement;
    }

    protected void setInsertStatement(String insertStatement) {
        this.insertStatement = insertStatement;
    }

    public <T> List<T> executeSelect(String query, Mapper<T> mapper) {
        try (
                Connection connection = ConnectionHandler.getConnection();
                Statement statement = connection.createStatement()
                ) {
            ResultSet resultSet = statement.executeQuery(query);
            return mapper.map(resultSet);
        } catch (SQLException e) {
            System.out.println("Unable to get data: " + e.getMessage());
        }
        return Collections.emptyList();
    }

    public int executeUpdate(String query){
        try (
                Connection connection = connectionHandler.getConnection();
                Statement statement = connection.createStatement()
                ) {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Unable to update data: " + e.getMessage());
        }
        return 0;
    }


    public abstract int executeInsert(T model);

    public boolean executeDeleteByID(int modelID){
        try (
                Connection connection = connectionHandler.getConnection();
                Statement statement = connection.createStatement()
        ){
            statement.execute(String.format("DELETE FROM " + getTable() + " WHERE id = %d", modelID));
            return true;
        } catch (SQLException e){
            System.out.println("Unable to delete data: " + e.getMessage());
        }
        return false;
    }
}
