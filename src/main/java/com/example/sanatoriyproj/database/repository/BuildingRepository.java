package com.example.sanatoriyproj.database.repository;

import com.example.sanatoriyproj.database.Mapper;
import com.example.sanatoriyproj.model.Building;
import com.example.sanatoriyproj.model.Room;

import java.util.ArrayList;
import java.util.List;

public class BuildingRepository extends Repository<Building> {

    private Mapper<Building> mapper = resultSet -> {
        List<Building> list = new ArrayList<>();
        while(resultSet.next()){
            Building building = new Building();
            building.setID(resultSet.getInt("id"));
            building.setType(resultSet.getString("type"));
            building.setFloorNum(resultSet.getInt("floornum"));
            list.add(building);
        }
        return list;
    };

    public BuildingRepository(){
        setTable("building");
    }

    @Override
    public List<Building> list() {
        return executeSelect("SELECT * FROM " + getTable(), mapper);
    }

    @Override
    public Building find(int id) {
        final List<Building> items = executeSelect(String.format("SELECT * FROM " + getTable() + " WHERE id = %d", id), mapper);
        return items.size() > 0 ? items.get(0) : null;
    }

    @Override
    public int executeInsert(Building model) {
        return -1;
    }
}
