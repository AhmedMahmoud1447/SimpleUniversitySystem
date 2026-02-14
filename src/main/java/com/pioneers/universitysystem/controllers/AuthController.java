package com.pioneers.universitysystem.controllers;

import com.pioneers.universitysystem.models.dtos.StudentLogin;
import com.pioneers.universitysystem.models.dtos.StudentSignup;
import com.pioneers.universitysystem.models.entities.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.pioneers.universitysystem.repositories.Database.students;
import static com.pioneers.universitysystem.repositories.StudentSearcher.findStudentByEmail;
import static com.pioneers.universitysystem.utils.AuthHelper.isPasswordMatched;
import static com.pioneers.universitysystem.utils.mappers.StudentMapper.toStudent;


@RestController
@RequestMapping("auth")
public class AuthController {

    @PostMapping("register")
    public String registerApi(@RequestBody final StudentSignup studentSignup) {

        final Optional<Student> optionalStudent = findStudentByEmail(students, studentSignup.getEmail());

        if (optionalStudent.isPresent()) {
            return "Student already Registered!!";
        }

        final Student student = toStudent(studentSignup);

        students.put(student.getId(), student);
        return "Student registered successfully";
    }

    @PostMapping("login")
    public String loginApi(@RequestBody final StudentLogin studentLogin) {

        final Optional<Student> optionalStudent = findStudentByEmail(students, studentLogin.getEmail());
        if (optionalStudent.isEmpty()) {
            return "Student is not registered";
        }

        final Student foundStudent = optionalStudent.get();

        final boolean isPasswordMatched = isPasswordMatched(foundStudent.getPassword(), studentLogin.getPassword());

        if (!isPasswordMatched) {
            return "Invalid Password";
        }

        if (foundStudent.isLogin()) {
            return "Student already logged-in";
        }

        foundStudent.setLogin(true);

        return "Login successful";
    }
}
