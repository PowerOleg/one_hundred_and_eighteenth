package com.example.demo.SMS.utils.DB;

import com.example.demo.SMS.models.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
public class StudentsRepository {
    private static List<Student> students;
    private static long id = 0;

    public StudentsRepository() {
        if (students == null) {
            students = new ArrayList<>();
            students.add(new Student(Long.valueOf(++id), "Mark", "Pollo", "markpollo@gmail.com"));
        }
    }

    public  List<Student> findAll() {
        return students;
    }

    public Optional<Student> findById (long id) {
        return students.stream().filter(n -> n.getId() == id).findFirst();
    }

    public Boolean deleteById(long id) {
        for (Iterator<Student> i = students.iterator(); i.hasNext(); ) {
            if (i.next().getId() == id) {
                i.remove();
                return true;
            }
        }
        return false;
    }

    public void save(Student student) {
        student.setId(Long.valueOf(++id));
        students.add(student);
    }

}
