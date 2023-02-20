package com.example.sanatoriyproj.database.repository;

import com.example.sanatoriyproj.database.Mapper;
import com.example.sanatoriyproj.model.Staff;

import java.util.List;

public class StaffRepository extends Repository<Staff>{
    @Override
    public List<Staff> list() {
        return null;
    }

    @Override
    public Staff find(int id) {
        return null;
    }

    @Override
    public int executeInsert(Staff model) {
        return 0;
    }
}
