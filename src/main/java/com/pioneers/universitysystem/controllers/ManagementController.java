package com.pioneers.universitysystem.controllers;

import com.pioneers.universitysystem.models.dtos.response.StudentInfo;
import com.pioneers.universitysystem.models.entities.Student;
import com.pioneers.universitysystem.utils.mappers.StudentMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pioneers.universitysystem.repositories.Database.students;

@RestController
@RequestMapping("management")
public class ManagementController {

    @GetMapping("fetchAllStudents")
    public List<StudentInfo> fetchAllStudents() {
        return students.values()
                .stream()
                .map(StudentMapper::toStudentInfo)
                .toList();
    }

    @DeleteMapping("deleteAllStudents")
    public String deleteAllStudents() {
        students.clear();
        return "All students deleted successfully";
    }

    @DeleteMapping("deleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam String id) {
        if (!students.containsKey(id)) {
            return ResponseEntity.status(404).body("Student with id " + id + " not found");
        }

        students.remove(id);
        return ResponseEntity.ok("Student with id " + id + " deleted successfully");
    }

    @GetMapping("firstRegisteredStudent")
    public String findFirstRegisteredStudent() {
        return students.values()
                .stream()
                .findFirst()
                .map(student -> student.getFullName() + "whose id is " + student.getId())
                .orElse("No students registered");
    }

    @PutMapping("updateStudentInformation/{id}")
    public String updateStudentInformation(@PathVariable String id , @RequestBody Student updatedStudent) {
        if(!students.containsKey(id)) {
            return "Student with id " + id + " not found";
        }
        students.put(id, updatedStudent);
        return "Student information updated successfully";
    }
}
