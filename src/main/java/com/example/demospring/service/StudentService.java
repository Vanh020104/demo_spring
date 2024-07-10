package com.example.demospring.service;

import com.example.demospring.dao.IStudentDAO;
import com.example.demospring.dto.StudentDTO;
import com.example.demospring.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final IStudentDAO studentDAO;

    @Autowired
    public StudentService(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }
    public Student getStudentById(Integer id) {
        return studentDAO.getStudentById(id);
    }
    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }
    public void deleteStudent(Integer id) {
        studentDAO.deleteStudent(id);
    }

    public List<Student> getAllStudent() {
      return studentDAO.getAllStudent();
    }
    public List<StudentDTO> getAllStudentsWithProcedure() {
    return studentDAO.getAllStudentsWithProcedure();
}



}
