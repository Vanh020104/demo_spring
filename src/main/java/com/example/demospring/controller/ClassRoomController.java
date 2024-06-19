package com.example.demospring.controller;

import com.example.demospring.entity.ClassRoom;
import com.example.demospring.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/api/classrooms")
public class ClassRoomController {

    private final ClassRoomService classRoomService;

    @Autowired
    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }
    @GetMapping("/add")
    public String addClassRoom(Model model) {
        model.addAttribute("classRoom", new ClassRoom());
        return "page/classrooms/add_classroom"; // This should be the name of your add form view
    }
    @PostMapping("/add")
    public String addClassRoom(@ModelAttribute ClassRoom classRoom) {
        classRoomService.saveOrUpdateClassRoom(classRoom);
        return "redirect:/api/classrooms";
    }
    @GetMapping
    public String getAllClassRooms(Model model) {
        List<ClassRoom> classRooms = classRoomService.getAllClassRooms();
        model.addAttribute("classRooms", classRooms);
        return "page/classrooms/classrooms"; // Update this line
    }
//    @GetMapping
//    public List<ClassRoom> getAllClassRooms() {
//        return classRoomService.getAllClassRooms();
//    }

    @GetMapping("/{id}")
    public ClassRoom getClassRoomById(@PathVariable Integer id) {
        return classRoomService.getClassRoomById(id);
    }

    // ...

    @GetMapping("/edit/{id}")
    public String editClassRoom(@PathVariable Integer id, Model model) {
        ClassRoom classRoom = classRoomService.getClassRoomById(id);
        model.addAttribute("classRoom", classRoom);
        return "page/classrooms/edit_classroom"; // This should be the name of your edit form view
    }

    @PostMapping("/edit/{id}")
    public String updateClassRoom(@PathVariable Integer id, @ModelAttribute ClassRoom classRoom) {
        classRoom.setId_class(id);
        classRoomService.saveOrUpdateClassRoom(classRoom);
        return "redirect:/api/classrooms";
    }

    @GetMapping("/delete/{id}")
    public String deleteClassRoom(@PathVariable Integer id) {
        classRoomService.deleteClassRoom(id);
        return "redirect:/api/classrooms";
    }

// ...
}