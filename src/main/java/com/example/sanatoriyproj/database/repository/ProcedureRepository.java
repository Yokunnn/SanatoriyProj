package com.example.sanatoriyproj.database.repository;

import com.example.sanatoriyproj.database.Mapper;
import com.example.sanatoriyproj.model.Procedure;

import java.util.ArrayList;
import java.util.List;

public class ProcedureRepository extends Repository<Procedure>{

    private Mapper<Procedure> mapper = resultSet -> {
        List<Procedure> list = new ArrayList<>();
        while (resultSet.next()){
            Procedure procedure = new Procedure();
            procedure.setID(resultSet.getInt("id"));
            procedure.setName(resultSet.getString("name"));
            procedure.setDatetime(resultSet.getTimestamp("datetime"));
            list.add(procedure);
        }
        return list;
    };

    @Override
    public List<Procedure> list() {
        return executeSelect("SELECT * FROM procedure", mapper);
    }

    @Override
    public Procedure find(int id) {
        final List<Procedure> items = executeSelect(String.format("SELECT * FROM procedure WHERE id = %d", id), mapper);
        return items.size() > 0 ? items.get(0) : null;
    }

    @Override
    public int executeInsert(Procedure procedure) {
        return -1;
    }

}
