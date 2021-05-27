package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final static List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Ivan Vasilev"),
            new Student(2, "Ginka Tosheva"),
            new Student(3, "Mincho Gogov")
    );

    @GetMapping("{studentId}")
    public Student getStudent(@PathVariable() Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exists!"));
    }
}
