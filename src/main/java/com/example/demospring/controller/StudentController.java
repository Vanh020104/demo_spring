package com.example.demospring.controller;

import com.example.demospring.entity.ClassRoom;
import com.example.demospring.entity.Student;
import com.example.demospring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
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
        model.addAttribute("student", student);
        return "page/students/edit_student"; // This should be the name of your edit form view
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
}
