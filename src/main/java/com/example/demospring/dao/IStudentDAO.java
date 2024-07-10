package com.example.demospring.dao;

import com.example.demospring.dto.StudentDTO;
import com.example.demospring.entity.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStudentDAO {
    void saveStudent(Student student);
    Student getStudentById( Integer id);
    List<Student> getAllStudent();
    void updateStudent(Student student);
    void deleteStudent(Integer id);
    List<Student> findByClassRoomId(Integer classId);
    @Query(value = "call SP_GET_ALL_STUDENTS", nativeQuery = true)
    List<StudentDTO> getAllStudentsWithProcedure();
}
