package com.example.demospring.dao;

import com.example.demospring.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO implements IStudentDAO{
    private EntityManager entityManager;
    @Autowired
    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void saveStudent(Student student) {
        this.entityManager.persist(student);
    }

    @Override
    @Transactional
    public Student getStudentById(Integer id) {
        return this.entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public List<Student> getAllStudent() {
        return this.entityManager.createQuery("from Student").getResultList();
    }
// phuong thức createQuery trả về một đối tượng Query, chúng ta gọi phương thức getResultList() để lấy danh sách kết quả.
    @Override
    @Transactional
    public void updateStudent(Student student) {
        this.entityManager.merge(student);
    }
// phương thưc merge() sẽ cập nhật đối tượng student vào cơ sở dữ liệu.
    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        Student student = getStudentById(id);
        if (student != null){
            this.entityManager.remove(student);
        }
    }
}
