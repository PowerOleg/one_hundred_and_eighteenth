package com.example.demo.SMS.services.impl;

import com.example.demo.SMS.models.Student;
import com.example.demo.SMS.services.StudentsService;
import com.example.demo.SMS.utils.DB.StudentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//работает с базой данных "StudentsRepository"
@Service
public class StudentServiceImpl implements StudentsService {
    private StudentsRepository studentsRepository;

    public StudentServiceImpl(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }
    @Override
    public List<Student> getAllStudents() {
        return studentsRepository.findAll();
    }
    @Override
    public Student saveStudent(Student student) {
        studentsRepository.save(student);
        return student;
    }

    @Override
    public Boolean deleteStudentById(Long id) {
        return studentsRepository.deleteById(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentsRepository.findById(id).get();
    }
}
