package com.pioneers.universitysystem.controllers;

import com.pioneers.universitysystem.models.dtos.StudentSignup;
import com.pioneers.universitysystem.models.entities.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("management")
public class ManagementController {



    /*@GetMapping("fetchAllStudents")
    public Map<String, StudentSignup> fetchAllStudents() {
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
    public String updateStudentInformation(@RequestBody final StudentSignup studentSignup) {
        final String email = studentSignup.getEmail();

        if (!students.containsKey(email)) {
            return "Student with email " + email + " not found";
        }
        students.put(email, studentSignup);
        return "Student information updated successfully";
    }*/
}
