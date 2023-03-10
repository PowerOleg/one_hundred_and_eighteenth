package com.example.demo.SMS.controllers;

import com.example.demo.SMS.models.Student;
import com.example.demo.SMS.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentsService studentsService;

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", studentsService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @PostMapping("/students")
    public String saveStudent(
            @ModelAttribute Student student
    ) {
        studentsService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")                        //тут Get потому что в html на кнопке навешен метод GET
    public String deleteStudent(@PathVariable Long id) {
        studentsService.deleteStudentById(id);
        return "redirect:/students";
    }


}
