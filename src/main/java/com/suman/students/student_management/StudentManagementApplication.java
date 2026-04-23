package com.suman.students.student_management;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/students")
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }

    private Map<Integer, Student> database = new HashMap<>();

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        database.put(student.getId(), student);
        return "Student stored successfully";
    }

    @GetMapping
    public Collection<Student> getAll() {
        return database.values();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return database.get(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        database.remove(id);
        return "Student deleted";
    }

    // Processing logic (extra for your project title 🔥)
    @GetMapping("/adults")
    public List<Student> getAdults() {
        List<Student> result = new ArrayList<>();
        for (Student s : database.values()) {
            if (s.getAge() >= 18) {
                result.add(s);
            }
        }
        return result;
    }

    static class Student {
        private int id;
        private String name;
        private int age;

        public Student() {}

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
    }
}