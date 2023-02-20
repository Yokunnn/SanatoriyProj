package com.example.sanatoriyproj.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@FunctionalInterface
public interface Mapper<T> {

    List<T> map(ResultSet resultSet) throws SQLException;
}
