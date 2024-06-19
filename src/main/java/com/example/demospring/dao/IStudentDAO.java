package com.example.demospring.dao;

import com.example.demospring.entity.Student;

import java.util.List;

public interface IStudentDAO {
    void saveStudent(Student student);
    Student getStudentById( Integer id);
    List<Student> getAllStudent();
    void updateStudent(Student student);
    void deleteStudent(Integer id);
}
