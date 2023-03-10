package com.example.demo.SMS.services;

import com.example.demo.SMS.models.Student;

import java.util.List;

public interface StudentsService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Boolean deleteStudentById(Long id);
    Student getStudentById(Long id);
}
