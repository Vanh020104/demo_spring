package com.example.demospring.dao;

import com.example.demospring.entity.ClassRoom;

import java.util.List;

public interface IClassRoomDAO {
    void saveClassRoom(ClassRoom classRoom);
    ClassRoom getClassRoomById( Integer id);
    List<ClassRoom> getAllClassRoom();
    void updateClassRoom(ClassRoom classRoom);
    void deleteClassRoom(Integer id);
}

