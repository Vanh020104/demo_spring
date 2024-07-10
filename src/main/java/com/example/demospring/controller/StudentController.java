package com.example.demospring.controller;

import com.example.demospring.dao.StudentDAO;
import com.example.demospring.dto.StudentDTO;
import com.example.demospring.entity.ClassRoom;
import com.example.demospring.entity.Student;
import com.example.demospring.service.ClassRoomService;
import com.example.demospring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    private final StudentService studentService;
    private final ClassRoomService classRoomService;
    @Autowired
    public StudentController(StudentService studentService, ClassRoomService classRoomService) {
        this.studentService = studentService;
        this.classRoomService = classRoomService;
    }
  @GetMapping("/add")
public String addStudent(Model model) {
    model.addAttribute("student", new Student());
    List<ClassRoom> classRooms = classRoomService.getAllClassRooms();
    model.addAttribute("classRooms", classRooms);
    return "page/students/add_student"; // This should be the name of your add form view
}

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/api/students";
    }

    @GetMapping()
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudent();
        model.addAttribute("students", students);
        return "page/students/student"; // Update this line
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

   @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Integer id, Model model) {
        Student student = studentService.getStudentById(id);
        List<ClassRoom> classRooms = classRoomService.getAllClassRooms();
        model.addAttribute("student", student);
        model.addAttribute("classRooms", classRooms);
        return "page/students/edit_student";
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable Integer id, @ModelAttribute Student student) {
        student.setId(id);
        studentService.updateStudent(student);
        return "redirect:/api/students";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/api/students";
    }

    @GetMapping("/all-with-procedure")
    public ResponseEntity<List<StudentDTO>> getAllStudentsWithProcedure() {
        List<StudentDTO> students = studentService.getAllStudentsWithProcedure();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
