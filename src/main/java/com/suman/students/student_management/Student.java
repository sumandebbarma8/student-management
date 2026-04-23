package com.suman.students.student_management;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;

    public Student() {}

    public Student(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}