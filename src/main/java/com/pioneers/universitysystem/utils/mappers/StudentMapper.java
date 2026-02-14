package com.pioneers.universitysystem.utils.mappers;

import com.pioneers.universitysystem.models.dtos.StudentSignup;
import com.pioneers.universitysystem.models.entities.Student;

import static com.pioneers.universitysystem.utils.NameHelper.buildFullName;
import static com.pioneers.universitysystem.utils.UuidHelper.generateRandomId;

public class StudentMapper {
    public static Student toStudent(final StudentSignup studentSignup) {
        final String id = generateRandomId();
        final String fullName = buildFullName(studentSignup.getFirstName(), studentSignup.getLastName());

        final Student student = new Student();
        student.setId(id);
        student.setFullName(fullName);
        student.setEmail(studentSignup.getEmail());
        student.setPassword(studentSignup.getPassword());
        student.setLogin(false);
        return student;
    }

}
