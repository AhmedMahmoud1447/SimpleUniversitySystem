package com.pioneers.universitysystem.repositories;

import com.pioneers.universitysystem.models.entities.Student;

import java.util.Map;
import java.util.Optional;

public class StudentSearcher {
    public static Optional<Student> findStudentByEmail(final Map<String, Student> students, final String email) {
        return students.values().stream()
                .filter(student -> student.getEmail().equals(email))
                .findFirst();
    }
}
