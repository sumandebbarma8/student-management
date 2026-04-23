package com.suman.students.student_management;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // ✅ GET ALL
    public List<Student> getAll() {
        return repository.findAll();
    }

    // ✅ GET BY ID
    public Student getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // ✅ ADD STUDENT
    public Student add(Student student) {
        return repository.save(student);
    }

    // ✅ UPDATE STUDENT
    public Student update(Long id, Student updated) {
        Student existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(updated.getName());
            existing.setAge(updated.getAge());
            return repository.save(existing);
        }

        return null;
    }

    // ✅ DELETE STUDENT
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // ✅ FILTER ADULTS (FIXED — NO 500 ERROR)
    public List<Student> getAdults() {
        List<Student> students = repository.findAll();

        if (students == null || students.isEmpty()) {
            return new ArrayList<>();
        }

        return students.stream()
                .filter(s -> s.getAge() >= 18)
                .collect(Collectors.toList());
    }
}