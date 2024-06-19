package com.example.demospring.service;

import com.example.demospring.dao.IClassRoomDAO;
import com.example.demospring.entity.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService {

    private final IClassRoomDAO classRoomDAO;

    @Autowired
    public ClassRoomService(IClassRoomDAO classRoomDAO) {
        this.classRoomDAO = classRoomDAO;
    }

    public List<ClassRoom> getAllClassRooms() {
        return classRoomDAO.getAllClassRoom();
    }

    public ClassRoom getClassRoomById(Integer id) {
        return classRoomDAO.getClassRoomById(id);
    }

    public void saveOrUpdateClassRoom(ClassRoom classRoom) {
        if (classRoom.getId_class() == null) {
            classRoomDAO.saveClassRoom(classRoom);
        } else {
            classRoomDAO.updateClassRoom(classRoom);
        }
    }

    public void deleteClassRoom(Integer id) {
        classRoomDAO.deleteClassRoom(id);
    }
}