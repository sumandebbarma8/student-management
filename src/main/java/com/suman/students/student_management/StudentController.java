package com.suman.students.student_management;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // ✅ GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAll();
    }

    // ✅ GET student by ID (numbers only → avoids conflict with /adults)
    @GetMapping("/{id:\\d+}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getById(id);
    }

    // ✅ POST (add student)
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.add(student);
    }

    // ✅ PUT (update student)
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return service.update(id, student);
    }

    // ✅ DELETE student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.delete(id);
    }

    // ✅ GET adults (age >= 18)
    @GetMapping("/adults")
    public List<Student> getAdults() {
        return service.getAdults();
    }
}