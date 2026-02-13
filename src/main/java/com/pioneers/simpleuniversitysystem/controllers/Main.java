package com.pioneers.simpleuniversitysystem.controllers;

import com.pioneers.simpleuniversitysystem.models.dtos.StudentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
@RequestMapping
public class Main {

    final LinkedHashMap<String, StudentRequest> students = new LinkedHashMap<>();

    @PostMapping("register")
    public String register(@RequestBody final StudentRequest studentRequest) {
        students.put(studentRequest.getEmail(), studentRequest);
        return "Student registered successfully";
    }

    @PostMapping("login")
    public String login(@RequestBody final StudentRequest studentRequest) {
        final String email = studentRequest.getEmail();
        final String password = studentRequest.getPassword();
        if (!students.containsKey(email) || !students.get(email).checkPassword(students, email, password)) {
            return "Invalid email or password";
        } else {
            return "Login successful";
        }
    }

    @GetMapping("fetchAllStudents")
    public LinkedHashMap<String, StudentRequest> fetchAllStudents() {
        return students;
    }

    @DeleteMapping("DeleteAllStudents")
    public String deleteAllStudents() {
        students.clear();
        return "All students deleted successfully";
    }

    @DeleteMapping("DeleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam String email) {
        if (students.containsKey(email)) {
            students.remove(email);
            return ResponseEntity.ok("Student with email " + email + " deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Student with email " + email + " not found");
        }
    }

    @GetMapping("FirstRegisteredStudent")
    public String findFirstRegisteredStudent() {
        return students.values().stream().findFirst().map(student -> student.getFirstName()
                        + " " + student.getLastName() + "whose email is " + student.getEmail())
                .orElse("No students registered");
    }

    @PutMapping("UpdateStudentInformation")
    public String updateStudentInformation(@RequestBody final StudentRequest studentRequest) {
        final String email = studentRequest.getEmail();

        if (!students.containsKey(email)) {
            return "Student with email " + email + " not found";
        }
        students.put(email, studentRequest);
        return "Student information updated successfully";
    }
}


