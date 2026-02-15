package com.pioneers.universitysystem.controllers;

import com.pioneers.universitysystem.models.entities.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pioneers.universitysystem.repositories.Database.students;

@RestController
@RequestMapping("management")
public class ManagementController {



    @GetMapping("fetchAllStudents")
    public List<String> fetchAllStudents() {
        return students.values().stream().map(student -> student.getFullName() +" whose email is " +
                student.getEmail()).toList();
    }

    @DeleteMapping("DeleteAllStudents")
    public String deleteAllStudents() {
        students.clear();
        return "All students deleted successfully";
    }

    @DeleteMapping("DeleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam String id) {
        if (students.containsKey(id)) {
            students.remove(id);
            return ResponseEntity.ok("Student with id " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Student with id " + id + " not found");
        }
    }

    @GetMapping("FirstRegisteredStudent")
    public String findFirstRegisteredStudent() {
        return students.values().stream().findFirst().map(student ->
                        student.getFullName() + "whose id is " + student.getId())
                         .orElse("No students registered");
    }

    @PutMapping("UpdateStudentInformation/{id}")
    public String updateStudentInformation(@PathVariable String id , @RequestBody Student updatedStudent) {
        if(!students.containsKey(id)) {
            return "Student with id " + id + " not found";
        }
        students.put(id, updatedStudent);
        return "Student information updated successfully";
    }
}
