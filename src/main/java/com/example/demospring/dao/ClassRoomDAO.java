package com.example.demospring.dao;

import com.example.demospring.entity.ClassRoom;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassRoomDAO implements IClassRoomDAO {
    private EntityManager entityManager;
@Autowired
    public ClassRoomDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
@Override
@Transactional
    public void saveClassRoom(ClassRoom classRoom) {

        this.entityManager.persist(classRoom);

    }
    @Override
    public ClassRoom getClassRoomById(Integer id) {
        return this.entityManager.find(ClassRoom.class, id);
    }

    @Override
    public List<ClassRoom> getAllClassRoom() {
        return this.entityManager.createQuery("from ClassRoom").getResultList();
    }
    @Override
    @Transactional
    public void updateClassRoom(ClassRoom classRoom) {
        this.entityManager.merge(classRoom);
    }

    @Override
    @Transactional
    public void deleteClassRoom(Integer id) {
        ClassRoom classRoom = getClassRoomById(id);
        if (classRoom != null) {
            this.entityManager.remove(classRoom);
        }
    }

}
