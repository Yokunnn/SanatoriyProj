package com.example.sanatoriyproj.database.repository;

import com.example.sanatoriyproj.database.Mapper;
import com.example.sanatoriyproj.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomRepository extends Repository<Room> {

    private Mapper<Room> mapper = resultSet -> {
        List<Room> list = new ArrayList<>();
        while (resultSet.next()) {
            Room room = new Room();
            room.setID(resultSet.getInt("id"));
            room.setBuildingID(resultSet.getInt("buildingid"));
            room.setType(resultSet.getString("type"));
            room.setCondition(resultSet.getString("condition"));
            room.setBedNum(resultSet.getInt("bednum"));
            room.setFloor(resultSet.getInt("floor"));
            list.add(room);
        }
        return list;
    };

    public RoomRepository(){
        setTable("room");
    }

    @Override
    public List<Room> list() {
        return executeSelect("SELECT * FROM " + getTable(), mapper);
    }

    @Override
    public Room find(int id) {
        final List<Room> items = executeSelect(String.format("SELECT * FROM " + getTable() + " WHERE id = %d", id), mapper);
        return items.size() > 0 ? items.get(0) : null;
    }

    @Override
    public int executeInsert(Room room) {
        return -1;
    }

}
